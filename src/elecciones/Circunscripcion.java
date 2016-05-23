package elecciones;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.Vista;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */



public class Circunscripcion implements Serializable{
//Atributos
    protected String nombre = "Sin Nombre";
    protected int poblacion;
    protected int escaños;
    protected double participacion;
    protected ArrayList<ItemVotos> resultadoVotos = new ArrayList<>();
    protected ArrayList<ItemEscaños> resultadoEscaños = new ArrayList<>();
    private ArrayList<Lista> listasPartidos = new ArrayList<>();
    private int votosBlanco;
    protected ArrayList<FormacionPolitica> formaciones = new ArrayList<>();
    
//Contructores
    public Circunscripcion(String nombre, int poblacion, double participacion) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.escaños = Escaños(poblacion);
        this.participacion = participacion;
    }
    
    public ArrayList<Lista> getListasPartidos() {
        return listasPartidos;
    }
    
    public int getVotosBlanco(){
        return votosBlanco;
    }

//GETs y SETs
    public void setVotosBlanco(int votosBlanco) {
        this.votosBlanco = votosBlanco;
    }

    public void setFormaciones(ArrayList<FormacionPolitica> formaciones) {
        this.formaciones = formaciones;
    }
    public ArrayList<FormacionPolitica> getFormaciones(){
        return this.formaciones;
    }
    public void setListasPartidos(ArrayList<Lista> listasPartidos) {    
        this.listasPartidos = listasPartidos;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPoblacion() {
        return poblacion;
    }
    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }
    public int getEscaños() {
        return escaños;
    }
    public void setEscaños(int poblacion) {
        if (poblacion<251){
            escaños=5;
        } else if (poblacion<1001){
            escaños=7;
        } else if (poblacion<2001){
            escaños=9;
        } else if (poblacion<5001){
            escaños=11;
        } else if (poblacion<10001){
            escaños=13;
        } else if (poblacion<20001){
            escaños=17;
        } else if (poblacion<50001){
            escaños=21;
        } else if (poblacion<100001){
            escaños=25;
        } else {
            escaños=(int) (25+Math.ceil((poblacion-100000)/100000));
            if((escaños%2)==0){
                escaños++;
            }
        }
    }
    public int Escaños(int poblacion){
        if (poblacion<251){
            escaños=5;
        } else if (poblacion<1001){
            escaños=7;
        } else if (poblacion<2001){
            escaños=9;
        } else if (poblacion<5001){
            escaños=11;
        } else if (poblacion<10001){
            escaños=13;
        } else if (poblacion<20001){
            escaños=17;
        } else if (poblacion<50001){
            escaños=21;
        } else if (poblacion<100001){
            escaños=25;
        } else {
            escaños=(int) (25+Math.ceil((poblacion-100000)/100000));
            if((escaños%2)==0){
                escaños++;
            }
        }
        return escaños;
    }
    
    public double getParticipacion() {
        return participacion;
    }
    public void setParticipacion(double participaccion) {
        this.participacion = participaccion;
    }
    public ArrayList<ItemVotos> getResultadoVotos() {
        return resultadoVotos;
    }
    public void setResultadoVotos(ArrayList<ItemVotos> resultadoVotos) {
        this.resultadoVotos = resultadoVotos;
    }
    public ArrayList<ItemEscaños> getResultadoEscaños() {
        return resultadoEscaños;
    }
    public void setResultadoEscaños(ArrayList<ItemEscaños> resultadoEscaños) {
        this.resultadoEscaños = resultadoEscaños;
    }
    
    public void simularResultados(boolean votosManuales) throws IllegalArgumentException{       
        int totalVotos = (int) Math.round((this.getPoblacion()*this.participacion));
        this.resultadoVotos = new ArrayList<>();
        for (int i = 0; i < listasPartidos.size(); i++) {
            /* int numVotos=Vista.pedirVotos(votosManuales,listasPartidos.get(i).getFormacionPolitica().getNombre(),listasPartidos.get(i).getCircunscripcionPertenece());
            if(numVotos==-1||numVotos>totalVotos){
                numVotos = (int)(Math.random() * totalVotos);
             }
            FormacionPolitica formacion = listasPartidos.get(i).getFormacionPolitica();
            ItemVotos votospartido = new ItemVotos(formacion,numVotos);
            this.resultadoVotos.add(votospartido); */
        }
        this.votosBlanco=totalVotos;
    };

    public void calcularResultados(boolean votosManuales){
           //Coger this.resultadoVotos
        
            int escañosTotales = this.getEscaños();
            simularResultados(votosManuales);//DEVUELVE resultadoVotos
            
            aplicarLey(resultadoVotos, escañosTotales);
    };

        
    public void calcularListas(){
        listasPartidos = new ArrayList<>();
        for (int i = 0; i < resultadoEscaños.size(); i++) {
            FormacionPolitica partido = resultadoEscaños.get(i).getFormacion();
            int escaños = resultadoEscaños.get(i).getNumeroEscaños();
            Lista listaPartido = partido.elaborarListas(escaños);
            listaPartido.setCircunscripcionPertenece(this.getNombre());
            listasPartidos.add(i, listaPartido);     
        }
    };
    //OPCIONALES
    public void imprimirTablaVotos(){
    
    };
    public void imprimirTablaescaños(){
    
    };
    
//Metodos Privados
    private void aplicarLey(ArrayList<ItemVotos> votos, int escañosTotales){
        ArrayList<ItemEscaños> escañoTemporal = new ArrayList<>();
        for(ItemVotos f: votos){
            escañoTemporal.add(new ItemEscaños(f.getFormacion(),0));
        }
        double [][] TablaAux = new double[votos.size()][escañosTotales];
        for (int i = 0; i < votos.size(); i++) {
            for (int j = 0; j < escañosTotales; j++) {
                TablaAux[i][j]=votos.get(i).getNumeroVotos()/(j+1); 
            }
        }
        
        for (int j = 0; j < escañosTotales; j++) {
            int partido = Dhondt.getMaximo(TablaAux,votos.size(),escañosTotales);
            escañoTemporal
                    .get(partido)
                    .setNumeroEscaños(escañoTemporal
                            .get(partido)
                            .getNumeroEscaños()+1);
            }
        this.resultadoEscaños = escañoTemporal;
    };
    
}
