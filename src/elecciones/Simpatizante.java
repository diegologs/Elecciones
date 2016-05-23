package elecciones;

import java.io.Serializable;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class Simpatizante extends Votantes implements Serializable{
    
//Contructores
    public Simpatizante(String nombreApellido, int edad, String profesion, String genero, String siglasPartido) {
        super(nombreApellido, edad, profesion, genero, siglasPartido);
    }
    
    public Simpatizante(String nombreApellido, int edad, String profesion, String genero) {
        super(nombreApellido, edad, profesion, genero);
    }
    public Simpatizante(String nombreApellido){
        super(nombreApellido);
    }
//Metodos Publicos
    @Override
    public String toString(){
        return super.toString();
    }
    
    @Override
    public void enviarEncuesta(String[] enc1){
        this.setEncuesta(enc1);
    }
    //Metodos Privados

}