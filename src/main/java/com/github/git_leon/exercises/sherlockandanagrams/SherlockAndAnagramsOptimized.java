package com.github.git_leon.exercises.sherlockandanagrams;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 */
public class SherlockAndAnagramsOptimized {
    private final String originalString;

    public SherlockAndAnagramsOptimized(String s) {
        this.originalString = s;
    }

    public Collection<Pair<String, String>> solve() {
        List<Pair<String, String>> result = new ArrayList<>();
        for (int i = 1; i < originalString.length(); i++) {
            String prevSubstring = originalString.substring(i-1);
            for (int j = i + 1; j <= originalString.length(); j++) {
                String nextSubstring = originalString.substring(i, j);
                if (isAnagram(prevSubstring, nextSubstring)) {
                    result.add(new Pair<>(prevSubstring, nextSubstring));
                }
            }
        }
        return result;
    }

    private boolean isAnagram(String value1, String value2) {
        char[] charArray1 = value1.toCharArray();
        char[] charArray2 = value2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }
    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        return new SherlockAndAnagramsOptimized(s).solve().size();
    }
}
