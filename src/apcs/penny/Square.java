package apcs.penny;

public class Square {

  private final int score;
  private int pennies;

  Square(int score) {
    this.score = score;
    pennies = 0;
  }

  int getScore() {
    return score;
  }

  void addPenny() {
    pennies++;
  }

  int getPennies() {
    return pennies;
  }

  @Override
  public String toString() {

    if (pennies == 0)
      return String.valueOf(score);
    else if (pennies == 1)
      return "P";
    else if (pennies == 2)
      return "D";
    else if (pennies == 3)
      return "T";
    else if (pennies == 4)
      return "Q";
    else
      return "X";
  }
}
