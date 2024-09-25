import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * The StartMenu class represents a start menu for a game.
 * It contains buttons for starting the game, accessing help, and changing
 * color.
 */
public class StartMenu {

  // instance variables
  private JPanel panel;
  private JButton startB;
  private JButton helpB;
  private JButton colorB;
  ActionListener sListener = new StartListener();
  ActionListener hListener = new HelpListener();
  ActionListener cListener = new ColorListener();

  /**
   * Constructs a new StartMenu object.
   * It creates the panel and initializes the buttons.
   */
  public StartMenu() {
    panel = new JPanel();
    startB = new JButton("START");
    helpB = new JButton("HELP");
    colorB = new JButton("COLOR");

    startB.addActionListener(sListener);
    helpB.addActionListener(hListener);
    colorB.addActionListener(cListener);
    panel.setLayout(new FlowLayout());
    panel.add(startB);
    panel.add(helpB);
    panel.add(colorB);
  }

  /**
   * Gets the panel containing the start menu.
   * @return the panel containing the start menu
   */
  public JPanel getPanel() {
    return panel;
  }

}
