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

package com.microsoft.windowsazure.management.websites.models;

import com.microsoft.windowsazure.core.OperationResponse;
import java.util.ArrayList;
import java.util.Iterator;

/**
* The web site instance ids response.
*/
public class WebSiteInstanceIdsResponse extends OperationResponse implements Iterable<String> {
    private ArrayList<String> instanceIds;
    
    /**
    * Optional. The identifiers of the currently running instances of the web
    * site.
    * @return The InstanceIds value.
    */
    public ArrayList<String> getInstanceIds() {
        return this.instanceIds;
    }
    
    /**
    * Optional. The identifiers of the currently running instances of the web
    * site.
    * @param instanceIdsValue The InstanceIds value.
    */
    public void setInstanceIds(final ArrayList<String> instanceIdsValue) {
        this.instanceIds = instanceIdsValue;
    }
    
    /**
    * Initializes a new instance of the WebSiteInstanceIdsResponse class.
    *
    */
    public WebSiteInstanceIdsResponse() {
        super();
        this.instanceIds = new ArrayList<String>();
    }
    
    /**
    * Gets the sequence of InstanceIds.
    *
    */
    public Iterator<String> iterator() {
        return this.getInstanceIds().iterator();
    }
}
