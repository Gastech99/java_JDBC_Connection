package com.objis.presentation;

import com.objis.dao.Connexion;
import com.objis.domaine.Employe;
import com.objis.exception.EntityNotFoundException;
import com.objis.dao.EmployeDao;

import java.sql.ResultSet;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        Connexion con = new Connexion();

        String sql = "SELECT * FROM employes";

        ResultSet rs = con.sqlSelect(sql);

        while (rs.next()){
            System.out.println(rs.getInt("id") + "\t" +rs.getString("nom") + "\t" + rs.getString("prenom") + "\t" + rs.getInt("est_directeur"));
        }

        // Test des services
            // Insertion
        Employe e = new Employe("Sall", "Fatim", false);
        EmployeDao es = new EmployeDao();

        es.addEmploye(e);

        es.deleteEmploye(e);

        try {
            es.getEmployeByName("Diop");
        } catch (EntityNotFoundException ent) {
            System.err.println("❌ Erreur : " + ent.getMessage() + " (Code : " + ent.getErrorCode().getCode() + ")");
        }

    }
}