/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Login.Controller;

import Framework.Modules.Login.Model.Bll.bll_login;
import Framework.Modules.Login.Model.Clases.Singleton_login;
import Framework.Modules.Login.View.login_frame;
import static Framework.Modules.Login.View.login_frame.btn_accept_login;
import static Framework.Modules.Login.View.login_frame.eti_pass_login;
import Framework.Modules.Menu.Controller.Controller_menu;
import Framework.Modules.Menu.View.choose_frame;
import Framework.Modules.Users.Client.Controller.Controller_client;
import Framework.Modules.Users.Client.View.client_jframe_update;
import Framework.Modules.Users.User_register.Controller.Controller_user_register;
import Framework.Modules.Users.User_register.View.user_register_jframe_update;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Javier
 */
public class Controller_login implements ActionListener , KeyListener{
    
    public static login_frame begin_login;
   
    
    public Controller_login(JFrame began){
        begin_login=(login_frame) began; 
    }    
    
    public enum Action{
        eti_dni_login,
        eti_pass_login,
        btn_accept_login        
    }
    
    public void began() {
    
                begin_login.setVisible(true);
                begin_login.setTitle("Login");
                begin_login.setLocationRelativeTo(null);
                //this.setSize(525,425);//ancho x alto
                begin_login.setResizable(true);

                this.begin_login.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                this.begin_login.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        JOptionPane.showMessageDialog(null,"Exit to the aplication");
                        begin_login.dispose();
                        System.exit(0);
                    }
               }
                );
                
        begin_login.eti_dni_login.setActionCommand("eti_dni_login");
        begin_login.eti_dni_login.setName("eti_dni_login");
        begin_login.eti_dni_login.addKeyListener(this);
        
        begin_login.eti_pass_login.setActionCommand("eti_pass_login");
        begin_login.eti_pass_login.setName("eti_pass_login");
        begin_login.eti_pass_login.addKeyListener(this);
        
        begin_login.btn_accept_login.setActionCommand("btn_accept_login");
        begin_login.btn_accept_login.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {     
        
        switch (Action.valueOf(e.getActionCommand())) {
         case btn_accept_login:
          int find=bll_login.type_user();
          switch(find){
              case 0:
                  begin_login.dispose();
                  new Controller_menu(new choose_frame(), 0).began(0);
                  break;
              case 1:
                  Singleton_login.dni=login_frame.eti_dni_login.getText();
                  begin_login.dispose();
                  new Controller_client(new client_jframe_update(), 2).begin(2);
                  client_jframe_update.btn_update_update.setVisible(true);
                  client_jframe_update.btn_cancel_update.setVisible(false);
                  break;
              case 2:
                  Singleton_login.dni=login_frame.eti_dni_login.getText();
                  begin_login.dispose();
                  new Controller_user_register(new user_register_jframe_update(), 2).begin(2);
                  user_register_jframe_update.btn_update_update.setVisible(true);
                  user_register_jframe_update.btn_cancel_update.setVisible(false);
                  break;
              case 3:
                  JOptionPane.showMessageDialog(null, "error");
                  break;
          }     
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (Action.valueOf(e.getComponent().getName())) {
            
            case eti_dni_login:                
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                eti_pass_login.requestFocus();
            break;
        
            case eti_pass_login:                
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btn_accept_login .requestFocus();
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}