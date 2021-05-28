package apcs.pi;

import java.util.Scanner;

public class PiRunner {

  public static void main(String[] args) {

    // Part 1: Approximate PI by the number of terms

    // Collect total number of iterations from user
    Scanner reader = new Scanner(System.in);
    System.out.print("Number of iterations: ");
    int totalIterations = reader.nextInt();

    // Calculate approximation
    double approximation = 0.0;
    double denominator = 1.0;
    for (int i = 0; i < totalIterations; i++) { // Loop through number of terms
      if (i % 2 == 0) { // even
        approximation = approximation + (4 / denominator); // Add positive terms to approximation
      } else { // odd
        approximation = approximation - (4 / denominator); // Add negative terms to approximation
      }
      denominator += 2.0; // Increase denominator for next term
    }

    System.out.println("PI approximated to " + totalIterations + " terms is " + approximation);

    // Part 2: Approximate Pi to a specific precision

    // Collect threshold of the smallest term
    System.out.print("Threshold of smallest term: ");
    double threshold = reader.nextDouble();

    // Calculate approximation
    double approximation2 = 0.0;
    double denominator2 = 1.0;
    boolean positive = true;
    int count = 0;

    while ((4 / denominator2)
        > threshold) { // Only proceed when the threshold isn't met for the term
      int sign = (positive) ? 1
          : -1; // Convert boolean of positive/not positive to make it so that you can multiply it in the equation
      approximation2 = approximation2 + sign * (4.0 / denominator2); // Calculate approximation

      denominator2 += 2.0; // Increase denominator for next term
      positive = !positive; // Flip sign
      count++; // Increase count
    }

    System.out
        .println("PI approximated until a term is less than " + threshold + " is " + approximation);
    System.out.println("It required " + (count + 1) + " terms to make this approximation.");

    // Part 3: Random number generator approximation

    // Collect total number of coordinate pairs to generate
    System.out.print("Number of pairs: ");
    int totalPairs = reader.nextInt();

    // Calculate approximation
    int inCircle = 0;
    for (int i = 0; i < totalPairs; i++) { // Loop through number of points
      // Generate two different random values between -1.0 and +1.0
      double x = (Math.random() * 2) - 1;
      double y = (Math.random() * 2) - 1;

      if ((x * x) + (y * y) < 1) { // Calculate if the point is in the circle
        inCircle++;
      }

    }

    double ratio = (double) inCircle / totalPairs; // pi / 4
    double approximate = ratio * 4; // pi

    System.out.println(totalPairs + " points were generated");
    System.out.println(inCircle + " fell inside the circle");
    System.out
        .println("Pi/4 is approximately " + inCircle + "/" + totalPairs + " = " + approximate);

    System.out.println("Pi is approximately " + approximate);

  }

}
