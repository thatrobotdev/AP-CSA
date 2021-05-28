package apcs.turtles;

import TurtleGraphics.Pen;
import TurtleGraphics.SketchPadWindow;

public class FractalRunner {

  public static void main(String[] args) {

    SketchPadWindow kochSnowflake = new SketchPadWindow(500, 500);
    SlowPen.setDelay(5);
    SlowPen p = new SlowPen(kochSnowflake);
    double length = 400;
    int degree = 3;

    p.up();
    p.move(-200);
    p.turn(-90);
    p.move(-200);
    p.down();

    for (int i = 0; i < 4; i++) {
      drawKochCurve(p, length, degree);
      p.turn(90);
    }

    SketchPadWindow cCurve = new SketchPadWindow(700, 700);
    SlowPen p2 = new SlowPen(cCurve);
    double length2 = 400;
    int degree2 = 3;

    p2.turn(-90);
    drawCCurve(p2, length2, degree2);

    SketchPadWindow tree = new SketchPadWindow(700, 700);
    SlowPen p3 = new SlowPen(tree);
    final double length3 = 400;
    final int degree3 = 3;

    p3.up();
    p3.move(-200);
    p3.down();

    FractalRunner.drawTree(p3, length3, degree3);

  }

  private static void drawKochCurve(Pen p, double length, int degree) {
    if (degree == 0) {
      p.move(length);
    } else {
      FractalRunner.drawKochCurve(p, length / 3, degree - 1);
      p.turn(60);
      FractalRunner.drawKochCurve(p, length / 3, degree - 1);
      p.turn(240);
      FractalRunner.drawKochCurve(p, length / 3, degree - 1);
      p.turn(60);
      FractalRunner.drawKochCurve(p, length / 3, degree - 1);
    }
  }

  private static void drawCCurve(Pen p, double length, int degree) {
    if (degree == 0) {
      p.move(length);
    } else {
      p.turn(315);
      FractalRunner.drawCCurve(p, length / 2, degree - 1);
      p.turn(90);
      FractalRunner.drawCCurve(p, length / 2, degree - 1);
      p.turn(315);

    }
  }

  private static void drawTree(Pen p, double length, int degree) {
    if (degree == 0) { // base case
      p.move(length);
    } else {

      // move up trunk
      p.move(length / 2);

      // first branch
      p.turn(45);
      drawTree(p, length / 4, degree - 1);
      p.move(-length / 4);
      p.turn(315);

      // move up trunk
      p.move(length / 4);

      //second branch
      p.turn(-45);
      drawTree(p, length / 4, degree - 1);
      p.move(-length / 4);
      p.turn(-315);

      // third branch
      drawTree(p, length / 2 - length / 4, degree - 1);

    }
  }

}
