package ePanjeeyanDAOImpl;

import ePanjeeyanDAO.DeedCategoryDAO;
import ePanjeeyanModel.DeedCategoryModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeedCategoryDAOImpl implements DeedCategoryDAO {

    final String url = "jdbc:mysql://localhost/metadatabase";
    final String uname = "root";
    final String pswd = "root";
    final String driver = "com.mysql.jdbc.Driver";

    @Override
    public List<String> getDeedCategory() {

        List<String> deed_category = new ArrayList();

        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName(driver);

            con = DriverManager.getConnection(url, uname, pswd);

            //since no user input in sql statement hence use create statement
            stmt = con.createStatement();

            String query = "SELECT section FROM deedtype";
            ResultSet rs = stmt.executeQuery(query);

            // applicant_type.add(rs.getString("type"))-To add the result set in a list
            while (rs.next()) {
                deed_category.add(rs.getString("section"));
            }

        } catch (Exception ex) {
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception ex) {
            }

        }

        return deed_category;

    }
    
      @Override
    public List<DeedCategoryModel> getModel() {
       
       List<DeedCategoryModel> deed_category = new ArrayList();
        
        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName(driver);

            con = DriverManager.getConnection(url, uname, pswd);

            //since no user input in sql statement hence use create statement
            stmt = con.createStatement();

            String query = "SELECT * FROM deedtype";
            ResultSet rs = stmt.executeQuery(query);
            
           
            // applicant_type.add(rs.getString("type"))-To add the result set in a list
            while (rs.next()) {
               
                // pick code from result set
                int code = rs.getInt(1);
                
                // pick section from result set 
                String section = rs.getString(2);
                
                DeedCategoryModel obj = new DeedCategoryModel(code , section);
                
                deed_category.add(obj);
               
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
        finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception ex) {
            }

        }

        return deed_category;
    }

}
