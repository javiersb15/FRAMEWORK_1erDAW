package Framework.Modules.Users.Client.Model.Utils;

import javax.swing.JOptionPane;

import Framework.Utils.Functions;
import Framework.Utils.Menus;
import Framework.Utils.Validate;

public class Core_users {

	/**INSERT NAME*/
	public static String insertname(String message, String title){
		String insertname=" ";
		boolean validate=false;
		
		do{
			insertname=Functions.givestring(message, title);
			validate=Validate.validate_name(insertname);
			if(validate==false)
				JOptionPane.showMessageDialog(null, "You must enter only letters","Error"
						,JOptionPane.INFORMATION_MESSAGE);
		}while (validate==false);
	return insertname;
	}
	
	/**INSERT MOBILE*/
	public static String insertmobile(String message, String title){
		String insertmobile=" ", number="+34";
		boolean validate=false;
		
		do{
			insertmobile=Functions.givestring(message, title);
			validate=Validate.validate_mobile(insertmobile);
			if(validate==false)
				JOptionPane.showMessageDialog(null, "You must enter only numbers","Error"
						,JOptionPane.INFORMATION_MESSAGE);
			else{
				number="+34"+(insertmobile);
			}
		}while (validate==false);
	return number;
	}
	
	/**INSERT DNI*/
	public static String insertdni(String message, String title){
		int num=0, rest=0;
		char letter=' ', control=' ';
		String insertdni=" ", aux=" ", characters="TRWAGMYFPDXBNJZSQVHLCKET";
		boolean validate=false;
		
		do{
			insertdni=Functions.givestring(message, title);
			validate=Validate.validate_dni(insertdni);
			if (validate==false)
				JOptionPane.showMessageDialog(null, "You must enter a Dni correctly", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			else {
			aux="";
			for(int i=0; i<8; i++){
				aux+=insertdni.charAt(i);
			}	
			letter=insertdni.charAt(8);			
			num=Integer.parseInt(aux);
			rest=num% 23;
			control=characters.charAt(rest);
			
			if(control==letter){
				validate=true;
			}else{
				JOptionPane.showMessageDialog(null, "You must enter a Dni correctly", "Error",
						JOptionPane.INFORMATION_MESSAGE);
				validate=false;
			}
			}
		}while (validate==false);
		
		return insertdni;
	}
	
	/**INSERT MAIL*/
	public static String insertemail(String message, String title) {
		String mail=" ";
		boolean validate=false;
		
		do {
			mail=Functions.givestring(message, title);
			validate=Validate.validate_mail(mail);
			if (validate==false)
				JOptionPane.showMessageDialog(null, "You must enter the mail correctly", "Error",
						JOptionPane.INFORMATION_MESSAGE);
		} while (validate==false);
		
		return mail;
	}
	
	/**INSERT PASSWORD*/
	public static String insertpassword(String message, String title) {
		String password=" ";
		boolean validate=false;
		
		do {
			password=Functions.givestring(message, title);
			validate=Validate.validate_password(password);
			if (validate==false)
				JOptionPane.showMessageDialog(null, "You must enter the password correctly", "Error",
						JOptionPane.INFORMATION_MESSAGE);
		} while (validate==false);
		
		return password;
	}
	
	/**INSERT TYPE OF CLIENT*/
	public static String insertclienttype(String message, String title) {
		String client=" ";
		int election=0;
		/**MENU TYPE OF CLIENT*/
		String[] clientoftype={"Yellow","Red","Blue"};
		
		do {
			election=Menus.menubutton(clientoftype, message, title);
			switch(election){
			case 0:
				client=clientoftype[election];
			break;
			case 1:
				client=clientoftype[election];
			break;
			case 2:
				client=clientoftype[election];
			break;
			}
		} while (election==-1);
		
		return client;
	}
}