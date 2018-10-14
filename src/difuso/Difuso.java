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
        control c=new control();
        
        //c.limiar();
        ArrayList<Competencia> competencias=new ArrayList<>(); 
       /*
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
        c.cargarCompetencias();

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
        c.cargarCompetencias();
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
        c.cargarCompetencias();
        
        */
        ArrayList<Competencia> compe=c.cargarCompetencias();
        for(Competencia p:compe)
        {
            
            System.out.println("h"+p.getNombre());
            for(Etiqueta e:p.getEtiquetas())
                System.out.println(e.nombre);
        }
        
        
        compe.get(0).ValorReal=80;
        compe.get(0).difusicar();
        competencias.add(compe.get(0));
        for(Etiqueta e:compe.get(0).Etiquetas)
            System.out.println("e:" +e.getNombre()+" gm: "+e.getGradoMembresia());
        
        compe.get(1).ValorReal=76;
        compe.get(1).difusicar();
        competencias.add(compe.get(1));
        for(Etiqueta e:compe.get(1).Etiquetas)
            System.out.println("e:" +e.getNombre()+" gm: "+e.getGradoMembresia());
        
        Relacion CAP=new Relacion(compe.get(2),competencias);
        c.crearReglas(CAP);
        CAP.inferir();
        for(Etiqueta e:CAP.Consecuente.getEtiquetas())
                  System.out.println("e:" +e.getNombre()+" gm: "+e.getGradoMembresia());
        for(Vector v:CAP.Vectores)
            System.out.println(CAP.mostrarReglaCompleta(v));
        /*
        ArrayList<Competencia> competencias=c.cargarCompetencias();
        for(Competencia p:competencias)
        {
            
            System.out.println("h"+p.getNombre());
            for(Etiqueta e:p.getEtiquetas())
                System.out.println(e.nombre);
        }
        
        /*
        
//        a1.ValorReal=20;
//        a1.ValorReal=75;
//        a1.difusicar();
//        competencias.add(a1);
//        for(Etiqueta e:a1.Etiquetas)
//            System.out.println("e:" +e.getNombre()+" gm: "+e.getGradoMembresia());
//        a1.ValorReal=20;
//        
//        a1.difusicar();
//        competencias.add(a1);
//        for(Etiqueta e:a1.Etiquetas)
//            System.out.println("e:" +e.getNombre()+" gm: "+e.getGradoMembresia());

       */
    
}
}
