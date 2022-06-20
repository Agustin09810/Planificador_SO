/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package equipo3.planificador;

import java.awt.Color;
import java.util.LinkedList;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

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
    private CPU cpu = new CPU();
    private boolean enEjecucion = false;
    private int totalTiempoReal=0;
    private int totalInteractivos=0;
    private int totalBatch=0;
    private boolean tableUpdateStatus = true;
    //Componentes UI
    private JLabel estadoPlanificador;
    private JProgressBar progressTiempoReal;
    private JProgressBar progressInteractivos;
    private JProgressBar progressBatch;
    private DefaultTableModel tablaProcesos;
    private JTextArea estados;
    private DefaultTableModel tablaBloqueados;
    

    public Planificador(DefaultTableModel tablaProcesos, DefaultTableModel tablaBloqueados, JProgressBar progressTiempoReal ,JProgressBar progressInteractivos, JProgressBar progressBatch, JTextArea estados, JLabel estadoPlanificador ){
        this.tablaProcesos = tablaProcesos;
        this.tablaBloqueados =  tablaBloqueados;
        this.progressTiempoReal = progressTiempoReal;
        this.progressTiempoReal.setStringPainted(true);
        this.progressTiempoReal.setValue(0);

        this.progressInteractivos = progressInteractivos;
        this.progressInteractivos.setStringPainted(true);
        this.progressInteractivos.setValue(0);
        
        this.progressBatch = progressBatch;
        this.progressBatch.setStringPainted(true);
        this.progressBatch.setValue(0);
        
        this.estados = estados;
        this.estadoPlanificador = estadoPlanificador;
    }
    
    public boolean agregarProceso(Proceso proc) {
        if (null == proc.getTipo()) {
            return false;
        } else switch (proc.getTipo()) {
            case INTERACTIVO:
                totalInteractivos++;
                estados.append("Proceso "+proc.getNombre()+"con ID "+proc.getID()+" se agregó a cola de interactivos \n");
                interactivos.add(proc);
                interactivos.sort(new comparadorPrioridad());
                break;
            case BATCH:
                totalBatch++;
                estados.append("Proceso "+proc.getNombre()+"con ID "+proc.getID()+" se agregó a cola de batch \n");
                batch.add(proc);
                break;
            case TIEMPOREAL:
                totalTiempoReal++;
                estados.append("Proceso "+proc.getNombre()+"con ID "+proc.getID()+" se agregó a cola de tiempo real \n");
                tiempoReal.add(proc);
                break;
            default:
                return false;
        }
        //cargarTablaProcesos();
        return true;
        
    }

    public void actualizarComponentesUI(){
        
        //Actualización asíncrona de tabla de procesos
        SwingUtilities.invokeLater(new Runnable(){public void run(){
            //cuando el mouse se posiciona sobre la tabla se detiene la edicion para poder seleccionar mejor los procesos
            if(tableUpdateStatus){
                if(tablaProcesos.getRowCount()>0){
                   tablaProcesos.setRowCount(0);
                   tablaProcesos.fireTableDataChanged();
                }
                LinkedList<Proceso> todos = new LinkedList<Proceso>();
                todos.addAll(interactivos);
                todos.addAll(tiempoReal);
                todos.addAll(batch);
                todos.addAll(finalizados);
                todos.addAll(bloqueados);
                for(Proceso actual : todos){
                    tablaProcesos.addRow(actual.imprimirProcesos(";").split(";"));
                    
                    tablaProcesos.fireTableDataChanged();
                } 
            }
            
            // actualizo tabla de bloqueados
            if(tablaBloqueados.getRowCount()>0){
                   tablaBloqueados.setRowCount(0);
                   tablaBloqueados.fireTableDataChanged();
            }
            for(Proceso procesoBloqueado : bloqueados){
                tablaBloqueados.addRow(new String[]{String.valueOf(procesoBloqueado.getID()),String.valueOf(procesoBloqueado.getTiempoBloqueado())});
                tablaBloqueados.fireTableDataChanged();
            }
        }});
        
        //progressBar
        if(totalTiempoReal != 0)
        progressTiempoReal.setValue(100 - (int)tiempoReal.size() * 100 / totalTiempoReal);
       
        if(totalInteractivos != 0)
        progressInteractivos.setValue(100 - (int)interactivos.size() * 100 / totalInteractivos);        
       
        if(totalBatch != 0)
        progressBatch.setValue(100 - (int)batch.size() * 100 / totalBatch);   

        // Etiqueta de estado del planificador
        if(this.enEjecucion){
            estadoPlanificador.setForeground(Color.green);
            estadoPlanificador.setText("En Ejecucion..");

        //No a comenzado o finalizo
        } else {
            estadoPlanificador.setForeground(Color.red);
            estadoPlanificador.setText("DETENIDO");
        }
                
    }
    
    public void procesarProcesos() throws InterruptedException {
        Proceso proc;
        this.enEjecucion = true;
        while (enEjecucion && (!tiempoReal.isEmpty() || !interactivos.isEmpty() || !batch.isEmpty())) {
            actualizarComponentesUI();
            //Verificar si tiemporeal no es vacía.
            // comienzo RoundRobin
            
            if(!tiempoReal.isEmpty()){
                Proceso procesoActual = tiempoReal.getFirst();
                estados.append("Proceso "+procesoActual.getNombre()+" con ID "+procesoActual.getID()+" ingreso al CPU \n");
                int resto = cpu.procesarProceso(procesoActual, QUANTUM_TIEMPO_REAL, bloqueados); //??
                if(procesoActual.getEstado() == Estado.EJECUCION){
                   tiempoReal.remove(procesoActual);
                   tiempoReal.addLast(procesoActual);
                   procesoActual.setEstado(Estado.LISTO);
                }
                estados.append("Proceso "+procesoActual.getNombre()+" con ID "+procesoActual.getID()+" salió del CPU \n");
                reasignarProcesos(procesoActual, tiempoReal);
                chequearBloqueados();
                continue;
            }
            else if(!interactivos.isEmpty()){ //HRN
                Proceso procesoActual = interactivos.getFirst(); //agarra el primero de la lista de interactivos(el que tiene mas prioridad)
                estados.append("Proceso "+procesoActual.getNombre()+" con ID "+procesoActual.getID()+" ingreso al CPU \n");
                int resto = cpu.procesarProceso(procesoActual, QUANTUM_INTERACTIVO, bloqueados); //lo manda al procesador para que lo procese
                estados.append("Proceso "+procesoActual.getNombre()+" con ID "+procesoActual.getID()+" salió del CPU \n");
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
                estados.append("Proceso "+procesoActual.getNombre()+" con ID "+procesoActual.getID()+" ingreso al CPU \n");
                int resto = cpu.procesarProceso(procesoActual, QUANTUM_BATCH, bloqueados);
                estados.append("Proceso "+procesoActual.getNombre()+" con ID "+procesoActual.getID()+" salió del CPU \n");
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

        this.enEjecucion = false;
        desbloqueos();
        actualizarComponentesUI();
    }
    //Se encarga de desbloquear aquellos procesos que el cpu no pudo decrementar el tiempo de bloqueado.
    private void desbloqueos() throws InterruptedException{
        while(!bloqueados.isEmpty()){
          chequearBloqueados();
            
          for(Proceso procesoBloqueado : bloqueados) {
              if(procesoBloqueado.getTiempoBloqueado() > 0){
                  procesoBloqueado.setTiempoBloqueado(procesoBloqueado.getTiempoBloqueado()-1.d);
              } else {
                    this.enEjecucion = true;
              }
          }
          TimeUnit.SECONDS.sleep(1);
          procesarProcesos();
          
        }
    }
    
    public void reasignarProcesos(Proceso proc, LinkedList<Proceso> listaProcesos) {
        if(proc.getEstado() == Estado.FINALIZADO){
            listaProcesos.remove(proc);
            proc.tiempoFinalizadoAhora();
            estados.append("Proceso "+proc.getNombre()+" con ID "+proc.getID()+" finalizó \n");
            finalizados.add(proc);                    
        } else if(proc.getEstado() == Estado.BLOQUEADO) {
            listaProcesos.remove(proc);
            estados.append("Proceso "+proc.getNombre()+" con ID "+proc.getID()+" ingresó a cola de bloqueados \n");
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
                        estados.append("Proceso "+p.getNombre()+" con ID "+p.getID()+" salió de cola de bloqueados \n");
                        tiempoReal.add(p);
                    }
                }
                if(p.getTipo() == Tipo.INTERACTIVO){
                    if(p.getTiempoBloqueado()<= 0.d){
                        iterador.remove();
                        p.setEstado(Estado.LISTO);
                        estados.append("Proceso "+p.getNombre()+" con ID "+p.getID()+" salió de cola de bloqueados \n");
                        interactivos.add(p);
                    }
                }
                if(p.getTipo() == Tipo.BATCH){
                    if(p.getTiempoBloqueado()<= 0.d){
                        iterador.remove();
                        p.setEstado(Estado.LISTO);
                        estados.append("Proceso "+p.getNombre()+" con ID "+p.getID()+" salió de cola de bloqueados \n");
                        batch.add(p);
                    }
                }
            }
        }
    }
    
    public boolean cambiarPrioridad(Proceso proc, int prioridad){
        if(prioridad < 1 || prioridad > 99){
            return false;
        }
        else if(prioridad >= 1 && prioridad <= 20){
            proc.setPrioridad(prioridad);
            proc.setTipo(Tipo.TIEMPOREAL);
            if(!tiempoReal.contains(proc)){
                cambiarPrioridadAux(proc);
                estados.append("Proceso "+proc.getNombre()+" con ID "+proc.getID()+" Ahora es de tipo tiempo real \n");
                tiempoReal.add(proc);
            }
        }
        else if(prioridad >= 21 && prioridad <= 70){
            proc.setPrioridad(prioridad);
            proc.setTipo(Tipo.INTERACTIVO);
            if(!interactivos.contains(proc)){
                cambiarPrioridadAux(proc);
                estados.append("Proceso "+proc.getNombre()+" con ID "+proc.getID()+" Ahora es de tipo interactivo \n");
                interactivos.add(proc);
            }
            interactivos.sort(new comparadorPrioridad());
        }
        else if(prioridad >= 71 && prioridad <= 99){
            proc.setPrioridad(prioridad);
            proc.setTipo(Tipo.BATCH);
            if(!batch.contains(proc)){
                cambiarPrioridadAux(proc);
                estados.append("Proceso "+proc.getNombre()+" con ID "+proc.getID()+" Ahora es de tipo tiempo batch \n");
                batch.add(proc);
            }
            batch.sort(new comparadorTiempo());
        }
        return true;
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
    
    public void bloqueoManual(Proceso proc, boolean bloquear){
        if(bloquear){
            proc.setEstado(Estado.BLOQUEADO);
            if(tiempoReal.contains(proc))
                tiempoReal.remove(proc);
            if(interactivos.contains(proc))
                interactivos.remove(proc);
            if(batch.contains(proc))
                batch.remove(proc);
            proc.setTiempoBloqueado(Double.POSITIVE_INFINITY);
            if(!bloqueados.contains(proc))
                bloqueados.add(proc);
        } else {
            proc.setTiempoBloqueado(0.d);
            chequearBloqueados();
        }
        actualizarComponentesUI();

    }
    
    public boolean limpiarFinalizados(){
        if(!enEjecucion){
            this.finalizados.clear();
            actualizarComponentesUI();
            return true;
        }
        return false;
    }
    
    public boolean getEstadoPlanificador(){
        return this.enEjecucion;
    }
    
    public Proceso getProcesoPorId(String id) {
       LinkedList<Proceso> todos = new LinkedList<Proceso>();
        todos.addAll(interactivos);
        todos.addAll(tiempoReal);
        todos.addAll(batch);
        todos.addAll(bloqueados);
        for(Proceso proceso : todos){
            if(proceso.getID() == Integer.parseInt(id)){
                return proceso;
            }
        }
        return null;
    }
    
    public void setTableUpdate(boolean status){
        if(status){
            tableUpdateStatus=true;
        } else {
            tableUpdateStatus=false;
        }
    }
            
}
