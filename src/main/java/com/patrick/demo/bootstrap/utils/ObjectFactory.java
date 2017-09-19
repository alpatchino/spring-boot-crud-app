package com.patrick.demo.bootstrap.utils;

import com.patrick.demo.entity.DataEntity;
import com.patrick.demo.networks.JeffNetwork;
import com.patrick.demo.networks.Network;
import com.patrick.demo.networks.TFNetwork;
import org.springframework.stereotype.Component;

/**
 * Created by patri on 26/08/2017.
 */
@Component
public class ObjectFactory {

    public Network createModel(String type) {

        if (type == null) {
            return null;
        }

        if (type.equalsIgnoreCase("JEFF")) {
            return new JeffNetwork();
        } else if (type.equalsIgnoreCase("TENSORFLOW"))
            return new TFNetwork();

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
