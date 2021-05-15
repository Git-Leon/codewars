package com.github.git_leon.exercises.organizelater;

import java.util.ArrayList;

/**
 * Created by Chris on 4/1/2017.
 */
/**
 * Write a description of class a here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PalindromeCounter {

    public int getNumberOfPalindromes(String s) {
        return getAllPalindromes(s).size();
    }

    public ArrayList<String> getAllPalindromes(String s) {
        ArrayList<String> palindromes = new ArrayList<String>();
        for(String substring : getAllSubstrings(s)) {
            boolean isPalindrome = new StringBuffer(substring).reverse().toString().equals(substring);
            if(isPalindrome(substring)) {
                palindromes.add(substring);
            }
        }
        return palindromes;
    }

    // http://stackoverflow.com/questions/8444710/easiest-way-to-check-if-a-string-is-palindrome
    public boolean isPalindrome(String s) {
        int n = s.length();
        for (int i=0;i<(n / 2);++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // http://www.programmingsimplified.com/java/source-code/java-program-find-substrings-of-string
    public ArrayList<String> getAllSubstrings(String string) {
        ArrayList<String> subStrings = new ArrayList<String>();
        int length = string.length();
        for(int c = 0 ; c < length ; c++ ) {
            for(int i = 1 ; i <= length - c ; i++ ) {
                subStrings.add(string.substring(c, c+i));
            }
        }
        return subStrings;
    }
}

