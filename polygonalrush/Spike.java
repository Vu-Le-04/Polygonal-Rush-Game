import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;

/**
 * The Spike class represents a spike object that implements the Animatable
 * interface.
 * It is used to create spike obstacles in a game.
 */
public class Spike implements Animatable {
  private int sizeX = 30;
  public static int SIZEY = 30;
  public int xPos = 300;
  public static int yPos = 280;
  private Image img;
  private int num;
  Random r = new Random();
  // maybe add STACK or LINKEDLIST for algorithm 1

  /**
   * Constructs a new Spike object with a random size and image.
   */
  public Spike() {
    num = r.nextInt(5);
    setImage();
  }

  /**
   * Constructs a new Spike object with the specified position and a random size
   * and image.
   * @param x the x-coordinate of the spike
   * @param y the y-coordinate of the spike
   */
  public Spike(int x, int y) {
    xPos = x;
    yPos = y;
    num = r.nextInt(5);
    setImage();
  }

  /**
   * 
   * Constructs a new Spike object with the specified size, position, and image.
   * @param n the size of the spike
   * @param x the x-coordinate of the spike
   * @param y the y-coordinate of the spike
   */
  public Spike(int n, int x, int y) {
    xPos = x;
    yPos = y;
    num = n;
    setImage();
  }

  /**
   * 
   * Sets the image of the spike based on its size.
   */
  private void setImage() {
    try {
      if (num == 0 || num == 1) {
        sizeX = 30;
        img = ImageIO.read(new File("Images//spike1.png"));
      } else if (num == 2 || num == 3) {
        sizeX = 60;
        img = ImageIO.read(new File("Images//spike2.png"));
      } else {
        sizeX = 90;
        img = ImageIO.read(new File("Images//spike3.png"));
      }
    } catch (IOException e) {
      System.out.println("File not found");
    }
  }

  /**
   * 
   * Moves the spike by the specified amount in the x and y directions.
   * @param dx the amount to move in the x-direction
   * @param dy the amount to move in the y-direction
   */
  public void move(int dx, int dy) {
    yPos += dy;
    xPos += dx;
  }

  /** 
   * Gets the x-coordinate of the spike.
   * @return the x-coordinate of the spike
   */
  public int getX() {
    return xPos;
  }

  /**
   * Draws the spike on the specified graphics context.
   * 
   * @param g2 the graphics context to draw on
   */
  public void draw(Graphics2D g2) {
    try {
      g2.drawImage(img, xPos, yPos, sizeX, SIZEY, null);
    } catch (Exception e) {
    }
  }

  /**
   * 
   * Gets the bounding rectangle of the spike.
   * 
   * @return the bounding rectangle of the spike
   */
  public Rectangle getBounds() {
    return new Rectangle(xPos, yPos, sizeX, SIZEY);
  }

  /** 
   * Animates the spike.
   * @throws InterruptedException if the animation is interrupted
   */
  public void animate() throws InterruptedException {

  }
}