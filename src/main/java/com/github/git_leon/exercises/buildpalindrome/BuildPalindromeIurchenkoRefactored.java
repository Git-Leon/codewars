package com.github.git_leon.exercises.buildpalindrome;

// https://github.com/mariiaiurchenko/hackerrank/blob/master/HakerRank/src/main/java/com/spring/tutorial/HakerRank/strings/BuildAPalindrome.java
public class BuildPalindromeIurchenkoRefactored implements BuildPalindromeInterface {
    private final String strA;
    private final String strB;

    public BuildPalindromeIurchenkoRefactored(String value1, String value2) {
        this.strA = value1;
        this.strB = value2;
    }

    public String toString() {
        String reverseStrB = new StringBuilder(strB).reverse().toString();
        String longestCS = longestCommonSubString(strA, reverseStrB);
        if (longestCS.length() <= 0) {
            return "-1";
        }

        String reverseLongestCS = new StringBuilder(longestCS).reverse().toString();
        int indexStart = strA.indexOf(longestCS);
        int indexEnd = indexStart + longestCS.length();
        Character chA = findMinNextChar(strA, longestCS);
        Character chB = findMinPrevChar(strB, reverseLongestCS);
        String middle = findMinChar(chA, chB);
        return strA
                .substring(indexStart, indexEnd)
                .concat(middle)
                .concat(reverseLongestCS);
    }

    private String findMinChar(Character a, Character b) {
        if (a != null && (b == null || a < b)) {
            return a.toString();
        } else if (b != null) {
            return b.toString();
        }
        return "";
    }

    private Character findMinNextChar(String strA, String subStr) {
        Character ch = null;
        int index = strA.indexOf(subStr);
        while (index != -1) {
            int newCharIndex = index + subStr.length();
            if (newCharIndex < strA.length()
                    && (ch == null || ch > strA.charAt(newCharIndex))) {
                ch = strA.charAt(newCharIndex);
            }
            index = strA.indexOf(subStr, index + 1);
        }
        return ch;
    }

    private Character findMinPrevChar(String strB, String subStr) {
        Character ch = null;
        int index = strB.indexOf(subStr);
        while (index != -1) {
            int newCharIndex = index - 1;
            if (newCharIndex >= 0
                    && (ch == null || ch > strB.charAt(newCharIndex))) {
                ch = strB.charAt(newCharIndex);
            }
            index = strB.indexOf(subStr, index + 1);
        }
        return ch;
    }


    private String longestCommonSubString(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return "";
        }
        if (a.equals(b)) {
            return a;
        }
        int firstDimensionSize = a.length();
        int[][] matrix = new int[firstDimensionSize][];

        int maxLength = 0;
        int maxI = 0;

        for (int columnNumber = 0; columnNumber < matrix.length; columnNumber++) {
            int secondDimensionSize = b.length();
            matrix[columnNumber] = new int[secondDimensionSize];
            for (int rowNumber = 0; rowNumber < matrix[columnNumber].length; rowNumber++) {
                Character characterA = a.charAt(columnNumber);
                Character characterB = b.charAt(rowNumber);
                boolean isSameCharacter = characterA.equals(characterB);
                if (isSameCharacter) {
                    if (columnNumber != 0 && rowNumber != 0) {
                        int previousColumnNumber = columnNumber - 1;
                        int previousRowNumber = rowNumber - 1;
                        int previousCellValue = matrix[previousColumnNumber][previousRowNumber];
                        int currentCellValue = previousCellValue + 1;
                        matrix[columnNumber][rowNumber] = currentCellValue;
                    } else {
                        matrix[columnNumber][rowNumber] = 1;
                    }
                    String substring1 = a.substring(maxI - maxLength + 1, maxI + 1);
                    String substring2 = a.substring(columnNumber - maxLength + 1, columnNumber + 1);
                    int currentCellValue = matrix[columnNumber][rowNumber];

                    boolean isCurrentCellValueGreaterThanMaxLength = currentCellValue > maxLength;
                    boolean isCurrentCellValueEqualToMaxLength = currentCellValue == maxLength;
                    boolean isGreaterThanSubstring2 = substring1.compareTo(substring2) > 0;
                    if (isCurrentCellValueGreaterThanMaxLength || (isCurrentCellValueEqualToMaxLength && isGreaterThanSubstring2)) {
                        maxLength = currentCellValue;
                        maxI = columnNumber;
                    }
                }
            }
        }
        return a.substring(maxI - maxLength + 1, maxI + 1);
    }

    public static String buildPalindrome(String a, String b) {
        return new BuildPalindromeIurchenkoRefactored(a, b).toString();
    }
}
