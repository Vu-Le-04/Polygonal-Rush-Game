import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 * The MovingPlayer class represents a player that can move on a graphical
 * component.
 * It extends the Player class.
 */
public class MovingPlayer extends Player {
  private JComponent component;

  /**
   * Constructs a MovingPlayer object with the specified initial position and
   * component.
   * @param x         the initial x-coordinate of the player
   * @param y         the initial y-coordinate of the player
   * @param component the component on which the player will be drawn
   */
  public MovingPlayer(int x, int y, JComponent component) {
    super(x, y);
    this.component = component;
  }

  /**
   * Draws the MovingPlayer on the specified graphics context.
   * @param g2 the graphics context on which to draw the player
   */
  public void draw(Graphics2D g2) {
    super.draw(g2);
  }
}