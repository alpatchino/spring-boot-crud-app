package com.patrick.demo.controllers;

import com.patrick.demo.controllers.requests.PredictionRequest;
import com.patrick.demo.controllers.responses.PredictionResponse;
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
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * Created by patri on 17/09/2017.
 */

@RestController
@RequestMapping(value = "/m", produces = MediaType.APPLICATION_JSON_VALUE)
public class PredictionController {

    @Autowired private UserService userService;
    @Autowired private ModelService modelService;
    @Autowired private FileService fileService;

    public static final Logger logger = LoggerFactory.getLogger(PredictionController.class);


    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public PredictionResponse ask(@PathVariable Integer id, @RequestBody PredictionRequest request) {

        String username = request.getUsername();
        String accessKey = request.getAccessKey();

        // Authenticate user
        try{
            User user  = userService.getUserByUsername(username);

            if(user.getApiKey().equalsIgnoreCase(accessKey)){
                logger.info("User {} with key {} has been authenticated", username, accessKey);
            }else{
                throw new AccessKeyException("API key provided does not match our records.");
            }

        }catch(AccessKeyException ex){
            logger.info("User {} with key {} has could not bee authenticated", username, accessKey);
            return new PredictionResponse();
        }


        //TODO: VERIFY INPUT
        Map<String, Double> requestInputMap = request.getInput();
        Integer inputSize = requestInputMap.size();

        Collection<Double> values = requestInputMap.values();
        double[] input_array = values.stream().mapToDouble(Double::doubleValue).toArray();

        // Get PredictionEntity and its related Network from disk
        PredictionEntity prediction = modelService.getModelById(id);
        Network nn = fileService.readNetworkFile(prediction.getId());

        // Ask network for prediction
        double[] output = nn.ask(input_array);


        PredictionResponse response = new PredictionResponse();
        response.setDatetime(new Date());

        Map<String, Double> outputMap = new HashMap<>();
        outputMap.put("A", output[0]);
        response.setOutput(outputMap);

        return response;
    }

}
