/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Users.Client.Controller;

import Framework.Modules.Login.Model.Clases.Singleton_login;
import Framework.Modules.Menu.Controller.Controller_menu;
import Framework.Modules.Menu.View.choose_frame;
import Framework.Modules.Users.Client.Model.Bll.bll_client;
import Framework.Modules.Users.Client.Model.Clases.miniSimpleTableModel_client;
import Framework.Modules.Users.Client.Model.Dao.dao_client;
import Framework.Modules.Users.Client.Model.Utils.Extensions.Json;
import Framework.Modules.Users.Client.Model.Utils.Extensions.Txt;
import Framework.Modules.Users.Client.Model.Utils.Extensions.Xml;
import Framework.Modules.Users.Client.Model.Utils.Pager.pagina_client;
import Framework.Modules.Users.Client.Model.Utils.autocomplete.AutocompleteJComboBox;
import Framework.Modules.Users.Client.Model.Utils.autocomplete.StringSearchable;
import Framework.Modules.Users.Client.View.client_jframe_create;
import static Framework.Modules.Users.Client.View.client_jframe_create.btn_create_create;
import static Framework.Modules.Users.Client.View.client_jframe_create.eti_avatar_create;
import static Framework.Modules.Users.Client.View.client_jframe_create.eti_buy_create;
import static Framework.Modules.Users.Client.View.client_jframe_create.eti_date_birthday_create;
import static Framework.Modules.Users.Client.View.client_jframe_create.eti_date_start_create;
import static Framework.Modules.Users.Client.View.client_jframe_create.eti_dni_create;
import static Framework.Modules.Users.Client.View.client_jframe_create.eti_email_create;
import static Framework.Modules.Users.Client.View.client_jframe_create.eti_mobile_create;
import static Framework.Modules.Users.Client.View.client_jframe_create.eti_name_create;
import static Framework.Modules.Users.Client.View.client_jframe_create.eti_pass_create;
import static Framework.Modules.Users.Client.View.client_jframe_create.eti_surname_create;
import static Framework.Modules.Users.Client.View.client_jframe_create.eti_tipeclient_create;
import static Framework.Modules.Users.Client.View.client_jframe_create.eti_user_create;
import Framework.Modules.Users.Client.View.client_jframe_update;
import static Framework.Modules.Users.Client.View.client_jframe_update.btn_update_update;
import static Framework.Modules.Users.Client.View.client_jframe_update.eti_avatar_update;
import static Framework.Modules.Users.Client.View.client_jframe_update.eti_buy_update;
import static Framework.Modules.Users.Client.View.client_jframe_update.eti_date_birthday_update;
import static Framework.Modules.Users.Client.View.client_jframe_update.eti_date_start_update;
import static Framework.Modules.Users.Client.View.client_jframe_update.eti_dni_update;
import static Framework.Modules.Users.Client.View.client_jframe_update.eti_email_update;
import static Framework.Modules.Users.Client.View.client_jframe_update.eti_mobile_update;
import static Framework.Modules.Users.Client.View.client_jframe_update.eti_name_update;
import static Framework.Modules.Users.Client.View.client_jframe_update.eti_pass_update;
import static Framework.Modules.Users.Client.View.client_jframe_update.eti_surname_update;
import static Framework.Modules.Users.Client.View.client_jframe_update.eti_tipeclient_update;
import static Framework.Modules.Users.Client.View.client_jframe_update.eti_user_update;
import Framework.Modules.Users.Client.View.pager_client;
import static Framework.Modules.Users.Client.View.pager_client.jComboBox1;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Javier
 */
public class Controller_client implements ActionListener, MouseListener, KeyListener, FocusListener{
    
    public static pager_client begin_pager;
    public static client_jframe_create begin_create;
    public static client_jframe_update begin_update;
    public static String DNI;
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_client());
    public static AutocompleteJComboBox combo = null;
    
    public Controller_client(JFrame began, int j) {
        switch (j){
            case 0:
                begin_pager=(pager_client) began;
                break;
            case 1:
                begin_create=(client_jframe_create) began;    
                break;
            case 2:
                begin_update=(client_jframe_update) began;
                break;
        }
    } 

    private void dispose() {
    }


    public enum Action {
        /**PAGER*/
        btn_pager_create,
        btn_pager_read,
        btn_pager_update,
        btn_pager_delete,
        btn_pager_json,
        btn_pager_xml,
        btn_pager_txt,
        jButton1,
        primero,
        ANTERIOR,
        SIGUIENTE,
        ultimo,
        jComboBox1,
        
        /**CREATE*/
        eti_dni_create,
        eti_name_create,
        eti_surname_create,
        eti_date_birthday_create,
        eti_mobile_create,
        eti_avatar_create,
        //eti_state_co_create,
        //eti_state_di_create,
        eti_email_create,
        eti_user_create,
        eti_pass_create,
        eti_date_start_create,
        eti_buy_create,
        eti_tipeclient_create,
        btn_create_create,
        btn_cancel_create,
        
        /**UPDATE*/
        eti_dni_update,
        eti_name_update,
        eti_surname_update,
        eti_date_birthday_update,
        eti_mobile_update,
        eti_avatar_update,
        //eti_state_co_update,
        //eti_state_di_update,
        eti_email_update,
        eti_user_update,
        eti_pass_update,
        eti_date_start_update,
        eti_buy_update,
        eti_tipeclient_update,
        btn_update_update,
        btn_cancel_update
        
    }
    
    public void begin(int j) {
        switch (j){
            case 0:
        //Json.auto_open_json_client();
        
        this.begin_pager.setVisible(true);
        this.begin_pager.setTitle("Framework Client");
        this.begin_pager.setExtendedState(JFrame.MAXIMIZED_BOTH);       
        begin_pager.TABLA.setModel( new miniSimpleTableModel_client() );
        ((miniSimpleTableModel_client)begin_pager.TABLA.getModel()).cargar();
        begin_pager.TABLA.setFillsViewportHeight(true);
        begin_pager.TABLA.setRowSorter(sorter);

        pagina_client.inicializa();
        pagina_client.initLinkBox();
        
        begin_pager.jLabel3.setText(String.valueOf(Singleton.Client_array.size()));
        
        this.begin_pager.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                this.begin_pager.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        JOptionPane.showMessageDialog(null,"Exit to the aplication");
                        begin_pager.dispose();
                        System.exit(0);
                    }
                });
          
        List<String> myWords = new ArrayList<String>();
        for(int i=0;i<=Singleton.Client_array.size()-1;i++) {
            myWords.add(Singleton.Client_array.get(i).getname());
        }

	StringSearchable searchable = new StringSearchable(myWords);
	combo = new AutocompleteJComboBox(searchable);
        //JPanel5 se utiliza solamente para que JPanel3 que contendrá combo, no se redimensione
        begin_pager.jPanel3.setLayout(new java.awt.BorderLayout());
        begin_pager.jPanel3.add(combo);
        
        combo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {                                            
            System.out.println("word selected: " + ((JComboBox)combo).getSelectedItem());
            pagina_client.currentPageIndex = 1;
            ((miniSimpleTableModel_client)begin_pager.TABLA.getModel()).filtrar();
            combo.requestFocus();
            } 
        }                
        );
        
        begin_pager.btn_pager_create.setActionCommand("btn_pager_create");
        begin_pager.btn_pager_create.addActionListener(this);
        
        begin_pager.btn_pager_read.setActionCommand("btn_pager_read");
        begin_pager.btn_pager_read.addActionListener(this);
        
        begin_pager.btn_pager_update.setActionCommand("btn_pager_update");
        begin_pager.btn_pager_update.addActionListener(this);
        
        begin_pager.btn_pager_delete.setActionCommand("btn_pager_delete");
        begin_pager.btn_pager_delete.addActionListener(this);
        
        begin_pager.btn_pager_json.setActionCommand("btn_pager_json");
        begin_pager.btn_pager_json.addActionListener(this);
        
        begin_pager.btn_pager_xml.setActionCommand("btn_pager_xml");
        begin_pager.btn_pager_xml.addActionListener(this);
        
        begin_pager.btn_pager_txt.setActionCommand("btn_pager_txt");
        begin_pager.btn_pager_txt.addActionListener(this);
        
        begin_pager.primero.setActionCommand("primero");
        begin_pager.primero.addActionListener(this);
                
        begin_pager.ANTERIOR.setActionCommand("ANTERIOR");
        begin_pager.ANTERIOR.addActionListener(this);
                
        begin_pager.SIGUIENTE.setActionCommand("SIGUIENTE");
        begin_pager.SIGUIENTE.addActionListener(this);
                
        begin_pager.ultimo.setActionCommand("ultimo");
        begin_pager.ultimo.addActionListener(this);
                
        begin_pager.jButton1.setActionCommand("jButton1");
        begin_pager.jButton1.addActionListener(this);
                
        begin_pager.jComboBox1.setActionCommand("jComboBox1");
        begin_pager.jComboBox1.addActionListener(this);
        break;
        
    case 1:
       
        eti_date_birthday_create.getDateEditor().setEnabled(false);
        eti_date_start_create.getDateEditor().setEnabled(false);
        this.begin_create.setVisible(true);
        begin_create.setTitle("Create Client");
	begin_create.setLocationRelativeTo(null);
	begin_create.setResizable(true);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null,"Exit to the aplication");
                        dispose();
                        System.exit(0);
            }
       });
        
        begin_create.eti_dni_create.setActionCommand("eti_dni_create");
        begin_create.eti_dni_create.setName("eti_dni_create");
        begin_create.eti_dni_create.addFocusListener(this);
        begin_create.eti_dni_create.addMouseListener(this);
        begin_create.eti_dni_create.addKeyListener(this);
        
        begin_create.eti_name_create.setActionCommand("eti_name_create");
        begin_create.eti_name_create.setName("eti_name_create");
        begin_create.eti_name_create.addFocusListener(this);
        begin_create.eti_name_create.addMouseListener(this);
        begin_create.eti_name_create.addKeyListener(this);
        
        begin_create.eti_surname_create.setActionCommand("eti_surname_create");
        begin_create.eti_surname_create.setName("eti_surname_create");
        begin_create.eti_surname_create.addFocusListener(this);
        begin_create.eti_surname_create.addMouseListener(this);
        begin_create.eti_surname_create.addKeyListener(this);
        
        begin_create.eti_mobile_create.setActionCommand("eti_mobile_create");
        begin_create.eti_mobile_create.setName("eti_mobile_create");
        begin_create.eti_mobile_create.addFocusListener(this);
        begin_create.eti_mobile_create.addMouseListener(this);
        begin_create.eti_mobile_create.addKeyListener(this);
        
        begin_create.eti_email_create.setActionCommand("eti_email_create");
        begin_create.eti_email_create.setName("eti_email_create");
        begin_create.eti_email_create.addFocusListener(this);
        begin_create.eti_email_create.addMouseListener(this);
        begin_create.eti_email_create.addKeyListener(this);
        
        begin_create.eti_user_create.setActionCommand("eti_user_create");
        begin_create.eti_user_create.setName("eti_user_create");
        begin_create.eti_user_create.addFocusListener(this);
        begin_create.eti_user_create.addMouseListener(this);
        begin_create.eti_user_create.addKeyListener(this);
        
        begin_create.eti_avatar_create.setName("eti_avatar_create");
        begin_create.eti_avatar_create.addMouseListener(this);
        
        begin_create.eti_pass_create.setActionCommand("eti_pass_create");
        begin_create.eti_pass_create.setName("eti_pass_create");
        begin_create.eti_pass_create.addFocusListener(this);
        begin_create.eti_pass_create.addMouseListener(this);
        begin_create.eti_pass_create.addKeyListener(this);
        
        begin_create.eti_buy_create.setActionCommand("eti_buy_create");
        begin_create.eti_buy_create.setName("eti_buy_create");
        begin_create.eti_buy_create.addFocusListener(this);
        begin_create.eti_buy_create.addMouseListener(this);
        begin_create.eti_buy_create.addKeyListener(this);
        
        begin_create.eti_tipeclient_create.setActionCommand("eti_tipeclient_create");
        begin_create.eti_tipeclient_create.setName("eti_tipeclient_create");
        begin_create.eti_tipeclient_create.addFocusListener(this);
        begin_create.eti_tipeclient_create.addMouseListener(this);
        begin_create.eti_tipeclient_create.addKeyListener(this);
        
        begin_create.btn_create_create.setActionCommand("btn_create_create");
        begin_create.btn_create_create.addActionListener(this);
        
        begin_create.btn_cancel_create.setActionCommand("btn_cancel_create");
        begin_create.btn_cancel_create.addActionListener(this);    
        break;
     
    case 2:
         
        dao_client.modifyclient();
        
        this.begin_update.setVisible(true);
        DNI=eti_dni_update.getText();
        eti_dni_update.setEnabled(false);
        eti_date_birthday_update.getDateEditor().setEnabled(false);
        eti_date_start_update.getDateEditor().setEnabled(false);
        
        begin_update.setTitle("Update Client");
	begin_update.setLocationRelativeTo(null);
	begin_update.setResizable(true);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null,"Exit to the aplication");
                dispose();
                System.exit(0);
            }
        });
        
        begin_update.eti_dni_update.setActionCommand("eti_dni_update");
        begin_update.eti_dni_update.setName("eti_dni_update");
        begin_update.eti_dni_update.addFocusListener(this);
        begin_update.eti_dni_update.addMouseListener(this);
        begin_update.eti_dni_update.addKeyListener(this);
        
        begin_update.eti_name_update.setActionCommand("eti_name_update");
        begin_update.eti_name_update.setName("eti_name_update");
        begin_update.eti_name_update.addFocusListener(this);
        begin_update.eti_name_update.addMouseListener(this);
        begin_update.eti_name_update.addKeyListener(this);
        
        begin_update.eti_surname_update.setActionCommand("eti_surname_update");
        begin_update.eti_surname_update.setName("eti_surname_update");
        begin_update.eti_surname_update.addFocusListener(this);
        begin_update.eti_surname_update.addMouseListener(this);
        begin_update.eti_surname_update.addKeyListener(this);
        
        begin_update.eti_mobile_update.setActionCommand("eti_mobile_update");
        begin_update.eti_mobile_update.setName("eti_mobile_update");
        begin_update.eti_mobile_update.addFocusListener(this);
        begin_update.eti_mobile_update.addMouseListener(this);
        begin_update.eti_mobile_update.addKeyListener(this);
        
        begin_update.eti_email_update.setActionCommand("eti_email_update");
        begin_update.eti_email_update.setName("eti_email_update");
        begin_update.eti_email_update.addFocusListener(this);
        begin_update.eti_email_update.addMouseListener(this);
        begin_update.eti_email_update.addKeyListener(this);
        
        begin_update.eti_user_update.setActionCommand("eti_user_update");
        begin_update.eti_user_update.setName("eti_user_update");
        begin_update.eti_user_update.addFocusListener(this);
        begin_update.eti_user_update.addMouseListener(this);
        begin_update.eti_user_update.addKeyListener(this);
        
        begin_update.eti_pass_update.setActionCommand("eti_pass_update");
        begin_update.eti_pass_update.setName("eti_pass_update");
        begin_update.eti_pass_update.addFocusListener(this);
        begin_update.eti_pass_update.addMouseListener(this);
        begin_update.eti_pass_update.addKeyListener(this);
        
        begin_update.eti_avatar_update.setName("eti_avatar_update");
        begin_update.eti_avatar_update.addMouseListener(this);
        
        begin_update.eti_buy_update.setActionCommand("eti_buy_update");
        begin_update.eti_buy_update.setName("eti_buy_update");
        begin_update.eti_buy_update.addFocusListener(this);
        begin_update.eti_buy_update.addMouseListener(this);
        begin_update.eti_buy_update.addKeyListener(this);
        
        begin_update.btn_update_update.setActionCommand("btn_update_update");
        begin_update.btn_update_update.addActionListener(this);
        
        begin_update.btn_cancel_update.setActionCommand("btn_cancel_update");
        begin_update.btn_cancel_update.addActionListener(this);
        break;
        
     }
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Action.valueOf(e.getActionCommand())) {
            case btn_pager_create:
                begin_pager.dispose();
                new Controller_client(new client_jframe_create(), 1).begin(1);
            break;
            
            case btn_pager_read:
                int select_read =-1;
                select_read=begin_pager.TABLA.getSelectedRow();
                if (select_read==-1){
                JOptionPane.showMessageDialog(null, "Usuario no seleccionado");
                }else{
                bll_client.print_client();
                }
            break;
            
            case btn_pager_update:
                int select_update =-1;
                select_update=begin_pager.TABLA.getSelectedRow();
                if (select_update==-1){
                JOptionPane.showMessageDialog(null, "Usuario no seleccionado");
                }else{
                Singleton_login.tabla=true;
                begin_pager.dispose();       
                new Controller_client(new client_jframe_update(), 2).begin(2);
                }         
            break;
                        
            case btn_pager_delete:
                bll_client.delete_client();
            break;
            
            case btn_pager_json:
                 Json.create_json_client();
            break;
            
            case btn_pager_xml:
                Xml.create_xml_client();
            break;
            
            case btn_pager_txt:
                Txt.create_txt_client();
            break;
            
            case primero:
                pagina_client.currentPageIndex = 1;
                pagina_client.initLinkBox();
            break;
            
            case ANTERIOR:
                pagina_client.currentPageIndex -= 1;
                pagina_client.initLinkBox();
            break;
            
            case SIGUIENTE:
                pagina_client.currentPageIndex += 1;
                pagina_client.initLinkBox();
            break;
            
            case ultimo:
                pagina_client.currentPageIndex = pagina_client.maxPageIndex;
                pagina_client.initLinkBox();
            break;
            
            case jButton1:
                begin_pager.dispose();
                new Controller_menu(new choose_frame(),0).began(0);
            break;
            
            case jComboBox1:
                pagina_client.itemsPerPage=Integer.parseInt(jComboBox1.getSelectedItem().toString());
                pagina_client.currentPageIndex = 1;
                pagina_client.initLinkBox();
            break;
            
            case btn_create_create:
                bll_client.create_client();
                    try {
                        Thread.sleep(2000);
                        begin_create.dispose();
                        new Controller_client(new pager_client(), 0).begin(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(client_jframe_create.class.getName()).log(Level.SEVERE, null, ex);
                        }
            break;
            
            case btn_cancel_create:
                begin_create.dispose();
                new Controller_client(new pager_client(), 0).begin(0);
            break;
            
            case btn_update_update:
                bll_client.update_client();
                bll_client.timer(begin_update);
            break;
            
            case btn_cancel_update:
                begin_update.dispose();
                new Controller_client(new pager_client(), 0).begin(0);
            break;
        }        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        switch (Action.valueOf(e.getComponent().getName())) {
            case eti_dni_create:
                eti_dni_create.selectAll();
            break;
            
            case eti_name_create:
                eti_name_create.selectAll();
            break;
            
            case eti_surname_create:
                eti_surname_create.selectAll();
            break;
            
            case eti_mobile_create:
                eti_mobile_create.selectAll();
            break;
            
            case eti_email_create:
                eti_email_create.selectAll();
            break;
            
            case eti_user_create:
                eti_user_create.selectAll();
            break;
            
            case eti_pass_create:
                eti_pass_create.selectAll();
            break;
            
            case eti_buy_create:
                eti_buy_create.selectAll();
            break;
            
            case eti_avatar_create:
                 bll_client.giveavatar();
            break;
            
            case eti_tipeclient_create:
                bll_client.givetypeclient();
                break;
            
            case eti_dni_update:
                eti_dni_update.selectAll();
            break;
            
            case eti_name_update:
                eti_name_update.selectAll();
            break;
            
            case eti_surname_update:
                eti_surname_update.selectAll();
            break;
            
            case eti_mobile_update:
                eti_mobile_update.selectAll();
            break;
            
            case eti_email_update:
                eti_email_update.selectAll();
            break;
            
            case eti_user_update:
                eti_user_update.selectAll();
            break;
            
            case eti_pass_update:
                eti_pass_update.selectAll();
            break;
            
            case eti_buy_update:
                eti_buy_update.selectAll();
            break;
            
            case eti_avatar_update:
                bll_client.giveavatar_update();
            break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (Action.valueOf(e.getComponent().getName())) {
            case eti_dni_create:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                eti_name_create.requestFocus();
                }else{
                bll_client.givedates("dni");
                }
            break;
            
            case eti_name_create:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    eti_surname_create.requestFocus();
                }else{
                    bll_client.givedates("name");
                }
            break;
            
            case eti_surname_create:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    eti_mobile_create.requestFocus();
                }else{
                    bll_client.givedates("surname");
                }
            break;
            
            case eti_mobile_create:
                 if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    eti_avatar_create.requestFocus();
                }else{
                    bll_client.givedates("mobile");
                }
            break;
            
            case eti_email_create:
                 if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    eti_user_create.requestFocus();
                }else{
                    bll_client.givedates("email");
                }
            break;
            
            case eti_user_create:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    eti_pass_create.requestFocus();
                }else{
                    bll_client.givedates("user");
                }
            break;
            
            case eti_pass_create:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    eti_buy_create.requestFocus();
                }else{
                    bll_client.givedates("pass");
                }
            break;
                       
            case eti_buy_create:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    eti_tipeclient_create.requestFocus();
                }else{
                    bll_client.givedates("buy");
                }
            break;
            
            case eti_tipeclient_create:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btn_create_create.requestFocus();
                }else{
                    bll_client.givedates("client_type");
                }
            break;
            
            case eti_dni_update:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    eti_name_update.requestFocus();
                }else{
                    bll_client.givedates_update("dni");
                }
            break;
            
            case eti_name_update:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    eti_surname_update.requestFocus();
                }else{
                    bll_client.givedates_update("name");
                }
            break;
            
            case eti_surname_update:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    eti_mobile_update.requestFocus();
                }else{
                    bll_client.givedates_update("surname");
                }
            break;
            
            case eti_mobile_update:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    eti_avatar_update.requestFocus();
                }else{
                    bll_client.givedates_update("mobile");
                }
            break;
            
            case eti_email_update:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    eti_user_update.requestFocus();
                }else{
                    bll_client.givedates_update("email");
                }
            break;
            
            case eti_user_update:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    eti_pass_update.requestFocus();
                }else{
                    bll_client.givedates_update("user");
                }
            break;
            
            case eti_pass_update:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    eti_buy_update.requestFocus();
                }else{
                    bll_client.givedates_update("pass");
                }
            break;
            
            case eti_buy_update:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    eti_tipeclient_update.requestFocus();
                }else{
                    bll_client.givedates_update("buy");
                }
            break;
            
            case eti_tipeclient_update:
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btn_update_update.requestFocus();
                }else{
                    bll_client.givedates("client_type");
                }
            break;
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void focusGained(FocusEvent e) {
        switch (Action.valueOf(e.getComponent().getName())) {
            case eti_dni_create:
                eti_dni_create.selectAll();
            break;
            
            case eti_name_create:
                eti_name_create.selectAll();
            break;
            
            case eti_surname_create:
                eti_surname_create.selectAll();
            break;
            
            case eti_mobile_create:
                eti_mobile_create.selectAll();
            break;
            
            case eti_email_create:
                eti_email_create.selectAll();
            break;
            
            case eti_user_create:
                eti_user_create.selectAll();
            break;
            
            case eti_pass_create:
                eti_pass_create.selectAll();
            break;
            
            case eti_buy_create:
                eti_buy_create.selectAll();
            break;
            
            case eti_tipeclient_create:
                eti_tipeclient_create.selectAll();
            break;
            
            case eti_dni_update:
                eti_dni_update.selectAll();
            break;
            
            case eti_name_update:
                eti_name_update.selectAll();
            break;
            
            case eti_surname_update:
                eti_surname_update.selectAll();
            break;
            
            case eti_mobile_update:
                eti_mobile_update.selectAll();
            break;
            
            case eti_email_update:
                eti_email_update.selectAll();
            break;
            
            case eti_user_update:
                eti_user_update.selectAll();
            break;
            
            case eti_pass_update:
                eti_pass_update.selectAll();
            break;
            
            case eti_buy_update:
                eti_buy_update.selectAll();
            break;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        switch (Action.valueOf(e.getComponent().getName())) {
            case eti_dni_create:
                bll_client.givedates("dni");
            break;
            
            case eti_name_create:
                bll_client.givedates("name");
            break;
            
            case eti_surname_create:
                bll_client.givedates("surnames");
            break;
            
            case eti_mobile_create:
                bll_client.givedates("mobile");
            break;
            
            case eti_email_create:
                 bll_client.givedates("email");
            break;
            
            case eti_user_create:
                bll_client.givedates("user");
            break;
            
            case eti_pass_create:
                bll_client.givedates("pass");
            break;
            
            case eti_buy_create:
                bll_client.givedates("buy");
            break;
            
            case eti_tipeclient_create:
                bll_client.givedates("client_type");
            break;
            
            case eti_dni_update:
                bll_client.givedates_update("dni");
            break;
            
            case eti_name_update:
                bll_client.givedates_update("name");
            break;
            
            case eti_surname_update:
                bll_client.givedates_update("surnames");
            break;
            
            case eti_mobile_update:
                bll_client.givedates_update("mobile");
            break;
            
            case eti_email_update:
                 bll_client.givedates_update("email");
            break;
            
            case eti_user_update:
                bll_client.givedates_update("user");
            break;
            
            case eti_pass_update:
                bll_client.givedates_update("pass");
            break;
            
            case eti_buy_update:
                bll_client.givedates_update("buy");
            break;
        }
    }
}