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
public class Relacion implements Serializable
{
   Competencia Consecuente;
   ArrayList<Vector> Vectores;

    public Relacion(Competencia Consecuente, ArrayList<Vector> Vectores) {
        this.Consecuente = Consecuente;
        this.Vectores = Vectores;
    }

    public Competencia getConsecuente() {
        return Consecuente;
    }

    public void setConsecuente(Competencia Consecuente) {
        this.Consecuente = Consecuente;
    }

    public ArrayList<Vector> getVectores() {
        return Vectores;
    }

    public void setVectores(ArrayList<Vector> Vectores) {
        this.Vectores = Vectores;
    }
    public void inferir(ArrayList<Competencia> c)
    {   //recorre todos los vectores de la relacion
        for(Vector  vector:Vectores)
        {   //el primer antesedente es el minimo de los antesedentes, en la primer iteracion
            float aux=c.get(vector.Antesedentes[0][0]).Etiquetas.get(vector.Antesedentes[0][1]).gradoMembresia;
            for(int i=1;i<vector.Antesedentes.length;i++)
            {   // si hay un antesedente con un grado de membresia menor cambia valor de aux
                float gmAntesedente=c.get(vector.Antesedentes[i][0]).Etiquetas.get(vector.Antesedentes[i][1]).gradoMembresia;
                if(aux<gmAntesedente )
                    aux=gmAntesedente;
            }
            //de los minimos de cada vector, ve salvando el mayor
            if(aux>Consecuente.Etiquetas.get(vector.EtiquetaConsecuente).gradoMembresia)
                Consecuente.Etiquetas.get(vector.EtiquetaConsecuente).gradoMembresia=aux;
        }
    }
    
}
