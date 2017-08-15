package com.patrick.demo.services.impl;

import com.patrick.demo.domain.Model;
import com.patrick.demo.repositories.ModelRepository;
import com.patrick.demo.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by patri on 10/08/2017.
 */
public class ModelServiceImpl implements ModelService {

    private ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Iterable<Model> listAllModels() {
        return modelRepository.findAll();
    }

    @Override
    public Model getModelById(Integer id) {
        return modelRepository.findOne(id);
    }

    @Override
    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public void deleteModel(Model model){
        modelRepository.delete(model);
    }
}
