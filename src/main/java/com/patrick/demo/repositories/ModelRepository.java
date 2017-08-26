package com.patrick.demo.repositories;

import com.patrick.demo.entity.PredictionEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by patri on 10/08/2017.
 */
public interface ModelRepository extends CrudRepository<PredictionEntity, Integer> {

}
