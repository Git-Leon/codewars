package com.github.git_leon.exercises.codewars;

import com.github.git_leon.utils.Utils;

public class CodeWars {
    public static void test() {
        System.out.println('\f');   
        long t0 = System.nanoTime();

        test("Are they here", "yes, they are here","2:eeeee/2:yy/=:hh/=:rr");
        test("looping is fun but dangerous", "less dangerous than coding","1:ooo/1:uuu/2:sss/=:nnn/1:ii/2:aa/2:dd/2:ee/=:gg");
        test(" In many languages", " there's a pair of functions","1:aaa/1:nnn/1:gg/2:ee/2:ff/2:ii/2:oo/2:rr/2:ss/2:tt");
        test("codewars", "codewars", "");
        test("Lords of the Fallen", "gamekult","1:ee/1:ll/1:oo");
        test("A generation must confront the looming ", "codewarrs","1:nnnnn/1:ooooo/1:tttt/1:eee/1:gg/1:ii/1:mm/=:rr");
        test("%ghjp=cptu'bfwnCzogyComflDxyva", "jetjXuinnMoaji%odyx+xmiw@pkln", "");

        Utils.printElapsedTime(t0);
    }

    private static void test(String s1, String s2, String expected) {             
        long t0 = System.nanoTime();

        String result = Mixing.mix(s1,s2);        

        double elapsedTime = Utils.getElapsedTime(t0);
        System.out.println("S1\t\t= " + s1);
        System.out.println("S2\t\t= " + s2);
        System.out.println("Result\t\t= " + result);
        System.out.println("Expected\t= " + expected);
        System.out.println("Elapsed time\t= " + elapsedTime + " milliseconds");
        System.out.println("Success\t\t= " + result.equals(expected));
        System.out.println("\n");
    }

    public <E> String myAbstractMethod(E... args) {
        return null;
    }

    public static void main(String[] args) {
        CodeWars obj = new CodeWars();
    }
}
