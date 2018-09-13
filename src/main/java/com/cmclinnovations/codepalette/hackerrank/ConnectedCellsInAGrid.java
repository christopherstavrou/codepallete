package com.cmclinnovations.codepalette.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConnectedCellsInAGrid {

    static int connectedCell(int[][] matrix) {
        final int result = 0;

        String prnt = "";

        int lastCell = matrix[0][0];
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                final int cell = matrix[x][y];
                if (cell != lastCell) {
                    //lastCell = cell;
                    //break;
                    prnt += "";
                } else {
                    prnt += "" + cell;
                    lastCell = cell;
                }
            }
            prnt += "\n";
        }

        System.out.println(prnt);
        return result;
    }

    @Test
    public void Test_1() {
        final int[][] matrix = {{1, 1, 0}, {1, 0, 0}, {0, 0, 1}};
        ;
        final int expected = 0;
        final int actual = connectedCell(matrix);
        Assertions.assertEquals(expected, actual);
    }

}
