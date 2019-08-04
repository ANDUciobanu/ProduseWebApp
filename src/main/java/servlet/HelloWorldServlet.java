package servlet;
import db.User;
import db.UserNameCreator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.util.Scanner;


@WebServlet (name="HelloServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

    private String name;
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
       UserNameCreator userNameCreator  = new UserNameCreator();
       userNameCreator.getUserByName("andu");
        PrintWriter out= new PrintWriter(response.getWriter());
        out.println("<html><head><title>Hello world </title><head>");

       // out.println("<body>Hello "+ userNameCreator.getUserByName("andu")+new Date());
        out.println("</body></html>");
        out.close();


       //        User user = new User();
//        user.setUser("ionut");
//        user.setPassword("5678");
//        userNameCreator.insertProdus(user);




//        PrintWriter out= new PrintWriter(response.getWriter());
//        out.println("<html><head><title>Hello world </title><head>");
//        out.println("<body>Hello world at "+new Date());
//        out.println("</body></html>");
//
//        out.close();

    }
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        String name= request.getParameter("user");
        String password = request.getParameter("password");
        this.name=name;

        UserNameCreator userNameCreator  = new UserNameCreator();
        try {
            User user = userNameCreator.getUserByName(name);
//        PrintWriter out= new PrintWriter(response.getWriter());
//        out.println("<html><head><title>Hello world </title><head>");
//        out.println("<body>Hello "+name+" "+ new Date());
//        out.println("</body></html>");
//        out.close();

            request.setAttribute("name", name);
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
