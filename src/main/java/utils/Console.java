package utils;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static void print(String val, Object... args) {
        System.out.format(val, args);
    }

    public static void println(String val, Object... args) {
        print(val + "\n", args);
    }

    public static String getStringInput(String prompt, Object... args) {
        println(prompt, args);
        return scanner.nextLine();
    }

    public static Float getFloatInput(String prompt, Object... args) {
        final String stringInput = getStringInput(prompt, args);
        try {
            return Float.parseFloat(stringInput);
        } catch (NumberFormatException nfe) {
            println("[ %s ] is an invalid input!", stringInput);
            println("Try inputting a numeric value!");
            return getFloatInput(prompt, args);
        }
    }

    public static Long getLongInput(String prompt, Object... args) {
        final String stringInput = getStringInput(prompt, args);
        try {
            return Long.parseLong(stringInput);
        } catch (NumberFormatException nfe) {
            println("[ %s ] is an invalid input!", stringInput);
            println("Try inputting an integer value!");
            return getLongInput(prompt, args);
        }
    }

    public static Integer getIntegerInput(String prompt, Object... args) {
        return getLongInput(prompt, args).intValue();
    }

    public static Double getDoubleInput(String prompt, Object... args) {
        return getFloatInput(prompt, args).doubleValue();
    }

    public static void repeatPrint(int numberOfRepeats, String val, Object... args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfRepeats; i++) {
            sb.append(String.format(val, args));
        }
        print(sb.toString());
    }
}