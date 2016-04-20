package Framework.Modules.Users.Client.Model.Bll;

import Framework.Modules.Users.Client.Model.Clases.Class_client;
import Framework.Modules.Users.Client.Model.Dao.dao_user;
import Framework.Modules.Users.Client.Model.Utils.Core_users;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import Framework.Utils.Menus;
import java.util.Collections;
import javax.swing.JOptionPane;



public class bll_users {
		
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
		
		Singleton.DNI=Core_users.insertdni("Enter your DNI", "DNI");
		Class_client cli=new Class_client(Singleton.DNI);
	return cli;
	}
	
	/**PRINT CLIENT*/
	public static void print_client (Class_client cli){
		int menu=0, position=-1;
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
					cli=bll_users.give_dni_client();
					position=bll_users.search_client(cli);
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
	
	/**UPDATE ADMIN*/
	public static void update_client (Class_client cli) {
		int position=-1;
		
		if(Singleton.Client_array.isEmpty()){
			JOptionPane.showMessageDialog(null, "There aren't any Client", "Client", JOptionPane.ERROR_MESSAGE);
		}else{
			position=-1;
			cli=bll_users.give_dni_client();
			position=bll_users.search_client(cli);
			if (position!=-1) {
				cli=Singleton.Client_array.get(position);
				dao_user.modifyclient(cli);
				Singleton.Client_array.set(position, cli);
			}else {
				JOptionPane.showMessageDialog(null, "This DNI dosent't exist", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**MODIFY DNI CLIENT*/
	public static void modify_clientDNI (Class_client cli2){
		int position=-1;
		
		Class_client cli=null;
		cli=bll_users.give_dni_client();
		position=bll_users.search_client(cli);
		if (position!= -1) {
			JOptionPane.showMessageDialog(null, "This Client is already exist", "Error Client", JOptionPane.ERROR_MESSAGE);
		}else {
			cli2.setDNI(Singleton.DNI);
			JOptionPane.showMessageDialog(null, "This client has been successfully update");
		}
	}
	
	/**CREATE CLIENT*/
	public static void create_client (Class_client cli){
		int position=-1;
		
		cli=bll_users.give_dni_client();
		position=bll_users.search_client(cli);
		if (position !=-1){
			JOptionPane.showMessageDialog(null, "This Client is already exist", "Error Client", JOptionPane.ERROR_MESSAGE);
		}else{ cli=dao_user.createclient();
		Singleton.Client_array.add(cli);
		}
	}
	
	/**DELETE CLIENT*/
	public static void delete_client (Class_client cli) {
		int position=-1;
		
		if(Singleton.Client_array.isEmpty()){
			JOptionPane.showMessageDialog(null, "There aren't any Client", "Client", JOptionPane.ERROR_MESSAGE);
		}else{
			position=-1;
			cli=bll_users.give_dni_client();
			position=bll_users.search_client(cli);
			if (position!=-1){
				Singleton.Client_array.remove(position);
				JOptionPane.showMessageDialog(null, "This client has been successfully removed");
			}else{
				JOptionPane.showMessageDialog(null, "This DNI dosent't exist", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}