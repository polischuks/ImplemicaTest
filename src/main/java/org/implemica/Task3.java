package org.implemica;

import java.math.BigInteger;

/**
 * File: Task3.java
 * The class sums the numbers in the number n!
 */
public class Task3 {

    private int summa = 0;

    /**
     * This method sums up the digits in the number factor!
     * @param factor natural number
     * @return sums of digits
     */
    public int getSumma(int factor){
        String number = String.valueOf(getFactorial(factor));
        for (int i = 0; i < number.length(); i++) {
            summa += Integer.parseInt(number.charAt(i) + "");
        }
        return summa;
    }

    /**
     * This method implements the calculation of the
     * factorial of the natural number
     * @param factor natural number
     * @return factor!
     */
    private BigInteger getFactorial(int factor) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= factor; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}
