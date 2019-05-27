package ePanjeeyanServlet;

import ePanjeeyanDAOImpl.SubDeedCategoryImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

public class SubDeedCategoryServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String code = request.getParameter("codeVal") ; //reading the get parameter from URL
        int codeNum = 0;
        
        try {
            codeNum = Integer.parseInt(code);           // string to int
        } 
        catch (Exception ex) {
            
        }
       
        SubDeedCategoryImpl obj = new SubDeedCategoryImpl();

        //list from BookDAOImpl is kept in the list 
        List<String> list = obj.getSubDeedCategory(codeNum);

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
