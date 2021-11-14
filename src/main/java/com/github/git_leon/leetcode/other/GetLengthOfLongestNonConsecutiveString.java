package com.github.git_leon.leetcode.other;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class GetLengthOfLongestNonConsecutiveString {
    public int lengthOfLongestSubstring(String s) {
        return getNonConsecutiveSubStrings(s)// remove consecutive duplicates
                .stream()
                .sorted((s2, s1) -> s1.length() - s2.length()) // sort by length
                .collect(Collectors.toList())
                .get(0) // fetch first element
                .length(); // fetch length
    }

    public List<String> getNonConsecutiveSubStrings(String input) {
        return getAllSubStrings(input)
                .stream()
                .filter(currentString -> hasConsecutiveDuplicates(currentString))
                .collect(Collectors.toList());
    }

    public boolean hasRepeatingCharacters(String input) {
        List<String> characters = Arrays.asList(input.split(""));
        String nonUniqueCharacters = characters.toString();
        String uniqueCharacters = new HashSet<>(characters).toString();
        System.out.println(nonUniqueCharacters);
        System.out.println(uniqueCharacters);
        return !nonUniqueCharacters.equals(uniqueCharacters);
    }

    public boolean hasConsecutiveDuplicates(String str) {
        for (int i = 1; i < str.length(); i++) {
            char previousChar = str.charAt(i - 1);
            char currentChar = str.charAt(i);
            if (previousChar == currentChar) {
                return true;
            }
        }
        return false;
    }

    public List<String> getAllSubStrings(String originalString) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < originalString.length(); i++) {
            for (int j = i + 1; j <= originalString.length(); j++) {
                result.add(originalString.substring(i, j));
            }
        }
        return result;
    }

}
