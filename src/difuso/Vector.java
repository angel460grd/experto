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
public class Vector implements Serializable {
   public int EtiquetaConsecuente;
   // no esnesesario una lista solo un areglo sin definir tamaño
   //la segunda dimencion tiene dos campos 0 id competencia antesedente id de su etiqueta
   public ArrayList<int []> Antecedentes;

    public Vector(int EtiquetaConsecuente, ArrayList<int[]> Antecedentes) {
        this.EtiquetaConsecuente = EtiquetaConsecuente;
        this.Antecedentes = Antecedentes;
    }

    public Vector(ArrayList<int[]> Antecedentes) {
        this.Antecedentes = Antecedentes;
    }
    public Vector()
    {
        Antecedentes=new ArrayList<>();
    }
    public void AgregarAntecedente(int[] ant)
    {
        Antecedentes.add(ant);
    }

    public void setEtiquetaConsecuente(int EtiquetaConsecuente) {
        this.EtiquetaConsecuente = EtiquetaConsecuente;
    }
}
