package Framework.Modules.Users.Client.Model.Clases;

import Framework.Class.Class_date;
import static Framework.Modules.Users.Client.Controller.Controller_client.combo;
import Framework.Modules.Users.Client.Model.Bll.bll_client_db;
import Framework.Modules.Users.Client.Model.Utils.Pager.pagina_client;
import Framework.Modules.Users.Client.View.pager_client;
import Framework.Modules.Users.User.Model.Clases.Singleton;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;




public class miniSimpleTableModel_client extends AbstractTableModel {
    public static ArrayList<Class_client> datos = new ArrayList<Class_client>();
    public static ArrayList<Class_client> datosaux = new ArrayList<Class_client>();
    
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
        Class_client fila = (Class_client) datos.get(row);

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
        Class_client fila = (Class_client) datos.get(row);

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

    public void addRow(Class_client usu) {
        datos.add(usu);
        fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();
        Singleton.Client_array.clear();
        bll_client_db.select_client_bll();
        
        //Json.auto_open_json_client();
        
        Class_client cli= null;
        java.util.Date date= new java.util.Date();
        for(int i=0; i<=(Singleton.Client_array.size()-1) ;i++) {
            cli=Singleton.Client_array.get(i);
            addRow(cli);
            datosaux.add(cli);
            
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
            pager_client.jLabel3.setText(String.valueOf(cont));
            System.out.println("word selected: " + name);
            pagina_client.initLinkBox();
        }
    }

    public Class_client buscar(String adm) {
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

    public int buscaUsuario(Class_client adm) {
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
