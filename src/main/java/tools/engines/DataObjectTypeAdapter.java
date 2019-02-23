/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package tools.engines;

import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonDeserializationContext;

import tools.engines.DataObject;

public class DataObjectTypeAdapter implements JsonSerializer<DataObject>, JsonDeserializer<DataObject> {
   public JsonElement serialize(DataObject dataObject, Type typeOfSrc, JsonSerializationContext context) {
      return dataObject.getDataobject();
   }

   public DataObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      return new DataObject(json.getAsJsonObject());
   }
}
