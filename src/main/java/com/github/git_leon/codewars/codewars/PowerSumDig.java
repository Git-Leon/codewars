package com.github.git_leon.codewars.codewars;

import java.util.HashMap;
import java.util.ArrayList;
public class PowerSumDig {
    public static HashMap<Integer, Long> foundValues = new HashMap<Integer, Long>();
    public static void test() {
        System.out.println('\f');
        test(12);
    }

    public static void test(int n) {
        System.out.format("\n\n\npowerSumDigTerm(%s) = %s", n, powerSumDigTerm(n));
    }

    public static long powerSumDigTermm(int n) {
        Long lcd = null;
        Long gcd = null;
        long val = 54;
        printDivisors(val);
        ArrayList<Long> divisors = null;
        for(int i=0; i<n; i++) {
            divisors = getDivisors(val);
            lcd = divisors.get(0);
            gcd = divisors.get(divisors.size()-1);
            val = lcd  * gcd;
        }
        return val;
    }

    public static long powerSumDigTerm(int n) {
        int seriesIndex = 0;
        long jthDegree = -1;
        for(long val=10;true;val++) {

            if(isValid(val)){
                foundValues.put(seriesIndex, val);
                seriesIndex++;
                System.out.format("\n\nindex = %s\nval = %s", seriesIndex, val);
                printDivisors(val);
                if(seriesIndex > n) {
                    break;
                }
                if(seriesIndex == n) {
                    return val;
                }
            }
        }
        return -1;
    }

    public static boolean isValid(long val) {
        return divisorCheck1(val) && checkPow(val);
    }

    public static boolean divisorCheck1(long val) {
        if(val%2==0) {
            return true;
        }
        Long lcd = null;
        Long gcd = null;
        ArrayList<Long> divisors = getDivisors(val);
        int count = divisors.size();
        if(count >= 1) {
            lcd = divisors.get(0);
            gcd = divisors.get(divisors.size()-1);
            long product = lcd  * gcd;
            return product == val;
        }
        return false;
    }

    public static boolean checkPow(long val) {
        long sum = digitSum(val);
        long jthDegree = -1;

        for(int j=2; jthDegree<val&& sum > 1; j++) {         
            jthDegree = (long)Math.pow(sum,j);
            if(jthDegree == val) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidd(long i) {
        long sum = digitSum(i);
        long jthDegree = -1;

        for(int j=2; jthDegree<i && sum > 1; j++) {         
            jthDegree = (long)Math.pow(sum,j);
            if(jthDegree == i) {
                return true;
            }
        }
        return false;
    }

    public static void printDivisors(long n) {
        ArrayList<Long> divisors = getDivisors(n);
        for(int i=0;i<divisors.size();i++) {            
            System.out.format("\n%s\t\t\t%s", i, divisors.get(i).toString());
        }
    }

    public static ArrayList<Long> getDivisors(long num) {
        ArrayList<Long> divisors = new ArrayList<Long>();
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                divisors.add(new Long(i));
            }
        }
        return divisors;
    }

    public static long digitSum(Long l) {
        long sum = 0;
        for(Character c : l.toString().toCharArray()) {
            sum += Long.parseLong(c.toString());
        }
        return sum;
    }
}
