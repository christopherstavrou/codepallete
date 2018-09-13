package com.cmclinnovations.codepalette.hackerrank.assesments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CitiOne {

    /**
     * What does this function do?
     *
     * @param ar the argument for the function
     *
     * @return the result of the function applied to the argument
     */
    public Object function(Object ar) {
        final Object result = null;

        return result;
    }

    public int multiple3and5(int start,int end){
        return IntStream.range(start, end).filter(i-> i % 3 == 0 || i % 5 == 0).sum();
    }


    @Test
    public void Test_1() {
        Object input = null;
        Object expected = null;
        Object actual = function(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Test_2(){
        System.out.println(multiple3and5(0,1000));
    }

}
