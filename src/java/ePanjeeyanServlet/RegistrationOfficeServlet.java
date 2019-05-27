package ePanjeeyanServlet;

import com.google.gson.Gson;
import ePanjeeyanDAOImpl.RegistrationOfficeDAOImpl;
import ePanjeeyanModel.RegistrationOfficeModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationOfficeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RegistrationOfficeDAOImpl obj = new RegistrationOfficeDAOImpl();
        
         //list from DAOImpl is kept in the list 
        List< RegistrationOfficeModel> list = obj.getRegistrationOffices();
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
         Gson gson = new Gson();
        // converting list to JSON
        String json = gson.toJson(list);

  
        //printwriter object to write in 
        PrintWriter out = response.getWriter();
       
       
        //jsonarray list is printed in the browser
        out.print(json);
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

  
}
