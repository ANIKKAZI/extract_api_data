package connection;

import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class APICallService {
    /**
     * @param queryparam
     * @return HttpResponse
     *  @throws Exception
     */
    public HttpResponse<String> makeApiConnection(String queryparam) throws Exception {
        HttpResponse<String> response = null;
        try{
           String url ="https://newsapi.org/v2/everything?q=" + queryparam;
            String apiKey = "&apiKey=b623780645ae45378676233208d0a63a";
            URL obj = new URL(url+apiKey);
            HttpRequest reqObj = HttpRequest.newBuilder().uri(obj.toURI()).GET().build();
            HttpClient clientResp = HttpClient.newHttpClient();
            response = clientResp.send(reqObj, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() != 200)
            {
                throw new Exception("Service error");
            }

        }
        catch (Exception e){
           System.out.println(e.getMessage());
        }

        return response;
    }
}
