package exercises.commonstrings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Created by Chris on 3/31/2017.
 */
public class CommonSuffixes1 implements CommonSuffixesInterface {
    public String largestCommonSuffix(String s1, String s2) {
        ArrayList<String> suffixes1 = getSuffixes(s1);
        ArrayList<String> suffixes2 = getSuffixes(s2);
        ArrayList<String> commonStrings = getCommonStrings(suffixes1, suffixes2);
        try {
            return commonStrings.stream().max(Comparator.comparingInt(String::length)).get();
        } catch (NoSuchElementException nsee) {
            return null;
        }
    }

    // returns list that represents common values between two specified arrays
    private ArrayList<String> getCommonStrings(ArrayList<String> array1, ArrayList<String> array2) {
        ArrayList<String> commonStrings = new ArrayList<String>();
        for (String s1 : array1) {
            for (String s2 : array2) {
                if (s1.equals(s2)) {
                    commonStrings.add(s1);
                }
            }
        }
        return commonStrings;
    }

    // returns a list of all suffixes of the specified word
    private ArrayList<String> getSuffixes(String word) {
        ArrayList<String> suffixes = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            String suffix = getLastNCharacters(word, i + 1);
            suffixes.add(suffix);
        }
        return suffixes;
    }

    // returns the last n characters of the specified string
    // used to get suffixes of a specified string
    private String getLastNCharacters(String word, int n) {
        return word.substring(word.length() - n);
    }
}