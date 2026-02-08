package org.umair.hotel_mangement_system_in_spring_boot.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Responses {

    private Map<String, Object> apiResponse = new HashMap<>();

    public Responses(){};

    public Map<String, Object> getResponse() {
        return apiResponse;
    }

    public void setResponse(String key , Object value) {
        apiResponse.put(key,value);
    }
    public Object getData(String key){
        return apiResponse.get(key);
    }
}
