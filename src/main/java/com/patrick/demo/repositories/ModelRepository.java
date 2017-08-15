package com.patrick.demo.repositories;

import com.patrick.demo.domain.Model;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by patri on 10/08/2017.
 */
public interface ModelRepository extends CrudRepository<Model, Integer> {

}
