package com.arka.shubhamsharma.model;

import java.util.HashMap;
import java.util.Map;

public class CountryModel {

    private RestResponseClass RestResponse;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public RestResponseClass getRestResponse() {
        return RestResponse;
    }

    public void setRestResponse(RestResponseClass restResponse) {
        RestResponse = restResponse;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
