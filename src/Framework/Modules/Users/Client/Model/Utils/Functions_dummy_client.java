package Framework.Modules.Users.Client.Model.Utils;

import Framework.Class.Class_date;
import Framework.Modules.Users.Client.Model.Clases.Class_client;
import Framework.Modules.Users.User.Model.Clases.Singleton;




public class Functions_dummy_client{
	
	
	/**CLIENT*/
	private static String dni_cli[]={"73099467Q","00000023T","00000001R","00000002W","00000003A"};
	private static String name_cli[]={"Luis","Lucas","Lucia","Pep","Lirios"};
	private static String surname_cli[]={"Perico","Delgado","Garcia","Sanabria","Albelda"};
	private static Class_date date_birthday_cli[]={new Class_date("15/04/1993"),new Class_date("20/05/1987"),new Class_date("12/07/1963"),new Class_date("28/07/1941"),new Class_date("02/12/1973")};
	private static String mobile_cli[]={"623456789","655280807","624567890","625678901","630363231"};
	private static String avatar_cli[]={"Pepito123","Lalllama23","Poasdm23s","Contrase�a123","Contra123"};
	private static boolean state_cli[]={true,true,false,true,true};
	private static String mail_cli[]={"luis1987@hotmail.com","lucas2004@gmail.com","luciabeniel@hotmail.com","pep@gmail.com","litrets23@gmail.com"};
	private static String user_cli[]={"Pepito123","Lalllama23","Poasdm23s","Contrase�a123","Contra123"};
	private static String pass_cli[]={"Casado123","Emparejado123","Soltero123","Casado123","Soltero123"};
	private static float buy_cli[]={28.25568f,286.22558f,88.25568f,78.32452f,81.10005f};
	private static boolean premium_cli[]={true,true,false,true,true};
	private static Class_date date_start_cli[]={new Class_date("30/08/2015"),new Class_date("18/10/2015"),new Class_date("11/07/2015"),new Class_date("22/06/2015"),new Class_date("11/08/2015")};
	private static String client_type_cli[]={"Yellow","Emparejado","Soltero","Casado","Soltero"};
	
	
	public static void cargar_client() { 
		Class_client cli=null;
		for (int i = 0; i<5 ;i++){	
		/**CLIENT*/
		cli=new Class_client (dni_cli[i], name_cli[i], surname_cli[i], date_birthday_cli[i], mobile_cli[i], avatar_cli[i], state_cli[i], mail_cli[i], user_cli[i], pass_cli[i], buy_cli[i], premium_cli[i], date_start_cli[i], client_type_cli[i]);
		Singleton.Client_array.add(cli);
		}
	}
}