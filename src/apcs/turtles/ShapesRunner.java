package apcs.turtles;

import TurtleGraphics.SketchPadWindow;

public class ShapesRunner {

  public static void main(String[] args) {
    SketchPadWindow sk = new SketchPadWindow(700, 700);
    SlowPen p = new SlowPen(sk);
    SlowPen.setDelay(100);
    spiral(p, 150, 50);

    SketchPadWindow sk2 = new SketchPadWindow(700, 700);
    SlowPen p2 = new SlowPen(sk2);
    SlowPen.setDelay(100);
    zigzag(p2, 150);
  }

  public static void spiral(SlowPen p, int dist, double angle) {
    if (dist > 0) {
      p.move(dist);
      p.turn(angle);
      spiral(p, dist - 1, angle);
    }
  }

  public static void zigzag(SlowPen p, int dist) {
    if (dist > 0) {

      p.move(dist);
      p.turn(-175);
      p.move(dist - 1);
      p.turn(175);

      zigzag(p, dist - 2);

    }
  }
}
