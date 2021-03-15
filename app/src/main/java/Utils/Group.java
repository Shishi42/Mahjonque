
package Utils;

import java.util.List;
import java.util.LinkedList;


/**
 * This class represent a group of object.
 * It has a maximal size and cannot contain multiple times the same element.
 * @author Salome Miha
 * @version 0.1
 */
public class Group<T> {

  private List<T> list;
  private int size;

  /**
   * This constructor create a new Group
   * @param size The maximal size of the group
   */
  public Group(int size) {

    this.list = new LinkedList<>();
    this.size = size;

  }

  /**
   * This method add an element to the group if the group is not full
   * @param element The element to add
   */
  public void add(T element) {
    if(this.list.size() < this.size) {
      this.list.add(element);
    }
  }


  /**
   * This method is used to remove an element from the group
   * @param element The element to remove
   */
  public void remove(T element) {
    this.list.remove(element);
  }


  /**
   * This method is used to get the elements of the group.
   * @return The elements of the group.
   */
  public List<T> getElements() {
    return this.list;
  }

  /**
   * This method is used to get an element of the group.
   * @param position The position of the element to take.
   * @return The element at the given position.
   */
  public T getElement(int position) {
    return this.list.get(position);
  }


  /**
   * This method return the position in the group of a given element
   * @param element The element to find in the group
   * @return The position of the element
   */
  public int getPosition(T element) {
    return this.list.indexOf(element);
  }

  /**
   * This method is used to swap elements inside the group
   * @param element The new element to put.
   * @param position The position of the new element.
   */
  public void swapElement(T element, int position) throws IllegalArgumentException {

    if(position < 0 && position >= this.size) {
      throw new IllegalArgumentException("Group.swapElement() : " + position);
    }

    if(this.list.contains(element)) {                                       //If the element is already here
      this.list.set(this.list.indexOf(element), this.list.get(position));   //We swap places
    }

    this.list.set(position, element);

  }

}
