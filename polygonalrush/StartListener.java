import java.awt.event.*;
import javax.swing.*;

/**
 * The StartListener class implements the ActionListener interface.
 * It handles the action event triggered by the "START" button in the start
 * menu.
 */
public class StartListener implements ActionListener {
  /**
   * Constructs a new StartListener object.
   */
  public StartListener() {
  }

  /**
   * 
   * Performs the action when the "START" button is clicked.
   * It creates a new GameScreen object and invokes the click() method.
   * @param event the action event triggered by the "START" button
   */
  public void actionPerformed(ActionEvent event) {
    GameScreen game = new GameScreen();
    game.click();
  }

}
