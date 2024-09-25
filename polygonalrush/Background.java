import javax.swing.*;
import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/*
 * A class that sets an image as the background of a panel
*/
public class Background extends JPanel {
  private Image background;

  /*
   * Constructs a Background object with an image file
   * @param background the image to set the background as
   */
  public Background(Image background) {
    this.background = background;
    setLayout(new BorderLayout());
  }

  /*
   * Paint component for Background
   * @param g the Graphics object
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(background, 0, 0, null); // image full size
  }

}
