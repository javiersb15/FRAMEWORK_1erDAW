package Framework.Modules.Config.Model;

import Framework.Modules.Users.Admin.Model.Bll.Functions_auto_open;
import Framework.Modules.Users.Admin.Model.Clases.Class_admin;
import Framework.Modules.Users.Admin.Model.Utils.Extensions.Json;
import Framework.Modules.Users.Admin.Model.Utils.Functions_dummy_admin;
import Framework.Modules.Users.Client.Model.Clases.Class_client;
import Framework.Modules.Users.Client.Model.Utils.Functions_dummy_client;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import Framework.Modules.Users.User_register.Model.Clases.Class_user_register;
import Framework.Modules.Users.User_register.Model.Utils.Functions_dummy_usr_reg;
import Framework.Utils.Theme;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.ArrayList;





@XStreamAlias("Class_config")
public class Class_config implements Serializable{

	
	@XStreamAlias("format_date")
	private String format_date;
	@XStreamAlias("currency")
	private char currency;
	@XStreamAlias("format_file")
	private String format_file;
	@XStreamAlias("language")
	private String language;
	@XStreamAlias("theme")
	private String theme;
	@XStreamAlias("decimal_number")
	private int decimal_number;
	@XStreamAlias("instance")
	private static Class_config instance;
		
	public Class_config(){
		this.format_date="dd/MM/yyyy";
		this.currency='€';
		this.format_file="1";
		this.language="Valencian";
		this.theme="Nimbus";
		this.decimal_number=2;	
	}
	
	public static Class_config getInstance(){
		if (instance==null){
			instance=new Class_config();
			
		Theme.select_theme("Nimbus");
		Class_language.getInstance();
		
		Singleton.Admin_array=new ArrayList <Class_admin>();
		Singleton.Client_array=new ArrayList <Class_client>();
		Singleton.User_register_array=new ArrayList <Class_user_register>();
		
		//Functions_auto_open.auto_open();
		Functions_dummy_admin.cargar_admin();
                Functions_dummy_client.cargar_client();
		Functions_dummy_usr_reg.cargar_user_register();
		Theme.select_theme("Nimbus");
                Json.auto_create_json_admin();
		}
		return instance;
	}

	public String getFormat_date() {
		return format_date;
	}

	public void setFormat_date(String format_date) {
		this.format_date = format_date;
	}

	public char getCurrency() {
		return currency;
	}

	public void setCurrency(char currency) {
		this.currency = currency;
	}

	public String getFormat_file() {
		return format_file;
	}

	public void setFormat_file(String format_file) {
		this.format_file = format_file;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getDecimal_number() {
		return decimal_number;
	}

	public void setDecimal_number(int decimal_number) {
		this.decimal_number = decimal_number;
	}

	public static void setInstance(Class_config instance) {
		Class_config.instance = instance;
	}
	
	public String toString() {
		return "Configuration [format_data="+format_date+", Currency="+currency
				+", File format="+format_file+", Languages="+language+", Theme="+theme+", "
						+ "Decimal number="+decimal_number+"]";
	}
}