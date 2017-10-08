package com.patrick.demo.bootstrap;


import com.patrick.demo.entity.PredictionEntity;
import com.patrick.demo.entity.DataEntity;
import com.patrick.demo.entity.User;
import com.patrick.demo.networks.NNetwork;
import com.patrick.demo.services.repositories.ModelRepository;
import com.patrick.demo.services.repositories.DataRepository;
import com.patrick.demo.services.repositories.UserRepository;
import com.patrick.demo.services.DataService;
import com.patrick.demo.services.FileService;
import com.patrick.demo.services.ModelService;
import com.patrick.demo.bootstrap.utils.Constants;

import java.util.Date;

import com.patrick.demo.bootstrap.utils.ObjectFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent>  {

    private Logger log = Logger.getLogger(UserLoader.class);

	//TODO: finish model repo

	@Autowired
    private UserRepository userRepository;
    @Autowired
	private ModelRepository modelRepository;
    @Autowired
	private DataRepository dataRepository;
	@Autowired
	private DataService dataService;
	@Autowired
    private ModelService modelService;
    @Autowired
	private ObjectFactory factory;
    @Autowired
    private FileService fileService;



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    	//populateDB();

    	userCreatesANDPrediction();

	}

	private void userCreatesANDModelAction(){

        // USER UPLOADS CSV

    }

	private void userUsersANDModel(){}



	private void userCreatesANDPrediction(){

	    // Step 0: User must exist in DB
        User admin = new User();
        admin.setAccountType(Constants.ACCOUNT_TYPE_ADMIN);
        admin.setAccessKey("0000-1111-abcd-edfg");
        admin.setCreatedOn(new Date());
        admin.setLastLogin(new Date());
        admin.setFailedLoginAttempts(0);
        admin.setFirstName("Admin");
        admin.setLastName("Admin");
        admin.setEmail("admin@admin.com");
        admin.setUsername("admin");
        admin.setPassword("password");
        userRepository.save(admin);
        log.info("Saved user - " + admin.getId());


		// Step 1: User fills form and uploads CSV
        String csv = "A, B, Output\n" +
                "0, 0, 0\n" +
                "0, 1, 0\n" +
                "1, 0, 0\n" +
                "1, 1, 1";


        // Step 2: App creates DataEntity and populates it with form data
        DataEntity ANDData = factory.createDataObject(Constants.DATA_LOCATION_LOCAL);
        ANDData.setDescription("Test case description");
        ANDData.setFiletype(Constants.DATA_TYPE_CSV);
        ANDData.setInputNodesCount(new Integer(2));
        ANDData.setOutputNodesCount(new Integer(1));
        ANDData.setLocation(Constants.DATA_LOCATION_LOCAL);

        // Step 3: Save data entity to DB, id will be used as file ID
        DataEntity returnedData = dataService.saveData(ANDData);



        // Step 4: Save CSV file with DataEntity id as file name
        //saveToDisk(csv, "src/main/resources/training-data/" + id.toString() + Constants.DATA_TYPE_CSV);
        fileService.saveDataFile(returnedData.getId(), csv);

        // Step 5: Load CSV data into memory
		log.info("Loading data object with id " + returnedData.toString());
		double[][] data_in = getCSVInputDataAs2DArrayMock("AND");
		double[][] data_out = getCSVOutputDataAs2DArrayMock("AND");
		String[] header = {"A", "B", "Output"};



		// Step 5: Basic metadata is extracted from data, data is normalised
        DataEntity loadedDataEntity = dataService.getDataById(returnedData.getId());
        int inputNodes = loadedDataEntity.getInputNodesCount();
        int outputNodes = loadedDataEntity.getOutputNodesCount();

		// Step 6: NNetwork is initialised with extracted data metadata
        NNetwork nn = factory.createModel("JEFF");
        nn.load(data_in, data_out);
        nn.construct(inputNodes, outputNodes);

        // Step: NNetwork info is saved in DB
        PredictionEntity ANDModel = new PredictionEntity();
        ANDModel.setCreatedBy(admin);
        ANDModel.setDescription("Logical AND of two inputs");
        ANDModel.setEndpointUri(Constants.PREDICTION_ENDPOINT_PREFIX);
        ANDModel.setName("Logical AND");
        ANDModel.setStatus(Constants.MODEL_STATUS_ONLINE);
        ANDModel.setModelLocation("/models/1.ser");
        ANDModel.setDataEntity(ANDData);
        PredictionEntity returnedPredictionEntity = modelService.saveModel(ANDModel);
        Integer returnedModelId = returnedPredictionEntity.getId();


		// Step 4: NNetwork learns data
        nn.learn();

		// Step 5: Ask network
        double[] input = {1.0, 0.0};
        double[] output = nn.ask(input);
        System.out.println("Answer is : " + output[0]);

        // Save finished NNetwork file
        fileService.saveNNetworkFile(returnedModelId, nn);
        NNetwork fromDiskNN = fileService.readNNetworkFile(returnedModelId);

        // Step 5: Ask network read from disk:
        output = fromDiskNN.ask(input);

        System.out.println("Answer from de-serialised NN is " + output[0]);


    }



	private double[][] getCSVInputDataAs2DArrayMock(String type){

		double dataAND[][] = {
                {0.0,0.0},
                {1.0,0.0},
                {0.0,1.0},
                {1.0,1.0}};

        double dataOR[][] = {
                {0.0,0.0},
                {1.0,0.0},
                {0.0,1.0},
                {1.0,1.0}};

        double dataXOR[][] = {
                {0.0,0.0},
                {1.0,0.0},
                {0.0,1.0},
                {1.0,1.0}};


		if(type.equalsIgnoreCase("1") || type.equalsIgnoreCase("AND"))
		    return dataAND;

        if(type.equalsIgnoreCase("2") || type.equalsIgnoreCase("OR"))
            return dataOR;

		if(type.equalsIgnoreCase("3") || type.equalsIgnoreCase("XOR"))
		    return dataXOR;

		return null;

	}

    private double[][] getCSVOutputDataAs2DArrayMock(String type){

        double dataAND[][] = {
                {0.0},
                {0.0},
                {0.0},
                {1.0}};

        double dataOR[][] = {
                {0.0},
                {1.0},
                {1.0},
                {1.0}};

        double dataXOR[][] = {
                {0.0},
                {1.0},
                {1.0},
                {0.0}};


        if(type.equalsIgnoreCase("1") || type.equalsIgnoreCase("AND"))
            return dataAND;

        if(type.equalsIgnoreCase("2") || type.equalsIgnoreCase("OR"))
            return dataOR;

        if(type.equalsIgnoreCase("3") || type.equalsIgnoreCase("XOR"))
            return dataXOR;

        return null;

    }


	private void populateDB() {

        /**
         * 	Initialise test users
         */
        User admin = new User();
        admin.setAccountType(Constants.ACCOUNT_TYPE_ADMIN);
        admin.setAccessKey("0000-1111-abcd-edfg");
        admin.setCreatedOn(new Date());
        admin.setLastLogin(new Date());
        admin.setFailedLoginAttempts(0);
        admin.setFirstName("Admin");
        admin.setLastName("Admin");
        admin.setEmail("admin@admin.com");
        admin.setUsername("admin");
        admin.setPassword("password");
        userRepository.save(admin);
        log.info("Saved user - " + admin.getId());

        User premiumUser = new User();
        premiumUser.setAccountType(Constants.ACCOUNT_TYPE_PREMIUM);
        premiumUser.setAccessKey("1234-5678-abcd-edfg");
        premiumUser.setCreatedOn(new Date());
        premiumUser.setLastLogin(new Date());
        premiumUser.setFailedLoginAttempts(0);
        premiumUser.setFirstName("Premium");
        premiumUser.setLastName("User");
        premiumUser.setEmail("premium@user.com");
        premiumUser.setUsername("premiumuser");
        premiumUser.setPassword("password");
        userRepository.save(premiumUser);
        log.info("Saved user - " + premiumUser.getId());

        User freeUser = new User();
        freeUser.setAccountType(Constants.ACCOUNT_TYPE_FREE);
        freeUser.setAccessKey("abcd-efgh-1234-5678");
        freeUser.setCreatedOn(new Date());
        freeUser.setLastLogin(new Date());
        freeUser.setFailedLoginAttempts(0);
        freeUser.setFirstName("Free");
        freeUser.setLastName("User");
        freeUser.setEmail("free@user.com");
        freeUser.setUsername("freeuser");
        freeUser.setPassword("password");
        userRepository.save(freeUser);
        log.info("Saved user - " + freeUser.getId());


        /**
         *  Initialise training data
         */
        DataEntity ANDData = factory.createDataObject("LOCAL");
        //DataEntity ANDData = new DataEntity();
        ANDData.setOutputNodesCount(2);
        ANDData.setInputNodesCount(4);
        ANDData.setFiletype(Constants.DATA_TYPE_CSV);
        ANDData.setLocation(Constants.DATA_LOCATION_LOCAL);
        ANDData.setDescription("Training data for Logical AND");
        dataRepository.save(ANDData);

        DataEntity ORData = factory.createDataObject("LOCAL");
        //DataEntity ORData = new DataEntity();
        ORData.setOutputNodesCount(2);
        ORData.setInputNodesCount(4);
        ORData.setFiletype(Constants.DATA_TYPE_CSV);
        ORData.setLocation(Constants.DATA_LOCATION_LOCAL);
        ORData.setDescription("Training data for Logical OR");
        dataRepository.save(ORData);


        /**
         *  Initialise test models
         */
        PredictionEntity ANDModel = new PredictionEntity();
        ANDModel.setCreatedBy(admin);
        ANDModel.setDescription("Logical AND of two inputs");
        ANDModel.setEndpointUri("/and");
        ANDModel.setName("Logical AND");
        ANDModel.setStatus(Constants.MODEL_STATUS_OFFLINE);
        ANDModel.setModelLocation("/models/1.ser");
        ANDModel.setDataEntity(ANDData);
        modelRepository.save(ANDModel);


        PredictionEntity ORModel = new PredictionEntity();
        ORModel.setCreatedBy(admin);
        ORModel.setDescription("Logical OR of two inputs");
        ORModel.setEndpointUri("/or");
        ORModel.setName("Logical OR");
        ORModel.setStatus(Constants.MODEL_STATUS_ONLINE);
        ORModel.setModelLocation("/models/2.ser");
        ORModel.setDataEntity(ORData);
        modelRepository.save(ORModel);

    }
}

