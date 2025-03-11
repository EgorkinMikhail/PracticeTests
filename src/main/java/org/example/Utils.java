package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

  public static int sumOfPrimes(int input) {
    if (input < 2) {
      return 0;
    }

    int sum = 0;
    for (int i = 2; i <= input; i++) {
      if (isPrime(i)) {
        sum += i;
      }
    }
    return sum;
  }

  private static boolean isPrime(int num) {
    if (num < 2) {
      return false;
    }
    // Check divisors from 2 up to the square root of the number
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static String convertToTitleCase(String input) {
    if (input == null || input.isEmpty()) {
      return input;
    }

    String[] words = input.split("\\s+");
    StringBuilder titleCase = new StringBuilder();

    for (String word : words) {
      if (!word.isEmpty()) {
        String capitalizedWord = word.substring(0, 1).toUpperCase() +
            word.substring(1).toLowerCase();
        titleCase.append(capitalizedWord).append(" ");
      }
    }

    return titleCase.toString().trim();
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }

    Map<String, List<String>> anagramMap = new HashMap<>();

    for (String str : strs) {
      char[] characters = str.toCharArray();
      Arrays.sort(characters);
      String sortedKey = new String(characters);

      anagramMap.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(str);
    }

    return new ArrayList<>(anagramMap.values());
  }
}
