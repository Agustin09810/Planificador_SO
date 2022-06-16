/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipo3.planificador;

import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Planificador");
        // Crear planificador
       // Planificador plan = new Planificador();
        // Crear UI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
                
            }
        });
        
    }
}
