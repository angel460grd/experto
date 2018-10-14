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
        
 //       etiqueta e1=new etiqueta("malo",
 //              new int[]{2,3},
 //               new int[]{50,1},new ArrayList<>io);
//        etiqueta e2=new etiqueta("bueno",
//                new int[]{2,3},
//                new int[]{50,1});
//        etiqueta e3=new etiqueta("bueno",
//                new int[]{2,3},
//                new int[]{50,1});
//        persona a1 = new persona(1 ,"Fernández");
//        a1.agregarE(e1);
//        a1.agregarE(e2);
//        
//  persona a2 = new persona(10,"Pérez");
//  a2.agregarE(e3);
  control c=new control();
//        c.guardar(a1);
//        c.guardar(a2);
        
        ArrayList<Competencia> competencias=c.cargarCompetencias();
        for(Competencia p:competencias)
        {
            
            System.out.println("h"+p.getNombre());
            for(Etiqueta e:p.getEtiquetas())
                System.out.println(e.nombre);
        }
       
    
}
}
