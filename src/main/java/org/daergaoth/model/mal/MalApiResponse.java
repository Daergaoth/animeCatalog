package org.daergaoth.model.mal;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Map;

public class MalApiResponse {

//    public Object node;


    private List<Map<String, Object>> data;
    private Map<String, Object> paging;

    public MalApiResponse() {
    }

    public MalApiResponse(List<Map<String, Object>> data, Map<String, Object> paging) {
        this.data = data;
        this.paging = paging;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }

    public Map<String, Object> getPaging() {
        return paging;
    }

    public void setPaging(Map<String, Object> paging) {
        this.paging = paging;
    }
}
