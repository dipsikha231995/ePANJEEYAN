package ePanjeeyanDAOImpl;

import ePanjeeyanDAO.RegistrationOfficeDAO;
import ePanjeeyanModel.RegistrationOfficeModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RegistrationOfficeDAOImpl implements RegistrationOfficeDAO {

    final String url = "jdbc:mysql://localhost/metadatabase";
    final String uname = "root";
    final String pswd = "root";
    final String driver = "com.mysql.jdbc.Driver";

    @Override
    public List<RegistrationOfficeModel> getRegistrationOffices() {

        List<RegistrationOfficeModel> office_name_list = new ArrayList<>();

        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName(driver);

            con = DriverManager.getConnection(url, uname, pswd);

            //since no user input in sql statement hence use create statement
            stmt = con.createStatement();

            String query = "SELECT office_name,sro_code FROM sro_offices";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String officeName = rs.getString("office_name");
                int sroCode = rs.getInt("sro_code");

                office_name_list.add(new RegistrationOfficeModel(officeName, sroCode)); // To add the result set in a list

            }

        } catch (Exception ex) {
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception ex) {
            }

        }

        return office_name_list;
    }

}
