package com.github.git_leon.exercises.buildpalindrome;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/challenging-palindromes/problem
 */
public class BuildPalindromeOptimized  implements BuildPalindromeInterface {
    private final String a;
    private final String b;

    public BuildPalindromeOptimized(String a, String b) {
        this.a = a;
        this.b = b;
    }

    private boolean isPalindromic(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    private List<String> getAllSubstrings(String s) {
        int n = s.length();
        List<String> result = new ArrayList<>(n * n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                result.add(s.substring(i, j));
            }
        }
        return result;
    }

    public Set<String> getAllPalindromicProducts() {
        Set<String> set = new HashSet<String>() {
            @Override
            public String toString() {
                StringJoiner sj = new StringJoiner("\n");
                for (String element : this) {
                    sj.add(element);
                }
                return sj.toString();
            }
        };
        String longestCommonSubString = getLongestCommonSubstring();
        List<String> allSubstrings = getAllSubstrings(longestCommonSubString);
        for (String potentialAddition : allSubstrings) {
            if (isPalindromic(potentialAddition)) {
                set.add(potentialAddition);
            }
        }
        return set;
    }

    private String getLongestCommonSubstring() {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return "";
        }
        if (a.equals(b)) {
            return a;
        }
        int[][] matrix = new int[a.length()][];

        int maxLength = 0;
        int maxI = 0;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[b.length()];
            for (int j = 0; j < matrix[i].length; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (i != 0 && j != 0) {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    } else {
                        matrix[i][j] = 1;
                    }
                    if (matrix[i][j] > maxLength
                            || (matrix[i][j] == maxLength && a.substring(
                            maxI - maxLength + 1, maxI + 1).compareTo(
                            a.substring(i - maxLength + 1, i + 1)) > 0)) {
                        maxLength = matrix[i][j];
                        maxI = i;
                    }
                }
            }
        }
        return a.substring(maxI - maxLength + 1, maxI + 1);
    }


    @Override
    public String toString() {
        List<String> palindromicProducts = new ArrayList<>(getAllPalindromicProducts());
        palindromicProducts.sort((string1, string2) -> {
            int lengthDelta = string2.length() - string1.length();
            if (lengthDelta == 0) {
                return string1.compareTo(string2);
            }
            return lengthDelta;
        });
        if (palindromicProducts.size() == 0) {
            return "-1";
        }
        return palindromicProducts.get(0);
    }

    /*
     * Complete the 'buildPalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */
    public static String buildPalindrome(String a, String b) {
        return new BuildPalindromeOptimized(a, b).toString();
    }
}
