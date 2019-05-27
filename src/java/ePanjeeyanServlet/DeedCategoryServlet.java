package ePanjeeyanServlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ePanjeeyanDAOImpl.DeedCategoryDAOImpl;
import ePanjeeyanModel.DeedCategoryModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;


public class DeedCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        DeedCategoryDAOImpl obj = new DeedCategoryDAOImpl();
        List<DeedCategoryModel> list = obj.getModel();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        // converting list to JSON
        String json = gson.toJson(list);
       
        //printwriter object to write in 
        PrintWriter out = response.getWriter();

        //list is printed in the browser
        out.print(json);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

}
