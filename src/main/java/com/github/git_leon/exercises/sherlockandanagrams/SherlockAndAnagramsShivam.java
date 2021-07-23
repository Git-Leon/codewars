package com.github.git_leon.exercises.sherlockandanagrams;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//https://github.com/shivam04/hackerrank/blob/master/sherlock-and-anagrams.java
public class SherlockAndAnagramsShivam extends AbstractSherlockAndAnagrams {
    public SherlockAndAnagramsShivam(String s) {
        super(s);
    }

    public Collection<Pair<String, String>> getAllAnagrammaticPairs() {
        List<Pair<String, String>> result = new ArrayList<>();
        int originalStringLength = originalString.length();
        for (int index = 1; index < originalStringLength; index++) {
            for (int i = 0; i < originalStringLength - index + 1; i++) {
                String firstSubstring = originalString.substring(i, index + i);
                for (int j = i + 1; j < originalStringLength - index + 1; j++) {
                    String nextSubstring = originalString.substring(j, index + j);
                    if (isAnagram(firstSubstring, nextSubstring))
                        result.add(new Pair<>(firstSubstring, nextSubstring));
                }
            }
        }
        return result;
    }
}
