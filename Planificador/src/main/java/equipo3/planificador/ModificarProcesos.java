/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package equipo3.planificador;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolascartalla
 */
public class ModificarProcesos extends javax.swing.JDialog {

    /**
     * Creates new form ModificarProcesos
     */
    public ModificarProcesos(java.awt.Frame parent, boolean modal, String id, String nombre, String prioridad, boolean bloqueado, Tipo tipo, Planificador planificador) {
        super(parent, modal);
        initComponents();
        procesoId.setText(id);
        procesoNombre.setText(nombre);
        procesoPrioridad.setText(prioridad);
        this.tipoProceso = tipo;
        this.planificador = planificador;
        if(bloqueado){
          procesoBloqueado.setText("Desbloquear");
        } else {
           procesoBloqueado.setText("Bloquear"); 
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        JPCrearProcesoManual = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        procesoPrioridad = new javax.swing.JTextField();
        procesoNombre = new javax.swing.JTextField();
        procesoId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        procesoBloqueado = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        editarProceso = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setTitle("Editar Proceso");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setText("Modificar Proceso");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        JPCrearProcesoManual.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        JPCrearProcesoManual.setOpaque(false);

        jLabel2.setText("Prioridad");

        jLabel3.setText("Nombre");

        procesoPrioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesoPrioridadActionPerformed(evt);
            }
        });
        procesoPrioridad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                procesoPrioridadKeyTyped(evt);
            }
        });

        procesoNombre.setEditable(false);
        procesoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesoNombreActionPerformed(evt);
            }
        });

        procesoId.setEditable(false);
        procesoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesoIdActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        procesoBloqueado.setText("Bloquear");

        jLabel7.setText("Bloquear/Desbloquear");

        editarProceso.setBackground(new java.awt.Color(0, 134, 190));
        editarProceso.setFont(new java.awt.Font("Roboto Mono Medium for Powerline", 1, 13)); // NOI18N
        editarProceso.setText("Editar Proceso");
        editarProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarProcesoActionPerformed(evt);
            }
        });

        cancelar.setBackground(new java.awt.Color(0, 134, 190));
        cancelar.setFont(new java.awt.Font("Roboto Mono Medium for Powerline", 1, 13)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPCrearProcesoManualLayout = new javax.swing.GroupLayout(JPCrearProcesoManual);
        JPCrearProcesoManual.setLayout(JPCrearProcesoManualLayout);
        JPCrearProcesoManualLayout.setHorizontalGroup(
            JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPCrearProcesoManualLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPCrearProcesoManualLayout.createSequentialGroup()
                        .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPCrearProcesoManualLayout.createSequentialGroup()
                                .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(procesoNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPCrearProcesoManualLayout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(procesoPrioridad))
                                    .addComponent(procesoId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPCrearProcesoManualLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(80, 80, 80)
                                .addComponent(procesoBloqueado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(15, 15, 15))
                    .addGroup(JPCrearProcesoManualLayout.createSequentialGroup()
                        .addComponent(editarProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(cancelar)
                        .addContainerGap(18, Short.MAX_VALUE))))
        );
        JPCrearProcesoManualLayout.setVerticalGroup(
            JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPCrearProcesoManualLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(procesoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(procesoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(procesoPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(procesoBloqueado)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editarProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        procesoPrioridad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    evt.consume();
                }
            }
        });

        bg.add(JPCrearProcesoManual, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 330, 210));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 270));

        getAccessibleContext().setAccessibleDescription("");
        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void procesoPrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesoPrioridadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_procesoPrioridadActionPerformed

    private void procesoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_procesoNombreActionPerformed

    private void editarProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarProcesoActionPerformed
        // TODO add your handling code here:
        int prioridad = Integer.parseInt(procesoPrioridad.getText());
        if(tipoProceso == Tipo.TIEMPOREAL && (prioridad >20)){
            JOptionPane.showMessageDialog(rootPane, "No se puede mover la prioridad de un proceso tiempo real a interactivo o Batch", "Editar Prioridad",JOptionPane.ERROR_MESSAGE);
        } else {
            Proceso proceso = planificador.getProcesoPorId(procesoId.getText());
            if(proceso != null){
                
                boolean cambioPrioridad = planificador.cambiarPrioridad(proceso, prioridad);
                if(!cambioPrioridad)
                    JOptionPane.showMessageDialog(rootPane, "Ingrese una prioridad valida entre 1 y 99", "Editar Prioridad",JOptionPane.ERROR_MESSAGE);

                
                if(procesoBloqueado.isSelected() && procesoBloqueado.getText() == "Bloquear"){
                        planificador.bloqueoManual(proceso,true);
                }
                if(procesoBloqueado.isSelected() && procesoBloqueado.getText() == "Desbloquear"){
                        planificador.bloqueoManual(proceso, false);
                }
                planificador.actualizarComponentesUI();
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se puede modificar el proceso actual, el proceso ya finalizo", "Editar Proceso",JOptionPane.ERROR_MESSAGE);
                    planificador.setTableUpdate(true);
                    planificador.actualizarComponentesUI();
            dispose();
            }
           
        }
        
        planificador.setTableUpdate(true);
        planificador.actualizarComponentesUI();
        dispose();
    }//GEN-LAST:event_editarProcesoActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        planificador.setTableUpdate(true);
        planificador.actualizarComponentesUI();
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void procesoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesoIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_procesoIdActionPerformed

    private void procesoPrioridadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_procesoPrioridadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_procesoPrioridadKeyTyped
    private Tipo tipoProceso;
    private Planificador planificador;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPCrearProcesoManual;
    private javax.swing.JPanel bg;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton editarProceso;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton procesoBloqueado;
    private javax.swing.JTextField procesoId;
    private javax.swing.JTextField procesoNombre;
    private javax.swing.JTextField procesoPrioridad;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
