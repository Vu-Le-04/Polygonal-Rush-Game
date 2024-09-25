import java.awt.event.*;
import javax.swing.*;

/**
 * The HelpListener class is an implementation of the ActionListener interface
 * that handles the action performed event.
 */
public class HelpListener implements ActionListener {
  /**
   * Constructs a new HelpListener object.
   */
  HelpListener() {
  }

  /**
   * Invoked when an action occurs.
   * Creates a HelpScreen object and triggers a click event on it.
   * @param event the action event
   */
  public void actionPerformed(ActionEvent event) {
    HelpScreen screen = new HelpScreen();
    screen.click();
  }
}
