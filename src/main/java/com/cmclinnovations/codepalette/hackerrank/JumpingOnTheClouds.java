package com.cmclinnovations.codepalette.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JumpingOnTheClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        //c has 1 or 0
        // can only progress on elements equal to 0 if they are within the next two positions.
        int result = 0;

        for (int i = 0; i < c.length; i++) {
            boolean canSingleJump = (i + 1 < c.length ? (c[i + 1] == 0 ? true : false) : false);
            boolean canDoubleJump = (i + 2 < c.length ? (c[i + 2] == 0 ? true : false) : false);

            if (canDoubleJump) {
                result++;
                i++;
            } else if (canSingleJump) {
                result++;
            }
        }

        return result;
    }

    @Test
    public void Test_0() {
        final int[] c = {0, 0, 1, 0, 0, 1, 0};
        final int actual = jumpingOnClouds(c);
        final int expected = 4;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Test_1() {
        final int[] c = {0, 0, 0 ,0 ,1 ,0};
        final int actual = jumpingOnClouds(c);
        final int expected = 3;
        Assertions.assertEquals(expected, actual);
    }
}
