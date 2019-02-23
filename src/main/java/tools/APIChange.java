/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package tools;

import java.io.File;
import java.util.Scanner;
import java.util.UUID;
import java.io.FileReader;
import java.io.FileWriter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class APIChange{

   private static JsonObject authClientIdVarHeader = new JsonObject();
   private static JsonObject authClientSecretVarHeader = new JsonObject();

   private static String authClientIdVar = "{{AUTH_CLIENT_ID}}";
   private static String authClientSecretVar = "{{AUTH_CLIENT_SECRET}}";

   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);

      System.out.println("Enter Postman collection \n");
      String fileName = sc.next();

      String authClientId = "contact_cloud_ops_for_client_id";
      String authClientSecret = "contact_cloud_ops_for_client_secret";

      authClientIdVarHeader.addProperty("key", "auth-client-id");
      authClientIdVarHeader.addProperty("value", authClientIdVar);

      authClientSecretVarHeader.addProperty("key", "auth-client-secret");
      authClientSecretVarHeader.addProperty("value", authClientSecretVar);

      try{
         Gson gson = new Gson();
         FileReader fileReader = new FileReader(new File(fileName));
         JsonObject jsonObject = gson.fromJson(fileReader, JsonObject.class);

         if (jsonObject.get("collections") != null) {
            JsonObject authClientIdHeader = new JsonObject();
            JsonObject authClientSecretHeader = new JsonObject();
            JsonObject HTTPHeader = new JsonObject();

            authClientIdHeader.addProperty("disabled", false);
            authClientIdHeader.addProperty("key", "AUTH_CLIENT_ID");
            authClientIdHeader.addProperty("value", authClientId);
            authClientIdHeader.addProperty("type", "text");
            authClientIdHeader.addProperty("description", "Get client id from ops");

            authClientSecretHeader.addProperty("disabled", false);
            authClientSecretHeader.addProperty("key", "AUTH_CLIENT_SECRET");
            authClientSecretHeader.addProperty("value", authClientSecret);
            authClientSecretHeader.addProperty("type", "text");
            authClientSecretHeader.addProperty("description", "Get client secret from ops");

            for (JsonElement collection : jsonObject.getAsJsonArray("collections")) {
               for (JsonElement request : collection.getAsJsonObject().getAsJsonArray("requests")) {
                  JsonObject requestObject = request.getAsJsonObject();
                  if (requestObject.get("url") != null && requestObject.get("url").getAsString().contains("APIURL")
                        && requestObject.get("headerData") != null) {
                     boolean addClientId = true;
                     boolean addClientSecret = true;
                     JsonArray requestHeaders = requestObject.getAsJsonArray("headerData");
                     for (JsonElement requestHeader : requestHeaders) {
                        JsonObject requestHeaderObject = requestHeader.getAsJsonObject();
                        if (requestHeaderObject.get("key").getAsString().equalsIgnoreCase("auth-client-id")) {
                           requestHeaderObject.addProperty("value", authClientIdVar);
                           addClientId = false;
                        } else if (requestHeaderObject.get("key").getAsString().equalsIgnoreCase("auth-client-secret")) {
                           requestHeaderObject.addProperty("value", authClientSecretVar);
                           addClientSecret = false;
                        }
                     }
                     if (addClientId) {
                        requestHeaders.add(authClientIdVarHeader);
                     }
                     if (addClientSecret) {
                        requestHeaders.add(authClientSecretVarHeader);
                     }
                  }
               }

               if (jsonObject.get("variables") != null) {
                  boolean addClientId = true;
                  boolean addClientSecret = true;
                  JsonArray requestHeaders = jsonObject.getAsJsonArray("variables");
                  for (JsonElement requestHeader : requestHeaders) {
                     JsonObject requestHeaderObject = requestHeader.getAsJsonObject();
                     if (requestHeaderObject.get("key").getAsString().equalsIgnoreCase("AUTH_CLIENT_ID")) {
                        requestHeaderObject.addProperty("value", authClientId);
                        addClientId = false;
                     } else if (requestHeaderObject.get("key").getAsString().equalsIgnoreCase("AUTH_CLIENT_SECRET")) {
                        requestHeaderObject.addProperty("value", authClientSecret);
                        addClientSecret = false;
                     }
                  }

                  if (addClientId) {
                     jsonObject.getAsJsonArray("variables").add(authClientIdHeader);
                  }
                  if (addClientSecret) {
                     jsonObject.getAsJsonArray("variables").add(authClientSecretHeader);
                  }
               } else {
                  JsonArray variable = new JsonArray();
                  variable.add(authClientIdHeader);
                  variable.add(authClientSecretHeader);
                  jsonObject.add("variables", variable);
               }
            }
         }


         else if (jsonObject.get("item") != null) {
            for (JsonElement item : jsonObject.getAsJsonArray("item")) {
               addRequestHeadersInItem(item);

               if (item.getAsJsonObject().get("item") != null) {
                  for (JsonElement innerItem : item.getAsJsonObject().getAsJsonArray("item")) {
                     addRequestHeadersInItem(innerItem);

                     if (innerItem.getAsJsonObject().get("item") != null) {
                        for (JsonElement innerItem1 : innerItem.getAsJsonObject().getAsJsonArray("item")) {
                           addRequestHeadersInItem(innerItem1);

                           if (innerItem1.getAsJsonObject().get("item") != null) {
                              for (JsonElement innerItem2 : innerItem1.getAsJsonObject().getAsJsonArray("item")) {
                                 addRequestHeadersInItem(innerItem2);

                                 if (innerItem2.getAsJsonObject().get("item") != null) {
                                    for (JsonElement innerItem3 : innerItem2.getAsJsonObject().getAsJsonArray("item")) {
                                       addRequestHeadersInItem(innerItem3);

                                       if (innerItem3.getAsJsonObject().get("item") != null) {
                                          for (JsonElement innerItem4 : innerItem3.getAsJsonObject().getAsJsonArray("item")) {
                                             addRequestHeadersInItem(innerItem4);

                                             if (innerItem4.getAsJsonObject().get("item") != null) {
                                                for (JsonElement innerItem5 : innerItem4.getAsJsonObject().getAsJsonArray("item")) {
                                                   addRequestHeadersInItem(innerItem5);

                                                   if (innerItem5.getAsJsonObject().get("item") != null) {
                                                      for (JsonElement innerItem6 : innerItem5.getAsJsonObject().getAsJsonArray("item")) {
                                                         addRequestHeadersInItem(innerItem6);

                                                         if (innerItem6.getAsJsonObject().get("item") != null) {
                                                            for (JsonElement innerItem7 : innerItem6.getAsJsonObject().getAsJsonArray("item")) {
                                                               addRequestHeadersInItem(innerItem7);

                                                               if (innerItem7.getAsJsonObject().get("item") != null) {
                                                                  for (JsonElement innerItem8 : innerItem7.getAsJsonObject().getAsJsonArray("item")) {
                                                                     addRequestHeadersInItem(innerItem8);

                                                                     if (innerItem8.getAsJsonObject().get("item") != null) {
                                                                        for (JsonElement innerItem9 : innerItem8.getAsJsonObject().getAsJsonArray("item")) {
                                                                           addRequestHeadersInItem(innerItem9);

                                                                           if (innerItem9.getAsJsonObject().get("item") != null) {
                                                                              for (JsonElement innerItem10 : innerItem9.getAsJsonObject().getAsJsonArray("item")) {
                                                                                 addRequestHeadersInItem(innerItem10);
                                                                              }
                                                                           }
                                                                        }
                                                                     }
                                                                  }
                                                               }
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            JsonObject authClientIdHeader = new JsonObject();
            JsonObject authClientSecretHeader = new JsonObject();

            authClientIdHeader.addProperty("id", UUID.randomUUID().toString());
            authClientIdHeader.addProperty("key", "AUTH_CLIENT_ID");
            authClientIdHeader.addProperty("value", authClientId);
            authClientIdHeader.addProperty("type", "string");

            authClientSecretHeader.addProperty("id", UUID.randomUUID().toString());
            authClientSecretHeader.addProperty("key", "AUTH_CLIENT_SECRET");
            authClientSecretHeader.addProperty("value", authClientSecret);
            authClientSecretHeader.addProperty("type", "string");

            if (jsonObject.get("variable") != null) {
               boolean addClientId = true;
               boolean addClientSecret = true;
               JsonArray requestHeaders = jsonObject.getAsJsonArray("variable");
               for (JsonElement requestHeader : requestHeaders) {
                  JsonObject requestHeaderObject = requestHeader.getAsJsonObject();
                  if (requestHeaderObject.get("key").getAsString().equalsIgnoreCase("AUTH_CLIENT_ID")) {
                     requestHeaderObject.addProperty("value", authClientId);
                     addClientId = false;
                  } else if (requestHeaderObject.get("key").getAsString().equalsIgnoreCase("AUTH_CLIENT_SECRET")) {
                     requestHeaderObject.addProperty("value", authClientSecret);
                     addClientSecret = false;
                  }
               }

               if (addClientId) {
                  jsonObject.getAsJsonArray("variable").add(authClientIdHeader);
               }
               if (addClientSecret) {
                  jsonObject.getAsJsonArray("variable").add(authClientSecretHeader);
               }
            } else {
               JsonArray variable = new JsonArray();
               variable.add(authClientIdHeader);
               variable.add(authClientSecretHeader);
               jsonObject.add("variable", variable);
            }
         }

         File file = new File(fileName + "_modified.json");
         if (file.exists()) {
            file.delete();
         }

         FileWriter fileWriter = new FileWriter(new File(fileName + "_modified.json"), true);
         gson.toJson(jsonObject, fileWriter);
         fileReader.close();
         fileWriter.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private static void addRequestHeadersInItem(JsonElement innerItem) {
      if (innerItem.getAsJsonObject().get("request") != null) {
         JsonObject requestObject = innerItem.getAsJsonObject().getAsJsonObject("request");
         if (requestObject.get("url") != null && requestObject.getAsJsonObject("url").get("raw").getAsString().contains("PORT")) {
            String url = requestObject.getAsJsonObject("url").get("raw").getAsString();
            if(url.startsWith("http://")){
               url = url.replaceAll("http://", "{{HTTP}}://");
            }
            if(url.contains("{{WEBURL}}:{{WEBPORT}}")){
               url = url.replaceAll("\\{\\{WEBURL\\}\\}:\\{\\{WEBPORT\\}\\}", "{{APIURL}}");
            }
            requestObject.getAsJsonObject("url").addProperty("raw", url);
            requestObject.getAsJsonObject("url").remove("port");
            JsonArray hostArray = requestObject.getAsJsonObject("url").getAsJsonArray("host");
            hostArray.remove(0);
            JsonPrimitive apiUrl = new JsonPrimitive("{{APIURL}}");
            hostArray.add(apiUrl);
            requestObject.getAsJsonObject("url").addProperty("protocol", "{{HTTP}}");
         }
         if (requestObject.get("url") != null && requestObject.getAsJsonObject("url").get("raw").getAsString().contains("APIURL")
               && requestObject.get("header") != null) {
            boolean addClientId = true;
            boolean addClientSecret = true;
            JsonArray requestHeaders = requestObject.getAsJsonArray("header");
            for (JsonElement requestHeader : requestHeaders) {
               JsonObject requestHeaderObject = requestHeader.getAsJsonObject();
               if (requestHeaderObject.get("key").getAsString().equalsIgnoreCase("auth-client-id")) {
                  requestHeaderObject.addProperty("value", authClientIdVar);
                  addClientId = false;
               } else if (requestHeaderObject.get("key").getAsString().equalsIgnoreCase("auth-client-secret")) {
                  requestHeaderObject.addProperty("value", authClientSecretVar);
                  addClientSecret = false;
               }
            }
            if (addClientId) {
               requestHeaders.add(authClientIdVarHeader);
            }
            if (addClientSecret) {
               requestHeaders.add(authClientSecretVarHeader);
            }
         }
      }
   }
}
