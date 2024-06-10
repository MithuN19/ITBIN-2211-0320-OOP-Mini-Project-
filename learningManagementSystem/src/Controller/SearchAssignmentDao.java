/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Search;
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
public class SearchAssignmentDao {
 
    private Connection con;

    public SearchAssignmentDao() {
        this.con = ConnectionProvider.getCon();
    }

     public ResultSet search(Search sear) throws Exception {
        Statement st = con.createStatement();
        ResultSet rs=st.executeQuery("select *from assignment where courseID='"+sear.getCourseID()+"' and assignmentID='" + sear.getAssignmentID() + "'");
        return rs;
    
     }
     
     public void deletestudent(int courseID) throws SQLException {
          Statement st = con.createStatement();
          String sql="DELETE FROM ASSIGNMENT WHERE courseID=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, courseID);
            
            ps.execute();
     }
}
