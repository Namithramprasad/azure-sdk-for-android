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

package com.microsoft.windowsazure.management.sql.models;

import java.util.Calendar;

/**
* A dropped Azure SQL Database that can be restored.
*/
public class RestorableDroppedDatabase extends SqlModelCommon {
    private Calendar creationDate;
    
    /**
    * Optional. Gets the date this database was created.
    * @return The CreationDate value.
    */
    public Calendar getCreationDate() {
        return this.creationDate;
    }
    
    /**
    * Optional. Gets the date this database was created.
    * @param creationDateValue The CreationDate value.
    */
    public void setCreationDate(final Calendar creationDateValue) {
        this.creationDate = creationDateValue;
    }
    
    private Calendar deletionDate;
    
    /**
    * Optional. Gets the date this database was deleted.
    * @return The DeletionDate value.
    */
    public Calendar getDeletionDate() {
        return this.deletionDate;
    }
    
    /**
    * Optional. Gets the date this database was deleted.
    * @param deletionDateValue The DeletionDate value.
    */
    public void setDeletionDate(final Calendar deletionDateValue) {
        this.deletionDate = deletionDateValue;
    }
    
    private String edition;
    
    /**
    * Optional. Gets the database resource's edition.
    * @return The Edition value.
    */
    public String getEdition() {
        return this.edition;
    }
    
    /**
    * Optional. Gets the database resource's edition.
    * @param editionValue The Edition value.
    */
    public void setEdition(final String editionValue) {
        this.edition = editionValue;
    }
    
    private String entityId;
    
    /**
    * Optional. Gets the entity ID of the database.
    * @return The EntityId value.
    */
    public String getEntityId() {
        return this.entityId;
    }
    
    /**
    * Optional. Gets the entity ID of the database.
    * @param entityIdValue The EntityId value.
    */
    public void setEntityId(final String entityIdValue) {
        this.entityId = entityIdValue;
    }
    
    private long maximumDatabaseSizeInBytes;
    
    /**
    * Optional. Gets the maximum size of this database expressed in bytes.
    * @return The MaximumDatabaseSizeInBytes value.
    */
    public long getMaximumDatabaseSizeInBytes() {
        return this.maximumDatabaseSizeInBytes;
    }
    
    /**
    * Optional. Gets the maximum size of this database expressed in bytes.
    * @param maximumDatabaseSizeInBytesValue The MaximumDatabaseSizeInBytes
    * value.
    */
    public void setMaximumDatabaseSizeInBytes(final long maximumDatabaseSizeInBytesValue) {
        this.maximumDatabaseSizeInBytes = maximumDatabaseSizeInBytesValue;
    }
    
    private Calendar recoveryPeriodStartDate;
    
    /**
    * Optional. Gets the starting date of the restorable period for this
    * database.
    * @return The RecoveryPeriodStartDate value.
    */
    public Calendar getRecoveryPeriodStartDate() {
        return this.recoveryPeriodStartDate;
    }
    
    /**
    * Optional. Gets the starting date of the restorable period for this
    * database.
    * @param recoveryPeriodStartDateValue The RecoveryPeriodStartDate value.
    */
    public void setRecoveryPeriodStartDate(final Calendar recoveryPeriodStartDateValue) {
        this.recoveryPeriodStartDate = recoveryPeriodStartDateValue;
    }
    
    private String serverName;
    
    /**
    * Optional. Gets the name of the server.
    * @return The ServerName value.
    */
    public String getServerName() {
        return this.serverName;
    }
    
    /**
    * Optional. Gets the name of the server.
    * @param serverNameValue The ServerName value.
    */
    public void setServerName(final String serverNameValue) {
        this.serverName = serverNameValue;
    }
}
