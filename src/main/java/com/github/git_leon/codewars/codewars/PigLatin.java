package com.github.git_leon.codewars.codewars;

public class PigLatin{

    public String translate(String str){
        Character firstChar = str.charAt(0);
        if(!isAlphaString(str)) {
            return null;
        } else if (isVowel(firstChar)) {
            str = str + "way";
        } else {
            for(int i=0; i<str.length(); i++) {
                if(isVowel(firstChar)) {
                    break;
                } else {
                    str = str.replaceFirst(firstChar.toString(), "");
                    str = str + firstChar;
                    firstChar = str.charAt(0);
                }
            }
            str = str + "ay";
        }
        return str.toLowerCase();
    }

    // return true if the specified character is a vowel
    private boolean isVowel(Character c) {
        return in(c, "aeiou");
    }

    // return true if the specified character is an alpha-character
    private boolean isAlphaChar(Character c) {
        return in(c, "abcdefghijklmnopqrstuvwxyz");
    }

    // return true if the specified String contains only alpha characters
    private boolean isAlphaString(String characters) {
        for(Character c : characters.toCharArray()) {
            if(!isAlphaChar(c)) {
                return false;
            }
        }
        return true;
    }

    // return true if the specified String contains the specified character
    private boolean in(Character c, String characters) {
        return characters.toLowerCase().contains(c.toString().toLowerCase());
    }

    public static void test(String s) {
        PigLatin pl = new PigLatin();
        System.out.println(pl.translate(s));
    }
}