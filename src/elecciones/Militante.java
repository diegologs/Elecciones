package elecciones;

import java.io.Serializable;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class Militante extends Votantes implements Serializable{
//Atributos
    protected String cuota = "Sin definir";
    protected String carnet = "Sin definir";
    
//Contructores
    public Militante(String nombreApellidos, int edad, String profesion, String genero, String siglasPartido,String cuota, String carnet) {
        super(nombreApellidos, edad, profesion, genero, siglasPartido);
        this.cuota = cuota;
        this.carnet = carnet;
    }
    public Militante(String nombreApellidos, int edad, String profesion, String genero, String cuota, String carnet) {
        super(nombreApellidos, edad, profesion, genero);
        this.cuota = cuota;
        this.carnet = carnet;
    }
    
    public Militante(String nombreApellidos){
        super(nombreApellidos);
    }
//GETs y SETs
    public String getCuota() {
        return cuota;
    }
    public void setCuota(String cuota) {
        this.cuota = cuota;
    }
    public String getCarnet() {
        return carnet;
    }
    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
//Metodos Publicos
    
    @Override
    public void enviarEncuesta(String[] enc1){
        this.setEncuesta(enc1);
    }
   
//Metodos Privados

    @Override
    public String toString() {
        return super.toString()+
                "\nNumero Carnet: "+this.carnet+
                "\nCuota: "+this.cuota+
                "\n";
    }



}
