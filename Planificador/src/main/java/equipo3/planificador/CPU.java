/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipo3.planificador;

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

    public int procesarProceso(Proceso proc, int quantum) {
        while (quantum > 0) {
            if (proc.getEstado() == Estado.LISTO) {

                proc.decrementarTiempoRestante();
                if (proc.getTiempoRestante() <= 0) {
                    proc.setEstado(Estado.FINALIZADO);
                    return quantum;
                }
                if (proc.getEntradaSalida().containsKey(proc.getTiempoEjecucionActual())) {
                    proc.setEstado(Estado.BLOQUEADO);
                    return quantum;
                }
                quantum--;
            }
        }
        return quantum;
    }
}
