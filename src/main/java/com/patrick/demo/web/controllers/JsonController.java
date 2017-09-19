package com.patrick.demo.web.controllers;

import com.patrick.demo.entity.DataEntity;
import com.patrick.demo.entity.PredictionEntity;
import com.patrick.demo.entity.User;
import com.patrick.demo.services.ModelService;
import com.patrick.demo.services.DataService;
import com.patrick.demo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

//TODO: Extract model and user functionality

@RestController
@RequestMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
public class JsonController {

    public static final Logger logger = LoggerFactory.getLogger(JsonController.class);

    /**
     *
     */
    @Autowired
    private UserService userService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private DataService dataService;

    /**
     *
     *      USER MAPPINGS: GetAllUsers, CreateUser, GetUser
     *
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Iterable<User> getAllUsers() {
        logger.info("Retrieving all users...");
        return userService.listAllUsers();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        logger.info("Retrieving single user {}...", id);
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        logger.info("Creating new user {}...", user);
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable Integer id, @RequestBody User user){
        logger.info("Updating user {}...", user.getId());
        user.setId(id);
        return userService.saveUser(user);
    }


    /**
     *
     *      MODEL MAPPINGS: GetAllModels, GetModel, CreateModel, UpdateModel
     *
     */
    @RequestMapping(value = "/models", method = RequestMethod.GET)
    public Iterable<PredictionEntity> getAllModels() {
        logger.info("Retrieving all models {}...");
        return modelService.listAllModels();
    }

    @RequestMapping(value = "/models/{id}", method = RequestMethod.GET)
    public PredictionEntity getModel(@PathVariable Integer id) {
        logger.info("Retrieving single model {}...", id);
        return modelService.getModelById(id);
    }

    @RequestMapping(value = "/models", method = RequestMethod.POST)
    public PredictionEntity createModel(@RequestBody PredictionEntity model) {
        logger.info("Creating new model {}...", model);
        return modelService.saveModel(model);
    }

    @RequestMapping(value = "/models/{id}", method = RequestMethod.PUT)
    public PredictionEntity updateModel(@PathVariable Integer id, @RequestBody PredictionEntity model){
        logger.info("Updating model {}...", model);
        model.setId(id);
        return modelService.saveModel(model);
    }

    /**
     *
     *
     *      DATA MAPPINGS: GetAllTrainingData, GetTrainingData, CreateTrainingData
     *
     */
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public Iterable<DataEntity> getAllData(){
        logger.info("Retrieving all training data...");
        return dataService.listAllData();
    }

    @RequestMapping(value = "/data/{id}", method = RequestMethod.GET)
    public DataEntity getData(@PathVariable Integer id){
        logger.info("Retrieving training data... {}" + id.toString());
        return dataService.getDataById(id);
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public DataEntity createData(@RequestBody DataEntity data){
        logger.info("Creating new training data");
        return dataService.saveData(data);
    }

}
