package com.alpatchino.hackerrank;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by patri on 30/09/2017.
 */
public class DiagonalDifferenceTest {

    DiagonalDifference classUnderTest;

    @Before
    public void setUp(){
        classUnderTest = new DiagonalDifference();
    }

    @Test
    public void test_GetDiagonalDifference_ShouldReturn15(){

        // Arrange
        String[] input =   {"3",
                            "11 2 4",
                            "4 5 6",
                            "10 8 -12"};
        // Act
        int result = classUnderTest.getDiagonalDifference(input);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void test_isUserInputValid_ShouldReturnTrue(){

        List<String> input = new ArrayList<>();
        input.add("3");
        input.add("2 3 1");
        input.add("5 -2 1");
        input.add("0 0 5");

        assertEquals(true, classUnderTest.isUserInputValid(input));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_isUserInputValid_ShouldThrowException(){

        List<String> input = new ArrayList<>();
        input.add("3");
        input.add("2 3");
        input.add("5 -2 1");
        input.add("0 0 5");

        classUnderTest.isUserInputValid(input);
    }

}