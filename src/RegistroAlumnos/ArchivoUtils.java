/**
 * Institución: Universidad Veracruzana
 * Programa Educativo: Ingeniería de Software
 * Descripción: 
 * Modificación: 
 * 
 * @author Victor Niño
 * @version 1.0
 * @since 2019/02/15
 */
package RegistroAlumnos;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Vik-t
 */
public class ArchivoUtils {
    
    /**
     * Escribe en archivo de texto el contenido de lo que se recibe.
     * @param nombreArchivo recibe el nombre que recibira el archivo de texto
     * para ser creado o actualizado.
     * @param agregarfinal recibe un valor booleano para saber en que parte 
     * del archivo de texto ubicarse para guardar los datos.
     * @param contenido son los datos que serán guardados en el arcivo de texto.
     * @throws IOException 
     */
    public static void escribirEnArchivo(String nombreArchivo, 
            boolean agregarfinal, String contenido) throws IOException{
        File archivo = new File(nombreArchivo+".txt");
        FileWriter w = new FileWriter(archivo, agregarfinal);
        BufferedWriter bw = new BufferedWriter(w);
        PrintWriter wr = new PrintWriter(bw);
        wr.append(contenido+"\n");
        wr.close();
        bw.close();
    }
    
    /**
     * Obtiene la informacion que se encuentra guardada en una linea del
     * archivo de texto.
     * @param nombreArchivo recibe el nombre que recibira el archivo de texto
     * para ser creado o actualizado.
     * @param numlinea recibe el numero de linea que se va a leer.
     * @return regresa el contenido de la linea especifica del archivo.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static String leerArchivoLinea(String nombreArchivo, 
            int numlinea) throws FileNotFoundException, IOException{
        String resultado = null;
        File archivo = new File(nombreArchivo+".txt");
        boolean existe = archivo.exists();
        if(existe){
            String linea = "";
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
            int num = 1;
            while((linea = b.readLine())!= null){
                if(num == numlinea){
                    resultado = linea;
                    break;
                }
                num++;
            }
            b.close();
        }
        return resultado;
    }
    
    /**
     * Obtiene toda la información que se encuentra guardada en el archivo de 
     * texto.
     * @param nombreArchivo recibe el nombre que recibira el archivo de texto
     * para ser creado o actualizado.
     * @return regresa el contenido de todo el archivo de texto.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static List<String> leerArchivoTodo(String nombreArchivo) 
            throws FileNotFoundException, IOException{
        List<String> contenido = new ArrayList<String>();
        File archivo = new File(nombreArchivo+".txt");
        boolean existe = archivo.exists();
        if(existe){
            String linea = "";
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
            while((linea = b.readLine())!= null){
                contenido.add(linea);
            }
            b.close();
        }
        return contenido;
    }
    
    /**
     * Elimina el archivo de texto.
     * @param nombreArchivo recibe el nombre que recibira el archivo de texto
     * para ser creado o actualizado.
     */
    public static void limpiarArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo+".txt");
        boolean existe = archivo.exists();
        if(existe){
            archivo.delete();
        }
    }
}
