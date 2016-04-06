package Framework.Modules.Users.Client.Model.Bll;

import Framework.Modules.Users.Client.Model.Utils.Extensions.Json;
import Framework.Modules.Users.Client.Model.Utils.Extensions.Txt;
import Framework.Modules.Users.Client.Model.Utils.Extensions.Xml;





public class Functions_auto_open {

	public static void auto_open() {
		
		Json.auto_open_json_client();
		Txt.auto_open_txt_client();
		Xml.auto_open_xml_client();
}
}
