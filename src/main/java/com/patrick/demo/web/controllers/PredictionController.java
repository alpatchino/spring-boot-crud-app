package com.patrick.demo.web.controllers;

import com.patrick.demo.bootstrap.utils.Constants;
import com.patrick.demo.entity.User;
import com.patrick.demo.services.*;
import com.patrick.demo.web.requests.PredictionRequest;
import com.patrick.demo.web.responses.PredictionResponse;
import com.patrick.demo.entity.PredictionEntity;

import com.patrick.demo.networks.NNetwork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * Created by patri on 17/09/2017.
 */

@RestController
@RequestMapping(value = "/m", produces = MediaType.APPLICATION_JSON_VALUE)
public class PredictionController {

    public static final Logger logger = LoggerFactory.getLogger(PredictionController.class);

    private final ModelService modelService;
    private final FileService fileService;
    private final AuthenticatorService authenticatorService;

    @Autowired
    public PredictionController(FileService fileService, ModelService modelService, AuthenticatorService authenticatorService) {
        this.fileService = fileService;
        this.modelService = modelService;
        this.authenticatorService = authenticatorService;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public PredictionResponse ask(@PathVariable Integer id, @RequestBody PredictionRequest request) throws Exception {

        // Authenticate user
        User user = authenticatorService.getAuthenticatedUser(request.getUsername(), request.getAccessKey());

        // Get PredictionEntity and its related NNetwork from disk
        PredictionEntity prediction = modelService.getModelById(id);
        NNetwork nn = fileService.readNNetworkFile(prediction.getId());

        if(!Constants.MODEL_STATUS_ONLINE.equalsIgnoreCase(nn.getStatus())){
            throw new Exception("Model is not ready to be queried. STATUS is " + nn.getStatus());
        }


        // Convert map to primitive double array
        double[] input = convertInputMapToPrimitiveDouble(request.getInput());

        // Ask network for prediction
        double[] output = nn.ask(input);

        // Build response
        PredictionResponse response = new PredictionResponse();
        response.setDatetime(new Date());
        response.setOutput(convertPrimitiveDoubleToOutputMap(output));

        return response;
    }

    @RequestMapping(value = "/{id}/response", method = RequestMethod.GET)
    public PredictionResponse getSampleResponse(@PathVariable Integer id){
        //TODO: Populate a typical response
        return new PredictionResponse();

    }

    @RequestMapping(value = "/{id}/request", method = RequestMethod.GET)
    public PredictionRequest getSampleRequest(@PathVariable Integer id){
        //TODO: Populate a typical request
        return new PredictionRequest();
    }



    // TODO: SRP - this should be in a Utils class
    private double[] convertInputMapToPrimitiveDouble(Map<String, Double> inputMap){
        Collection<Double> values = inputMap.values();
        return values.stream().mapToDouble(Double::doubleValue).toArray();
    }

    private Map<String, Double> convertPrimitiveDoubleToOutputMap(double[] output){

        Map<String, Double> outputMap = new HashMap<>();

        for(int i = 0; i < output.length; i++)
            outputMap.put(Integer.toString(i), output[i]);

        return outputMap;

    }

}
