package org.daergaoth.service.malAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.daergaoth.model.mal.MalApiResponse;
import org.daergaoth.service.URLBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Objects;

public class MalService {

    private static MalService instance;
    private final URLBuilder urlBuilder;

    private MalService() {
        this.urlBuilder = URLBuilder.getInstance();
    }

    public static MalService getInstance() {
        if(Objects.isNull(instance)){
            instance = new MalService();
        }
        return instance;
    }

    public void queryAnimeList(String baseURL, Map<String,String> parameters, String headerName, String headerValue){
        getHTML(urlBuilder.build(baseURL, parameters), headerName, headerValue);
    }

    private void getHTML(String urlToRead,String headerName, String headerValue) {
        try{
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .setHeader(headerName, headerValue)
                    .uri(URI.create(urlToRead))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            MalApiResponse result = objectMapper.readValue(response.body(), MalApiResponse.class);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
