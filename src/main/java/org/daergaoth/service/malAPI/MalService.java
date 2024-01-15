package org.daergaoth.service.malAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.daergaoth.model.anime.Anime;
import org.daergaoth.model.mal.MalApiResponse;
import org.daergaoth.service.MalSearchResultToAnimeList;
import org.daergaoth.service.URLBuilder;
import org.daergaoth.swing.build.SwingBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
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

    public List<Anime> queryAnimeList(String baseURL, Map<String,String> parameters, String headerName, String headerValue){
        return getHTML(urlBuilder.build(baseURL, parameters), headerName, headerValue);
    }

    private List<Anime> getHTML(String urlToRead, String headerName, String headerValue) {
        try{
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .setHeader(headerName, headerValue)
                    .uri(URI.create(urlToRead))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            MalApiResponse result = objectMapper.readValue(response.body(), MalApiResponse.class);
            return MalSearchResultToAnimeList.parseMalSearchToAnime(result);
//            return MalSearchResultToAnimeList.parseMalSearchToAnime(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
