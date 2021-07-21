/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhultc.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.nhultc.dtos.BookDTO;
import com.nhultc.ui.TableModelBook;
import com.nhultc.utils.DBHelper;

/**
 *
 * @author Dell
 */
public class BookDAO {
    private String[] headers = {"Book ID", "Book Name", "Author", "Published Year", "For Rent"};
    private int[] indexes = {0, 1, 2, 3, 4 ,5};
    private TableModelBook model = new TableModelBook(headers, indexes);
    
    public TableModelBook getModelBook(){
        return model;
    }
    
    public BookDAO(){
        try {
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadData() throws Exception{
        model.getList().clear();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBHelper.openConnection();
            if(con != null){
                String sql = "SELECT bookID, bookName, author, publisher, publishedYear, forRent FROM dbo.Books";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    BookDTO book = new BookDTO(rs.getString("bookID"),
                                        rs.getString("bookName"),
                                        rs.getString("author"),
                                        rs.getString("publisher"),
                                        rs.getInt("publishedYear"),
                                        rs.getBoolean("forRent"));
                    model.getList().add(book);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        }
    }
    
    public BookDTO getBookById(String bookID) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT bookID, bookName, author, publisher, publishedYear, forRent FROM dbo.Books WHERE bookID=?";
        try {
            con = DBHelper.openConnection();
            if(con != null){
                ps = con.prepareStatement(sql);
                ps.setString(1, bookID);
                if(rs.next()){
                    String id = rs.getString("booID");
                    String name = rs.getString("bookName");
                    String author = rs.getString("author");
                    String publisher = rs.getString("publishedYear");
                    int publishedYear = rs.getInt("publishedYear");
                    boolean forRent = rs.getBoolean("forRent");
                    BookDTO book = new BookDTO(id, name, author, publisher, publishedYear, forRent);
                    return book;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        }
        return null;
    }
    
    public int Insert(BookDTO book) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBHelper.openConnection();
            if(con !=  null){
                String sql = "Insert dbo.Books Values(?,?,?,?,?,?)";
                
                ps = con.prepareStatement(sql);
                ps.setString(1, book.getId());
                ps.setString(2, book.getName());
                ps.setString(3, book.getAuthor());
                ps.setString(4, book.getPublisher());
                ps.setInt(5, book.getPublishedYear());
                ps.setBoolean(6, book.isForRent());
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(con != null){
                con.close();
            }
            if(ps != null){
                ps.close();
            }
        }
        return -1;
    }
    
    public int Save(BookDTO b) throws Exception{
        Connection con= null;
        PreparedStatement ps= null;
        try {
            con= DBHelper.openConnection();
            if(con!=null){
                String sql= "Update dbo.Books Set bookName=?, author=?, publisher=?, publishedYear=?, forRent=? Where bookID=?";
                ps= con.prepareStatement(sql);
                ps.setString(1, b.getName());
                ps.setString(2, b.getAuthor());
                ps.setString(3, b.getPublisher());
                ps.setInt(4, b.getPublishedYear());
                ps.setBoolean(5, b.isForRent());
                ps.setString(6, b.getId());
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(ps!=null){
                ps.close();
            }
            if(con!=null){
                con.close();
            }
            
        }
        return -1;
    }

    
    public int Delete(BookDTO b) throws Exception{
        Connection con= null;
        PreparedStatement ps= null;
        try {
            con= DBHelper.openConnection();
            if(con!=null){
                String sql="DELETE FROM dbo.Books WHERE bookID=?";
                ps= con.prepareStatement(sql);
                ps.setString(1, b.getId());
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(ps!=null){
                ps.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return -1;
    }
    
    public void loadBookAscending() throws SQLException{
        Connection con=null;
        PreparedStatement ps= null;
        ResultSet rs= null;
        model.getList().clear();
        try {
            con= DBHelper.openConnection();
            if(con!=null){
                String sql= "SELECT bookID, bookName, author, publisher, publishedYear, forRent FROM dbo.Books ORDER BY bookName ASC;";
                ps=con.prepareStatement(sql);
                rs= ps.executeQuery();
                while(rs.next()){
                    BookDTO b= new BookDTO(rs.getString("bookID"), rs.getString("bookName"), rs.getString("author"),
                            rs.getString("publisher"), rs.getInt("publishedYear"), rs.getBoolean("forRent"));
                    model.getList().add(b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(con!=null){
                con.close();
            }
        }
    }

    public void loadBookDescending() throws SQLException {
        Connection con = null;   
        PreparedStatement ps = null;   
        ResultSet rs = null;   
        model.getList().clear();
        try {
            con = DBHelper.openConnection();  
            if (con != null) {   
                String sql = "SELECT bookID, bookName, author, publisher, publishedYear, forRent FROM dbo.Books ORDER BY bookName DESC;";   // Lấy tất cả giá trị tăng dần từ bảng LISTBOOK trong database

                ps = con.prepareStatement(sql); 
                rs = ps.executeQuery();   
                while (rs.next()) {
                    BookDTO b = new BookDTO(rs.getString("bookID"), rs.getString("bookName"), rs.getString("author"),
                            rs.getString("publisher"), rs.getInt("publishedYear"), rs.getBoolean("forRent"));
                    model.getList().add(b);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();   
            }
            if (ps != null) {
                ps.close();  
            }
            if (con != null) {
                con.close();  
            }
        }

    }

    public void loadTableBookSearchByName(String bookName) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        model.getList().clear();
        try {
            con = DBHelper.openConnection();
            if (con != null) {
                String sql = "SELECT bookID, bookName, author, publisher, publishedYear, forRent FROM dbo.Books WHERE CHARINDEX(N'" + bookName + "', bookName)>0;";

                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    BookDTO b = new BookDTO(rs.getString("bookID"), rs.getString("bookName"), rs.getString("author"),
                            rs.getString("publisher"), rs.getInt("publishedYear"), rs.getBoolean("forRent"));
                    model.getList().add(b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean validDatabookID(String bookID) {//xet trung category
        try {
            for (int i = 0; i < model.getList().size(); i++) {
                if (model.getList().get(i).getId().compareToIgnoreCase(bookID) == 0) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean validData(String bookID, String bookName, String author, String publisher) {
        if (!bookID.toUpperCase().matches("[a-zA-Z]{3}[0-9]{3}")) {
            JOptionPane.showMessageDialog(null, "Invalid Book ID");
            return false;
        }
        if (bookName.isEmpty() || bookName.length() > 50) {
            JOptionPane.showMessageDialog(null, "Invalid Book Name");
            return false;
        }
        if (author.isEmpty() || author.length() > 50) {
            JOptionPane.showMessageDialog(null, "Invalid Author");
            return false;
        }
        if (publisher.isEmpty() || publisher.length() > 50) {
            JOptionPane.showMessageDialog(null, "Invalid Publisher");
            return false;
        }
        return true;
    }
}
