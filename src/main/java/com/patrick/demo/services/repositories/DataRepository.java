package com.patrick.demo.services.repositories;

import com.patrick.demo.entity.DataEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by patri on 20/08/2017.
 */
public interface DataRepository extends CrudRepository<DataEntity, Integer> {

}
