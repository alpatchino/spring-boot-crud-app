package com.patrick.demo.services.impl;

import com.patrick.demo.networks.Network;
import com.patrick.demo.services.FileService;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by patri on 17/09/2017.
 */
@Service
public class FileServiceImpl implements FileService {

    @Override
    public void saveNetworkFile(Integer id, Network network) {
        String path = "src/main/resources/networks/" + id.toString();
        saveFile(path, network);
    }

    @Override
    public Network readNetworkFile(Integer id) {
        String path = "src/main/resources/networks/" + id.toString();
        return (Network) readFile(path);
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
