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
 * @author hp
 */
public class Artigo implements Serializable {
    
    private static final long serialVersionUID = 7700455490594805711L;
    private int id;
    private String ano;
    private String titulo;
    private String area;
    private ArrayList<String> Autor = new ArrayList<String>();

    public Artigo(int id, String ano, String titulo, String area){
        this.id = id;
        this.ano = ano;
        this.titulo = titulo;
        this.area = area;
    }
    
    public ArrayList<String> getAutor() {
        return Autor;
    }

    //Recebe o buffer de leitura do .csv e adiciona todos os autores
    public void setAutor(String []arrAutor,int tamString) {
        for(int i=21;i<tamString;i+=2)
            Autor.add(arrAutor[i]);
   }
     
  
    public void setId(int a){
        this.id = a;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setTitulo(String a){
        this.titulo = a;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
 
    public void setArea(String a){
        this.area = a;
    }
      
    public String getArea(){
        return this.area;
    }
    
    public void setAno(String a){
        this.ano = a;
    }
    
    public String getAno(){
        return this.ano;
    }  


}
