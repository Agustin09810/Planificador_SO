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
        if (null == proc.getTipo()) {
            return false;
        } else switch (proc.getTipo()) {
            case INTERACTIVO:
                interactivos.add(proc);
                interactivos.sort(new comparadorPrioridad());
                break;
            case BATCH:
                batch.add(proc);
                break;
            case TIEMPOREAL:
                tiempoReal.add(proc);
                break;
            default:
                System.out.println("El proceso debe de ser de tipo TIEMPOREAL, INTERACTIVO o BATCH ");
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
