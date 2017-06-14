/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cp.lms.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Deepesh
 */
public class DBConnection {

    static Connection con = null;

    public static Connection getConnection() {
        if (con == null) {
            connectToDb();
        }
        return con;

    }

    private static void connectToDb() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("not connected");
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryms", "root", "");
            System.out.println("driver loaded");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("not loaded");
        }

    }

}
