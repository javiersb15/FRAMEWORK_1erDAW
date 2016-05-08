package Framework.Modules.Users.Client.Model.Bll;

import static Framework.Class.Singleton_tools.cancel;
import static Framework.Class.Singleton_tools.okey;
import Framework.Modules.Login.Controller.Controller_login;
import Framework.Modules.Login.Model.Clases.Singleton_login;
import Framework.Modules.Login.View.login_frame;
import Framework.Modules.Menu.Controller.Controller_menu;
import Framework.Modules.Menu.View.choose_frame;
import Framework.Modules.Users.Client.Controller.Controller_client;
import Framework.Modules.Users.Client.Model.Clases.Class_client;
import Framework.Modules.Users.Client.Model.Clases.Singleton_cli;
import Framework.Modules.Users.Client.Model.Clases.miniSimpleTableModel_client;
import Framework.Modules.Users.Client.Model.Dao.dao_client;
import Framework.Modules.Users.Client.Model.Utils.Pager.pagina_client;
import Framework.Modules.Users.Client.View.client_jframe_create;
import Framework.Modules.Users.Client.View.client_jframe_update;
import Framework.Modules.Users.Client.View.pager_client;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import Framework.Utils.Menus;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class bll_client {
    public static boolean check;
	
	/**CLIENT*/
	
	/**SEARCH CLIENT*/
	public static int search_client(Class_client cli){ 
            
		for (int i = 0; i<=(Singleton.Client_array.size()-1); i++){
			if((Singleton.Client_array.get(i)).equals(cli) )
				return i;
		}
		return -1;
	}
        	
	/**GIVE DNI CLIENT*/
	public static Class_client give_dni_client() {
            
            int selection, inicio, selection1;
		inicio=(pagina_client.currentPageIndex-1)*pagina_client.itemsPerPage; //nos situamos al inicio de la página en cuestión
                selection=pager_client.TABLA.getSelectedRow(); //nos situamos en la fila
                selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
		Singleton.DNI=(String)pager_client.TABLA.getModel().getValueAt(selection1, 0);
		Class_client cli=new Class_client(Singleton.DNI);
	return cli;
	}
        
        /**SELECT CLIENT*/
        public static Class_client select_client() {
        Class_client cli = null;
        String ID = "";
        int position = -1, selection, inicio, selection1;
        if (Singleton_login.tabla==true){
        inicio=(pagina_client.currentPageIndex-1)*pagina_client.itemsPerPage; //nos situamos al inicio de la página en cuestión
        selection=pager_client.TABLA.getSelectedRow(); //nos situamos en la fila
        selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
        ID = (String) pager_client.TABLA.getModel().getValueAt(selection1, 0);
        cli = new Class_client (ID);
        }else{
            cli = new Class_client (Singleton_login.dni);
        }
        position = -1;
        position = bll_client.search_client(cli);
        if (position != -1) {
            cli = Singleton.Client_array.get(position);
        }
        return cli;		
    }
       	
	/**CREATE CLIENT*/
	public static void create_client(){
		int position=-1;
		
		Class_client cli=null;
			
                cli=dao_client.create();
                Singleton_cli.cli=cli;
                if(cli==null)
                    JOptionPane.showMessageDialog(null, "User not create");
                else {
                    position=bll_client.search_client(cli);
		if (position !=-1){
			JOptionPane.showMessageDialog(null, "This Client is already exist", "Error Client", JOptionPane.ERROR_MESSAGE);
		}else{ cli=dao_client.create();
		Singleton.Client_array.add(cli);
                    //JOptionPane.showMessageDialog(null, "User create");
                    bll_client_db.insert_client_bll();
		}
                }
	}
        
        /**CREATE CLIENT update*/
	public static void create_client_update(){
		int position=-1;
		
		Class_client cli=null;
				
                cli=dao_client.create_update();
                if(cli==null)
                    JOptionPane.showMessageDialog(null, "User not modified");
                else {
                    position=bll_client.search_client(cli);
		if (position !=-1){
			JOptionPane.showMessageDialog(null, "This Client is already exist", "Error Client", JOptionPane.ERROR_MESSAGE);
		}else{ cli=dao_client.create_update();
		Singleton.Client_array.add(cli);
                    JOptionPane.showMessageDialog(null, "User modify");
		}
                }
               
	}
	
	/**PRINT CLIENT*/
	public static void print_client (){
		int menu=0, position=-1;
                Class_client cli=null;
		String[] submenu={"Read all data", "Read only the DNI"};
		
                
		if(Singleton.Client_array.isEmpty()){
			JOptionPane.showMessageDialog(null, "There aren't any Client", "Client", JOptionPane.ERROR_MESSAGE);
		}else{
			menu=Menus.menubutton(submenu, "What do you want?", "Choosing");
			switch (menu){
				case 0:
					for (int i=0; i<Singleton.Client_array.size(); i++){
						JOptionPane.showMessageDialog(null, Singleton.Client_array.get(i).toString(), "Print", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 1:
					position=-1;
					cli=bll_client.give_dni_client();
					position=bll_client.search_client(cli);
					if (position!=-1){
						cli=Singleton.Client_array.get(position);
						JOptionPane.showMessageDialog(null, cli.toString());
					}else{
						JOptionPane.showMessageDialog(null, "This DNI dosent't exist", "Error", JOptionPane.ERROR_MESSAGE);
					}
					break;
			}
		}
	}      
        
	/**UPDATE CLIENT*/
	 public static void update_client() {
            
            int location1 = -1;
                String dni = Controller_client.DNI;
		Class_client a1 = new Class_client (dni);
                location1 = bll_client.search_client(a1);
		if (location1 == -1) {
                        check=false;
                }else{
                        if (client_jframe_update.eti_dni_update.getText().equals(dni)){
                                a1 = dao_client.create_update();
                                Singleton_cli.cli=a1;
                                //System.out.println(a1.toString());
                                 //System.out.println(1);
                                //System.out.println(client_jframe_update.eti_name_update.getText());
                                    if (a1==null){
                                       check=false;
                                    } else {
                                        Singleton.Client_array.set(location1, a1);
                                        bll_client_db.update_client_bll();
                                        check=true;
                                   }
                        }
                } 
        }      
        
	/**DELETE CLIENT*/
	        
         public static void delete_client() {
       String dni;
        int pos;
        int inicio, selection1;
        int n = ((miniSimpleTableModel_client) pager_client.TABLA.getModel()).getRowCount();
        Class_client client = null;
        if (n != 0) {

            inicio = (pagina_client.currentPageIndex - 1) * pagina_client.itemsPerPage;
            int selec = pager_client.TABLA.getSelectedRow();
            selection1 = inicio + selec;

            if (selec == -1) {
                JOptionPane.showMessageDialog(null, "There isn't anybody selected", "Error!", 2);
            } else {
                dni = (String) pager_client.TABLA.getModel().getValueAt(selection1, 0);
                client = new Class_client(dni);
                pos = bll_client.search_client(client);
                int opc = JOptionPane.showConfirmDialog(null, "Do you want this person with DNI: " + dni +" "+"?",
                        "Info", JOptionPane.WARNING_MESSAGE);

                if (opc == 0) {
                    ((miniSimpleTableModel_client) pager_client.TABLA.getModel()).removeRow(selection1);
                    client = Singleton.Client_array.get(pos);

                    bll_client_db.delete_client_bll();
                    Singleton.Client_array.remove(client);     
                    miniSimpleTableModel_client.datosaux.remove(pos);
                    ((miniSimpleTableModel_client) pager_client.TABLA.getModel()).cargar();
                    pager_client.jLabel3.setText(String.valueOf(Singleton.Client_array.size()));
                    pagina_client.initLinkBox();
                }
                
                if (pager_client.TABLA.getRowCount()==0){
                    pagina_client.currentPageIndex -= 1;
                    pagina_client.initLinkBox();
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "Empty list", "Error!", 2);
        }
    }
         
         /**TIMER CLIENT*/
         public static void timer(JFrame jframe) {
        Timer timer = new Timer (2000, new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
                jframe.dispose();
                if (Singleton_login.admin==true){
                    new Controller_client(new pager_client(), 0).begin(0);
                }else{
                    new Controller_login(new login_frame()).began();
                }
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

       /**GIVE AVATAR*/
        public static void giveavatar(){
            dao_client.giveavatar(dao_client.dialogoSelectorImagen());
        }
        
        /**GIVE AVATAR UPDATE*/
        public static void giveavatar_update(){
            dao_client.giveavatar_update(dao_client.dialogoSelectorImagen_update());
        }
            
                       
        /**GIVE DATES*/
        public static void givedates(String type) {
        
        switch (type) {
            case "dni":
                givedni();
                break;
            case "name":
                givename();
                break;
            case "surname":
                givesurname();
                break;
            case "date_birthday":
                Validatedatebirthday(client_jframe_create.eti_date_birthday_create.getCalendar());
                break;
            case "mobile":
                givemobile();
                break;
            case "avatar":
                //correct = dao_user.
                break;
            case "state":
                //correct = dao_user.
                break;
            case "email":
                givemail();
                break;
            case "user":
                giveuser();
                break;
            case "pass":
                givepassword();
                break;
            case "date_start":
                Validatedatestart(client_jframe_create.eti_date_birthday_create.getCalendar(), client_jframe_create.eti_date_start_create.getCalendar());
                break;
            case "buy":
                 givebuy();
                break;
            case "client_type":
                 givetypeclient();
                break;
        }
    }
        
        
        /**GIVE DNI*/
         public static void givedni() {
                
        if (dao_client.givedni()==false) {
            client_jframe_create.eti_dni_create.setBackground(Color.red);
            client_jframe_create.lab_dni.setIcon(cancel);
                        
        } else {
            
                client_jframe_create.eti_dni_create.setBackground(Color.CYAN);
                client_jframe_create.lab_dni.setIcon(okey);
              }
        }
        
        
        /**GIVE NAME*/
        public static void givename() {        
        
        if (dao_client.givename()==false) {
            client_jframe_create.eti_name_create.setBackground(Color.red);
            client_jframe_create.lab_name.setIcon(cancel);         
        
            } else {
                client_jframe_create.eti_name_create.setBackground(Color.CYAN);
                client_jframe_create.lab_name.setIcon(okey);
              }
        }
     
        
        /**GIVE SURNAME*/
        public static void givesurname() {
               
        if (dao_client.givesurname()==false) {
            client_jframe_create.eti_surname_create.setBackground(Color.red);
            client_jframe_create.lab_surname.setIcon(cancel);
                     
            } else {
                client_jframe_create.eti_surname_create.setBackground(Color.CYAN);
                client_jframe_create.lab_surname.setIcon(okey);
               
            }
        }
     
       /**GIVE MOBILE*/ 
        public static void givemobile() {
       
        if (dao_client.givemobile()==false){
            client_jframe_create.eti_mobile_create.setBackground(Color.red);
            client_jframe_create.lab_mobile.setIcon(cancel);
            
            } else {
                client_jframe_create.eti_mobile_create.setBackground(Color.CYAN);
                client_jframe_create.lab_mobile.setIcon(okey);
               
            }
        }
         
        /**GIVE MAIL*/
         public static void givemail() {        
       
        if (dao_client.givemail()==false) {
            client_jframe_create.eti_email_create.setBackground(Color.red);
            client_jframe_create.lab_email.setIcon(cancel);
                                    
            } else {
                client_jframe_create.eti_email_create.setBackground(Color.CYAN);
                client_jframe_create.lab_email.setIcon(okey);
                
            }
        }
    
        /**GIVE USER*/
        public static void giveuser() {
               
        if (dao_client.giveuser()==false) {
            client_jframe_create.eti_user_create.setBackground(Color.red);
            client_jframe_create.lab_user.setIcon(cancel);       
           } else {
                client_jframe_create.eti_user_create.setBackground(Color.CYAN);
                client_jframe_create.lab_user.setIcon(okey);
                
            }
        }
        
        /**GIVE PASS*/           
        public static void givepassword() {        
        
        if (dao_client.givepassword()==false) {
            client_jframe_create.eti_pass_create.setBackground(Color.red);
            client_jframe_create.lab_pass.setIcon(cancel);    
            } else {
                client_jframe_create.eti_pass_create.setBackground(Color.CYAN);
                client_jframe_create.lab_pass.setIcon(okey);
                
            }
        }      
        
        /**GIVE BUY*/
         public static void givebuy() {
           
           if (dao_client.givebuy()==false) {
            client_jframe_create.eti_buy_create.setBackground(Color.red);
            client_jframe_create.lab_buy.setIcon(cancel);    
            } else {
                client_jframe_create.eti_buy_create.setBackground(Color.CYAN);
                client_jframe_create.lab_buy.setIcon(okey);
                
            }
        }
         
         /**GIVE TYPE CLIENT*/
         public static void givetypeclient() {
               
            if (dao_client.givetypeclient()==false) {
            client_jframe_create.eti_tipeclient_create.setBackground(Color.red);
            client_jframe_create.lab_typeclient.setIcon(cancel);
                     
            } else {
                client_jframe_create.eti_tipeclient_create.setBackground(Color.CYAN);
                client_jframe_create.lab_typeclient.setIcon(okey);
               
            }
        }
       
        /**GIVE DATE BIRTHDAY*/
        public static void Validatedatebirthday(Calendar birthdate) {
            if (dao_client.give_date_birthday(birthdate)==false) {
            client_jframe_create.eti_date_birthday_create.setBackground(Color.red);
            client_jframe_create.lab_date_birthday.setIcon(cancel);    
            } else {
                client_jframe_create.eti_date_birthday_create.setBackground(Color.CYAN);
                client_jframe_create.lab_date_birthday.setIcon(okey);
                
            }
        }
        
        /**GIVE DATE START*/
         public static void Validatedatestart(Calendar birthdate, Calendar dateemploy) {
            if (dao_client.give_date_start(birthdate,dateemploy)==false) {
            client_jframe_create.eti_date_start_create.setBackground(Color.red);
            client_jframe_create.lab_date_start.setIcon(cancel);    
            } else {
                client_jframe_create.eti_date_start_create.setBackground(Color.CYAN);
                client_jframe_create.lab_date_start.setIcon(okey);
                
            }
         }
         
         /**GIVE DATES UPDATE*/
        public static void givedates_update(String type) {
        
        switch (type) {
            case "dni":
                givedni_update();
                break;
            case "name":
                givename_update();
                break;
            case "surname":
                givesurname_update();
                break;
            case "date_birthday":
                Validatedatebirthday_update(client_jframe_update.eti_date_birthday_update.getCalendar());
                break;
            case "mobile":
                givemobile_update();
                break;
            case "avatar":
                giveavatar_update();
                break;
            case "state":
                //correct = dao_user.
                break;
            case "email":
                givemail_update();
                break;
            case "user":
                giveuser_update();
                break;
            case "pass":
                givepassword_update();
                break;
            case "date_start":
                Validatedatestart_update(client_jframe_update.eti_date_birthday_update.getCalendar(), client_jframe_update.eti_date_start_update.getCalendar());
                break;
            case "buy":
                 givebuy_update();
                break;
            case "type client":
                 givetypeclient_update();
                break;
        }
    }
        
        /**GIVE DNI UPDATE*/
         public static void givedni_update() {
                
        if (dao_client.givedni_update()==false) {
            client_jframe_update.eti_dni_update.setBackground(Color.red);
            client_jframe_update.lab_dni.setIcon(cancel);
                        
        } else {
            
                client_jframe_update.eti_dni_update.setBackground(Color.CYAN);
                client_jframe_update.lab_dni.setIcon(okey);
              }
        }
        
        /**GIVE NAME UPDATE*/
        public static void givename_update() {        
        
        if (dao_client.givename_update()==false) {
            client_jframe_update.eti_name_update.setBackground(Color.red);
            client_jframe_update.lab_name.setIcon(cancel);         
        
            } else {
                client_jframe_update.eti_name_update.setBackground(Color.CYAN);
                client_jframe_update.lab_name.setIcon(okey);
              }
        }
     
        /**GIVE SURNAME UPDATE*/
        public static void givesurname_update() {
               
        if (dao_client.givesurname_update()==false) {
            client_jframe_update.eti_surname_update.setBackground(Color.red);
            client_jframe_update.lab_surname.setIcon(cancel);
                     
            } else {
                client_jframe_update.eti_surname_update.setBackground(Color.CYAN);
                client_jframe_update.lab_surname.setIcon(okey);
               
            }
        }
     
        /**GIVE MOBILE UPDATE*/
        public static void givemobile_update() {
       
        if (dao_client.givemobile_update()==false){
            client_jframe_update.eti_mobile_update.setBackground(Color.red);
            client_jframe_update.lab_mobile.setIcon(cancel);
            
            } else {
                client_jframe_update.eti_mobile_update.setBackground(Color.CYAN);
                client_jframe_update.lab_mobile.setIcon(okey);
               
            }
        }
         
        /**GIVE MAIL*/
         public static void givemail_update() {        
       
        if (dao_client.givemail_update()==false) {
            client_jframe_update.eti_email_update.setBackground(Color.red);
            client_jframe_update.lab_email.setIcon(cancel);
                                    
            } else {
                client_jframe_update.eti_email_update.setBackground(Color.CYAN);
                client_jframe_update.lab_email.setIcon(okey);
                
            }
        }
    
        /**GIVE USER UPDATE*/
        public static void giveuser_update() {
               
        if (dao_client.giveuser_update()==false) {
            client_jframe_update.eti_user_update.setBackground(Color.red);
            client_jframe_update.lab_user.setIcon(cancel);       
           } else {
                client_jframe_update.eti_user_update.setBackground(Color.CYAN);
                client_jframe_update.lab_user.setIcon(okey);
                
            }
        }
        
        /**GIVE PASS UPDATE*/           
        public static void givepassword_update() {        
        
        if (dao_client.givepassword_update()==false) {
            client_jframe_update.eti_pass_update.setBackground(Color.red);
            client_jframe_update.lab_pass.setIcon(cancel);    
            } else {
                client_jframe_update.eti_pass_update.setBackground(Color.CYAN);
                client_jframe_update.lab_pass.setIcon(okey);
                
            }
        }
      
        /**GIVE BUY UPDATE*/
         public static void givebuy_update() {
           
           if (dao_client.givebuy_update()==false) {
            client_jframe_update.eti_buy_update.setBackground(Color.red);
            client_jframe_update.lab_buy.setIcon(cancel);    
            } else {
                client_jframe_update.eti_buy_update.setBackground(Color.CYAN);
                client_jframe_update.lab_buy.setIcon(okey);
                
            }
        }
         
         /**GIVE TYPE CLIENT UPDATE*/
         public static void givetypeclient_update() {
               
            if (dao_client.givetypeclient()==false) {
            client_jframe_update.eti_tipeclient_update.setBackground(Color.red);
            client_jframe_update.lab_typeclient.setIcon(cancel);
                     
            } else {
                client_jframe_update.eti_tipeclient_update.setBackground(Color.CYAN);
                client_jframe_update.lab_typeclient.setIcon(okey);
               
            }
        }
       
        /**GIVE DATE BIRTHDAY UPDATE*/
        public static void Validatedatebirthday_update(Calendar birthdate) {
            if (dao_client.give_date_birthday_update(birthdate)==false) {
            client_jframe_update.eti_date_birthday_update.setBackground(Color.red);
            client_jframe_update.lab_date_birthday.setIcon(cancel);    
            } else {
                client_jframe_update.eti_date_birthday_update.setBackground(Color.CYAN);
                client_jframe_update.lab_date_birthday.setIcon(okey);
                
            }
        }
        
        /**GIVE DATE START*/
         public static void Validatedatestart_update(Calendar birthdate, Calendar dateemploy) {
            if (dao_client.give_date_start_update(birthdate,dateemploy)==false) {
            client_jframe_update.eti_date_start_update.setBackground(Color.red);
            client_jframe_update.lab_date_start.setIcon(cancel);    
            } else {
                client_jframe_update.eti_date_start_update.setBackground(Color.CYAN);
                client_jframe_update.lab_date_start.setIcon(okey);
                
            }
         }
}