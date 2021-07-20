package com.github.git_leon.exercises.buildpalindrome;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/challenging-palindromes/problem
 */
public class BuildPalindrome {
    private String a;
    private String b;

    public BuildPalindrome(String a, String b) {
        this.a = a;
        this.b = b;
    }

    private boolean isPalindromic(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    private List<String> getAllSubstrings(String s) {
        List<String> result = new ArrayList<>(s.length() * s.length());
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
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
        for (String substringA : getAllSubstrings(a)) {
            for (String substringB : getAllSubstrings(b)) {
                String potentialAddition = substringA + substringB;
                if (isPalindromic(potentialAddition)) {
                    set.add(potentialAddition);
                }

                potentialAddition = substringB + substringA;
                if (isPalindromic(potentialAddition)) {
                    set.add(potentialAddition);
                }
            }
        }
        return set;
    }

    @Override
    public String toString() {
        List<String> palindromicProducts = new ArrayList<>(getAllPalindromicProducts());
        palindromicProducts.sort((string1, string2) -> {
            int lengthDelta = string1.length() - string2.length();
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
        return new BuildPalindrome(a, b).toString();
    }
}
