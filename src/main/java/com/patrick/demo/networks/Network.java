package com.patrick.demo.networks;

/**
 * Created by patri on 26/08/2017.
 */
public abstract class Network {

    /**
     *  Load learning data into network
     */
    abstract public void load(double[][] input, double[][] output);

    /**
     *  Configure network nodes to reflect loaded data, ie. input/output nodes
     */
    abstract public void construct(int inputCount, int outputCount);


    /**
     *  Peform learning algorithm to approximate output
     */
    abstract public void learn();

    /**
     *  Query model
     */
    abstract public double[] ask(double[] input);

    /**
     * Resets all network nodes and weights to random values
     */
    abstract public void reset();
}
