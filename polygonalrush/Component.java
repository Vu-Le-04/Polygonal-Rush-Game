import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.imageio.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

/*
 *  A component class for the contents of the GameScreen along with animation processes
 */
public class Component extends JComponent implements KeyListener, ActionListener {
  private MovingPlayer p1;
  private boolean spaceBar;
  private Timer timer;
  private static final int UPDATE_INTERVAL = 10;
  private boolean jumpOk;
  private Image background;
  private int nx2 = 690;
  private int nx;
  private int xVal = 2075;
  private int numSpikes = 20;
  SpikeList spikes;
  private boolean alive = true;
  private JFrame gameFrame;
  public static JFrame dframe;
  MainMenuListener mListener = new MainMenuListener();
  public static JFrame vFrame;
  MovingFinishLine finish;
  private boolean victory;
  ColorListener colorL = new ColorListener();


  /*
   * Creates a Component and initializes instance variables
   */
  public Component() throws Exception {
    p1 = new MovingPlayer(10, 280, this);
    background = ImageIO.read(new File("Images//background.jpg"));
    this.addKeyListener(this);
    timer = new Timer(UPDATE_INTERVAL, this);
    timer.start();
    spaceBar = false;
    jumpOk = false;
    victory = false;
    setFocusable(true);
    requestFocus();
    finish = new MovingFinishLine(9000, 0, 100, 20, this);
    spikes = new SpikeList(numSpikes);
  }

  /*
   * Paints the contents in Component
   * Checks if the game is ongoing or over due to the status of the player
   * Starts the animation processes
   * @param g the Graphics object
   */
  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    if ((xVal - 680) % 1380 == 0)
      nx = 0;
    if ((xVal - 1370) % 1380 == 0)
      nx2 = 0;
    g2.drawImage(background, 690 - nx2, 0, null);
    if (xVal >= 690)
      g2.drawImage(background, 690 - nx, 0, null);
    
    p1.draw(g2);
    finish.draw(g2);
    
    if (!alive) {
      dframe = new JFrame();
      dframe.setSize(700, 430);
      dframe.setTitle("YOU DIED");
      dframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel panel = new JPanel();
      panel.setLayout(new BorderLayout());
      JButton mainMenu = new JButton("Main Menu");
      mainMenu.addActionListener(mListener);
      JLabel jlabel = new JLabel("YOU DIED", SwingConstants.CENTER);
      jlabel.setBackground(Color.red);
      jlabel.setOpaque(true);
      jlabel.setFont(new Font("Comic Sans MS", 1, 40));
      panel.add(jlabel, BorderLayout.CENTER);
      panel.add(mainMenu, BorderLayout.SOUTH);
      dframe.add(panel);
      dframe.setVisible(true);
      gameFrame.dispose();
      timer.stop();
    }

    if(victory){
      vFrame = new JFrame();
      vFrame.setTitle("YOU WON");
      vFrame.setSize(700,430);
      vFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel panel = new JPanel();
      panel.setLayout(new BorderLayout());
      JButton mainMenu = new JButton("Main Menu");
      mainMenu.addActionListener(mListener);
      JLabel jlabel = new JLabel("YOU WON", SwingConstants.CENTER);
      jlabel.setBackground(Color.GREEN);
      jlabel.setOpaque(true);
      jlabel.setFont(new Font("Comic Sans MS", 1, 40));
      panel.add(jlabel, BorderLayout.CENTER);
      panel.add(mainMenu, BorderLayout.SOUTH);
      vFrame.add(panel);
      vFrame.setVisible(true);
      gameFrame.dispose();
      timer.stop();
    }

    for (int i = 0; i < numSpikes; i++) {
      ((MovingSpike)(spikes.get(i))).draw(g2);
    }

    if (jumpOk) {
      p1.jump();
    } else
      p1.fall();

    checkCollisions();
    checkVictory();

    xVal++;
    nx2++;
    nx++;
    repaint();

  }

  /*
   * Method to start the animation processes
   */
  public void startAnimation() {
    try {
      for (int i = 0; i < numSpikes; i++) {
        Thread t = new Thread((MovingSpike)(spikes.get(i)));
        t.start();
      }
      Thread t2 = new Thread(finish);
      t2.start();
      if (!alive) {
        for (int i = 0; i < numSpikes; i++) {
        }
      }
    } catch (Exception e) {
      System.out.println("interrupted");
    }
  }

  /*
   * ActionPerformed method. Empty
   * @param e the ActionEvent
   */
  public void actionPerformed(ActionEvent e) {
  }

  /*
   * Manages key presses. Empty
   * @param e the KeyEvent
   */
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_SPACE && p1.getY() == p1.getFloorHeight()) {
      jumpOk = true;
      new Thread(new JumpThread()).start();
    }
  }

  /*
   * Manages key releases
   * Makes player jump when spacebar is released
   * @param e the KeyEvent
   */
  public void keyReleased(KeyEvent e) {

  }

  /*
   * Manages key typing. Empty
   * @param e the KeyEvent
   */
  public void keyTyped(KeyEvent e) {
  }

  /*
   * Thread to constantly check if user is pressing the spacebar to jump
   */
  public class JumpThread implements Runnable {
    @Override
    public void run(){
      try {
        Thread.sleep(250);
        jumpOk = false;
      } catch (Exception e) {
        e.printStackTrace();
        new Thread(this).start();
        System.exit(0);
      }
    }
  }

  /*
   * Checks if the player and spikes collide
   */
  public void checkCollisions() {
    Rectangle pBox = p1.getBounds();
    for (int i = 0; i < numSpikes; i++) {
      Rectangle sBox = spikes.get(i).getBounds();
      if (pBox.intersects(sBox)) {
        alive = false;
      }
    }
  }

  /*       
   * Hides the gameFrame
   */
  public void hideFrame() {
    gameFrame.setVisible(false);

  }

  /*
   * Sets gameFrame to a frame
   */
  public void setFrame(JFrame f) {
    gameFrame = f;
  }

  /*
   * Checks if player has won
   */
  public void checkVictory()  {
    Rectangle pBox = p1.getBounds();
    Rectangle fBox = finish.getBounds();
    if (pBox.intersects(fBox)) {
      victory = true;
  }
}

}