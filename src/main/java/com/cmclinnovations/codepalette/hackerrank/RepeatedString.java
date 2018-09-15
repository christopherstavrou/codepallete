package com.cmclinnovations.codepalette.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepeatedString {
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
            return n /s.length();
    }

    @Test
    public void Test_0(){
        // aba aba aba a

        final String s = "aba";
        final long n = 10L;
        final long actual = repeatedString(s, n);
        final long expected = 7L;
        Assertions.assertEquals(expected, actual);
    }

}
