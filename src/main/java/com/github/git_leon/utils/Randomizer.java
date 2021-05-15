package com.github.git_leon.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Chris on 2/4/2017.
 */

public class Randomizer {
    private static final Random random = new Random();

    public static Float createFloat(float min, float max) {
        return random.nextFloat() * (max - min) + min;
    }

    public static Double createDouble(Double min, Double max) {
        return createFloat(min.floatValue(), max.floatValue()).doubleValue();
    }

    public static Long createLong(Long min, Long max) {
        return createFloat(min, max).longValue();
    }

    public static Integer createInteger(Integer min, Integer max) {
        return createFloat(min, max).intValue();
    }

    public static Character createCharacter(char min, char max) {
        return (char) createInteger((int) min, (int) max).intValue();
    }

    public static <T> T selectElement(T... elements) {
        return elements[createInteger(0, elements.length-1)];
    }

    public static String createString(char min, char max, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(createCharacter(min, max).toString());
        }
        return sb.toString();
    }

    public static String shuffleCasing(String str) {
        StringBuilder sb = new StringBuilder();
        for (String s : str.toLowerCase().split("")) {
            sb.append(createInteger(0, 1) == 0 ? s.toUpperCase() : s.toLowerCase());
        }
        return sb.toString();
    }

    public static String[] shuffleStringArray(String... array) {
        ArrayList<String> list = new ArrayList(Arrays.asList(array));
        Collections.shuffle(list);
        return list.toArray(new String[list.size()]);
    }
}
