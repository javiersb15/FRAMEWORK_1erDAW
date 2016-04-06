package Framework.Modules.Users.User.Model.Clases;

import Framework.Modules.Users.Admin.Model.Clases.Class_admin;
import Framework.Modules.Users.Client.Model.Clases.Class_client;
import Framework.Modules.Users.User_register.Model.Clases.Class_user_register;
import java.util.ArrayList;

public class Singleton {

	public static ArrayList <Class_admin> Admin_array;
	public static ArrayList <Class_client> Client_array;
	public static ArrayList <Class_user_register> User_register_array;
	public static String DNI;

	}