/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package tools.engines;

import com.google.gson.JsonObject;

public interface IDataObject extends IJsonSerialize {

   String getId();

   void setId(String id);

   String getName();

   void setName(String name);

   String getDomain();

   void setDomain(String domain);

   Integer getVersion();

   void setVersion(Integer version);

   long getTimestamp();

   void setTimestamp(long timestamp);

   JsonObject getData();

   void setData(JsonObject data);

   String getDataObjectType();

   void setDataObjectType(String dataObjectType);

   String getDataObjectDomain();

   void setDataObjectDomain(String dataObjectDomain);

   String getDataObjectSource();

   void setDataObjectSource(String dataObjectSource);

   String getTenantId();

   void setTenantId(String tenantId);
}
