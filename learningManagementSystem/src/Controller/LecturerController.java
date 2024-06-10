/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Lecturer;
import View.lecturer;
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
public class LecturerController {
    private lecturer lec;
     private LecturerDao lecturerDao;

    public LecturerController() {
        this.lec = new lecturer();
        this.lecturerDao = new LecturerDao();
        lec.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        
        lec.getjButton3().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
    
        lec.getjButton4().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
    
          lec.getjButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });      
                
          lec.setVisible(true);
  }
                
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
//        String lecturerID=lec.getjTextField1().getText();
//        String name=lec.getjTextField2().getText();
//        String email=lec.getjTextField3().getText();
//        String course=(String)lec.getjComboBox1().getSelectedItem();
        
        
         Lecturer lect = new Lecturer();
         lect.setLecturerID(lec.getjTextField1().getText());
         lect.setName(lec.getjTextField2().getText());
         lect.setEmail(lec.getjTextField3().getText());
         lect.setCourse((String)lec.getjComboBox1().getSelectedItem());
        try
        {
//            Connection con=ConnectionProvider.getCon();
//            Statement st=con.createStatement();
//            st.executeUpdate("insert into lecturer values('"+lecturerID+"','"+name+"','"+email+"','"+course+"')");
            lecturerDao.addlecturer(lect);
            JOptionPane.showMessageDialog(null,"Successfully Added");
//            setVisible(false);
//            new lecturer().setVisible(true);
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null,"Lecturer ID allready exist");
         lec.setVisible(false);
         new lecturer().setVisible(true);
        }
    }                   
                
                
      private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
//        String lecturerID = lec.getjTextField1().getText();
//        String name = lec.getjTextField2().getText();
//        String email = lec.getjTextField3().getText();
//        String course=(String)lec.getjComboBox1().getSelectedItem();
        
         Lecturer lect = new Lecturer();
         lect.setLecturerID(lec.getjTextField1().getText());
         lect.setName(lec.getjTextField2().getText());
         lect.setEmail(lec.getjTextField3().getText());
         lect.setCourse((String)lec.getjComboBox1().getSelectedItem());
        try{
            
//         Connection conn=ConnectionProvider.getCon();
//       
//        String sql = "update lecturer SET lecturerID='"+lecturerID+"',name='"+name+"',email='"+email+"',course='"+course+"' WHERE lecturerID = '"+lecturerID+"'";
//        PreparedStatement ptst= conn.prepareStatement(sql);
//        ptst.execute();
//        
        JOptionPane.showMessageDialog(null, "Updated Successfully!");
        lecturerDao.updatelecturer(lect);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        
        }
    }                
                
      public void deletelecturer(int lecturerID){
        try{
//            Connection con=ConnectionProvider.getCon();
//            String sql="DELETE FROM lecturer WHERE lecturerID=?";
//            PreparedStatement ps=con.prepareStatement(sql);
//            ps.setInt(1, lecturerID);
//            
//            ps.execute();
            JOptionPane.showMessageDialog(null,"Successfully Removed");
            
            lecturerDao.deletelecturer(lecturerID);
        }
        catch(Exception ex){
            Logger.getLogger(lecturer.class.getName()).log (Level.SEVERE,null,ex);
        }
    }
      
      
      
      private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        int ID=Integer.parseInt(lec.getjTextField1().getText());
        deletelecturer(ID);
    }            
                
     
       private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        lec.setVisible(false);
    }  
  }
