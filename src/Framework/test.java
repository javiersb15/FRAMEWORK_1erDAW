/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import Framework.Modules.Menu.View.choose_frame;
import Framework.Modules.Config.Model.Class_config;
import Framework.Modules.Menu.Controller.Controller_menu;



/**
 *
 * @author usuario
 */
public class test {
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        Class_config.getInstance();

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controller_menu(new choose_frame()).began();      
            }
        });
    }
}
