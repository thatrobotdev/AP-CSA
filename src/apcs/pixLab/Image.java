package apcs.pixLab;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {

  /*
   * Instance variables: image - a 2D Array of Colors
   */
  private Color[][] image;

  /**
   * Creates a new Image based on an existing 2D array of colors
   *
   * @param image the array of Colors
   */
  public Image(Color[][] image) {
    this.image = image;
  }

  /**
   * Creates a new Image from an image stored in a file
   *
   * @param file the name of the file to create the Image from
   */
  public Image(String file) {
    // read image and load into array of Colors
    try {
      BufferedImage img = ImageIO.read(new File(file));
      image = new Color[img.getHeight()][img.getWidth()];
      for (int r = 0; r < image.length; r++) {
        for (int c = 0; c < image[r].length; c++) {
          image[r][c] = new Color(img.getRGB(c, r));
        }
      }
    } catch (IOException e) {  // couldn't open file
      e.printStackTrace();
      System.exit(-1);
    }
  }

  /**
   * Displays a COPY of the image into a Java GUI Window
   *
   * @param title The title to be displayed in the window's title bar
   */
  public void display(String title) {
    new ImageGUI(image, title);
  }

  /**
   * copy - creates and returns a duplicate copy of an image
   * <p>
   * precondition: the image has at least one row and at least one column
   *
   * @return a copy of the image
   */
  public Image copy() {
    Color[][] theCopy = new Color[image.length][image[0].length];
    for (int r = 0; r < image.length; r++) {
      for (int c = 0; c < image[0].length; c++) {
        theCopy[r][c] = new Color(image[r][c].getRGB());
      }
    }
    return new Image(theCopy);
  }

  public void removeBlue() {

    // loop through all pixels
    for (int r = 0; r < image.length; r++) {
      for (int c = 0; c < image[r].length; c++) {

        // get component parts of pixel's color
        Color pixel = image[r][c];
        int red = pixel.getRed();
        int green = pixel.getGreen();

        // construct a new pixel with the same red and green but no blue
        image[r][c] = new Color(red, green, 0);
      }
    }
  }

  public void removeRed() {

    // loop through all pixels
    for (int r = 0; r < image.length; r++) {
      for (int c = 0; c < image[r].length; c++) {

        // get component parts of pixel's color
        Color pixel = image[r][c];
        int green = pixel.getGreen();
        int blue = pixel.getBlue();

        // construct a new pixel with the same red and green but no blue
        image[r][c] = new Color(0, green, blue);
      }
    }
  }

  public void blackWhite() {
    for (int r = 0; r < image.length; r++) {
      for (int c = 0; c < image[r].length; c++) {
        Color pixel = image[r][c];
        int red = pixel.getRed();
        int green = pixel.getGreen();
        int blue = pixel.getBlue();

        int average = (red + green + blue) / 3;
        image[r][c] = new Color(average, average, average);
      }
    }

  }

  public void invert() {
    for (int r = 0; r < image.length; r++) {
      for (int c = 0; c < image[r].length; c++) {
        Color pixel = image[r][c];
        int red = pixel.getRed();
        int green = pixel.getGreen();
        int blue = pixel.getBlue();

        image[r][c] = new Color(255 - red, 255 - green, 255 - blue);
      }
    }
  }

  public void flipHorizontal() {
    for (int r = 0; r < image.length; r++) {
      for (int c = 0; c < image[r].length / 2; c++) {
        Color leftPixel = image[r][c];

        int red = leftPixel.getRed();
        int green = leftPixel.getGreen();
        int blue = leftPixel.getBlue();

        image[r][c] = image[r][image[r].length - c - 1];
        image[r][image[r].length - c - 1] = new Color(red, green, blue);


      }
    }

  }


  public void mirrorVertical() {
    for (int r = 0; r < image.length; r++) {
      for (int c = 0; c < image[r].length; c++) {
        Color topPixel = image[r][c];

        int red = topPixel.getRed();
        int green = topPixel.getGreen();
        int blue = topPixel.getBlue();

        image[image.length - r - 1][c] = new Color(red, green, blue);
      }
    }
  }

  public void blurImage() {
    Color[][] blurred = new Color[image.length][image[0].length]; // Create a temporary 2D array of Colors the same size as the original image

    for (int r = 2; r < blurred.length - 1; r++) {
      for (int c = 1; c < blurred[r].length - 1;
          c++) { // For each pixel in the original image from 1 to length-1, calculate the blurred red/blue/green component by averaging the pixel's color component with that of its eight neighboring pixels.
        int[] averagePixel = {0, 0, 0};

        for (int n = r - 1; n <= r + 1; n++) {
          for (int m = c - 1; m <= c + 1; m++) {
            Color currentPixel = image[n][m];

            averagePixel = new int[]{averagePixel[0] + currentPixel.getRed(),
                averagePixel[1] + currentPixel.getGreen(),
                averagePixel[2] + currentPixel.getBlue()};

          }
        }

        for (int i = 0; i < averagePixel.length; i++) {
          averagePixel[i] /= 9;
        }

        blurred[r][c] = new Color(averagePixel[0], averagePixel[1], averagePixel[2]);

      }
    }

    for (int r = 2; r < image.length - 1; r++) {
      for (int c = 2; c < image[r].length - 1; c++) {
        int red = blurred[r][c].getRed();
        int green = blurred[r][c].getGreen();
        int blue = blurred[r][c].getBlue();

        image[r][c] = new Color(red, green, blue);
      }
    }
  }


}
