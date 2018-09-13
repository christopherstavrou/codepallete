package com.cmclinnovations.codepalette.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Staircase {

    // Complete the staircase function below.
    static String staircase(int n) {
        String staircase = "";

        for (int i = 1; i < n+1; i++) {
            staircase += IntStream.range(0, n - i).mapToObj(obj -> " ").collect(Collectors.joining());
            staircase += IntStream.range(0, i).mapToObj(obj -> "#").collect(Collectors.joining());
            staircase += "\n";
        }
        return staircase;
    }

    @Test
    public void Test_1() {
        int input = 10;
        String expected = "         #\n" + "        ##\n" + "       ###\n" + "      ####\n" + "     #####\n" + "    ######\n" + "   #######\n" + "  ########\n" + " #########\n" + "##########\n";
        String actual = staircase(input);

        System.out.println("actual\n"+expected);
        System.out.println("expected\n"+actual);

        Assertions.assertEquals(expected, actual);
    }

}
