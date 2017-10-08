package com.alpatchino.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

/**
 * Created by patri on 30/09/2017.
 */
public class DiagonalDifference {

    public static void main(String[] args){

        DiagonalDifference d = new DiagonalDifference();

        // get user input
        Scanner in = new Scanner(System.in);
        List<String> input = new ArrayList<>();

        // loop through user input
        while(in.hasNextLine()){
            String s = in.nextLine();
            input.add(s);
        }

        int result = 0;

        if(d.isUserInputValid(input)){
            // validate input and get diagonal difference
            result = d.getDiagonalDifference(input.toArray(new String[input.size()]));
        }

        System.out.println(result);

    }

    public boolean isUserInputValid(List<String> input){

        // check for valid input
        if(input.size() > 0 && input.get(0).toString().length() > 1)
            throw new IllegalArgumentException("First element should be matrix row size, and should contain one integer");

        int matrixRowCount = Integer.parseInt(input.get(0));

        // check that user input should be at least
        if(input.size() < 3 || input.size() - 1 != matrixRowCount)
            throw new IllegalArgumentException("Input should be at least 3 lines (matrix row, 2 row matrix minimum)");

        // check every row in matrix matches matrixRowCount
        for (String s: input) {
            // dont check first arg
            if(input.indexOf(s) > 0){
                if(s.split("\\s+").length != matrixRowCount)
                    throw new IllegalArgumentException("Matrix dimension should match first arg");
            }

        }

        return true;
    }

    public int getDiagonalDifference(String[] input) {

        int[][] matrix = convertStringToIntegerMatrix(input);

        return abs(getPrimaryDiagonalSum(matrix) - (getSecondaryDiagonalSum(matrix)));
    }

    private int getPrimaryDiagonalSum(int[][] matrix){
        int sum = 0;

        for(int x = 0; x < matrix.length; x++)
            sum = sum + matrix[x][x];

        return sum;
    }

    private int getSecondaryDiagonalSum(int[][] matrix){
        int sum = 0;

        for(int x = matrix.length - 1; x >= 0; x--)
            sum = sum + matrix[x][matrix.length - x - 1];

        return sum;
    }

    private int[][] convertStringToIntegerMatrix(String[] input) {

        int[][] matrix = new int[input.length - 1][input.length - 1];

        String[] row;

        // skip first element as its not part of matrix
        for (int i = 1; i < input.length; i++) {

            // split by space
            row = input[i].split("\\s+");

            for (int j = 0; j < row.length; j++) {

                // convert to int and assign to matrix
                int element = Integer.parseInt(row[j]);

                matrix[i - 1][j] = element;
            }
        }

        return matrix;
    }

}
