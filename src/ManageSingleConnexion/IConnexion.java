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
public interface IConnexion {
      Connection Initialise(Connexion connexion, connexionType connectionType);
}
