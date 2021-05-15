package com.github.git_leon.exercises.adjacentdigits;

/**
 * Created by Chris on 3/31/2017.
 */
public class AdjacentDigits2 implements AdjacentDigitInterface {
    public String adjacentDigits(int n) {
        StringBuilder result = new StringBuilder(); // store result here
        String stringVal = "" + n; // convert to String
        int prevDigit = -1; // temporary value
        for (String s : stringVal.split("")) { // iterate through each digit
            int curDigit = Integer.parseInt(s); // convert digit to integer
            boolean isFirstDigit = prevDigit == -1; // check if this is the first digit

            if (!isFirstDigit) { // if this is not the first digit
                if (!isZero(curDigit) && !isZero(prevDigit)) { // if both are not zero
                    if (isEven(curDigit) && isEven(prevDigit)) { // if both even
                        result.append("*"); // put '*' between digits
                    }

                    if (isOdd(curDigit) && isOdd(prevDigit)) { // if both odd
                        result.append("-"); // put '-' between digits
                    }
                }
            }
            prevDigit = curDigit; // re-assign prev digit to its new value
            result.append(curDigit); // add this digit to the result
        }
        return result.toString();
    }

    public boolean isZero(int val) {
        return val == 0;
    }

    public boolean isEven(int val) {
        return val % 2 == 0;
    }

    public boolean isOdd(int val) {
        return !isEven(val);
    }
}
