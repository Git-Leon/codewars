package com.github.git_leon.exercises;

import java.util.Collections;
import java.util.List;

public class MinMaxSum {
    public Long lowestSum;
    public Long highestSum;

    public MinMaxSum(List<Integer> arr) {
        Collections.sort(arr);
        this.lowestSum = 0L;
        this.highestSum = 0L;
        for (int i = 0; i < 4; i++) {
            lowestSum += arr.get(i);
        }
        for (int i = 4; i >= 1; i--) {
            highestSum += arr.get(i);
        }
    }

    @Override
    public String toString() {
        return lowestSum + " " + highestSum;
    }
}
