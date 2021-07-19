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

    /**
     * @param string value to be padded
     * @param n      amount of padding
     * @return string with left padding
     */
    public static String padLeft(String string, int n) {
        return String.format("%1$" + n + "s", string);
    }

    /**
     * @param string value to be padded
     * @param n      amount of padding
     * @return string with right padding
     */
    public static String padRight(String string, int n) {
        return padLeft(string, -n);
    }

    public static boolean isPalindrome(String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }
}
