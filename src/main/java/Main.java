import exercises.adjacentdigits.AdjacentDigits1;
import exercises.commonstrings.CommonSuffixes1;

/**
 * Created by Chris on 2/4/2017.
 */
public class Main {

    // used to test the code
    public static void main(String[] args) {
        digitTest();
    }

    private static void commonStringTest() {
        CommonSuffixes1 test = new CommonSuffixes1();
//        String largestCommonSubString = test.largestCommonSuffix("123456,123456");
//        System.out.println(largestCommonSubString);
    }

    private static void digitTest() {
        AdjacentDigits1 ad = new AdjacentDigits1();
        String result1 = ad.adjacentDigits(1234567);
        String result2 = ad.adjacentDigits(12467930);

        System.out.println("Input1 = " + 1234567);
        System.out.println("Result1 = " + result1);

        System.out.println("Input2 = " + 12467930);
        System.out.println("Result2 = " + result2);
    }
}
