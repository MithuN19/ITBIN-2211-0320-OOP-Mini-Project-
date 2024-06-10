/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Lecturer;
import View.lecturer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import systemproject.ConnectionProvider;

/**
 *
 * @author Mithun Hirushan
 */
public class LecturerDao {
    
    private Connection con;

    public LecturerDao() {
        this.con = ConnectionProvider.getCon();
    }
    
    public void addlecturer(Lecturer lecturer) throws Exception{
        
            Statement st=con.createStatement();
            st.executeUpdate("insert into lecturer values('"+lecturer.getLecturerID()+"','"+lecturer.getName()+"','"+lecturer.getEmail()+"','"+lecturer.getCourse()+"')");
            
    }
    
    
     public void updatelecturer(Lecturer lecturer) throws Exception {
         Statement st = con.createStatement();
         String sql = "update lecturer SET lecturerID='"+lecturer.getLecturerID()+"',name='"+lecturer.getName()+"',email='"+lecturer.getEmail()+"',course='"+lecturer.getCourse()+"' WHERE lecturerID = '"+lecturer.getLecturerID()+"'";
        PreparedStatement ptst= con.prepareStatement(sql);
        ptst.execute();
     }
     
       public void deletelecturer(int lecturerID) throws SQLException {
           String sql="DELETE FROM lecturer WHERE lecturerID=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, lecturerID);
             ps.execute();
}
}
