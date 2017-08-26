package com.patrick.demo.services;

import com.patrick.demo.entity.DataEntity;

/**
 * Created by patri on 20/08/2017.
 */
public interface TrainingDataService {

    Iterable<DataEntity> listAllTrainingData();

    DataEntity getTrainingDataById(Integer id);

    DataEntity saveTrainingData(DataEntity data);
}
