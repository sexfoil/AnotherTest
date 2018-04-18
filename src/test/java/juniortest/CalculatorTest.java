package juniortest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Test. Ways to fill a tank. Yopsel Mopsel.
 * Unit test for Calculator class.
 *
 * @author Slava Poliakov
 * @version 1.00 2017-12-12
 */

public class CalculatorTest extends TestCase {

    public Calculator calculator = new Calculator();

    public CalculatorTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(CalculatorTest.class);
    }

    public void testForVolume_1() {
        calculator.calculateWays(1);
        int wayNumber = calculator.getWaysNumber();
        assertTrue("It must be only one way", wayNumber==1);
    }
    public void testForVolume_6() {
        calculator.calculateWays(6);
        int wayNumber = calculator.getWaysNumber();
        assertTrue("It must be 5 ways", wayNumber==5);
    }
    public void testForVolume_0() {
        calculator.calculateWays(0);
        int waysSetSize = calculator.getWaysSet().size();
        assertTrue("Size must be zero", waysSetSize==0);
    }

}
