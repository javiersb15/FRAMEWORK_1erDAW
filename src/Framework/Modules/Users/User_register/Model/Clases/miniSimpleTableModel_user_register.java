package Framework.Modules.Users.User_register.Model.Clases;

import Framework.Class.Class_date;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import static Framework.Modules.Users.User_register.Controller.Controller_user_register.combo;
import Framework.Modules.Users.User_register.Model.Utils.Extensions.Json;
import Framework.Modules.Users.User_register.Model.Utils.Pager.pagina_user_register;
import Framework.Modules.Users.User_register.View.pager_user_register;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;




public class miniSimpleTableModel_user_register extends AbstractTableModel {
    public static ArrayList<Class_user_register> datos = new ArrayList<Class_user_register>();
    public static ArrayList<Class_user_register> datosaux = new ArrayList<Class_user_register>();
    
    String[] columnas = {"DNI", "Name", "Surname", "Date of birthday"};

    ////////////////////estos métodos son necesarios para que jtable funcione/////////////////////
    @Override
    public String getColumnName(int col) {
        return columnas[col].toString();
    }

    //Devuelve el numero de filas
    @Override
    public int getRowCount() {
        return datos.size();
    }

    //Devuelve el numero de columnas
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    //Devuelve el valor del objeto en la fila y columna
    @Override
    public Object getValueAt(int row, int col) {

        Object dev = null;
        Class_user_register fila = (Class_user_register) datos.get(row);

        switch (col) {
            case 0:
                dev = fila.getDNI();
                break;

            case 1:
                dev = fila.getname();
                break;

            case 2:
                dev = fila.getsurname();
                break;

            case 3:
                dev = fila.getdate_birthday().toStringformat();
                break;

        }
        return dev;
    }

    //Determina si una fila y columna ha de ser editable
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    //Actualiza un objeto de una fila y columna
    @Override
    public void setValueAt(Object value, int row, int col) {
        Class_user_register fila = (Class_user_register) datos.get(row);

        switch (col) {
            case 0:
                fila.setDNI(value.toString());
                break;

            case 1:
                fila.setname(value.toString());
                break;

            case 2:
                fila.setsurname(value.toString());
                break;
            
            case 3:                
                fila.setdate_birthday(new Class_date(value.toString()));
                break;

        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Class_user_register usu) {
        datos.add(usu);
        fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();
        
        Json.auto_open_json_usr_reg();
        
        Class_user_register usr_reg= null;
        java.util.Date date= new java.util.Date();
        for(int i=0; i<=(Singleton.User_register_array.size()-1) ;i++) {
            usr_reg=Singleton.User_register_array.get(i);
            addRow(usr_reg);
            datosaux.add(usr_reg);
            
            try {
                Thread.sleep(1); //1 milliseconds
            } catch (Exception e) {
              System.out.println(e);
            }
        }
    }

    public void filtrar() {
        datos.clear();
        int cont=0;
        
        String name=(String) ((JComboBox)combo).getSelectedItem();   
        if(name!=null){
            for(int i=0;i<datosaux.size();i++) {
                if(datosaux.get(i).getname().toLowerCase().startsWith(name.toLowerCase())){
                    addRow(datosaux.get(i));
                    cont++;
                }
            }
            pager_user_register.jLabel3.setText(String.valueOf(cont));
            System.out.println("word selected: " + name);
            pagina_user_register.initLinkBox();
        }
    }

    public Class_user_register buscar(String usr_reg) {
        datos.clear();
        cargar();

        String res;
        for (int i = 0; i < datos.size(); i++) {
            res = datos.get(i).toString();
            if (res.contains(usr_reg)) {
                return datos.get(i);
            }
        }
        return null;
    }

    public int buscaUsuario(Class_user_register usr_reg) {
        datos.clear();
        cargar();

        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).equals(usr_reg)) {
                return i;
            }
        }
        return -1;
    }

    public void removeRow(int fila) {
        datos.remove(fila);
        fireTableDataChanged();
    }
}
