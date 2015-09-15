/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.File;
import javax.swing.filechooser.*;

/**
 *
 * @author vpperego
 */
public class filtroArq extends FileFilter {
    private String formatoEntrada = "csv";
    private char dotIndex = '.';
    public boolean accept(File F) {
        if(F.isDirectory()){
            return true;
        }
        if(extension(F).equalsIgnoreCase(formatoEntrada)){
            return true;
        } else
            return false;
    }

     public String getDescription() {
        return "Arquivo CSV(.csv)";
    }
    public String extension(File F){
        String FileName = F.getName();
        int indexFile = FileName.lastIndexOf(dotIndex);
        if(indexFile > 0 && indexFile < FileName.length()-1){
            return FileName.substring(indexFile+1);
        }else
            return "";
    }
    
}
