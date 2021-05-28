package apcs.rect;

public class RectRunner {

  public static void main(String[] args) {
    Rect r1 = new Rect(10, 4);
    System.out.println(r1);
    double w = r1.getWidth();
    double h = r1.getHeight();

    r1.setWidth(h);
    r1.setHeight(w);

    System.out.println(r1);
    System.out.println("The area of Rect r1 is: " + r1.getArea());
    System.out.println("The perimeter of Rect r1 is: " + r1.getPerimeter());

    Rect r2 = new Rect(1, 5);
    System.out.println("The diagonal length of Rect r2 is: " + r2.getDiagonal());
    if (r1.equals(r2)) {
      System.out.println(r1 + "\nis the same as \n" + r2);
    } else {
      System.out.println(r1 + "\nis the NOT same as \n" + r2);
    }

    Rect r3 = new Rect(4, 10);
    if (r1.equals(r3)) {
      System.out.println(r1 + "\nis the same as \n" + r3);
    } else {
      System.out.println(r1 + "\nis the NOT same as \n" + r3);
    }


  }
}
