package com.github.git_leon.utils;

/**
 * Created by Chris on 3/31/2017.
 */
public class StringTwister {
    public static String upperCaseFirstCharacter(String originalString) {
        String firstChar = "" + originalString.charAt(0);
        return originalString.replaceFirst(firstChar, firstChar.toUpperCase());
    }

    public static String camelCase(String originalString, Character delimiter) {
        String[] phrases = originalString.split(delimiter.toString());
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<phrases.length;i++) {
            phrases[i] = upperCaseFirstCharacter((phrases[i]));
        }
        return ArrayHandler.toString(phrases, delimiter);
    }

    public static boolean isPalindrome(String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }
}
