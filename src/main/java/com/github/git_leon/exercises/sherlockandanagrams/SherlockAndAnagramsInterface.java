package com.github.git_leon.exercises.sherlockandanagrams;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Collection;

public interface SherlockAndAnagramsInterface {
    Collection<Pair<String, String>> getAllAnagrammaticPairs();

    default Integer solve() {
        return getAllAnagrammaticPairs().size();
    }

    default boolean isAnagram(String value1, String value2) {
        char[] charArray1 = value1.toCharArray();
        char[] charArray2 = value2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }
}
