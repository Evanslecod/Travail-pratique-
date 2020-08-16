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
public class PersonneDOA {

    private int id;
    private String nom;
    private String postnom;
    private String prenom;
    private String sexe;

    public PersonneDOA() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom.trim().length() > 0) {
            this.nom = nom;
        }

    }

    public String getPostnom() {
        return postnom;
    }

    public void setPostnom(String postnom) {
        if (postnom.trim().length() > 0) {
            this.postnom = postnom;
        }

    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        if (prenom.trim().length() > 0) {
            this.prenom = prenom;
        }

    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        if (sexe.trim().length() > 0) {
            this.sexe = sexe;
        }
    }
}
