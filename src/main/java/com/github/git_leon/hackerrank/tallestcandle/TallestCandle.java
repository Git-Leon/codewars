package com.github.git_leon.hackerrank.tallestcandle;


import java.util.Collections;
import java.util.List;

public class TallestCandle {
    private List<Integer> candles;
    public TallestCandle(List<Integer> candles) {
        this.candles = candles;
        Collections.sort(this.candles, (val1, val2) -> val2-val1);
    }

    public int count() {
        int count = 0;
        int tallestCandle = candles.get(0);
        for(int candle : candles) {
            if(candle != tallestCandle) {
                break;
            }
            count++;
        }
        return count;
    }

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        return new TallestCandle(candles).count();

    }

}