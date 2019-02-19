/**
 * Institución: Universidad Veracruzana
 * Programa Educativo: Ingeniería de Software
 * Descripción: Esta clase de alumno será usada para crear objetos de alumnos
 * de el porgrama Registrar Alumnos.
 * Modificación: 
 * 
 * @author Victor Niño
 * @version 1.0
 * @since 2019/02/15
 */
package RegistroAlumnos;

/**
 * Implementacion de la clase alumno con metodos sets y gets
 * @author Vik-t
 */
public class Alumno {
    private String nombre;
    private String matricula;
    
    Alumno(){
        
    }
    Alumno(String nombre,String matricula){
        this.nombre = nombre;
        this.matricula = matricula; 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
}
