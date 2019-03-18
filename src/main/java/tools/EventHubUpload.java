package tools;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.microsoft.azure.eventhubs.EventData;
import com.microsoft.azure.eventhubs.EventHubClient;
import com.microsoft.azure.eventhubs.ConnectionStringBuilder;

import java.io.File;
import java.time.Instant;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import tools.engines.Filter;

public class EventHubUpload {
   static int count=1;
   public static void main(String args[]) {
      try{
         //Connect Event Hub
         final ConnectionStringBuilder connStr = new ConnectionStringBuilder()
               .setNamespaceName("dev-s01-nk-eventhub")
               .setEventHubName("import")
               .setSasKeyName("RDP")
               .setSasKey("nuMCNGKkjkwH6qunNllfRQ36EeSJhC8spkI3JHlMgEA=");

         final Gson gson = new GsonBuilder().create();

         final ExecutorService executorService = Executors.newSingleThreadExecutor();
         final EventHubClient ehClient = EventHubClient.createSync(connStr.toString(), executorService);

         JsonParser parser = new JsonParser();
         Filter f=new Filter();

         //Get folder path which contains entities
         File file[]=f.finder("C:\\Users\\dnmurthi\\Desktop\\test");
         for(int i=0;i<file.length;i++) {
            JsonElement jsontree = parser.parse(new FileReader(file[i].toString()));
            byte[] payloadBytes = gson.toJson(jsontree).getBytes(Charset.defaultCharset());
            EventData sendEvent = EventData.create(payloadBytes);

            //Upload to Event Hub
            ehClient.sendSync(sendEvent);

            System.out.println(Instant.now() +" No of Files Uploaded: "+ count);
            count++;
         }
         ehClient.closeSync();
         executorService.shutdown();
      }
      catch(Exception ex){
         ex.printStackTrace();
      }
   }
}

