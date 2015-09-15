/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataManipulation;

import Classes.Autor;

/**
 *
 * @author hp
 */
public class ComparadorAutor implements java.util.Comparator{
    
    public int compare(Object o1, Object o2){  
        Autor a1 = (Autor) o1;  
        Autor a2 = (Autor) o2;  
  
        return a1.getAutor().compareTo(a2.getAutor());  
  }  
}