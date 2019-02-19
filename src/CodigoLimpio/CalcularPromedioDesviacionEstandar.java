/**
 * Institución: Universidad Veracruzana
 * Programa educativo: Ingenieria de Software
 * Descripción: Este programa calcula el promedio y desviacion estandar
 * de 10 numeros.
 * Modificación: 2019/02/14
 *
 * @author Victor Niño
 * @version 1.0
 * @since 2019/02/12
 */
package CodigoLimpio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class CalcularPromedioDesviacionEstandar {

    public static void main(String args[]) {
        int numeros[] = new int[8];
        double numerosDesviacion[] = new double[8];
        JOptionPane.showMessageDialog(null, "Este programa calcula el promedio y "
                + "desviacion estandar de 10 numeros");
        ObtenerNumeros(numeros);
        JOptionPane.showMessageDialog(null, "El promedio es: " + CalcularPromedio(numeros));
        JOptionPane.showMessageDialog(null, "La desviacion Estandar es: "
                + CalcularDesviacionEstandar(numeros, numerosDesviacion));
        JOptionPane.showMessageDialog(null, "La moda es: " + CalcularModa(numeros));
        JOptionPane.showMessageDialog(null, "La mediana es: " + CalcularMediana(numeros));
    }

    /**
     * Metodo que pide los numeros a los usuarios y los guarda en un arreglo de
     * enteros.
     *
     * @param numeros es el arreglo de enteros que se ocupara para guardar los
     * datos del usuario.
     */
    public static void ObtenerNumeros(int numeros[]) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int numeroIngresado = 0;
        String valor;
        for (int contador = 0; contador < numeros.length; contador++) {
            System.out.println("Ingresar el numero " + (contador + 1) + ":");
            try {
                valor = entrada.readLine();
                numeroIngresado = Integer.parseInt(valor);
            } catch (IOException e) {

            }
            numeros[contador] = numeroIngresado;
        }
    }

    /**
     *
     * @param numeros es el arreglo de enteros que se ocupara para guardar los
     * datos del usuario.
     * @return regresa el promedio de los numeros ingresados
     */
    public static double CalcularPromedio(int numeros[]) {
        double promedio = 0.0;
        for (int contador = 0; contador < numeros.length; contador++) {
            promedio = promedio + numeros[contador];
        }
        promedio = promedio / numeros.length;
        return promedio;
    }

    /**
     *
     * @param numeros es el arreglo de enteros que se ocupara para guardar los
     * datos del usuario.
     * @param numerosDesviacion es el arreglo de double que se ocupara para
     * guardar los datos de la varianza.
     * @return regresa la varianza de los numeros
     */
    public static double CalcularVarianza(int numeros[], double numerosDesviacion[]) {
        double promedio = CalcularPromedio(numeros);
        double suma = 0.0;
        for (int contador = 0; contador < numeros.length; contador++) {
            numerosDesviacion[contador] = Math.pow((numeros[contador] - promedio), 2);
        }
        for (int contador = 0; contador < numerosDesviacion.length; contador++) {
            suma = suma + numerosDesviacion[contador];
        }
        return suma / numeros.length;
    }

    /**
     *
     * @param numeros es el arreglo de enteros que se ocupara para guardar los
     * datos del usuario.
     * @param numerosDesviacion es el arreglo de double que se ocupara para
     * guardar los datos de la varianza.
     *
     */
    public static void MostrarDesviacionPorNum(int numeros[], double numerosDesviacion[]) {
        System.out.println("Desviación de cada numero: ");
        for (int contador = 0; contador < numerosDesviacion.length; contador++) {
            System.out.println("Numero " + numeros[contador] + ": " + numerosDesviacion[contador]);
        }

    }

    /**
     *
     * @param numeros es el arreglo de enteros que se ocupara para guardar los
     * datos del usuario.
     * @param numerosDesviacion es el arreglo de double que se ocupara para
     * guardar los datos de la varianza.
     * @return regresa la desviacion estandar de los numeros ingresados.
     */
    public static double CalcularDesviacionEstandar(int numeros[], double numerosDesviacion[]) {
        double desviacionEstandar = 0.0;
        desviacionEstandar = Math.sqrt(CalcularVarianza(numeros, numerosDesviacion));
        return desviacionEstandar;
    }

    /**
     * EL método recibe un vector de numeros, los guarda en otro y los ordena
     * con el método de burbuja
     *
     * @param numeros es el arreglo de enteros que se ocupara para guardar los
     * datos del usuario.
     * @return regresa un vector con los numeros ordenados
     */
    public static int[] OrdenarNumeros(int numeros[]) {
        int auxiliar[] = new int[numeros.length], num;
        auxiliar = numeros;
        int n = numeros.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (auxiliar[i] > auxiliar[j]) {
                    num = auxiliar[j];
                    auxiliar[j] = auxiliar[i];
                    auxiliar[i] = num;
                }
            }
        }
        return auxiliar;
    }

    /**
     *
     * @param numeros es el arreglo de enteros que se ocupara para guardar los
     * datos del usuario.
     * @return regresa la moda de los datos ingresados.
     */
    public static int CalcularModa(int numeros[]) {
        int moda = 0, maxRepeticiones = 0;
        for (int i = 0; i < numeros.length; i++) {
            int numRepeticiones = 0;
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[i] == numeros[j]) {
                    numRepeticiones++;
                }
            }
            if (numRepeticiones > maxRepeticiones) {
                moda = numeros[i];
                maxRepeticiones = numRepeticiones;
            }
        }
        return moda;
    }

    /**
     *
     * @param numeros es el arreglo de enteros que se ocupara para guardar los
     * datos del usuario.
     * @return regresa la mediana de los numeros ingresados
     */
    public static double CalcularMediana(int numeros[]) {
        double mediana = 0;
        int pos = 0;
        int numOrdenados[] = new int[numeros.length];
        numOrdenados = OrdenarNumeros(numeros);
        if (numOrdenados.length % 2 == 0) {
            pos = numOrdenados.length / 2;
            mediana = (double) (numOrdenados[pos] + numOrdenados[pos - 1]) / 2;
        } else {
            pos = numOrdenados.length / 2;
            mediana = numOrdenados[pos];
        }

        return mediana;
    }
}
