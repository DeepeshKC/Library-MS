/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cp.lms.controller;

import edu.cp.lms.dbconnection.DBConnection;
import edu.cp.lms.modules.Book;
import edu.cp.lms.modules.BookType;
import edu.cp.lms.modules.Booking;
import edu.cp.lms.modules.User;
import edu.cp.lms.utils.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Deepesh
 */
public class BookController {

    private Connection con = null;
    private PreparedStatement pstmt;
    private Statement st;
    private ResultSet rs;

    public BookController() {
        if (con == null) {
            con = DBConnection.getConnection();
        }
    }

    public int InsertBook(Book b, BookType bt) throws SQLException {
        int done = 0;
        String sql = "insert into Book values(null,'" + b.getTitle() + "','" + b.getAuthor() + "','" + b.getPublisher() + "','" + b.getCategory() + "', " + b.getIsbn() + ",'" + new java.sql.Date(b.getDateofpublication().getTime()) + "'," + b.getNoofcopies() + "," + bt.getId() + " )";
        st = con.createStatement();
        done = st.executeUpdate(sql);
        return done;
    }

    public int getId(BookType bk) throws SQLException {
        ResultSet rs = null;
        int id = 0;
        st = con.createStatement();
        String sql = "select id from book_type where type='" + bk.getType() + "'";
        rs = st.executeQuery(sql);
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;

    }

    public DefaultTableModel buildTableData() throws SQLException {
        DefaultTableModel data = Util.buildDataTable(getAllBooks());
        return data;
    }

    public ResultSet getAllBooks() throws SQLException {
        ResultSet rs = null;
        String query = "SELECT * FROM Book";
        pstmt = con.prepareStatement(query);
        rs = pstmt.executeQuery();
        return rs;
    }

    public ResultSet searchBook(Book b) throws SQLException {
        ResultSet rs = null;
        String query = "select * from book where title='" + b.getTitle() + "'";
        String query1 = "select * from book where isbn=" + b.getIsbn() + "";
        String query2 = "select * from book where author='" + b.getAuthor() + "'";
        String query3 = "select * from book where category='" + b.getCategory() + "'";
        String query4 = "select * from book where id=" + b.getId() + "";
        st = con.createStatement();
        rs = st.executeQuery(query);
        rs = st.executeQuery(query1);
        rs = st.executeQuery(query2);
        rs = st.executeQuery(query3);
        rs = st.executeQuery(query4);
        return rs;

    }

    public int getNoofcopies(Book b) throws SQLException {
        ResultSet rs = null;
        int noofcopies = 0;
        String query = "Select noofcopies from book where id=" + b.getId() + "";
        st = con.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            noofcopies = rs.getInt("noofcopies");
        }
        return noofcopies;
    }

    public int Addcopies(Book b) throws SQLException {
        int rs = 0;
        String sql = "update book set noofcopies=" + b.getNoofcopies() + " where id=" + b.getId() + "";
        st = con.createStatement();
        rs = st.executeUpdate(sql);
        return rs;
    }

    public int Deletebook(Book b) throws SQLException {
        int rs = 0;
        String sql = "delete from book where title='" + b.getTitle() + "'";
        st = con.createStatement();
        rs = st.executeUpdate(sql);
        return rs;
    }

    public int IssueBook(Booking bk) throws SQLException {
        int rs = 0;
        String sql = "insert into booking values(null," +  new java.sql.Date(bk.getBorroweddate().getTime()) + "," +  new java.sql.Date(bk.getReturndate().getTime()) + "," +new java.sql.Date(bk.getActualreturneddate().getTime()) + "," + bk.getNoofcopies() + ",'"+bk.getStatus()+"', "+bk.getPrice()+","+bk.getBookid().getId()+" ," + bk.getUserid().getId() + ") ";
        st = con.createStatement();
        rs = st.executeUpdate(sql);
        return rs;
    }

    public int ReturnBook(Book b, Booking bk) throws SQLException {
        int done = 0;
        String sql = "update isbn, id where isbn=" + b.getIsbn() + "," + b.getId() + ", ";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        return done;
    }
}
