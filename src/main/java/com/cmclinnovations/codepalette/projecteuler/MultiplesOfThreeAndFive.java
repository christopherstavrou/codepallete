package com.cmclinnovations.codepalette.projecteuler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class MultiplesOfThreeAndFive {

    public int multiple3and5(int start,int end){
        return IntStream.range(start, end).filter(i-> i % 3 == 0 || i % 5 == 0).sum();
    }

    @Test
    public void Test_2(){
        final int multiple3and5 = multiple3and5(0, 1000);
        System.out.println(multiple3and5);
        Assertions.assertEquals(233168,multiple3and5);
    }

}
