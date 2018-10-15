/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package difuso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class control {
    public void limiar()
    {
        ArrayList<Competencia>personas=cargarCompetencias();
        try{
        FileOutputStream fs = new FileOutputStream("Competenicas.bin");//Creamos el archivo
        ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos
        os.writeObject(null);
        os.close();//Hay que cerrar siempre el archivo
      }catch(FileNotFoundException e){
        e.printStackTrace();
      }catch(IOException e){
        e.printStackTrace();}
    }
    
    public void guardarCompetencias( Competencia competencia )
    {
            ArrayList<Competencia>personas=cargarCompetencias();
            try{
            FileOutputStream fs = new FileOutputStream("Competenicas.bin");//Creamos el archivo
            ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos
            for(Competencia p:personas)
                os.writeObject(p);
            os.writeObject(competencia);//El método writeObject() serializa el objeto y lo escribe en el archivo
            os.writeObject(null);
            os.close();//Hay que cerrar siempre el archivo
          }catch(FileNotFoundException e){
            e.printStackTrace();
          }catch(IOException e){
            e.printStackTrace();}
    }
    public ArrayList<Competencia> cargarCompetencias()
    {
         ArrayList<Competencia> competencias=new ArrayList<>();
        try
        {
            File af = new File("Competenicas.bin");
            if(!af.exists())
                return competencias;
            FileInputStream fis = new FileInputStream(af);

            ObjectInputStream ois = new ObjectInputStream(fis);
            Competencia aux;
            do
            {
                aux=(Competencia)ois.readObject();
                if(aux!=null)
                     competencias.add(aux);//El método readObject() recupera el objeto

            }while(aux!=null);

            ois.close();
            fis.close();

        }catch(FileNotFoundException e){e.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        catch(ClassNotFoundException e){e.printStackTrace();}
            return competencias;
    }
    public void crearReglas(Relacion Rel)
    {
        Rel.crearFamVectores();
        String[] opciones=Rel.Consecuente.nombreEtiquetas();
        for(Vector vec:Rel.Vectores)
        {
            vec.EtiquetaConsecuente = JOptionPane.showOptionDialog(null, Rel.mostrarRegla(vec),
                "consecuente en"+Rel.Consecuente.getNombre(),
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            System.out.println(vec.EtiquetaConsecuente);
        }
    }
   
        
}
