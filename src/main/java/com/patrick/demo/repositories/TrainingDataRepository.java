package com.patrick.demo.repositories;

import com.patrick.demo.entity.DataEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by patri on 20/08/2017.
 */
public interface TrainingDataRepository extends CrudRepository<DataEntity, Integer> {

}
