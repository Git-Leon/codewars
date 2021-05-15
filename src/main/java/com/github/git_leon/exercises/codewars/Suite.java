package com.github.git_leon.exercises.codewars;

public class Suite {

    public static double going(int n) {
        return -1;
    }

    public int f(int x) {
        return 1/factorial(x);
    }

    public int g(int x) {
        int result =0;
        for(int i : range(x)) {
            result += factorial(i);
        }
        return result;
    }

    public int h(int x) {
        return f(x) * g(x);
    }

    public void test(int x) {
        for(int i : range(x)) {        
            System.out.println(h(i));
        }
    }

    public void test() {
        test(100);
    }

    public static void main() {
        Suite obj = new Suite();
        obj.test();
    }

    public int factorial(Integer n) {
        if(n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);	
        }
    }

    public Integer[] range(int n) {
        return range(0, n);
    }

    public Integer[] range(int m, int n) {
        Integer[] array = new Integer[Math.abs(n-m)];
        for(int i=m; i<n; i++) {
            array[i] = i;
        }
        return array;
    }
}