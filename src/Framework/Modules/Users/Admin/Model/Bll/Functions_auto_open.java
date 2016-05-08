package Framework.Modules.Users.Admin.Model.Bll;

import Framework.Modules.Users.Admin.Model.Utils.Extensions.Json;
import Framework.Modules.Users.Admin.Model.Utils.Extensions.Txt;
import Framework.Modules.Users.Admin.Model.Utils.Extensions.Xml;

public class Functions_auto_open {

	public static void auto_open() {
		/**ADMIN*/
		Json.auto_open_json_admin();
		Txt.auto_open_txt_admin();
		Xml.auto_open_xml_admin();
}
}