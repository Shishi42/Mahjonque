
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

  private List<T> liste;
  private int taille;

  public Group(int taille) {

    this.liste = new LinkedList<T>();
    this.taille = taille;

  }

  public void add(T element) {
    if(this.liste.size() < this.taille) {
      this.liste.add(element);
    }
  }

  public void remove(T element) {
    this.liste.remove(element);
  }


  /**
   * This method is used to get the elements of the group.
   * @return The elements of the group.
   */
  public List<T> getElements() {
    return this.liste;
  }

  /**
   * This method is used to get an element of the group.
   * @param position The position of the element to take.
   * @return The element at the given position.
   */
  public T getElement(int position) {
    return this.liste.get(position);
  }



  public int getPosition(T element) {
    return this.liste.indexOf(element);
  }

  /**
   * Cette méthode permet de modifier les elements dans le groupe
   * This method is used to swap elements inside the group
   * @param element The new element to put.
   * @param position The position of the new element.
   */
  public void swapElement(T element, int position) throws IllegalArgumentException {

    if(position < 0 && position >= this.taille) {
      throw new IllegalArgumentException("Groupe.changeElement() : " + position);
    }

    if(this.liste.contains(element)) {                                        //If the element is already here
      this.liste.set(this.liste.indexOf(element), this.liste.get(position));  //We swap places
    }

    this.liste.set(position, element);

  }


}
