package com.cmclinnovations.codepalette.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PlusMinus {

    // Complete the plusMinus function below.
    static double[] plusMinus(int[] arr) {
        double[] result = {0.500000, 0.333333, 0.166667};

        final double positive = IntStream.of(arr).filter(n -> n > 0).count();
        final double negative = IntStream.of(arr).filter(n -> n < 0).count();
        final double zero = IntStream.of(arr).filter(n -> n == 0).count();

        result[0] = positive / arr.length;
        result[1] = negative / arr.length;
        result[2] = zero / arr.length;
        return result;
    }

    @Test
    public void Test_1() {
        int[] input = {-4, 3, -9, 0, 4, 1};
        double[] expected = {0.500000, 0.333333, 0.166667};
        double[] actual = plusMinus(input);

        System.out.println(DoubleStream.of(expected).mapToObj(Double::toString).collect(Collectors.joining(",")));
        System.out.println(DoubleStream.of(actual).mapToObj(Double::toString).collect(Collectors.joining(",")));

        //Assertions.assertArrayEquals(expected, actual);
    }
}
