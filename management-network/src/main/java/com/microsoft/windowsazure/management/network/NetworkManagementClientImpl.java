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

package com.microsoft.windowsazure.management.network;

import com.microsoft.windowsazure.AzureHttpStatus;
import com.microsoft.windowsazure.Configuration;
import com.microsoft.windowsazure.core.OperationStatus;
import com.microsoft.windowsazure.core.OperationStatusResponse;
import com.microsoft.windowsazure.core.ServiceClient;
import com.microsoft.windowsazure.core.utils.BOMInputStream;
import com.microsoft.windowsazure.core.utils.XmlUtility;
import com.microsoft.windowsazure.credentials.SubscriptionCloudCredentials;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.network.models.LocalNetworkConnectionType;
import com.microsoft.windowsazure.tracing.CloudTracing;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
* The Service Management API includes operations for managing the virtual
* networks for your subscription.  (see
* http://msdn.microsoft.com/en-us/library/windowsazure/jj157182.aspx for more
* information)
*/
public class NetworkManagementClientImpl extends ServiceClient<NetworkManagementClient> implements NetworkManagementClient {
    private URI baseUri;
    
    /**
    * The URI used as the base for all SQL requests.
    * @return The BaseUri value.
    */
    public URI getBaseUri() {
        return this.baseUri;
    }
    
    private SubscriptionCloudCredentials credentials;
    
    /**
    * When you create an Azure subscription, it is uniquely identified by a
    * subscription ID. The subscription ID forms part of the URI for every
    * call that you make to the Service Management API. The Azure Service
    * Management API uses mutual authentication of management certificates
    * over SSL to ensure that a request made to the service is secure. No
    * anonymous requests are allowed.
    * @return The Credentials value.
    */
    public SubscriptionCloudCredentials getCredentials() {
        return this.credentials;
    }
    
    private ClientRootCertificateOperations clientRootCertificates;
    
    /**
    * The Network Management API includes operations for managing the client
    * root certificates for your subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/jj154113.aspx for
    * more information)
    * @return The ClientRootCertificatesOperations value.
    */
    public ClientRootCertificateOperations getClientRootCertificatesOperations() {
        return this.clientRootCertificates;
    }
    
    private GatewayOperations gateways;
    
    /**
    * The Network Management API includes operations for managing the gateways
    * for your subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/jj154113.aspx for
    * more information)
    * @return The GatewaysOperations value.
    */
    public GatewayOperations getGatewaysOperations() {
        return this.gateways;
    }
    
    private NetworkOperations networks;
    
    /**
    * The Network Management API includes operations for managing the virtual
    * networks for your subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/jj157182.aspx for
    * more information)
    * @return The NetworksOperations value.
    */
    public NetworkOperations getNetworksOperations() {
        return this.networks;
    }
    
    private ReservedIPOperations reservedIPs;
    
    /**
    * The Network Management API includes operations for managing the reserved
    * IPs for your subscription.
    * @return The ReservedIPsOperations value.
    */
    public ReservedIPOperations getReservedIPsOperations() {
        return this.reservedIPs;
    }
    
    private StaticIPOperations staticIPs;
    
    /**
    * The Network Management API includes operations for managing the static
    * IPs for your subscription.
    * @return The StaticIPsOperations value.
    */
    public StaticIPOperations getStaticIPsOperations() {
        return this.staticIPs;
    }
    
    /**
    * Initializes a new instance of the NetworkManagementClientImpl class.
    *
    * @param configuration The service configurations.
    * @param executorService The executor service.
    */
    public NetworkManagementClientImpl(Configuration configuration, ExecutorService executorService) {
        super(configuration, executorService);
        this.clientRootCertificates = new ClientRootCertificateOperationsImpl(this);
        this.gateways = new GatewayOperationsImpl(this);
        this.networks = new NetworkOperationsImpl(this);
        this.reservedIPs = new ReservedIPOperationsImpl(this);
        this.staticIPs = new StaticIPOperationsImpl(this);
        
        if (configuration.getProperty("Credentials") == null) {
            throw new NullPointerException("credentials");
        } else {
            this.credentials = ((SubscriptionCloudCredentials) configuration.getProperty("Credentials"));
        }
        if (configuration.getProperty("BaseUri") == null) {
            try {
                this.baseUri = new URI("https://management.core.windows.net");
            }
            catch (URISyntaxException ex) {
            }
        } else {
            this.baseUri = ((URI) configuration.getProperty("BaseUri"));
        }
        this.credentials = ((SubscriptionCloudCredentials) configuration.getProperty("Credentials"));
        this.baseUri = ((URI) configuration.getProperty("BaseUri"));
    }
    
    /**
    * Initializes a new instance of the NetworkManagementClientImpl class.
    *
    * @param configuration The service configurations.
    * @param executorService The executor service.
    */
    protected NetworkManagementClientImpl newInstance(Configuration configuration, ExecutorService executorService) {
        return new NetworkManagementClientImpl(configuration, executorService);
    }
    
    /**
    * The Get Operation Status operation returns the status of the specified
    * operation. After calling an asynchronous operation, you can call Get
    * Operation Status to determine whether the operation has succeeded,
    * failed, or is still in progress.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460783.aspx for
    * more information)
    *
    * @param requestId Required. The request ID for the request you wish to
    * track. The request ID is returned in the x-ms-request-id response header
    * for every request.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request. If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request, and also includes error information regarding the
    * failure.
    */
    @Override
    public Future<OperationStatusResponse> getOperationStatusAsync(final String requestId) {
        return this.getExecutorService().submit(new Callable<OperationStatusResponse>() { 
            @Override
            public OperationStatusResponse call() throws Exception {
                return getOperationStatus(requestId);
            }
         });
    }
    
    /**
    * The Get Operation Status operation returns the status of the specified
    * operation. After calling an asynchronous operation, you can call Get
    * Operation Status to determine whether the operation has succeeded,
    * failed, or is still in progress.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460783.aspx for
    * more information)
    *
    * @param requestId Required. The request ID for the request you wish to
    * track. The request ID is returned in the x-ms-request-id response header
    * for every request.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request. If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request, and also includes error information regarding the
    * failure.
    */
    @Override
    public OperationStatusResponse getOperationStatus(String requestId) throws MalformedURLException, ProtocolException, ServiceException, IOException, ParserConfigurationException, SAXException {
        // Validate
        if (requestId == null) {
            throw new NullPointerException("requestId");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("requestId", requestId);
            CloudTracing.enter(invocationId, this, "getOperationStatusAsync", tracingParameters);
        }
        
        // Construct URL
        String baseUrl = this.getBaseUri().toString();
        String url = "/" + (this.getCredentials().getSubscriptionId() != null ? this.getCredentials().getSubscriptionId().trim() : "") + "/operations/" + requestId.trim();
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
        httpRequest.setRequestProperty("x-ms-version", "2014-05-01");
        
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
            OperationStatusResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpRequest.getInputStream();
            result = new OperationStatusResponse();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(new BOMInputStream(responseContent));
            
            Element operationElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://schemas.microsoft.com/windowsazure", "Operation");
            if (operationElement != null) {
                Element idElement = XmlUtility.getElementByTagNameNS(operationElement, "http://schemas.microsoft.com/windowsazure", "ID");
                if (idElement != null) {
                    String idInstance;
                    idInstance = idElement.getTextContent();
                    result.setId(idInstance);
                }
                
                Element statusElement = XmlUtility.getElementByTagNameNS(operationElement, "http://schemas.microsoft.com/windowsazure", "Status");
                if (statusElement != null) {
                    OperationStatus statusInstance;
                    statusInstance = OperationStatus.valueOf(statusElement.getTextContent());
                    result.setStatus(statusInstance);
                }
                
                Element httpStatusCodeElement = XmlUtility.getElementByTagNameNS(operationElement, "http://schemas.microsoft.com/windowsazure", "HttpStatusCode");
                if (httpStatusCodeElement != null) {
                    Integer httpStatusCodeInstance;
                    httpStatusCodeInstance = Integer.valueOf(httpStatusCodeElement.getTextContent());
                    result.setHttpStatusCode(httpStatusCodeInstance);
                }
                
                Element errorElement = XmlUtility.getElementByTagNameNS(operationElement, "http://schemas.microsoft.com/windowsazure", "Error");
                if (errorElement != null) {
                    OperationStatusResponse.ErrorDetails errorInstance = new OperationStatusResponse.ErrorDetails();
                    result.setError(errorInstance);
                    
                    Element codeElement = XmlUtility.getElementByTagNameNS(errorElement, "http://schemas.microsoft.com/windowsazure", "Code");
                    if (codeElement != null) {
                        String codeInstance;
                        codeInstance = codeElement.getTextContent();
                        errorInstance.setCode(codeInstance);
                    }
                    
                    Element messageElement = XmlUtility.getElementByTagNameNS(errorElement, "http://schemas.microsoft.com/windowsazure", "Message");
                    if (messageElement != null) {
                        String messageInstance;
                        messageInstance = messageElement.getTextContent();
                        errorInstance.setMessage(messageInstance);
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
    
    /**
    * Parse enum values for type LocalNetworkConnectionType.
    *
    * @param value The value to parse.
    * @return The enum value.
    */
     static LocalNetworkConnectionType parseLocalNetworkConnectionType(String value) {
        if ("IPsec".equalsIgnoreCase(value)) {
            return LocalNetworkConnectionType.IPSecurity;
        }
        if ("Dedicated".equalsIgnoreCase(value)) {
            return LocalNetworkConnectionType.Dedicated;
        }
        throw new IllegalArgumentException("value");
    }
    
    /**
    * Convert an enum of type LocalNetworkConnectionType to a string.
    *
    * @param value The value to convert to a string.
    * @return The enum value as a string.
    */
     static String localNetworkConnectionTypeToString(LocalNetworkConnectionType value) {
        if (value == LocalNetworkConnectionType.IPSecurity) {
            return "IPsec";
        }
        if (value == LocalNetworkConnectionType.Dedicated) {
            return "Dedicated";
        }
        throw new IllegalArgumentException("value");
    }
}
