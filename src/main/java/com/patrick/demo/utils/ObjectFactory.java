package com.patrick.demo.utils;

import com.patrick.demo.entity.DataEntity;
import com.patrick.demo.entity.PredictionEntity;
import com.patrick.demo.networks.JeffNetwork;
import com.patrick.demo.networks.Network;
import com.patrick.demo.networks.TFNetwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

/**
 * Created by patri on 26/08/2017.
 */
@Component
public class ObjectFactory {

    @Autowired
    private JeffNetwork jeffNetwork;

    @Autowired
    private TFNetwork tfNetwork;

    @Autowired
    private DataEntity dataEntity;


    public Network createModel(String type) {

        if (type == null) {
            return null;
        }

        if (type.equalsIgnoreCase("JEFF")) {
            return jeffNetwork;
        } else if (type.equalsIgnoreCase("TENSORFLOW"))
            return tfNetwork;

        return null;
    }

    public DataEntity createDataObject(String type){

        if (type == null)
            return null;

        if (type.equalsIgnoreCase("LOCAL"))
            return dataEntity;

        return null;
    }

}
