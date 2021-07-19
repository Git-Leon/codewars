package com.github.git_leon.exercises;

import java.util.Collections;
import java.util.List;

public class MinMaxSum {
    private List<Integer> arr;
    public int highestSum;
    public int lowestSum;

    public MinMaxSum(List<Integer> arr) {
        Collections.sort(arr);
        this.highestSum = 0;
        this.lowestSum = 0;
        for (int i = 0; i < 4; i++) {
            highestSum += arr.get(i);
        }
        for (int i = 4; i >= 1; i--) {
            lowestSum += arr.get(i);
        }
    }

    @Override
    public String toString() {
        return highestSum + " " + lowestSum;
    }
}
