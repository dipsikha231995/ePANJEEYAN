package ePanjeeyanServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //read the user submitted post values in the android app
        String referenceNum = request.getParameter("refno");
        
        System.out.println("param: " + referenceNum);

        JSONObject getref = new JSONObject();
        try {
            getref.put("data", referenceNum + "posted");
        } catch (JSONException ex) {

        }
        
        System.out.println("json: " + getref);
        
        
        // Set response content type
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.print(getref);
    }
}
