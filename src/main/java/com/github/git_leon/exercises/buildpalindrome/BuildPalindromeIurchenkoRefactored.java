package com.github.git_leon.exercises.buildpalindrome;

import java.util.Scanner;

// https://github.com/mariiaiurchenko/hackerrank/blob/master/HakerRank/src/main/java/com/spring/tutorial/HakerRank/strings/BuildAPalindrome.java
public class BuildPalindromeIurchenkoRefactored implements BuildPalindromeInterface {
    private final String strA;
    private final String strB;

    public BuildPalindromeIurchenkoRefactored(String value1, String value2) {
        this.strA = value1;
        this.strB = value2;
    }

    public static String buildPalindrome(String a, String b) {
        return new BuildPalindromeIurchenkoRefactored(a, b).toString();
    }

    public String toString() {
        String reverseStrB = new StringBuilder(strB).reverse().toString();
        String longestCS = longestCommonSubString(reverseStrB);
        if (longestCS.length() <= 0) {
            return "-1";
        }
        StringBuilder res = new StringBuilder();

        String reverseLongestCS = new StringBuilder(longestCS).reverse()
                .toString();
        int indexStart = strA.indexOf(longestCS);
        int indexEnd = indexStart + longestCS.length();
        Character chA = findMinNextChar(longestCS);
        Character chB = findMinPrevChar(reverseLongestCS);
        StringBuilder middle = findMinChar(chA, chB);
        res
                .append(strA.substring(indexStart, indexEnd))
                .append(middle)
                .append(reverseLongestCS);

        return res.toString();
    }

    private StringBuilder findMinChar(Character a, Character b) {
        StringBuilder res = new StringBuilder();
        if (a != null && (b == null || a < b)) {
            res.append(a);
        } else if (b != null) {
            res.append(b);
        }
        return res;
    }

    private Character findMinNextChar(String subStr) {
        Character ch = null;
        int index = strA.indexOf(subStr);
        while (index != -1) {
            int newCharIndex = index + subStr.length();
            if (newCharIndex < strA.length()
                    && (ch == null || ch > strA.charAt(newCharIndex))) {
                ch = strA.charAt(newCharIndex);
            }
            index = strA.indexOf(subStr, index + 1);
        }
        return ch;
    }

    private Character findMinPrevChar(String subStr) {
        Character ch = null;
        int index = strB.indexOf(subStr);
        while (index != -1) {
            int newCharIndex = index - 1;
            if (newCharIndex >= 0
                    && (ch == null || ch > strB.charAt(newCharIndex))) {
                ch = strB.charAt(newCharIndex);
            }
            index = strB.indexOf(subStr, index + 1);
        }
        return ch;
    }

    private String longestCommonSubString(String b) {
        if (strA == null || b == null || strA.length() == 0 || b.length() == 0) {
            return "";
        }
        if (strA.equals(b)) {
            return strA;
        }
        int[][] matrix = new int[strA.length()][];

        int maxLength = 0;
        int maxI = 0;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[b.length()];
            for (int j = 0; j < matrix[i].length; j++) {
                if (strA.charAt(i) == b.charAt(j)) {
                    if (i != 0 && j != 0) {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    } else {
                        matrix[i][j] = 1;
                    }
                    if (matrix[i][j] > maxLength
                            || (matrix[i][j] == maxLength && strA.substring(
                            maxI - maxLength + 1, maxI + 1).compareTo(
                            strA.substring(i - maxLength + 1, i + 1)) > 0)) {
                        maxLength = matrix[i][j];
                        maxI = i;
                    }
                }
            }
        }
        return strA.substring(maxI - maxLength + 1, maxI + 1);
    }
}
