package org.fasttrackit.dev.todolist.servlet;

import org.fasttrackit.dev.todolist.ToDoBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Razvan on 2/23/2017.
 */

public class UserAccessList {

    public UserAccessList(){}

    /*
    public int getUserID(String username){
        int id = 0;
        System.out.println("Aici incerc logarea");
        try {


            Class.forName("org.postgresql.Driver");


            // 2. define connection params to db
            final String URL = "jdbc:postgresql://54.93.65.5:5432/5NumePrenume";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";



            // 3. obtain a connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 4. create a query statement
//            Statement st = conn.createStatement();

            String query = "SELECT user_id FROM userlist where username = ?";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);


            // 5. execute a query
            ResultSet rs = statement.executeQuery();

            // 6. iterate the result set and print the values
            while (rs.next()) {
                id = rs.getInt("user_id");
                return id;

                // 7. close the objects

            }
            rs.close();
            statement.close();
            conn.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return id;

}

*/
    public int checkUserCredentials(String username, String password) {

        int iduser=-1;
        try {



            Class.forName("org.postgresql.Driver");


            // 2. define connection params to db
            final String URL = "jdbc:postgresql://54.93.65.5:5432/5NumePrenume";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";

            // 3. obtain a connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 4. create a query statement
//            Statement st = conn.createStatement();

            String query = "SELECT user_id FROM userlist where username = ? and password = ?";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            // 5. execute a query
            ResultSet rs = statement.executeQuery();

            // 6. iterate the result set and print the values
            while (rs.next()) {
                iduser= rs.getInt("user_id");

                // 7. close the objects
            }
            rs.close();
            statement.close();
            conn.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("iese cu idu:"+iduser);
        return iduser;
    }

    public void insertUser(String username, String password) {


        try {



            Class.forName("org.postgresql.Driver");


            // 2. define connection params to db
            final String URL = "jdbc:postgresql://54.93.65.5:5432/5NumePrenume";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";

            // 3. obtain a connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 4. create a query statement
//            Statement st = conn.createStatement();

            String query = "insert into userlist (username, password ) values(?,?) ";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            // 5. execute a query
             statement.executeUpdate();



            statement.close();
            conn.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("iese din register:");

    }

    public void passwordChange(String username, String password) {

        System.out.println("sunt aici");

        try {



            Class.forName("org.postgresql.Driver");


            // 2. define connection params to db
            final String URL = "jdbc:postgresql://54.93.65.5:5432/5NumePrenume";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";

            // 3. obtain a connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 4. create a query statement
//            Statement st = conn.createStatement();

            String query = "UPDATE userlist SET password=? WHERE username=?";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, password);
            statement.setString(2, username);

            // 5. execute a query
            statement.executeUpdate();



            statement.close();
            conn.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}
