package com.patrick.demo.controllers.responses;

import java.util.Date;
import java.util.Map;

/**
 * Created by patri on 17/09/2017.
 */
public class PredictionResponse {

    Date datetime;
    Map<String, Double> output;

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Map<String, Double> getOutput() {
        return output;
    }

    public void setOutput(Map<String, Double> output) {
        this.output = output;
    }
}
