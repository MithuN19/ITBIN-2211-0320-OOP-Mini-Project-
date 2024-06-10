/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Course;
import View.courses;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import systemproject.ConnectionProvider;

/**
 *
 * @author Mithun Hirushan
 */
public class CoursesController {
    private courses cous;
    private CourseDao courseDao;

    public CoursesController() {
        this.cous = new courses();
        this.courseDao = new CourseDao();
        cous.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        cous.getjButton4().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        
       cous.getjButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        }); 
        
       cous.getjButton3().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        
    
    cous.setVisible(true);
    
    
    
}
    
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
//        String courseID=cous.getjTextField1().getText();
//        String courseName=(String)cous.getjComboBox1().getSelectedItem();
//        String lecturerID=cous.getjTextField3().getText();
//        String credit=cous.getjTextField4().getText();
        
        Course cos = new Course();
        cos.setCourseID(cous.getjTextField1().getText());
        cos.setCourseName((String)cous.getjComboBox1().getSelectedItem());
        cos.setLecturerID(cous.getjTextField3().getText());
        cos.setCredit(cous.getjTextField4().getText());
        try
        {
//            Connection con=ConnectionProvider.getCon();
//            Statement st=con.createStatement();
//            st.executeUpdate("insert into courses values('"+courseID+"','"+courseName+"','"+lecturerID+"','"+credit+"')");
            JOptionPane.showMessageDialog(null,"Successfully Added");
             courseDao.addcourse(cos);
//            setVisible(false);
//            new courses().setVisible(true);
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null,"Course ID allready exist");
         cous.setVisible(false);
         new courses().setVisible(true);
        }
        
    }                                          
    
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
//        String courseID=cous.getjTextField1().getText();
//        String courseName=(String)cous.getjComboBox1().getSelectedItem();
//        String lecturerID=cous.getjTextField3().getText();
//        String credit=cous.getjTextField4().getText();
        
         Course cos = new Course();
        cos.setCourseID(cous.getjTextField1().getText());
        cos.setCourseName((String)cous.getjComboBox1().getSelectedItem());
        cos.setLecturerID(cous.getjTextField3().getText());
        cos.setCredit(cous.getjTextField4().getText());
        try{
//         Connection conn=ConnectionProvider.getCon();
//       
//        String sql = "update courses SET courseID='"+courseID+"',courseName='"+courseName+"',lecturerID='"+lecturerID+"',credit='"+credit+"' WHERE courseID = '"+courseID+"'";
//        PreparedStatement ptst= conn.prepareStatement(sql);
//        ptst.execute();
        courseDao.updatecourse(cos);
        JOptionPane.showMessageDialog(null, "Updated Successfully!");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        
        }
       
    }      
    
     public void deletecourse(int courseID){
        try{
//            Connection con=ConnectionProvider.getCon();
//            String sql="DELETE FROM COURSES WHERE courseID=?";
//            PreparedStatement ps=con.prepareStatement(sql);
//            ps.setInt(1, courseID);
//            
//            ps.execute();
            JOptionPane.showMessageDialog(null,"Successfully Removed");
            courseDao.deletecourse(courseID);
            
        }
        catch(Exception ex){
            Logger.getLogger(courses.class.getName()).log (Level.SEVERE,null,ex);
        }
    }
     
      private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        int ID=Integer.parseInt(cous.getjTextField1().getText());
        deletecourse(ID);
    }  
    
     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        cous.setVisible(false);
    } 
    
    
}
