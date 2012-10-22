/*
 * Copyright (C) 2011 Benoit GUEROUT <bguerout at gmail dot com> and Yves AMSELLEM <amsellem dot yves at gmail dot com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jongo.query;

import org.jongo.marshall.Marshaller;

public final class QueryFactory {

    private final QueryBinder binder;

    public QueryFactory(Marshaller marshaller) {
        this.binder = new QueryBinder(marshaller);
    }

    public Query createQuery(String query) {
        return createQuery(query, new Object[0]);
    }

    public Query createQuery(String query, Object... parameters) {

        if (parameters.length == 0) {
            return new Query(query);
        }
        return new Query(binder.bind(query, parameters));
    }

    public Query createEmptyQuery() {
        return new Query("{}");
    }
}
