package Framework.Modules.Users.Client.Model.Dao;

import Framework.Modules.Config.Model.Class_config;
import Framework.Class.Class_date;
import Framework.Modules.Users.Client.Model.Bll.bll_users;
import Framework.Modules.Users.Client.Model.Clases.Class_client;
import Framework.Modules.Users.Client.Model.Utils.Core_date;
import Framework.Modules.Users.Client.Model.Utils.Core_users;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import Framework.Utils.Functions;
import Framework.Utils.Menus;

public class dao_user {
				
	/**CREATE CLIENT*/
	public static Class_client createclient() {
			
			/**DADES USER*/
			String dni=" ", name=" ", surname=" ", mobile=" ",avatar=" ", email=" ",user=" ", pass=" ";
			boolean state=false;
			Class_date date_birthday=null;
			/**DADES CLIENT*/
			float buy=0.0f;  
			boolean premium=false; 
			String client_type=" "; 
			Class_date date_start=null; 
			/**MENU BOOLEAN*/
			String[] statemenu={"Conect", "Disconect"};
			String[] premium_menu={"Yes", "No"};
			
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
			
			/**GIVE ME CLIENT*/
			buy=Functions.givefloat("Enter your buy", "Buy");
			premium=Functions.giveboolean(premium_menu,"Enter your premium", "Premium");
			date_start=Core_date.givedateemploy("Enter your date_start"+" "+Class_config.getInstance().getFormat_date(), "Date Start", date_birthday);
			client_type=Core_users.insertclienttype("Choose your type of client", "Client Type");
			
		return new Class_client(dni, name, surname, date_birthday, mobile,
				avatar, state, email, user, pass, buy, premium, date_start, client_type);
			}
	
	/**MODIFY CLIENT*/
	public static void modifyclient(Class_client c_1) {
		
		String [] options_client={"dni", "name", "surname", "date_birthday", "mobile", "state", "avatar", "email",
				"user", "pass", "buy", "premium", "date_start", "client_type"};
		String selection=" ";
		String[] statemenu={"Conect", "Disconect"};
		String[] premium_menu={"Yes", "No"};
		Class_date date_birthday=null;
		
			selection=Menus.menucombobox(options_client,"What do you want", "Choosing");
		
		switch (selection){
			case "dni":
				bll_users.modify_clientDNI(c_1);
				break;	
			case "name":
				c_1.setname(Core_users.insertname("Enter your name", "Name"));
				break;
			case "surname":
				c_1.setsurname(Core_users.insertname("Enter your surname", "Surname"));
				break;
			case "date_birthday":
				c_1.setdate_birthday(Core_date.givedate("Enter your date_birthday"+" "+Class_config.getInstance().getFormat_date(), "Birthday"));
				break;
			case "mobile":
				c_1.setmobile(Core_users.insertmobile("Enter your mobile", "Mobile"));
				break;
			case "state":
				c_1.setstate(Functions.giveboolean(statemenu,"Enter your state", "State"));
				break;
			case "avatar":
				c_1.setavatar(Functions.givestring("Enter your avatar", "Avatar"));
				break;
			case "email":
				c_1.setemail(Core_users.insertemail("Enter your email", "Email"));
				break;
			case "user":
				c_1.setuser(Functions.givestring("Enter your user", "User"));
				break;
			case "pass":
				c_1.setpass(Core_users.insertpassword("Enter your pass", "Pass"));
				break;
			case "buy":
				c_1.setbuy(Functions.givefloat("Enter your buy", "Buy"));
				break;
			case "premium":
				c_1.setpremium(Functions.giveboolean(premium_menu,"Enter your premium", "Premium"));
				break;
			case "date_start":
				c_1.setdate_start(Core_date.givedateemploy("Enter your date_start"+" "+Class_config.getInstance().getFormat_date(), "Date Start", date_birthday));
				break;
			case "client_type":
				c_1.setclient_type(Functions.givestring("Enter your client type", "Client Type"));
				break;
		}
	}
}