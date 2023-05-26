package data_processing;

import java.net.http.HttpResponse;

public class NewsDataProcessing {
    private static final String TITLE = "\"title\":";
    private static final String DESCRIPTION = "\"description\":";
    private static final String CONTENT = "\"content\":";
    /**
     * @param queryparam response
     */
    public void processData(String queryparam, HttpResponse<String> response){
        String resp = response.body().toString();
        int closeBrace = resp.lastIndexOf("]");
        int openBrace = resp.indexOf("[");
        FileOperation fileCreationObj = new FileOperation();
        String articleData = resp.substring(openBrace+1,closeBrace);
        String[] reqData = articleData.split("},");
        int articleCount = 0;
        int start = 1;
        while((start<reqData.length) && (articleCount<5))
        {
            String articleDataEx = reqData[start];
            int titleIndex = articleDataEx.indexOf(TITLE);
            int descriptionIndex = articleDataEx.indexOf(DESCRIPTION);
            int contentIndex = articleDataEx.indexOf(CONTENT);
            String titleExtract= articleDataEx.substring(titleIndex+8,descriptionIndex-1).trim();
            String contentExtract= articleDataEx.substring(contentIndex+10).trim();
            fileCreationObj.fileCreation(queryparam,titleExtract,contentExtract);
            start=start+2;
            articleCount++;
        }
    }

}
