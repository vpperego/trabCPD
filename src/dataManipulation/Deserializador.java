/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataManipulation;

import Classes.Area;
import Classes.Autor;
import Classes.Artigo;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Deserializador {

  

    public Autor achaAutor(String path, String nomeAutor) throws Exception {
        FileInputStream inFile = new FileInputStream(path);
        ObjectInputStream d = new ObjectInputStream(inFile);
        Autor aux = new Autor(nomeAutor);
        nomeAutor = nomeAutor.toUpperCase();
        aux = (Autor) d.readObject();
        try {
            while (aux != null) {

                if ((aux.getAutor().contains(nomeAutor))) {//CUIDADO- TROQUEI EQUALS POR CONTAINS
                    d.close();
                    return aux;
                }
                aux = (Autor) d.readObject();
            }

        } catch (EOFException e) {
            //we expect it so ignore
        }
        d.close();

        return null;
    }
 
    public Area achaArea(String path, String nomeArea, Area aux) throws Exception {
        //busca 4
        FileInputStream inFile = new FileInputStream(path);
        ObjectInputStream d = new ObjectInputStream(inFile);
        nomeArea = nomeArea.toUpperCase();
        aux = (Area) d.readObject();
        try {
            while (aux != null) {

                if ((aux.getNome().contains(nomeArea))) {//CUIDADO- TROQUEI EQUALS POR CONTAINS
                    d.close();
                    return aux;
                }
                aux = (Area) d.readObject();
            }

        } catch (EOFException e) {
            //we expect it so ignore
        }

        d.close();
        return null;

    }

    public ArrayList<Autor> busca4(String path, ArrayList<Integer> idArtigos) throws Exception{
        //bombando
        FileInputStream inFile = new FileInputStream(path);
        ObjectInputStream d = new ObjectInputStream(inFile);
        ArrayList<Autor> autores = new ArrayList<Autor>();
        
        Autor aut = (Autor) d.readObject();
        try {
            while (true) {
                //faz a intersecção dos idArtigo(geral) do autor com os idsArtigos validos para a area em questão
                aut.getArtigoTotal().retainAll(idArtigos);
                autores.add(aut);
                aut = (Autor) d.readObject();
            }
        } catch (EOFException e) {
            //we expect it so ignore
        }
        return autores;
    }
     
    public ArrayList<Artigo> artigosValidos(ArrayList<Integer> idValidos, String path) throws Exception {
        //pega os artigos de um determinado autor
        FileInputStream inFile = new FileInputStream(path);
        ObjectInputStream d = new ObjectInputStream(inFile);

        ArrayList<Artigo> artigosValidos = new ArrayList<Artigo>();
        int index = 0;
        Artigo art = (Artigo) d.readObject();

        try {
            while (index < idValidos.size()) {
                if (idValidos.get(index) == art.getId()) {
                    artigosValidos.add(art);
                    index++;
                }
                art = (Artigo) d.readObject();
            }
            if (index == 0) {
                art = null;
            }
        } catch (EOFException e) {
            //we expect it so ignore
        }
        /*
         while (art != null && index< idValidos.size()) {
         art = (Artigo) d.readObject();
         if (idValidos.get(index) == art.getId()) {
         artigosValidos.add(art);
         index++;
         }
         }
         */
        return artigosValidos;
    }

    public ArrayList<Artigo> artigosBusca3(String palavra, String path) throws Exception {
        //seleciona os artigos que contem a palavra no titulo
        FileInputStream inFile = new FileInputStream(path);
        ObjectInputStream d = new ObjectInputStream(inFile);
        palavra = palavra.toUpperCase();
        ArrayList<Artigo> artigosValidos = new ArrayList<Artigo>();
        
        Artigo art = (Artigo) d.readObject();
        try{
            while(true){
                if(art.getTitulo().contains(palavra)){
                    artigosValidos.add(art);
                }
                art = (Artigo) d.readObject();
            }
        }catch(EOFException e){
             //we expect it so ignore
        }
        
        return artigosValidos;
    }
    
    public ArrayList<Artigo> artigosValidosAno(ArrayList<Artigo> artigos, String ano) {
        //busca5
        ArrayList<Artigo> aux = new ArrayList<Artigo>();
        for (int i = 0; i < artigos.size(); i++) {
            if (artigos.get(i).getAno().equals(ano)) {
                aux.add(artigos.get(i));
            }
        }
        return aux;
    }
}
