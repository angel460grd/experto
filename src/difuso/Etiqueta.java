/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package difuso;

import java.io.Serializable;
import java.util.ArrayList;

public class Etiqueta implements Serializable{
   public String nombre;
    //public int[] puntoI=new int[2],puntoF=new int[2];
    public ArrayList<Integer> listaPuntos=new ArrayList<>();
    public  int puntoCritico;
    //no se guardara en archivo
    transient int gradoMembresia;

  
    public  int puntoI,puntoF;

    public Etiqueta(String n,int pi,int pf,int   lp){
        nombre=n;
        puntoI=pi;
        puntoF=pf;
        listaPuntos.add(lp);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntoCritico() {
        return puntoCritico;
    }

    public void setPuntoCritico(int puntoCritico) {
        this.puntoCritico = puntoCritico;
    }

    public int getGradoMembresia() {
        return gradoMembresia;
    }

    public void setGradoMembresia(int gradoMembresia) {
        this.gradoMembresia = gradoMembresia;
    }

    public int getPuntoI() {
        return puntoI;
    }

    public void setPuntoI(int puntoI) {
        this.puntoI = puntoI;
    }

    public int getPuntoF() {
        return puntoF;
    }

    public void setPuntoF(int puntoF) {
        this.puntoF = puntoF;
    }

    public ArrayList<Integer> getListaPuntos() {
        return listaPuntos;
    }

    public void setListaPuntos(ArrayList<Integer> listaPuntos) {
        this.listaPuntos = listaPuntos;
    }


    public float  gradoMembresia()
    {   
        return 0;
    }
    
}
