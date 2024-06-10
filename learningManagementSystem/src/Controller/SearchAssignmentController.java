/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Search;
import View.searchAssignment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import systemproject.ConnectionProvider;

/**
 *
 * @author Mithun Hirushan
 */
public class SearchAssignmentController {
    
     private searchAssignment search;
     private SearchAssignmentDao searchAssignmentDao;

    public SearchAssignmentController() {
        this.search = new searchAssignment();
        this.searchAssignmentDao = new SearchAssignmentDao();
        search.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        search.getjButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        search.getjButton3().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
    
    search.setVisible(true);
    
    
}
    
    
     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
//         String courseID=search.getjTextField1().getText();
         
         Search sear = new Search();
        sear.setCourseID(search.getjTextField1().getText());
        sear.setAssignmentID(search.getjTextField2().getText());
       
        try
        {
//            Connection con=ConnectionProvider.getCon();
//            Statement st=con.createStatement();
//            ResultSet rs=st.executeQuery("select *from assignment where courseID='"+courseID+"'");
            ResultSet rs = searchAssignmentDao.search(sear);
            if(rs.next())
            {
               search.getjTextField2().setText(rs.getString(2));
               search.getjTextField3().setText(rs.getString(3));
               search.getjTextField4().setText(rs.getString(4));
               search.getjTextField5().setText(rs.getString(5));
               search.getjTextField1().setEditable(false);
               
            }
            else{
                JOptionPane.showMessageDialog(null,"Assignment is not submitted");
                search.setVisible(false);
                new searchAssignment().setVisible(true);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Connection Error");
        }
    }       
     public void deletesearchassignment(int courseID){
        try{
            Connection con=ConnectionProvider.getCon();
//            String sql="DELETE FROM ASSIGNMENT WHERE courseID=?";
//            PreparedStatement ps=con.prepareStatement(sql);
//            ps.setInt(1, courseID);
//            
//            ps.execute();
            searchAssignmentDao.deletestudent(courseID);
            JOptionPane.showMessageDialog(null,"Successfully Removed");
            
            
        }
        catch(Exception ex){
            Logger.getLogger(searchAssignment.class.getName()).log (Level.SEVERE,null,ex);
        }
    }
     
      private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        int ID=Integer.parseInt(search.getjTextField1().getText());
        deletesearchassignment(ID);
        
    }  
      
        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        search.setVisible(false);
    } 
}
