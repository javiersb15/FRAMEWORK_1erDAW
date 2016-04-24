package Framework.Modules.Users.Admin.Model.Dao;

import Framework.Class.Class_date;
import Framework.Modules.Users.Admin.Model.Bll.bll_admin;
import Framework.Modules.Users.Admin.Model.Clases.Class_admin;
import Framework.Modules.Users.Admin.Model.Clases.Singleton_adm;
import Framework.Modules.Users.Admin.View.admin_jframe_create;
import Framework.Modules.Users.Admin.View.admin_jframe_update;
import Framework.Modules.Users.User.Model.Clases.Files_class;
import Framework.Utils.Validate;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Image;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static Framework.Modules.Users.Admin.View.admin_jframe_create.eti_avatar_create;
import static Framework.Modules.Users.Admin.View.admin_jframe_update.eti_avatar_update;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import javax.swing.JOptionPane;

public class dao_admin {

    /**
     * MODIFY ADMIN
     */
    public static void modifyadmin() {
        Class_admin a_1 = null;
        a_1 = bll_admin.select_admin();

        if (a_1 != null) {
            admin_jframe_update.eti_dni_update.setText(a_1.getDNI());
            admin_jframe_update.eti_name_update.setText(a_1.getname());
            admin_jframe_update.eti_surname_update.setText(a_1.getsurname());
            admin_jframe_update.eti_date_birthday_update.setCalendar(a_1.getdate_birthday().stringtocalendar());
            admin_jframe_update.eti_mobile_update.setText(a_1.getmobile());
            admin_jframe_update.eti_avatar_update.setText(a_1.getavatar());
            if (a_1.isstate() == true) {
                admin_jframe_update.eti_state_co_update.setSelected(true);
            } else {
                admin_jframe_update.eti_state_di_update.setSelected(true);
            }
            admin_jframe_update.eti_email_update.setText(a_1.getemail());
            admin_jframe_update.eti_user_update.setText(a_1.getuser());
            admin_jframe_update.eti_pass_update.setText(a_1.getpass());
            admin_jframe_update.eti_date_employ_update.setCalendar(a_1.getdate_employ().stringtocalendar());
            admin_jframe_update.eti_salary_update.setText(a_1.getsalary() + "");
            admin_jframe_update.eti_incentive_update.setText(a_1.getincentive() + "");
            admin_jframe_update.eti_activity_update.setText(a_1.getactivity() + "");
        }
    }

    /**CREATE ADMIN*/
    
    public static Class_admin create() {
        Class_admin admin = null;

        String dni = null;
        String name;
        String surname;
        Class_date date_birthday = null;
        String mobile;
        String avatar;
        boolean state;
        String email;
        String user;
        String pass;
        Class_date date_employ = null;
        float salary;
        float incentive;
        int activity;
        boolean correct, correct1, correct2, correct3, correct4, correct5, correct6, correct7, correct8, correct9, correct10, correct11, correct12;

        correct = givedni();
        correct1 = givename();
        correct2 = givesurname();
        correct3 = give_date_birthday(admin_jframe_create.eti_date_birthday_create.getCalendar());
        correct4 = givemobile();
        correct5 = givemail();
        correct6 = giveuser();
        correct7 = givepassword();
        correct8 = give_date_employ(admin_jframe_create.eti_date_birthday_create.getCalendar(), admin_jframe_create.eti_date_employ_create.getCalendar());
        correct9 = giveactivity();
        correct10 = correct_salary();
        correct11 = correct_incentive();
        correct12 = correct_activity();

        if (correct == true && correct1 == true && correct2 == true && correct3 == true && correct4 == true && correct5 == true && correct6 == true && correct7 == true && correct8 == true && correct9 == true && correct10 == true && correct11 == true && correct12 == true) {
            dni = admin_jframe_create.eti_dni_create.getText();
            name = admin_jframe_create.eti_name_create.getText();
            surname = admin_jframe_create.eti_surname_create.getText();
            date_birthday = new Class_date(((JTextFieldDateEditor) admin_jframe_create.eti_date_birthday_create.getDateEditor()).getText());
            mobile = admin_jframe_create.eti_mobile_create.getText();
            avatar = admin_jframe_create.eti_avatar_create.getText();
            state = state();
            email = admin_jframe_create.eti_email_create.getText();
            user = admin_jframe_create.eti_user_create.getText();
            pass = admin_jframe_create.eti_pass_create.getText();
            date_employ = new Class_date(((JTextFieldDateEditor) admin_jframe_create.eti_date_employ_create.getDateEditor()).getText());
            salary = Float.parseFloat(admin_jframe_create.eti_salary_create.getText());
            incentive = Float.parseFloat(admin_jframe_create.eti_incentive_create.getText());
            activity = Integer.parseInt(admin_jframe_create.eti_activity_create.getText());

            admin = new Class_admin(dni, name, surname, date_birthday, mobile, avatar, state, email, user, pass, date_employ, salary, incentive, activity);
        } else {
            admin = null;
        }

        return admin;
    }
        
        public static boolean correct_salary(){
            float salary=0.0f;
            
            try {
            salary = Float.parseFloat(admin_jframe_create.eti_salary_create.getText());
            return true;
        } catch (Exception e) {
            return false;
        }
        }
               
        public static boolean state(){
            boolean correct=false;
            
            if(admin_jframe_create.eti_state_co_create.isSelected())
                correct=true;
            if(admin_jframe_create.eti_state_di_create.isSelected())
                correct=false;            
            return correct;
        }
               
        public static boolean correct_incentive(){
            float incentive=0.0f;
            
            try {
            incentive = Integer.parseInt(admin_jframe_create.eti_incentive_create.getText());
            return true;
        } catch (Exception e) {
            return false;
        }
        }
        
         public static boolean correct_activity(){
            float activity=0.0f;
            
            try {
            activity= Float.parseFloat(admin_jframe_create.eti_activity_create.getText());
            return true;
        }   catch (Exception e) {
            return false;
        }
        }
         
          public static boolean givedni() {
        boolean correct = false;
        
        if (admin_jframe_create.eti_dni_create.getText().equals("")) {
            
            correct = false;
            
        } else {
            if (Validate.validate_dni(admin_jframe_create.eti_dni_create.getText()) == false) {
               
                correct = false;
                
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean givename() {
        boolean correct = false;
        
        if (admin_jframe_create.eti_name_create.getText().equals("")) {
            
            correct = false;
            
        } else {
            if (Validate.validate_name(admin_jframe_create.eti_name_create.getText()) == false) {
                
                correct = false;
               
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean givesurname() {
        boolean correct = false;
        
        if (admin_jframe_create.eti_surname_create.getText().equals("")) {
            
            correct = false;
           
        } else {
            if (Validate.validate_surname(admin_jframe_create.eti_surname_create.getText()) == false) {
                
                correct = false;
                
            } else {
               
                correct = true;
            }
        }
        return correct;
    }
        public static boolean give_date_birthday(Calendar birthdate) {
            boolean correct = false;
            Class_date fecha = new Class_date(birthdate);
            Class_date factualMenos16Anyos = Class_date.Factual();
            
            try {
            factualMenos16Anyos.setyear(factualMenos16Anyos.getyear() - 18);
            } catch (Exception e) {
                e.printStackTrace();
            }            
            if (fecha.comparedate(factualMenos16Anyos) > 0) {
                correct= false;			
            } else {
                correct= true;                
            }                    
            return correct;
        }
        
        public static boolean give_date_employ(Calendar birthdate, Calendar dateemploy) {
            boolean correct= false;
            Class_date fbirthday = new Class_date(birthdate);
            Class_date femploy = new Class_date(dateemploy);
            Class_date factualMenos16Anyos = null;

            try {            
            factualMenos16Anyos = new Class_date(fbirthday.getday(), fbirthday.getmonth(), fbirthday.getyear() + 18);
            } catch (Exception e) {
                e.printStackTrace();
            }            
            if ((femploy.comparedate(factualMenos16Anyos) < 0) || (femploy.comparedate(Class_date.Factual()) > 0)) {
                correct= false;                
            } else {
                correct= true;               
            }            
            return correct;
        }
        
        
         public static boolean givemobile() {
        boolean correct = false;
       
        if (admin_jframe_create.eti_mobile_create.getText().equals("")){
            
            correct = false;
            
        } else {
            if (Validate.validate_mobile(admin_jframe_create.eti_mobile_create.getText()) == false) {
                
                correct = false;
                
            } else {
               
                correct = true;
            }
        }
        return correct;
    }
         
         public static boolean givemail() {
        boolean correct = false;
       
        if (admin_jframe_create.eti_email_create.getText().equals("")) {
            
            correct = false;
            
        } else {
            if (Validate.validate_mail(admin_jframe_create.eti_email_create.getText()) == false) {
                
                correct = false;
                
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean giveuser() {
        boolean correct = false;
       
        if (admin_jframe_create.eti_user_create.getText().equals("")) {
            
            correct = false;
           
        } else {
            if (Validate.validate_user(admin_jframe_create.eti_user_create.getText()) == false) {
               
                correct = false;
               
            } else {
               
                correct = true;
            }
        }
        return correct;
    }
                   
        public static boolean givepassword() {
        boolean correct = false;
        
        if (admin_jframe_create.eti_pass_create.getText().equals("")) {
            
            correct = false;
         
        } else {
            if (Validate.validate_password(admin_jframe_create.eti_pass_create.getText()) == false) {
                
                correct = false;
                
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        
       public static boolean giveactivity() {
           boolean correct = false;
           int activity=0;
        
        try {
            activity= Integer.parseInt(admin_jframe_create.eti_activity_create.getText());
           
            correct= true;
        }   catch (Exception e) {
            
            correct= false;
        }
        return correct;
       }
       
       public static boolean givesalary() {
        float salary=0.0f;
        boolean correct = false;
        
        try {
            salary= Float.parseFloat(admin_jframe_create.eti_salary_create.getText());
            
            correct = true;
        }   catch (Exception e) {
           
            correct = false;
        }
        return correct;
       }
       
       public static boolean giveincentive() {
        float incentive=0.0f;
        boolean correct = false;
        
        try {
            incentive= Float.parseFloat(admin_jframe_create.eti_incentive_create.getText());
            
            correct =true;
        }   catch (Exception e) {
           
            correct =false;
        }
        return correct;
       }
       
       public static String dialogoSelectorImagen() {
        String img = "";

        String extensiones[] = {"jpg", "png", "gif"};
        int valor;

        Files_class filtro = new Files_class(extensiones, "Imagenes jpg, gif, png");

        JFileChooser selector = new JFileChooser();
        selector.setFileFilter(filtro);
        selector.setAcceptAllFileFilterUsed(false);

        valor = selector.showOpenDialog(null);

        if (valor == JFileChooser.APPROVE_OPTION) {
            img = selector.getSelectedFile().getPath();
            eti_avatar_create.setText(selector.getSelectedFile().getPath());
        }

        return img;
    }
       
       public static void giveavatar(String img){
           ImageIcon temporal=new ImageIcon(img);
           ImageIcon imagen=new ImageIcon(temporal.getImage().getScaledInstance(160, -1, Image.SCALE_DEFAULT));
            admin_jframe_create.lab_avatar.setIcon(imagen);
       }
       
       
       /**UPDATE ADMIN*/
    
    public static Class_admin create_update() {
        Class_admin admin = null;

        String dni = null;
        String name;
        String surname;
        Class_date date_birthday = null;
        String mobile;
        String avatar;
        boolean state;
        String email;
        String user;
        String pass;
        Class_date date_employ = null;
        float salary;
        float incentive;
        int activity;
        boolean correct, correct1, correct2, correct3, correct4, correct5, correct6, correct7, correct8, correct9, correct10, correct11, correct12;

        correct = givedni_update();
        System.out.println(correct +" " +"dni");
        correct1 = givename_update();
        System.out.println(correct +" " +"name");
        correct2 = givesurname_update();
        System.out.println(correct +" " +"surname");
        correct3 = give_date_birthday_update(admin_jframe_update.eti_date_birthday_update.getCalendar());
        System.out.println(correct +" " +"date_birthday");
        correct4 = givemobile_update();
        System.out.println(correct +" " +"mobile");
        correct5 = givemail_update();
        System.out.println(correct +" " +"mail");
        correct6 = giveuser_update();
        System.out.println(correct +" " +"user");
        correct7 = givepassword_update();
        System.out.println(correct +" " +"pass");
        correct8 = give_date_employ_update(admin_jframe_update.eti_date_birthday_update.getCalendar(), admin_jframe_update.eti_date_employ_update.getCalendar());
        System.out.println(correct +" " +"date_employ");
        correct9 = giveactivity_update();
        System.out.println(correct +" " +"activity");
        correct10 = correct_salary_update();
        System.out.println(correct +" " +"salary");
        correct11 = correct_incentive_update();
        System.out.println(correct +" " +"incentive");
        correct12 = correct_activity_update();
        System.out.println(correct +" " +"activity");

        //if (correct == true && correct1 == true && correct2 == true && correct3 == true && correct4 == true && correct5 == true && correct6 == true && correct7 == true && correct8 == true && correct9 == true && correct10 == true && correct11 == true && correct12 == true) {
            dni = admin_jframe_update.eti_dni_update.getText();
            //System.out.println(dni);
            name = admin_jframe_update.eti_name_update.getText();
            surname = admin_jframe_update.eti_surname_update.getText();
            date_birthday = new Class_date(((JTextFieldDateEditor) admin_jframe_update.eti_date_birthday_update.getDateEditor()).getText());
            mobile = admin_jframe_update.eti_mobile_update.getText();
            avatar = admin_jframe_update.eti_avatar_update.getText();
            state = state_update();
            email = admin_jframe_update.eti_email_update.getText();
            user = admin_jframe_update.eti_user_update.getText();
            pass = admin_jframe_update.eti_pass_update.getText();
            date_employ = new Class_date(((JTextFieldDateEditor) admin_jframe_update.eti_date_employ_update.getDateEditor()).getText());
            salary = Float.parseFloat(admin_jframe_update.eti_salary_update.getText());
            incentive = Float.parseFloat(admin_jframe_update.eti_incentive_update.getText());
            activity = Integer.parseInt(admin_jframe_update.eti_activity_update.getText());

            admin = new Class_admin(dni, name, surname, date_birthday, mobile, avatar, state, email, user, pass, date_employ, salary, incentive, activity);
       //} else {
           // admin = null;
       //}
        //System.out.println(admin);
        return admin;
    }
    
    public static Class_admin ask_adminDNI_update () {
	boolean checkDNI;
        String DNI;
        Class_admin admin=null;
        
        checkDNI=DNI_update();
        if (checkDNI==true){
            admin = new Class_admin (admin_jframe_update.eti_dni_update.getText());
        }        
        return admin;
    }
    
    public static boolean DNI_update () {
        boolean check=true;
        
        String DNI = "", aux = "", caracteres = "TRWAGMYFPDXBNJZSQVHLCKET";
		boolean confirm;
		int number = 0, module = 0;
		char character = ' ', control = ' ';
		
		DNI=admin_jframe_update.eti_dni_update.getText();
		confirm=Validate.validate_dni(DNI);
		if (confirm==false) {
                    check = false;
                }else{
                    aux = "";
                    for(int i=0; i<8; i++){
                        aux += DNI.charAt(i);
                    }	
                    character = DNI.charAt(8);			
                    number = Integer.parseInt(aux);
                    module= number % 23;
                    control = caracteres.charAt(module);
                    if(control == character){
                        check = true;
                    }else{
                        check = false;
                    }
                }
        
        return check;
    }
    
        public static boolean correct_salary_update(){
            float salary=0.0f;
            
            try {
            salary = Float.parseFloat(admin_jframe_update.eti_salary_update.getText());
            return true;
        } catch (Exception e) {
            return false;
        }
        }
               
        public static boolean state_update(){
            boolean correct=false;
            
            if(admin_jframe_update.eti_state_co_update.isSelected())
                correct=true;
            if(admin_jframe_update.eti_state_di_update.isSelected())
                correct=false;            
            return correct;
        }
               
        public static boolean correct_incentive_update(){
            float incentive=0.0f;
            
            try {
            incentive = Integer.parseInt(admin_jframe_update.eti_incentive_update.getText());
            return true;
        } catch (Exception e) {
            return false;
        }
        }
        
         public static boolean correct_activity_update(){
            float activity=0.0f;
            
            try {
            activity= Float.parseFloat(admin_jframe_update.eti_activity_update.getText());
            return true;
        }   catch (Exception e) {
            return false;
        }
        }
         
          public static boolean givedni_update() {
        boolean correct = false;
        
        if (admin_jframe_update.eti_dni_update.getText().equals("")) {
            
            correct = false;
            
        } else {
            if (Validate.validate_dni(admin_jframe_update.eti_dni_update.getText()) == false) {
               
                correct = false;
                
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean givename_update() {
        boolean correct = false;
        
        if (admin_jframe_update.eti_name_update.getText().equals("")) {
            
            correct = false;
            
        } else {
            if (Validate.validate_name(admin_jframe_update.eti_name_update.getText()) == false) {
                
                correct = false;
               
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean givesurname_update() {
        boolean correct = false;
        
        if (admin_jframe_update.eti_surname_update.getText().equals("")) {
            
            correct = false;
           
        } else {
            if (Validate.validate_surname(admin_jframe_update.eti_surname_update.getText()) == false) {
                
                correct = false;
                
            } else {
               
                correct = true;
            }
        }
        return correct;
    }
        public static boolean give_date_birthday_update(Calendar birthdate) {
            boolean correct = false;
            Class_date fecha = new Class_date(birthdate);
            Class_date factualMenos16Anyos = Class_date.Factual();
            
            try {
            factualMenos16Anyos.setyear(factualMenos16Anyos.getyear() - 18);
            } catch (Exception e) {
                e.printStackTrace();
            }            
            if (fecha.comparedate(factualMenos16Anyos) > 0) {
                correct= false;			
            } else {
                correct= true;                
            }                    
            return correct;
        }
        
        public static boolean give_date_employ_update(Calendar birthdate, Calendar dateemploy) {
            boolean correct= false;
            Class_date fbirthday = new Class_date(birthdate);
            Class_date femploy = new Class_date(dateemploy);
            Class_date factualMenos16Anyos = null;

            try {            
            factualMenos16Anyos = new Class_date(fbirthday.getday(), fbirthday.getmonth(), fbirthday.getyear() + 18);
            } catch (Exception e) {
                e.printStackTrace();
            }            
            if ((femploy.comparedate(factualMenos16Anyos) < 0) || (femploy.comparedate(Class_date.Factual()) > 0)) {
                correct= false;                
            } else {
                correct= true;               
            }            
            return correct;
        }
        
        
         public static boolean givemobile_update() {
        boolean correct = false;
       
        if (admin_jframe_update.eti_mobile_update.getText().equals("")){
            
            correct = false;
            
        } else {
            if (Validate.validate_mobile(admin_jframe_update.eti_mobile_update.getText()) == false) {
                
                correct = false;
                
            } else {
               
                correct = true;
            }
        }
        return correct;
    }
         
         public static boolean givemail_update() {
        boolean correct = false;
       
        if (admin_jframe_update.eti_email_update.getText().equals("")) {
            
            correct = false;
            
        } else {
            if (Validate.validate_mail(admin_jframe_update.eti_email_update.getText()) == false) {
                
                correct = false;
                
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean giveuser_update() {
        boolean correct = false;
       
        if (admin_jframe_update.eti_user_update.getText().equals("")) {
            
            correct = false;
           
        } else {
            if (Validate.validate_user(admin_jframe_update.eti_user_update.getText()) == false) {
               
                correct = false;
               
            } else {
               
                correct = true;
            }
        }
        return correct;
    }
                   
        public static boolean givepassword_update() {
        boolean correct = false;
        
        if (admin_jframe_update.eti_pass_update.getText().equals("")) {
            
            correct = false;
         
        } else {
            if (Validate.validate_password(admin_jframe_update.eti_pass_update.getText()) == false) {
                
                correct = false;
                
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        
       public static boolean giveactivity_update() {
           boolean correct = false;
           int activity=0;
        
        try {
            activity= Integer.parseInt(admin_jframe_update.eti_activity_update.getText());
           
            correct= true;
        }   catch (Exception e) {
            
            correct= false;
        }
        return correct;
       }
       
       public static boolean givesalary_update() {
        float salary=0.0f;
        boolean correct = false;
        
        try {
            salary= Float.parseFloat(admin_jframe_update.eti_salary_update.getText());
            
            correct = true;
        }   catch (Exception e) {
           
            correct = false;
        }
        return correct;
       }
       
       public static boolean giveincentive_update() {
        float incentive=0.0f;
        boolean correct = false;
        
        try {
            incentive= Float.parseFloat(admin_jframe_update.eti_incentive_update.getText());
            
            correct =true;
        }   catch (Exception e) {
           
            correct =false;
        }
        return correct;
       }
       
       public static String dialogoSelectorImagen_update() {
        String img = "";

        String extensiones[] = {"jpg", "png", "gif"};
        int valor;

        Files_class filtro = new Files_class(extensiones, "Imagenes jpg, gif, png");

        JFileChooser selector = new JFileChooser();
        selector.setFileFilter(filtro);
        selector.setAcceptAllFileFilterUsed(false);

        valor = selector.showOpenDialog(null);

        if (valor == JFileChooser.APPROVE_OPTION) {
            img = selector.getSelectedFile().getPath();
            eti_avatar_update.setText(selector.getSelectedFile().getPath());
        }
        return img;
    }
       
       public static void giveavatar_update(String img){
           ImageIcon temporal=new ImageIcon(img);
           ImageIcon imagen=new ImageIcon(temporal.getImage().getScaledInstance(160, -1, Image.SCALE_DEFAULT));
            admin_jframe_update.lab_avatar.setIcon(imagen);
       }
}
