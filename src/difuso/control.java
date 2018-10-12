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

/**
 *
 * @author lenovo
 */
public class control {
    public void guardar( persona casa_bulma )
    {
            ArrayList<persona>personas=cargarPersonas();
            try{
            FileOutputStream fs = new FileOutputStream("agenda.bin");//Creamos el archivo
            ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos
            for(persona p:personas)
                os.writeObject(p);
            os.writeObject(casa_bulma);//El método writeObject() serializa el objeto y lo escribe en el archivo
            os.writeObject(null);
            os.close();//Hay que cerrar siempre el archivo
          }catch(FileNotFoundException e){
            e.printStackTrace();
          }catch(IOException e){
            e.printStackTrace();
  }
    }
        public ArrayList<persona> cargarPersonas()
        {
             ArrayList<persona> personas=new ArrayList<>();
            try
            {
                File af = new File("agenda.bin");
                if(!af.exists())
                    return personas;
                FileInputStream fis = new FileInputStream(af);
                
                ObjectInputStream ois = new ObjectInputStream(fis);
                persona aux;
                do
                {
                    aux=(persona)ois.readObject();
                    if(aux!=null)
                         personas.add(aux);//El método readObject() recupera el objeto
                
                }while(aux!=null);
               
                ois.close();
                fis.close();

            }catch(FileNotFoundException e){e.printStackTrace();}
            catch(IOException e){e.printStackTrace();}
            catch(ClassNotFoundException e){e.printStackTrace();}
                return personas;
        }
        
}
