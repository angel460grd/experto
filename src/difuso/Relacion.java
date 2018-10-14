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
   ArrayList<Competencia> Antecedentes;
    public Relacion(Competencia Consecuente, ArrayList<Competencia> Antecedentes) {
        this.Consecuente = Consecuente;
        this.Antecedentes = Antecedentes;
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
            float aux=c.get(vector.Antecedentes.get(0)[0]).Etiquetas.get(vector.Antecedentes.get(0)[1]).gradoMembresia;
            for(int i=1;i<vector.Antecedentes.size();i++)
            {   // si hay un antesedente con un grado de membresia menor cambia valor de aux
                float gmAntesedente=c.get(vector.Antecedentes.get(i)[0]).Etiquetas.get(vector.Antecedentes.get(i)[1]).gradoMembresia;
                if(aux<gmAntesedente )
                    aux=gmAntesedente;
            }
            //de los minimos de cada vector, ve salvando el mayor
            if(aux>Consecuente.Etiquetas.get(vector.EtiquetaConsecuente).gradoMembresia)
                Consecuente.Etiquetas.get(vector.EtiquetaConsecuente).gradoMembresia=aux;
        }
    }
    public void crearFamVectores()
    {
        Vectores=new ArrayList<>();
        for(int i=0;i<Antecedentes.get(0).Etiquetas.size();i++)
        {
            Vector vec=new Vector();
            vec.AgregarAntecedente(new int[]{0,i});
            Vectores.add(vec);
        }
        for(int j=1;j<Antecedentes.size() ;j++)
        {
            ArrayList<Vector> aux2=new ArrayList<>();
            for (Vector aux1 : Vectores) {
                for (int i = 0; i<Antecedentes.get(j).Etiquetas.size(); i++) {
                    Vector vec = new Vector();
                    for(int[] ant:  aux1.Antecedentes)
                        vec.AgregarAntecedente(ant);
                    vec.AgregarAntecedente(new int[]{j,i});
                    aux2.add(vec);
                }
            }
            Vectores=aux2;
        }
    }
    public String mostrarRegla(Vector vec)
    {
        String regla="si ";
        for(int[] antecedente:vec.Antecedentes)
            regla+=Antecedentes.get(antecedente[0]).getNombre()+" es "+Antecedentes.get(antecedente[0]).Etiquetas.get(antecedente[1]).getNombre()+" ";
        return regla;
    }
    
}
