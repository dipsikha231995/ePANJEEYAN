package ePanjeeyanDAOImpl;

import java.sql.*;
import ePanjeeyanDAO.ApplicantTypeDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ePanjeeyanModel.ApplicantTypeModel;

public class ApplicantTypeDAOImpl implements ApplicantTypeDAO {

    final String url = "jdbc:mysql://localhost/metadatabase";
    final String uname = "root";
    final String pswd = "root";
    final String driver = "com.mysql.jdbc.Driver";
  
    @Override
    public List<ApplicantTypeModel> getApplicantType() {

        List<ApplicantTypeModel> applicant_type = new ArrayList<>();

        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName(driver);

            con = DriverManager.getConnection(url, uname, pswd);

            //since no user input in sql statement hence use create statement
            stmt = con.createStatement();

            String query = "SELECT type, exempted FROM applicant_type";
            ResultSet rs = stmt.executeQuery(query);

            // applicant_type.add(rs.getString("type"))-To add the result set in a list
            while (rs.next()) {
                int exempted = rs.getInt("exempted");
                String type = rs.getString("type");
                
                applicant_type.add(new ApplicantTypeModel(type, exempted));
           
            }

        } catch (Exception ex) {
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception ex) {
            }

        }

        return applicant_type;

    }

}
