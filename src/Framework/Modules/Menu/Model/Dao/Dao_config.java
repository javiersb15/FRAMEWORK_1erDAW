/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Menu.Model.Dao;

import Framework.Modules.Menu.Model.Clases.Class_config;
import Framework.Modules.Menu.View.config_frame;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

/**
 *
 * @author usuario
 */
public class Dao_config {
    
    /**FUNCTION BUTTON GROUP*/
    public static String getSelect(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
    
    /**SET LANGUAGE*/
    public static String setlanguage () {
        String language = "";
        switch (getSelect((config_frame.language))){
            case "VALENCIAN":
                language="VALENCIAN";
                break;
        
            case "SPANISH":
                language="SPANISH";
                break;
        
            case "ENGLISH":
                language="ENGLISH";
                break;
        }              
        return language;
    }
    
    /**SET DATE*/
    public static String setdate () {
        String date = "";
        switch (getSelect(config_frame.date)){
            case "dd/MM/yyyy":
                date="dd/MM/yyyy";
                break;
                
            case "dd-MM-yyyy":
                date="dd-MM-yyyy";
                break;
                
            case "yyyy/MM/dd":
                date="yyyy/MM/dd";
                break;
                
            case "yyyy-MM-dd":
                date="yyyy-MM-dd";
                break;       
        }
        return date;
    }
    
    /**SET CURRENCY*/
    public static String setcurrency () {
        String currency ="";     
        switch (getSelect(config_frame.currency)){
            case "EURO":
                currency="EURO";
                break;
            
            case "DOLAR":
                currency="DOLAR";
                break;
            
            case "LIBRA":
                currency="LIBRA";
                break;
        }        
        return currency;
    }
    
    /**SET THEME*/
    public static String settheme () {
        String theme = "";
        switch (getSelect(config_frame.theme)){
            case "Metal":
                theme="Metal";
                break;
        
            case "Windows":
                theme="Windows";
                break;
        
            case "Motif":
                theme="Motif";                
                break;
            
            case "Nimbus":
                theme="Nimbus";
                break;            
        }
        return theme;
    }   
    
    /**SET DECIMAL*/
    public static String setdecimal () {
        String decimal ="";        
        switch (getSelect(config_frame.decimal)){
            case "1 DECIMAL":
                decimal="1 DECIMAL";
                break;
            
            case "2 DECIMAL":
                decimal="2 DECIMAL";
                break;  
            
            case "3 DECIMAL":
                decimal="3 DECIMAL";
                break;       
        }
        return decimal;
    }
    
    /**GET LANGUAGE*/
    public static void getlanguage () {
        switch (Class_config.getInstance().getLanguage()){            
            case "VALENCIAN":
                config_frame.language_valencian.setSelected(true);
                break;
                
            case "SPANISH":
                config_frame.language_spanish.setSelected(true);
                break;
                
            case "ENGLISH":
                config_frame.language_english.setSelected(true);
                break;
        }
    }
    
    /**GET DATE*/
    public static void getdate () {
        switch (Class_config.getInstance().getFormat_date()){            
            case "dd/MM/yyyy":
                config_frame.date_ddMMyyyy_barra.setSelected(true);
                break;
                
            case "dd-MM-yyyy":                
                config_frame.date_ddMMyyyy_guion.setSelected(true);
                break;
                
            case "yyyy/MM/dd":
                config_frame.date_yyyyMMdd_barra.setSelected(true);
                break;
                
            case "yyyy-MM-dd":
                config_frame.date_yyyyMMdd_guion.setSelected(true);
                break;
        }
    }
    
    /**GET CURRENCY*/
    public static void getcurrency () {
        switch (Class_config.getInstance().getCurrency()){            
            case "EURO":
                config_frame.currency_euro.setSelected(true);
                break;
                
            case "DOLAR":
                config_frame.currency_dolar.setSelected(true);
                break;
                
            case "LIBRA":
                config_frame.currency_libra.setSelected(true);
                break;
        }
    }
    
    /**GET THEME*/
    public static void gettheme () {
        switch (Class_config.getInstance().getTheme()){            
            case "Metal":
                config_frame.theme_metal.setSelected(true);
                break;
                
            case "Windows":
                config_frame.theme_windows.setSelected(true);
                break;
                
            case "Motif":
                config_frame.theme_motif.setSelected(true);
                break;
                
            case "Nimbus":
                config_frame.theme_nimbus.setSelected(true);
                break;           
        }
    }
    
    /**GET DECIMAL*/
    public static void getdecimal () {
        switch (Class_config.getInstance().getDecimal_number()){            
            case "1 DECIMAL":
                config_frame.decimal_1decimal.setSelected(true);
                break;
                
            case "2 DECIMAL":
                config_frame.decimal_2decimal.setSelected(true);
                break;
                
            case "3 DECIMAL":
                config_frame.decimal_3decimal.setSelected(true);
                break;
        }
    }
}