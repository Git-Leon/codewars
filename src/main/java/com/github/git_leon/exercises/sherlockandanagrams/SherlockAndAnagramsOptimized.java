package com.github.git_leon.exercises.sherlockandanagrams;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 */
public class SherlockAndAnagramsOptimized extends AbstractSherlockAndAnagrams {
    public SherlockAndAnagramsOptimized(String s) {
        super(s);
    }

    public Collection<Pair<String, String>> getAllAnagrammaticPairs() {
        List<Pair<String, String>> result = new ArrayList<>();
        for (int i = 1; i < originalString.length(); i++) {
            String firstSubstring = originalString.substring(i - 1,i+1);
            for (int j = i + 1; j <= originalString.length(); j++) {
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
        return new SherlockAndAnagramsOptimized(s).getAllAnagrammaticPairs().size();
    }
}
