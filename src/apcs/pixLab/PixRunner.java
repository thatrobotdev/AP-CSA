// I was the host, my coding partner was JP
package apcs.pixLab;

import java.awt.Color;

public class PixRunner {

  public static void main(String[] args) {
    Color[][] img = new Color[256][256];
    for (int r = 0; r < img.length; r++) {
      for (int c = 0; c < img[r].length; c++) {
        img[r][c] = new Color(r, c, 255 - (r + c) / 2);
      }
    }
    Image a = new Image(img);
    a.display("Full Gradient");

    Image b = new Image("p2p.jpg");
    b.display("Peak to Peak");

    Image c = b.copy();
    c.removeBlue();
    c.display("P2P with no blue");

    Image d = b.copy();
    d.removeRed();
    d.display("P2P with no red");

    Image e = b.copy();
    e.blackWhite();
    e.display("P2P in black & white");

    Image f = b.copy();
    f.invert();
    f.display("P2P with inverted colors");

    Image g = b.copy();
    g.flipHorizontal();
    g.display("P2P flipped horizontally");

    Image h = b.copy();
    h.mirrorVertical();
    h.display("P2P mirrored vertically");

    Image blur = b.copy();
    blur.blurImage();
    blur.display("P2P blurred");

  }

}
