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
    
    public static String getSelect(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
    
    public static String setlanguage () {
        String language = "";
        switch (language){
            case "val":
                config_frame.language_valencian.isSelected();
                break;
        
            case "es":
                config_frame.language_spanish.isSelected();
                break;
        
            case "en":
                config_frame.language_english.isSelected();
                break;
        }              
        return language;
    }
    
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
    
    public static String setcurrency () {
        String currency ="";     
        switch (getSelect(config_frame.currency)){
            case "EURO":
                currency="€";
                break;
            
            case "DOLAR":
                currency="$";
                break;
            
            case "LIBRA":
                currency="£";
                break;
        }        
        return currency;
    }
    
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
    
    public static void getlanguage () {
        switch (Class_config.getInstance().getLanguage()){            
            case "val":
                config_frame.language_valencian.setSelected(true);
                break;
                
            case "es":
                config_frame.language_spanish.setSelected(true);
                break;
                
            case "en":
                config_frame.language_english.setSelected(true);
                break;
        }
    }
    
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
                
            case "yyyy-MM--dd":
                config_frame.date_yyyyMMdd_guion.setSelected(true);
                break;
        }
    }
    
    public static void getcurrency () {
        switch (Class_config.getInstance().getCurrency()){            
            case "€":
                config_frame.currency_euro.setSelected(true);
                break;
                
            case "$":
                config_frame.currency_dolar.setSelected(true);
                break;
                
            case "£":
                config_frame.currency_libra.setSelected(true);
                break;
        }
    }
    
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
    
    public static void getdecimal () {
        switch (Class_config.getInstance().getDecimal_number()){            
            case "1":
                config_frame.decimal_1decimal.setSelected(true);
                break;
                
            case "2":
                config_frame.decimal_2decimal.setSelected(true);
                break;
                
            case "3":
                config_frame.decimal_3decimal.setSelected(true);
                break;
        }
    }
}