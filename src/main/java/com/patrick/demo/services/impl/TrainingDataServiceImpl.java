package com.patrick.demo.services.impl;

import com.patrick.demo.entity.DataEntity;
import com.patrick.demo.repositories.TrainingDataRepository;
import com.patrick.demo.services.TrainingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by patri on 20/08/2017.
 */
@Service
public class TrainingDataServiceImpl implements TrainingDataService {

    private TrainingDataRepository trainingDataRepository;

    @Autowired
    public void setTrainingDataRepository(TrainingDataRepository trainingDataRepository) {
        this.trainingDataRepository = trainingDataRepository;
    }

    @Override
    public Iterable<DataEntity> listAllTrainingData() {
        return null;
    }

    @Override
    public DataEntity getTrainingDataById(Integer id) {
        return null;
    }

    @Override
    public DataEntity saveTrainingData(DataEntity data) {
        return null;
    }
}
