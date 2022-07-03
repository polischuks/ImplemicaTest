package org.implemica;

import java.util.ArrayList;

/**
 * File: Task1.java
 * The class searches for valid parenthesis
 * expressions that contain N opening and N
 * closing parentheses.
 */
public class Task1 {
    private ArrayList<String> totalCombination;
    private int countBrackets;
    public Task1() {
    }

    /**
     * The main method for obtaining a result,
     * in the method ArrayList < String > totalCombination
     * is initialized.
     */
    public void generateCombination() {
        totalCombination = new ArrayList<>();
        char[] arrayOfBrackets = new char[countBrackets * 2];
        addCouple(countBrackets, countBrackets, arrayOfBrackets, 0);
    }

    /**
     * This method implements the generation of parenthesis
     * pairs using a recursive approach.
     *
     * @param leftBrackets the count of left brackets
     * @param rightBrackets the count of right brackets
     * @param arrayOfBrackets the array of all brackets
     * @param count the count of brackets couple
     */
    private void addCouple(int leftBrackets, int rightBrackets, char[] arrayOfBrackets, int count) {
        if (leftBrackets < 0 || rightBrackets < leftBrackets) return;
        if (leftBrackets == 0 && rightBrackets == 0) {
            totalCombination.add(String.copyValueOf(arrayOfBrackets));
        } else {
            if (leftBrackets > 0) {
                arrayOfBrackets[count] = '(';
                addCouple(leftBrackets - 1, rightBrackets, arrayOfBrackets, count + 1);
            }
            if (rightBrackets > leftBrackets) {
                arrayOfBrackets[count] = ')';
                addCouple(leftBrackets, rightBrackets - 1, arrayOfBrackets, count + 1);
            }
        }
    }

    public void setCountBrackets(int countBrackets) {
        this.countBrackets = countBrackets;
    }

    public ArrayList<String> getTotalCombination() {
        return totalCombination;
    }
}
