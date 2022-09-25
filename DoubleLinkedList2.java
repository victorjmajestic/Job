/* Victor Majestic
 * The extended double linked list class.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

/**
 * A doubly linked linked list.
 */
public class DoubleLinkedList2<T> implements Iterable<T> {
  /** a reference to the first node of the double linked list */
  private DLNode<T> front;
  
  /** a reference to the last node of a double linked list */
  private DLNode<T> back;
  
  /** a reference to the next node of a double linked list */
  private DLNode<T> next;
  
  /** a reference to the previous node of a double linked list */
  private DLNode<T> previous;
  
  /** a reference to the last element returned by next() or previous() */
  private DLNode<T> lastreturned;
  
  /** a reference to the current node */
  private DLNode<T> element;  
  
  /** a switch to determine if remove or add have been called after the last call to next or previous */
  private boolean nextpreviouscalled;
  
  /** Create an empty double linked list. */
  public DoubleLinkedList2() {
    front = back = next = null;
  }
  
  /** 
   * Returns true if the list is empty.
   * @return  true if the list has no nodes
   */
  public boolean isEmpty() {
    return (getFront() == null);
  }
  
  /**
   * Returns the reference to the first node of the linked list.
   * @return the first node of the linked list
   */
  protected DLNode<T> getFront() {
    return front;
  }
  
  /**
   * Sets the first node of the linked list.
   * @param node  the node that will be the head of the linked list.
   */
  protected void setFront(DLNode<T> node) {
    front = node;
  }
  
  /**
   * Returns the reference to the last node of the linked list.
   * @return the last node of the linked list
   */
  protected DLNode<T> getBack() {
    return back;
  }
  
  /**
   * Sets the last node of the linked list.
   * @param node the node that will be the last node of the linked list
   */
  protected void setBack(DLNode<T> node) {
    back = node;
  } 
  
  /**
   * Returns the next node of the linked list.
   * @return the next node of the linked list
   */
  protected DLNode<T> getNext() {
    return next;
  }
  
  /**
   * Returns the previous node of the linked list.
   * @return the previous node of the linked list
   */
  protected DLNode<T> getPrevious() {
    return previous;
  }
  
  /**
   * Sets the current node of the linked list.
   * @param node the new current node of the linked list.
   */
  protected void setElement(DLNode<T> node) {
    next = getElement().getNext();
    previous = getElement().getPrevious();
  }
  
  /**
   * Returns the reference to the last node of the linked list.
   * @return the last node of the linked list
   */
  protected DLNode<T> getElement() {
    return element;
  }
  
  /**
   * Add an element to the linked list.
   * @param element  the element to add to the front of the linked list
   */
  public void add(T newelement) throws IllegalStateException {
    if (lastreturned == null) {
      throw new IllegalStateException();
    }
    else if (nextpreviouscalled = true) {
      throw new IllegalStateException();
    }
    else if (isEmpty()) {
      DLNode<T> node2 = new DLNode<T>(newelement, null, null);
      setFront(node2);
      setBack(node2);
    }
    else {
      DLNode<T> node2 = new DLNode<T>(newelement, this.getPrevious(), this.getNext());
      this.getElement().setPrevious(this.getPrevious());
      this.getElement().setNext(this.getNext());
      this.getElement().setElement(node2.getElement());
    }
    nextpreviouscalled = true;
  }
  
  /**
   * Removes an element from the linked list.
   */
  public void remove() throws IllegalStateException {
    if (lastreturned == null) {
      throw new IllegalStateException();
    }
    else if (nextpreviouscalled = true) {
      throw new IllegalStateException();
    }
    else if (isEmpty()) {
    }
    else {
      this.getElement().getNext().setPrevious(this.getElement().getPrevious());
      this.getElement().getPrevious().setNext(this.getElement().getNext());
    }
  }
      
  /*
   * Returns if there is a node after the current node.
   * @param node the current node.
   * @return true if there is a node after the current node, false if there is not.
   */
  public boolean hasNext(DLNode<T> node) {
    if (node.getNext() == null) {
      return false;
    }
    else {
      return true;
    }
  }
  
  /*
   * Returns if there is a node before the current node.
   * @param node the current node.
   * @return true if there is a node before the current node, false if there is not.
   */
  public boolean hasPrevious(DLNode<T> node) {
    if (node.getPrevious() == null) {
      return false;
    }
    else {
      return true;
    }
  }
  
  /*
   * Returns the next element in the list and iterates to the next element.
   * @return the next element in the list.
   */
  public T next() throws NoSuchElementException {
    if (getNext() != null) {
      next = getNext();
      lastreturned = getNext();
      nextpreviouscalled = false;
      return getNext().getElement();
    }
    else {
      throw new NoSuchElementException();
    }
  }
  
  /*
   * Returns the previous element in the list and iterates to the previous element.
   * @return the previous element in the list.
   */
  public T previous() throws NoSuchElementException {
    if (getPrevious() != null) {
      previous = getPrevious();
      lastreturned = getPrevious();
      nextpreviouscalled = false;
      return getPrevious().getElement();
    }
    else {
      throw new NoSuchElementException();
    }
  }
  
  /**
   * Returns an interator for the linked list that starts at the head of the list and runs to the tail.
   * @return  the iterator that runs through the list from the head to the tail
   */
  @Override
  public Iterator<T> iterator() {
    return null;
  }
}