/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.assignments;
import View.Assignment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import systemproject.ConnectionProvider;

/**
 *
 * @author Mithun Hirushan
 */
public class AssignmentDao {
    
    
     private Connection con;

    public AssignmentDao() {
        this.con = ConnectionProvider.getCon();
    }
    public void addassignment( assignments Assignments) throws Exception{
    Statement st=con.createStatement();
      st.executeUpdate("insert into assignment values('"+Assignments.getAssignmentID()+"','"+Assignments.getCourseID()+"','"+Assignments.getAssignmentTitle()+"','"+Assignments.getOpenDate()+"','"+Assignments.getDueDate()+"')");
    
    }    
    
    public void updateassignment(assignments Assignments) throws Exception {
         Statement st = con.createStatement();
         String sql = "update assignment SET assignmentID='"+Assignments.getAssignmentID()+"',courseID='"+Assignments.getCourseID()+"',assignmentTitle='"+Assignments.getAssignmentTitle()+"',openDate='"+Assignments.getOpenDate()+"',dueDate='"+Assignments.getDueDate()+"' WHERE assignmentID = '"+Assignments.getAssignmentID()+"'";
        PreparedStatement ptst= con.prepareStatement(sql);
        ptst.execute();
    }
    
    public ResultSet getassignment() throws SQLException {
        Statement stmt = con.createStatement();
        String sql="SELECT * FROM ASSIGNMENT";
        ResultSet res = stmt.executeQuery(sql);
        return res;
    }
}
