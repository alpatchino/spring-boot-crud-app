package com.patrick.demo.services;

import com.patrick.demo.domain.Model;

/**
 * Created by patri on 10/08/2017.
 */
public interface ModelService {

    Iterable<Model> listAllModels();

    Model getModelById(Integer id);

    Model saveModel(Model model);

    void deleteModel(Model model);
}
