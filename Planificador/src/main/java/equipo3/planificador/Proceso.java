package equipo3.planificador;

import java.time.*;
import java.util.HashMap;

/**
 *
 * @author Equipo 3
 */
public class Proceso {
    private int id;
    private int prioridad;
    private int tiempoRestante;
    private LocalDateTime tiempoCreacion = LocalDateTime.now();
    private LocalDateTime tiempoFinalizado;
    private int tiempoEjecucionActual;
    private HashMap<Integer, Integer> entradaSalida = new HashMap<>();
    private Tipo tipo;
    private Estado estado;
    private double tiempoBloqueado = 0.0;

    public Proceso(int id, int prioridad, int duracion, HashMap<Integer, Integer> entradaSalida) {
        this.id = id;
        this.prioridad = prioridad;
        if(prioridad < 1 || prioridad > 99){
            System.out.println("ERROR: No se puede crear proceso, prioridad debe ser entre 1 y 99");
            System.exit(1);
        }
        else if(prioridad >= 1 && prioridad <= 20){
            this.prioridad = prioridad;
            this.tipo = Tipo.TIEMPOREAL;
        }
        else if(prioridad >= 21 && prioridad <= 70){
            this.prioridad = prioridad;
            this.tipo = Tipo.INTERACTIVO;
        }
        else if(prioridad >= 71 && prioridad <= 99){
            this.prioridad = prioridad;
            this.tipo = Tipo.BATCH;
        }
        this.tiempoRestante = duracion;
        this.entradaSalida = entradaSalida;
    }

    public int getID() {
        return this.id;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return this.prioridad;
    }

    public void decrementarTiempoRestante() {
        this.tiempoRestante--;
        this.tiempoEjecucionActual++;

    }

    public int getTiempoRestante() {
        return this.tiempoRestante;
    }

    public int getTiempoEjecucionActual() {
        return this.tiempoEjecucionActual;
    }

    public LocalDateTime getTiempoCreacion() {
        return this.tiempoCreacion;
    }

    public HashMap getEntradaSalida() {
        return this.entradaSalida;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public Tipo getTipo() {
        return this.tipo;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public double getTiempoBloqueado() {
        return tiempoBloqueado;
    }

    public void setTiempoBloqueado(double tiempoBloqueado) {
        if(tiempoBloqueado <0) {
            this.tiempoBloqueado = 0.0;
        }else {
            this.tiempoBloqueado = tiempoBloqueado;
            
        }
    }
    
    public void tiempoFinalizadoAhora(){
        this.tiempoFinalizado = LocalDateTime.now();
    }
    
}