package search;

import connection.*;
import data_processing.FileOperation;
import data_processing.NewsDataProcessing;

import java.net.http.HttpResponse;
import java.util.ArrayList;

public class SearchNews implements Keywords {
    /**
     *  @throws Exception
     */

    public void getNewsForKeyWords() throws Exception {
            APICallService newsService = new APICallService();
            NewsDataProcessing dataprocessObj = new NewsDataProcessing();
            DBConnection dbObj = new DBConnection();
            FileOperation fileObj = new FileOperation();
        for (String queryparam: Keywords.keywords)
            {
                try {
                    HttpResponse<String> response= newsService.makeApiConnection(queryparam);
                    dataprocessObj.processData(queryparam,response);
                    ArrayList<String> filteredData = fileObj.fileReadOperation(queryparam);
                    dbObj.setConnection(filteredData,queryparam);
                } catch (Exception e) {
                    throw new RuntimeException(e);
            }
        }





    }

}
