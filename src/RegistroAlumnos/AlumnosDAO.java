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

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AlumnosDAO {
    /**
     * Recupera una lista de alumnos de un archivo de texto
     * @return lista de los alumnos registrados
     */
    public static List<Alumno> getAlumnos(){
        Gson gson = new Gson();
        List<Alumno> lista = new ArrayList<Alumno>();
        try{
            List<String> datos = ArchivoUtils.leerArchivoTodo("Alumnos");
            for(String linea : datos){
                if(linea != null && !linea.isEmpty()){
                    lista.add(gson.fromJson(linea, Alumno.class));
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    /**
     * Guarda los alumnos, llama a otro metodo para completar el 
     * guardado.
     * @param a recibe objeto de tipo alumno 
     * @return si el registro fue guardado exitosamente regresa un true, 
     * en caso contrario regresa un false 
     */
    public static boolean guardarAlumno(Alumno a){
        Gson gson = new Gson();
        String linea = gson.toJson(a);
        try{
            ArchivoUtils.escribirEnArchivo("Alumnos", true, linea);
            return true;
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    /**
     * Actualiza los datos de un registro, llama a otra funcion para completar 
     * la tarea.
     * @param alumno recibe una lista de alumnos que estan registrados.
     * @param indice recibe la posicion en la que se encuentra guardado el 
     * registro del alumno. 
     * @param a recibe un objeto de tipo alumno.
     */
    public static void actualizarAdministrativo(List<Alumno> alumno, int indice, Alumno a){
        Gson gson = new Gson();
        ArchivoUtils.limpiarArchivo("Alumnos");
        int i=0;
        String linea = "";
        for(Alumno ad : alumno){
            if(indice == i){
                linea = gson.toJson(a);
            }else{
                linea = gson.toJson(ad);
            }
            try{
                ArchivoUtils.escribirEnArchivo("Alumnos", true, linea);
            }catch(IOException ex){
                ex.printStackTrace();
            }
            i++;
        } 
    }
    
    /**
     * Elimina el registro de un alumno, llama a otro metodo para completar
     * la tarea.
     * @param alumnos recibe una lista de alumnos que estan registrados.
     * @param indice recibe la posicion en la que se encuentra guardado el 
     * registro del alumno.
     */
    public static void eliminarAlumno(List<Alumno> alumnos, int indice){
        Gson gson = new Gson();
        int i = 0;
        ArchivoUtils.limpiarArchivo("Alumnos");
        String linea = "";
        for(Alumno ad : alumnos){
            if(indice != i){
                linea = gson.toJson(ad);
                try{
                ArchivoUtils.escribirEnArchivo("Alumnos", true, linea);
                }catch(IOException ex){
                ex.printStackTrace();
                }
            }
            
            i++;
        }
    }
}
