package com.patrick.demo.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by patri on 20/08/2017.
 */

@Component
@Entity(name="data_main")
public class DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int inputNodesCount;
    private int outputNodesCount;

    private String filetype;
    private String location;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getInputNodesCount() {
        return inputNodesCount;
    }

    public void setInputNodesCount(int inputNodesCount) {
        this.inputNodesCount = inputNodesCount;
    }

    public int getOutputNodesCount() {
        return outputNodesCount;
    }

    public void setOutputNodesCount(int outputNodesCount) {
        this.outputNodesCount = outputNodesCount;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
