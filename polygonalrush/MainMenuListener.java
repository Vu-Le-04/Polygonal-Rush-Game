import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

/**
 * This class implements the ActionListener interface and serves as a listener
 * for the main menu events.
 * It handles the action performed when an event occurs.
 */
public class MainMenuListener implements ActionListener {
  /**
   * Constructs a new instance of the MainMenuListener class.
   */
  MainMenuListener() {
  }

  /**
   * @param event the ActionEvent object representing the event
   */
  public void actionPerformed(ActionEvent event) {
    // try {
    //   Component c = new Component();
    //   JFrame frame = new JFrame();
    //   frame.setSize(700, 430);
    //   frame.setTitle("Polygonal Rush");
    //   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //   frame.add(new StartMenu().getPanel());
    //   frame.setVisible(true);
    // } catch (Exception e) {
    // }
    if(ColorScreen.cframe != null)
      ColorScreen.cframe.setVisible(false);
    if(GameScreen.gframe != null)
      GameScreen.gframe.setVisible(false);
    if(Component.vFrame != null)
      Component.vFrame.setVisible(false);
    if(Component.dframe != null)
      Component.dframe.setVisible(false);
  }
}