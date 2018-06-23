package utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayHandler {

    public static <T> T[] concatenate(@SuppressWarnings("unchecked") T[]... superArray) {
        T[] mergedArray = null;
        for (T[] subArray : superArray) {
            mergedArray = concatenate(mergedArray, subArray);
        }
        return mergedArray;
    }

    private static <T> T[] concatenate(T[] a, T[] b) {
        int aLen = a.length;
        int bLen = b.length;

        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);

        return c;
    }

    public static <T> String toString(T[] array, Character delimiter) {
        StringBuilder sb = new StringBuilder();
        for (T t : array) {
            if (delimiter == null) {
                sb.append(t);
            } else {
                sb.append(delimiter.toString() + t);
            }
        }
        return sb.toString();
    }


    private static <E> ArrayList<E> toArrayList(E[] array) {
        return new ArrayList<E>(Arrays.asList(array));
    }

    @SuppressWarnings("unchecked")
    private static <E> E[] toArray(List<E> list) {
        return list.toArray((E[]) new Object[list.size()]);
    }

}
