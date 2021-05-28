package apcs.inheritance;

public class Runner {

  public static void main(String[] args) {
    Parent p1 = new Parent();
    Parent p2 = new Parent(5);

    Child c1 = new Child();
    Child c2 = new Child(6);
  }
}
