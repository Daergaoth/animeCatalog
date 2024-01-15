package org.daergaoth.swing.build;

import org.daergaoth.enums.Fields;
import org.daergaoth.service.malAPI.MalService;
import org.daergaoth.staticPackage.StaticObjects;
import org.daergaoth.swing.elements.MyTextArea;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ButtonMethodProvider {

    private static ButtonMethodProvider instance;

    private ButtonMethodProvider() {
    }

    public static ButtonMethodProvider getInstance() {
        if(Objects.isNull(instance)){
            instance = new ButtonMethodProvider();
        }
        return instance;
    }

    public void executeSearchButtonCommand(Map<String, Object> swingElements){
        Map<String, String> parameters = new HashMap<>();
        MyTextArea keywordTextArea = ((MyTextArea)swingElements.get(StaticObjects.QUERY_INPUT_KEY));
        String query = keywordTextArea.getText();
        if(!query.isEmpty()){
            parameters.put(StaticObjects.QUERY_HEADER_ID,query);
        }
        parameters.put(StaticObjects.LIMIT_HEADER_ID,"4");
        parameters.put(StaticObjects.FIELDS_HEADER_ID, Fields.ALTERNATIVE_TITLES.getLabel() + "," + Fields.MEDIA_TYPE.getLabel());
        MalService malService = MalService.getInstance();
        malService.queryAnimeList("https://api.myanimelist.net/v2/anime", parameters, "X-MAL-CLIENT-ID", "<clientID>");
    }
}
