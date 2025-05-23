package com.objis.dao;

import com.objis.domaine.Employe;
import com.objis.exception.EntityNotFoundException;
import com.objis.exception.ErrorCodes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeDao {

    public static Connexion con;

    public EmployeDao(){
        con = new Connexion();
    }

    public Employe getEmployeByName(String nom) {
        String sql = "SELECT * FROM employes WHERE nom = 'Diop'" ;
        ResultSet rs = con.sqlSelect(sql);

        try {
            if (rs.next()) {
                return new Employe(
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getInt("est_directeur") == 1
                );
            } else {
                throw new EntityNotFoundException("Aucun employé trouvé sous ce nom : " + nom, ErrorCodes.EMPLOYE_NOT_FOUND);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur SQL lors de la recherche de l'employé.", e);
        }
    }


    public void addEmploye(Employe emp) {
        String sql = "INSERT INTO Employes (nom, prenom) VALUES (?, ?)";

        try {
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, emp.getNom());
            ps.setString(2, emp.getPrenom());
            ps.executeUpdate();
            System.out.println("Employé ajouté avec succès !");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'ajout de l'employé.");
        }
    }

    public void deleteEmploye(Employe emp) throws SQLException {
        String sql = "DELETE FROM employes WHERE nom = ?";
        PreparedStatement stmt = con.getConnection().prepareStatement(sql);
        stmt.setString(1, emp.getNom());
        stmt.executeUpdate();
        System.out.println("Employé supprimé avec succès !");

    }

}
