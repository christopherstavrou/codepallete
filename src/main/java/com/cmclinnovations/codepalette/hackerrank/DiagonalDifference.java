package com.cmclinnovations.codepalette.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 *
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.
 *
 * For example, the square matrix arr is shown below:
 *
 * 1 2 3
 * 4 5 6
 * 9 8 9
 */
public class DiagonalDifference {

    // Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] arr) {
        int n = arr.length;
        int diag1 = 0;
        int diag2 = 0;
        for (int i = 0; i < n; i++) {
            diag1 = diag1 + arr[i][i];
            diag2 = diag2 + arr[i][n - 1 - i];
        }
        return Math.abs(diag1 - diag2);
    }

    @Test
    public void Test_1() {
        final int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        final int expected = 0;
        final int actual = diagonalDifference(input);

        Assertions.assertEquals(expected, actual);

    }

}
