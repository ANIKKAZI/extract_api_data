package connection;

import com.mongodb.*;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;

public class DBConnection {
    /**
     * @param filteredData queryparam
     */

    public void setConnection(ArrayList<String> filteredData, String queryparam){
        String connectionKey = "mongodb+srv://testUser:Sampurna2023@cluster0.kztafbg.mongodb.net/?retryWrites=true&w=majority";
        MongoClient clientObj = MongoClients.create(MongoClientSettings
                .builder()
                .applyConnectionString(new ConnectionString(connectionKey))
                .build());
        MongoDatabase database = clientObj.getDatabase("myMongoNews");
        MongoCollection<Document> collection = database.getCollection("myMongoNews");
        for(int start = 0; start< filteredData.size();start+=2)
        {
            String title = filteredData.get(start)
                    .replaceAll("[^a-zA-Z0-9<>]", "")
                    .replaceAll("[\\uD83C-\\uDBFF\\uDC00-\\uDFFF]+", "")
                    .replaceAll("\\b(?:https?|ftp):\\/\\/\\S+[\\p{Punct}]?", "");
            String content  = filteredData.get(start+1)
                    .replaceAll("[^a-zA-Z0-9<>]", "")
                    .replaceAll("[\\uD83C-\\uDBFF\\uDC00-\\uDFFF]+", "")
                    .replaceAll("\\b(?:https?|ftp):\\/\\/\\S+[\\p{Punct}]?", "");
            Document doc = new Document("keyword", queryparam)
                    .append("title", title)
                    .append("content", content);
            collection.insertOne(doc);
        }



    }

}
