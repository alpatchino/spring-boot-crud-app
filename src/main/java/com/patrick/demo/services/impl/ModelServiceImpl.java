package com.patrick.demo.services.impl;

import com.patrick.demo.domain.PredictionModel;
import com.patrick.demo.repositories.ModelRepository;
import com.patrick.demo.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by patri on 10/08/2017.
 */
@Service
public class ModelServiceImpl implements ModelService {

    private ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Iterable<PredictionModel> listAllModels() {
        return modelRepository.findAll();
    }

    @Override
    public PredictionModel getModelById(Integer id) {
        return modelRepository.findOne(id);
    }

    @Override
    public PredictionModel saveModel(PredictionModel predictionModel) {
        return modelRepository.save(predictionModel);
    }

    @Override
    public void deleteModel(PredictionModel predictionModel){
        modelRepository.delete(predictionModel);
    }
}
