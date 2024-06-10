/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import systemproject.ConnectionProvider;

/**
 *
 * @author Mithun Hirushan
 */
public class CourseDao {
    
    private Connection con;

    public CourseDao() {
        this.con = ConnectionProvider.getCon();
    }
    
    
     public void addcourse(Course course) throws Exception{
        
            Statement st=con.createStatement();
            st.executeUpdate("insert into courses values('"+course.getCourseID()+"','"+course.getCourseName()+"','"+course.getLecturerID()+"','"+course.getCredit()+"')");
     }
     
      public void updatecourse(Course course) throws Exception {
         Statement st = con.createStatement();
         String sql = "update courses SET courseID='"+course.getCourseID()+"',courseName='"+course.getCourseName()+"',lecturerID='"+course.getLecturerID()+"',credit='"+course.getCredit()+"' WHERE courseID = '"+course.getCourseID()+"'";
        PreparedStatement ptst= con.prepareStatement(sql);
        ptst.execute();
      }
      
       public void deletecourse(int courseID) throws SQLException {
          Statement st = con.createStatement();
          String sql="DELETE FROM COURSES WHERE courseID=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, courseID);
            
            ps.execute();
      }

}

