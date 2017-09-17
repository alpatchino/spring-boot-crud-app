package com.patrick.demo.services.impl;

import com.patrick.demo.entity.DataEntity;
import com.patrick.demo.services.repositories.DataRepository;
import com.patrick.demo.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by patri on 20/08/2017.
 */
@Service
public class DataServiceImpl implements DataService {


    private DataRepository dataRepository;

    @Autowired
    public void setDataRepository(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public Iterable<DataEntity> listAllData() {
        return dataRepository.findAll();
    }

    @Override
    public DataEntity getDataById(Integer id) {
        return dataRepository.findOne(id);
    }

    @Override
    public DataEntity saveData(DataEntity data) {
        return dataRepository.save(data);
    }
}
