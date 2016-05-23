package elecciones;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import vista.Vista;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */
public class Elecciones implements Serializable{

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */

    
    public static void main(String[] args) throws IOException {
        // Creamos la ventana principal de la aplicación
        Vista app = new Vista();
        // La hacemos visible
        app.setVisible(true);
           
    };
};
