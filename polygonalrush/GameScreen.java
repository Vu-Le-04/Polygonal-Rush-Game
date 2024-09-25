import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * The GameScreen class represents a game screen for the Polygonal Rush game.
 * It provides methods for setting up the screen and handling user interaction.
 */
public class GameScreen {
  public static JFrame gframe;

  /**
   * Constructs a new GameScreen object.
   * Sets up the frame size, title, and default close operation.
   */
  public GameScreen() {
    gframe = new JFrame();
    gframe.setSize(700, 430);
    gframe.setTitle("Polygonal Rush");
    gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  /**
   * Handles a click event on the game screen.
   * Adds a Component to the content pane, sets the frame for the component,
   * makes the frame visible, and starts the animation.
   */
  public void click() {
    try {
      Container c = gframe.getContentPane();
      Component component = new Component();
      component.setFrame(gframe);
      c.add(component);
      gframe.setVisible(true);
      component.startAnimation();
    } catch (Exception e) {
      // Exception handling code
    }
  }
}
