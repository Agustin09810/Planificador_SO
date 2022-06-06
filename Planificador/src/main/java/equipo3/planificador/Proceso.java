package equipo3.planificador;
import java.time.*;
/**
 *
 * @author Equipo 3
 */
public class Proceso {
    private int id;
    private enum Tipo{
        TIEMPOREAL,
        INTERACTIVOS,
        BATCH
    }
    private int prioridad;
    private LocalDateTime tiempoCreacion = LocalDateTime.now();
    private LocalDateTime tiempoFinalizacion;
    private enum Estado{
        BLOQUEADO,
        LISTO,
        FINALIZADO
    }
    
    //CADA CUANTO SE HACE ENTRADA Y SALIDA
    
    //CUANTO TIEMPO EN ENTRADA Y SALIDA
    
//    constructor
    Tipo tipo;
    Estado estado;
    
    
    public Proceso(int id, int prioridad, int tipo, LocalDateTime tiempoFin){
        this.id = id;
        this.prioridad = prioridad;
        //Falta terminar
    } 
    
    
            
    public int getID(){
        return this.id;
    }
    
    public void setPrioridad(int prioridad){
        this.prioridad = prioridad;
    }
    
    public int getPrioridad(){
        return this.prioridad;
    }
    
    //METODO PARA SETEAR ESTADO
    
    //METODO PARA DEVOLVER ESTADO
}