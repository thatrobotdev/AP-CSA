/*

NOTE: At first, I made the triangle right side up before I realized that a YIELD sign was upside down.
This file is my first attempt before I fixed it in Project2.

Problem:
A yield sign encloses the word YIELD within a triangle.
Write a program that displays a yield sign. (Use stars to represent the sides of the triangle)

 */

package apcs.project2;

public class RegularTriangle {
    public static void main(String[] args) {

        final int triangleHeight = 10; // Set to change triangle height (To see 'YIELD' text, set to a high number)
        final boolean printStars = false; // Set to true if you want the program to print stars instead of slashes / dotted lines

        for(int line = 0; line < triangleHeight; line++) { // Runs for each line of the triangle
            int leftWhitespace; // Counter used to count the number of left whitespaces print


            for (leftWhitespace = 0; leftWhitespace < (triangleHeight - line); leftWhitespace++) { // Counts up to the number of left whitespaces needed to print
                    System.out.print(" "); // Print whitespace on left side of triangle
            }


            if(printStars) { // Print left side of triangle
                System.out.print("*");
            } else {
                System.out.print("/");
            }


            int totalTriangleWhitespace = 2 * (triangleHeight - leftWhitespace); // Number of total whitespace to be printed inside of the triangle

            for(int middleWhitespace = 0; middleWhitespace < totalTriangleWhitespace; middleWhitespace++) { // Counts up to the number of middle whitespaces needed to be printed inside of the triangle

                final int triangleMiddle = triangleHeight / 2; // Line number of the middle line for the triangle

                if(line == triangleHeight - 1) { // Print bottom of triangle
                    if(printStars) {
                        if(middleWhitespace % 2 == 1) {
                            System.out.print("* ");
                        }
                    } else {
                        System.out.print("_");
                    }

                } else if(line == triangleMiddle) { // If printing middle line
                    if(middleWhitespace == (totalTriangleWhitespace / 2) - 2) { // If printing in the middle of the middle line minus two characters
                        System.out.print("YIELD");
                        middleWhitespace += 4; // Push counter 4 characters forward to make up for the space that 'YIELD' takes up.
                    } else { // Runs when printing middle whitespace characters on middle line before/after yield
                        System.out.print(" ");
                    }
                } else { // Runs when printing middle whitespace characters on any line
                    System.out.print(" ");
                }
            }
            if(printStars) { // Print right side of triangle
                System.out.println("*");
            } else {
                System.out.println("\\");
            }

        }
    }
}