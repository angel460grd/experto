/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package difuso;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class Difuso {

    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args)  {
        
        ArrayList<Competencia> competencias=new ArrayList<>(); 
        
        ArrayList<float[]> puntos=new ArrayList<>();
        puntos.add(new float[]{0,1});
        puntos.add(new float[]{50,1});
        puntos.add(new float[]{60,0});
        Etiqueta e1=new Etiqueta("malo",
               new float[]{0,1},
                new float[]{60,0},puntos);
        puntos=new ArrayList<>();
        puntos.add(new float[]{50,0});
        puntos.add(new float[]{60,1});
        puntos.add(new float[]{70,1});
        puntos.add(new float[]{80,0});
        Etiqueta e2=new Etiqueta("regular",
                new float[]{50,0},
                new float[]{80,0},puntos);
        puntos=new ArrayList<>();
        puntos.add(new float[]{70,0});
        puntos.add(new float[]{80,1});
        puntos.add(new float[]{100,1});
        Etiqueta e3=new Etiqueta("bueno",
                new float[]{70,0},
                new float[]{100,1},puntos);
        Competencia a1 = new Competencia("CAS");
        a1.agregarE(e1);
        a1.agregarE(e2);
        a1.agregarE(e3);
        a1.ValorReal=79;
        a1.difusicar();
        competencias.add(a1);
        for(Etiqueta e:a1.Etiquetas)
            System.out.println("e:" +e.getNombre()+" gm: "+e.getGradoMembresia());
        puntos=new ArrayList<>();
        puntos.add(new float[]{0,1});
        puntos.add(new float[]{40,1});
        puntos.add(new float[]{50,0});
        e1=new Etiqueta("malo",
               new float[]{0,1},
                new float[]{50,0},puntos);
        puntos=new ArrayList<>();
        puntos.add(new float[]{40,0});
        puntos.add(new float[]{50,1});
        puntos.add(new float[]{70,1});
        puntos.add(new float[]{80,0});
        e2=new Etiqueta("regular",
                new float[]{40,0},
                new float[]{80,0},puntos);
        puntos=new ArrayList<>();
        puntos.add(new float[]{70,0});
        puntos.add(new float[]{80,1});
        puntos.add(new float[]{100,1});
        e3=new Etiqueta("bueno",
                new float[]{70,0},
                new float[]{100,1},puntos);
        a1 = new Competencia("HI");
        a1.agregarE(e1);
        a1.agregarE(e2);
        a1.agregarE(e3);
        a1.ValorReal=79;
        a1.difusicar();
        competencias.add(a1);
        for(Etiqueta e:a1.Etiquetas)
            System.out.println("e:" +e.getNombre()+" gm: "+e.getGradoMembresia());
        
        
        puntos=new ArrayList<>();
        puntos.add(new float[]{0,1});
        puntos.add(new float[]{40,1});
        puntos.add(new float[]{60,0});
        e1=new Etiqueta("malo",
               new float[]{0,1},
                new float[]{60,0},puntos);
        puntos=new ArrayList<>();
        puntos.add(new float[]{40,0});
        puntos.add(new float[]{60,1});
        puntos.add(new float[]{80,0});
        e2=new Etiqueta("regular",
                new float[]{40,0},
                new float[]{80,0},puntos);
        puntos=new ArrayList<>();
        puntos.add(new float[]{60,0});
        puntos.add(new float[]{80,1});
        puntos.add(new float[]{100,1});
        e3=new Etiqueta("bueno",
                new float[]{60,0},
                new float[]{100,1},puntos);
        a1 = new Competencia("CAP");
        a1.agregarE(e1);
        a1.agregarE(e2);
        a1.agregarE(e3);
        
        Relacion CAP=new Relacion(a1,competencias);
        
        
        
        
//  persona a2 = new persona(10,"Pérez");
//  a2.agregarE(e3);
  control c=new control();
  c.crearReglas(CAP);
//        c.guardar(a1);
//        c.guardar(a2);
        /*
        ArrayList<Competencia> competencias=c.cargarCompetencias();
        for(Competencia p:competencias)
        {
            
            System.out.println("h"+p.getNombre());
            for(Etiqueta e:p.getEtiquetas())
                System.out.println(e.nombre);
        }
       */
    
}
}
