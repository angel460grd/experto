/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package difuso;

import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class Competencia {
    public String Nombre;
    ArrayList<Etiqueta> Etiquetas;
    float ValorReal;

    public Competencia(String Nombre, ArrayList<Etiqueta> Etiquetas) {
        this.Nombre = Nombre;
        this.Etiquetas = Etiquetas;
        this.ValorReal = ValorReal;
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

    public void setEtiquetas(ArrayList<Etiqueta> Etiquetas) {
        this.Etiquetas = Etiquetas;
    }

    public boolean difusicar()
    {
        return true;
    }
    public boolean desdifusicar()
    {
        return true;
    }
}
