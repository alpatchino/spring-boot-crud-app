package com.patrick.demo.services;

import com.patrick.demo.domain.PredictionModel;
import org.springframework.stereotype.Service;

/**
 * Created by patri on 10/08/2017.
 */
public interface ModelService {

    Iterable<PredictionModel> listAllModels();

    PredictionModel getModelById(Integer id);

    PredictionModel saveModel(PredictionModel predictionModel);

    void deleteModel(PredictionModel predictionModel);
}
