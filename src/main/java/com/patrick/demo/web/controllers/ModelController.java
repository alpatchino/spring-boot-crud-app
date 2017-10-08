package com.patrick.demo.web.controllers;

import com.patrick.demo.entity.PredictionEntity;
import com.patrick.demo.services.ModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by patri on 08/10/2017.
 */
@RestController
@RequestMapping(value = "/models", produces = MediaType.APPLICATION_JSON_VALUE)
public class ModelController {

    public static final Logger logger = LoggerFactory.getLogger(ModelController.class);

    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<PredictionEntity> getAllModels() {
        logger.info("Retrieving all models {}...");
        return modelService.listAllModels();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PredictionEntity getModel(@PathVariable Integer id) {
        logger.info("Retrieving single model {}...", id);
        return modelService.getModelById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public PredictionEntity createModel(@RequestBody PredictionEntity model) {
        logger.info("Creating new model {}...", model);
        return modelService.saveModel(model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public PredictionEntity updateModel(@PathVariable Integer id, @RequestBody PredictionEntity model){
        logger.info("Updating model {}...", model);
        model.setId(id);
        return modelService.saveModel(model);
    }
}
