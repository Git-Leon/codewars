package exercises.piglatin;

public class PigLatin1 {
    public String translate(String str) {
        Character firstChar = str.charAt(0);
        if (!isAlphaString(str)) {
            return null;
        } else if (isVowel(firstChar)) {
            str += "way";
        } else {
            for (int i = 0; i < str.length() && !isVowel(firstChar); i++) {
                str = str.replaceFirst(firstChar.toString(), "") + firstChar;
                firstChar = str.charAt(0);
            }
            str += "ay";
        }
        return str.toLowerCase();
    }

    private boolean isAlphaString(String characters) {
        for (Character c : characters.toCharArray())
            if (!in(c, "abcdefghijklmnopqrstuvwxyz")) return false;
        return true;
    }

    private boolean isVowel(Character c) {
        return in(c, "aeiou");
    }

    private boolean in(Character c, String characters) {
        return characters.toLowerCase().contains(c.toString().toLowerCase());
    }
}