/*******************************************************************************
 * Copyright 2011, Mysema Ltd
 *  
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 *******************************************************************************/
package br.com.anteros.persistence.dsl.osql.types.path;

import java.util.HashMap;
import java.util.Map;

import br.com.anteros.core.utils.StringUtils;

/**
 * PathBuilderFactory is a factory class for PathBuilder creation
 *
 * @author tiwe
 *
 */
public final class PathBuilderFactory {

    private final Map<Class<?>, PathBuilder<?>> paths = new HashMap<Class<?>, PathBuilder<?>>();

    /**
     * Create a new PathBuilder instance for the given type
     * 
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> PathBuilder<T> create(Class<T> clazz) {
        PathBuilder<T> rv = (PathBuilder<T>) paths.get(clazz);
        if (rv == null) {
            rv = new PathBuilder<T>(clazz, StringUtils.uncapitalize(clazz.getSimpleName()));
            paths.put(clazz, rv);
        }
        return rv;
    }

}
