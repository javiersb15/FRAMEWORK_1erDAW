package Framework.Modules.Users.User_register.Model.Utils;

import Framework.Class.Class_date;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import Framework.Modules.Users.User_register.Model.Clases.Class_user_register;


public class Functions_dummy_usr_reg{
	
	/**USER REGISTER*/
	private static String dni_usr_reg[]={"73099467Q","00000023T","00000001R","00000002W","00000003A","00000003B"};
	private static String name_usr_reg[]={"Luis","Lucas","Lucia","Pep","Lirios","Anthony"};
	private static String surname_usr_reg[]={"Perico","Delgado","Garcia","Sanabria","Albelda","Bustamante"};
	private static Class_date date_birthday_usr_reg[]={new Class_date("15/04/1993"),new Class_date("20/05/1987"),new Class_date("12/07/1963"),new Class_date("28/07/1941"),new Class_date("02/12/1973"),new Class_date("04/01/1955")};
	private static String mobile_usr_reg[]={"623456789","655280807","624567890","625678901","630363231","654987123"};
	private static String avatar_usr_reg[]={"Pepito123","Lalllama23","Poasdm23s","Contrase�a123","Contra123","/root"};
	private static boolean state_usr_reg[]={true,true,false,true,true,false};
	private static String mail_usr_reg[]={"luis1987@hotmail.com","lucas2004@gmail.com","luciabeniel@hotmail.com","pep@gmail.com","litrets23@gmail.com","anthony@gmail.com"};
	private static String user_usr_reg[]={"Pepito123","Lalllama23","Poasdm23s","Contrase�a123","Contra123","busta123"};
	private static String pass_usr_reg[]={"Casado123","Emparejado123","Soltero123","Casado123","Soltero123","1234@qweRTY"};
	private static int activity_usr_reg[]={12,200,400,5000,2212,2241};
	
		
	public static void cargar_user_register() { 
		Class_user_register usr_reg=null;
		for (int i = 0; i<6 ;i++){	
		/**USER REGISTER*/
		usr_reg=new Class_user_register (dni_usr_reg[i], name_usr_reg[i], surname_usr_reg[i], date_birthday_usr_reg[i], mobile_usr_reg[i], avatar_usr_reg[i], state_usr_reg[i], mail_usr_reg[i], user_usr_reg[i], pass_usr_reg[i], activity_usr_reg[i]);
		Singleton.User_register_array.add(usr_reg);
		}
	}
}