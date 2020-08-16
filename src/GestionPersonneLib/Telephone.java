/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionPersonneLib;

import static ManageSingleConnexion.ImplementeConnexion.initConnexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author selemani
 */
public class Telephone implements IPersonne<TelephoneDAO> {

    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Statement statement;

    @Override
    public boolean enregistre(TelephoneDAO personne) {
        try {
            preparedStatement = initConnexion().prepareCall("Call sp_telephone(?,?,?,?,?)");
            preparedStatement.setString(1, personne.getInitial());
            preparedStatement.setString(2, personne.getNumero_());
            preparedStatement.setString(3, personne.getNom());
            preparedStatement.setString(4, personne.getPostnom());
            preparedStatement.setString(5, personne.getPrenom());
            return preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(TelephoneDAO personne) {
        try {
            preparedStatement = initConnexion().prepareStatement("delete from telephone where numero=?");
            preparedStatement.setString(1, personne.getNumero_());
            return preparedStatement.execute();
        } catch (SQLException e) {
        }
        return false;
    }

    @Override
    public List<TelephoneDAO> getData(String search) {
        List<TelephoneDAO> list = new ArrayList<>();
        try {
            resultSet = initConnexion().createStatement().executeQuery("select * from telephone");
            while (resultSet.next()) {
                TelephoneDAO tel = new TelephoneDAO(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
                list.add(tel);
            }
        } catch (SQLException ex) {
        }
        return list;
    }

    @Override
    public boolean update(TelephoneDAO personne) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nouveau() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
