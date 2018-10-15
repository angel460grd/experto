/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package difuso;

import java.util.ArrayList;
import javafx.scene.chart.XYChart;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;

/**
 *
 * @author miguel
 */
public class Graficas {

    public static void main(String[] args) throws Exception {

        control c = new control();

//        c.limiarCompetencias();        
        ArrayList<Integer> competencias = new ArrayList<>();
        ArrayList<Competencia> compe = c.cargarCompetencias();

        System.out.println(""+compe.size());


//          org.knowm.xchart.XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);
            // Show it
    
            
                
            }
    
        
    }
 
    


