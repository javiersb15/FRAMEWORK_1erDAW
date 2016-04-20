package Framework.Modules.Users.User_register.Model.Dao;

import Framework.Modules.Config.Model.Class_config;
import Framework.Class.Class_date;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import Framework.Modules.Users.User_register.Model.Bll.bll_users;
import Framework.Modules.Users.User_register.Model.Clases.Class_user_register;
import Framework.Modules.Users.User_register.Model.Utils.Core_date;
import Framework.Modules.Users.User_register.Model.Utils.Core_users;
import Framework.Utils.Functions;
import Framework.Utils.Menus;



public class dao_user {

	/**CREATE USER REGISTER*/
	public static Class_user_register createuser_register() {
						
			/**DADES USER*/
			String dni=" ", name=" ", surname=" ", mobile=" ", avatar=" ", email=" ",user=" ", pass=" ";
			boolean state=false;
			Class_date date_birthday=null;
			/**DADES USER_REGISTER*/
			int activity=0; 
			/**MENU BOOLEAN*/
			String[] statemenu={"Conect", "Disconect"};
			
			/**GIVE ME USER*/
			dni=Singleton.DNI;
			name=Core_users.insertname("Enter your name", "Name");
			surname=Core_users.insertname("Enter your surname", "Surname");
			date_birthday=Core_date.givedatebirthday("Enter your date_birthday"+" "+Class_config.getInstance().getFormat_date(), "Birthday");
			mobile=Core_users.insertmobile("Enter your mobile", "Mobile");
			avatar=Functions.givestring("Enter your avatar", "Avatar");
			state=Functions.giveboolean(statemenu,"Enter your state", "State");
			email=Core_users.insertemail("Enter your email", "Email");
			user=Functions.givestring("Enter your user", "User");
			pass=Core_users.insertpassword("Enter your pass", "Pass");
			
			/**GIVE ME USER REGISTER*/
			activity=Functions.givenumber("Enter your activity user register", "Activity"); 
			
				return new Class_user_register (dni, name, surname, date_birthday, mobile,
						avatar, state, email, user, pass, activity);
			}
	
	/**MODIFY USER_REGISTER*/
	public static void modifyuser_register(Class_user_register u_1) {
		String [] options_user_register={"dni", "name", "surname", "date_birthday", "mobile", "age", "state", "avatar", 
				"email", "user", "pass", "activity"};
		String selection=" ";
		String[] statemenu={"Conect", "Disconect"};
		
			selection=Menus.menucombobox(options_user_register,"What do you want", "Choosing");
		
		switch (selection){
			case "dni":
				bll_users.modify_usr_reg_DNI(u_1);
				break;	
			case "name":
				u_1.setname(Core_users.insertname("Enter your name", "Name"));
				break;
			case "surname":
				u_1.setsurname(Core_users.insertname("Enter your surname", "Surname"));
				break;
			case "date_birthday":
				u_1.setdate_birthday(Core_date.givedate("Enter your date_birthday "+" "+Class_config.getInstance().getFormat_date(), "Birthday"));
				break;
			case "mobile":
				u_1.setmobile(Core_users.insertmobile("Enter your mobile", "Mobile"));
				break;
			case "state":
				u_1.setstate(Functions.giveboolean(statemenu,"Enter your state", "State"));
				break;
			case "avatar":
				u_1.setavatar(Functions.givestring("Enter your avatar", "Avatar"));
				break;
			case "email":
				u_1.setemail(Core_users.insertemail("Enter your email", "Email"));
				break;
			case "user":
				u_1.setuser(Functions.givestring("Enter your user", "User"));
				break;
			case "pass":
				u_1.setpass(Core_users.insertpassword("Enter your pass", "Pass"));
				break;
			case "activity":
				u_1.setactivity(Functions.givenumber("Enter your activity", "Activity"));
				break;
		}
	}
}