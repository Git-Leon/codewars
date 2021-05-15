package com.github.git_leon.exercises.codewars;

//https://www.codewars.com/kata/consecutive-strings/train/java
class LongestConsec {
    public static String longestConsec(String[] strarr, int k) {
        try {
            String longest = getLongestString(strarr);
            int longestIndex = getIndexOf(strarr, longest);
            String result = strarr[longestIndex] ;
            for(int i=1; i<k;i++) {
                result += strarr[longestIndex + i];
            }
            return result;
        } catch(Exception e) {
            return "";
        }
    }

    public static String getLongestString(String[] strarr) {
        Integer longestLength = null;
        Integer currentLength = null;
        String longestString = null;
        for(String s : strarr) {
            currentLength = s.length();
            if(longestLength == null || longestLength < currentLength) {
                longestString = s;
                longestLength = currentLength;
            }
        }
        return longestString;
    }

    public static int getIndexOf(String[] strarr, String myString) {
        for(int i=0; i<strarr.length; i++) {
            if(strarr[i].equals(myString)) {
                return i;
            }
        }
        return -1;
    }

    public static void test(String[] input, int k, String output) {
        String result = longestConsec(input, k);	
        System.out.println("Result =\t" + result);
        System.out.println("Expected =\t" + output);
        System.out.println("Success =\t" + result.equals(output));
    }

    public static void test() {
        System.out.println("\f");
        String[] array1 = {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"};
        String output1 = "abigailtheta";
        int k1 = 2;

        String[] array2 = {"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"};
        String output2 = "oocccffuucccjjjkkkjyyyeehh";
        int k2 = 1;

        String[] array3 = {"itvayloxrp","wkppqsztdkmvcuwvereiupccauycnjutlv","vweqilsfytihvrzlaodfixoyxvyuyvgpck"};
        String output3 = "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck";
        int k3 = 2;

        String[] array4 = {"wlwsasphmxx","owiaxujylentrklctozmymu","wpgozvxxiu"};
        String output4 = "wlwsasphmxxowiaxujylentrklctozmymu";
        int k4 = 2;

        test(array1, k1, output1);
        test(array2, k2, output2);
        test(array3, k3, output3);
        test(array4, k4, output4);
    }
}