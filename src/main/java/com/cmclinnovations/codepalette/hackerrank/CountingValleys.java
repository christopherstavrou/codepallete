package com.cmclinnovations.codepalette.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class CountingValleys {

    static int countingValleys(int n, String s) {
        int result = 0;

        // Starts and finishes a 0
        // U =(up hill and +1 unit in altitude)
        // D =(down hill and -1 unit in altitude)
        //count how many time a valley had been entered (which is when the altitude has gone from altitude == 0 ->  altitude < 0 -> altitude == 0)

        final char[] chars = s.toCharArray();
        final int seaLvl = 0;
        int currentLvl = seaLvl;

        boolean isBelowSeaLvl = false;

        for (int i = 0; i < n; i++) {
            char direction = chars[i];
            if (Objects.equals(direction, 'U')) {
                currentLvl ++;
            } else {
                currentLvl --;
            }

            if (!isBelowSeaLvl && currentLvl < seaLvl){
                isBelowSeaLvl = true;
                result ++;
            } else if (currentLvl >= seaLvl){
                isBelowSeaLvl = false;
            }
        }
        return result;
    }

    @Test
    public void Test_1() {
        final int n = 8;
        final String s = "DDUUDDUU";
        final int actual = countingValleys(n, s);
        final int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

}
