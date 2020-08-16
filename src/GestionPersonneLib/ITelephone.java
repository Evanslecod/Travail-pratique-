/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionPersonneLib;

import java.util.List;

/**
 *
 * @author selemani
 */
public interface ITelephone<T> {

    boolean enregistre(T personne);

    boolean update(T personne);

    boolean delete(T personne);

    int nouveau();

    List<T> getData(String search);
}
