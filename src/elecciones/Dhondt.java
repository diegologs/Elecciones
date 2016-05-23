package elecciones;

import java.io.Serializable;

/**
 *
 * @author Josemi
 */

public class Dhondt implements Serializable{

    //Cogemos el mayor de la tabla creada y lo eliminamos.
    //Devuelve la fila que contiene el partido con el maximo.

	public static int getMaximo(double [][]tabla, int filas, int columnas)
	{   int filaMaxima = -1;
            int colMaxima = -1;
            double maximo = 0.0;
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if(tabla[i][j]>maximo){
                        maximo = tabla[i][j];
                        filaMaxima = i;
                        colMaxima = j;
                    }
                }
            }
            tabla[filaMaxima][colMaxima]=0.0;
            return filaMaxima;
        }
}
