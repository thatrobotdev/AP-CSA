/*

Problem:
A yield sign encloses the word YIELD within a triangle.
Write a program that displays a yield sign. (Use stars to represent the sides of the triangle)

 */

package apcs.project2;

public class Project2 {
    public static void main(String[] args) {
        final int triangleHeight = 20; // Set to change triangle height (To see 'YIELD' text, set to a high number)
        final boolean printStars = false; // Set to true if you want the program to print stars instead of slashes / dotted lines

        for(int line = 0; line < triangleHeight; line++) { // Runs for each line of the triangle
            int leftWhitespace;
            for(leftWhitespace = 0; leftWhitespace < line; leftWhitespace++) {
                System.out.print(" ");
            }

            if(line == 0) { // Runs on first line to draw bottom of triangle
                for(int i = 0; i < triangleHeight; i++) {
                    if(printStars) {
                        System.out.print(" *");
                    } else {
                        System.out.print(" _");
                    }

                }
                System.out.println();
            } else {
                if(printStars) {
                    System.out.print("*");
                } else {
                    System.out.print("\\");
                }

                int totalTriangleWhitespace = 2 * (triangleHeight - leftWhitespace - 1); // Number of total whitespace to be printed inside of the triangle

                for(int middleWhitespace = 0; middleWhitespace < totalTriangleWhitespace; middleWhitespace++) {

                    final int triangleMiddle = triangleHeight / 2; // Line number of the middle line for the triangle

                    if(line == triangleMiddle) {
                        if(middleWhitespace == (totalTriangleWhitespace / 2) - 2) { // If printing in the middle of the middle line minus two characters
                            System.out.print("YIELD");
                            middleWhitespace += 4; // Push counter 4 characters forward to make up for the space that 'YIELD' takes up.
                        } else { // Runs when printing middle whitespace characters on middle line before/after yield
                            System.out.print(" ");
                        }

                    } else {
                        System.out.print(" ");
                    }
                }

                if(printStars) {
                    System.out.println("*");
                } else {
                    System.out.println("/");
                }

            }

        }
    }

}