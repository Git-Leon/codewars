package com.github.git_leon.exercises.sherlockandanagrams;

import java.util.Arrays;

//https://github.com/shivam04/hackerrank/blob/master/sherlock-and-anagrams.java
public class SherlockAndAnagramsShivam implements SherlockAndAnagramsInterface {
    String s;

    public SherlockAndAnagramsShivam(String s) {
        this.s = s;
    }



    private boolean isAnagram(String value1, String value2) {
        char[] charArray1 = value1.toCharArray();
        char[] charArray2 = value2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }

    public Integer solve() {
        char[] sa;
        sa = s.toCharArray();
        int c = 0;
        for (int index = 1; index < sa.length; index++) {
            for (int i = 0; i < sa.length - index + 1; i++) {
                String s1 = s.substring(i, index + i);
                for (int j = i + 1; j < sa.length - index + 1; j++) {
                    String s2 = s.substring(j, index + j);
                    if (isAnagram(s1, s2))
                        c++;
                }
            }
        }
        return c;
    }
}
