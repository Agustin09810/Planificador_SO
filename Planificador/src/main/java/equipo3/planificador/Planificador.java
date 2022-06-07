/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package equipo3.planificador;

import java.util.LinkedList;

/**
 *
 * @author Administrador
 */
public class Planificador {

    private LinkedList<Proceso> tiempoReal = new LinkedList<>();
    private LinkedList<Proceso> interactivos = new LinkedList<>();
    private LinkedList<Proceso> batch = new LinkedList<>();
    private LinkedList<Proceso> bloqueados = new LinkedList<>();
    private LinkedList<Proceso> finalizados = new LinkedList<>();
    private static final int QUANTUM_TIEMPO_REAL = 1;
    private static final int QUANTUM_INTERACTIVO = 2;
    private static final int QUANTUM_BATCH = 3;

    public boolean agregarProceso(Proceso proc) {
        if (proc.getTipo() == Tipo.INTERACTIVOS) {
            interactivos.add(proc);
        } else if (proc.getTipo() == Tipo.BATCH) {
            batch.add(proc);
        } else {
            return false;
        }
        return true;
    }

    public void procesarProcesos() {
        Proceso proc;
        while (!tiempoReal.isEmpty() || !interactivos.isEmpty() || !batch.isEmpty()) {

            if (!tiempoReal.isEmpty()) {
                proc = tiempoReal.removeFirst();
                tiempoReal.add(proc);
                if (proc.getTiempoRestante() == 0) {
                    finalizados.add(proc);
                } else {
                    bloqueados.add(proc);
                }
            }
            if (!batch.isEmpty()) {
                proc = batch.removeFirst();
                tiempoReal.add(proc);
                if (proc.getTiempoRestante() == 0) {
                    finalizados.add(proc);
                } else {
                    bloqueados.add(proc);
                }
            }
        }
    }
}
