import java.util.Scanner;

public class Read {
    /*
    This was part of homework to learn how to use the Java Scanner class to get
    input from the command line.
     */

    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        int x;
        System.out.println("Enter a number: ");
        x = reader.nextInt();
        System.out.println("You entered: " + x);
    }
}
