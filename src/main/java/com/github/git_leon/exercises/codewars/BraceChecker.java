package com.github.git_leon.exercises.codewars;

//https://www.codewars.com/kata/5277c8a221e209d3f6000b56/train/java
public class BraceChecker {
    public static void test() {
        System.out.println("\f");
        test("[(])", false);
        test("[()]", true);
    }

    public static void test(String checkStr, boolean expectation) {
        BraceChecker bc = new BraceChecker();
        System.out.println("String = " + checkStr);
        System.out.println("isValid = " + bc.isValid(checkStr));
        System.out.println("expectation = " + expectation);
        System.out.println("\n");
    }

    public boolean isValid(String braces) {
        char[] braceArray = braces.toCharArray();
        for(int i=0;i<braceArray.length;i++) {
            char currentChar = braces.charAt(i);
            if(!isBrace(currentChar)) {
                break;
            }

            if(isClosing(currentChar)) {
                if(prevBrace(braces, i) != getComplementaryBrace(currentChar)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBrace(Character myChar) {
        return "{([])}".contains(myChar.toString());
    }

    public boolean isOpening(Character myChar) {
        return "{([".contains(myChar.toString());
    }

    public boolean isClosing(Character myChar) {
        return "])}".contains(myChar.toString());
    }

    public char nextBrace(String s, int currentIndex) {
        for(;currentIndex < s.length(); currentIndex++) {
            char currentChar = s.charAt(currentIndex);
            if(isBrace(currentChar)) {
                return currentChar;
            }
        }
        return '!';
    }

    public char prevBrace(String s, int currentIndex) {
        for(;currentIndex >= 0; currentIndex--) {
            char currentChar = s.charAt(currentIndex);
            if(isBrace(currentChar)) {
                return currentChar;
            }
        }
        return '!';
    }

    public char getComplementaryBrace(char brace) {        
        switch(brace) {
            case '}':
            return '{';
            case '{':
            return '}';

            case '(':
            return ')';
            case ')':
            return '(';

            case '[':
            return ']';
            case ']':
            return '[';

            default:
            return '!';
        }
    }
}