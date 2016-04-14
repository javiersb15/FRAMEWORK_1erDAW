package Framework.Modules.Users.Admin.Model.Clases;

import Framework.Class.Class_date;
import static Framework.Modules.Users.Admin.Controller.Controller_admin.combo;
import Framework.Modules.Users.Admin.Model.Utils.Extensions.Json;
import Framework.Modules.Users.Admin.Model.Utils.Pager.pagina_admin;
import Framework.Modules.Users.Admin.View.pager_adm;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;


public class miniSimpleTableModel_admin extends AbstractTableModel {
    public static ArrayList<Class_admin> datos = new ArrayList<Class_admin>();
    public static ArrayList<Class_admin> datosaux = new ArrayList<Class_admin>();
    
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
        Class_admin fila = (Class_admin) datos.get(row);

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
        Class_admin fila = (Class_admin) datos.get(row);

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

    public void addRow(Class_admin usu) {
        datos.add(usu);
        fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();
        
        Json.auto_open_json_admin();
        
        Class_admin adm= null;
        java.util.Date date= new java.util.Date();
        for(int i=0; i<=(Singleton.Admin_array.size()-1) ;i++) {
            adm=Singleton.Admin_array.get(i);
            addRow(adm);
            datosaux.add(adm);
            
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
            pager_adm.jLabel3.setText(String.valueOf(cont));
            System.out.println("word selected: " + name);
            pagina_admin.initLinkBox();
        }
    }

    public Class_admin buscar(String adm) {
        datos.clear();
        cargar();

        String res;
        for (int i = 0; i < datos.size(); i++) {
            res = datos.get(i).toString();
            if (res.contains(adm)) {
                return datos.get(i);
            }
        }
        return null;
    }

    public int buscaUsuario(Class_admin adm) {
        datos.clear();
        cargar();

        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).equals(adm)) {
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