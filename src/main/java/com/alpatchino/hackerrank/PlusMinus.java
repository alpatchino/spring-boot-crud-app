package com.alpatchino.hackerrank;

import java.util.Scanner;

/**
 * Created by patri on 01/10/2017.
 */
public class PlusMinus {

    public static void main(String[] args){

        PlusMinus p = new PlusMinus();

        Scanner in = new Scanner(System.in);

        int sizeOfArray = in.nextInt();

        int[] ar = new int[sizeOfArray];
        for(int ar_i = 0; ar_i < sizeOfArray; ar_i++){
            ar[ar_i] = in.nextInt();
        }

        double[] result = p.getFractionSignature(sizeOfArray, ar);

    }

    public double[] getFractionSignature(int sizeOfArray, int[] arr){

        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        for(int i = 0; i < sizeOfArray; i++){
            if(arr[i] > 0) positiveCount++;
            if(arr[i] < 0) negativeCount++;
            if(arr[i] == 0) zeroCount++;
        }

        double[] result = new double[3];

        if(positiveCount == 0){
            result[0] = 0;
        }else{
            result[0] = positiveCount / sizeOfArray;
        }
        if(negativeCount == 0){
            result[1] = 0;
        }else{
            result[1] = negativeCount / sizeOfArray;
        }
        if(zeroCount == 0){
            result[2] = 0;
        }else{
            result[2] = zeroCount / sizeOfArray;
        }

        return result;
    }

}
