/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Home;
import View.login;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Mithun Hirushan
 */
public class LoginController {

    public LoginController() {
        login log = new login();
        log.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt, log.getjTextField1(), log.getjPasswordField1(), log);
            }
        });

        log.getjButton2().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        log.setVisible(true);

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt, JTextField username, JPasswordField password, login log) {
        // TODO add your handling code here:
        //username=mithun
        //password=1234
        if (username.getText().equals("mithun") && password.getText().equals("1234")) {
            log.setVisible(false);
            new HomeController();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }
}
