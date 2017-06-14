/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cp.lms.controller;

import edu.cp.lms.dbconnection.DBConnection;
import edu.cp.lms.modules.Staff;
import edu.cp.lms.modules.StaffType;
import edu.cp.lms.modules.User;
import edu.cp.lms.utils.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Deepesh
 */
public class UserController {

    private Connection con = null;
    private PreparedStatement pstmt;
    private Statement st;
    private ResultSet rs;

    public UserController() {
        if (con == null) {
            con = DBConnection.getConnection();
        }
    }

    public ResultSet authenticate(Staff staffObj) {

        String query = "select * from staff where username = '" + staffObj.getUsername() + "' and password ='" + staffObj.getPassword() + "'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            ResultSetMetaData rdm = rs.getMetaData();
            int column = rdm.getColumnCount();

        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int InsertStaff(Staff tbl, StaffType stt) throws SQLException {
        int done = 0;
        String sql = "insert into staff values(null,'" + tbl.getUsername() + "','" + tbl.getPassword() + "','" + tbl.getAddress() + "'," + tbl.getContactno() + "," + stt.getId() + ")";
        st = con.createStatement();
        done = st.executeUpdate(sql);
        return done;
    }

    public ResultSet getInformation(Staff stf) throws SQLException {
        String sql = "select * from Staff where username='" + stf.getUsername() + "' ";
        st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }

    public int InsertUser(User tbl) throws SQLException {
        int done = 0;
        String sql = "insert into User values(null,'" + tbl.getFirstname() + "','" + tbl.getLastname() + "','" + tbl.getAddress() + "'," + tbl.getContactno() + ")";
        st = con.createStatement();
        done = st.executeUpdate(sql);
        return done;
    }
       public DefaultTableModel buildTableData( ) throws SQLException {
        DefaultTableModel data = Util.buildDataTable(ViewUser());
        return data;
    }
       
    public ResultSet ViewUser() throws SQLException{
        ResultSet rs= null;
        String query="select * from user";
        st=con.createStatement();
        rs=st.executeQuery(query);
        return rs;
    }
   
    
    public int UpdateUser(User tbl) throws SQLException{
        int done=0;
        String sql= "update user set firstname='"+ tbl.getFirstname() +"', lastname='" + tbl.getLastname() + "',address='" + tbl.getAddress() + "',contactno="+ tbl.getContactno() +"";
        st=con.createStatement();
        done=st.executeUpdate(sql);
        return done;
    }
}
