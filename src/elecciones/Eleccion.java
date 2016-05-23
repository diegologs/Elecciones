package elecciones;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class Eleccion implements Serializable {
//Atributos
    protected String nombre = "Sin nombre";
    protected double participacion;
    protected int escaños;
    protected ArrayList<ItemVotos> resultadosTotalVotos = new ArrayList<>();
    protected ArrayList<ItemEscaños> resultadosTotalEscaños = new ArrayList<>();
    private ArrayList<Circunscripcion> eleccionesEnCircunscripcion = new ArrayList<>();
    private static final long serialVersionUID = -1187279578359299039L;
    private int votosTotalBlanco;

//Contructores
    public Eleccion(String nombre) {
        this.nombre = nombre;
    }
    
//GETs y SETs
     public ArrayList<Circunscripcion> getEleccionesEnCircunscripcion() {
        return eleccionesEnCircunscripcion;
    }

    public void setEleccionesEnCircunscripcion(ArrayList<Circunscripcion> eleccionesEnCircunscripcion) {
        this.eleccionesEnCircunscripcion = eleccionesEnCircunscripcion;
    }

    public int getVotosTotalBlanco() {
        return votosTotalBlanco;
    }

    public void setVotosTotalBlanco(int votosTotalBlanco) {
        this.votosTotalBlanco = votosTotalBlanco;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getParticipacion() {
        return participacion;
    }
    public void setParticipacion(double participacion) {
        this.participacion = participacion;
    }
    public int getEscaños() {
        return escaños;
    }
    public void setEscaños(int escaños) {
        this.escaños = escaños;
    }
    public ArrayList<ItemVotos> getResultadosTotalVotos() {
        return resultadosTotalVotos;
    }
    public void setResultadosTotalVotos() {
        this.resultadosTotalVotos = new ArrayList<>();
        for (Circunscripcion circuns: eleccionesEnCircunscripcion ) {
            ArrayList<ItemVotos> x_tablaVotos = circuns.getResultadoVotos();
            this.setVotosTotalBlanco(this.getVotosTotalBlanco()+circuns.getVotosBlanco());
            for (ItemVotos vots_itemVotos : x_tablaVotos){
                FormacionPolitica partido = vots_itemVotos.getFormacion();
                int votos = vots_itemVotos.getNumeroVotos();
                int posicion = damePosicion_votos(partido);
                if (posicion == -1){
                    resultadosTotalVotos.add(new ItemVotos(partido,votos));
                }else{
                    resultadosTotalVotos.get(posicion).setNumeroVotos(resultadosTotalVotos.get(posicion).getNumeroVotos()+votos);
                }
            }
        }
    }
    public int damePosicion_votos(FormacionPolitica partido){
        for (int i=0; i<resultadosTotalVotos.size(); i++ ){
            if(resultadosTotalVotos.get(i).getFormacion().equals(partido)){
                return i;
            }
        }
        return -1;
    }
    
        public void setResultadosTotalEscaños() {
            this.resultadosTotalEscaños = new ArrayList<>();
        for (Circunscripcion circuns: eleccionesEnCircunscripcion ) {
            ArrayList<ItemEscaños> x_tablaEscaños = circuns.getResultadoEscaños();
            for (ItemEscaños escaños_itemEscaños : x_tablaEscaños){
                FormacionPolitica partido = escaños_itemEscaños.getFormacion();
                int escañosTemporal = escaños_itemEscaños.getNumeroEscaños();
                int posicion = damePosicion_escaños(partido);
                if (posicion == -1){
                    resultadosTotalEscaños.add(new ItemEscaños(partido,escañosTemporal));
                }else{
                    resultadosTotalEscaños.get(posicion).setNumeroEscaños(resultadosTotalEscaños.get(posicion).getNumeroEscaños()+escañosTemporal);
                }
            }
        }
    }
    public int damePosicion_escaños(FormacionPolitica partido){
        for (int i=0; i<resultadosTotalEscaños.size(); i++ ){
            if(resultadosTotalEscaños.get(i).getFormacion().equals(partido)){
                return i;
            }
        }
        return -1;
    }
    
    
    
    public ArrayList<ItemEscaños> getResultadosTotalEscaños() {
        return resultadosTotalEscaños;
    }
    public void setResultadosTotalEscaños(ArrayList<ItemEscaños> resultadosTotalEscaños) {
        this.resultadosTotalEscaños = resultadosTotalEscaños;
    }
    
    
    
//Metodos Publicos
    public void realizarEleccion(boolean votosManuales){
        for(Circunscripcion circunscripcion : eleccionesEnCircunscripcion){
            circunscripcion.calcularResultados(votosManuales);
            
            circunscripcion.calcularListas();
        }
        this.setResultadosTotalEscaños();
        this.setResultadosTotalVotos();
        this.imprimirTablaGlobalVotos();
    }
    
    public String imprimirTablaGlobalVotos(){
        return resultadosTotalVotos.toString();
    };
    public String imprimirTablaGlobalescaños(){
        return resultadosTotalEscaños.toString();
    };
    
    public ArrayList<Lista> imrpimirListaElectos() {
        ArrayList<Lista> listaElectos = new ArrayList<>();
        for (Circunscripcion circuns: eleccionesEnCircunscripcion ) {
            ArrayList<Lista> x_listasPartidos = circuns.getListasPartidos();
            for (Lista lista : x_listasPartidos){
                listaElectos.add(lista);
            }
        }
        return listaElectos;
    }
    
    
    private int damePosicion_Electos(FormacionPolitica partido, ArrayList<Lista> listaElectos ){
        for (int i=0; i<listaElectos.size(); i++ ){
            if(listaElectos.get(i).getFormacionPolitica().equals(partido)){
                return i;
            }
        }
        return -1;
    }
    
    
    public StringBuilder imprimirMayorias(){
        StringBuilder mayorias = new StringBuilder();
        ArrayList<ItemEscaños> cuatroFormaciones = cuatroFuerzas();
        for(ItemEscaños formacion: cuatroFormaciones){
            if(formacion.getNumeroEscaños()>(escaños/2)){
               mayorias.append(formacion.getFormacion().getNombre()).append(" ").append(formacion.getNumeroEscaños()).append("\n");
               return mayorias;
            }
        }
        switch(cuatroFormaciones.size()){
            case 2:
                    if(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(1).getNumeroEscaños()>(escaños/2)){
                    mayorias.append(cuatroFormaciones.get(0).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(0).getNumeroEscaños()).append(" + ")
                    .append(cuatroFormaciones.get(1).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(1).getNumeroEscaños()).append(" ")
                    .append(" = ").append(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(1).getNumeroEscaños())
                    .append("\n");
                    }
                    break;
            case 3:
                    if(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(1).getNumeroEscaños()>(escaños/2)){
                    mayorias.append(cuatroFormaciones.get(0).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(0).getNumeroEscaños()).append(" + ")
                    .append(cuatroFormaciones.get(1).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(1).getNumeroEscaños()).append(" ")
                    .append(" = ").append(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(1).getNumeroEscaños())
                    .append("\n");
                    }
                    if(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(2).getNumeroEscaños()>(escaños/2)){
                        mayorias.append(cuatroFormaciones.get(0).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(0).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(2).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(2).getNumeroEscaños()).append(" ")
                                .append(" = ").append(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(2).getNumeroEscaños())
                                .append("\n");
                    }
                    if(cuatroFormaciones.get(1).getNumeroEscaños() + cuatroFormaciones.get(2).getNumeroEscaños()>(escaños/2)){
                        mayorias.append(cuatroFormaciones.get(1).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(1).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(2).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(2).getNumeroEscaños()).append(" ")
                               .append(" = ").append(cuatroFormaciones.get(1).getNumeroEscaños() + cuatroFormaciones.get(2).getNumeroEscaños()) 
                                .append("\n");
                    }
                    if(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(1).getNumeroEscaños() + cuatroFormaciones.get(2).getNumeroEscaños()>(escaños/2)){
                        mayorias.append(cuatroFormaciones.get(0).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(0).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(1).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(1).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(2).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(2).getNumeroEscaños()).append(" ")
                                .append(" = ").append(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(1).getNumeroEscaños()+ cuatroFormaciones.get(2).getNumeroEscaños())
                                .append("\n");
                    }
                    break;
            case 4:
                    if(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(1).getNumeroEscaños()>(escaños/2)){
                    mayorias.append(cuatroFormaciones.get(0).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(0).getNumeroEscaños()).append(" + ")
                    .append(cuatroFormaciones.get(1).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(1).getNumeroEscaños()).append(" ")
                            .append(" = ").append(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(1).getNumeroEscaños())
                            .append("\n");
                    }
                    if(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(2).getNumeroEscaños()>(escaños/2)){
                        mayorias.append(cuatroFormaciones.get(0).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(0).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(2).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(2).getNumeroEscaños()).append(" ")
                                .append(" = ").append(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(2).getNumeroEscaños()).append("\n");
                    }
                    if(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(3).getNumeroEscaños()>(escaños/2)){
                        mayorias.append(cuatroFormaciones.get(0).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(0).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(3).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(3).getNumeroEscaños()).append(" ")
                                .append(" = ").append(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(3).getNumeroEscaños()).append("\n");
                    }
                    if(cuatroFormaciones.get(1).getNumeroEscaños() + cuatroFormaciones.get(2).getNumeroEscaños()>(escaños/2)){
                        mayorias.append(cuatroFormaciones.get(1).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(1).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(2).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(2).getNumeroEscaños()).append(" ")
                                .append(" = ").append(cuatroFormaciones.get(1).getNumeroEscaños() + cuatroFormaciones.get(2).getNumeroEscaños())
                                .append("\n");
                    }
                    if(cuatroFormaciones.get(1).getNumeroEscaños() + cuatroFormaciones.get(3).getNumeroEscaños()>(escaños/2)){
                        mayorias.append(cuatroFormaciones.get(1).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(1).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(3).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(3).getNumeroEscaños()).append(" ")
                                .append(" = ").append(cuatroFormaciones.get(1).getNumeroEscaños() + cuatroFormaciones.get(3).getNumeroEscaños())
                                .append("\n");
                    }
                    if(cuatroFormaciones.get(2).getNumeroEscaños() + cuatroFormaciones.get(3).getNumeroEscaños()>(escaños/2)){
                        mayorias.append(cuatroFormaciones.get(2).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(2).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(3).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(3).getNumeroEscaños()).append(" ")
                                .append(" = ").append(cuatroFormaciones.get(2).getNumeroEscaños() + cuatroFormaciones.get(3).getNumeroEscaños())
                                .append("\n");
                    }
                    if(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(1).getNumeroEscaños() + cuatroFormaciones.get(2).getNumeroEscaños()>(escaños/2)){
                        mayorias.append(cuatroFormaciones.get(0).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(0).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(1).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(1).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(2).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(2).getNumeroEscaños()).append(" ")
                                .append(" = ").append(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(1).getNumeroEscaños()+ cuatroFormaciones.get(2).getNumeroEscaños())
                                .append("\n");
                    }
                    if(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(1).getNumeroEscaños() + cuatroFormaciones.get(3).getNumeroEscaños()>(escaños/2)){
                        mayorias.append(cuatroFormaciones.get(0).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(0).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(1).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(1).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(3).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(3).getNumeroEscaños()).append(" ")
                                .append(" = ").append(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(1).getNumeroEscaños()+ cuatroFormaciones.get(3).getNumeroEscaños())
                                .append("\n");
                    }
                    if(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(2).getNumeroEscaños() + cuatroFormaciones.get(3).getNumeroEscaños()>(escaños/2)){
                        mayorias.append(cuatroFormaciones.get(0).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(0).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(2).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(2).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(3).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(3).getNumeroEscaños()).append(" ")
                                .append(" = ").append(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(2).getNumeroEscaños()+ cuatroFormaciones.get(3).getNumeroEscaños())
                                .append("\n");
                    }
                    if(cuatroFormaciones.get(1).getNumeroEscaños() + cuatroFormaciones.get(2).getNumeroEscaños() + cuatroFormaciones.get(3).getNumeroEscaños()>(escaños/2)){
                        mayorias.append(cuatroFormaciones.get(1).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(1).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(2).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(2).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(3).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(3).getNumeroEscaños()).append(" ")
                                .append(" = ").append(cuatroFormaciones.get(1).getNumeroEscaños() + cuatroFormaciones.get(2).getNumeroEscaños()+ cuatroFormaciones.get(3).getNumeroEscaños())
                                .append("\n");
                    }
                    if(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(1).getNumeroEscaños() + cuatroFormaciones.get(2).getNumeroEscaños()
                            + cuatroFormaciones.get(3).getNumeroEscaños()>(escaños/2)){
                        mayorias.append(cuatroFormaciones.get(0).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(0).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(1).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(1).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(2).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(2).getNumeroEscaños()).append(" + ")
                        .append(cuatroFormaciones.get(3).getFormacion().getNombre()).append(" ").append(cuatroFormaciones.get(3).getNumeroEscaños()).append(" ")
                                .append(" = ").append(cuatroFormaciones.get(0).getNumeroEscaños() + cuatroFormaciones.get(1).getNumeroEscaños()+ cuatroFormaciones.get(2).getNumeroEscaños()+ cuatroFormaciones.get(3).getNumeroEscaños())
                                .append("\n");
                    }
                    break;
        };
        return mayorias;
    };
    
   
    private ArrayList<ItemEscaños> cuatroFuerzas(){
        ArrayList<ItemEscaños> copia = new ArrayList<>(resultadosTotalEscaños); 
        ArrayList<ItemEscaños> fuerzas = new ArrayList<>();
        if (copia.size()<5){
            return copia;
         }else{        
            int posicion = 0;
            for(int i=0; i<4;i++){
                int numEscañosMayor = 0; //actualizacion de Numero de escaños para que encuentre el mayor.
                for (int j=0; j<copia.size();j++){
                    if(copia.get(j).getNumeroEscaños()>numEscañosMayor){
                        numEscañosMayor = copia.get(j).getNumeroEscaños();
                        posicion = j;
                    }
                }
                // Añadir al nuevo ArrayList la posicion i.
                fuerzas.add(copia.get(posicion));
                //borra para poder encontrar el siguiente mayor (hay que clonar resultadosTotalEscaños para no borrar el original, lo he intentado pero no me deja)
                copia.remove(posicion);             
            }
            return fuerzas;
        }
        
    }

}
