package com.patrick.demo.networks;

import com.patrick.demo.entity.PredictionEntity;
import org.springframework.stereotype.Component;

/**
 * Created by patri on 23/08/2017.
 */
public class TFNetwork extends Network {

    @Override
    public void load(double[][] input, double[][] output) {

    }

    @Override
    public void construct(int inputCount, int outputCount) {

    }

    @Override
    public void learn() {

    }

    @Override
    public double[] ask(double[] input) {
        return new double[0];
    }


    @Override
    public void reset() {

    }

    //TODO: extract hyper params


}
