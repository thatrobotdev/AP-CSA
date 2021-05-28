package apcs.turtles;

import TurtleGraphics.SketchPadWindow;

public class TurtleRunner {

  public static void main(String[] args) {
    SketchPadWindow sk = new SketchPadWindow(500, 500);
    SlowPen pen = new SlowPen(sk);
    SlowPen.setDelay(5);

    pen.up();
    pen.move(50);
    pen.turn(90);
    pen.move(50);
    pen.down();

    for (int i = 0; i < 4; i++) {
      pen.turn(90);
      pen.move(100);
    }

    pen.up();
    pen.move(120);
    pen.turn(90);
    pen.move(100);
    pen.turn(90);
    pen.down();

    for (int i = 0; i < 3; i++) {
      pen.move(110);
      pen.turn(120);

    }

    pen.up();
    pen.move(250);
    pen.down();

    for (int i = 0; i < 22.5; i++) {
      pen.move(100);
      pen.turn(180);
      pen.up();
      pen.move(100);
      pen.turn(180);
      pen.turn(2);
      pen.down();
    }


  }


}
