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
    private int tiempoEjecucionActual;
    private HashMap<Integer, Integer> entradaSalida = new HashMap<>();
    private Tipo tipo;
    private Estado estado;
    // CADA CUANTO SE HACE ENTRADA Y SALIDA

    // CUANTO TIEMPO EN ENTRADA Y SALIDA

    // constructor

    public Proceso(int id, int prioridad, Tipo tipo, int duracion, HashMap<Integer, Integer> entradaSalida) {
        this.id = id;
        this.prioridad = prioridad;
        this.tipo = tipo;
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

    // METODO PARA SETEAR ESTADO

    // METODO PARA DEVOLVER ESTADO
}