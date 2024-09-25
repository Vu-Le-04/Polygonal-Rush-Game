import javax.swing.*;

/**
 * The HelpScreen class displays a help manual with instructions on how to play
 * a game.
 */
public class HelpScreen {
  /**
   * Creates a new instance of the HelpScreen class.
   */
  public HelpScreen() {
  }

  /**
   * Displays a help manual with instructions on how to play the game.
   * The manual contains information on how to jump and dodge obstacles.
   * The method uses a JFrame and JOptionPane to create a dialog box that displays
   * the help information.
   */
  public void click() {

    JFrame hframe = new JFrame("Help Screen");
    JOptionPane.showMessageDialog(hframe, "Press space to jump. Dodge all obstacles until you reach the finish line!", "Help Manual",
        JOptionPane.INFORMATION_MESSAGE);

    hframe.setSize(350, 350);
  }
}