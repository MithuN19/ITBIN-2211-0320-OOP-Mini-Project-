/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemproject;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mithun
 */
public class ConnectionProvider {
     public static Connection getCon()
    {
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/LearningManagementSystem","root","N199910@p");
            return con;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
}
