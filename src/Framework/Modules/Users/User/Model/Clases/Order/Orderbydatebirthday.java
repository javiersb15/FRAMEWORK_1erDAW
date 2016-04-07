package Framework.Modules.Users.User.Model.Clases.Order;

import Framework.Modules.Users.User.Model.Clases.Class_user;
import java.util.Comparator;


/**ORDER BY DATE OF BIRTHDAT*/
public class Orderbydatebirthday implements Comparator <Class_user>{

	public int compare (Class_user usr1, Class_user usr2) {
		return usr1.getdate_birthday().comparedate(usr2.getdate_birthday());
	}
}