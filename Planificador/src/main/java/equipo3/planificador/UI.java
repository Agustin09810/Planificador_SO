package equipo3.planificador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UI extends javax.swing.JFrame {
    
    int xMouse, yMouse;
    private Planificador planificador;
    
    public UI() {
        initComponents();
        DefaultTableModel tablaProcesos = (DefaultTableModel)TablaProcesos.getModel();
        this.planificador = new Planificador(tablaProcesos);
    }
    
    public UI(Planificador planificador) {
        this.planificador = planificador;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        bg = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProcesos = new javax.swing.JTable();
        JPCrearProcesoManual = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        procesoES = new javax.swing.JTextField();
        procesoPrioridad = new javax.swing.JTextField();
        procesoNombre = new javax.swing.JTextField();
        userLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        procesoDuracion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPCargarProcesos1 = new javax.swing.JPanel();
        jPCargarProcesos2 = new javax.swing.JPanel();
        CargarProcesosArchivo = new javax.swing.JButton();
        userLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jProgressBar3 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));

        exitTxt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitTxt.setPreferredSize(new java.awt.Dimension(40, 40));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 800, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 40));

        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setText("Planificador");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setText("Carga desde Archivo");
        bg.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 20));

        TablaProcesos.setAutoCreateRowSorter(true);
        TablaProcesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tipo", "Ingreso", "T. Restante", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaProcesos.setComponentPopupMenu(jPopupMenu1);
        TablaProcesos.setEditingColumn(0);
        TablaProcesos.setEditingRow(0);
        TablaProcesos.setFocusTraversalKeysEnabled(false);
        TablaProcesos.setFocusTraversalPolicyProvider(true);
        TablaProcesos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        TablaProcesos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TablaProcesos.setShowGrid(true);
        TablaProcesos.setShowHorizontalLines(true);
        TablaProcesos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProcesosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaProcesos);
        TablaProcesos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 610, 140));

        JPCrearProcesoManual.setOpaque(false);

        jLabel2.setText("Prioridad");

        jLabel3.setText("Nombre");

        jLabel4.setText("E/S");

        procesoPrioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesoPrioridadActionPerformed(evt);
            }
        });

        procesoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesoNombreActionPerformed(evt);
            }
        });

        userLabel2.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel2.setText("Carga Manual de Procesos");

        jButton1.setBackground(new java.awt.Color(0, 134, 190));
        jButton1.setFont(new java.awt.Font("Roboto Mono Medium for Powerline", 1, 13)); // NOI18N
        jButton1.setText("Crear Proceso");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        procesoDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesoDuracionActionPerformed(evt);
            }
        });

        jLabel5.setText("Duracion");

        javax.swing.GroupLayout JPCrearProcesoManualLayout = new javax.swing.GroupLayout(JPCrearProcesoManual);
        JPCrearProcesoManual.setLayout(JPCrearProcesoManualLayout);
        JPCrearProcesoManualLayout.setHorizontalGroup(
            JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPCrearProcesoManualLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPCrearProcesoManualLayout.createSequentialGroup()
                        .addComponent(userLabel2)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPCrearProcesoManualLayout.createSequentialGroup()
                        .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JPCrearProcesoManualLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(procesoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPCrearProcesoManualLayout.createSequentialGroup()
                                .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(procesoNombre)
                                    .addGroup(JPCrearProcesoManualLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(procesoPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(JPCrearProcesoManualLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(procesoES, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))))
            .addGroup(JPCrearProcesoManualLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JPCrearProcesoManualLayout.setVerticalGroup(
            JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPCrearProcesoManualLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(procesoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(procesoPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(procesoDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(procesoES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bg.add(JPCrearProcesoManual, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 210, 210));

        jPanel1.setOpaque(false);

        jPCargarProcesos1.setBackground(new java.awt.Color(0, 134, 190));

        javax.swing.GroupLayout jPCargarProcesos1Layout = new javax.swing.GroupLayout(jPCargarProcesos1);
        jPCargarProcesos1.setLayout(jPCargarProcesos1Layout);
        jPCargarProcesos1Layout.setHorizontalGroup(
            jPCargarProcesos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPCargarProcesos1Layout.setVerticalGroup(
            jPCargarProcesos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPCargarProcesos2.setBackground(new java.awt.Color(0, 134, 190));

        javax.swing.GroupLayout jPCargarProcesos2Layout = new javax.swing.GroupLayout(jPCargarProcesos2);
        jPCargarProcesos2.setLayout(jPCargarProcesos2Layout);
        jPCargarProcesos2Layout.setHorizontalGroup(
            jPCargarProcesos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPCargarProcesos2Layout.setVerticalGroup(
            jPCargarProcesos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        CargarProcesosArchivo.setBackground(new java.awt.Color(0, 134, 190));
        CargarProcesosArchivo.setFont(new java.awt.Font("Roboto Mono Medium for Powerline", 1, 13)); // NOI18N
        CargarProcesosArchivo.setText("Cargar Procesos");
        CargarProcesosArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CargarProcesosArchivoMouseClicked(evt);
            }
        });
        CargarProcesosArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarProcesosArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPCargarProcesos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPCargarProcesos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(CargarProcesosArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(CargarProcesosArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCargarProcesos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCargarProcesos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 210, 150));

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setText("Procesos");
        bg.add(userLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, 20));
        bg.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 220, 30));
        bg.add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 220, 30));
        bg.add(jProgressBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 220, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(Color.white);
        exitTxt.setForeground(Color.black);
    }//GEN-LAST:event_exitTxtMouseExited

    private void procesoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_procesoNombreActionPerformed

    private void procesoPrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesoPrioridadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_procesoPrioridadActionPerformed

    private void CargarProcesosArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarProcesosArchivoActionPerformed
        // TODO add your handling code here:
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(this);
            if(option == JFileChooser.APPROVE_OPTION){
               File file = fileChooser.getSelectedFile();
               if(file.isFile() && file.canRead()) {
                   String[] procesos = ManejadorArchivosGenerico.leerArchivo(file.getAbsolutePath());
                   for(String linea : procesos){
                       String[] proceso = linea.split(";");
                       
                       //get hashmap Entrada Salida
                       HashMap<Integer,Integer> entradaSalida = new HashMap();
                       for(String es : proceso[3].split(",")){
                           String key = es.split(":")[0];
                           String value = es.split(":")[1];
                         entradaSalida.put(Integer.parseInt(key), Integer.parseInt(value));
                       }                       
                       Proceso temp =  new Proceso(proceso[0], 
                                           Integer.parseInt(proceso[1]), 
                                           Integer.parseInt(proceso[2]), 
                                           entradaSalida);
                       planificador.agregarProceso(temp);
//                       DefaultTableModel dt = (DefaultTableModel)TablaProcesos.getModel();
//                       dt.addRow(temp.imprimirProcesos(";").split(";"));
                       
                   }
                   //nuevo hilo para el planificador
                   new Thread(new Runnable() {
                    public void run() {
                        try {
                            planificador.procesarProcesos();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    }).start();
                   
               }

         }
    }//GEN-LAST:event_CargarProcesosArchivoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

            String nombreProceso = procesoNombre.getText();
            int prioridadProceso = 0;
            int duracionProceso = 0;
            String esProceso = procesoES.getText();
          
          try {
                prioridadProceso = Integer.parseInt(procesoPrioridad.getText());
                duracionProceso = Integer.parseInt(procesoDuracion.getText());
                HashMap<Integer,Integer> entradaSalida = new HashMap();
                for(String es : esProceso.split(",")){
                    String key = es.split(":")[0];
                    String value = es.split(":")[1];
                    entradaSalida.put(Integer.getInteger(key), Integer.getInteger(value));
                  }                       
                  Proceso tempProceso =  new Proceso(nombreProceso, 
                                              prioridadProceso, 
                                              duracionProceso, 
                                              entradaSalida);
                  planificador.agregarProceso(tempProceso);
                   //nuevo hilo para el planificador
                   new Thread(new Runnable() {
                    public void run() {
                        try {
                            planificador.procesarProcesos();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    }).start();
                   

        } catch (Exception e) {
              JOptionPane.showMessageDialog(rootPane, "Error al leer datos del proceso", "Dialog",JOptionPane.ERROR_MESSAGE);
              
        } finally {
                  procesoNombre.setText("");
                  procesoPrioridad.setText("");
                  procesoDuracion.setText("");
                  procesoES.setText("");
          }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CargarProcesosArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CargarProcesosArchivoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CargarProcesosArchivoMouseClicked

    private void procesoDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesoDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_procesoDuracionActionPerformed

    private void TablaProcesosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProcesosMouseClicked
        // TODO add your handling code here:
            JTable target = (JTable)evt.getSource();
            int row = target.getSelectedRow();
            int colum = target.getSelectedColumn();
            JOptionPane.showMessageDialog(rootPane, "hiciste click en "+TablaProcesos.getValueAt(row, 0), "Dialog",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_TablaProcesosMouseClicked

    public javax.swing.JTable getTablaProcesos(){
        return this.TablaProcesos;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CargarProcesosArchivo;
    private javax.swing.JPanel JPCrearProcesoManual;
    private javax.swing.JTable TablaProcesos;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPCargarProcesos1;
    private javax.swing.JPanel jPCargarProcesos2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField procesoDuracion;
    private javax.swing.JTextField procesoES;
    private javax.swing.JTextField procesoNombre;
    private javax.swing.JTextField procesoPrioridad;
    private javax.swing.JLabel title;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    // End of variables declaration//GEN-END:variables
}
