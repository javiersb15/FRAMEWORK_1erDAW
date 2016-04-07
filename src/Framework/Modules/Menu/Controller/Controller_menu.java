/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Menu.Controller;

import Framework.Modules.Menu.View.choose_frame;
import Framework.Modules.Users.Admin.View.pager_adm;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
        btn_adm
    }

    public void begin() {
        begin.setVisible(true);
        begin.setTitle("Choose User");
	begin.setLocationRelativeTo(null);
	//this.setSize(525,425);//ancho x alto
	begin.setResizable(true);
       
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null,"Exit to the aplication");
                dispose();
                System.exit(0);
            }

            private void dispose() {
            }
       }
        );
       
        
        begin.btn_adm.setActionCommand("btn_adm");
        begin.btn_adm.addActionListener(this);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        switch (Action.valueOf(e.getActionCommand())) {
            case btn_adm:

                begin.setVisible(false);
                pager_adm adm = new pager_adm();
                adm.setVisible(true);               

                break;

        }
    }

}
