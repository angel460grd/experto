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
    public float[] puntoI=new float[2],puntoF=new float[2];
    public ArrayList<float[]> listaPuntos=new ArrayList<>();
    public  int puntoCritico;
    //no se guardara en archivo
    transient float gradoMembresia=0;

  
    //public  int puntoI,puntoF;

    public Etiqueta(String n,float[] pi,float[] pf,ArrayList<float[]>   lp){
        nombre=n;
        puntoI=pi;
        puntoF=pf;
        listaPuntos=lp;
    }

    public Etiqueta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Etiqueta(String n){
    nombre=n;
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

    public float getGradoMembresia() {
        return gradoMembresia;
    }

    public void setGradoMembresia(int gradoMembresia) {
        this.gradoMembresia = gradoMembresia;
    }

    public float[]  getPuntoI() {
        return puntoI;
    }

    public void setPuntoI(float[] puntoI) {
        this.puntoI = puntoI;
    }

    public float[]  getPuntoF() {
        return puntoF;
    }

    public void setPuntoF(float[]  puntoF) {
        this.puntoF = puntoF;
    }

    public ArrayList<float[] > getListaPuntos() {
        return listaPuntos;
    }

    public void setListaPuntos(ArrayList<float[] > listaPuntos) {
        this.listaPuntos = listaPuntos;
    }


    public void  gradoMembresia(float valorReal )
    {   
        //esta dentro del rango la etiqueta
        if(valorReal>=puntoI[0]&&valorReal<=puntoF[0])
        {
            float[] puntoSeg2=listaPuntos.get(0);
            float[] puntoSeg1;
            for(int i=1;i<listaPuntos.size();i++)
            {
                puntoSeg1=puntoSeg2;
                puntoSeg2=listaPuntos.get(i);
                if(valorReal>=puntoSeg1[0]&&valorReal<=puntoSeg2[0])
                {
                    float pendiente=(puntoSeg2[1]-puntoSeg1[1])/(puntoSeg2[0]-puntoSeg1[0]);
                    //sustituyo punto2 por un puto (valorReal,gradoMemvresia)
                    this.gradoMembresia=pendiente*(valorReal-puntoSeg1[0])+puntoSeg1[1];
                    //si ya encontre grado membresia no es nesesario seguir recorriendo los puntos
                    break;
                }
            }
            //para caso exepcional donde esta dentro de rango, pero no esta dentro de algun segmento
            this.gradoMembresia=0;
        }
        else
            this.gradoMembresia=0;
    }
    public float  gmX(float valorReal )
    {   
        //esta dentro del rango la etiqueta
        if(valorReal>=puntoI[0]&&valorReal<=puntoF[0])
        {
            float[] puntoSeg2=listaPuntos.get(0);
            float[] puntoSeg1;
            for(int i=1;i<listaPuntos.size();i++)
            {
                puntoSeg1=puntoSeg2;
                puntoSeg2=listaPuntos.get(i);
                if(valorReal>=puntoSeg1[0]&&valorReal<=puntoSeg2[0])
                {
                    float pendiente=(puntoSeg2[1]-puntoSeg1[1])/(puntoSeg2[0]-puntoSeg1[0]);
                    //sustituyo punto2 por un puto (valorReal,gradoMemvresia)
                    return pendiente*(valorReal-puntoSeg1[0])+puntoSeg1[1];
                    //si ya encontre grado membresia no es nesesario seguir recorriendo los puntos
                    
                }
               
            }
             //para caso exepcional donde esta dentro de rango, pero no esta dentro de algun segmento
             return 0;
        }
        else
            return 0;
    }
}
