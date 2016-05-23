package elecciones;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */
public class Coalicion extends FormacionPolitica implements Serializable{
    private ArrayList<FormacionPolitica> partidosCoalicion = new ArrayList<>();

    
//Contructores
    public Coalicion(String nombre, String siglas, String logo){
        super(nombre,siglas,logo);
    }
    
    public Coalicion(String nombre, String siglas, String logo, ArrayList<FormacionPolitica> partidos){
        super(nombre,siglas,logo);
        this.partidosCoalicion = partidos;
        
        // ¿Cuantos partidos formaran la coalicion?
        this.militantes = new ArrayList<>();
        
        double numPartidos = new Double(partidos.size());

        for (FormacionPolitica partido : partidos){
            int nMilis = partido.getMilitantes().size();
            ArrayList<Militante> prueba = new ArrayList<>(partido.getMilitantes().subList(0, (int) Math.round((nMilis*(1/numPartidos)))));
            this.militantes.addAll(prueba);
        }
        
    }
//GETs y SETs
    public ArrayList<FormacionPolitica> getCoalicion_partidos() {
        return partidosCoalicion;
    }
    public void setCoalicion_partidos(ArrayList<FormacionPolitica> coalicion_partidos) {
        this.partidosCoalicion = coalicion_partidos;
    }
    
//Metodos Publicos
    @Override
    public String toString(){
        
        // Lista de todos los partidos que forman la coalición
        StringBuilder partidos = new StringBuilder();
        for (FormacionPolitica p : partidosCoalicion){
            partidos.append(p.getNombre());
            partidos.append(";");
        }
        return "Nombre coalición: " +nombre+
                "\nSiglas: " +siglas+
                "\nFormada por los partidos: "+partidos;
    }
//Metodos Privados

}
