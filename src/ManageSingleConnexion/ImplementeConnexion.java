/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageSingleConnexion;

import ManageSingleConnexion.ConnexionType.connexionType;
import java.sql.*;

/**
 *
 * @author selemani
 */
public class ImplementeConnexion implements IConnexion {

    public Connection _connexion;
    private static final ImplementeConnexion _instance;

    static {
        _instance = new ImplementeConnexion();
    }

    @Override
    public Connection Initialise(Connexion connexion, connexionType connectionType) {
        switch (connectionType) {
            case SQLServer: {
                try {
                    return DriverManager.getConnection("jdbc:sqlserver://" + connexion.getServeur() + ";databaseName=" + connexion.getDatabase() + "", connexion.getUser(), connexion.getPassword());
                } catch (SQLException ex) {

                }
            }
            break;
            case MySQL:
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    return DriverManager.getConnection("jdbc:mysql://" + connexion.getServeur() + ":3306/" + connexion.getDatabase(), connexion.getUser(), connexion.getPassword());
                } catch (SQLException | ClassNotFoundException e) {
                }
                break;

            case PostGrsSQL: {
                try {
                    return DriverManager.getConnection("jdbc:postgresql://" + connexion.getServeur() + ":5432/" + connexion.getDatabase(), connexion.getUser(), connexion.getPassword());
                } catch (SQLException e) {
                }
            }
            break;
            case Oracle:
                try {

                } catch (Exception e) {
                }

                break;

            case Access: {
                _connexion = null;
            }
            break;

            case Fire_base: {
                _connexion = null;
            }
            break;

        }
        return null;
    }

    public static Connection initConnexion() {
        Connexion init = null;
        if (init == null) {
            init = new Connexion("localhost", "gestion_personne", "root", "");
            System.out.println("connexion n'exister pas");
        }
        return _instance.Initialise(init, connexionType.MySQL);
    }

}
