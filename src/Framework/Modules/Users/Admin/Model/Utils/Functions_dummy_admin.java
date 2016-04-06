package Framework.Modules.Users.Admin.Model.Utils;

import Framework.Class.Class_date;
import Framework.Modules.Users.Admin.Model.Clases.Class_admin;
import Framework.Modules.Users.User.Model.Clases.Singleton;


public class Functions_dummy_admin{
	
	/**ADMIN*/
	private static String DNI[]={"73099467Q","00000023T","00000001R","00000002W","00000003A","12345678Z"};
	private static String name[]={"Luis","Lucas","Lucia","Pep","Lirios","Rafa"};
	private static String surname[]={"Perico","Delgado","Garcia","Sanabria","Albelda","Alonso"};
	private static Class_date date_birthday[]={new Class_date("15/04/1993"),new Class_date("20/05/1987"),new Class_date("12/07/1963"),new Class_date("28/07/1941"),new Class_date("02/12/1973"),new Class_date("04/11/1980")};
	private static String mobile[]={"623456789","655280807","624567890","625678901","630363231","654987123"};
	private static String avatar[]={"IMG_20141026_150909.jpg","IMG_20141026_150909.jpg","IMG_20141026_150909.jpg","IMG_20141026_150909.jpg","IMG_20141026_150909.jpg","IMG_20141026_150909.jpg"};
	private static boolean state[]={true,true,false,true,true,false};
	private static String mail[]={"luis1987@hotmail.com","lucas2004@gmail.com","luciabeniel@hotmail.com","pep@gmail.com","litrets23@gmail.com","jaimito123@gmail.com"};
	private static String user[]={"Pepito123","Lalllama23","Poasdm23s","Contrase�a123","Contra123","contra12345"};
	private static String pass[]={"Casado123","Emparejado123","Soltero123","Casado123","Soltero123","hola@123"};
	private static Class_date date_employ[]={new Class_date("30/08/2015"),new Class_date("18/10/2015"),new Class_date("11/07/2015"),new Class_date("22/06/2015"),new Class_date("11/08/2015"),new Class_date("5/10/2015")};
	private static float salary[]={28.25568f,286.22558f,88.25568f,78.32452f,81.10005f,40.00214f};
	private static int activity[]={12,200,400,5000,2212,2000};
	private static int incentive[]={12,200,400,5000,2212,1540};
	
	public static void cargar_admin() { 
	Class_admin adm=null;	
		for (int i = 0; i<6 ;i++){	
		/**ADMIN*/
		adm=new Class_admin(DNI[i], name[i], surname[i], date_birthday[i], mobile[i], avatar[i], state[i], mail[i], user[i], pass[i], date_employ[i], salary[i], activity[i], incentive[i]);
		Singleton.Admin_array.add(adm);
		}
	}
}