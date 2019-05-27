package ePanjeeyanDAOImpl;

import ePanjeeyanDAO.HolidayDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HolidayDAOImpl implements HolidayDAO{
    
    final String url = "jdbc:mysql://localhost/metadatabase";
    final String uname = "root";
    final String pswd = "root";
    final String driver = "com.mysql.jdbc.Driver";
    
    @Override
    public List<String> getHolidays() {
      
        List<String> holidays = new ArrayList<>();
        SimpleDateFormat ddFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName(driver);

            con = DriverManager.getConnection(url, uname, pswd);

            //since no user input in sql statement hence use create statement
            stmt = con.createStatement();

            String query = "SELECT date FROM holiday";
            ResultSet rs = stmt.executeQuery(query);

        
            while (rs.next()) {
              
                holidays.add(ddFormat.format(rs.getDate("date")));
            }

        } 
        catch (Exception ex) {
            System.out.println("exception: " + ex.getMessage());
        } 
        finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception ex) {
            }

        }

        return holidays;
        
        
    }
    
}
