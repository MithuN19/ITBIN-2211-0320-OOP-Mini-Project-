/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.assignments;
import View.Assignment;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import systemproject.ConnectionProvider;

/**
 *
 * @author Mithun Hirushan
 */
public class AssignmentController {
     private Assignment assignment;
     private AssignmentDao assignmentDao;

    public AssignmentController() {
        this.assignment = new Assignment();
        this.assignmentDao = new AssignmentDao();
        
        assignment.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        assignment.getjButton4().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        
        assignment.getjButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
    showRecord();
    assignment.setVisible(true);
 }
                
                
                
                
                
        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-YYYY");
//        String assignmentID=assignment.getjTextField2().getText();
//        String courseID=assignment.getjTextField1().getText();
//        String assignmentTitle=assignment.getjTextField3().getText();
//        String openDate=dFormat.format(assignment.getjDateChooser2().getDate());
//        String dueDate=dFormat.format(assignment.getjDateChooser1().getDate());
        
       
        assignments assign = new assignments();
        assign.setdFormat(new SimpleDateFormat("dd-MM-YYYY"));
        assign.setAssignmentID(assignment.getjTextField2().getText());
        assign.setCourseID(assignment.getjTextField1().getText());
        assign.setAssignmentTitle(assignment.getjTextField3().getText());
        assign.setOpenDate(dFormat.format(assignment.getjDateChooser2().getDate()));
        assign.setDueDate(dFormat.format(assignment.getjDateChooser1().getDate()));
        
         try
        {
//            Connection con=ConnectionProvider.getCon();
//            Statement st=con.createStatement();
//            st.executeUpdate("insert into assignment values('"+assignmentID+"','"+courseID+"','"+assignmentTitle+"','"+openDate+"','"+dueDate+"')");
            JOptionPane.showMessageDialog(null,"Successfully Added");
             assignmentDao.addassignment(assign);
//            setVisible(false);
//            new Assignment().setVisible(true);
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null,"Assignment ID allready exist");
         assignment.setVisible(false);
         new Assignment().setVisible(true);
        }
         showRecord();
    }
        
         private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-YYYY");
//        String assignmentID=assignment.getjTextField2().getText();
//        String courseID=assignment.getjTextField1().getText();
//        String assignmentTitle=assignment.getjTextField3().getText();
//        String openDate=dFormat.format(assignment.getjDateChooser2().getDate());
//        String dueDate=dFormat.format(assignment.getjDateChooser1().getDate());
        
        
        assignments assign = new assignments();
        assign.setdFormat(new SimpleDateFormat("dd-MM-YYYY"));
        assign.setAssignmentID(assignment.getjTextField2().getText());
        assign.setCourseID(assignment.getjTextField1().getText());
        assign.setAssignmentTitle(assignment.getjTextField3().getText());
        assign.setOpenDate(dFormat.format(assignment.getjDateChooser2().getDate()));
        assign.setDueDate(dFormat.format(assignment.getjDateChooser1().getDate()));
        
        try{
         Connection conn=ConnectionProvider.getCon();
       
//        String sql = "update assignment SET assignmentID='"+assignmentID+"',courseID='"+courseID+"',assignmentTitle='"+assignmentTitle+"',openDate='"+openDate+"',dueDate='"+dueDate+"' WHERE assignmentID = '"+assignmentID+"'";
//        PreparedStatement ptst= conn.prepareStatement(sql);
//        ptst.execute();
        
        JOptionPane.showMessageDialog(null, "Updated Successfully!");
        assignmentDao.updateassignment(assign);
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
//            String sql="SELECT * FROM ASSIGNMENT";
            ResultSet res = assignmentDao.getassignment();
            assignment.getjTable1().setModel(DbUtils.resultSetToTableModel(res));
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
         
         
         private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        assignment.setVisible(false);
    } 
}
    