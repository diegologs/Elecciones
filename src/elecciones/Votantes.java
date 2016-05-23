package elecciones;
// prueba 02012016

import java.io.Serializable;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public abstract class Votantes implements Serializable{
//Atributos
    protected String nombreApellidos = "Sin definir";
    protected int edad;
    protected String profesion= "Sin definir";
    protected String genero= "Sin definir";
    protected String siglasPartido= "Sin definir";
    protected String[] encuesta;

//Contructores
    public Votantes(String nombreApellidos){
        this.nombreApellidos= nombreApellidos;
    }
    public Votantes(String nombreApellidos, int edad, String profesion, String genero, String siglasPartido) {
        this.nombreApellidos = nombreApellidos;
        this.edad = edad;
        this.profesion = profesion;
        this.genero = genero;
        this.siglasPartido = siglasPartido;
    }
    public Votantes(String nombreApellidos, int edad, String profesion, String genero){
        this.nombreApellidos = nombreApellidos;
        this.edad = edad;
        this.profesion = profesion;
        this.genero = genero;
    }
    
//GETs y SETs
    public String getNombreApellidos() {
        return nombreApellidos;
    }
    public void setNombreApellidos(String nombre) {
        this.nombreApellidos = nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getProfesion() {
        return profesion;
    }
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getSiglasPartido() {
        return siglasPartido;
    }
    public void setSiglasPartido(String siglasPartido) {
        this.siglasPartido = siglasPartido;
    }
    public String[] getEncuesta() {
        return encuesta;
    }
    public void setEncuesta(String[] encuesta) {
        this.encuesta = encuesta;
    }

//Metodos Publicos
    public abstract void enviarEncuesta(String[] encuesta);
    
    @Override
    public String toString() {
        return "Nombre y Apellidos:" + nombreApellidos + 
                "\nEdad: " + edad + 
                "\nGenero: " + genero + 
                "\nProfesion: " + profesion +                 
                "\nSiglas Partido: " + siglasPartido;
    }
       
//Metodos Privados




}

