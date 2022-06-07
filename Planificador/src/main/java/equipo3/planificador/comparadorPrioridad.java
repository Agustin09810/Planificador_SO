/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipo3.planificador;
import java.util.Comparator;
/**
 *
 * @author Administrador
 */
public class comparadorPrioridad implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Proceso p1 = (Proceso) o1;
        Proceso p2 = (Proceso) o2;
        if(p1.getPrioridad() > p2.getPrioridad())
            return 1;
        if(p2.getPrioridad() > p1.getPrioridad())
            return -1;
        else 
            return 0;
    }
}
