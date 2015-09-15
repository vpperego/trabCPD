/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataManipulation;

import Classes.Area;
import Classes.Artigo;
import Classes.Autor;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Serializador {

    public Serializador() {

    }

    public void serializarAutor(String path, ArrayList<Autor> obj) throws Exception {
        FileOutputStream outFile = new FileOutputStream(path);
        ObjectOutputStream s = new ObjectOutputStream(outFile);
        for (int i = 0; i < obj.size(); i++) {
            s.writeObject(obj.get(i));

        }
        outFile.close();
        s.close();
    }
    public void serializarArea(String path, ArrayList<Area> obj) throws Exception {
        FileOutputStream outFile = new FileOutputStream(path);
        ObjectOutputStream s = new ObjectOutputStream(outFile);
        for (int i = 0; i < obj.size(); i++) {
            s.writeObject(obj.get(i));

        }
        outFile.close();
        s.close();
    }
    public void serializarArtigo(String path, ArrayList<Artigo> obj) throws Exception {
        FileOutputStream outFile = new FileOutputStream(path);
        ObjectOutputStream s = new ObjectOutputStream(outFile);
        for (int i = 0; i < obj.size(); i++) {
            s.writeObject(obj.get(i));
                
        }
        outFile.close();
        s.close();
    }

}
