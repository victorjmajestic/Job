/** 
 * Victor Majestic
 * A class to represent a schedule.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Schedule<ScheduleSlot> implements Iterable<ScheduleSlot> {
  
  /** A reference to the front node. */
  private DLNode<ScheduleSlot> front;
  
  /** A reference to the end node. */
  private DLNode<ScheduleSlot> back;
  
  /** A nested class that creates the doubly linked list. */
  private class DLNode<ScheduleSlot> {
    
    /** A reference to the current element of the linked list. */
    ScheduleSlot element;
    
    /** A reference to the next element of the linked list. */
    DLNode<ScheduleSlot> next;
    
    /** A reference to the previous element of the linked list. */
    DLNode<ScheduleSlot> previous;
    
    /** A constructor that creates the linked list. */
    public DLNode(ScheduleSlot element, DLNode<ScheduleSlot> previous, DLNode<ScheduleSlot> next) {
      this.element = element;
      this.previous = previous;
      this.next = next;
    }
    
    /** 
     * Returns the current element.
     * @return the current element.
     */
    protected ScheduleSlot getElement() {
      return element;
    }
    
    /** 
     * Changes the current element.
     * @param element the new element.
     */
    protected void setElement(ScheduleSlot element) {
      this.element = element;
    }

    /** 
     * Returns the next slot.
     * @return the next slot.
     */
    protected DLNode<ScheduleSlot> getNext() {
      return next;
    }

    /** 
     * Sets the next slot.
     * @param next the slot to replace the next spot.
     */
    protected void setNext(DLNode<ScheduleSlot> next) {
      this.next = next;
    }

    /** 
     * Returns the previous slot.
     * @return the previous slot.
     */
    protected DLNode<ScheduleSlot> getPrevious() {
      return previous;
    }

    /** 
     * Sets the previous slot.
     * @param previous the slot to replace the previous slot.
     */
    protected void setPrevious(DLNode<ScheduleSlot> previous) {
      this.previous = previous;
    }
  }
  
  /** 
   * Returns the first slot.
   * @return the first slot.
   */
  protected DLNode<ScheduleSlot> getFront() {
    return front;
  }
  
  /** 
   * Returns the last slot.
   * @return the last slot.
   */
  protected DLNode<ScheduleSlot> getBack() {
    return back;
  }
  
  /** 
   * Changes the first slot.
   * @param front the first slot.
   */
  protected void setFront(DLNode<ScheduleSlot> front) {
    this.front = front;
  }
  
  /** 
   * Changes the last slot.
   * @param back the last slot.
   */
  protected void setBack(DLNode<ScheduleSlot> back) {
    this.back = back;
  }
  
  /** 
   * Checks if the linked list is empty.
   * Returns true if it is empty, false if it is not empty.
   */
  public boolean isEmpty() {
    if (getFront() == null && getBack() == null) {
      return true;
    }
      return false;
  }
  
  /** 
   * Adds an element to the front of the linked list.
   * @param element the element to be added to the front of the linked list
   */
  public void addToFront(ScheduleSlot element) {
    if (isEmpty()) {
      DLNode<ScheduleSlot> node2 = new DLNode<ScheduleSlot>(element, null, null);           // node2 is the new node created with parameter element.
      setFront(node2);
      setBack(node2);
    }
    else {
      setFront(new DLNode<ScheduleSlot>(element, null, this.getFront()));
      this.getFront().getNext().setPrevious(this.getFront());
    }
  }
  
  /**
   * Add an element to the tail of the linked list.
   * @param element the element to add to the tail of the linked list
   */
  public void addToBack(ScheduleSlot element) {
    if (isEmpty()) {
      DLNode<ScheduleSlot> node2 = new DLNode<ScheduleSlot>(element, null, null);           // node2 is the new node created with parameter element.
      setFront(node2);
      setBack(node2);
    }
    else {
      setBack(new DLNode<ScheduleSlot>(element, this.getBack(), null));
      this.getBack().getPrevious().setNext(this.getBack());
    }
  }
  
  /** 
   * Removes the element from the front of the linked list.
   * @return the removed element.
   * @throws NoSuchElementException if the list is empty.
   */
  public ScheduleSlot removeFromFront() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    else {
      DLNode<ScheduleSlot> slot = front;                                                                                // slot is the node being removed.
      front = getFront().getNext();
      front.previous = null;
      return slot.getElement();
    }
  }
  
  /** 
   * Removes the element from the back of the linked list.
   * @return the removed element.
   * @throws NoSuchElementException if the list is empty.
   */
  public ScheduleSlot removeFromBack() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    else {
      DLNode<ScheduleSlot> slot = back;                                                                                 // slot is the node being removed.
      back = getBack().getPrevious();
      back.next = null;
      return slot.getElement();
    }
  }
  
  /**
   * Splits the linked list of nodes.
   * @return the first node that was removed.
   */
  private <ScheduleSlot> DLNode<ScheduleSlot> split(DLNode<ScheduleSlot> list1) {
    DLNode<ScheduleSlot> list2 = list1.getNext();                                                                       //The second half of the list.
    DLNode<ScheduleSlot> nodeptr = list2;                                                                               //The current node pointer.
    DLNode<ScheduleSlot> prevptr = list1;                                                                               //The previous node pointer.
    /* Iterates through the entire list until the pointer is null. */
    while (nodeptr != null) {
      prevptr.setNext(nodeptr.getNext());
      prevptr = nodeptr;
      nodeptr = nodeptr.getNext();
    }
    return list2;
  }
  
  /**
   * Merges both halves of the linked list into one linked list.
   * @param list1 the first half of the linked list.
   * @param list2 the second half of the linked list.
   * @return the first node of the combined list.
   */
  private <ScheduleSlot extends Comparable<? super ScheduleSlot>> DLNode<ScheduleSlot> merge(DLNode<ScheduleSlot> list1, DLNode<ScheduleSlot> list2) {
    DLNode<ScheduleSlot> finalList;                                                                                     //The final node of the combined list.
    if (list1.getElement().compareTo(list2.getElement()) < 0) {
      finalList = list1;
      list1 = list1.getNext();
    }
    else {
      finalList = list2;
      list2 = list2.getNext();
    }
    DLNode<ScheduleSlot> endptr = finalList;                                                                            //A variable that iterates through each node until the final node.
    /* Searches through both lists until the end of both lists. */
    while (list1 != null && list2 != null) {
      if (list1.getElement().compareTo(list2.getElement()) < 0) {
        endptr.setNext(list1);
        list1 = list2.getNext();
      }
      else {
        endptr.setNext(list2);
        list2 = list2.getNext();
      }
      endptr = endptr.getNext();
    }
    if (list1 == null)
      endptr.setNext(list2);
    else
      endptr.setNext(list1);
    return finalList;
  }
  
  /**
   * Sorts the list.
   * @param list the first node in the node list.
   * @return the first node of the sorted list.
   */
  private <ScheduleSlot extends Comparable<? super ScheduleSlot>> DLNode<ScheduleSlot> mergeSort(DLNode<ScheduleSlot> list) {
    if (list.getNext() == null)
      return list;
    DLNode<ScheduleSlot> list2 = split(list);
    list = mergeSort(list);
    list2= mergeSort(list2);
    return merge(list, list2);
  }
  
  /**
   * Merge sorts the linked list.
   * @param list the list that is being sorted.
   */
  public <ScheduleSlot extends Comparable<? super ScheduleSlot>> void mergeSort(DLNode<ScheduleSlot> list) {
    list.setFront(mergeSort(list.getFront()));
  }
  
  /**
   * Returns an interator for the linked list that starts at the head of the list and runs to the tail.
   * @return  the iterator that runs through the list from the head to the tail
   */
  public Iterator<ScheduleSlot> iterator() {
    return null;
  }
}