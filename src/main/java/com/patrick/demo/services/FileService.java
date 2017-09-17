package com.patrick.demo.services;

import com.patrick.demo.networks.Network;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


/**
 * Created by patri on 17/09/2017.
 */
public interface FileService {

    void saveNetworkFile(Integer id, Network network);

    Network readNetworkFile(Integer id);
}
