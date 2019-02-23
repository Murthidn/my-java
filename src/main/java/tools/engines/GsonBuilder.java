/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package tools.engines;

import com.google.gson.Gson;

import tools.engines.DataObject;
import tools.engines.DataObjectTypeAdapter;

/**
 * The GsonBuilder singleton.
 */
public class GsonBuilder {

   private static String GSON_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ";

   private static Gson gson = null;
   private static Gson gsonPrettyPrinting = null;
   private static Gson gsonDisableHtmlEscaping = null;

   static {
      // Create gson singletons.
      gson = initGsonInstance();
      gsonPrettyPrinting = initGsonPrettyPrintingInstance();
      gsonDisableHtmlEscaping = initGsonDisableHtmlEscapingInstance();
   }

   /**
    * Return Gson singleton to be used in production methods.
    */
   public static Gson getGsonInstance() { return gson; }

   /**
    * Return Gson singleton with pretty printing enabled.
    */
   public static Gson getGsonInstance(boolean prettyPrinting) {
      return prettyPrinting ? gsonPrettyPrinting : gson;
   }

   /**
    * Return Gson singleton with HTML escaping disabled.
    */
   public static Gson getGsonDisableHtmlEscapingInstance() {
      return gsonDisableHtmlEscaping;
   }

   private static Gson initGsonInstance() {
      com.google.gson.GsonBuilder gsonBuilder = new com.google.gson.GsonBuilder();
      gsonBuilder.setDateFormat(GSON_DATE_FORMAT);
      gsonBuilder.registerTypeAdapter(DataObject.class, new DataObjectTypeAdapter());
      return gsonBuilder.create();
   }

   private static Gson initGsonDisableHtmlEscapingInstance() {
      com.google.gson.GsonBuilder gsonBuilder = new com.google.gson.GsonBuilder();
      gsonBuilder.disableHtmlEscaping();
      gsonBuilder.setDateFormat(GSON_DATE_FORMAT);
      gsonBuilder.registerTypeAdapter(DataObject.class, new DataObjectTypeAdapter());
      return gsonBuilder.create();
   }

   private static Gson initGsonPrettyPrintingInstance() {
      com.google.gson.GsonBuilder gsonBuilder = new com.google.gson.GsonBuilder();
      gsonBuilder.setPrettyPrinting();
      gsonBuilder.setDateFormat(GSON_DATE_FORMAT);
      gsonBuilder.registerTypeAdapter(DataObject.class, new DataObjectTypeAdapter());
      return gsonBuilder.create();
   }
}

