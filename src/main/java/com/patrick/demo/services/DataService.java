package com.patrick.demo.services;

import com.patrick.demo.entity.DataEntity;

/**
 * Created by patri on 20/08/2017.
 */
public interface DataService {

    Iterable<DataEntity> listAllData();

    DataEntity getDataById(Integer id);

    DataEntity saveData(DataEntity data);
}
