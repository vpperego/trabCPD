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
class ComparadorDecrescente implements java.util.Comparator {
    public int compare(Object o1, Object o2){  
    Autor c1 = (Autor) o1;  
    Autor c2 = (Autor) o2;  
  
     return c2.getArtigoTotal().size() - c1.getArtigoTotal().size();  
  } 
}
