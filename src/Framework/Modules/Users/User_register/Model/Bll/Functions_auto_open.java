package Framework.Modules.Users.User_register.Model.Bll;

import Framework.Modules.Users.User_register.Model.Utils.Extensions.Json;
import Framework.Modules.Users.User_register.Model.Utils.Extensions.Txt;
import Framework.Modules.Users.User_register.Model.Utils.Extensions.Xml;



public class Functions_auto_open {

	public static void auto_open() {
		
		Json.auto_open_json_usr_reg();
		Txt.auto_open_txt_usr_reg();
		Xml.auto_open_xml_usr_reg();
}
}