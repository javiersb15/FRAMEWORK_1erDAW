/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Menu.Controller;

import Framework.Modules.Menu.View.choose_frame;
import Framework.Modules.Users.Admin.Controller.Controller_admin;
import Framework.Modules.Users.Admin.View.pager_adm;
import Framework.Modules.Users.Client.Controller.Controller_client;
import Framework.Modules.Users.Client.View.pager_client;
import Framework.Modules.Users.User_register.Controller.Controller_user_register;
import Framework.Modules.Users.User_register.View.pager_user_register;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author usuario
 */
public class Controller_menu implements ActionListener {

    public static choose_frame begin;

    public Controller_menu(JFrame began) {      
        begin = (choose_frame) began;       
    }   

    public enum Action {
        btn_adm,
        btn_client,
        btn_user_reg
    }

    public void began() {
        
        begin.setVisible(true);
        begin.setTitle("Choose User");
	begin.setLocationRelativeTo(null);
	//this.setSize(525,425);//ancho x alto
	begin.setResizable(true);
       
        this.begin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.begin.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null,"Exit to the aplication");
                begin.dispose();
                System.exit(0);
            }

       }
        );
       
        begin.btn_adm.setActionCommand("btn_adm");
        begin.btn_adm.addActionListener(this);
        
        begin.btn_client.setActionCommand("btn_client");
        begin.btn_client.addActionListener(this);
        
        begin.btn_user_reg.setActionCommand("btn_user_reg");
        begin.btn_user_reg.addActionListener(this);
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        switch (Action.valueOf(e.getActionCommand())) {
            case btn_adm:
                begin.dispose();
                new Controller_admin(new pager_adm(), 0).begin(0);
                break;
            case btn_client:
                begin.dispose();
                new Controller_client(new pager_client(), 0).begin(0);
                break;
            case btn_user_reg:
                begin.dispose();
                new Controller_user_register(new pager_user_register(), 0).begin(0);
                break;
        }
    }
}