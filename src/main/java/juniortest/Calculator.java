package juniortest;

import java.util.ArrayList;

/**
 * Test. Ways to fill a tank. Yopsel Mopsel.
 * Calculator class.
 *
 * @author Slava Poliakov
 * @version 1.00 2017-12-12
 */


public class Calculator {
    private int waysNumber;
    private ArrayList<String> waysSet;
    final private int[] bucketsType = new int[]{1, 2, 5, 10};


    public Calculator() {
    }

    /**
     * Method to calculate possible ways to fill a tank
     * @param volume Integer value of tank volume
     */
    public void calculateWays(int volume) {
        waysNumber = 0;
        waysSet = new ArrayList<>();
        if (volume != 0) {
            int max10 = volume / 10;
            for (int b10 = max10; b10 >= 0; b10--) {
                int max5 = (volume - b10 * 10) / 5;
                for (int b5 = max5; b5 >= 0; b5--) {
                    int max2 = (volume - b10 * 10 - b5 * 5) / 2;
                    for (int b2 = max2; b2 >= 0; b2--) {
                        int b1 = (volume - b2 * 2 - b5 * 5 - b10 * 10);
                        String liter1 = b1 == 0 ? "" : String.format("%3d of  1L", b1) + (b2 != 0 || b5 != 0 || b10 != 0 ? " + " : "");
                        String liter2 = b2 == 0 ? "" : String.format("%3d of  2L", b2) + (b5 != 0 || b10 != 0 ? " + " : "");
                        String liter5 = b5 == 0 ? "" : String.format("%3d of  5L", b5) + (b10 != 0 ? " + " : "");
                        String liter10 = b10 == 0 ? "" : String.format("%3d of 10L", b10);
                        String way = liter1 + liter2 + liter5 + liter10;
                        waysSet.add(way);
                        waysNumber++;
                    }
                }
            }
        }
    }

    public int getWaysNumber() {
        return waysNumber;
    }

    public ArrayList<String> getWaysSet() {
        return waysSet;
    }
}
