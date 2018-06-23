package utilitytests;

import org.junit.Before;
import org.junit.Test;
import utils.Console;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Chris on 2/4/2017.
 */
public class ConsoleTest {
    @Before
    public void setup() {
        setInput("5.0");
    }

    @Test
    public void testFloat() {
        assertEquals(5F, Console.getFloatInput("Input float").floatValue(), 0);
    }

    @Test
    public void testDouble() {
        assertEquals(5.0, Console.getDoubleInput("Input double").doubleValue(), 0);
    }

    @Test
    public void testLong() {
        assertEquals(5L, Console.getLongInput("Input long").longValue(), 0);
    }

    @Test
    public void testInteger() {
        assertEquals(5, Console.getIntegerInput("Input integer").intValue(), 0);
    }

    @Test
    public void testString() {
        assertEquals("5", Console.getStringInput("Input string"), 0);
    }


    public String setInput(String expected) {
        Console.print("Setting input...");
        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        return expected;
    }
}
