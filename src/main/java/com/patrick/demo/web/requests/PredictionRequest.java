package com.patrick.demo.web.requests;

import java.util.Map;

/**
 * Created by patri on 17/09/2017.
 */
public class PredictionRequest {

    String username;
    String accessKey;

    Map<String, Double> input;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public Map<String, Double> getInput() {
        return input;
    }

    public void setInput(Map<String, Double> input) {
        this.input = input;
    }
}
