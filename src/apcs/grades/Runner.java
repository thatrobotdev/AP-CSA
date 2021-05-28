package apcs.grades;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {

    /*
    PROG: Grades Array
    Extensions: Calculate and print the median value, allow for any number of test scores
     */


  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    // Get number of tests that user wants to input
    int tests;

    System.out.print("How many test scores are you inputting? ");
    tests = reader.nextInt();

    double[] testScores = new double[tests]; // Create a new array to hold test scores in, with size of what user wants to input

    boolean goodInput = false;
    for (int i = 0; i < tests; i++) {
      do { // Retry until a (outside of 0.0-100.0)
        double score;
        System.out.print("Test score " + (i + 1) + ": ");
        score = reader.nextDouble();

        if (score < 0.0 || score > 100.0)
          System.out.println("Please input a score between 0.0 and 100.0");
        else {
          goodInput = true;
          testScores[i] = score;
        }
      } while (!goodInput);
      goodInput = false;

    }

    System.out.println(Arrays.toString(testScores));
    System.out.println("The maximum score is: " + Runner.max(testScores));
    System.out.println("The minimum score is: " + Runner.min(testScores));
    System.out.println("The average is " + Runner.average(testScores));
    System.out.println("The median is " + Runner.median(testScores));

  }

  private static double min(double[] arr) {
    double min = 100.0;
    for (double doubleTemp : arr)
      if (doubleTemp < min) {
        min = doubleTemp;
      }
    return min;
  }

  private static double max(double[] arr) {
    double max = 0.0;
    for (double doubleTemp : arr)
      if (doubleTemp > max) {
        max = doubleTemp;
      }
    return max;
  }

  private static double average(double[] arr) {
    double average = 0.0;
    for (double doubleTemp : arr)
      average += doubleTemp;
    if (average != 0)
      average /= arr.length;
    return average;
  }

  private static double median(double[] arr) {
    double median;
    if (arr.length % 2 == 0)
      median = (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
    else
      median = arr[arr.length / 2];
    return median;
  }
}
