package apcs.turtles;

import TurtleGraphics.SketchPadWindow;
import TurtleGraphics.StandardPen;

public class SlowPen extends StandardPen {
  private static int delay = 500;

  public static void setDelay(int delay) {
    SlowPen.delay = delay;
  }

  public SlowPen(SketchPadWindow sk) {
    super (sk);
  }
  @Override
  public void move(double v) {
    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    super.move(v);
  }
  public void move(double x, double y) {
    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    super.move(x, y);
  }
}
