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

import com.microsoft.windowsazure.Configuration;
import com.microsoft.windowsazure.core.ServiceClient;
import com.microsoft.windowsazure.credentials.SubscriptionCloudCredentials;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;

/**
* This is the main client class for interacting with the Azure SQL Database
* REST APIs.
*/
public class SqlManagementClientImpl extends ServiceClient<SqlManagementClient> implements SqlManagementClient {
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
    * call that you make to the Service Management API.  The Azure Service
    * ManagementAPIs use mutual authentication of management certificates over
    * SSL to ensure that a request made to the service is secure.  No
    * anonymous requests are allowed.
    * @return The Credentials value.
    */
    public SubscriptionCloudCredentials getCredentials() {
        return this.credentials;
    }
    
    private DacOperations dac;
    
    /**
    * Includes operations for importing and exporting Azure SQL Databases into
    * and out of Azure blob storage.
    * @return The DacOperations value.
    */
    public DacOperations getDacOperations() {
        return this.dac;
    }
    
    private DatabaseCopyOperations databaseCopies;
    
    /**
    * Represents the SQL Database Management API includes operations for
    * managing SQL Server database copies for a subscription.
    * @return The DatabaseCopiesOperations value.
    */
    public DatabaseCopyOperations getDatabaseCopiesOperations() {
        return this.databaseCopies;
    }
    
    private DatabaseOperationOperations databaseOperations;
    
    /**
    * The Azure SQL Database Management API includes operations for getting
    * database operations. Specifically, this API allows you to get a specific
    * operation, or to list all the operations that happened on a specific
    * database or on all databases in the Azure SQL Database Server.
    * @return The DatabaseOperationsOperations value.
    */
    public DatabaseOperationOperations getDatabaseOperationsOperations() {
        return this.databaseOperations;
    }
    
    private DatabaseOperations databases;
    
    /**
    * Represents all the operations for operating on Azure SQL Databases.
    * Contains operations to: Create, Retrieve, Update, and Delete databases,
    * and also includes the ability to get the event logs for a database.
    * @return The DatabasesOperations value.
    */
    public DatabaseOperations getDatabasesOperations() {
        return this.databases;
    }
    
    private FirewallRuleOperations firewallRules;
    
    /**
    * The Azure SQL Database Management API includes operations for managing
    * the server-level Firewall Rules for Azure SQL Database Servers. You
    * cannot manage the database-level firewall rules using the Azure SQL
    * Database Management API; they can only be managed by running the
    * Transact-SQL statements against the master or individual user databases.
    * @return The FirewallRulesOperations value.
    */
    public FirewallRuleOperations getFirewallRulesOperations() {
        return this.firewallRules;
    }
    
    private QuotaOperations quotas;
    
    /**
    * The Azure SQL Database Management API includes operations for getting
    * Azure SQL Database Server quotas. Specifically, using the APIs you can
    * get a specific quota or list all of the quotas for the Azure SQL
    * Database Server.
    * @return The QuotasOperations value.
    */
    public QuotaOperations getQuotasOperations() {
        return this.quotas;
    }
    
    private RecoverableDatabaseOperations recoverableDatabases;
    
    /**
    * Contains operations for getting Azure SQL Databases that can be recovered.
    * @return The RecoverableDatabasesOperations value.
    */
    public RecoverableDatabaseOperations getRecoverableDatabasesOperations() {
        return this.recoverableDatabases;
    }
    
    private RecoverDatabaseOperations recoverDatabaseOperations;
    
    /**
    * Contains the operation to create recovery requests for Azure SQL
    * Databases.
    * @return The RecoverDatabaseOperationsOperations value.
    */
    public RecoverDatabaseOperations getRecoverDatabaseOperationsOperations() {
        return this.recoverDatabaseOperations;
    }
    
    private RestorableDroppedDatabaseOperations restorableDroppedDatabases;
    
    /**
    * Contains operations for getting dropped Azure SQL Databases that can be
    * restored.
    * @return The RestorableDroppedDatabasesOperations value.
    */
    public RestorableDroppedDatabaseOperations getRestorableDroppedDatabasesOperations() {
        return this.restorableDroppedDatabases;
    }
    
    private RestoreDatabaseOperations restoreDatabaseOperations;
    
    /**
    * Contains the operation to create restore requests for Azure SQL Databases.
    * @return The RestoreDatabaseOperationsOperations value.
    */
    public RestoreDatabaseOperations getRestoreDatabaseOperationsOperations() {
        return this.restoreDatabaseOperations;
    }
    
    private ServerOperations servers;
    
    /**
    * Contains methods to allow various operations on Azure SQL Database
    * Servers.
    * @return The ServersOperations value.
    */
    public ServerOperations getServersOperations() {
        return this.servers;
    }
    
    private ServiceObjectiveOperations serviceObjectives;
    
    /**
    * This class provides methods to get a specific service objective by using
    * its ID or to List all of the service objectives on a server.
    * @return The ServiceObjectivesOperations value.
    */
    public ServiceObjectiveOperations getServiceObjectivesOperations() {
        return this.serviceObjectives;
    }
    
    /**
    * Initializes a new instance of the SqlManagementClientImpl class.
    *
    * @param configuration The service configurations.
    * @param executorService The executor service.
    */
    public SqlManagementClientImpl(Configuration configuration, ExecutorService executorService) {
        super(configuration, executorService);
        this.dac = new DacOperationsImpl(this);
        this.databaseCopies = new DatabaseCopyOperationsImpl(this);
        this.databaseOperations = new DatabaseOperationOperationsImpl(this);
        this.databases = new DatabaseOperationsImpl(this);
        this.firewallRules = new FirewallRuleOperationsImpl(this);
        this.quotas = new QuotaOperationsImpl(this);
        this.recoverableDatabases = new RecoverableDatabaseOperationsImpl(this);
        this.recoverDatabaseOperations = new RecoverDatabaseOperationsImpl(this);
        this.restorableDroppedDatabases = new RestorableDroppedDatabaseOperationsImpl(this);
        this.restoreDatabaseOperations = new RestoreDatabaseOperationsImpl(this);
        this.servers = new ServerOperationsImpl(this);
        this.serviceObjectives = new ServiceObjectiveOperationsImpl(this);
        
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
    * Initializes a new instance of the SqlManagementClientImpl class.
    *
    * @param configuration The service configurations.
    * @param executorService The executor service.
    */
    protected SqlManagementClientImpl newInstance(Configuration configuration, ExecutorService executorService) {
        return new SqlManagementClientImpl(configuration, executorService);
    }
}
