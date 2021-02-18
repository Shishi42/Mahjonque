
package Utils;

import java.util.List;
import java.util.LinkedList;


/**
 * Cette classe représente un groupe d'objet
 * Il a une taille maximale et ne peut contenir plusieurs fois le même élément
 * @author Salome Miha
 * @version 0.1
 */
public class Groupe<T> {

  private List<T> liste;
  private int taille;

  public Groupe(int taille) {

    this.liste = new LinkedList<T>();
    this.taille = taille;

  }

  public void ajoute(T element) {
    if(this.liste.size() < this.taille) {
      this.liste.add(element);
    }
  }

  public void retirer(T element) {
    this.liste.remove(element);
  }


  /**
   * Cette méthode permet de récupérer les elements dans le groupe
   * @return Les elements dans le groupe
   */
  public List<T> getElements() {
    return this.liste;
  }

  /**
  * Cette méthode permet de récupérer un element dans le groupe
   * @param position La position de l'element dans le groupe
   * @return L'élement à la position donnée en paramètre
   */
  public T getElement(int position) {
    return this.liste.get(position);
  }



  public int getPosition(T element) {
    return this.liste.indexOf(element);
  }

  /**
   * Cette méthode permet de modifier les elements dans le groupe
   * @param element Le nouveau element à mettre
   * @param position La position à laquelle mettre l'element
   */
  public void changeElement(T element, int position) throws IllegalArgumentException {

    if(position < 0 && position >= this.taille) {
      throw new IllegalArgumentException("Groupe.changeElement() : " + position);
    }

    if(this.liste.contains(element)) {                                        //Si l'élément est déjà present
      this.liste.set(this.liste.indexOf(element), this.liste.get(position));  //On échange les places
    }

    this.liste.set(position, element);

  }


}
