package com.github.git_leon.codewars.largestdifference;

/**
 * @author leonhunter
 * @created 05/07/2022 - 10:19 PM
 * Summary: Write a function which takes an array data of numbers and returns the largest difference in indexes j - i such that data[i] <= data[j]
 * <p>
 * Long Description:
 * <p>
 * The largestDifference takes an array of numbers. That array is not sorted. Do not sort it or change the order of the elements in any way, or their values.
 * <p>
 * Consider all of the pairs of numbers in the array where the first one is less than or equal to the second one.
 * <p>
 * From these, find a pair where their positions in the array are farthest apart.
 * <p>
 * Return the difference between the indexes of the two array elements in this pair.
 */ // https://www.codewars.com/kata/52503c77e5b972f21600000e/train/java
public class LargestDifference {
    private static class ValueAndIndex {
        private Integer firstValue;
        private Integer secondValue;

        public ValueAndIndex(Integer firstValue, Integer secondValue) {
            this.firstValue = firstValue;
            this.secondValue = secondValue;
        }

        public Integer getValue() {
            return firstValue;
        }

        public Integer getIndex() {
            return secondValue;
        }
    }

    private static class ValueAndIndexPair implements Comparable<ValueAndIndexPair> {
        private ValueAndIndex firstValueAndIndex;
        private ValueAndIndex secondValueAndIndex;

        public ValueAndIndexPair(ValueAndIndex firstValueAndIndex, ValueAndIndex secondValueAndIndex) {
            this.firstValueAndIndex = firstValueAndIndex;
            this.secondValueAndIndex = secondValueAndIndex;
        }

        public ValueAndIndex getFirstValueAndIndex() {
            return firstValueAndIndex;
        }

        public ValueAndIndex getSecondValueAndIndex() {
            return secondValueAndIndex;
        }

        public boolean isFirstValueLessThanSecondValue() {
            return firstValueAndIndex.getValue() <= secondValueAndIndex.getValue();
        }

        public int getIndexDelta() {
            return  getSecondValueAndIndex().getIndex() - getFirstValueAndIndex().getIndex();
        }

        @Override
        public int compareTo(ValueAndIndexPair o) {
            return o.getIndexDelta() - getIndexDelta();
        }
    }

    public static int largestDifference(int[] array) {
        // list of pair of two indices and their delta
        int largestDelta = Integer.MIN_VALUE;
        for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {
            int currentElement = array[currentIndex];
            for (int nextIndex = 1; nextIndex < array.length; nextIndex++) {
                int nextElement = array[nextIndex];
                ValueAndIndex firstValueAndIndex = new ValueAndIndex(currentElement, currentIndex);
                ValueAndIndex secondValueAndIndex = new ValueAndIndex(nextElement, nextIndex);
                ValueAndIndexPair valueAndIndexPair = new ValueAndIndexPair(firstValueAndIndex, secondValueAndIndex);
                if (valueAndIndexPair.isFirstValueLessThanSecondValue()) {
                    boolean isLargerDelta = largestDelta < valueAndIndexPair.getIndexDelta();
                    if (isLargerDelta) {
                        largestDelta = valueAndIndexPair.getIndexDelta();
                    }
                }
            }
        }
        return largestDelta;
    }
}
