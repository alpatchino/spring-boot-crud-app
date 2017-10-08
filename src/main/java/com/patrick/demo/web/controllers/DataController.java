package com.patrick.demo.web.controllers;

import com.patrick.demo.entity.DataEntity;
import com.patrick.demo.services.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by patri on 08/10/2017.
 */
@RestController
@RequestMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
public class DataController {

    public static final Logger logger = LoggerFactory.getLogger(DataController.class);

    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<DataEntity> getAllData(){
        logger.info("Retrieving all training data...");
        return dataService.listAllData();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DataEntity getData(@PathVariable Integer id){
        logger.info("Retrieving training data... {}" + id.toString());
        return dataService.getDataById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public DataEntity createData(@RequestBody DataEntity data){
        logger.info("Creating new training data");
        return dataService.saveData(data);
    }
}
