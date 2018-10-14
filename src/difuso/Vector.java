/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package difuso;

import java.io.Serializable;

/**
 *
 * @author lenovo
 */
public class Vector implements Serializable {
   public int EtiquetaConsecuente;
   // no esnesesario una lista solo un areglo sin definir tamaño
   //la segunda dimencion tiene dos campos 0 id competencia antesedente id de su etiqueta
   public int[][] Antesedentes;

    public Vector(int EtiquetaConsecuente, int[][] Antesedentes) {
        this.EtiquetaConsecuente = EtiquetaConsecuente;
        this.Antesedentes = Antesedentes;
    }

   

   
   
}
