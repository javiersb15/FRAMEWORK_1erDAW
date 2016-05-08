/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Menu.Controller;

import Framework.Modules.Menu.Model.Bll.Bll_config;
import Framework.Modules.Menu.Model.Clases.Class_language;
import Framework.Modules.Menu.View.choose_frame;
import Framework.Modules.Menu.View.config_frame;
import Framework.Modules.Users.Admin.Controller.Controller_admin;
import Framework.Modules.Users.Admin.View.pager_adm;
import Framework.Modules.Users.Client.Controller.Controller_client;
import Framework.Modules.Users.Client.View.pager_client;
import Framework.Modules.Users.User_register.Controller.Controller_user_register;
import Framework.Modules.Users.User_register.Model.Utils.Extensions.Json;
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
 * @author Javier
 */
public class Controller_menu implements ActionListener {

    public static choose_frame begin_choose;
    public static config_frame begin_config;    

    public Controller_menu(JFrame began, int j) {
        switch (j){
            case 0:
                begin_choose=(choose_frame) began; 
                break;
            case 1:
                begin_config=(config_frame) began;
                break;
        }
    }   

    public enum Action {
        /**CHOOSE FRAME*/
        btn_adm,
        btn_client,
        btn_user_reg,
        btn_config,
        
        /**CHOOSE CONFIG*/
        btn_accept_date,
        btn_cancel_date,
        btn_accept_theme,
        btn_cancel_theme,
        btn_accept_currency,
        btn_cancel_currency,
        btn_accept_language,
        btn_cancel_language,
        btn_accept_decimal,
        btn_cancel_decimal
    }

    public void began(int j) {
        switch (j){
            case 0: 
                begin_choose.setVisible(true);
                begin_choose.setTitle("Choose User");
                begin_choose.setLocationRelativeTo(null);
                //this.setSize(525,425);//ancho x alto
                begin_choose.setResizable(true);

                this.begin_choose.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                this.begin_choose.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        Json.auto_create_json_usr_reg();
                        JOptionPane.showMessageDialog(null,Class_language.getInstance().getProperty("Exit"));
                        begin_choose.dispose();
                        System.exit(0);
                    }
               }
                );       
                begin_choose.btn_adm.setActionCommand("btn_adm");
                begin_choose.btn_adm.addActionListener(this);

                begin_choose.btn_client.setActionCommand("btn_client");
                begin_choose.btn_client.addActionListener(this);

                begin_choose.btn_user_reg.setActionCommand("btn_user_reg");
                begin_choose.btn_user_reg.addActionListener(this);
                
                begin_choose.btn_config.setActionCommand("btn_config");
                begin_choose.btn_config.addActionListener(this);
                break;
            
            case 1:
                begin_config.setVisible(true);
                begin_config.setTitle("Choose Config");
                begin_config.setLocationRelativeTo(null);
                //this.setSize(525,425);//ancho x alto
                begin_config.setResizable(true);
                
                Bll_config.getConfig();

                this.begin_config.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                this.begin_config.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        Json.auto_create_json_usr_reg();
                        JOptionPane.showMessageDialog(null,Class_language.getInstance().getProperty("Exit"));
                        begin_config.dispose();
                        System.exit(0);
                    }
               }
                );
                this.begin_config.btn_accept_date.setActionCommand("btn_accept_date");
                this.begin_config.btn_accept_date.addActionListener(this);
                
                this.begin_config.btn_cancel_date.setActionCommand("btn_cancel_date");
                this.begin_config.btn_cancel_date.addActionListener(this);
                
                this.begin_config.btn_accept_theme.setActionCommand("btn_accept_theme");
                this.begin_config.btn_accept_theme.addActionListener(this);
                
                this.begin_config.btn_cancel_theme.setActionCommand("btn_cancel_theme");
                this.begin_config.btn_cancel_theme.addActionListener(this);
                
                this.begin_config.btn_accept_currency.setActionCommand("btn_accept_currency");
                this.begin_config.btn_accept_currency.addActionListener(this);
                
                this.begin_config.btn_cancel_currency.setActionCommand("btn_cancel_currency");
                this.begin_config.btn_cancel_currency.addActionListener(this);
                
                this.begin_config.btn_accept_language.setActionCommand("btn_accept_language");
                this.begin_config.btn_accept_language.addActionListener(this);
                
                this.begin_config.btn_cancel_language.setActionCommand("btn_cancel_language");
                this.begin_config.btn_cancel_language.addActionListener(this);
                
                this.begin_config.btn_accept_decimal.setActionCommand("btn_accept_decimal");
                this.begin_config.btn_accept_decimal.addActionListener(this);
                
                this.begin_config.btn_cancel_decimal.setActionCommand("btn_cancel_decimal");
                this.begin_config.btn_cancel_decimal.addActionListener(this);                
                break;
        }       
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        switch (Action.valueOf(e.getActionCommand())) {
            case btn_adm:
                begin_choose.dispose();
                new Controller_admin(new pager_adm(), 0).begin(0);
                break;
            case btn_client:
                begin_choose.dispose();
                new Controller_client(new pager_client(), 0).begin(0);
                break;
            case btn_user_reg:
                begin_choose.dispose();
                new Controller_user_register(new pager_user_register(), 0).begin(0);
                break;
            case btn_config:
                begin_choose.dispose();
                new Controller_menu(new config_frame(), 1).began(1);
                break;
            case btn_accept_date:
                Bll_config.setConfig();
                begin_config.dispose();
                new Controller_menu(new choose_frame(), 0).began(0);
                break;
            case btn_cancel_date:                
                begin_config.dispose();
                new Controller_menu(new choose_frame(), 0).began(0);
                break;
            case btn_accept_theme:
                Bll_config.setConfig();
                begin_config.dispose();
                new Controller_menu(new choose_frame(), 0).began(0);
                break;
            case btn_cancel_theme:
                begin_config.dispose();
                new Controller_menu(new choose_frame(), 0).began(0);
                break;
            case btn_accept_currency:
                Bll_config.setConfig();
                begin_config.dispose();
                new Controller_menu(new choose_frame(), 0).began(0);
                break;
            case btn_cancel_currency:
                begin_config.dispose();
                new Controller_menu(new choose_frame(), 0).began(0);
                break;
            case btn_accept_language:
                Bll_config.setConfig();
                begin_config.dispose();
                new Controller_menu(new choose_frame(), 0).began(0);
                break;
            case btn_cancel_language:
                begin_config.dispose();
                new Controller_menu(new choose_frame(), 0).began(0);
                break;
            case btn_accept_decimal:
                Bll_config.setConfig();
                begin_config.dispose();
                new Controller_menu(new choose_frame(), 0).began(0);
                break;
            case btn_cancel_decimal:
                Bll_config.setConfig();
                begin_config.dispose();
                new Controller_menu(new choose_frame(), 0).began(0);
                break;
        }
    }
}