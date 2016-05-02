/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Login.Controller;

import Framework.Class.Singleton_tools;
import static Framework.Class.Singleton_tools.usr_reg;
import Framework.Modules.Login.Model.Bll.bll_login;
import Framework.Modules.Login.View.login_frame;
import static Framework.Modules.Login.View.login_frame.btn_accept_login;
import static Framework.Modules.Login.View.login_frame.eti_pass_login;
import Framework.Modules.Menu.Controller.Controller_menu;
import Framework.Modules.Menu.View.choose_frame;
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
 * @author usuario
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
        
        /*switch (Action.valueOf(e.getActionCommand())) {
         case btn_accept_login:
             
        if (bll_login.login_admin()==true){
            begin_login.dispose();
            new Controller_menu(new choose_frame(), 0).began(0);
        }else{
            JOptionPane.showMessageDialog(null, "error");
        } */ 
    
        begin_login.dispose();
        new Controller_menu(new choose_frame(), 0).began(0);        
        //}
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