package com.github.git_leon.exercises.staircase;

import java.util.StringJoiner;

/**
 * https://www.hackerrank.com/challenges/staircase/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 */
public class Staircase {


    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
        StringJoiner sj = new StringJoiner("\n");
        for (int i = 0; i < n; i++) {
            sj.add(padLeft(getRow(i+1), n));
        }
        System.out.println(sj.toString().replace("$\n", ""));
    }

    public static String getRow(int noCharacters) {
        return new String(new char[noCharacters]).replaceAll("\u0000", "#");
    }

    public static String padLeft(String string, int n) {
        return String.format("%1$" + n + "s", string);
    }
}
