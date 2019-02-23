/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package tools.engines;

import com.google.gson.JsonObject;

public class BusinessObjectBase {
   protected JsonObject convertToJson(String jsonString) {
      return GsonBuilder.getGsonInstance().fromJson(jsonString, JsonObject.class);
   }

   public String toJson() {
      return GsonBuilder.getGsonInstance().toJson(this);
   }
}
