package com.cmclinnovations.codepalette.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MiniMaxSum {

    static Number[] miniMaxSum(final int... arr) {
        //final int[] results = {10,14};
        int[] posArr = IntStream.of(arr).filter(i -> i>0).toArray();
        Arrays.sort(posArr);

        final long min = IntStream.range(0, posArr.length >= 4 ? 4: posArr.length).map(i -> posArr[i]).asLongStream().sum();
        final long max = IntStream.range(posArr.length >= 4 ? posArr.length - 4: posArr.length, posArr.length).map(i -> posArr[i]).asLongStream().sum();


        return new Number[]{min, max};
    }

    @Test
    public void Test_1() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {10, 14};
        Number[] actual = miniMaxSum();
        System.out.println(input.length);
        System.out.println("expected " +IntStream.of(expected).mapToObj(Integer::toString).collect(Collectors.joining(" ")));

        System.out.println("actual " + Stream.of(actual).map(n -> "" +n.longValue()).collect(Collectors.joining(" ")));

//        Assertions.assertArrayEquals(expected, Stream.of(actual).mapToInt(n -> n.intValue()).toArray());
    }

}
