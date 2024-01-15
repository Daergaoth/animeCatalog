package org.daergaoth.service;

import org.daergaoth.model.anime.Anime;
import org.daergaoth.model.mal.MalApiResponse;

import java.util.*;

public class MalSearchResultToAnimeList {
    public static List<Anime> parseMalSearchToAnime(MalApiResponse malApiResponse){

        List<Anime> result = new ArrayList<>();

        if(Objects.nonNull(malApiResponse.getData())){

            malApiResponse.getData().forEach(entry -> {
                for (Map.Entry<String, Object> entry2 : entry.entrySet()){
                    Anime anime = new Anime();
                    for(Object entry3 : ((LinkedHashMap)entry2.getValue()).entrySet()){
                        Map.Entry<String, Object> temp = ((Map.Entry<String, Object>)entry3);
                        switch (temp.getKey()){
                            case "id":
                                anime.setId(((Integer) temp.getValue()));
                                break;
                            case "title":
                                anime.setTitle(((String) temp.getValue()));
                                break;
                            case "main_picture":

                                Map<String, Object> temp2 = ((Map<String, Object>)temp.getValue());
                                for(Map.Entry<String, Object> temp3 : temp2.entrySet()){
                                    anime.setMainPicture(((String) temp3.getValue()));
                                }
                                break;
                            case "alternative_titles":
                                Map<String, Object> temp4 = ((Map<String, Object>)temp.getValue());
                                for(Map.Entry<String, Object> temp3 : temp4.entrySet()){
                                    if(temp3.getValue() instanceof String){
                                        anime.getAlternativeTitles().add(((String) temp3.getValue()));
                                    }
                                }
                                break;
                            case "media_type":
                                anime.setMediaType(((String) temp.getValue()));
                                break;
                        }
                    }
                    result.add(anime);
                }
            });
        }
        return result;
    }
}
