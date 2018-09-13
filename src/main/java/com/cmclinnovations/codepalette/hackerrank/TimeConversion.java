package com.cmclinnovations.codepalette.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        String result = "";

        final String[] split = s.split(":");

        int hr = Integer.valueOf(split[0]);
        String sHr = "";
        if (split[2].toUpperCase().contains("PM")) {
            if (hr != 12) {
                sHr = "" + (hr + 12);
            } else {
                sHr = "12";
            }
        } else {
            if (new String("" + hr).length() < 2) {
                sHr = "0" + hr;

            } else {
                if (hr != 12) {
                    sHr = "" + hr;
                } else {
                    sHr = "00";
                }
            }
        }

        String min = split[1];
        String sec = split[2].toUpperCase().replaceAll("AM", "").replaceAll("PM", "");

        result = sHr + ":" + min + ":" + sec;

        return result;
    }

    @Test
    public void Test_1() {
        String arg = "07:05:45PM";
        String expected = "19:05:45";
        String actual = timeConversion(arg);

        Assertions.assertEquals(expected, actual);

        Assertions.assertEquals("00:40:22", timeConversion("12:40:22AM"));
    }

}
