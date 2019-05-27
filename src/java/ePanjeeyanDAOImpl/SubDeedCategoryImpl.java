package ePanjeeyanDAOImpl;

import ePanjeeyanDAO.SubDeedCategoryDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubDeedCategoryImpl implements SubDeedCategoryDAO {
    
     final String url = "jdbc:mysql://localhost/metadatabase";
    final String uname = "root";
    final String pswd = "root";
    final String driver = "com.mysql.jdbc.Driver";
    
    
     @Override
    public List<String> getSubDeedCategory(int code)
    {
        List<String> subdeed_category = new ArrayList();

        Connection con = null;
        Statement stmt = null;
         
        try {
            Class.forName(driver);

            con = DriverManager.getConnection(url, uname, pswd);

            //since no user input in sql statement hence use create statement
            stmt = con.createStatement();

            String query = "SELECT sub_deed_type FROM category WHERE code = " + code;
            ResultSet rs = stmt.executeQuery(query);

            // applicant_type.add(rs.getString("type"))-To add the result set in a list
            while (rs.next()) {
                subdeed_category.add(rs.getString("sub_deed_type"));
            }

        } catch (Exception ex) {
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception ex) {
            }

        }

        return subdeed_category;

    } 

    
}
