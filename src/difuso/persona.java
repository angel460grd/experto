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
public class persona implements Serializable {
    
    private String nombre_casa;
    private  int cantidad_habitaciones;
    public ArrayList<Etiqueta> etiquetas;
    public persona( int cantidad_habitaciones, String nombre_casa ){
        this.cantidad_habitaciones = cantidad_habitaciones;
        this.nombre_casa = nombre_casa;
        etiquetas=new ArrayList<>();
    }
    private void agregarE(Etiqueta eti)
    {
        etiquetas.add(eti);
    }
    public String getNombre_casa() {
        return nombre_casa;
    }

    public int getCantidad_habitaciones() {
        return cantidad_habitaciones;
    }
    
    
}
