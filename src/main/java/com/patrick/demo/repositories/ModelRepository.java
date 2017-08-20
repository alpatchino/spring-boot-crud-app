package com.patrick.demo.repositories;

import com.patrick.demo.domain.PredictionModel;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by patri on 10/08/2017.
 */
public interface ModelRepository extends CrudRepository<PredictionModel, Integer> {

}
