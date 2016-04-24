package Framework.Modules.Users.Admin.Model.Bll;

import Framework.Class.Singleton_tools;
import static Framework.Class.Singleton_tools.cancel;
import static Framework.Class.Singleton_tools.okey;
import Framework.Modules.Users.Admin.Controller.Controller_admin;
import Framework.Modules.Users.Admin.Model.Clases.Class_admin;
import Framework.Modules.Users.Admin.Model.Clases.Singleton_adm;
import Framework.Modules.Users.Admin.Model.Clases.miniSimpleTableModel_admin;
import Framework.Modules.Users.Admin.Model.Dao.dao_admin;
import Framework.Modules.Users.Admin.Model.Utils.Extensions.Json;
import Framework.Modules.Users.Admin.Model.Utils.Pager.pagina_admin;
import Framework.Modules.Users.Admin.View.admin_jframe_create;
import Framework.Modules.Users.Admin.View.admin_jframe_update;
import Framework.Modules.Users.Admin.View.pager_adm;
import javax.swing.JOptionPane;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import Framework.Utils.Menus;
import java.awt.Color;
import java.util.Calendar;

public class bll_admin {
    public static boolean check;
	
	/**ADMIN*/
	
	/**SEARCH ADMIN*/
	public static int search_admin(Class_admin adm){ 
            
		for (int i = 0; i<=(Singleton.Admin_array.size()-1); i++){
			if((Singleton.Admin_array.get(i)).equals(adm) )
				return i;
		}
		return -1;
	}
        	
	/**GIVE DNI ADMIN*/
	public static Class_admin give_dni_admin() {
            
            int selection, inicio, selection1;
		inicio=(pagina_admin.currentPageIndex-1)*pagina_admin.itemsPerPage; //nos situamos al inicio de la página en cuestión
                selection=pager_adm.TABLA.getSelectedRow(); //nos situamos en la fila
                selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
		Singleton.DNI=(String)pager_adm.TABLA.getModel().getValueAt(selection1, 0);
		Class_admin adm=new Class_admin(Singleton.DNI);
	return adm;
	}
        
        public static Class_admin select_admin() {
            
            int selection, inicio, selection1, position=-1;
                
		inicio=(pagina_admin.currentPageIndex-1)*pagina_admin.itemsPerPage; //nos situamos al inicio de la página en cuestión
                selection=pager_adm.TABLA.getSelectedRow(); //nos situamos en la fila
                selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
		Singleton.DNI=(String)pager_adm.TABLA.getModel().getValueAt(selection1, 0);
		Class_admin adm=new Class_admin(Singleton.DNI);
                position=bll_admin.search_admin(adm);
                if(position !=-1){
                    adm=Singleton.Admin_array.get(position);                                            
			}else {
				JOptionPane.showMessageDialog(null, "This DNI dosent't exist", "Error", JOptionPane.ERROR_MESSAGE);
                }                
	return adm;
	}
              
       	
	/**CREATE ADMIN*/
	public static void create_admin(){
		int position=-1;
		
		Class_admin adm=null;
				
                adm=dao_admin.create();
                Singleton_adm.adm=adm;
                if(adm==null)
                    JOptionPane.showMessageDialog(null, "User not create");
                else {
                    position=bll_admin.search_admin(adm);
		if (position !=-1){
			JOptionPane.showMessageDialog(null, "This Administrator is already exist", "Error Administrator", JOptionPane.ERROR_MESSAGE);
		}else{ 
                adm=dao_admin.create();                
                Singleton.Admin_array.add(adm);                    
                    JOptionPane.showMessageDialog(null, "User create");
                    bll_admin_db.insert_admin_bll();
		}
                }
	}
        
        /**CREATE ADMIN update*/
	public static void create_admin_update(){
		int position=-1;
		
		Class_admin adm=null;
				
                adm=dao_admin.create_update();
                Singleton_adm.adm=adm;
                if(adm==null)
                    JOptionPane.showMessageDialog(null, "User not modified");
                else {
                    position=bll_admin.search_admin(adm);
		if (position !=-1){
			JOptionPane.showMessageDialog(null, "This Administrator is already exist", "Error Administrator", JOptionPane.ERROR_MESSAGE);
		}else{ 
                adm=dao_admin.create_update();
		Singleton.Admin_array.add(adm);
                    JOptionPane.showMessageDialog(null, "User modify");
		}
                }
               
	}
	
	/**PRINT ADMIN*/
	public static void print_admin (){
		int menu=0, position=-1;
                Class_admin adm=null;
		String[] submenu={"Read all data", "Read only the DNI"};		
                
		if(Singleton.Admin_array.isEmpty()){
			JOptionPane.showMessageDialog(null, "There aren't any Administrator", "Administrator", JOptionPane.ERROR_MESSAGE);
		}else{
			menu=Menus.menubutton(submenu, "What do you want?", "Choosing");
			switch (menu){
				case 0:
					for (int i=0; i<Singleton.Admin_array.size(); i++){
						JOptionPane.showMessageDialog(null, Singleton.Admin_array.get(i).toString(), "Print", JOptionPane.INFORMATION_MESSAGE);
					}
					break;
				case 1:
					position=-1;
					adm=bll_admin.give_dni_admin();
					position=bll_admin.search_admin(adm);
					if (position!=-1){
						adm=Singleton.Admin_array.get(position);
						JOptionPane.showMessageDialog(null, adm.toString());
					}else{
						JOptionPane.showMessageDialog(null, "This DNI dosent't exist", "Error", JOptionPane.ERROR_MESSAGE);
					}
					break;
			}
		}
	}      
        
	/**UPDATE ADMIN*/
	 public static void update_admin() {
            
            int location1 = -1;
                String dni = Controller_admin.DNI;
		Class_admin a1 = new Class_admin (dni);
                location1 = bll_admin.search_admin(a1);
		if (location1 == -1) {
                        check=false;
                }else{
                        if (admin_jframe_update.eti_dni_update.getText().equals(dni)){
                                a1 = dao_admin.create_update();
                                Singleton_adm.adm=a1;
                                //System.out.println(a1.toString());
                                 //System.out.println(1);
                                //System.out.println(admin_jframe_update.eti_name_update.getText());
                                    if (a1==null){
                                       check=false;
                                    } else {
                                        Singleton.Admin_array.set(location1, a1);
                                        bll_admin_db.update_admin_bll();
                                        check=true;
                                   }
                        }
                } 
        }
         
         /*public static void update_admin() {
            
            int position1=-1, position2=-1;               
		
		Class_admin adm=new Class_admin(Controller_admin.DNI);
                
                position1=bll_admin.search_admin(adm);
                if(position1 !=-1){                    
                    adm=dao_admin.create_update();
                    position2=bll_admin.search_admin(adm);
                    if(position2 ==-1){
				Singleton.Admin_array.set(position1, adm);
                Singleton_adm.adm=adm;
                bll_admin_db.update_admin_bll();
                                Json.auto_create_json_admin();
			}else {
				JOptionPane.showMessageDialog(null, "This DNI dosent't exist hola", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                }                
        }*/
         
         /*public static boolean update_admin() {
        String dni = null;
        boolean ok = false;
        int selection, inicio, selection1, pos=0;

        if (((miniSimpleTableModel_admin) pager_adm.TABLA.getModel()).getRowCount() != 0) {
            int selec = pager_adm.TABLA.getSelectedRow();

            if (selec == -1) {
                ok = false;
                JOptionPane.showMessageDialog(null, "There_is_not_a_selected_user");

            } else {

                inicio = (pagina_admin.currentPageIndex - 1) * pagina_admin.itemsPerPage; //nos situamos al inicio de la pÃ¡gina en cuestiÃ³n
                selection = pager_adm.TABLA.getSelectedRow(); //nos situamos en la fila
                selection1 = inicio + selection; //nos situamos en la fila correspondiente de esa pÃ¡gina

                dni =(String) pager_adm.TABLA.getModel().getValueAt(selection1, 0);
                Class_admin adm = new Class_admin(dni);
                adm = Singleton.Admin_array.get(pos);
                search_admin(adm);

                new Controller_admin(new admin_jframe_update(), 2).begin(2);
                dao_admin.modifyadmin();
                ((miniSimpleTableModel_admin) pager_adm.TABLA.getModel()).cargar();
                pagina_admin.inicializa();
                pagina_admin.initLinkBox();

                ok = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "List_empty");

            ok = false;
        }
        return ok;
    }*/

	/**DELETE ADMIN*/
	        
         public static void delete_admin() {
        String dni;
        int pos;
        int n, selection, inicio, selection1;

        n=((miniSimpleTableModel_admin) pager_adm.TABLA.getModel()).getRowCount();  
        if(n!=0){
            inicio=(pagina_admin.currentPageIndex-1)*pagina_admin.itemsPerPage; //nos situamos al inicio de la página en cuestión
             selection=pager_adm.TABLA.getSelectedRow(); //nos situamos en la fila
             selection1=inicio+selection; //nos situamos en la fila correspondiente de esa página
            if (selection1 == -1) {
                JOptionPane.showMessageDialog(null, "There isn't anybody selected", "Error!", 2);
            } else {
                
                dni = (String) pager_adm.TABLA.getModel().getValueAt(selection1, 0);
                Class_admin adm = new Class_admin(dni);
                Singleton_adm.adm=adm;
                pos = bll_admin.search_admin((Class_admin) adm);
                
                int opc = JOptionPane.showConfirmDialog(null, "Do you want this person with DNI: " + dni +" "+"?",
                        "Info", JOptionPane.WARNING_MESSAGE);

                if (opc == 0) {
                    bll_admin_db.delete_admin_bll();
                    ((miniSimpleTableModel_admin) pager_adm.TABLA.getModel()).removeRow(selection1);
                    pagina_admin.initLinkBox();
                    adm = Singleton.Admin_array.get(pos);
                    Singleton.Admin_array.remove(adm);                    
                    miniSimpleTableModel_admin.datosaux.remove(adm);
                    ((miniSimpleTableModel_admin) pager_adm.TABLA.getModel()).cargar();
                    pager_adm.jLabel3.setText(String.valueOf(Singleton.Admin_array.size()));
                    pagina_admin.initLinkBox();
                }
                if (pager_adm.TABLA.getRowCount() == 0) {
                    pagina_admin.currentPageIndex-=1;
                    pagina_admin.initLinkBox();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empty list", "Error!", 2);
        }
    }      
         
        public static void giveavatar(){
            dao_admin.giveavatar(dao_admin.dialogoSelectorImagen());
        }
        
        public static void giveavatar_update(){
            dao_admin.giveavatar_update(dao_admin.dialogoSelectorImagen_update());
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
                Validatedatebirthday(admin_jframe_create.eti_date_birthday_create.getCalendar());
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
            case "date_employ":
                Validatedateemploy(admin_jframe_create.eti_date_birthday_create.getCalendar(), admin_jframe_create.eti_date_employ_create.getCalendar());
                break;
            case "salary":
                 givesalary();
                break;
            case "activity":
                 giveactivity();
                break;
            case "incentive":
                 giveincentive();
                break;
        }
    }
        
         public static void givedni() {
                
        if (dao_admin.givedni()==false) {
            admin_jframe_create.eti_dni_create.setBackground(Color.red);
            admin_jframe_create.lab_dni.setIcon(cancel);
                        
        } else {
            
                admin_jframe_create.eti_dni_create.setBackground(Color.CYAN);
                admin_jframe_create.lab_dni.setIcon(okey);
              }
        }
        
        
        public static void givename() {        
        
        if (dao_admin.givename()==false) {
            admin_jframe_create.eti_name_create.setBackground(Color.red);
            admin_jframe_create.lab_name.setIcon(cancel);         
        
            } else {
                admin_jframe_create.eti_name_create.setBackground(Color.CYAN);
                admin_jframe_create.lab_name.setIcon(okey);
              }
        }
     
        
        public static void givesurname() {
               
        if (dao_admin.givesurname()==false) {
            admin_jframe_create.eti_surname_create.setBackground(Color.red);
            admin_jframe_create.lab_surname.setIcon(cancel);
                     
            } else {
                admin_jframe_create.eti_surname_create.setBackground(Color.CYAN);
                admin_jframe_create.lab_surname.setIcon(okey);
               
            }
        }
     
        
        public static void givemobile() {
       
        if (dao_admin.givemobile()==false){
            admin_jframe_create.eti_mobile_create.setBackground(Color.red);
            admin_jframe_create.lab_mobile.setIcon(cancel);
            
            } else {
                admin_jframe_create.eti_mobile_create.setBackground(Color.CYAN);
                admin_jframe_create.lab_mobile.setIcon(okey);
               
            }
        }
         
         public static void givemail() {
        
       
        if (dao_admin.givemail()==false) {
            admin_jframe_create.eti_email_create.setBackground(Color.red);
            admin_jframe_create.lab_email.setIcon(cancel);
                                    
            } else {
                admin_jframe_create.eti_email_create.setBackground(Color.CYAN);
                admin_jframe_create.lab_email.setIcon(okey);
                
            }
        }
    
        
        public static void giveuser() {
               
        if (dao_admin.giveuser()==false) {
            admin_jframe_create.eti_user_create.setBackground(Color.red);
            admin_jframe_create.lab_user.setIcon(cancel);       
           } else {
                admin_jframe_create.eti_user_create.setBackground(Color.CYAN);
                admin_jframe_create.lab_user.setIcon(okey);
                
            }
        }
        
                   
        public static void givepassword() {        
        
        if (dao_admin.givepassword()==false) {
            admin_jframe_create.eti_pass_create.setBackground(Color.red);
            admin_jframe_create.lab_pass.setIcon(cancel);    
            } else {
                admin_jframe_create.eti_pass_create.setBackground(Color.CYAN);
                admin_jframe_create.lab_pass.setIcon(okey);
                
            }
        }
      
        
         public static void giveactivity() {
           
           if (dao_admin.giveactivity()==false) {
            admin_jframe_create.eti_activity_create.setBackground(Color.red);
            admin_jframe_create.lab_activity.setIcon(cancel);    
            } else {
                admin_jframe_create.eti_activity_create.setBackground(Color.CYAN);
                admin_jframe_create.lab_activity.setIcon(okey);
                
            }
        }
       
       public static void givesalary() {
           
        if (dao_admin.givesalary()==false) {
            admin_jframe_create.eti_salary_create.setBackground(Color.red);
            admin_jframe_create.lab_salary.setIcon(cancel);    
            } else {
                admin_jframe_create.eti_salary_create.setBackground(Color.CYAN);
                admin_jframe_create.lab_salary.setIcon(okey);
                
            }
        }
       
       public static void giveincentive() {
        if (dao_admin.giveincentive()==false) {
            admin_jframe_create.eti_incentive_create.setBackground(Color.red);
            admin_jframe_create.lab_incentive.setIcon(cancel);    
            } else {
                admin_jframe_create.eti_incentive_create.setBackground(Color.CYAN);
                admin_jframe_create.lab_incentive.setIcon(okey);
                
            }
        }
       
        public static void Validatedatebirthday(Calendar birthdate) {
            if (dao_admin.give_date_birthday(birthdate)==false) {
            admin_jframe_create.eti_date_birthday_create.setBackground(Color.red);
            admin_jframe_create.lab_date_birthday.setIcon(cancel);    
            } else {
                admin_jframe_create.eti_date_birthday_create.setBackground(Color.CYAN);
                admin_jframe_create.lab_date_birthday.setIcon(okey);
                
            }
        }
        
         public static void Validatedateemploy(Calendar birthdate, Calendar dateemploy) {
            if (dao_admin.give_date_employ(birthdate,dateemploy)==false) {
            admin_jframe_create.eti_date_employ_create.setBackground(Color.red);
            admin_jframe_create.lab_date_employ.setIcon(cancel);    
            } else {
                admin_jframe_create.eti_date_employ_create.setBackground(Color.CYAN);
                admin_jframe_create.lab_date_employ.setIcon(okey);
                
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
                Validatedatebirthday_update(admin_jframe_update.eti_date_birthday_update.getCalendar());
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
            case "date_employ":
                Validatedateemploy_update(admin_jframe_update.eti_date_birthday_update.getCalendar(), admin_jframe_update.eti_date_employ_update.getCalendar());
                break;
            case "salary":
                 givesalary_update();
                break;
            case "activity":
                 giveactivity_update();
                break;
            case "incentive":
                 giveincentive_update();
                break;
        }
    }
        
         public static void givedni_update() {
                
        if (dao_admin.givedni_update()==false) {
            admin_jframe_update.eti_dni_update.setBackground(Color.red);
            admin_jframe_update.lab_dni.setIcon(cancel);
                        
        } else {
            
                admin_jframe_update.eti_dni_update.setBackground(Color.CYAN);
                admin_jframe_update.lab_dni.setIcon(okey);
              }
        }
        
        
        public static void givename_update() {        
        
        if (dao_admin.givename_update()==false) {
            admin_jframe_update.eti_name_update.setBackground(Color.red);
            admin_jframe_update.lab_name.setIcon(cancel);         
        
            } else {
                admin_jframe_update.eti_name_update.setBackground(Color.CYAN);
                admin_jframe_update.lab_name.setIcon(okey);
              }
        }
     
        
        public static void givesurname_update() {
               
        if (dao_admin.givesurname_update()==false) {
            admin_jframe_update.eti_surname_update.setBackground(Color.red);
            admin_jframe_update.lab_surname.setIcon(cancel);
                     
            } else {
                admin_jframe_update.eti_surname_update.setBackground(Color.CYAN);
                admin_jframe_update.lab_surname.setIcon(okey);
               
            }
        }
     
        
        public static void givemobile_update() {
       
        if (dao_admin.givemobile_update()==false){
            admin_jframe_update.eti_mobile_update.setBackground(Color.red);
            admin_jframe_update.lab_mobile.setIcon(cancel);
            
            } else {
                admin_jframe_update.eti_mobile_update.setBackground(Color.CYAN);
                admin_jframe_update.lab_mobile.setIcon(okey);
               
            }
        }
         
         public static void givemail_update() {
        
       
        if (dao_admin.givemail_update()==false) {
            admin_jframe_update.eti_email_update.setBackground(Color.red);
            admin_jframe_update.lab_email.setIcon(cancel);
                                    
            } else {
                admin_jframe_update.eti_email_update.setBackground(Color.CYAN);
                admin_jframe_update.lab_email.setIcon(okey);
                
            }
        }
    
        
        public static void giveuser_update() {
               
        if (dao_admin.giveuser_update()==false) {
            admin_jframe_update.eti_user_update.setBackground(Color.red);
            admin_jframe_update.lab_user.setIcon(cancel);       
           } else {
                admin_jframe_update.eti_user_update.setBackground(Color.CYAN);
                admin_jframe_update.lab_user.setIcon(okey);
                
            }
        }
        
                   
        public static void givepassword_update() {
        
        
        if (dao_admin.givepassword_update()==false) {
            admin_jframe_update.eti_pass_update.setBackground(Color.red);
            admin_jframe_update.lab_pass.setIcon(cancel);    
            } else {
                admin_jframe_update.eti_pass_update.setBackground(Color.CYAN);
                admin_jframe_update.lab_pass.setIcon(okey);
                
            }
        }
      
        
         public static void giveactivity_update() {
           
           if (dao_admin.giveactivity_update()==false) {
            admin_jframe_update.eti_activity_update.setBackground(Color.red);
            admin_jframe_update.lab_activity.setIcon(cancel);    
            } else {
                admin_jframe_update.eti_activity_update.setBackground(Color.CYAN);
                admin_jframe_update.lab_activity.setIcon(okey);
                
            }
        }
       
       public static void givesalary_update() {
           
        if (dao_admin.givesalary_update()==false) {
            admin_jframe_update.eti_salary_update.setBackground(Color.red);
            admin_jframe_update.lab_salary.setIcon(cancel);    
            } else {
                admin_jframe_update.eti_salary_update.setBackground(Color.CYAN);
                admin_jframe_update.lab_salary.setIcon(okey);
                
            }
        }
       
       public static void giveincentive_update() {
        if (dao_admin.giveincentive_update()==false) {
            admin_jframe_update.eti_incentive_update.setBackground(Color.red);
            admin_jframe_update.lab_incentive.setIcon(cancel);    
            } else {
                admin_jframe_update.eti_incentive_update.setBackground(Color.CYAN);
                admin_jframe_update.lab_incentive.setIcon(okey);
                
            }
        }
       
        public static void Validatedatebirthday_update(Calendar birthdate) {
            if (dao_admin.give_date_birthday_update(birthdate)==false) {
            admin_jframe_update.eti_date_birthday_update.setBackground(Color.red);
            admin_jframe_update.lab_date_birthday.setIcon(cancel);    
            } else {
                admin_jframe_update.eti_date_birthday_update.setBackground(Color.CYAN);
                admin_jframe_update.lab_date_birthday.setIcon(okey);
                
            }
        }
        
         public static void Validatedateemploy_update(Calendar birthdate, Calendar dateemploy) {
            if (dao_admin.give_date_employ_update(birthdate,dateemploy)==false) {
            admin_jframe_update.eti_date_employ_update.setBackground(Color.red);
            admin_jframe_update.lab_date_employ.setIcon(cancel);    
            } else {
                admin_jframe_update.eti_date_employ_update.setBackground(Color.CYAN);
                admin_jframe_update.lab_date_employ.setIcon(okey);
                
            }
         }
}