package com.patrick.demo.services.impl;

import com.patrick.demo.entity.PredictionEntity;
import com.patrick.demo.services.repositories.ModelRepository;
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
    public Iterable<PredictionEntity> listAllModels() {
        return modelRepository.findAll();
    }

    @Override
    public PredictionEntity getModelById(Integer id) {
        return modelRepository.findOne(id);
    }

    @Override
    public PredictionEntity saveModel(PredictionEntity predictionEntity) {
        return modelRepository.save(predictionEntity);
    }

    @Override
    public void deleteModel(PredictionEntity predictionEntity){
        modelRepository.delete(predictionEntity);
    }
}
