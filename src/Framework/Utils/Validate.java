package Framework.Utils;

import Framework.Modules.Config.Model.Class_config;

public class Validate {

    /**
     * CONTROL USER
     */
    private static final String control_user = "^([0-9A-Za-z]*)$";

    /**
     * CONTROL NAME
     */
    private static final String control_name = "^[a-zA-Z\\s]*$";

    /**
     * CONTROL SURNAME
     */
    private static final String control_surname = "^[a-zA-Z\\s]*$";

    /**
     * CONTROL MOBILE
     */
    private static final String control_mobile = "^(6|9)\\d{8}$";
  

    /**
     * CONTROL MAIL
     */
    private static final String control_mail = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * CONTROL PASSWORD
     */
    private static final String control_password = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

    /**
     CONTROL DATE
     */    
    private static final String pattern_date1 = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2}$";
    private static final String pattern_date2 = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-(19|20)\\d{2}$";
    private static final String pattern_date3 = "^(19|20)\\d{2}/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])$";
    private static final String pattern_date4 = "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";

    /**
     * CONTROL TYPE OF CLIENT
     */
    private static final String control_typeofclient= "^([0-9A-Za-z]*)$";
    

    /**
     * VALIDATE DNI
     */
    public static boolean validate_dni(String DNI) {
        
        String s = "[0-9]{8}[a-zA-Z]";
        String letras = "TRWAGMYFPDXBNJZSQVHLCKET";
        boolean resultado = true;

        resultado = DNI.matches(s);

        if (resultado) {
            int modulo = (Integer.parseInt(DNI.substring(0, 8))) % 23;
            char letra = letras.charAt(modulo);

            if (letra != DNI.substring(8).toUpperCase().charAt(0)) {
                resultado = false;
            }
        }
        return resultado;
    }

    /**
     * VALIDATE NAME
     */
    public static boolean validate_name(String name) {
        return name.matches(control_name);
    }

    /**
     * VALIDATE SURNAME
     */
    public static boolean validate_surname(String surname) {
        return surname.matches(control_surname);
    }

    /**
     * VALIDATE USER
     */
    public static boolean validate_user(String user) {
        return user.matches(control_user);
    }

    /**
     * VALIDATE MOBILE
     */
    public static boolean validate_mobile(String mobile) {
        return mobile.matches(control_mobile);
    }

    /**
     * VALIDATE MAIL
     */
    public static boolean validate_mail(String mail) {
        return mail.matches(control_mail);
    }

    /**
     * VALIDATE DATE
     */
    public static boolean validate_date(String date) {
        String s = "";
        switch (Class_config.getInstance().getFormat_date()) {
            case "dd/MM/yyyy":
                s = pattern_date1;
                break;
            case "dd-MM-yyyy":
                s = pattern_date2;
                break;
            case "yyyy/MM/dd":
                s = pattern_date3;
                break;
            case "yyyy-MM-dd":
                s = pattern_date4;
                break;
        }
        return date.matches(s);
    }

    /**
     * VALIDATE PASSWORD
     */
    public static boolean validate_password(String password) {
        return password.matches(control_password);
    }
    
    /**
     * VALIDATE TYPE OF CLIENT
     */
    public static boolean validate_typeofclient(String typeofclient) {
        return typeofclient.matches(control_typeofclient);
    }
}
