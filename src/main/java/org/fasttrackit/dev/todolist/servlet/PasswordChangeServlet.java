package org.fasttrackit.dev.todolist.servlet;

import javax.servlet.annotation.WebServlet;

/**
 * Created by Csongor on 2/28/2017.
 */
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet ("/passwchange")
public class PasswordChangeServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // read user and password introduced by the user in the UI
        String username = request.getParameter("u");
        String password = request.getParameter("p");

        UserAccessList passChange = new UserAccessList();

        passChange.passwordChange(username, password);

        String back = "/todolist.html";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(back);
        dispatcher.forward(request, response);
    }

}
