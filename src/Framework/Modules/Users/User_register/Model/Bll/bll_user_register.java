package Framework.Modules.Users.User_register.Model.Bll;

import static Framework.Class.Singleton_tools.cancel;
import static Framework.Class.Singleton_tools.okey;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import Framework.Modules.Users.User_register.Controller.Controller_user_register;
import Framework.Modules.Users.User_register.Model.Clases.Class_user_register;
import Framework.Modules.Users.User_register.Model.Clases.miniSimpleTableModel_user_register;
import Framework.Modules.Users.User_register.Model.Dao.dao_user_register;
import Framework.Modules.Users.User_register.Model.Utils.Extensions.Json;
import Framework.Modules.Users.User_register.Model.Utils.Pager.pagina_user_register;
import Framework.Modules.Users.User_register.View.pager_user_register;
import static Framework.Modules.Users.User_register.View.pager_user_register.TABLA;
import static Framework.Modules.Users.User_register.View.pager_user_register.jLabel3;
import Framework.Modules.Users.User_register.View.user_register_jframe_create;
import Framework.Modules.Users.User_register.View.user_register_jframe_update;
import Framework.Utils.Menus;
import java.awt.Color;
import java.util.Calendar;
import javax.swing.JOptionPane;



public class bll_user_register {
	
	/**USER REGISTER*/
	
	/**SEARCH USER REGISTER*/
	public static int search_user_register(Class_user_register usr_reg){ 
            
		for (int i = 0; i<=(Singleton.User_register_array.size()-1); i++){
			if((Singleton.User_register_array.get(i)).equals(usr_reg) )
				return i;
		}
		return -1;
	}
        	
	/**GIVE DNI USER REGISTER*/
	public static Class_user_register give_dni_user_register() {
            
            int selection, inicio, selection1;
		inicio=(pagina_user_register.currentPageIndex-1)*pagina_user_register.itemsPerPage; //nos situamos al inicio de la página en cuestión
                selection=pager_user_register.TABLA.getSelectedRow(); //nos situamos en la fila
                selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
		Singleton.DNI=(String)pager_user_register.TABLA.getModel().getValueAt(selection1, 0);
		Class_user_register usr_reg=new Class_user_register(Singleton.DNI);
	return usr_reg;
	}
        
        public static Class_user_register select_user_register() {
            
            int selection, inicio, selection1, position=-1;
                
		inicio=(pagina_user_register.currentPageIndex-1)*pagina_user_register.itemsPerPage; //nos situamos al inicio de la página en cuestión
                selection=pager_user_register.TABLA.getSelectedRow(); //nos situamos en la fila
                selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
		Singleton.DNI=(String)pager_user_register.TABLA.getModel().getValueAt(selection1, 0);
		Class_user_register usr_reg=new Class_user_register(Singleton.DNI);
                position=bll_user_register.search_user_register(usr_reg);
                if(position !=-1){
                    usr_reg=Singleton.User_register_array.get(position);                                            
			}else {
				JOptionPane.showMessageDialog(null, "This DNI dosent't exist", "Error", JOptionPane.ERROR_MESSAGE);
                }                
	return usr_reg;
	}
        
       
       	
	/**CREATE USER REGISTER*/
	public static void create_user_register(){
		int position=-1;
		
		Class_user_register usr_reg=null;
				
                usr_reg=dao_user_register.create();
                if(usr_reg==null)
                    JOptionPane.showMessageDialog(null, "User not create");
                else {
                    position=bll_user_register.search_user_register(usr_reg);
		if (position !=-1){
			JOptionPane.showMessageDialog(null, "This Administrator is already exist", "Error Administrator", JOptionPane.ERROR_MESSAGE);
		}else{ usr_reg=dao_user_register.create();
		Singleton.User_register_array.add(usr_reg);
                    JOptionPane.showMessageDialog(null, "User create");
                    Json.auto_create_json_usr_reg();
		}
                }
	}
        
        /**CREATE USER REGISTER update*/
	public static void create_user_register_update(){
		int position=-1;
		
		Class_user_register usr_reg=null;
				
                usr_reg=dao_user_register.create_update();
                if(usr_reg==null)
                    JOptionPane.showMessageDialog(null, "User not modified");
                else {
                    position=bll_user_register.search_user_register(usr_reg);
		if (position !=-1){
			JOptionPane.showMessageDialog(null, "This Administrator is already exist", "Error Administrator", JOptionPane.ERROR_MESSAGE);
		}else{ usr_reg=dao_user_register.create_update();
		Singleton.User_register_array.add(usr_reg);
                    JOptionPane.showMessageDialog(null, "User modify");
		}
                }
               
	}
	
	/**PRINT USER REGISTER*/
	public static void print_user_register (){
		int menu=0, position=-1;
                Class_user_register usr_reg=null;
		String[] submenu={"Read all data", "Read only the DNI"};
		
                
		if(Singleton.User_register_array.isEmpty()){
			JOptionPane.showMessageDialog(null, "There aren't any Administrator", "Administrator", JOptionPane.ERROR_MESSAGE);
		}else{
			menu=Menus.menubutton(submenu, "What do you want?", "Choosing");
			switch (menu){
				case 0:
					for (int i=0; i<Singleton.User_register_array.size(); i++){
						JOptionPane.showMessageDialog(null, Singleton.User_register_array.get(i).toString(), "Print", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 1:
					position=-1;
					usr_reg=bll_user_register.give_dni_user_register();
					position=bll_user_register.search_user_register(usr_reg);
					if (position!=-1){
						usr_reg=Singleton.User_register_array.get(position);
						JOptionPane.showMessageDialog(null, usr_reg.toString());
					}else{
						JOptionPane.showMessageDialog(null, "This DNI dosent't exist", "Error", JOptionPane.ERROR_MESSAGE);
					}
					break;
			}
		}
	}      
        
	/**UPDATE USER REGISTER*/
	 public static void update_user_register() {
            
            int position1=-1, position2=-1;               
		if(Singleton.User_register_array.isEmpty()){
			JOptionPane.showMessageDialog(null, "There aren't any Administrator", "Administrator", JOptionPane.ERROR_MESSAGE);
		}else{
		Class_user_register usr_reg=new Class_user_register(Controller_user_register.DNI);
                position1=bll_user_register.search_user_register(usr_reg);
                if(position1 !=-1){                    
                    usr_reg=dao_user_register.create_update();
                    position2=bll_user_register.search_user_register(usr_reg);
                    if(position2 ==-1){
				Singleton.User_register_array.set(position1, usr_reg); 
                                Json.auto_create_json_usr_reg();
			}else {
				JOptionPane.showMessageDialog(null, "This DNI dosent't exist", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                }
                }
        }      
        
	/**DELETE USER REGISTER*/
	        
         public static void delete_user_register() {
        String dni;
        int pos;
        int n, selection, inicio, selection1;

         
        
        n=((miniSimpleTableModel_user_register) pager_user_register.TABLA.getModel()).getRowCount();  
        if(n!=0){
            inicio=(pagina_user_register.currentPageIndex-1)*pagina_user_register.itemsPerPage; //nos situamos al inicio de la página en cuestión
             selection=pager_user_register.TABLA.getSelectedRow(); //nos situamos en la fila
             selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
            if (selection1 == -1) {
                JOptionPane.showMessageDialog(null, "There isn't anybody selected", "Error!", 2);
            } else {
                
                dni = (String) pager_user_register.TABLA.getModel().getValueAt(selection1, 0);
                Class_user_register usr_reg = new Class_user_register(dni);
                pos = bll_user_register.search_user_register((Class_user_register) usr_reg);
                
                int opc = JOptionPane.showConfirmDialog(null, "Do you want this person with DNI: " + dni +" "+"?",
                        "Info", JOptionPane.WARNING_MESSAGE);

                if (opc == 0) {
                    ((miniSimpleTableModel_user_register) pager_user_register.TABLA.getModel()).removeRow(selection);
                    usr_reg = Singleton.User_register_array.get(pos);
                    Singleton.User_register_array.remove(usr_reg);                    
                    miniSimpleTableModel_user_register.datosaux.remove(usr_reg);
                    Json.auto_create_json_usr_reg();
                    ((miniSimpleTableModel_user_register) pager_user_register.TABLA.getModel()).cargar();
                    jLabel3.setText(String.valueOf(Singleton.User_register_array.size()));
                    pagina_user_register.initLinkBox();
                }
                if (pager_user_register.TABLA.getRowCount() == 0) {
                    pagina_user_register.currentPageIndex-=1;
                    pagina_user_register.initLinkBox();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empty list", "Error!", 2);
        }
    }      
         
        public static void giveavatar(){
            dao_user_register.giveavatar(dao_user_register.dialogoSelectorImagen());
        }
        
        public static void giveavatar_update(){
            dao_user_register.giveavatar_update(dao_user_register.dialogoSelectorImagen_update());
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
                Validatedatebirthday(user_register_jframe_create.eti_date_birthday_create.getCalendar());
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
            case "activity":
                 giveactivity();
                break;
           
        }
    }
        
         public static void givedni() {
                
        if (dao_user_register.givedni()==false) {
            user_register_jframe_create.eti_dni_create.setBackground(Color.red);
            user_register_jframe_create.lab_dni.setIcon(cancel);
                        
        } else {
            
                user_register_jframe_create.eti_dni_create.setBackground(Color.CYAN);
                user_register_jframe_create.lab_dni.setIcon(okey);
              }
        }
        
        
        public static void givename() {        
        
        if (dao_user_register.givename()==false) {
            user_register_jframe_create.eti_name_create.setBackground(Color.red);
            user_register_jframe_create.lab_name.setIcon(cancel);         
        
            } else {
                user_register_jframe_create.eti_name_create.setBackground(Color.CYAN);
                user_register_jframe_create.lab_name.setIcon(okey);
              }
        }
     
        
        public static void givesurname() {
               
        if (dao_user_register.givesurname()==false) {
            user_register_jframe_create.eti_surname_create.setBackground(Color.red);
            user_register_jframe_create.lab_surname.setIcon(cancel);
                     
            } else {
                user_register_jframe_create.eti_surname_create.setBackground(Color.CYAN);
                user_register_jframe_create.lab_surname.setIcon(okey);
               
            }
        }
     
        
        public static void givemobile() {
       
        if (dao_user_register.givemobile()==false){
            user_register_jframe_create.eti_mobile_create.setBackground(Color.red);
            user_register_jframe_create.lab_mobile.setIcon(cancel);
            
            } else {
                user_register_jframe_create.eti_mobile_create.setBackground(Color.CYAN);
                user_register_jframe_create.lab_mobile.setIcon(okey);
               
            }
        }
         
         public static void givemail() {
        
       
        if (dao_user_register.givemail()==false) {
            user_register_jframe_create.eti_email_create.setBackground(Color.red);
            user_register_jframe_create.lab_email.setIcon(cancel);
                                    
            } else {
                user_register_jframe_create.eti_email_create.setBackground(Color.CYAN);
                user_register_jframe_create.lab_email.setIcon(okey);
                
            }
        }
    
        
        public static void giveuser() {
               
        if (dao_user_register.giveuser()==false) {
            user_register_jframe_create.eti_user_create.setBackground(Color.red);
            user_register_jframe_create.lab_user.setIcon(cancel);       
           } else {
                user_register_jframe_create.eti_user_create.setBackground(Color.CYAN);
                user_register_jframe_create.lab_user.setIcon(okey);
                
            }
        }
        
                   
        public static void givepassword() {
        
        
        if (dao_user_register.givepassword()==false) {
            user_register_jframe_create.lab_pass.setBackground(Color.red);
            user_register_jframe_create.lab_pass.setIcon(cancel);    
            } else {
                user_register_jframe_create.eti_pass_create.setBackground(Color.CYAN);
                user_register_jframe_create.lab_pass.setIcon(okey);
                
            }
        }
      
        
         public static void giveactivity() {
           
           if (dao_user_register.giveactivity()==false) {
            user_register_jframe_create.lab_activity.setBackground(Color.red);
            user_register_jframe_create.lab_activity.setIcon(cancel);    
            } else {
                user_register_jframe_create.eti_activity_create.setBackground(Color.CYAN);
                user_register_jframe_create.lab_activity.setIcon(okey);
                
            }
        }
       
        public static void Validatedatebirthday(Calendar birthdate) {
            if (dao_user_register.give_date_birthday(birthdate)==false) {
            user_register_jframe_create.lab_date_birthday.setBackground(Color.red);
            user_register_jframe_create.lab_date_birthday.setIcon(cancel);    
            } else {
                user_register_jframe_create.eti_date_birthday_create.setBackground(Color.CYAN);
                user_register_jframe_create.lab_date_birthday.setIcon(okey);
                
            }
        }
        
         /**GIVE DATES*/
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
                Validatedatebirthday_update(user_register_jframe_create.eti_date_birthday_create.getCalendar());
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
            case "activity":
                 giveactivity_update();
                break;
        }
    }
        
         public static void givedni_update() {
                
        if (dao_user_register.givedni_update()==false) {
            user_register_jframe_update.eti_dni_update.setBackground(Color.red);
            user_register_jframe_update.lab_dni.setIcon(cancel);
                        
        } else {
            
                user_register_jframe_update.eti_dni_update.setBackground(Color.CYAN);
                user_register_jframe_update.lab_dni.setIcon(okey);
              }
        }
        
        
        public static void givename_update() {        
        
        if (dao_user_register.givename_update()==false) {
            user_register_jframe_update.eti_name_update.setBackground(Color.red);
            user_register_jframe_update.lab_name.setIcon(cancel);         
        
            } else {
                user_register_jframe_update.eti_name_update.setBackground(Color.CYAN);
                user_register_jframe_update.lab_name.setIcon(okey);
              }
        }
     
        
        public static void givesurname_update() {
               
        if (dao_user_register.givesurname_update()==false) {
            user_register_jframe_update.eti_surname_update.setBackground(Color.red);
            user_register_jframe_update.lab_surname.setIcon(cancel);
                     
            } else {
                user_register_jframe_update.eti_surname_update.setBackground(Color.CYAN);
                user_register_jframe_update.lab_surname.setIcon(okey);
               
            }
        }
     
        
        public static void givemobile_update() {
       
        if (dao_user_register.givemobile_update()==false){
            user_register_jframe_update.eti_mobile_update.setBackground(Color.red);
            user_register_jframe_update.lab_mobile.setIcon(cancel);
            
            } else {
                user_register_jframe_update.eti_mobile_update.setBackground(Color.CYAN);
                user_register_jframe_update.lab_mobile.setIcon(okey);
               
            }
        }
         
         public static void givemail_update() {
        
       
        if (dao_user_register.givemail_update()==false) {
            user_register_jframe_update.eti_email_update.setBackground(Color.red);
            user_register_jframe_update.lab_email.setIcon(cancel);
                                    
            } else {
                user_register_jframe_update.eti_email_update.setBackground(Color.CYAN);
                user_register_jframe_update.lab_email.setIcon(okey);
                
            }
        }
    
        
        public static void giveuser_update() {
               
        if (dao_user_register.giveuser_update()==false) {
            user_register_jframe_update.eti_user_update.setBackground(Color.red);
            user_register_jframe_update.lab_user.setIcon(cancel);       
           } else {
                user_register_jframe_update.eti_user_update.setBackground(Color.CYAN);
                user_register_jframe_update.lab_user.setIcon(okey);
                
            }
        }
        
                   
        public static void givepassword_update() {
        
        
        if (dao_user_register.givepassword_update()==false) {
            user_register_jframe_update.lab_pass.setBackground(Color.red);
            user_register_jframe_update.lab_pass.setIcon(cancel);    
            } else {
                user_register_jframe_update.eti_pass_update.setBackground(Color.CYAN);
                user_register_jframe_update.lab_pass.setIcon(okey);
                
            }
        }
      
        
         public static void giveactivity_update() {
           
           if (dao_user_register.giveactivity_update()==false) {
            user_register_jframe_update.lab_activity.setBackground(Color.red);
            user_register_jframe_update.lab_activity.setIcon(cancel);    
            } else {
                user_register_jframe_update.eti_activity_update.setBackground(Color.CYAN);
                user_register_jframe_update.lab_activity.setIcon(okey);
                
            }
        }
         
        public static void Validatedatebirthday_update(Calendar birthdate) {
            if (dao_user_register.Validatedatebirthday_update(birthdate)==false) {
            user_register_jframe_update.lab_date_birthday.setBackground(Color.red);
            user_register_jframe_update.lab_date_birthday.setIcon(cancel);    
            } else {
                user_register_jframe_update.eti_date_birthday_update.setBackground(Color.CYAN);
                user_register_jframe_update.lab_date_birthday.setIcon(okey);
                
            }
        }
        
}