package org.implemica;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please select a task number: ");
            if (scanner.hasNextInt()) {
                switch (scanner.nextInt()) {
                    case 1 -> {
                        int count;
                        while (scanner.hasNextLine()) {
                            System.out.println("Please enter the number of brackets");
                            count = scanner.nextInt();
                            if (count > 0) {
                                Task1 task1 = new Task1();
                                task1.setCountBrackets(count);
                                task1.generateCombination();
                                System.out.println("Number of correct combination: " +
                                        task1.getTotalCombination().size());
                                task1.getTotalCombination().forEach(s -> System.out.print(s + " "));
                                break;
                            } else {
                                System.out.println("Error! Please enter correct digits.");
                            }
                        }
                    }
                    case 2 -> new Task2().getPathsOfMinimumCost();
                    case 3 -> System.out.println("The sum of the digits in the number " +
                            new Task3().getSumma(100));
                }
            }
        }
    }
}