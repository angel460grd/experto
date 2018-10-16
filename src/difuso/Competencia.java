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
public class Competencia implements Serializable{
    public String Nombre,centroide;

   
    ArrayList<Etiqueta> Etiquetas;
    transient float ValorReal;

    public Competencia(String Nombre, ArrayList<Etiqueta> Etiquetas) {
        this.Nombre = Nombre;
        this.Etiquetas = Etiquetas;
        this.ValorReal = 0;
    }
    public Competencia(String Nombre)
    {
        Etiquetas=new ArrayList<>();
        this.Nombre = Nombre;
    }
    
    public void agregarE(Etiqueta eti)
    {
        Etiquetas.add(eti);
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return Etiquetas;
    }
    //para el momento de pedir llenar la matriz fAM
    public String[] nombreEtiquetas()
    {
        String[] etiquetas=new String[Etiquetas.size()];
        for (int i = 0; i < etiquetas.length; i++)
            etiquetas[i]=Etiquetas.get(i).getNombre();
        return etiquetas;
    }
    public void setEtiquetas(ArrayList<Etiqueta> Etiquetas) {
        this.Etiquetas = Etiquetas;
    }

    public void difusicar()
    {
        for(Etiqueta e:Etiquetas)
            e.gradoMembresia(ValorReal);
    }

  public String getCentroide() {
        return centroide;
    }

    public void setCentroide(String centroide) {
        this.centroide = centroide;
    }
    public void desdifusicar()
    {   
        centroide="\nCentroide ";
        ValorReal=0;
        float x=0,divisor=0,dividendo=0;
        while(x<100)
        {
            float yx=0;
            for(Etiqueta e:Etiquetas)
            {   
                centroide=centroide+"Etiqueta "+e.getNombre();
                float gmDifuso=e.gradoMembresia,gmX=e.gmX(x);
        
                    if(gmDifuso<gmX&&yx<gmX)
                    {yx=gmDifuso;
                     centroide=centroide+"\ngmDifuso "+gmDifuso+"gmX "+gmX+ "yx "+yx;}
                    else
                        if(yx<gmX){
                            yx=gmX; 
                         centroide=centroide+"\ngmDifuso "+gmDifuso+" gmX "+gmX+ " yx "+yx;
                        }   
            }
            divisor+=yx*x;
            dividendo+=yx;
            x++;
        }
         centroide=centroide+"\nDivisor "+divisor+ "Dividendo "+dividendo;
        ValorReal=divisor/dividendo;
    }
}
