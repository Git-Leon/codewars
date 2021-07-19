package com.github.git_leon.diagnoldelta;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DiagonalDelta {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public int diagonalDifference(List<List<Integer>> arr) {
        int firstSum = getLeftDiagonalSum(arr);
        int secondSum = getRightDiagonalSum(arr);
        return Math.abs(firstSum - secondSum);

    }

    public int getLeftDiagonalSum(List<List<Integer>> arr) {
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i).get(i);
        }
        return sum;
    }


    public int getRightDiagonalSum(List<List<Integer>> arr) {
        List<List<Integer>> reversedList = new ArrayList<>();
        arr
                .forEach(list -> {
                    Collections.reverse(list);
                    reversedList.add(list);
                });
        int val = getLeftDiagonalSum(reversedList);
        return val;
    }
}
