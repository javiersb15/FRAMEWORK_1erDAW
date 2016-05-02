package Framework.Modules.Users.User_register.Model.Dao;

import Framework.Class.Class_date;
import Framework.Modules.Users.User.Model.Clases.Files_class;
import Framework.Modules.Users.User_register.Model.Bll.bll_user_register;
import Framework.Modules.Users.User_register.Model.Clases.Class_user_register;
import Framework.Modules.Users.User_register.View.user_register_jframe_create;
import static Framework.Modules.Users.User_register.View.user_register_jframe_create.eti_avatar_create;
import Framework.Modules.Users.User_register.View.user_register_jframe_update;
import static Framework.Modules.Users.User_register.View.user_register_jframe_update.eti_avatar_update;
import Framework.Utils.Validate;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Image;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;


public class dao_user_register {

	
	/**MODIFY USER REGISTER*/
	public static void modifyuser_register() {
            Class_user_register u_1=null;
            u_1=bll_user_register.select_user_register();
            
            
            if (u_1!=null){
            user_register_jframe_update.eti_dni_update.setText(u_1.getDNI());
            user_register_jframe_update.eti_name_update.setText(u_1.getname());
            user_register_jframe_update.eti_surname_update.setText(u_1.getsurname());
            user_register_jframe_update.eti_date_birthday_update.setCalendar(u_1.getdate_birthday().stringtocalendar());
            user_register_jframe_update.eti_mobile_update.setText(u_1.getmobile());
            user_register_jframe_update.eti_avatar_update.setText(u_1.getavatar());            
            if (u_1.isstate()==true){
                user_register_jframe_update.eti_state_co_update.setSelected(true);
            }else{ 
                user_register_jframe_update.eti_state_di_update.setSelected(true);
            }
            user_register_jframe_update.eti_email_update.setText(u_1.getemail());
            user_register_jframe_update.eti_user_update.setText(u_1.getuser());
            user_register_jframe_update.eti_pass_update.setText(u_1.getpass());
            user_register_jframe_update.eti_activity_update.setText(u_1.getactivity()+"");	
            }
        }
        
        public static Class_user_register create() {
           Class_user_register user_register=null;           
       
        String dni = null;
        String name;
        String surname;
        Class_date date_birthday=null;
        String mobile;
        String avatar;
        boolean state;
        String email;
        String user;
        String pass;
        int activity;
        boolean correct, correct1, correct2, correct3, correct4, correct5, correct6, correct7, correct8;

        correct=givedni();
        correct1=givename();
        correct2=givesurname();
        correct3=give_date_birthday(user_register_jframe_create.eti_date_birthday_create.getCalendar());
        correct4=givemobile();
        correct5=givemail();
        correct6=giveuser();
        correct7=givepassword();
        correct8=giveactivity();

        if (correct== true && correct1==true && correct2==true && correct3==true && correct4==true && correct5==true && correct6==true && correct7==true && correct8==true) {
            dni=user_register_jframe_create.eti_dni_create.getText();
            name=user_register_jframe_create.eti_name_create.getText();
            surname=user_register_jframe_create.eti_surname_create.getText();
            date_birthday=new Class_date (((JTextFieldDateEditor)user_register_jframe_create.eti_date_birthday_create.getDateEditor()).getText());
            mobile=user_register_jframe_create.eti_mobile_create.getText();
            avatar=user_register_jframe_create.eti_avatar_create.getText();
            state=state();
            email=user_register_jframe_create.eti_email_create.getText();
            user=user_register_jframe_create.eti_user_create.getText();
            pass=user_register_jframe_create.eti_pass_create.getText();
            activity=Integer.parseInt(user_register_jframe_create.eti_activity_create.getText());


            user_register= new Class_user_register(dni, name, surname, date_birthday, mobile, avatar, state, email, user, pass, activity);
        } else {
            user_register= null;

        }
        return user_register;
    }
        
        public static Class_user_register create_update() {
           Class_user_register user_register_update=null;           
       
        String DNI = null;
        String name;
        String surname;
        Class_date date_birthday=null;
        String mobile;
        String avatar;
        boolean state;
        String email;
        String user;
        String pass;
        int activity;
        boolean correct, correct1, correct2, correct3, correct4, correct5, correct6, correct7, correct8;

        correct=givedni_update();
        correct1=givename_update();
        correct2=givesurname_update();
        correct3=give_date_birthday(user_register_jframe_update.eti_date_birthday_update.getCalendar());
        correct4=givemobile_update();
        correct5=givemail_update();
        correct6=giveuser_update();
        correct7=givepassword_update();
        correct8=giveactivity_update();

        if (correct== true && correct1==true && correct2==true && correct3==true && correct4==true && correct5==true && correct6==true && correct7==true && correct8==true) {
            DNI=user_register_jframe_update.eti_dni_update.getText();
            name=user_register_jframe_update.eti_name_update.getText();
            surname=user_register_jframe_update.eti_surname_update.getText();
            date_birthday=new Class_date (((JTextFieldDateEditor)user_register_jframe_update.eti_date_birthday_update.getDateEditor()).getText());
            mobile=user_register_jframe_update.eti_mobile_update.getText();
            avatar=user_register_jframe_update.eti_avatar_update.getText();
            state=state_update();
            email=user_register_jframe_update.eti_email_update.getText();
            user=user_register_jframe_update.eti_user_update.getText();
            pass=user_register_jframe_update.eti_pass_update.getText();
            activity=Integer.parseInt(user_register_jframe_update.eti_activity_update.getText());


            user_register_update= new Class_user_register(DNI, name, surname, date_birthday, mobile, avatar, state, email, user, pass, activity);
        } else {
            user_register_update= null;

        }
        return user_register_update;
    }
        
        public static boolean state(){
            boolean correct=false;
            
            if(user_register_jframe_create.eti_state_co_create.isSelected())
                correct=true;
            if(user_register_jframe_create.eti_state_di_create.isSelected())
                correct=false;            
            return correct;
        }
                
          public static boolean givedni() {
        boolean correct = false;
        
        if (user_register_jframe_create.eti_dni_create.getText().equals("")) {
            
            correct = false;
            
        } else {
            if (Validate.validate_dni(user_register_jframe_create.eti_dni_create.getText()) == false) {
               
                correct = false;
                
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean givename() {
        boolean correct = false;
        
        if (user_register_jframe_create.eti_name_create.getText().equals("")) {
            
            correct = false;
            
        } else {
            if (Validate.validate_name(user_register_jframe_create.eti_name_create.getText()) == false) {
                
                correct = false;
               
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean givesurname() {
        boolean correct = false;
        
        if (user_register_jframe_create.eti_surname_create.getText().equals("")) {
            
            correct = false;
           
        } else {
            if (Validate.validate_surname(user_register_jframe_create.eti_surname_create.getText()) == false) {
                
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
        
         public static boolean givemobile() {
        boolean correct = false;
       
        if (user_register_jframe_create.eti_mobile_create.getText().equals("")){
            
            correct = false;
            
        } else {
            if (Validate.validate_mobile(user_register_jframe_create.eti_mobile_create.getText()) == false) {
                
                correct = false;
                
            } else {
               
                correct = true;
            }
        }
        return correct;
    }
         
         public static boolean givemail() {
        boolean correct = false;
       
        if (user_register_jframe_create.eti_email_create.getText().equals("")) {
            
            correct = false;
            
        } else {
            if (Validate.validate_mail(user_register_jframe_create.eti_email_create.getText()) == false) {
                
                correct = false;
                
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean giveuser() {
        boolean correct = false;
       
        if (user_register_jframe_create.eti_user_create.getText().equals("")) {
            
            correct = false;
           
        } else {
            if (Validate.validate_user(user_register_jframe_create.eti_user_create.getText()) == false) {
               
                correct = false;
               
            } else {
               
                correct = true;
            }
        }
        return correct;
    }
                   
        public static boolean givepassword() {
        boolean correct = false;
        
        if (user_register_jframe_create.eti_pass_create.getText().equals("")) {
            
            correct = false;
         
        } else {
            if (Validate.validate_password(user_register_jframe_create.eti_pass_create.getText()) == false) {
                
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
            activity= Integer.parseInt(user_register_jframe_create.eti_activity_create.getText());
           
            correct= true;
        }   catch (Exception e) {
            
            correct= false;
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
            user_register_jframe_create.lab_avatar.setIcon(imagen);
       }
       
       
       
       public static boolean givedni_update() {
        boolean correct = false;
        
        if (user_register_jframe_update.eti_dni_update.getText().equals("")) {
            
            correct = false;
            
        } else {
            if (Validate.validate_dni(user_register_jframe_update.eti_dni_update.getText()) == false) {
               
                correct = false;
                
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean givename_update() {
        boolean correct = false;
        
        if (user_register_jframe_update.eti_name_update.getText().equals("")) {
            
            correct = false;
            
        } else {
            if (Validate.validate_name(user_register_jframe_update.eti_name_update.getText()) == false) {
                
                correct = false;
               
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean givesurname_update() {
        boolean correct = false;
        
        if (user_register_jframe_update.eti_surname_update.getText().equals("")) {
            
            correct = false;
           
        } else {
            if (Validate.validate_surname(user_register_jframe_update.eti_surname_update.getText()) == false) {
                
                correct = false;
                
            } else {
               
                correct = true;
            }
        }
        return correct;
    }
        public static boolean Validatedatebirthday_update(Calendar birthdate) {
            boolean check = false;
            Class_date fecha = new Class_date(birthdate);
            Class_date factualMenos16Anyos = Class_date.Factual();
            
            try {
            factualMenos16Anyos.setyear(factualMenos16Anyos.getyear() - 18);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            if (fecha.comparedate(factualMenos16Anyos) > 0) {
                check = false;
			
            } else {
                check = true;
                
            }                    
            return check;
        }
        
         public static boolean givemobile_update() {
        boolean correct = false;
       
        if (user_register_jframe_update.eti_mobile_update.getText().equals("")){
            
            correct = false;
            
        } else {
            if (Validate.validate_mobile(user_register_jframe_update.eti_mobile_update.getText()) == false) {
                
                correct = false;
                
            } else {
               
                correct = true;
            }
        }
        return correct;
    }
         
         public static boolean givemail_update() {
        boolean correct = false;
       
        if (user_register_jframe_update.eti_email_update.getText().equals("")) {
            
            correct = false;
            
        } else {
            if (Validate.validate_mail(user_register_jframe_update.eti_email_update.getText()) == false) {
                
                correct = false;
                
            } else {
                
                correct = true;
            }
        }
        return correct;
    }
        
        public static boolean giveuser_update() {
        boolean correct = false;
       
        if (user_register_jframe_update.eti_user_update.getText().equals("")) {
            
            correct = false;
           
        } else {
            if (Validate.validate_user(user_register_jframe_update.eti_user_update.getText()) == false) {
               
                correct = false;
               
            } else {
               
                correct = true;
            }
        }
        return correct;
    }
                   
        public static boolean givepassword_update() {
        boolean correct = false;
        
        if (user_register_jframe_update.eti_pass_update.getText().equals("")) {
            
            correct = false;
         
        } else {
            if (Validate.validate_password(user_register_jframe_update.eti_pass_update.getText()) == false) {
                
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
            activity= Integer.parseInt(user_register_jframe_update.eti_activity_update.getText());
           
            correct= true;
        }   catch (Exception e) {
            
            correct= false;
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
            user_register_jframe_update.lab_avatar.setIcon(imagen);
       } 
       
       public static boolean state_update(){
            boolean correct=false;
            
            if(user_register_jframe_update.eti_state_co_update.isSelected())
                correct=true;
            if(user_register_jframe_update.eti_state_di_update.isSelected())
                correct=false;            
            return correct;
        }
}