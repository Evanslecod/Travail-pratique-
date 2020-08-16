/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionPersonneLib;

import static ManageSingleConnexion.ImplementeConnexion.initConnexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Selemani
 */
public class Personne implements IPersonne<PersonneDOA> {

    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Statement statement;

    static Personne init;

    static {
        init = new Personne();
    }

    @Override
    public boolean enregistre(PersonneDOA personne) {
        try {
            int id = 0;
            if (personne.getId() <= 0) {
                id = init.nouveau();
            } else {
                id = personne.getId();
            }
            String query = "Call sp_personne(?,?,?,?,?)";
            preparedStatement = initConnexion().prepareCall(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, personne.getNom());
            preparedStatement.setString(3, personne.getPostnom());
            preparedStatement.setString(4, personne.getPrenom());
            preparedStatement.setString(5, personne.getSexe());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException ex) {
        }
        return false;
    }

    @Override
    public boolean update(PersonneDOA personne) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(PersonneDOA personne) {
        try {
            preparedStatement = initConnexion().prepareStatement("Delete from personne where id=?");
            preparedStatement.setInt(1, personne.getId());
            return preparedStatement.execute();
        } catch (SQLException e) {
        }
        return false;
    }

    @Override
    public int nouveau() {
        try {
            resultSet = initConnexion().createStatement().executeQuery("select coalesce(max(id),0)+1 from personne");
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public List<PersonneDOA> getData(String search) {
        List<PersonneDOA> list = new ArrayList<>();
        try {
            list.clear();
            resultSet = initConnexion().createStatement().executeQuery("select * from personne");
            while (resultSet.next()) {
                PersonneDOA personne = new PersonneDOA();
                personne.setId(resultSet.getInt("id"));
                personne.setNom(resultSet.getString("nom"));
                personne.setPostnom(resultSet.getString("postnom"));
                personne.setPrenom(resultSet.getString("prenom"));
                personne.setSexe(resultSet.getString("sexe"));
//                personne.setId(resultSet.getInt("numero"));
                list.add(personne);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
	
    public static void main(String[] args) {
        PersonneDOA personne = new PersonneDOA();
        personne.setId(init.nouveau());
        personne.setNom("MUHUHA");
        personne.setPostnom("SELEMANI");
        personne.setPrenom("EVARISTE");
        personne.setSexe("M");
        init.enregistre(personne);
        List<PersonneDOA> pe = init.getData("Gloire");
        pe.forEach((p) -> {
            System.out.println(p.getId()+" "+p.getNom()+" "+p.getPostnom()+" "+p.getPrenom()+" "+p.getSexe());
        });
    }

}
