/*

Problem:
Write a program that takes as input a number of kilometers and prints the corresponding number of nautical miles.
You may rely on the following items of information:

* A kilometer represents 1/10,000 of the distance between the North Pole and the equator
* There are 90 degrees, containing 60 minutes of arc each, between the North Pole and the equator.
* A nautical mile is 1 minutes of an arc.

 */

package apcs.project3;
import java.util.Scanner;

public class Project3 {
    public static void main(String[] args) {

        // Get number of kilometers to calculate from the console
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter number of kilometers (integer): ");
        int kilometers = reader.nextInt();

        double nauticalMiles = (90.0 * 60.0 / 10000.0) * kilometers; // 90 degrees times 60 minutes of arc between the North Pole and the equator, divided by a thousand because a kilomiter is 1/10,000 of the distance between the North Pole and the equator, multiplied by the number of kilometers.

        System.out.println("Nautical miles: " + nauticalMiles);

    }
}
