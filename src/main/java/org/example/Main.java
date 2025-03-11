package org.example;

public class Main {
  public static void main(String[] args) {
    int n = 20;
    System.out.println("The sum of all prime numbers up to " + n + " is: " + sumOfPrimes(n));
  }

  public static int sumOfPrimes(int n) {
    // If n is less than 2, there are no prime numbers to sum
    if (n < 2) {
      return 0;
    }

    int sum = 0;
    for (int i = 2; i <= n; i++) {
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
}