package Framework.Modules.Users.User_register.Model.Bll;

import java.util.Collections;
import javax.swing.JOptionPane;
import Framework.Modules.Users.User_register.Model.Clases.Class_user_register;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import Framework.Modules.Users.User_register.Model.Dao.dao_user;
import Framework.Modules.Users.User_register.Model.Utils.Core_users;
import Framework.Utils.Menus;

public class bll_users {
		
	/**USER REGISTER*/
	
	/**GIVE DNI USER REGISTER*/
	public static Class_user_register give_dni_usr_reg() {
		
		Singleton.DNI=Core_users.insertdni("Enter your DNI", "DNI");
		Class_user_register usr_reg=new Class_user_register(Singleton.DNI);
	return usr_reg;
	}
	
	/**SEARCH USER REGISTER*/
	public static int search_usr_reg(Class_user_register usr_reg){ 
		for (int i = 0; i<=(Singleton.User_register_array.size()-1); i++){
			if((Singleton.User_register_array.get(i)).equals(usr_reg) )
				return i;
		}
		return -1;
	}
	
	/**MODIFY DNI USER RESGISTER*/
	public static void modify_usr_reg_DNI (Class_user_register usr_reg2){
		int position=-1;
		
		Class_user_register usr_reg=null;
		usr_reg=bll_users.give_dni_usr_reg();
		position=bll_users.search_usr_reg(usr_reg);
		if (position!= -1) {
			JOptionPane.showMessageDialog(null, "This User Register is already exist", "Error User Register", JOptionPane.ERROR_MESSAGE);
		}else {
			usr_reg2.setDNI(Singleton.DNI);
			JOptionPane.showMessageDialog(null, "This user register has been successfully update");
		}
	}
	
	/**CREATE USER RESGISTER*/
	public static void create_user_register (Class_user_register usr_reg){
		int position=-1;
		
		usr_reg=bll_users.give_dni_usr_reg();
		position=bll_users.search_usr_reg(usr_reg);
		if (position !=-1){
			JOptionPane.showMessageDialog(null, "This User Register is already exist", "Error User Register", JOptionPane.ERROR_MESSAGE);
		}else{ usr_reg=dao_user.createuser_register();
		Singleton.User_register_array.add(usr_reg);
		}
	}
	
	/**PRINT USER REGISTER*/
	public static void print_user_register (Class_user_register usr_reg){
		int menu=0, position=-1;
		String[] submenu={"Read all data", "Read only the DNI"};
		
		if(Singleton.User_register_array.isEmpty()){
			JOptionPane.showMessageDialog(null, "There aren't any User Register", "User Register", JOptionPane.ERROR_MESSAGE);
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
					usr_reg=bll_users.give_dni_usr_reg();
					position=bll_users.search_usr_reg(usr_reg);
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
	public static void update_user_register (Class_user_register usr_reg) {
		int position=-1;
		
		if(Singleton.User_register_array.isEmpty()){
			JOptionPane.showMessageDialog(null, "There aren't any User Register", "User Register", JOptionPane.ERROR_MESSAGE);
		}else{
			position=-1;
			usr_reg=bll_users.give_dni_usr_reg();
			position=bll_users.search_usr_reg(usr_reg);
			if (position!=-1) {
				usr_reg=Singleton.User_register_array.get(position);
				dao_user.modifyuser_register(usr_reg);
				Singleton.User_register_array.set(position, usr_reg);
			}else {
				JOptionPane.showMessageDialog(null, "This DNI dosent't exist", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**DELETE USER RESGISTER*/
	public static void delete_user_register (Class_user_register usr_reg) {
		int position=-1;
		
		if(Singleton.User_register_array.isEmpty()){
			JOptionPane.showMessageDialog(null, "There aren't any User Register", "User Register", JOptionPane.ERROR_MESSAGE);
		}else{
			position=-1;
			usr_reg=bll_users.give_dni_usr_reg();
			position=bll_users.search_usr_reg(usr_reg);
			if (position!=-1){
				Singleton.User_register_array.remove(position);
				JOptionPane.showMessageDialog(null, "This user register has been successfully removed");
			}else{
				JOptionPane.showMessageDialog(null, "This DNI dosent't exist", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}