/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

package tools.engines;

import java.net.URL;
import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import com.google.gson.JsonObject;

public class RestClient {

   private HttpURLConnection connect(String url, String method) throws IOException {
      URL connectionURL = new URL(url);
      HttpURLConnection conn = (HttpURLConnection) connectionURL.openConnection();
      conn.setDoOutput(true);
      System.setProperty("http.agent", "");
      conn.setConnectTimeout(60000);
      conn.setReadTimeout(60000);
      conn.setRequestMethod(method);
      conn.setRequestProperty("Content-Type", "application/json");
      conn.setRequestProperty("Connection", "close");
      conn.setRequestProperty("Accept", "application/json");
      conn.setRequestProperty("x-rdp-userId", "system_user");
      conn.setRequestProperty("x-rdp-clientId", "rdpclient");
      conn.setRequestProperty("x-rdp-userRoles", "admin");
      return conn;
   }

   public String sendRequest(String url, String requestPayLoad) throws IOException, RuntimeException {
      OutputStream outputStream = null;
      BufferedReader bufferedReader = null;
      BufferedReader errorStreamReader = null;
      HttpURLConnection conn = null;
      String response = null;
      int respCode;

      try {
         conn = connect(url, "POST");

         outputStream = conn.getOutputStream();
         outputStream.write(requestPayLoad.getBytes());
         outputStream.flush();
         respCode = conn.getResponseCode();

         bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

         StringBuilder responseBuilder = new StringBuilder();
         String output;

         while ((output = bufferedReader.readLine()) != null) {
            responseBuilder.append(output);
         }

         bufferedReader.close();
         outputStream.close();

         response = responseBuilder.toString();

         if (respCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
         }
      } catch (IOException ex) {
         try {

            if (conn != null) {
               respCode = conn.getResponseCode();

               errorStreamReader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));

               StringBuilder responseBuilder = new StringBuilder();
               String output;

               while ((output = errorStreamReader.readLine()) != null) {
                  responseBuilder.append(output);
               }

               // close the errorstream
               errorStreamReader.close();

               if (respCode != HttpURLConnection.HTTP_OK) {
                  throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
               } else {
                  throw new RuntimeException("Error reading response body");
               }
            } else {
               throw new RuntimeException("Failed to connect to url " + url);
            }
         } catch (IOException ex1) {
            throw new RuntimeException("Error reading response body");
         }
      } finally {
         if (outputStream != null) {
            outputStream.close();
         }
         if (bufferedReader != null) {
            bufferedReader.close();
         }
         if (errorStreamReader != null) {
            errorStreamReader.close();
         }
         if (conn != null) {
            conn.disconnect();
         }
      }

      return response;
   }


   public String getRequest(String getURL) throws IOException, RuntimeException {
      BufferedReader bufferedReader = null;
      BufferedReader errorStreamReader = null;
      HttpURLConnection conn = null;
      String response;
      int respCode;

      try {
         conn = connect(getURL, "GET");
         respCode = conn.getResponseCode();
         bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         StringBuilder responseBuilder = new StringBuilder();
         String output;

         while ((output = bufferedReader.readLine()) != null) {
            responseBuilder.append(output);
         }

         bufferedReader.close();

         response = responseBuilder.toString();

         if (respCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
         }
      } catch (IOException ex) {
         try {

            if (conn != null) {
               respCode = conn.getResponseCode();

               errorStreamReader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));

               StringBuilder responseBuilder = new StringBuilder();
               String output;

               while ((output = errorStreamReader.readLine()) != null) {
                  responseBuilder.append(output);
               }

               // close the errorstream
               errorStreamReader.close();

               if (respCode != HttpURLConnection.HTTP_OK) {
                  throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
               } else {
                  throw new RuntimeException("Error reading response body");
               }
            } else {
               throw new RuntimeException("Failed to connect to url " + getURL);
            }
         } catch (IOException ex1) {
            throw new RuntimeException("Error reading response body");
         }
      } finally {
         if (bufferedReader != null) {
            bufferedReader.close();
         }
         if (errorStreamReader != null) {
            errorStreamReader.close();
         }
         if (conn != null) {
            conn.disconnect();
         }
      }

      return response;
   }

   /**
    * @return true if response is success.
    */
   public static boolean isSuccessResponse(JsonObject responseData) {
      return responseData.has("response") &&
            responseData.getAsJsonObject("response").has("status")
            && responseData.getAsJsonObject("response").get("status").getAsString().equals("success");
   }
}