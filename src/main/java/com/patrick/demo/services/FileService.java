package com.patrick.demo.services;

import com.patrick.demo.networks.NNetwork;

import java.io.File;


/**
 * Created by patri on 17/09/2017.
 */
public interface FileService {

    // TODO: This should be generic file saver and not tied to NNetwork entity

    /**
     * Saves a NNetwork file
     * @param id
     * @param NNetwork
     */
    void saveNNetworkFile(Integer id, NNetwork NNetwork);

    /**
     * Reads a NNetwork file from local storage
     * @param id
     * @return NNetwork
     */
    NNetwork readNNetworkFile(Integer id);

    /**
     * Saves a specific data file to local storage
     *
     * @param id
     * @param file
     */
    void saveDataFile(Integer id, String file);

    /**
     * Reads a data file from local storage
     *
     * @param id fileId
     * @return File
     */
    File readDataFile(Integer id);
}
