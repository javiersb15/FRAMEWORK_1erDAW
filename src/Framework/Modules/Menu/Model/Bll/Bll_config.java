/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Menu.Model.Bll;

import Framework.Modules.Menu.Model.Clases.Class_config;
import Framework.Modules.Menu.Model.Dao.Dao_config;
import Framework.Modules.Menu.Model.Functions.json_auto_config;

/**
 *
 * @author usuario
 */
public class Bll_config {
    
    public static void setConfig () {
        Class_config.getInstance().setLanguage(Dao_config.setlanguage());
        Class_config.getInstance().setFormat_date(Dao_config.setdate());
        Class_config.getInstance().setCurrency(Dao_config.setcurrency());
        Class_config.getInstance().setTheme(Dao_config.settheme());
        Class_config.getInstance().setDecimal_number(Dao_config.setdecimal());
        json_auto_config.create_json_config();
    }
    
    public static void getConfig () {
        Dao_config.getlanguage();
        Dao_config.getdate();
        Dao_config.getcurrency();
        Dao_config.gettheme();
        Dao_config.getdecimal();
    }    
}