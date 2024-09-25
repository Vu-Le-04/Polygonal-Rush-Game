import java.awt.event.*;

/**
 * An ActionListener that creates a ColorScreen.
 */
public class ColorListener implements ActionListener {

  ColorScreen screen = new ColorScreen();
  String color;

  /** 
   * Constructs a ColorListener object with the default color set to "RED".
   */
  ColorListener() {
    color = "RED";
  }

  /**
   * Invoked when an action occurs. Calls the click() method of the associated
   * ColorScreen object.
   * @param event the ActionEvent object representing the action
   */
  public void actionPerformed(ActionEvent event) {
    screen.click();
  }

  /**
   * Retrieves the current color of the associated ColorScreen object.
   * @return the color as a String
   */
  public String getColor() {
    return screen.getColor();
  }
}
