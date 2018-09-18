package com.cmclinnovations.codepalette.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class RepeatedString {
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long result = 0;

        String combined = "";
        int i = 0, slength = 0;

        while (slength <= n) {
            combined += s;
            slength = combined.length();
            i++;
        }

        char[] chars = combined.toCharArray();

        int ii = 0;
        while (ii < n) {
            char c = chars[ii];
            if (c == 'a') {
                result ++;
            }
            ii++;
        }
//        String repeatedString = LongStream.range(0, n).mapToObj(i -> s).collect(Collectors.joining()).substring(0,(int)n);
//        long count = Stream.of(repeatedString.toCharArray()).filter(c-> Objects.equals(c,'a')).count();
//        return n /s.length();

        return result;
    }

    @Test
    public void Test_0() {
        // aba aba aba a

        final String s = "aba";
        final long n = 10L;
        final long actual = repeatedString(s, n);
        final long expected = 7L;
        Assertions.assertEquals(expected, actual);
    }

}
