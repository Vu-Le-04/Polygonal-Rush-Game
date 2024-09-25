import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * The Player class represents a player object in the game.
 * It extends the ColorScreen class and contains information about the player's
 * position, color, and actions.
 */
public class Player extends ColorScreen {
  private int xPos;
  private int yPos;
  private static int floorHeight = 280;
  private static int SIZE = 25;
  Image image;

  /**
   * Constructs a new Player object with the specified position.
   * @param x the x-coordinate of the player
   * @param y the y-coordinate of the player
   */
  public Player(int x, int y) {
    xPos = x;
    yPos = y;
  }

  /**
   * Constructs a new Player object with the specified position and color.
   * @param x the x-coordinate of the player
   * @param y the y-coordinate of the player
   * @param c the color of the player
   */

  /**
   * 
   * Gets the y-coordinate of the player.
   * 
   * @return the y-coordinate of the player
   */
  public int getY() {
    return yPos;
  }

  /**
   * Sets the color of the player.
   * @param c the color to set for the player
   */
  public void setColor(String c) {
    color = c;
  }

  /**
   * Draws the player on the specified graphics context.
   * @param g2 the graphics context to draw on
   */
  public void draw(Graphics2D g2) {
    try {
      image = ImageIO.read(new File("Images//" + ColorScreen.color + ".png"));
      g2.drawImage(image, xPos, yPos, SIZE, SIZE, null);

    } catch (Exception e) {
    }
  }

  /**
   * Makes the player jump by changing its y-coordinate.
   */
  public void jump() {
    yPos -= 1;
  }

  /**
   * Makes the player fall by changing its y-coordinate.
   * If the player's y-coordinate exceeds the floor height, it is set to the floor
   * height.
   */
  public void fall() {
    yPos += 1;
    if (yPos > floorHeight)
      yPos = floorHeight;
  }

  /**
   * Gets the floor height of the game.
   * @return the floor height
   */
  public int getFloorHeight() {
    return floorHeight;
  }

  /**
   * Gets the bounding rectangle of the player.
   * @return the bounding rectangle of the player
   */
  public Rectangle getBounds() {
    return new Rectangle(xPos, yPos, SIZE, SIZE);
  }

}