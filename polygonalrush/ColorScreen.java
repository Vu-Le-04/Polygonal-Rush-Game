import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.awt.event.*;

/*
 *  A class to create a JFrame associated with the color selection screen
 */
public class ColorScreen extends DoubleLinkedList {

  private int xPos;
  private int yPos;
  private static int floorHeight = 280;
  private static int SIZE = 25;
  public static String color = "RED";
  Image img;
  DoubleLinkedList blue;
  DoubleLinkedList red;
  DoubleLinkedList orange;
  DoubleLinkedList green;
  NextListener nListener = new NextListener();
  PreviousListener pListener = new PreviousListener();
  MainMenuListener bListener = new MainMenuListener();
  public static JFrame cframe;
  DoubleLinkedList currentColor;
  JComponent component;
  JLabel picLabel;
  JPanel panel = new JPanel();

  /*
   * Creates a JFrame and a DoubleLinkedList for the color options
   */
  public ColorScreen() {
    red = new DoubleLinkedList("RED", null, null);
    blue = new DoubleLinkedList("BLUE", red, null);
    orange = new DoubleLinkedList("ORANGE", blue, null);
    green = new DoubleLinkedList("GREEN", orange, red);
    red.setPrevious(green);
    red.setNext(blue);
    blue.setNext(orange);
    orange.setNext(green);
    currentColor = new DoubleLinkedList("RED", green, blue);

    try {
      img = ImageIO.read(new File("Images//RED.png"));
    } catch (Exception e) {}

  }

  /*
   * Initializes the JFrame with a JPanel for the color selection screen
   * Called in ColorListener when a button associated with the listener is clicked
   */
  public void click() {
    cframe = new JFrame();
    cframe.setSize(700, 430);
    cframe.setTitle("Color Chooser");
    cframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton back = new JButton("BACK");
    JButton next = new JButton("NEXT");
    JButton previous = new JButton("PREVIOUS");
    next.addActionListener(nListener);
    previous.addActionListener(pListener);
    back.addActionListener(bListener);
    panel.setLayout(new BorderLayout());
    panel.add(next, BorderLayout.EAST);
    panel.add(previous, BorderLayout.WEST);
    panel.add(back, BorderLayout.SOUTH);
    picLabel = new JLabel(new ImageIcon(img));
    panel.add(picLabel, BorderLayout.CENTER);
    cframe.add(panel);
    cframe.setVisible(true);
  }

  /*
   * Assigns the variable img to a image read from a file
   */
  public void setImage() {
    try {
      if (getColor() == "BLUE") {
        img = ImageIO.read(new File("Images//BLUE.png"));
      } else if (getColor() == "RED") {
        img = ImageIO.read(new File("Images//RED.png"));
      } else if (getColor() == "ORANGE") {
        img = ImageIO.read(new File("Images//ORANGE.png"));
      } else {
        img = ImageIO.read(new File("Images//GREEN.png"));
      }
    }

    catch (IOException e) {
      System.out.println("File not found");
    }
  }

  /*
   * Assigns the variable currentColor to the next color in the list
   */
  public void nextColor() {
    currentColor = currentColor.getNext();
    color = getColor();
    setImage();
    panel.remove(picLabel);
    picLabel = new JLabel(new ImageIcon(img));
    panel.add(picLabel, BorderLayout.CENTER);
    panel.revalidate();
    panel.repaint();

  }

  /*
   * Assigns the variable currentColor to the previous color in the list
   */
  public void previousColor() {
    currentColor = currentColor.getPrevious();
    color = getColor();
    setImage();
    panel.remove(picLabel);
    picLabel = new JLabel(new ImageIcon(img));
    panel.add(picLabel, BorderLayout.CENTER);
    panel.revalidate();
    panel.repaint();

  }

  /*
   * Gets the current color as a String value
   * @return the current Color as a String
   */
  public String getColor() {
    return currentColor.getValue();
  }

  /*
   * Draws the image
   * @param g2 the Graphics2D object
   */
  public void draw(Graphics2D g2) {
    try {
      g2.drawImage(img, xPos, yPos, SIZE, SIZE, null);
    } catch (Exception e) {
    }
  }

  /*
   * Hides the frame
   */
  public void disposeFrame() {
    cframe.setVisible(false);
  }

  /**
   * 
   * This class represents an ActionListener for the "Next" button.
   * It implements the ActionListener interface and is designed to handle
   * the actionPerformed event triggered by the "Next" button.
   */
  class NextListener implements ActionListener {

    /**
     * 
     * Constructs a new instance of NextListener.
     */
    NextListener() {
    }

    /**
     * This method is invoked when the actionPerformed event is triggered.
     * It calls the nextColor() method to perform the necessary actions
     * when the "Next" button is clicked.
     * @param event the ActionEvent object representing the event
     */
    public void actionPerformed(ActionEvent event) {
      nextColor();
    }
  }

  /**
   * This class represents an ActionListener for the "Previous" button.
   * It implements the ActionListener interface and is designed to handle
   * the actionPerformed event triggered by the "Previous" button.
   */
  class PreviousListener implements ActionListener {

    /**
     * Constructs a new instance of PreviousListener.
     */
    PreviousListener() {}

    /**
     * This method is invoked when the actionPerformed event is triggered.
     * It calls the previousColor() method to perform the necessary actions
     * when the "Previous" button is clicked.
     * @param event the ActionEvent object representing the event
     */
    public void actionPerformed(ActionEvent event) {
      previousColor();
    }
  }
}
