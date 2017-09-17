package com.patrick.demo.services;

import com.patrick.demo.entity.PredictionEntity;

/**
 * Created by patri on 10/08/2017.
 */
public interface ModelService {

    Iterable<PredictionEntity> listAllModels();

    PredictionEntity getModelById(Integer id);

    PredictionEntity saveModel(PredictionEntity predictionEntity);

    void deleteModel(PredictionEntity predictionEntity);


}
