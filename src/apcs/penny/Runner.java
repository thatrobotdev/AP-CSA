package apcs.penny;

import java.util.Random;
import java.util.Scanner;

public class Runner {

  public static void main(String[] args) {
    Square[][] board = new Square[5][5];
    int rows = board.length;
    int middle = (int) Math.floor(((double) rows + 1.0) / 2.0);

    for (int a = 0; a < middle; a++)
      for (int b = a; b < rows - a; b++) {
        board[b][a] = new Square(a + 1);
        board[a][b] = new Square(a + 1);

        board[rows - b - 1][rows - (a + 1)] = new Square(a + 1);
        board[rows - (a + 1)][rows - b - 1] = new Square(a + 1);
      }

    System.out.println("Welcome to Penny Pitch!");
    System.out.println(
        "5 pennies will be tossed on the board, get lucky by hitting numbers with higher values!");

    int totalScore = 0;
    for (int i = 0; i < 5; i++) {
      Scanner reader = new Scanner(System.in);
      System.out.print("Press ENTER to continue >> ");
      reader.nextLine();

      Random random = new Random();
      int r = random.nextInt(5);
      int c = random.nextInt(5);

      board[r][c].addPenny();
      int pennies = board[r][c].getPennies();
      int score = board[r][c].getScore() * pennies;

      Runner.displayBoard(board);

      if (pennies == 2)
        System.out.print("DOUBLE! ");
      else if (pennies == 3)
        System.out.print("TRIPLE! ");
      else if (pennies == 4)
        System.out.print("QUADRUPLE! ");
      else if (pennies == 5)
        System.out.print("QUINTUPLE! ");

      if (pennies > 1)
        System.out.println(pennies + "x score for throwing your penny on another penny!");

      totalScore += score * pennies;

      System.out.print("You scored " + score + " point");
      if (score != 1)
        System.out.print("s");
      System.out.println("! (You hit row " + (r + 1) + ", column " + (c + 1) + ")");
    }

    System.out.println("GAME OVER!");
    System.out.println("You got " + totalScore + " points!");
    if (totalScore > 9)
      System.out.println("You win!");
    else
      System.out.println("Try again for a better score!");
  }

  private static void displayBoard(Square[][] b) {
    for (Square[] squares : b) {
      for (Square square : squares) {
        if (square == null)
          System.out.print("n");
        else
          System.out.print(square);
        System.out.print(" ");

      }
      System.out.println();
    }

  }
}
