package com.patrick.demo.services.impl;

import com.patrick.demo.networks.NNetwork;
import com.patrick.demo.services.FileService;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by patri on 17/09/2017.
 */
@Service
public class FileServiceImpl implements FileService {

    private static final String NETWORK_FILES_FOLDER = "src/main/resources/network_files/";
    private static final String DATA_FILES_FOLDER = "src/main/resources/data_files/";

    @Override
    public void saveNNetworkFile(Integer id, NNetwork NNetwork) {
        String path = NETWORK_FILES_FOLDER + id.toString();
        saveFile(path, NNetwork);
    }

    @Override
    public NNetwork readNNetworkFile(Integer id) {
        String path = NETWORK_FILES_FOLDER + id.toString();
        return (NNetwork) readFile(path);
    }

    @Override
    public void saveDataFile(Integer id, File file){
        String path = DATA_FILES_FOLDER + id.toString();
        saveFile(path, file);
    }

    @Override
    public File readDataFile(Integer id){
        String path = DATA_FILES_FOLDER + id.toString();
        return (File) readFile(path);
    }


    private void saveFile(String path, Object obj){

        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try {
            fout = new FileOutputStream(path);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(obj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object readFile(String path){

        Object obj = null;
        FileInputStream fin = null;
        ObjectInputStream ois = null;
        try {
            fin = new FileInputStream(path);
            ois = new ObjectInputStream(fin);
            obj = ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
