package com.cmclinnovations.codepalette.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BirthdayCakeCandles {

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
        int result = 0;
        int tallest = IntStream.of(ar).max().orElse(0);
        final List<Integer> arList = Arrays.stream(ar).boxed().collect(Collectors.toList());
        result = Collections.frequency(arList,tallest);
        return result;
    }


    @Test
    public void Test_1(){
        final int[] input = {1,2,4,4};
        final int expected = 2;
        final int actual = birthdayCakeCandles(input);
        Assertions.assertEquals(expected, actual);
    }
}
