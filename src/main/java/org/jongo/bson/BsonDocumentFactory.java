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

package org.jongo.bson;

import com.mongodb.DBObject;
import org.bson.LazyBSONCallback;

public final class BsonDocumentFactory {

    public static BsonDocument fromDBObject(DBObject dbo) {
        if (dbo instanceof BsonDocument) {
            return (BsonDocument) dbo;
        }
        return new SimpleBsonDocument(dbo);
    }

    public static BsonDocument fromByteArray(byte[] bytes) {
        return new ReadonlyBsonDocument(bytes, 0, new LazyBSONCallback());
    }

    private BsonDocumentFactory() {
    }
}
