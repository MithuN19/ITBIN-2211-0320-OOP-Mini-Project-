/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Student;
import View.addStudent;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import systemproject.ConnectionProvider;

/**
 *
 * @author Mithun Hirushan
 */
public class AddStudentController {
    
    private addStudent student;
    private StudentDao studentDao;

    public AddStudentController() {
        this.student = new addStudent();
        this.studentDao = new StudentDao();
        student.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
         student.getjButton4().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        student.getjButton3().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        
        student.getjButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
         
         
    showRecord();
    student.setVisible(true);
}
    
    
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
//        String studentID=student.getjTextField1().getText();
//        String name=student.getjTextField2().getText();
//        String email=student.getjTextField3().getText();
//        String gender=(String)student.getjComboBox1().getSelectedItem();
//        String course=(String)student.getjComboBox2().getSelectedItem();
        
        Student std = new Student();
        std.setStudentID(student.getjTextField1().getText());
        std.setName(student.getjTextField2().getText());
        std.setEmail(student.getjTextField3().getText());
        std.setGender((String)student.getjComboBox1().getSelectedItem());
        std.setCourse((String)student.getjComboBox2().getSelectedItem());
        
        try
        {
            
             studentDao.addstudent(std);
//            student.setVisible(false);
//            new addStudent().setVisible(true);
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null,"Student ID allready exist");
         student.setVisible(false);
         new addStudent().setVisible(true);
        }
        showRecord();
    }
  
   private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
//        String studentID = student.getjTextField1().getText();
//        String name = student.getjTextField2().getText();
//        String email = student.getjTextField3().getText();
//       String gender=(String)student.getjComboBox1().getSelectedItem();
//        String course=(String)student.getjComboBox2().getSelectedItem();
        
        Student std = new Student();
        std.setStudentID(student.getjTextField1().getText());
        std.setName(student.getjTextField2().getText());
        std.setEmail(student.getjTextField3().getText());
        std.setGender((String)student.getjComboBox1().getSelectedItem());
        std.setCourse((String)student.getjComboBox2().getSelectedItem());
        
        try{
         Connection conn=ConnectionProvider.getCon();
       
//        String sql = "update addstudent SET studentID='"+studentID+"',name='"+name+"',email='"+email+"',gender='"+gender+"',course='"+course+"' WHERE studentID = '"+studentID+"'";
//        PreparedStatement ptst= conn.prepareStatement(sql);
//        ptst.execute();
        studentDao.updatestudent(std);
        JOptionPane.showMessageDialog(null, "Updated Successfully!");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        
        }
        showRecord();
    }               
    
     public void showRecord(){
        try{
//            Connection con = ConnectionProvider.getCon();
//            Statement stmt = con.createStatement();
//            String sql="SELECT * FROM ADDSTUDENT";
//            ResultSet res = stmt.executeQuery(sql);
             ResultSet res = studentDao.getStudents();
            student.getjTable1().setModel(DbUtils.resultSetToTableModel(res));
             
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void deletestudent(int studentID){
        try{
            //Connection con=ConnectionProvider.getCon();
//            String sql="DELETE FROM ADDSTUDENT WHERE studentID=?";
//            PreparedStatement ps=con.prepareStatement(sql);
//            ps.setInt(1, studentID);
//            
//            ps.execute();
            JOptionPane.showMessageDialog(null,"Successfully Removed");
            
            studentDao.deletestudent(studentID);
        }
        catch(Exception ex){
            Logger.getLogger(addStudent.class.getName()).log (Level.SEVERE,null,ex);
        }
        showRecord();
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here
        int ID=Integer.parseInt(student.getjTextField1().getText());
        deletestudent(ID);
        showRecord();
    }  
    
     private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        student.setVisible(false);
    } 
}

