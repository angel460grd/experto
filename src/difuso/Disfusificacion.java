/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package difuso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

/**
 *
 * @author miguel
 */
public class Disfusificacion {

    public static int puntoInicial = 0;
    public static int puntoCritico = -1;
    public static int puntoFinal = 0;
    public static int competencia = 0;
    public static int translape = 0;
    public static Competencia comp;
    public static Etiqueta a;
    public static float NumReal = 0;

    public ArrayList<Etiqueta> v = new ArrayList<>();

    public ArrayList<Competencia> c = new ArrayList<>();

    public void Disfusificar() {

        competencia = Integer.parseInt(JOptionPane.showInputDialog("Elige un antecedente (competencia) :"
                + "\n 1.-Habilidad de Analisis y sintesis "
                + "\n 2.- Habilidad de investigacion "
                + "\n 3.- Capacidad e poner en practica el conocimiento  "));

        if (competencia != 0) {
            int etiqueta = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la etiqueta"));

            if (competencia != 0) {
                puntoCritico = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el punto critico "));

                int auxPuntoCritico = Integer.parseInt(JOptionPane.showInputDialog("Deseas ingresar otro punto critico \n 1.- SI \n 2.- NO"));
                while (puntoCritico != -1) {

                    String nombreCompetencia = comp.getNombre();
                    String nombreEtiqueta = comp.getEtiquetas().get(etiqueta).getNombre();

                    v.add(new Etiqueta(nombreEtiqueta, 0, 1, 5));
                    c.add(new Competencia(nombreCompetencia, v));

                    auxPuntoCritico = Integer.parseInt(JOptionPane.showInputDialog("Deseas ingresar otro punto critico \n 1.- SI \n 2.- NO"));
                    if (auxPuntoCritico == 2) {
                        puntoCritico = -1;
                    } else {
                        puntoCritico = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el punto critico "));

                    }

                }

            }
            int valorReal = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el unto critico"));
        }

        translape = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el translape"));

        puntoCritico = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el unto critico"));
        puntoCritico = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el unto critico"));

    }

    public void ingresar() {
        String nombreCompetencia = (JOptionPane.showInputDialog("Ingresa el nombre de la competetncia "));
        translape = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el translape"));

        ArrayList<Integer> puntosCriticos = new ArrayList<>();

        String nombreEtiqueta = (JOptionPane.showInputDialog("Ingresa la etiqueta"));

        while (nombreEtiqueta != "") {
            puntoCritico = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el punto critico "));
            puntosCriticos.add(new Integer(puntoCritico));

            v.add(new Etiqueta(nombreEtiqueta, 0, 0, puntoCritico));
            c.add(new Competencia(nombreCompetencia, v));

            int auxPuntoCritico = Integer.parseInt(JOptionPane.showInputDialog("Deseas ingresar otro punto critico \n 1.- SI \n 2.- NO"));
            while (puntoCritico != -1) {

                v.add(new Etiqueta(nombreEtiqueta, 0, 0, puntoCritico));
                c.add(new Competencia(nombreCompetencia, v));

                auxPuntoCritico = Integer.parseInt(JOptionPane.showInputDialog("Deseas ingresar otro punto critico \n 1.- SI \n 2.- NO"));
                if (auxPuntoCritico == 2) {
                    puntoCritico = -1;
                } else {
                    puntoCritico = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el punto critico "));

                }

            }

            auxPuntoCritico = Integer.parseInt(JOptionPane.showInputDialog("Deseas ingresar otra etiqueta  \n 1.- SI \n 2.- NO"));
            if (auxPuntoCritico == 2) {
                nombreEtiqueta = "";
            } else {
                nombreEtiqueta = (JOptionPane.showInputDialog("Ingresa la etiqueta"));

            }

        }

        int cont = 1;

        for (Competencia cmp : c) {
            ArrayList<Etiqueta> e = new ArrayList<>();
            e = c.get(competencia).Etiquetas;
            Collections.sort(e, new Comparator() {
                public int compare(Etiqueta p1, Etiqueta p2) {
                    return new Integer(p1.puntoCritico).compareTo(new Integer(p2.puntoCritico));
                }

                @Override
                public int compare(Object o1, Object o2) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }                
                
            });

            for (Etiqueta et : e) {

                et.setPuntoI(et.getPuntoCritico());

            }

        }

    }

}
