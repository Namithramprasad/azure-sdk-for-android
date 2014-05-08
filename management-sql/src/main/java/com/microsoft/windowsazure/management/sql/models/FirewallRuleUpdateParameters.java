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

import java.net.InetAddress;

/**
* Represents the parameters for the Create Firewall Rule operation.
*/
public class FirewallRuleUpdateParameters {
    private InetAddress endIPAddress;
    
    /**
    * Required. Gets or sets the new ending IP address for this Firewall Rule.
    * @return The EndIPAddress value.
    */
    public InetAddress getEndIPAddress() {
        return this.endIPAddress;
    }
    
    /**
    * Required. Gets or sets the new ending IP address for this Firewall Rule.
    * @param endIPAddressValue The EndIPAddress value.
    */
    public void setEndIPAddress(final InetAddress endIPAddressValue) {
        this.endIPAddress = endIPAddressValue;
    }
    
    private String name;
    
    /**
    * Required. Gets or sets the new name of the Firewall Rule.
    * @return The Name value.
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * Required. Gets or sets the new name of the Firewall Rule.
    * @param nameValue The Name value.
    */
    public void setName(final String nameValue) {
        this.name = nameValue;
    }
    
    private InetAddress startIPAddress;
    
    /**
    * Required. Gets or sets the new beginning IP address for this Firewall
    * Rule.
    * @return The StartIPAddress value.
    */
    public InetAddress getStartIPAddress() {
        return this.startIPAddress;
    }
    
    /**
    * Required. Gets or sets the new beginning IP address for this Firewall
    * Rule.
    * @param startIPAddressValue The StartIPAddress value.
    */
    public void setStartIPAddress(final InetAddress startIPAddressValue) {
        this.startIPAddress = startIPAddressValue;
    }
}
