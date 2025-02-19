/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.infra.datasource.props.custom;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Custom data source properties.
 */
@Getter
@EqualsAndHashCode
public final class CustomDataSourceProperties {
    
    private final Map<String, Object> properties;
    
    public CustomDataSourceProperties(final Map<String, Object> props, 
                                      final Collection<String> standardPropertyKeys, final Collection<String> transientFieldNames, final Map<String, String> propertySynonyms) {
        properties = new LinkedHashMap<>(props);
        standardPropertyKeys.forEach(properties::remove);
        transientFieldNames.forEach(properties::remove);
        propertySynonyms.values().forEach(properties::remove);
    }
}
