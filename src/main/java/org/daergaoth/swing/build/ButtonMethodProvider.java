package org.daergaoth.swing.build;

import org.daergaoth.enums.Fields;
import org.daergaoth.model.anime.Anime;
import org.daergaoth.model.mal.MalApiResponse;
import org.daergaoth.service.malAPI.MalService;
import org.daergaoth.staticPackage.StaticObjects;
import org.daergaoth.swing.elements.MyTextArea;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ButtonMethodProvider {

    private static ButtonMethodProvider instance;
    private final SwingBuilder swingBuilder;

    private ButtonMethodProvider() {
        this.swingBuilder = SwingBuilder.getInstance();
    }

    public static ButtonMethodProvider getInstance() {
        if(Objects.isNull(instance)){
            instance = new ButtonMethodProvider();
        }
        return instance;
    }

    public List<Anime> executeSearchButtonCommand(Map<String, Object> swingElements){
        Map<String, String> parameters = new HashMap<>();
        MyTextArea keywordTextArea = ((MyTextArea)swingElements.get(StaticObjects.QUERY_INPUT_KEY));
        String query = keywordTextArea.getText();
        if(!query.isEmpty()){
            parameters.put(StaticObjects.QUERY_HEADER_ID,query);
        }
        parameters.put(StaticObjects.LIMIT_HEADER_ID,"4");
        parameters.put(StaticObjects.FIELDS_HEADER_ID, Fields.ALTERNATIVE_TITLES.getLabel() + "," + Fields.MEDIA_TYPE.getLabel());
        MalService malService = MalService.getInstance();
        if(Objects.nonNull(swingBuilder.getSwingElements().get(StaticObjects.MAL_CLIENT_ID_INPUT_KEY))){

            String clientID = ((MyTextArea)swingBuilder.getSwingElements().get(StaticObjects.MAL_CLIENT_ID_INPUT_KEY)).getText();
            return malService.queryAnimeList(StaticObjects.MAL_BASEURL, parameters, StaticObjects.MAL_HEADER_TAG, clientID);
        }else {
            throw new RuntimeException("ClientID is missing.");
        }
    }

    public void executeExitButtonCommand(){
        System.exit(0);
    }
}
