package com.patrick.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class PredictionModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private String description;
	private String endpointUri;
	private String status;
	private String modelLocation;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference // Stops infinite loop
	private User createdBy;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "training_data_id")
	private TrainingData data;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEndpointUri() {
		return endpointUri;
	}

	public void setEndpointUri(String endpointUri) {
		this.endpointUri = endpointUri;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getModelLocation() {
		return modelLocation;
	}

	public void setModelLocation(String modelLocation) {
		this.modelLocation = modelLocation;
	}

	public TrainingData getData() {
		return data;
	}

	public void setData(TrainingData data) {
		this.data = data;
	}
}
