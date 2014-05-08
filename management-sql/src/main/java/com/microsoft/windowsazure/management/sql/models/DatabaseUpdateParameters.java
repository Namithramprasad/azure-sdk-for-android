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

/**
* Represents the parameters supplied to the Create Database operation.
*/
public class DatabaseUpdateParameters {
    private String edition;
    
    /**
    * Required. Gets or sets the new edition for the database.
    * @return The Edition value.
    */
    public String getEdition() {
        return this.edition;
    }
    
    /**
    * Required. Gets or sets the new edition for the database.
    * @param editionValue The Edition value.
    */
    public void setEdition(final String editionValue) {
        this.edition = editionValue;
    }
    
    private Long maximumDatabaseSizeInBytes;
    
    /**
    * Optional. Gets or sets the maximum size of this database expressed in
    * bytes.  If this is used with MaximumDatabaseSizeInGB they must agree.
    * @return The MaximumDatabaseSizeInBytes value.
    */
    public Long getMaximumDatabaseSizeInBytes() {
        return this.maximumDatabaseSizeInBytes;
    }
    
    /**
    * Optional. Gets or sets the maximum size of this database expressed in
    * bytes.  If this is used with MaximumDatabaseSizeInGB they must agree.
    * @param maximumDatabaseSizeInBytesValue The MaximumDatabaseSizeInBytes
    * value.
    */
    public void setMaximumDatabaseSizeInBytes(final Long maximumDatabaseSizeInBytesValue) {
        this.maximumDatabaseSizeInBytes = maximumDatabaseSizeInBytesValue;
    }
    
    private Integer maximumDatabaseSizeInGB;
    
    /**
    * Optional. Gets or sets the maximum size of this database expressed in
    * gigabytes.  If this is used with MaximumDatabaseSizeInBytes they must
    * agree.
    * @return The MaximumDatabaseSizeInGB value.
    */
    public Integer getMaximumDatabaseSizeInGB() {
        return this.maximumDatabaseSizeInGB;
    }
    
    /**
    * Optional. Gets or sets the maximum size of this database expressed in
    * gigabytes.  If this is used with MaximumDatabaseSizeInBytes they must
    * agree.
    * @param maximumDatabaseSizeInGBValue The MaximumDatabaseSizeInGB value.
    */
    public void setMaximumDatabaseSizeInGB(final Integer maximumDatabaseSizeInGBValue) {
        this.maximumDatabaseSizeInGB = maximumDatabaseSizeInGBValue;
    }
    
    private String name;
    
    /**
    * Optional. Gets or sets the new name of the database.
    * @return The Name value.
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * Optional. Gets or sets the new name of the database.
    * @param nameValue The Name value.
    */
    public void setName(final String nameValue) {
        this.name = nameValue;
    }
    
    private String serviceObjectiveId;
    
    /**
    * Optional. Gets or sets the unique identifier for the service objective to
    * apply to the database.
    * @return The ServiceObjectiveId value.
    */
    public String getServiceObjectiveId() {
        return this.serviceObjectiveId;
    }
    
    /**
    * Optional. Gets or sets the unique identifier for the service objective to
    * apply to the database.
    * @param serviceObjectiveIdValue The ServiceObjectiveId value.
    */
    public void setServiceObjectiveId(final String serviceObjectiveIdValue) {
        this.serviceObjectiveId = serviceObjectiveIdValue;
    }
}
