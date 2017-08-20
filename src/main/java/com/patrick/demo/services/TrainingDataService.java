package com.patrick.demo.services;

import com.patrick.demo.domain.TrainingData;

/**
 * Created by patri on 20/08/2017.
 */
public interface TrainingDataService {

    Iterable<TrainingData> listAllTrainingData();

    TrainingData getTrainingDataById(Integer id);

    TrainingData saveTrainingData(TrainingData data);
}
