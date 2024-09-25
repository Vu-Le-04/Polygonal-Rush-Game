import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.lang.*;
import java.util.*;

public class MovingSpike extends Spike implements Runnable {
  private int delay;
  private int speed;
  private JComponent component;

  /**
   * The MovingSpike class extends the Spike class and implements the Runnable
   * interface.
   * It represents a spike that can move and animate on a component.
   */
  public MovingSpike(int x, int y, int speed, int delay, JComponent component) {
    super(x, y);
    this.speed = speed;

    this.delay = delay;
    this.component = component;
  }

  /**
   * Constructs a new MovingSpike object.
   * @param x         the x-coordinate of the top left corner
   * @param y         the y-coordinate of the top left corner
   * @param speed     the speed of the spike
   * @param delay     the delay to wait between each step
   * @param component the component to animate on
   */
  public void animate() throws InterruptedException {
    // System.out.println("moving spikes");
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
