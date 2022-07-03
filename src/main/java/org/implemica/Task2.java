package org.implemica;

import java.util.*;

/**
 * File Task2.java
 * The class retrieves' data, processes and searches for
 * the lowest cost between pairs of cities.
 */
public class Task2 {
    private static final int MAX_TESTS_VALUE = 10;
    private static final int MAX_CITIES_VALUE = 10_000;
    private static final int MAX_SUM_COSTS = 200_000;
    private static final int INFINITY = Integer.MAX_VALUE;
    private int numberOfTests;
    private int numberOfCities;
    private int[][] distance;
    private List<String> cityName;
    private String startCity;
    private String targetCity;
    private int numberOfSearch;
    private final Scanner scanner = new Scanner(System.in);

    /**
     * The method implements the logic of interaction
     * of input data and obtaining a result.
     */
    public void getPathsOfMinimumCost() {
        while(scanner.hasNextInt()) {
            numberOfTests = scanner.nextInt();
            if (numberOfTests <= MAX_TESTS_VALUE) break;
        }
        while (numberOfTests != 0) {
            getInputData();
            getResultList().forEach(System.out::println);
            numberOfTests--;
        }
        scanner.close();
    }

    /**
     * This method performs a minimum cost search based
     * on the number of searches.
     * @return list of results
     */
    private List<Integer> getResultList() {
        List<Integer> listResult = new ArrayList<>();
        if (scanner.hasNextInt()) numberOfSearch = scanner.nextInt();
        for (int j = 0; j < numberOfSearch; j++) {
            if (scanner.hasNext()) {
                startCity = scanner.next().toLowerCase();
            }
            if (scanner.hasNext()) {
                targetCity = scanner.next().toLowerCase();
            }
            listResult.add(findShortestPath(cityName.indexOf(startCity), cityName.indexOf(targetCity)));
        }
        return listResult;
    }

    /**
     * This method provides input from the standard console.
     */
    private void getInputData() {
        while(scanner.hasNextInt()) {
            numberOfCities = scanner.nextInt();
            if (numberOfCities <= MAX_CITIES_VALUE) break;
        }
        cityName = new ArrayList<>();
        distance = new int[numberOfCities][numberOfCities];
        for (int i = 0; i < numberOfCities; i++){
            for (int j = 0; j< numberOfCities; j++){
                distance[i][j] = MAX_SUM_COSTS;
            }
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                if (s.matches("[a-z]{1,10}")) {
                    cityName.add(s);
                    break;
                }
            }
            int neighbors = 0;
            if (scanner.hasNextInt()) {
                neighbors = scanner.nextInt();
            }
            for (int j = 0; j < neighbors; j++) {
                int[] temp = new int[2];
                if (scanner.hasNextInt()) {
                    temp[0] = scanner.nextInt();
                }
                if (scanner.hasNextInt()) {
                    temp[1] = scanner.nextInt();
                }
                distance[i][temp[0] - 1] = temp[1];
            }
        }
    }

    /**
     * This method implements the search for the minimum cost
     * of transportation from the city.
     * The method uses Dijkstra's algorithm
     * @param startCity the start city for search
     * @param targetCity the end city for search
     * @return the minimum cost
     */
    private int findShortestPath(int startCity, int targetCity) {
        int numbersOfCity = distance[0].length;
        int[] distanceFind = new int[numbersOfCity];
        int index = 0;
        boolean[] visited = new boolean[numbersOfCity];
        for (int i = 0; i < numbersOfCity; i++) {
            distanceFind[i] = INFINITY;
        }
        distanceFind[startCity] = 0;
        for (int num = 0; num < numbersOfCity; num++) {
            int min = INFINITY;
            for (int i = 0; i < numbersOfCity; i++)
                if (!visited[i] && distanceFind[i] <= min) {
                    min = distanceFind[i];
                    visited[i] = !visited[i];
                    index = i;
                }
            for (int i = 0; i < numbersOfCity; i++)
                if (!visited[i] && distanceFind[index] + distance[index][i] < distanceFind[i])
                    distanceFind[i] = distanceFind[index] + distance[index][i];
        }
        return distanceFind[targetCity];
    }
}
