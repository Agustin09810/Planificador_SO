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
public class comparadorTiempo implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Proceso p1 = (Proceso) o1;
        Proceso p2 = (Proceso) o2;
        return(p1.getTiempoCreacion().compareTo(p2.getTiempoCreacion()));
    }
}
