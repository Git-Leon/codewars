package com.github.git_leon.exercises.sherlockandanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 */
public class SherlockAndAnagrams {
    private final String originalString;

    public SherlockAndAnagrams(String s) {
        this.originalString = s;
    }

    public List<String> getAllSubstrings() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < originalString.length(); i++) {
            for (int j = 0; j < originalString.length(); j++) {
                result.add(originalString.substring(i, j));
            }
        }
        return result;
    }

    public List<String> solve() {
        List<String> allSubStringList = getAllSubstrings();
        List<String> allSubstringsToBeRemoved = new ArrayList<>(allSubStringList);
        List<String> result = new ArrayList<>();
        for (String substring1 : allSubStringList) {
            allSubstringsToBeRemoved.remove(substring1);
            if (allSubstringsToBeRemoved.contains(substring1)) {
                result.add(substring1);
                continue;
            }
            for (String substring2 : allSubstringsToBeRemoved) {
                if (isAnagram(substring1, substring2)) {
                    result.add(substring1);
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
        return new SherlockAndAnagrams(s).solve().size();
    }
}
