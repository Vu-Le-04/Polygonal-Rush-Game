import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.lang.*;
import java.util.*;

/**
 * The SpikeList class extends JComponent and represents a list of spikes in the
 * game.
 * It manages the generation, retrieval, and removal of MovingSpike objects.
 */
public class SpikeList extends JComponent {
  private int xPos = 500;
  private int numSpikes;
  LinkedList<MovingSpike> spikes = new LinkedList();
  Random r = new Random();
  MovingSpike s;

  /**
   * Constructs a new SpikeList object.
   * It generates the spikes.
   */
  public SpikeList() {
    generateSpikes();
  }

  /**
   * Constructs a new SpikeList object with the specified number of spikes.
   * @param n the number of spikes
   */
  public SpikeList(int n) {
    numSpikes = n;
    generateSpikes();
  }

  /**
   * Removes and returns the first MovingSpike from the list.
   * @return the removed MovingSpike, or null if the list is empty
   */
  public MovingSpike remove() {
    return remove();
  }

  /**
   * Gets the MovingSpike at the specified index in the list.
   * @param i the index of the MovingSpike to retrieve
   * @return the MovingSpike at the specified index, or null if the index is out of range
   */
  public MovingSpike get(int i) {
    if (spikes.get(i) == null) {
      return null;
    } else
      return spikes.get(i);
  }

  /**
   * Gets the length of the spike list.
   * 
   * @return the number of spikes in the list
   */
  public int length() {
    return spikes.size();
  }

  /**
   * Generates the spikes by creating MovingSpike objects and adding them to the
   * list.
   */
  public void generateSpikes() {
    for (int i = 0; i < numSpikes; i++) {
      s = new MovingSpike(xPos, 280, 100, 20, this);
      xPos += r.nextInt(50) + 400;
      spikes.add(s);
    }
  }
}