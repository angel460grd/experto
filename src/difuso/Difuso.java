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
import javafx.scene.chart.Chart;
//import org.knowm.xchart.QuickChart;
//import org.knowm.xchart.SwingWrapper;
//import org.knowm.xchart.XYChart;

/**
 *
 * @author lenovo
 */
public class Difuso {

    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args)  {
        
                        //Form gui = new Form();
        //gui.setVisible(true);

        
        control c=new control();
        
//        c.limiarCompetencias();        
        ArrayList<Integer> competencias=new ArrayList<>(); 
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
        c.guardarCompetencias(a1);

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

        c.guardarCompetencias(a1);

        a1.ValorReal=83;
        a1.difusicar();
        
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
        c.guardarCompetencias(a1);
        /*
       */
        
        ArrayList<Competencia> compe=c.cargarCompetencias();
        for(Competencia p:compe)
        {
            
            System.out.println("h "+p.getNombre());
            System.out.println("Cantidad de etiquetas "+p.Etiquetas.size()+"\n");
            for(Etiqueta e:p.getEtiquetas())
                System.out.println("Etiqueta "+e.nombre);
        }
        
        
        compe.get(0).ValorReal=80;
        compe.get(0).difusicar();
        competencias.add(0);
        for(Etiqueta e:compe.get(0).Etiquetas)
            System.out.println("e:" +e.getNombre()+" gm: "+e.getGradoMembresia());
        
        compe.get(1).ValorReal=76;
        compe.get(1).difusicar();
        competencias.add(1);    
        for(Etiqueta e:compe.get(1).Etiquetas)
            System.out.println("e:" +e.getNombre()+" gm: "+e.getGradoMembresia());
        
        /*
        Relacion CAP=new Relacion(2,competencias);
        CAP.cargarAntesedentesYConsecuete(compe);
        c.crearReglas(CAP);
        c.limiarRelaciones();
        c.guardarRelacion(CAP);
        /*
        */
        ArrayList<Relacion> Relaciones=c.cargarRelaciones();
        Relacion CAP=Relaciones.get(0);
        System.out.println();
        CAP.cargarAntesedentesYConsecuete(compe);
        CAP.inferir();
        System.out.println(CAP.Antecedentes.get(0).Etiquetas.get(0).gradoMembresia);
        for(Etiqueta e:CAP.Consecuente.getEtiquetas())
                  System.out.println("e:" +e.getNombre()+" gm: "+e.getGradoMembresia());
        for(Vector v:CAP.Vectores)
            System.out.println(CAP.mostrarReglaCompleta(v));
        
        CAP.Consecuente.desdifusicar();
        System.out.println(" valor real es de "+CAP.Consecuente.Nombre+" es "+CAP.Consecuente.ValorReal);
        
        
        System.out.println("\n"+(double) CAP.getConsecuente().getEtiquetas().get(0).getPuntoI()[0]+"  "+
                  CAP.getConsecuente().getEtiquetas().get(0).getPuntoCritico()+"  "+
                  (double) CAP.getConsecuente().getEtiquetas().get(0).getPuntoF()[0]);
        
        
              double[] xData = new double[]{ (double) CAP.getConsecuente().getEtiquetas().get(0).getPuntoI()[0],
                  CAP.getConsecuente().getEtiquetas().get(0).getPuntoCritico(),
                  (double) CAP.getConsecuente().getEtiquetas().get(0).getPuntoF()[0]};
                double[] yData = new double[]{0.0,1.0,0.0};

              double[] xData1 = new double[]{ (double) CAP.getConsecuente().getEtiquetas().get(1).getPuntoI()[0],
                  CAP.getConsecuente().getEtiquetas().get(1).getPuntoCritico(),
                  (double) CAP.getConsecuente().getEtiquetas().get(1).getPuntoF()[0]};
                double[] yData1 = new double[]{1.0,1.0,0.0};

                double[] xData2 = new double[]{ (double) CAP.getConsecuente().getEtiquetas().get(2).getPuntoI()[0],
                  CAP.getConsecuente().getEtiquetas().get(2).getPuntoCritico(),
                  (double) CAP.getConsecuente().getEtiquetas().get(2).getPuntoF()[0]};
                double[] yData2 = new double[]{0.0,1.0,0.1};




                //org.knowm.xchart.XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);
                //org.knowm.xchart.XYChart chart1 = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData1, yData1);
                //org.knowm.xchart.XYChart chart2 = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData2, yData2);

                
//                ArrayList<Chart> chart = new ArrayList<>();
               
                
                //new SwingWrapper(chart).displayChart();
                //new SwingWrapper(chart1).displayChart();
                //new SwingWrapper(chart2).displayChart();
    
        
                
                
                
                
                
        
        
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
