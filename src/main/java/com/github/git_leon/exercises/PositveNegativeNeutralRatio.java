package com.github.git_leon.exercises;


import java.util.List;
import java.util.StringJoiner;

public class PositveNegativeNeutralRatio {
    private List<Integer> arr;
    private int noPositives;
    private int noNegatives;
    private int noZeroes;

    public PositveNegativeNeutralRatio(List<Integer> arr) {
        this.arr = arr;
        for (int value : arr) {
            if (value > 0) {
                this.noPositives++;
            } else if (value < 0) {
                this.noNegatives++;
            } else {
                this.noZeroes++;
            }
        }
    }

    public double size() {
        return arr.size();
    }

    public double getPositiveRatio() {
        return this.noPositives / size();
    }

    public double getNegativeRatio() {
        return this.noNegatives / size();
    }

    public double getZeroRatio() {
        return this.noZeroes / size();
    }

    public String toString() {
        final String precision = "%.5f";
        return new StringJoiner("\n")
                .add(String.format(precision, getPositiveRatio()))
                .add(String.format(precision, getNegativeRatio()))
                .add(String.format(precision, getZeroRatio()))
                .toString();
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here

    }

}