package utilitytests;

import org.junit.Assert;
import org.junit.Test;
import utils.Randomizer;

/**
 * Created by Chris on 3/22/2017.
 */
public class RandomizerTest {
    private Float min = 0.0F;
    private Float max = 10.0F;


    @Test
    public void testCreateFloat() {
        for (int i = 0; i < 1000; i++) {
            float randomDouble = Randomizer.createFloat(min, max);
            boolean greaterThanMin = randomDouble >= min;
            boolean lesserThanMax = randomDouble <= max;
            boolean outcome = greaterThanMin && lesserThanMax;
            Assert.assertEquals(true, outcome);
        }
    }


    @Test
    public void testCreateDouble() {
        for (int i = 0; i < 1000; i++) {
            double min = this.min.doubleValue();
            double max = this.max.doubleValue();
            double randomDouble = Randomizer.createDouble(min, max);
            boolean greaterThanMin = randomDouble >= min;
            boolean lesserThanMax = randomDouble <= max;
            boolean outcome = greaterThanMin && lesserThanMax;
            Assert.assertEquals(true, outcome);
        }
    }


    @Test
    public void testCreateInteger() {
        for (int i = 0; i < 1000; i++) {
            int min = this.min.intValue();
            int max = this.max.intValue();
            long randomDouble = Randomizer.createInteger(min, max);
            boolean greaterThanMin = randomDouble >= min;
            boolean lesserThanMax = randomDouble <= max;
            boolean outcome = greaterThanMin && lesserThanMax;
            Assert.assertEquals(true, outcome);
        }
    }


    @Test
    public void testCreateLong() {
        for (int i = 0; i < 1000; i++) {
            long min = this.min.longValue();
            long max = this.max.longValue();
            long randomDouble = Randomizer.createLong(min, max);
            boolean greaterThanMin = randomDouble >= min;
            boolean lesserThanMax = randomDouble <= max;
            boolean outcome = greaterThanMin && lesserThanMax;
            Assert.assertEquals(true, outcome);
        }
    }
}