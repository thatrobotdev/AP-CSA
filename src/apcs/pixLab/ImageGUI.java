package apcs.pixLab;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ImageGUI {

  /*
   * Instance variables: image - a Buffered Image
   */
  private final BufferedImage image;

  public ImageGUI(Color[][] imgArr, String title) {

    // duplicate pixel data to instance variable
    image = new BufferedImage(imgArr[0].length, imgArr.length, BufferedImage.TYPE_INT_RGB);
    for (int r = 0; r < imgArr.length; r++) {
      for (int c = 0; c < imgArr[r].length; c++) {
        image.setRGB(c, r, imgArr[r][c].getRGB());
      }
    }

    // create a JFrame to display the image in
    JFrame theGUI = new JFrame();

    int height = image.getHeight() + 47;
    int width = image.getWidth() + 18;

    theGUI.setTitle(title);
    theGUI.setSize(width, height);
    theGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    // create a custom ColorPanel to insert the image into a single-paned JFrame
    ColorPanel panel = new ColorPanel();
    Container pane = theGUI.getContentPane();
    pane.add(panel);

    // view the JFrame
    theGUI.setVisible(true);
  }

  /**
   * This is a custom private class to extend JPanel and display a Buffered Image in the panel - it
   * allows redisplay if the window is moved or obscured
   */
  private class ColorPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      ImageIcon other = new ImageIcon(image);
      other.paintIcon(this, g, 0, 0);
    }
  }
}

