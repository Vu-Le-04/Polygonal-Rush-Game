import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.lang.*;
import java.util.*;

public class MovingFinishLine extends FinishLine implements Runnable {
  private int delay;
  private int speed;
  private JComponent component;

  /**
   * Creates a new MovingCarInstance
   * @param x         the x coordinate of the top left corner
   * @param y         the y coordinate of the top left corner
   * @param step      Step in pixels the car will move each time
   * @param delay     The delay to wait between each step
   * @param steps     How many times the car will move
   * @param direction In which direction the car will move
   * @param component The component
   */
  public MovingFinishLine(int x, int y, int speed, int delay, JComponent component) {
    super(x, y);
    this.speed = speed;
    this.delay = delay;
    this.component = component;
  }

  /**
   * Adjusts the car's x and y locations based on the direction it is going. Moves
   * it a fixed
   * number of steps.
   */
  public void animate() throws InterruptedException {
    // System.out.println("moving FinishLines");
    move(-10, 0);
    pause();
  }

  /**
   * Draws the car in the current position.
   * @param g2 the graphics context
   */
  public void draw(Graphics2D g2) {
    super.draw(g2);
  }

  /**
   * Pauses the animation.
   */
  public void pause() throws InterruptedException {
    component.repaint();
    Thread.sleep(delay);
  }

  public void run() {
    while (true) {
      try {
        animate();
      } catch (InterruptedException exception) {
      }
    }
  }

}
