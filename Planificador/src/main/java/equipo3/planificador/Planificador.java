/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package equipo3.planificador;

import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import java.util.Iterator;

/**
 *
 * @author Administrador
 */
public class Planificador{

    private LinkedList<Proceso> tiempoReal = new LinkedList<>();
    private LinkedList<Proceso> interactivos = new LinkedList<>();
    private LinkedList<Proceso> batch = new LinkedList<>();
    private LinkedList<Proceso> bloqueados = new LinkedList<>();
    private LinkedList<Proceso> finalizados = new LinkedList<>();
    private static final int QUANTUM_TIEMPO_REAL = 1;
    private static final int QUANTUM_INTERACTIVO = 2;
    private static final int QUANTUM_BATCH = 3;
    private DefaultTableModel tablaProcesos;
    private CPU cpu = new CPU();

    public Planificador(DefaultTableModel tablaProcesos){
        this.tablaProcesos = tablaProcesos;
    }
    
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
        //cargarTablaProcesos();
        return true;
        
    }

    private void cargarTablaProcesos(){
        tablaProcesos.setRowCount(0);
        
        LinkedList<Proceso> todos = new LinkedList<Proceso>();
        todos.addAll(interactivos);
        todos.addAll(tiempoReal);
        todos.addAll(batch);
        todos.addAll(finalizados);
        todos.addAll(bloqueados);
        for(Proceso actual : todos){
            this.tablaProcesos.addRow(actual.imprimirProcesos(";").split(";"));
        }

    }
    
    public void procesarProcesos() throws InterruptedException {
        Proceso proc;
        
        while (!tiempoReal.isEmpty() || !interactivos.isEmpty() || !batch.isEmpty()) {
            cargarTablaProcesos();
            //Verificar si tiemporeal no es vacía.
            // comienzo RoundRobin
            
            if(!tiempoReal.isEmpty()){
                Proceso procesoActual = tiempoReal.getFirst();
                System.out.println("Procesando.. "+procesoActual.imprimirProcesos("-"));
                int resto = cpu.procesarProceso(procesoActual, QUANTUM_TIEMPO_REAL, bloqueados); //??
                reasignarProcesos(procesoActual, tiempoReal);
                chequearBloqueados();
                continue;
            }
            else if(!interactivos.isEmpty()){ //HRN
                Proceso procesoActual = interactivos.getFirst(); //agarra el primero de la lista de interactivos(el que tiene mas prioridad)
                System.out.println("Procesando.. "+procesoActual.imprimirProcesos("-"));
                int resto = cpu.procesarProceso(procesoActual, QUANTUM_INTERACTIVO, bloqueados); //lo manda al procesador para que lo procese
                reasignarProcesos(procesoActual, interactivos); //Una vez terminado, se llama al proceso reasignarProcesos
                chequearBloqueados(); //proceso cheaquear bloqueados
                if(procesoActual.getEstado() == Estado.EJECUCION) //Si el proceso no se termino ni se bloqueo, se baja en uno su prioridad debido a que ya tuvo tiempo de CPU. para cumplir con el HRN
                    procesoActual.setPrioridad(procesoActual.getPrioridad() + 1);//VERIFICACION
                interactivos.sort(new comparadorPrioridad()); //Se reordenan los proceso por prioridad por si hubo algun cambio
                if(procesoActual.getEstado() != Estado.FINALIZADO && procesoActual.getEstado() != Estado.BLOQUEADO){
                    if(interactivos.getFirst() != procesoActual)
                        procesoActual.setEstado(Estado.LISTO);
                }
                continue;
            }
            else if(!batch.isEmpty()){
                Proceso procesoActual = batch.getFirst();
                System.out.println("Procesando.. "+procesoActual.imprimirProcesos("-"));
                int resto = cpu.procesarProceso(procesoActual, QUANTUM_BATCH, bloqueados);
                reasignarProcesos(procesoActual, batch);
                chequearBloqueados();
                batch.sort(new comparadorTiempo()); //Se reordenan por orden de llegada, por si hubo algun cambio en la lista.
                if(procesoActual.getEstado() != Estado.FINALIZADO && procesoActual.getEstado() != Estado.BLOQUEADO){
                    if(batch.getFirst() != procesoActual)
                        procesoActual.setEstado(Estado.LISTO);
                }
                continue;
            }          
        }
        cargarTablaProcesos();
    }
    
    public void reasignarProcesos(Proceso proc, LinkedList<Proceso> listaProcesos) {
        if(proc.getEstado() == Estado.FINALIZADO){
            listaProcesos.remove(proc);
            proc.tiempoFinalizadoAhora();
            finalizados.add(proc);                    
        } else if(proc.getEstado() == Estado.BLOQUEADO) {
            listaProcesos.remove(proc);
            bloqueados.add(proc);
        }
    }
    public void chequearBloqueados(){
        if(!bloqueados.isEmpty()){
            for(Iterator<Proceso> iterador = bloqueados.iterator(); iterador.hasNext();){
                Proceso p = iterador.next();
                if(p.getTipo() == Tipo.TIEMPOREAL){
                    if(p.getTiempoBloqueado()<= 0.d){
                        iterador.remove();
                        p.setEstado(Estado.LISTO);
                        tiempoReal.add(p);
                    }
                }
                if(p.getTipo() == Tipo.INTERACTIVO){
                    if(p.getTiempoBloqueado()<= 0.d){
                        iterador.remove();
                        p.setEstado(Estado.LISTO);
                        interactivos.add(p);
                    }
                }
                if(p.getTipo() == Tipo.BATCH){
                    if(p.getTiempoBloqueado()<= 0.d){
                        iterador.remove();
                        p.setEstado(Estado.LISTO);
                        batch.add(p);
                    }
                }
            }
        }
    }
    
    public void cambiarPrioridad(Proceso proc, int prioridad){
        if(prioridad < 1 || prioridad > 99){
            System.out.println("ERROR: No se puede crear proceso, prioridad debe ser entre 1 y 99");
            System.exit(1);
        }
        else if(prioridad >= 1 && prioridad <= 20){
            proc.setPrioridad(prioridad);
            proc.setTipo(Tipo.TIEMPOREAL);
            if(!tiempoReal.contains(proc)){
                cambiarPrioridadAux(proc);
                tiempoReal.add(proc);
            }
        }
        else if(prioridad >= 21 && prioridad <= 70){
            proc.setPrioridad(prioridad);
            proc.setTipo(Tipo.INTERACTIVO);
            if(!interactivos.contains(proc)){
                cambiarPrioridadAux(proc);
                interactivos.add(proc);
            }
            interactivos.sort(new comparadorPrioridad());
        }
        else if(prioridad >= 71 && prioridad <= 99){
            proc.setPrioridad(prioridad);
            proc.setTipo(Tipo.BATCH);
            if(!batch.contains(proc)){
                cambiarPrioridadAux(proc);
                batch.add(proc);
            }
            batch.sort(new comparadorTiempo());
        }
        //QUE PASA CON LOS BLOQUEADOS?????????????
    }
    
    public void cambiarPrioridadAux(Proceso proc){
        if(tiempoReal.contains(proc))
            tiempoReal.remove(proc);
        if(interactivos.contains(proc))
            interactivos.remove(proc);
        if(batch.contains(proc))
            batch.remove(proc);
    }
    
    public void bloqueoManual(Proceso proc){
        proc.setEstado(Estado.BLOQUEADO);
        if(tiempoReal.contains(proc))
            tiempoReal.remove(proc);
        if(interactivos.contains(proc))
            interactivos.remove(proc);
        if(batch.contains(proc))
            batch.remove(proc);
        proc.setTiempoBloqueado(Double.POSITIVE_INFINITY);
        bloqueados.add(proc);
    }
            
}
