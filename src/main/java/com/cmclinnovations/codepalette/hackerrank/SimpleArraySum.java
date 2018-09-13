package com.cmclinnovations.codepalette.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

public class SimpleArraySum {
    /*
     * Complete the simpleArraySum function below.
     */
    static int simpleArraySum(int[] ar) {
        /*
         * Write your code here.
         */

        return IntStream.of(ar).filter(value -> 0 < value).sum();
    }

    private static final Scanner scanner = new Scanner(System.in);

    @Test
    public void Test_1(){
        final int expected = 15;
        final int actual = simpleArraySum(new int[]{1,2,3,4,5});
        Assertions.assertEquals(expected,actual);
    }

}
