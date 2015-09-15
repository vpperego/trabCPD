/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Pittigliani
 */
public class Area implements Serializable {
    
    private String Nome;
    private ArrayList<Integer> idArtigos = new ArrayList<Integer>();
    //private ArrayList<Integer> idAutor = new ArrayList<Integer>();
    
    
    
    public String getNome() {
        return Nome;
    }
    
    public void setNome(String Nome) {
        this.Nome = Nome;
        
    }
    
    public ArrayList<Integer> getIdArtigosArray(){
        return this.idArtigos;
    }
    
    public int getIdArtigos(int index) {
        return idArtigos.get(index);
    }

    public void setIdArtigos(int novoArtigo) {
        idArtigos.add(novoArtigo);
    }
    
    
}
