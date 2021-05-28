package apcs.inheritance;

class Child extends Parent {

  Child() {
    super(7);
    System.out.println("Default Child Constructor");
  }

  Child(int num) {
    System.out.println("Special Child Constructor " + num);
  }
}