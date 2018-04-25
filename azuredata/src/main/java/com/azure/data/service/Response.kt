package com.azure.data.service

import com.azure.data.AzureData
import com.azure.data.model.*
import okhttp3.Request
import java.lang.reflect.Type

/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License.
 */

typealias DataResponse = Response<String>
typealias ListResponse<T> = Response<ResourceList<T>>

open class Response<T>(
        // The request sent to the server.
        val request: Request? = null,
        // The server's response to the request.
        val response: okhttp3.Response? = null,
        //  The json data returned by the server (if applicable)
        val jsonData: String? = null,
        // The result of response deserialization.
        val result: Result<T>,
        // The resourceLocation, filled out when there could be more results
        val resourceLocation: ResourceLocation? = null,
        // The class of the Resource
        val resourceType: Type? = null
) {
    val metadata : ResponseMetadata by lazy {
        ResponseMetadata(response)
    }

    constructor(
            // the error
            error: DataError,
            // The URL request sent to the server.
            request: Request? = null,
            // The server's response to the URL request.
            response: okhttp3.Response? = null,
            // The json data returned by the server.
            jsonData: String? = null) : this(request, response, jsonData, Result<T>(error))

    constructor(result: T) : this(result = Result(result))

    /**
     * Returns the associated error value if the result if it is a failure, null otherwise.
     */
    val error: DataError? get() = result.error

    /**
     * Returns `true` if the result is a success, `false` otherwise.
     */
    val isSuccessful get() = error == null

    /**
     * Returns `true` if the result is an error, `false` otherwise.
     */
    val isErrored get() = error != null

    /**
     * Returns the associated value of the result if it is a success, null otherwise.
     */
    val resource: T? = result.resource

    /**
     * Returns `true` if there are more paged results available
     */
    val hasMoreResults : Boolean get() {
        return !metadata.continuation.isNullOrEmpty()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Resource> next(callback: (ListResponse<T>) -> Unit) =
            AzureData.documentClient.next(
                    this as ListResponse<T>,
                    resourceType,
                    callback
            )
}