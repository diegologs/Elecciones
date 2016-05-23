package elecciones;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class Lista implements Serializable{
//Atributos
    private String descripcion = "Descripción por defecto";
    private ArrayList<Militante> diputados = new ArrayList<>(); // NO BORRAR
    private FormacionPolitica formacionPolitica;  // NO BORRAR
    private String circunscripcionPertenece; // NO BORRAR
    private static final long serialVersionUID = 3545915645390216242L;
    public ArrayList<Militante> getDiputados() {
        return diputados;
    }

    public void setDiputados(ArrayList<Militante> diputados) {
        this.diputados = diputados;
    }

    public FormacionPolitica getFormacionPolitica() {
        return formacionPolitica;
    }

    public void setFormacionPolitica(FormacionPolitica formacionPolitica) {
        this.formacionPolitica = formacionPolitica;
    }

    public String getCircunscripcionPertenece() {
        return circunscripcionPertenece;
    }

    public void setCircunscripcionPertenece(String eleccionEnCircunscripcion) {
        this.circunscripcionPertenece = eleccionEnCircunscripcion;
    }

    
//Contructores
    //Crear lista vacia (evitamos NULLPOINTEREXCEPTION)
    public Lista(){
        this.diputados = new ArrayList<Militante>();
    }
    // Crear lista a partir de ArrayList
    public Lista(ArrayList<Militante> lista){
        this.diputados = lista;
    }
    // Crear la lista pasando todo
    public Lista(ArrayList<Militante> lista, FormacionPolitica f,String nombre, String d) {
        this.diputados = lista;
        this.circunscripcionPertenece = nombre;
        this.formacionPolitica = f;
        this.descripcion = d;
    }
//GETs y SETs
    public void setDescripcion (String d1){
        this.descripcion = d1;
    }
    
    public ArrayList<Militante> getLista_militantes() {
        return diputados;
    }
//Metodos Publicos
    public void add(Militante mil) {
        this.diputados.add(mil);
    }
    
//Metodos Privados

    @Override
    public String toString() {
        return formacionPolitica.getNombre()+ ": "+ diputados + ',' + this.circunscripcionPertenece;
    }
}
