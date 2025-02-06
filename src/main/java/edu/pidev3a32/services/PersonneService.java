package edu.pidev3a32.services;

import edu.pidev3a32.entities.Personne;
import edu.pidev3a32.interfaces.IService;
import edu.pidev3a32.tools.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonneService implements IService<Personne> {

    @Override
    public void addEntity(Personne personne) {
        try {
        String requete = "INSERT INTO personne(nom, prenom) " +
                "VALUES ('" + personne.getNom() + "','" + personne.getPrenom() + "')";

            Statement st = MyConnection.getInstance().getCnx().createStatement();

            st.executeUpdate(requete);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addEntity2(Personne personne){
        try {
            String requete = "INSERT INTO personne(nom, prenom) " +
                "VALUES (? , ?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, personne.getNom());
            pst.setString(2, personne.getPrenom());
            pst.executeUpdate();
            System.out.println("Success!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteEntity(Personne personne) {

    }

    @Override
    public void updateEntity(int id, Personne personne) {

    }

    @Override
    public List<Personne> getAllData() {
        List<Personne> results = new ArrayList();
        String requete = "SELECT * FROM personne";
        try {
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Personne p = new Personne();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                results.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results;
    }
}
