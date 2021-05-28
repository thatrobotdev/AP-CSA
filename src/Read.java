import java.util.Scanner;

public class Read {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        int x;
        System.out.println("Enter a number: ");
        x = reader.nextInt();
        System.out.println("You entered: " + x);
    }
}
