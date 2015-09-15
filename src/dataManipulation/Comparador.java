/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataManipulation;

import Classes.Artigo;

/**
 *
 * @author hp
 */
public class Comparador implements java.util.Comparator{
    
    public int compare(Object o1, Object o2){  
        Artigo a1 = (Artigo) o1;  
        Artigo a2 = (Artigo) o2;  
  
        return a1.getTitulo().compareTo(a2.getTitulo());  
  }  
}