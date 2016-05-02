/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import Framework.Modules.Login.Controller.Controller_login;
import Framework.Modules.Login.View.login_frame;
import Framework.Modules.Menu.Model.Clases.Class_config;


/**
 *
 * @author usuario
 */

public class Main {
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        Class_config.getInstance();

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controller_login(new login_frame()).began();      
            }
        });
    }
}