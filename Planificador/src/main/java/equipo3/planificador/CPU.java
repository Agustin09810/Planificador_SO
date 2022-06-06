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
    
    public CPU(){}
    
    public Proceso getProcesoActual(){
        return this.procesoActual;
    }
    
    public void setProcesoActual(Proceso proceso){
        this.procesoActual = proceso;
    }
}
