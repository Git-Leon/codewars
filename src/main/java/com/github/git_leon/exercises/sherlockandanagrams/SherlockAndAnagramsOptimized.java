package com.github.git_leon.exercises.sherlockandanagrams;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 */
public class SherlockAndAnagramsOptimized implements SherlockAndAnagramsInterface {
    private final String originalString;

    public SherlockAndAnagramsOptimized(String s) {
        this.originalString = s;
    }

    public Integer solve() {
        return getAllAnaGrammaticPairs().size();
    }

    private boolean isAnagram(String value1, String value2) {
        char[] charArray1 = value1.toCharArray();
        char[] charArray2 = value2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }

    public Collection<Pair<String, String>> getAllAnaGrammaticPairs() {
        List<Pair<String, String>> result = new ArrayList<>();
        for (int i = 1; i < originalString.length(); i++) {
            int j = i + 1;
            String firstSubstring = originalString.substring(i - 1, j - 1);
            for (; j <= originalString.length(); j++) {
                String nextSubstring = originalString.substring(i, j);
                if (isAnagram(firstSubstring, nextSubstring)) {
                    result.add(new Pair<>(firstSubstring, nextSubstring));
                }
            }
        }
        return result;
    }
    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        return new SherlockAndAnagramsOptimized(s).getAllAnaGrammaticPairs().size();
    }
}
