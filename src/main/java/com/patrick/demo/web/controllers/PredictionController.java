package com.patrick.demo.web.controllers;

import com.patrick.demo.bootstrap.utils.Constants;
import com.patrick.demo.web.requests.PredictionRequest;
import com.patrick.demo.web.responses.PredictionResponse;
import com.patrick.demo.entity.PredictionEntity;
import com.patrick.demo.entity.User;
import com.patrick.demo.bootstrap.exceptions.AccessKeyException;
import com.patrick.demo.networks.Network;
import com.patrick.demo.services.FileService;
import com.patrick.demo.services.ModelService;
import com.patrick.demo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * Created by patri on 17/09/2017.
 */

@RestController
@RequestMapping(value = "/m", produces = MediaType.APPLICATION_JSON_VALUE)
public class PredictionController {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private FileService fileService;

    public static final Logger logger = LoggerFactory.getLogger(PredictionController.class);


    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public PredictionResponse ask(@PathVariable Integer id, @RequestBody PredictionRequest request) throws Exception {

        // Authenticate user
        authenticate(request.getUsername(), request.getAccessKey());

        // Get PredictionEntity and its related Network from disk
        PredictionEntity prediction = modelService.getModelById(id);
        Network nn = fileService.readNetworkFile(prediction.getId());

        if(nn.getStatus() != Constants.MODEL_STATUS_ONLINE)
            throw new Exception("Model is not ready to be queried. STATUS is " + nn.getStatus());

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

    private void authenticate(String username, String accessKey){

        try{

            User user  = userService.getUserByUsername(username);

            if(user != null){
                throw new UsernameNotFoundException("Username provided does not match our records");
            }

            if(user.getApiKey().equalsIgnoreCase(accessKey)){
                logger.info("User {} with key {} has been authenticated", username, accessKey);
            }else{
                throw new AccessKeyException("API key provided does not match our records.");
            }

        }catch(AccessKeyException ex){
            logger.info("User {} with key {} has could not bee authenticated", username, accessKey);
        }
    }

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
