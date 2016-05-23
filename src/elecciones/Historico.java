package elecciones;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class Historico implements Serializable{
//Atributos
    private ArrayList<Eleccion> historia_elecciones = new ArrayList<>();
//Contructores

    public Historico(ArrayList<Eleccion> historia_elecciones) {
        this.historia_elecciones = historia_elecciones;
    }

    public ArrayList<Eleccion> getHistoria_elecciones() {
        return historia_elecciones;
    }

    public void setHistoria_elecciones(ArrayList<Eleccion> historia_elecciones) {
        this.historia_elecciones = historia_elecciones;
    }

//GETs y SETs

//Metodos Publicos
    public void consultarResultado (PartidoPolitico partido){
    };
//Metodos Privados
}
