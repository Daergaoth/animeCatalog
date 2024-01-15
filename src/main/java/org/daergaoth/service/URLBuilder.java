package org.daergaoth.service;

import java.util.Map;
import java.util.Objects;

public class URLBuilder {
    private static URLBuilder instance;

    private URLBuilder() {
    }

    public static URLBuilder getInstance() {
        if(Objects.isNull(instance)){
            instance = new URLBuilder();
        }
        return instance;
    }

    public String build(String baseURL, Map<String,String> parameters){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        if(!parameters.isEmpty()){
            stringBuilder.append("?");
            int counter = 0;
            for(Map.Entry<String, String> parameter : parameters.entrySet()){
                if(counter > 0){
                    stringBuilder.append("&");
                }
                stringBuilder.append(parameter.getKey());
                stringBuilder.append("=");
                stringBuilder.append(parameter.getValue().replaceAll(" ", "%20"));
                counter++;
            }
        }


        return stringBuilder.toString();
    }
}
