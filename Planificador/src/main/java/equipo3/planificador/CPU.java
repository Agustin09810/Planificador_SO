/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipo3.planificador;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Administrador
 */
public class CPU {

    private Proceso procesoActual;

    public CPU() {
    }

    public Proceso getProcesoActual() {
        return this.procesoActual;
    }

    public void setProcesoActual(Proceso proceso) {
        this.procesoActual = proceso;
    }

    public int procesarProceso(Proceso proc, int quantum, LinkedList<Proceso> bloqueados) throws InterruptedException {
        while (quantum > 0) {
            if (proc.getEstado() == Estado.LISTO || proc.getEstado() == Estado.EJECUCION ) {
                proc.setEstado(Estado.EJECUCION);
                proc.decrementarTiempoRestante();
                bloqueados.forEach((c) -> c.setTiempoBloqueado((Double) c.getTiempoBloqueado()- 1.d));
                if (proc.getTiempoRestante() <= 0) {
                    proc.setEstado(Estado.FINALIZADO);
                    return quantum;
                }
                if (proc.getEntradaSalida().containsKey(proc.getTiempoEjecucionActual())) {
                    proc.setEstado(Estado.BLOQUEADO);
                    Double aux = Double.valueOf((Integer)proc.getEntradaSalida().get(proc.getTiempoEjecucionActual()));
                    proc.setTiempoBloqueado(aux);
                    return quantum;
                }
                quantum--;
            }
            TimeUnit.SECONDS.sleep(1);
        }

        return quantum;
    }
}
