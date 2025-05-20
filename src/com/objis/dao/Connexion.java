package com.objis.dao;

import java.sql.*;

public class Connexion {

    // Pour établir la connexion
    private Connection con;

    // Pou exécuter les requetes
    private Statement st;

    // Pour récupérer le résultat d'une requete SELECT
    private ResultSet rs = null;

    public Connexion(){
        try {
            // Chargement du driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Etablissement de la connexion
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_conge?useSSL=false&serverTimezone=UTC", "root", "");
            st = con.createStatement();

            System.out.println("✅ Connected success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sqlAction(String sql){
        try {
            st.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ResultSet sqlSelect(String sql){

        try {
            // Permet d'exécuter une requete de sélection
            rs = st.executeQuery(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
}
