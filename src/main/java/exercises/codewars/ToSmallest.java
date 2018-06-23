package exercises.codewars;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ToSmallest {
    public static void test() {
        System.out.println("\f");
        int n = 654321;
        int m = n + 100;
        for(int i=n; i<m; i++) {
            test(i);
        }
    }

    private static void test(long n) {
        System.out.println("\n\ninput = " + n);
        System.out.println("output = " + toLong(smallest(n)));	
    }

    private static long toLong(long[] longs) {
        StringBuilder sb = new StringBuilder();
        for(long l : longs) {
            sb.append(l);
        }
        return Long.parseLong(sb.toString());
    }

    public static long[] smallest(long n) {        
        StringBuilder result = new StringBuilder();
        for(String digit : sortArrayAscending(toStringArray(n))) {
            result.append(digit);
        }
        return toLongArray(result.toString());
    }

    private static long[] toLongArray(String s) {
        Long l = new Long(Long.parseLong(s));
        char[] chars = l.toString().toCharArray();
        long[] longs = new long[chars.length];
        for(int i=0; i<longs.length; i++) {
            String val = Character.toString(chars[i]);
            longs[i] = Long.parseLong(val);
        }
        return longs;
    }

    private  static <E> E[] sortArrayDescending(E[] array) {
        return reverseArray(sortArrayAscending(array));    
    }

    private  static <E> E[] sortArrayAscending(E[] array) {
        Arrays.sort(array);
        return array;
    }

    private  static <E> E[] reverseArray(E[] array) {
        ArrayList<E> list = toArrayList(array);
        Collections.reverse(list);
        return toArray(list);
    }

    private  static <E> ArrayList<E> toArrayList(E[] array) {
        return new ArrayList<E>(Arrays.asList(array));
    }

    @SuppressWarnings("unchecked")
    private  static <E> E[] toArray(List<E> list) {
        return list.toArray((E[]) new Object[list.size()]);
    }

    private  static String[] toStringArray(long l) {
        String digits = new Long(l).toString();
        String[] characters = new String[digits.length()];
        for(int i =0; i<digits.length(); i++){
            characters[i] = Character.toString(digits.charAt(i));
        }
        return characters;
    }
}