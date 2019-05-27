package ePanjeeyanServlet;

import ePanjeeyanDAOImpl.HolidayDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

public class GetHolidayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HolidayDAOImpl obj = new HolidayDAOImpl();
        List<String> list = obj.getHolidays();
    
        System.out.println(list.toString());
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        //printwriter object to write in 
        PrintWriter out = response.getWriter();

        //converting the arraylist into json array
        JSONArray jsArray = new JSONArray(list);

        //jsonarray list is printed in the browser
        out.print(jsArray);

    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
}
