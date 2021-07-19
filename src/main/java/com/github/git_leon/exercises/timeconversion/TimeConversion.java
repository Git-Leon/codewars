package com.github.git_leon.exercises.timeconversion;

import java.util.Arrays;
import java.util.StringJoiner;

public class TimeConversion {
    private final int seconds;
    private final int minutes;
    private final int hours;
    private final boolean isPM;

    public TimeConversion(String s) {
        String[] data = s.split(":");
        String secondsAsString = data[2].substring(0, 2);
        this.isPM = "PM".equalsIgnoreCase(data[2].substring(2));
        this.seconds = Integer.parseInt(secondsAsString);
        this.minutes = Integer.parseInt(data[1]);
        int hours = Integer.parseInt(data[0]) + (isPM ? 12 : 0);
        this.hours = hours == 24 ? 12 : hours;
    }
    private String getHours() {
        if(isPM) return 12 == hours ? "12" : format(hours);
        return 12 == hours ? "00" : format(hours);
    }

    private String format(Integer value) {
        return value < 10 ?
                "0" + value :
                value.toString();
    }

    @Override
    public String toString() {
        return new StringJoiner(":")
                .add(getHours())
                .add(format(minutes))
                .add(format(seconds))
                .toString();
    }
    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        return new TimeConversion(s).toString();
    }

}
