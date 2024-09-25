import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;


public class Main {
  public static void main(String[] args) {
    JFrame sframe = new JFrame();
    sframe.setSize(700,430);
    sframe.setTitle("Polygonal Rush");
    sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    sframe.add(new StartMenu().getPanel());
    sframe.setVisible(true);


  }
}