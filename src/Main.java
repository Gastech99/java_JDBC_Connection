import com.objis.dao.Connexion;

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

    }
}