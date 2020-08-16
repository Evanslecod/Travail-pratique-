/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageSingleConnexion;

/**
 *
 * @author selemani
 */
public class Connexion {

    private String _serveur ;
    private String _database ;
    private String _user;
    private String _password ;
    private int _port = 0;
 

    public Connexion(String _serveur, String _database, String _user, String _password) {
        this._database = _database;
        this._password = _password;
        this._serveur = _serveur;
        this._user = _user;
    }

    
    public Connexion() {
    }

    /**
     * @return the _serveur
     */
    public String getServeur() {
        return _serveur;
    }

    /**
     * @param _serveur the _serveur to set
     */
    public void setServeur(String _serveur) {
        if (_serveur.length() > 0) {
            this._serveur = _serveur;
        }

    }

    /**
     * @return the _database
     */
    public String getDatabase() {
        return _database;
    }

    /**
     * @param _database the _database to set
     */
    public void setDatabase(String _database) {
        if (_database.length() > 0) {
            this._database = _database;
        }

    }

    /**
     * @return the _user
     */
    public String getUser() {
        return _user;
    }

    /**
     * @param _user the _user to set
     */
    public void setUser(String _user) {
        if (_user.length() > 0) {
            this._user = _user;
        }

    }

    /**
     * @return the _password
     */
    public String getPassword() {
        return _password;
    }

    /**
     * @param _password the _password to set
     */
    public void setPassword(String _password) {
        if (_password.length() > 0) {
            this._password = _password;
        }

    }

    /**
     * @return the _port
     */
    public int getPort() {
        return _port;
    }

    /**
     * @param _port the _port to set
     */
    public void setPort(int _port) {
        if (_port >= 0) {
            this._port = _port;
        }

    }

}
