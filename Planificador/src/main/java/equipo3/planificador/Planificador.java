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
    private CPU cpu = new CPU();

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

            //Verificar si tiemporeal no es vacía.
            // comienzo RoundRobin
            if(!tiempoReal.isEmpty()){
                Proceso procesoActual = tiempoReal.getFirst();
                int resto = cpu.procesarProceso(procesoActual, QUANTUM_TIEMPO_REAL, bloqueados);
                reasignarProcesos(procesoActual, interactivos);
                
                continue;
            }
        }
    }
    
    public void reasignarProcesos(Proceso proc, LinkedList<Proceso> listaProcesos) {
        if(proc.getEstado() == Estado.FINALIZADO){
            tiempoReal.remove(proc);
            finalizados.add(proc);
            //obtener tiempo de finalizado para mostrarlo en la interfaz gráfica.                        
        } else if(proc.getEstado() == Estado.BLOQUEADO) {
            tiempoReal.remove(proc);
            bloqueados.add(proc);
        }
        
        if(!bloqueados.isEmpty()){
            for(Proceso p : bloqueados){
                if(p.getTiempoBloqueado()==0){
                    bloqueados.remove(p);
                    listaProcesos.add(p);
                }
            }
        }
        
    }
}
