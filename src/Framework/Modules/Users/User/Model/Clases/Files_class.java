/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework.Modules.Users.User.Model.Clases;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Javier
 */
public class Files_class extends FileFilter {

    private String[] extension;
    private String descripcion;

    public Files_class(String[] exten, String descrip) {

        this.extension = exten;
        this.descripcion = descrip;
    }

    public boolean accept(File archivo) {

        if (archivo != null) {

            if (archivo.isDirectory()) {
                return true;
            }
            for (int i = 0; i < extension.length; i++) {
                if (this.getExtension(archivo).equals(extension[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getDescription() {
        return descripcion;
    }

    public String getExtension(File archivo) {

        String nombreArchivo;

        int i;

        if (archivo != null) {

            nombreArchivo = archivo.getName();
            i = nombreArchivo.lastIndexOf(".");

            if (i > 0 && i < (nombreArchivo.length() - 1)) {
                return nombreArchivo.substring(i + 1).toLowerCase();
            }
        }
        return "";
    }
}