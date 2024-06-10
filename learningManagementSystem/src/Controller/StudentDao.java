/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import systemproject.ConnectionProvider;

/**
 *
 * @author Mithun Hirushan
 */
public class StudentDao {
    
    private Connection con;

    public StudentDao() {
        this.con = ConnectionProvider.getCon();
    }

    public void addstudent(Student student) throws Exception{
        
            Statement st=con.createStatement();
            st.executeUpdate("insert into addStudent values('"+student.getStudentID()+"','"+student.getName()+"','"+student.getEmail()+"','"+student.getGender()+"','"+student.getCourse()+"')");
            JOptionPane.showMessageDialog(null,"Successfully Added");
    }
    
     public void updatestudent(Student student) throws Exception {
         Statement st = con.createStatement();
        String sql = "update addstudent SET studentID='"+student.getStudentID()+"',name='"+student.getName()+"',email='"+student.getEmail()+"',gender='"+student.getGender()+"',course='"+student.getCourse()+"' WHERE studentID = '"+student.getStudentID()+"'";
        PreparedStatement ptst= con.prepareStatement(sql);
        ptst.execute();
     }    
     
     public void deletestudent(int studentID) throws SQLException {
          Statement st = con.createStatement();
          String sql="DELETE FROM ADDSTUDENT WHERE studentID=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, studentID);
            
            ps.execute();
      }
    
    public ResultSet getStudents() throws SQLException {
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM ADDSTUDENT";
        ResultSet res = stmt.executeQuery(sql);
        return res;
    }
    
    
    
    
}
