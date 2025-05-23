package com.objis.dao;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class Connexion {

    // Pour établir la connexion
    private Connection con;

    // Pou exécuter les requetes
    private Statement st;

    // Pour récupérer le résultat d'une requete SELECT
    private ResultSet rs = null;

    public Connexion(){
        try {

            Properties properties = new Properties();
            FileInputStream data = new FileInputStream("src/data.properties");
            properties.load(data);

            // Chargement du driver
            Class.forName(properties.getProperty("driver"));

            // Etablissement de la connexion
            con = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
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

    public Connection getConnection() {
        return this.con;
    }

}
