package org.fasttrackit.dev.todolist.servlet;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by icondor on 18/02/17.
 */


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {


    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("gooool");

        String username = request.getParameter("u");
                String password = request.getParameter("p");

                UserAccessList ual = new UserAccessList();



        ual.insertUser(username, password); // insert into users (?,?) ....

        // intoarcere la login

        String back = "/login.html";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(back);
        dispatcher.forward(request, response);
    }
}
