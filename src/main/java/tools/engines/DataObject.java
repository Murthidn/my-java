/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package tools.engines;

import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class DataObject extends BusinessObjectBase implements IDataObject {

   private JsonObject dataobject = null;

   public DataObject() {
      dataobject = new JsonObject();
      dataobject.add(GlobalConstants.PropertyNames.DATA_OBJECT_INFO, new JsonObject());
      dataobject.add(GlobalConstants.PropertyNames.SYSTEM_INFO, new JsonObject());
      dataobject.add(GlobalConstants.PropertyNames.DATA, new JsonObject());
   }

   public DataObject(JsonObject inputDataObject) {
      dataobject = inputDataObject;

      if (dataobject == null) {
         dataobject = new JsonObject();
      }

      if (dataobject.get(GlobalConstants.PropertyNames.DATA_OBJECT_INFO) == null || dataobject.get(GlobalConstants.PropertyNames.DATA_OBJECT_INFO).isJsonNull()) {
         dataobject.add(GlobalConstants.PropertyNames.DATA_OBJECT_INFO, new JsonObject());
      }

      if (dataobject.get(GlobalConstants.PropertyNames.SYSTEM_INFO) == null || dataobject.get(GlobalConstants.PropertyNames.SYSTEM_INFO).isJsonNull()) {
         dataobject.add(GlobalConstants.PropertyNames.SYSTEM_INFO, new JsonObject());
      }

      if (dataobject.get(GlobalConstants.PropertyNames.DATA) == null || dataobject.get(GlobalConstants.PropertyNames.DATA).isJsonNull()) {
         dataobject.add(GlobalConstants.PropertyNames.DATA, new JsonObject());
      }
   }

   @Deprecated
   public DataObject(String id, String dataJson) {
      this();
      setId(id);
      setData(convertToJson(dataJson));
   }

   public DataObject(String id, String dataObjectType, String dataObjectDomain, String tenantId, String dataObjectSource) {
      this();
      setId(id);
      setDataObjectInfo(dataObjectType, dataObjectDomain, dataObjectSource);
      setSystemInfo(tenantId);
   }

   public DataObject(String id, String dataObjectType, String tenantId, JsonObject data) {
      this();
      setId(id);
      setDataObjectInfo(dataObjectType, null, null);
      setSystemInfo(tenantId);
      setData(data);
   }

   public JsonObject getDataobject() {
      return dataobject;
   }

   @Override
   public String getId() {
      JsonPrimitive id = dataobject.getAsJsonPrimitive(GlobalConstants.PropertyNames.ID);
      return id != null ? id.getAsString() : null;
   }

   @Override
   public void setId(String id) {
      if (id != null) {
         dataobject.addProperty(GlobalConstants.PropertyNames.ID, id);
      } else {
         dataobject.remove(GlobalConstants.PropertyNames.ID);
      }
   }

   @Override
   public String getName() {
      JsonPrimitive name = dataobject.getAsJsonPrimitive(GlobalConstants.PropertyNames.NAME);
      return name != null ? name.getAsString() : null;
   }

   @Override
   public void setName(String name) {
      if (name != null) {
         dataobject.addProperty(GlobalConstants.PropertyNames.NAME, name);
      } else {
         dataobject.remove(GlobalConstants.PropertyNames.NAME);
      }
   }

   @Override
   public String getDomain() {
      JsonPrimitive domain = dataobject.getAsJsonPrimitive(GlobalConstants.PropertyNames.DOMAIN_NAME);
      return domain != null ? domain.getAsString() : null;
   }

   @Override
   public void setDomain(String domain) {
      if (domain != null) {
         dataobject.addProperty(GlobalConstants.PropertyNames.DOMAIN_NAME, domain);
      } else {
         dataobject.remove(GlobalConstants.PropertyNames.DOMAIN_NAME);
      }
   }

   @Override
   public Integer getVersion() {
      JsonPrimitive version = dataobject.getAsJsonPrimitive(GlobalConstants.PropertyNames.VERSION);
      return version != null ? version.getAsInt() : null;
   }

   @Override
   public void setVersion(Integer version) {
      if (version != null) {
         dataobject.addProperty(GlobalConstants.PropertyNames.VERSION, version);
      }
   }

   @Override
   public long getTimestamp() {
      JsonPrimitive timestamp = dataobject.getAsJsonPrimitive(GlobalConstants.PropertyNames.TIMESTAMP);
      return timestamp != null ? timestamp.getAsLong() : null;
   }

   @Override
   public void setTimestamp(long timestamp) {
      dataobject.addProperty(GlobalConstants.PropertyNames.TIMESTAMP, timestamp);
   }

   @Override
   public JsonObject getData() {
      return dataobject.getAsJsonObject(GlobalConstants.PropertyNames.DATA);
   }

   @Override
   public void setData(JsonObject data) {
      if (data != null) {
         dataobject.add(GlobalConstants.PropertyNames.DATA, data);
      } else {
         dataobject.remove(GlobalConstants.PropertyNames.DATA);
      }
   }

   @Override
   public String getDataObjectType() {
      return getString(getDataObjectInfo(), GlobalConstants.PropertyNames.DATA_OBJECT_TYPE);
   }

   @Override
   public void setDataObjectType(String dataObjectType) {
      if (dataObjectType != null) {
         getDataObjectInfo().addProperty(GlobalConstants.PropertyNames.DATA_OBJECT_TYPE, dataObjectType);
      } else {
         getDataObjectInfo().remove(GlobalConstants.PropertyNames.DATA_OBJECT_TYPE);
      }
   }

   @Override
   public String getDataObjectDomain() {
      return getString(getDataObjectInfo(), GlobalConstants.PropertyNames.DATA_OBJECT_DOMAIN);
   }

   @Override
   public void setDataObjectDomain(String dataObjectDomain) {
      if (dataObjectDomain != null) {
         getDataObjectInfo().addProperty(GlobalConstants.PropertyNames.DATA_OBJECT_DOMAIN, dataObjectDomain);
      } else {
         getDataObjectInfo().remove(GlobalConstants.PropertyNames.DATA_OBJECT_DOMAIN);
      }
   }

   @Override
   public String getDataObjectSource() {
      return getString(getDataObjectInfo(), GlobalConstants.PropertyNames.DATA_OBJECT_SOURCE);
   }

   @Override
   public void setDataObjectSource(String dataObjectSource) {
      if (dataObjectSource != null) {
         getDataObjectInfo().addProperty(GlobalConstants.PropertyNames.DATA_OBJECT_SOURCE, dataObjectSource);
      } else {
         getDataObjectInfo().remove(GlobalConstants.PropertyNames.DATA_OBJECT_SOURCE);
      }
   }

   @Override
   public String getTenantId() {
      return getString(getSystemInfo(), GlobalConstants.PropertyNames.TENANT_ID);
   }

   @Override
   public void setTenantId(String tenantId) {
      setSystemInfo(tenantId);
   }

   private void setDataObjectInfo(String dataObjectType, String dataObjectDomain, String dataObjectSource) {
      JsonObject dataObjectInfo = getDataObjectInfo();
      if (dataObjectType != null) {
         dataObjectInfo.addProperty(GlobalConstants.PropertyNames.DATA_OBJECT_TYPE, dataObjectType);
      } else {
         dataObjectInfo.remove(GlobalConstants.PropertyNames.DATA_OBJECT_TYPE);
      }

      if (dataObjectDomain != null) {
         dataObjectInfo.addProperty(GlobalConstants.PropertyNames.DATA_OBJECT_DOMAIN, dataObjectDomain);
      } else {
         dataObjectInfo.remove(GlobalConstants.PropertyNames.DATA_OBJECT_DOMAIN);
      }

      if (dataObjectSource != null) {
         dataObjectInfo.addProperty(GlobalConstants.PropertyNames.DATA_OBJECT_SOURCE, dataObjectSource);
      } else {
         dataObjectInfo.remove(GlobalConstants.PropertyNames.DATA_OBJECT_SOURCE);
      }
   }

   private JsonObject getDataObjectInfo() {
      return dataobject.getAsJsonObject(GlobalConstants.PropertyNames.DATA_OBJECT_INFO);
   }

   private JsonObject getSystemInfo() {
      return dataobject.getAsJsonObject(GlobalConstants.PropertyNames.SYSTEM_INFO);
   }

   private void setSystemInfo(String tenantId) {
      if (tenantId != null) {
         getSystemInfo().addProperty(GlobalConstants.PropertyNames.TENANT_ID, tenantId);
      } else {
         getSystemInfo().remove(GlobalConstants.PropertyNames.TENANT_ID);
      }
   }

   private String getString(JsonObject jsonObject, String field) {
      JsonElement value = jsonObject.get(field);
      return value == null || !value.isJsonPrimitive() ? null : value.getAsJsonPrimitive().getAsString();
   }
}
