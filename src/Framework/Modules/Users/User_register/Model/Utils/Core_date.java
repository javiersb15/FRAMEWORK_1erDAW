package Framework.Modules.Users.User_register.Model.Utils;

import java.util.Calendar;
import javax.swing.JOptionPane;
import Framework.Class.Class_date;
import Framework.Utils.Functions;
import Framework.Utils.Validate;

public class Core_date {

	/**GIVE DATE*/
	public static Class_date givedate(String message, String title) {
		String date_s=" "; 
		boolean validate=false;
		boolean check=false;
		Class_date date=null;
		
		do{
			date_s=Functions.givestring(message, title);
			validate=Validate.validate_date(date_s);
			if (validate==false){
				JOptionPane.showMessageDialog(null, "You must enter the date correctly", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}else{
				date=new Class_date(date_s);
			check=date.tocheckdate();
			if (check==false){
				JOptionPane.showMessageDialog(null, "You must enter the date correctly", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}
			}
		}while((validate==false) || (check==false));
		
		return date;
	}
	
	/**GIVE DATE OF BIRTHDAY*/
	public static Class_date givedatebirthday(String message, String title){
		Class_date date=null;
		int select=0;
		
		do{
		date=givedate(message, title);
		select=date.substractdatesystem();
		if (select<18){
			JOptionPane.showMessageDialog(null, "You must be over 18 years", "Error",JOptionPane.INFORMATION_MESSAGE);
		}
		else if (select>65) {
			JOptionPane.showMessageDialog(null, "You must be under 65 years", "Error",JOptionPane.INFORMATION_MESSAGE);
		}
		}while ((select<18) || (select>65));
		
		return date;
	}
	
	/**GIVE DATE EMPLOY*/
	public static Class_date givedateemploy(String message, String title, Class_date date_birthday){
		Class_date date=null;
		int compare=0, datenow2=0;
		Calendar cal=Calendar.getInstance();
		Class_date datenow=new Class_date (cal.get(Calendar.DATE)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR));
		
		do{
		date=givedate(message, title);
		compare=date.comparedate(date_birthday);
		datenow2=date.comparedate(datenow);
		
		if (date.substractdate(date_birthday) < 18)
		JOptionPane.showMessageDialog(null, "You must be over 18 years","Error",JOptionPane.INFORMATION_MESSAGE);
		
		}while (date.substractdate(date_birthday) < 18);

		return date;
	}
}