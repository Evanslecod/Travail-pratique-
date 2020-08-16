/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionPersonneLib;

/**
 *
 * @author selemani
 */
public class TelephoneDAO {

    private String numero_;
    private String initial;
    private String nom;
    private String postnom;
    private String prenom;

    public TelephoneDAO() {
    }

    public String getNumero_() {
        return numero_;
    }

    public String getInitial() {
        return initial;
    }

    public String getNom() {
        return nom;
    }

    public String getPostnom() {
        return postnom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNumero_(String numero_) {
        this.numero_ = numero_;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPostnom(String postnom) {
        this.postnom = postnom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public TelephoneDAO(String numero_, String initial, String nom, String postnom, String prenom) {
        this.numero_ = numero_;
        this.initial = initial;
        this.nom = nom;
        this.postnom = postnom;
        this.prenom = prenom;
    }

}
