package com.github.git_leon.codewars.codewars;

import java.util.ArrayList;import java.util.Arrays;
public class CountDuplicates {
    public CountDuplicates() {}

    public <E> int countDuplicates(E[] numberArray) {
        int numberOfDuplicates = 0;
        ArrayList<E> uniqueVals = new ArrayList<E>(Arrays.asList(numberArray));
        for(E val : uniqueVals) {
            uniqueVals.remove(val);
            if(uniqueVals.contains(val)) {
                uniqueVals = removeAll(uniqueVals, val);
                numberOfDuplicates++;
            }
        }
        return numberOfDuplicates;
    }

    private <E> ArrayList<E> removeAll(ArrayList<E> list, E val) {
        while(list.contains(val)) {
            list.remove(val);
        }
        return list;
    }

    public static void main(String[] args) {
    }
}
