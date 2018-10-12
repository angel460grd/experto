/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package difuso;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class Etiqueta implements Serializable{
   public String nombre;
    public int[] puntoI=new int[2],puntoF=new int[2];
    public ArrayList<int[][]> listaPuntos=new ArrayList<>();
    //no se guardara en archivo
    transient int gradoMembresia;
    public Etiqueta(String n,int[] pi,int[] pf,ArrayList<int[][]>lp){
        nombre=n;
        puntoI=pi;
        puntoF=pf;
        listaPuntos=lp;
    }
    public float  gradoMembresia()
    {
        return 0;
    }
    
}
