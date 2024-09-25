import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;

/**
 * 
 * The FinishLine class represents a finish line object that implements the
 * Animatable interface.
 * It is used to mark the end point of a race track or a similar game scenario.
 */
public class FinishLine implements Animatable {
  private int sizeX = 60;
  public static int SIZEY = 307;
  public int xPos;
  public static int yPos = 280;
  private Image img;

  /**
   * Constructs a new FinishLine object with default x and y positions.
   * It also sets the image for the finish line.
   */
  public FinishLine() {
    xPos = 300;
    setImage();
  }

  /**
   * Constructs a new FinishLine object with the specified x and y positions.
   * It also sets the image for the finish line.
   * @param x The x-coordinate of the finish line
   * @param y The y-coordinate of the finish line
   */
  public FinishLine(int x, int y) {
    xPos = x;
    yPos = y;
    setImage();
  }

  /**
   * Sets the image for the finish line by loading it from a file.
   * If the image file is not found, it prints an error message.
   */
  private void setImage() {
    try {
      img = ImageIO.read(new File("Images//FINISHLINE.png"));
    } catch (IOException e) {
      System.out.println("File not found");
    }
  }

  /**
   * Moves the finish line by the specified amount in the x and y directions.
   * @param dx The amount to move the finish line in the x-direction
   * @param dy The amount to move the finish line in the y-direction
   */
  public void move(int dx, int dy) {
    yPos += dy;
    xPos += dx;
  }

  /** 
   * Returns the x-coordinate of the finish line.
   * @return The x-coordinate of the finish line
   */
  public int getX() {
    return xPos;
  }

  /**
   * Draws the finish line on the specified graphics context.
   * @param g2 The graphics context on which to draw the finish line
   */
  public void draw(Graphics2D g2) {
    try {
      g2.drawImage(img, xPos, yPos, sizeX, SIZEY, null);
    } catch (Exception e) {
    }
  }

  /**
   * Returns the bounding rectangle of the finish line.
   * @return The bounding rectangle of the finish line
   */
  public Rectangle getBounds() {
    return new Rectangle(xPos, yPos, sizeX, SIZEY);
  }

  /**
   * Performs the animation for the finish line.
   * This method is empty as the finish line does not have any animation.
   * @throws InterruptedException If the animation is interrupted
   */
  public void animate() throws InterruptedException {}
}