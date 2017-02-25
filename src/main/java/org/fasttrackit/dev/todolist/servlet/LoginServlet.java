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


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public static String _nickname = null;

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        // read user and password introduced by the user in the UI
        String user = request.getParameter("u");
        String passwd = request.getParameter("p");

        _nickname = user;

//        // static & simulated db row
//        final String dbu="razvan";
//        final String dbp="razvan95";





        UserAccessList userAccess = new UserAccessList();

        //final int userid=userAccess.getUserID(user);




        // version 5
        // the UI and the usability is so ugly
        // TASK: pls fix the UI and the usability by adding some css classes


        if(userAccess.checkUserCredentials(user, passwd)) {
            System.out.println(user + "0000");
            // userul exista in db, deci il autentific
            HttpSession session = request.getSession(true);
            session.setAttribute("username",user);


            String success = "/todolist.html";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(success);
            dispatcher.forward(request, response);
        }
        else {
            System.out.println("nu exista acest user in db, deci nu fac nimic ");
            String back = "/login.html";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(back);
            dispatcher.forward(request, response);
        }

        System.out.println("login service called...");

    }
}

