/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package difuso;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 123456
 */
public class CRUD {
     static RandomAccessFile entrada;
    static RandomAccessFile entradaI;
    static int tamReg = 455;
    static int tamAnt = 17;
    static int tamRegI = 8;
    static CRUD formato;
    File archivo = new File("Competencias");
    File archivoIndice = new File("indice");
    File bh= new File("Bitacora");
    static int salto = 0;
    static int saltop=0;
    static int saltoI = 0;
    Scanner teclado = new Scanner(System.in);
    int dest = 10;
    int desicion;
    int posicion_logica,id;
    float puntox,puntoy;
ArrayList<float[]> puntos=new ArrayList<>();  
String Competencia,Etiquetas;
    List<String> hechos= new ArrayList<String>();
    List<BC<Object>> conocimiento = new ArrayList<BC<Object>>();
    BC consecuente=null;
    BC antecedente=null;
    
    /***********************Método para actualizar la base de conocimiento***************************************/
    public void escribir_Arch_Maestro(int desicion) {
        try {
            if (desicion == 1) {
                if (archivo.exists()) {
                    archivo.delete();
                    archivoIndice.delete();
                    System.out.println("Se elimino el archivo antiguo");
                    archivo = new File("Competencias");
                    archivoIndice = new File("indice");
                    System.out.println("Se creo el nuevo archivo");
                }
            }
            entrada = new RandomAccessFile(archivo, "rw");
            entradaI = new RandomAccessFile(archivoIndice, "rw");
            salto = (int) entrada.length() / tamReg;
            saltoI = (int) entradaI.length() / tamRegI;
            entrada.seek(salto * tamReg);
            entradaI.seek(saltoI * tamRegI);
            System.out.println("Escribiendo en el archivo maestro");
            do {
                int opcion = 0;
                while (opcion == 0) {
                    formato = new CRUD();
                    System.out.println("ID Competencia");
                    formato.id = teclado.nextInt();
                    opcion = leer_secuencial(formato.id);
                    if (opcion == 0) {
                        System.out.println("El ID ya esta en el archivo , Teclee otro id");
                    } else {
                        break;
                    }
                }
                System.out.println("ID de la regla es " + formato.getId());
                entrada.writeInt(formato.getId());
                entradaI.writeInt(formato.getId());
                System.out.println("Nombre competencia");
                formato.Competencia = (teclado.next());
                entrada.writeUTF(formato.getCompetencia());
                System.out.println("Etiquetas \n");
                do {
                    System.out.println("Etiquetas");
                    formato.Etiquetas = (teclado.next());
                    entrada.writeUTF(formato.getEtiquetas());
                    System.out.println("Cuantos puntos criticos ingresara? max= 2");
                    desicion = teclado.nextInt();
                    for(int i=0;i<desicion;i++){
                     
                        System.out.println("Punto critico : coordenada en x");
                        puntox= teclado.nextFloat();
                        entrada.writeFloat(puntox);
                        if(i==1&& desicion==2)
                        puntos.add(new float[]{puntox,entrada.getFilePointer()});
                         if(desicion==1)
                        puntos.add(new float[]{puntox,entrada.getFilePointer()});
                        
                        
                        if(desicion!=2)
                            entrada.seek(entrada.getFilePointer()+20);
                        else
                            entrada.seek(entrada.getFilePointer()+8);

                    }
                    System.out.println("Otro Etiqueta mas? Si=1, no =0");
                    desicion = teclado.nextInt();
                    dest--;
                    if (dest == 0) {
                        System.out.println("Se han excedido los antecedentes");
                        break;
                    }

                } while (desicion == 1);
        
                for(float []p:puntos){
                     
                }
                String sa = "x";
                formato.Etiquetas = (sa);
                System.out.println("Numeros de etiquetas restantes " + dest);
                if (dest > 0) {
                    for (int i = 1; i <= dest; i++) {
                        entrada.writeUTF(formato.getEtiquetas());
                    }
                }

                System.out.println("Quieres otra Competencia? Si=1, no=0");
                desicion = teclado.nextInt();
                dest = 7;
                posicion_logica = (int) entrada.length() / tamReg;
                entradaI.writeInt(posicion_logica);
            } while (desicion == 1);

            entrada.close();
            entradaI.close();
            System.out.println("Se escribio en el archivo");
        } catch (IOException w) {
            System.out.println("No se pudieron escribir los datos en el archivo");
        }
    }
    /**************************Método para dar de alta un hecho*****************************************/
    public void escribir_BH(String hecho) {
        try {
            entrada = new RandomAccessFile(bh, "rw");
            salto = (int) entrada.length() / 17;
            entrada.seek(salto * 17);
            System.out.println("Escribiendo en la base de Hechos");
            formato= new CRUD();
            formato.Etiquetas=hecho;
            entrada.writeUTF(formato.getEtiquetas());
            entrada.close();
            System.out.println("Se escribio en el archivo");
        } catch (IOException w) {
            System.out.println("No se pudieron escribir los datos en el archivo");
        }
    }
    /***************************Método para recuperar la base de hechos****************************************************/
    public List<String> leer_BH() throws IOException {
        try{
            entrada = new RandomAccessFile(bh, "rw");
            entrada.seek(0);
            formato = new CRUD();
            int registro = (int) entrada.length() / 17;
            //System.out.println("Hola "+ registro);
            while (registro > 0) {
                formato.Etiquetas = (entrada.readUTF());
                hechos.add(formato.getEtiquetas());
                registro--;
                //System.out.println(formato.getAntecedentes());
            }
            entrada.close();
        }catch (java.io.FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return hechos;
    }
    /*****************************************Método para recuperar la base de conocimiento***************************************************/
    public List<BC<Object>> leer_secuencial_maestro() throws IOException {
        conocimiento.clear();
        entrada = new RandomAccessFile(archivo, "r");
        entrada.seek(0);
        formato = new CRUD();
        String valor = "x";
        valor = String.format("%-15s", valor);
        long entradas = entrada.length();
        //System.out.println("Tamaño del archivo " + entradas);
        int registro = (int) entrada.length() / tamReg;
        //System.out.println(registro);
        int cont=0;
        while (registro > 0) {

            formato.id = (entrada.readInt());

            formato.Competencia=entrada.readUTF();
            //System.out.println(formato.Competencia);
            consecuente= new BC(formato.getCompetencia(),formato.id);

            if (formato.id > 0) {
                for (int i = 0; i < 7; i++) {
                    formato.Etiquetas = (entrada.readUTF());
                    if (valor.equalsIgnoreCase(formato.Etiquetas)) {
                    } else {
                        antecedente= new BC(formato.getEtiquetas());
                        consecuente.addAntecedent(antecedente);
                    }
                }
            } else {
                entrada.seek(entrada.getFilePointer() + 136);
            }
            registro--;
            conocimiento.add(consecuente);
        }
        entrada.close();
        return conocimiento;
    }


    public int leer_secuencial(int id) throws IOException {
        int id_repe = 1;
        RandomAccessFile entrada = new RandomAccessFile(archivo, "rw");
        CRUD formato = new CRUD();
        String valor = "x";
        valor = String.format("%-15s", valor);
        long entradas = entrada.length();
        int registro = (int) entrada.length() / tamReg;
        System.out.println(registro);
        entrada.seek(0);
        while (registro > 0) {
            formato.id = (entrada.readInt());

            if (formato.id > 0) {
                if (formato.id == id) {
                    id_repe = 0;
                    break;
                }
                formato.Competencia = (entrada.readUTF());
                for (int i = 0; i < 7; i++) {
                    formato.Etiquetas = (entrada.readUTF());
                }
            } else {
                entrada.seek(entrada.getFilePointer() + 136);
            }
            registro--;
        }
        entrada.close();
        return id_repe;
    }


    public void leer_aleatorio_maestro() throws IOException {
        int direccionLog = busqueda_indice();
        entrada.seek(direccionLog * tamReg);
        System.out.println("Entrada " + direccionLog);
        System.out.println("INFORMACION DE LA REGLA SOLICITADA");
        formato.id = entrada.readInt();
        System.out.println("ID-REGLA :" + formato.id);
        formato.Competencia = (entrada.readUTF());
        System.out.println("Antecendentes :");
        String com = "x";
        com = String.format("%-15s", com);
        for (int i = 0; i < 7; i++) {
            formato.Etiquetas = entrada.readUTF();
            if (com.equals(formato.Etiquetas)) {
            } else {
                System.out.println("Antecendentes " + (i + 1) + formato.Etiquetas);
            }
        }
        System.out.println("Consecuente: " + formato.Competencia);

        System.out.println();
        entrada.close();
        entradaI.close();
    }

    public void editar_archivo_maestro() throws IOException {
        int direccionLog = busqueda_indice();
        System.out.println("El indice es " + direccionLog);
        int desicion;
        formato = new CRUD();
        CRUD formato2 = new CRUD();
        int destinospuntero = (direccionLog * tamReg) + 4;
        entrada.seek(destinospuntero);
        System.out.println("Que quieres modificar? 1=Consecuente,2=Antecedentes");
        desicion = teclado.nextInt();
        if (desicion == 1) {
            System.out.println("Que quieres modificar del origen?  1-Clave 2.- Nombre");
            int var = teclado.nextInt();
            if (var == 1) {
                int opcion = 0;
                entrada.seek(entrada.getFilePointer() - 4);
                formato.id = entrada.readInt();
                int id = formato.id;
                System.out.println("La Clave de la regla antiguo es : " + formato.id);
                while (opcion == 0) {
                    System.out.println("Dame el nuevo clave");
                    formato2.id = teclado.nextInt();
                    System.out.println("Se ha tecleado " + formato2.id);
                    if (formato2.id == id) {
                        entrada.seek(entrada.getFilePointer() - 4);
                        entrada.writeInt(id);
                        System.out.println("Se escribio el ID");
                        break;
                    } else {
                        opcion = leer_secuencial(formato2.id);
                        if (opcion == 0) {
                            System.out.println("ID duplicado Vuelve a teclear un ID");
                        } else {
                            entrada.seek(entrada.getFilePointer() - 4);
                            entrada.writeInt(formato2.id);
                            modificar_indice(id, formato2.id);
                            System.out.println("Se escribio el nuevo ID");
                            break;
                        }
                    }
                }
            } else {
                formato.Competencia = entrada.readUTF();
                System.out.println("El consecuente antiguo es : " + formato.Competencia);
                System.out.println("Dame el nuevo consecuente");
                formato2.Competencia = teclado.next();
                entrada.seek(entrada.getFilePointer() - 17);
                entrada.writeUTF(formato2.getCompetencia());
            }
        }
        if (desicion == 2) {
            System.out.println("Que destino deseas modificar?");
            int destin = teclado.nextInt();
            destin--;
            System.out.println("Antecedente no " + (destin + 1));
            entrada.seek(((direccionLog * tamReg) + 21) + (tamAnt * destin));
            formato.Etiquetas = entrada.readUTF();
            System.out.println("El Antecedente " + destin + " es : " + formato.Etiquetas );
            System.out.println("Nuevos Valores");
            System.out.println("Nombre");
            formato2.Etiquetas = teclado.next();
            entrada.seek((entrada.getFilePointer()) - tamAnt);
            entrada.writeUTF(formato2.getEtiquetas());
            System.out.println("Se modifico el destino");
        }
        entrada.close();
    }

    public void eliminar_archivo_maestro() throws IOException {
        int direccionLog = busqueda_indice();
        System.out.println("El indice es " + direccionLog);
        int desicion;
        formato = new CRUD();
        CRUD formato2 = new CRUD();
        int destinospuntero = (direccionLog * tamReg);
        entrada.seek(destinospuntero);
        System.out.println("Que quieres borrar? 1=Registro 2=Destinos");
        desicion = teclado.nextInt();
        if (desicion == 1) {
            busqueda_eliminar_indice(direccionLog);
            formato2.id = 0;
            entrada.writeInt(0);
            entrada.writeUTF(formato2.getCompetencia());

        }
        if (desicion == 2) {
            System.out.println("Que destino antecende borrar?");
            int destin = teclado.nextInt();
            destin--;
            System.out.println("Antecendetes no " + (destin + 1));
            entrada.seek(((direccionLog * tamReg) + 21) + (tamAnt * destin));
            formato.Etiquetas = entrada.readUTF();
            System.out.println("El antecedente " + destin + " es : " + formato.Etiquetas);
            formato2.Etiquetas = "x";

            entrada.seek((entrada.getFilePointer()) - tamAnt);
            entrada.writeUTF(formato2.getEtiquetas());
            System.out.println("Se elimino el destino");
        }
        entrada.close();
    }

    public int busqueda(int id) throws IOException {
        int direccionLog = 0;
        int reg, llave;
        formato = new CRUD();
        entradaI = new RandomAccessFile(archivoIndice, "rw");
        entrada = new RandomAccessFile(archivo, "rw");
        reg = (int) entradaI.length() / tamRegI;
        entradaI.seek(0);
        for (int e = 0; e < reg; e++) {
            llave = entradaI.readInt();
            direccionLog = entradaI.readInt();
            if (llave == id) {
                direccionLog--;
                break;
            }
        }
        entradaI.close();
        return direccionLog;
    }
    public int busqueda_indice() throws IOException {
        int direccionLog = 0, indice = 0;
        int nombre;
        int reg, llave;
        formato = new CRUD();
        entradaI = new RandomAccessFile(archivoIndice, "rw");
        entrada = new RandomAccessFile(archivo, "rw");
        System.out.println("Busqueda Aleatoria ");
        System.out.println("Dame el nombre del nodo que quieres buscar:");
        nombre = teclado.nextInt();
        indice = busqueda(nombre);
        return indice;
    }

    public void modificar_indice(int id, int id_final) throws IOException {
        int direccionLog = 0;
        int reg, llave;
        formato = new CRUD();
        entradaI = new RandomAccessFile(archivoIndice, "rw");
        entrada = new RandomAccessFile(archivo, "rw");
        reg = (int) entradaI.length() / tamRegI;
        entradaI.seek(0);
        for (int e = 0; e < reg; e++) {
            llave = entradaI.readInt();
            direccionLog = entradaI.readInt();
            System.out.println("La llave es " + llave);
            if (llave == id) {
                entradaI.seek(entradaI.getFilePointer() - 8);
                entradaI.writeInt(id_final);
                System.out.println("llave" + llave);
                break;
            }
        }
        entradaI.close();
    }
    public String getCompetencia() {
        Competencia=String.format("%-15s",Competencia);
        return Competencia;
    }
    public String getEtiquetas() {
        Etiquetas=String.format("%-15s",Etiquetas);
        return Etiquetas;
    }
    public int getId(){
        return id;
    }
     public float[] carcularpuntos(float puntoI,float puntocx, float traslape){
        traslape=traslape*puntoI;
      float  puntoini=puntocx-traslape;
      float puntof=puntocx+traslape;
      float []puntos= new float[]{puntoini,puntof};
      return puntos;
        
    }

    public void busqueda_eliminar_indice(int indice) throws IOException {
        int direccionLog = 0;
        int reg, llave;
        formato = new CRUD();
        CRUD formato2 = new CRUD();
        entradaI = new RandomAccessFile(archivoIndice, "rw");
        entrada = new RandomAccessFile(archivo, "rw");
        reg = (int) entradaI.length() / tamRegI;
        entradaI.seek(0);
        for (int e = 0; e < reg; e++) {
            llave = entradaI.readInt();
            direccionLog = entradaI.readInt();
            System.out.println("La llave es " + llave);
            if (direccionLog == indice) {
                direccionLog--;
                entradaI.seek(entradaI.getFilePointer() - 8);
                entradaI.writeInt(0);
                entradaI.writeInt(0);
                System.out.println("llave" + llave);
                break;
            }
        }
        entradaI.close();
    }


    public int busqueda_id(int id) throws IOException {//Recupera el id sin preguntar
        int direccionLog = 0;
        int indice = 0;
        int reg, llave;
        formato = new CRUD();
        CRUD formato = new CRUD();
        entradaI = new RandomAccessFile(archivoIndice, "rw");
        entrada = new RandomAccessFile(archivo, "rw");
        indice = id;
        reg = (int) entradaI.length() / tamRegI;
        entradaI.seek(0);
        for (int e = 0; e < reg; e++) {
            llave = entradaI.readInt();
            direccionLog = entradaI.readInt();
            if (llave == indice) {
                direccionLog--;
                break;
            }
        }
        entradaI.close();
        return direccionLog;
    }

    
}
