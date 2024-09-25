import static java.lang.System.*;

/*
 * Class for a DoubleLinkedList for color selection
 */
public class DoubleLinkedList {
  private String data;
  private DoubleLinkedList next;
  private DoubleLinkedList prev;

  /*
   * Constructs an empty DoubleLinkedList
   */
  public DoubleLinkedList() {
  }

  /*
   * Constructs a DoubleLinkedList with data, previous, and next values
   * @param dat the data
   * @param prv the previous data
   * @param nxt the next data
   */
  public DoubleLinkedList(String dat, DoubleLinkedList prv, DoubleLinkedList nxt) {
    data = dat;
    prev = prv;
    next = nxt;
  }

  /*
   * Sets the next value
   * @param nxt the next value to set
   */
  public void setNext(DoubleLinkedList nxt) {
    next = nxt;
  }

  /*
   * Sets the previous value
   * @param prv the previous value
   */
  public void setPrevious(DoubleLinkedList prv) {
    prev = prv;
  }

  /*
   * Gets the next value
   * @return the next DoubleLinkedList value
   */
  public DoubleLinkedList getNext() {
    return next;
  }

  /*
   * Gets the previous value
   * @return the previous DoubleLinkedList value
   */
  public DoubleLinkedList getPrevious() {
    return prev;
  }

  /*
   * Gets the current value
   * @return the current value
   */
  public String getValue() {
    return data;
  }
}