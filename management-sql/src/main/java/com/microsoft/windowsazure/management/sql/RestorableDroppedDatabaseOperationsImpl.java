/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management.sql;

import com.microsoft.windowsazure.AzureHttpStatus;
import com.microsoft.windowsazure.core.ServiceOperations;
import com.microsoft.windowsazure.core.utils.BOMInputStream;
import com.microsoft.windowsazure.core.utils.XmlUtility;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.sql.models.RestorableDroppedDatabase;
import com.microsoft.windowsazure.management.sql.models.RestorableDroppedDatabaseGetResponse;
import com.microsoft.windowsazure.management.sql.models.RestorableDroppedDatabaseListResponse;
import com.microsoft.windowsazure.tracing.CloudTracing;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
* Contains operations for getting dropped Azure SQL Databases that can be
* restored.
*/
public class RestorableDroppedDatabaseOperationsImpl implements ServiceOperations<SqlManagementClientImpl>, RestorableDroppedDatabaseOperations {
    /**
    * Initializes a new instance of the RestorableDroppedDatabaseOperationsImpl
    * class.
    *
    * @param client Reference to the service client.
    */
    RestorableDroppedDatabaseOperationsImpl(SqlManagementClientImpl client) {
        this.client = client;
    }
    
    private SqlManagementClientImpl client;
    
    /**
    * Gets a reference to the
    * microsoft.windowsazure.management.sql.SqlManagementClientImpl.
    * @return The Client value.
    */
    public SqlManagementClientImpl getClient() {
        return this.client;
    }
    
    /**
    * Returns information about a dropped Azure SQL Database that can be
    * restored.
    *
    * @param serverName Required. The name of the Azure SQL Database Server on
    * which the database was hosted.
    * @param entityId Required. The entity ID of the restorable dropped Azure
    * SQL Database to be obtained.
    * @return Contains the response to the Get Restorable Dropped Database
    * request.
    */
    @Override
    public Future<RestorableDroppedDatabaseGetResponse> getAsync(final String serverName, final String entityId) {
        return this.getClient().getExecutorService().submit(new Callable<RestorableDroppedDatabaseGetResponse>() { 
            @Override
            public RestorableDroppedDatabaseGetResponse call() throws Exception {
                return get(serverName, entityId);
            }
         });
    }
    
    /**
    * Returns information about a dropped Azure SQL Database that can be
    * restored.
    *
    * @param serverName Required. The name of the Azure SQL Database Server on
    * which the database was hosted.
    * @param entityId Required. The entity ID of the restorable dropped Azure
    * SQL Database to be obtained.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return Contains the response to the Get Restorable Dropped Database
    * request.
    */
    @Override
    public RestorableDroppedDatabaseGetResponse get(String serverName, String entityId) throws MalformedURLException, ProtocolException, ServiceException, IOException, ParserConfigurationException, SAXException {
        // Validate
        if (serverName == null) {
            throw new NullPointerException("serverName");
        }
        if (entityId == null) {
            throw new NullPointerException("entityId");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("serverName", serverName);
            tracingParameters.put("entityId", entityId);
            CloudTracing.enter(invocationId, this, "getAsync", tracingParameters);
        }
        
        // Construct URL
        String baseUrl = this.getClient().getBaseUri().toString();
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/services/sqlservers/servers/" + serverName.trim() + "/restorabledroppeddatabases/" + entityId.trim();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        
        // Create HTTP transport objects
        URL serverAddress = new URL(url);
        HttpURLConnection httpRequest = ((HttpURLConnection) serverAddress.openConnection());
        httpRequest.setRequestMethod("Get");
        httpRequest.setDoOutput(true);
        
        // Set Headers
        httpRequest.setRequestProperty("x-ms-version", "2012-03-01");
        
        // Send Request
        try {
            int statusCode = httpRequest.getResponseCode();
            if (statusCode != AzureHttpStatus.OK) {
                ServiceException ex = ServiceException.createFromXml(null, httpRequest.getResponseMessage(), httpRequest.getResponseCode(), httpRequest.getContentType(), httpRequest.getInputStream());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            RestorableDroppedDatabaseGetResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpRequest.getInputStream();
            result = new RestorableDroppedDatabaseGetResponse();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(new BOMInputStream(responseContent));
            
            Element serviceResourceElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://schemas.microsoft.com/windowsazure", "ServiceResource");
            if (serviceResourceElement != null) {
                RestorableDroppedDatabase serviceResourceInstance = new RestorableDroppedDatabase();
                result.setDatabase(serviceResourceInstance);
                
                Element entityIdElement = XmlUtility.getElementByTagNameNS(serviceResourceElement, "http://schemas.microsoft.com/windowsazure", "EntityId");
                if (entityIdElement != null) {
                    String entityIdInstance;
                    entityIdInstance = entityIdElement.getTextContent();
                    serviceResourceInstance.setEntityId(entityIdInstance);
                }
                
                Element serverNameElement = XmlUtility.getElementByTagNameNS(serviceResourceElement, "http://schemas.microsoft.com/windowsazure", "ServerName");
                if (serverNameElement != null) {
                    String serverNameInstance;
                    serverNameInstance = serverNameElement.getTextContent();
                    serviceResourceInstance.setServerName(serverNameInstance);
                }
                
                Element editionElement = XmlUtility.getElementByTagNameNS(serviceResourceElement, "http://schemas.microsoft.com/windowsazure", "Edition");
                if (editionElement != null) {
                    String editionInstance;
                    editionInstance = editionElement.getTextContent();
                    serviceResourceInstance.setEdition(editionInstance);
                }
                
                Element maxSizeBytesElement = XmlUtility.getElementByTagNameNS(serviceResourceElement, "http://schemas.microsoft.com/windowsazure", "MaxSizeBytes");
                if (maxSizeBytesElement != null) {
                    long maxSizeBytesInstance;
                    maxSizeBytesInstance = DatatypeConverter.parseLong(maxSizeBytesElement.getTextContent());
                    serviceResourceInstance.setMaximumDatabaseSizeInBytes(maxSizeBytesInstance);
                }
                
                Element creationDateElement = XmlUtility.getElementByTagNameNS(serviceResourceElement, "http://schemas.microsoft.com/windowsazure", "CreationDate");
                if (creationDateElement != null) {
                    Calendar creationDateInstance;
                    creationDateInstance = DatatypeConverter.parseDateTime(creationDateElement.getTextContent());
                    serviceResourceInstance.setCreationDate(creationDateInstance);
                }
                
                Element deletionDateElement = XmlUtility.getElementByTagNameNS(serviceResourceElement, "http://schemas.microsoft.com/windowsazure", "DeletionDate");
                if (deletionDateElement != null) {
                    Calendar deletionDateInstance;
                    deletionDateInstance = DatatypeConverter.parseDateTime(deletionDateElement.getTextContent());
                    serviceResourceInstance.setDeletionDate(deletionDateInstance);
                }
                
                Element recoveryPeriodStartDateElement = XmlUtility.getElementByTagNameNS(serviceResourceElement, "http://schemas.microsoft.com/windowsazure", "RecoveryPeriodStartDate");
                if (recoveryPeriodStartDateElement != null && (recoveryPeriodStartDateElement.getTextContent() == null || recoveryPeriodStartDateElement.getTextContent().isEmpty() == true) == false) {
                    Calendar recoveryPeriodStartDateInstance;
                    recoveryPeriodStartDateInstance = DatatypeConverter.parseDateTime(recoveryPeriodStartDateElement.getTextContent());
                    serviceResourceInstance.setRecoveryPeriodStartDate(recoveryPeriodStartDateInstance);
                }
                
                Element nameElement = XmlUtility.getElementByTagNameNS(serviceResourceElement, "http://schemas.microsoft.com/windowsazure", "Name");
                if (nameElement != null) {
                    String nameInstance;
                    nameInstance = nameElement.getTextContent();
                    serviceResourceInstance.setName(nameInstance);
                }
                
                Element typeElement = XmlUtility.getElementByTagNameNS(serviceResourceElement, "http://schemas.microsoft.com/windowsazure", "Type");
                if (typeElement != null) {
                    String typeInstance;
                    typeInstance = typeElement.getTextContent();
                    serviceResourceInstance.setType(typeInstance);
                }
                
                Element stateElement = XmlUtility.getElementByTagNameNS(serviceResourceElement, "http://schemas.microsoft.com/windowsazure", "State");
                if (stateElement != null) {
                    String stateInstance;
                    stateInstance = stateElement.getTextContent();
                    serviceResourceInstance.setState(stateInstance);
                }
            }
            
            result.setStatusCode(statusCode);
            result.setRequestId(httpRequest.getHeaderField("x-ms-request-id"));
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpRequest != null) {
                httpRequest.disconnect();
            }
        }
    }
    
    /**
    * Returns a collection of databases that has been dropped but can still be
    * restored from a specified server.
    *
    * @param serverName Required. The name of the Azure SQL Database Server to
    * query for dropped databases that can still be restored.
    * @return Contains the response to the List Restorable Dropped Databases
    * request.
    */
    @Override
    public Future<RestorableDroppedDatabaseListResponse> listAsync(final String serverName) {
        return this.getClient().getExecutorService().submit(new Callable<RestorableDroppedDatabaseListResponse>() { 
            @Override
            public RestorableDroppedDatabaseListResponse call() throws Exception {
                return list(serverName);
            }
         });
    }
    
    /**
    * Returns a collection of databases that has been dropped but can still be
    * restored from a specified server.
    *
    * @param serverName Required. The name of the Azure SQL Database Server to
    * query for dropped databases that can still be restored.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return Contains the response to the List Restorable Dropped Databases
    * request.
    */
    @Override
    public RestorableDroppedDatabaseListResponse list(String serverName) throws MalformedURLException, ProtocolException, ServiceException, IOException, ParserConfigurationException, SAXException {
        // Validate
        if (serverName == null) {
            throw new NullPointerException("serverName");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("serverName", serverName);
            CloudTracing.enter(invocationId, this, "listAsync", tracingParameters);
        }
        
        // Construct URL
        String baseUrl = this.getClient().getBaseUri().toString();
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/services/sqlservers/servers/" + serverName.trim() + "/restorabledroppeddatabases" + "?" + "contentview=generic";
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        
        // Create HTTP transport objects
        URL serverAddress = new URL(url);
        HttpURLConnection httpRequest = ((HttpURLConnection) serverAddress.openConnection());
        httpRequest.setRequestMethod("Get");
        httpRequest.setDoOutput(true);
        
        // Set Headers
        httpRequest.setRequestProperty("x-ms-version", "2012-03-01");
        
        // Send Request
        try {
            int statusCode = httpRequest.getResponseCode();
            if (statusCode != AzureHttpStatus.OK) {
                ServiceException ex = ServiceException.createFromXml(null, httpRequest.getResponseMessage(), httpRequest.getResponseCode(), httpRequest.getContentType(), httpRequest.getInputStream());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            RestorableDroppedDatabaseListResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpRequest.getInputStream();
            result = new RestorableDroppedDatabaseListResponse();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(new BOMInputStream(responseContent));
            
            Element serviceResourcesSequenceElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://schemas.microsoft.com/windowsazure", "ServiceResources");
            if (serviceResourcesSequenceElement != null) {
                for (int i1 = 0; i1 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(serviceResourcesSequenceElement, "http://schemas.microsoft.com/windowsazure", "ServiceResource").size(); i1 = i1 + 1) {
                    org.w3c.dom.Element serviceResourcesElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(serviceResourcesSequenceElement, "http://schemas.microsoft.com/windowsazure", "ServiceResource").get(i1));
                    RestorableDroppedDatabase serviceResourceInstance = new RestorableDroppedDatabase();
                    result.getDatabases().add(serviceResourceInstance);
                    
                    Element entityIdElement = XmlUtility.getElementByTagNameNS(serviceResourcesElement, "http://schemas.microsoft.com/windowsazure", "EntityId");
                    if (entityIdElement != null) {
                        String entityIdInstance;
                        entityIdInstance = entityIdElement.getTextContent();
                        serviceResourceInstance.setEntityId(entityIdInstance);
                    }
                    
                    Element serverNameElement = XmlUtility.getElementByTagNameNS(serviceResourcesElement, "http://schemas.microsoft.com/windowsazure", "ServerName");
                    if (serverNameElement != null) {
                        String serverNameInstance;
                        serverNameInstance = serverNameElement.getTextContent();
                        serviceResourceInstance.setServerName(serverNameInstance);
                    }
                    
                    Element editionElement = XmlUtility.getElementByTagNameNS(serviceResourcesElement, "http://schemas.microsoft.com/windowsazure", "Edition");
                    if (editionElement != null) {
                        String editionInstance;
                        editionInstance = editionElement.getTextContent();
                        serviceResourceInstance.setEdition(editionInstance);
                    }
                    
                    Element maxSizeBytesElement = XmlUtility.getElementByTagNameNS(serviceResourcesElement, "http://schemas.microsoft.com/windowsazure", "MaxSizeBytes");
                    if (maxSizeBytesElement != null) {
                        long maxSizeBytesInstance;
                        maxSizeBytesInstance = DatatypeConverter.parseLong(maxSizeBytesElement.getTextContent());
                        serviceResourceInstance.setMaximumDatabaseSizeInBytes(maxSizeBytesInstance);
                    }
                    
                    Element creationDateElement = XmlUtility.getElementByTagNameNS(serviceResourcesElement, "http://schemas.microsoft.com/windowsazure", "CreationDate");
                    if (creationDateElement != null) {
                        Calendar creationDateInstance;
                        creationDateInstance = DatatypeConverter.parseDateTime(creationDateElement.getTextContent());
                        serviceResourceInstance.setCreationDate(creationDateInstance);
                    }
                    
                    Element deletionDateElement = XmlUtility.getElementByTagNameNS(serviceResourcesElement, "http://schemas.microsoft.com/windowsazure", "DeletionDate");
                    if (deletionDateElement != null) {
                        Calendar deletionDateInstance;
                        deletionDateInstance = DatatypeConverter.parseDateTime(deletionDateElement.getTextContent());
                        serviceResourceInstance.setDeletionDate(deletionDateInstance);
                    }
                    
                    Element recoveryPeriodStartDateElement = XmlUtility.getElementByTagNameNS(serviceResourcesElement, "http://schemas.microsoft.com/windowsazure", "RecoveryPeriodStartDate");
                    if (recoveryPeriodStartDateElement != null && (recoveryPeriodStartDateElement.getTextContent() == null || recoveryPeriodStartDateElement.getTextContent().isEmpty() == true) == false) {
                        Calendar recoveryPeriodStartDateInstance;
                        recoveryPeriodStartDateInstance = DatatypeConverter.parseDateTime(recoveryPeriodStartDateElement.getTextContent());
                        serviceResourceInstance.setRecoveryPeriodStartDate(recoveryPeriodStartDateInstance);
                    }
                    
                    Element nameElement = XmlUtility.getElementByTagNameNS(serviceResourcesElement, "http://schemas.microsoft.com/windowsazure", "Name");
                    if (nameElement != null) {
                        String nameInstance;
                        nameInstance = nameElement.getTextContent();
                        serviceResourceInstance.setName(nameInstance);
                    }
                    
                    Element typeElement = XmlUtility.getElementByTagNameNS(serviceResourcesElement, "http://schemas.microsoft.com/windowsazure", "Type");
                    if (typeElement != null) {
                        String typeInstance;
                        typeInstance = typeElement.getTextContent();
                        serviceResourceInstance.setType(typeInstance);
                    }
                    
                    Element stateElement = XmlUtility.getElementByTagNameNS(serviceResourcesElement, "http://schemas.microsoft.com/windowsazure", "State");
                    if (stateElement != null) {
                        String stateInstance;
                        stateInstance = stateElement.getTextContent();
                        serviceResourceInstance.setState(stateInstance);
                    }
                }
            }
            
            result.setStatusCode(statusCode);
            result.setRequestId(httpRequest.getHeaderField("x-ms-request-id"));
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpRequest != null) {
                httpRequest.disconnect();
            }
        }
    }
}
