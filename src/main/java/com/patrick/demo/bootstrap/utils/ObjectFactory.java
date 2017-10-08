package com.patrick.demo.bootstrap.utils;

import com.patrick.demo.entity.DataEntity;
import com.patrick.demo.networks.JeffNNetwork;
import com.patrick.demo.networks.NNetwork;
import com.patrick.demo.networks.TFNNetwork;
import org.springframework.stereotype.Component;

/**
 * Created by patri on 26/08/2017.
 */
@Component
public class ObjectFactory {

    public NNetwork createModel(String type) {

        if (type == null) {
            return null;
        }

        if (type.equalsIgnoreCase("JEFF")) {
            return new JeffNNetwork();
        } else if (type.equalsIgnoreCase("TENSORFLOW"))
            return new TFNNetwork();

        return null;
    }

    public DataEntity createDataObject(String type){

        if (type == null)
            return null;

        if (type.equalsIgnoreCase("LOCAL"))
            return new DataEntity();

        return null;
    }

}
