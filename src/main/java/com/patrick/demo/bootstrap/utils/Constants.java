package com.patrick.demo.bootstrap.utils;

public interface Constants {
	
	/**
	 *  -- TODO: Domain constants - there's probably a better way of doing this™
	 */

	/**
	 * User.java
 	 */
	String ACCOUNT_TYPE_ADMIN = "ADMIN";
	String ACCOUNT_TYPE_PREMIUM = "PREMIUM";
	String ACCOUNT_TYPE_FREE = "FREE";

	/**
	 * PredictionEntity.java
 	 */
	String MODEL_TYPE_BINARY_CLASSIFICATION = "Binary Classification";
	String MODEL_TYPE_MULTICLASS_CLASSIFICATION = "Multi-class Classification";
	String MODEL_TYPE_REGRESSIO = "Regression";

	/**
	 * PredictiveModel.java
 	 */
	String MODEL_STATUS_OFFLINE = "OFFLINE";
	String MODEL_STATUS_LEARNING = "LEARNING";
	String MODEL_STATUS_ONLINE = "ONLINE";
	String MODEL_STATUS_ERROR = "ERROR";

	/**
	 * DataEntity.java
	 */
    String DATA_TYPE_CSV = ".csv";
    String DATA_TYPE_TXT = ".txt";
    String DATA_TYPE_XLS = ".xls";
    String DATA_TYPE_JSON = ".json";

    String DATA_LOCATION_LOCAL = "LOCAL";
	String DATA_LOCATION_AWS = "AWS";

    String PREDICTION_ENDPOINT_PREFIX = "m/";
}
