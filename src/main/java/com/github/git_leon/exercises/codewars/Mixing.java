package com.github.git_leon.exercises.codewars;//https://www.codewars.com/kata/5629db57620258aa9d000014/train/java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Mixing {

    public static String mix(String s1, String s2) {
        StringBuilder builder = new StringBuilder();
        //String s3 = removeChars(sortString(s1+s2), " ");//*!@#$%^&{[()]}_+|\\,./<>?;`");
        String s3 = sortString(removeNonAlphas(s1 + s2));//*!@#$%^&{[()]}_+|\\,./<>?;`");
        for (char c : uniqueCharacters(s3)) {
            Integer s1Count = countInstances(s1, c);
            Integer s2Count = countInstances(s2, c);
            if (s1Count <= 1 && s2Count <= 1) {
                continue;
            }

            if (s1Count > s2Count) {
                builder.append(createString("1", c, s1Count));
            } else if (s1Count < s2Count) {
                builder.append(createString("2", c, s2Count));
            } else {
                builder.append(createString("=", c, s1Count));
            }
        }

        try {
            String[] delimitedString = builder.substring(0, builder.length() - 1).toString().split("/");
            Arrays.sort(delimitedString, myComparator());
            return String.join("/", delimitedString);
        } catch (Exception e) {
            return "";
        }
    }

    private static String removeNonAlphas(String base) {
        try {
            String alpha = "abcdefghijklmnopqrstuvwxyz";
            for (Character c : base.toLowerCase().toCharArray()) {
                String s = c.toString();
                if (!alpha.contains(s)) {
                    base = base.replaceAll(s, "");
                }
            }
        } catch (Exception e) {
        }
        return base;
    }

    private static String removeChars(String base, String removeables) {
        try {
            for (Character c : removeables.toCharArray()) {
                base = base.replaceAll(c.toString(), "");
            }
            return base;
        } catch (Exception e) {
            return base;
        }
    }

    private static Comparator<String> myComparator() {
        return new Comparator<String>() {
            public int compare(String s1, String s2) {
                int compareLength = Integer.compare(s1.length(), s2.length()) * -1;
                return compareLength == 0 ? s1.compareTo(s2) : compareLength;
            }
        };
    }

    private static String sortString(String s) {
        char[] array = new char[s.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = s.charAt(i);
        }
        Arrays.sort(array);
        return new String(array);
    }

    private static String createString(String prefix, char character, Integer stringCount) {
        return String.format("%s:%s/", prefix.toString(), repeatCharacter(character, stringCount));
    }

    private static String repeatCharacter(char c, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static Integer countInstances(String s, Character val) {
        int count = 0;
        ArrayList<Character> list = toCharacterArrayList(s);
        for (Character c : uniqueCharacters(s)) {
            while (list.contains(val)) {
                count++;
                list.remove(val);
            }
        }
        return count;
    }

    private static ArrayList<Character> uniqueCharacters(String s) {
        ArrayList<Character> characters = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (!characters.contains(currentChar)) {
                characters.add(s.charAt(i));
            }
        }
        return characters;
    }

    private static ArrayList<Character> toCharacterArrayList(String s) {
        ArrayList<Character> characters = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            characters.add(s.charAt(i));
        }
        return characters;
    }
}