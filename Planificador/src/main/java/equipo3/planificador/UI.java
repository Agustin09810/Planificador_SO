package equipo3.planificador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
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
        DefaultTableModel tablaBloqueados = (DefaultTableModel)TablaBloqueados.getModel();
        this.planificador = new Planificador(tablaProcesos,tablaBloqueados, ProgressTiempoReal, ProgressInteractivos, ProgressBatch, status,estadoPlanificador);
    }
    
    public UI(Planificador planificador) {
        this.planificador = planificador;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
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
        cargarProcesosManual = new javax.swing.JButton();
        procesoDuracion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPCargarProcesos1 = new javax.swing.JPanel();
        jPCargarProcesos2 = new javax.swing.JPanel();
        cargarProcesosArchivo = new javax.swing.JButton();
        limpiarFinalizados = new javax.swing.JButton();
        userLabel1 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        ProgressTiempoReal = new javax.swing.JProgressBar();
        ProgressInteractivos = new javax.swing.JProgressBar();
        ProgressBatch = new javax.swing.JProgressBar();
        userLabel3 = new javax.swing.JLabel();
        userLabel4 = new javax.swing.JLabel();
        userLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        status = new javax.swing.JTextArea();
        estadoPlanificador = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaBloqueados = new javax.swing.JTable();
        userLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        userLabel7 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitTxtMousePressed(evt);
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
        TablaProcesos.setFillsViewportHeight(true);
        TablaProcesos.setFocusTraversalPolicyProvider(true);
        TablaProcesos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        TablaProcesos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TablaProcesos.setShowGrid(true);
        TablaProcesos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProcesosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TablaProcesosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TablaProcesosMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(TablaProcesos);
        TablaProcesos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 680, 140));

        JPCrearProcesoManual.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
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

        cargarProcesosManual.setBackground(new java.awt.Color(0, 134, 190));
        cargarProcesosManual.setFont(new java.awt.Font("Roboto Mono Medium for Powerline", 1, 13)); // NOI18N
        cargarProcesosManual.setText("Crear Proceso");
        cargarProcesosManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarProcesosManualActionPerformed(evt);
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
                        .addContainerGap(13, Short.MAX_VALUE))
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
                .addComponent(cargarProcesosManual, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPCrearProcesoManualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(procesoES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(cargarProcesosManual, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        procesoDuracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    evt.consume();
                }
            }
        });

        bg.add(JPCrearProcesoManual, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 210, 220));

        jPanel1.setOpaque(false);

        jPCargarProcesos1.setBackground(new java.awt.Color(0, 134, 190));

        javax.swing.GroupLayout jPCargarProcesos1Layout = new javax.swing.GroupLayout(jPCargarProcesos1);
        jPCargarProcesos1.setLayout(jPCargarProcesos1Layout);
        jPCargarProcesos1Layout.setHorizontalGroup(
            jPCargarProcesos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPCargarProcesos1Layout.setVerticalGroup(
            jPCargarProcesos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        cargarProcesosArchivo.setBackground(new java.awt.Color(0, 134, 190));
        cargarProcesosArchivo.setFont(new java.awt.Font("Roboto Mono Medium for Powerline", 1, 13)); // NOI18N
        cargarProcesosArchivo.setText("Cargar Procesos");
        cargarProcesosArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargarProcesosArchivoMouseClicked(evt);
            }
        });
        cargarProcesosArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarProcesosArchivoActionPerformed(evt);
            }
        });

        limpiarFinalizados.setBackground(new java.awt.Color(0, 134, 190));
        limpiarFinalizados.setFont(new java.awt.Font("Roboto Mono Medium for Powerline", 1, 13)); // NOI18N
        limpiarFinalizados.setText("Limpiar Finalizados");
        limpiarFinalizados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limpiarFinalizadosMouseClicked(evt);
            }
        });
        limpiarFinalizados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarFinalizadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPCargarProcesos1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPCargarProcesos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cargarProcesosArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiarFinalizados, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCargarProcesos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPCargarProcesos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cargarProcesosArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(limpiarFinalizados, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 220, 150));

        userLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel1.setText("Eventos");
        bg.add(userLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 90, 20));

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado de colas"));

        ProgressTiempoReal.setMinimumSize(new java.awt.Dimension(10, 10));

        ProgressBatch.setToolTipText("");

        userLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel3.setText("Tiempo Real");

        userLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel4.setText("Interactivos");

        userLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel5.setText("Batch");

        jLayeredPane1.setLayer(ProgressTiempoReal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ProgressInteractivos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(ProgressBatch, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(userLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(userLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(userLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ProgressBatch, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(ProgressInteractivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProgressTiempoReal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(userLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ProgressTiempoReal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProgressInteractivos, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProgressBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        bg.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 220, 170));

        status.setEditable(false);
        status.setColumns(20);
        status.setRows(5);
        jScrollPane2.setViewportView(status);

        bg.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 450, 260));

        estadoPlanificador.setForeground(new java.awt.Color(255, 51, 51));
        estadoPlanificador.setText("DETENIDO");
        bg.add(estadoPlanificador, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 110, -1));

        TablaBloqueados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "T. Restante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TablaBloqueados);

        bg.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 220, 90));

        userLabel6.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel6.setText("Procesos");
        bg.add(userLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, 20));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 10, 450));

        userLabel7.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel7.setText("Bloqueados");
        bg.add(userLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 90, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
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

    private void cargarProcesosArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarProcesosArchivoActionPerformed
        // TODO add your handling code here:
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(this);
            if(option == JFileChooser.APPROVE_OPTION){
               File file = fileChooser.getSelectedFile();
               if(file.isFile() && file.canRead()) {
                   String[] procesos = ManejadorArchivosGenerico.leerArchivo(file.getAbsolutePath());
                   for(String linea : procesos){
                       String[] proceso = linea.split(";");
                       HashMap<Integer,Integer> entradaSalida = new HashMap();
                       if(proceso.length >3){
                        //get hashmap Entrada Salida            
                        for(String es : proceso[3].split(",")){
                            String key = es.split(":")[0];
                            String value = es.split(":")[1];
                          entradaSalida.put(Integer.parseInt(key), Integer.parseInt(value));
                        }                       
                       }
                       
                       Proceso temp =  new Proceso(proceso[0], 
                                           Integer.parseInt(proceso[1]), 
                                           Integer.parseInt(proceso[2]), 
                                           entradaSalida);
                       planificador.agregarProceso(temp);
                       
                   }
                   //nuevo hilo para el planificador
                   if(!planificador.getEstadoPlanificador()){
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

         }
    }//GEN-LAST:event_cargarProcesosArchivoActionPerformed

    private void cargarProcesosManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarProcesosManualActionPerformed

            String nombreProceso = procesoNombre.getText();
            int prioridadProceso = 0;
            int duracionProceso = 0;
            String esProceso = procesoES.getText();
          
          try {
                prioridadProceso = Integer.parseInt(procesoPrioridad.getText());
                if(prioridadProceso <= 20){
                    JOptionPane.showMessageDialog(rootPane, "No se puede ingresar un proceso manual con prioridad <20.\n Ingresado como interactivo con prioridad 21", "Dialog",JOptionPane.WARNING_MESSAGE);
                    prioridadProceso=21;
                }
                duracionProceso = Integer.parseInt(procesoDuracion.getText());
                HashMap<Integer,Integer> entradaSalida = new HashMap();
                if(esProceso.isBlank()){
                    entradaSalida.put(0,0);
                } else {
                  for(String es : esProceso.split(",")){
                    String key = es.split(":")[0];
                    String value = es.split(":")[1];
                    entradaSalida.put(Integer.parseInt(key), Integer.parseInt(value));
                  }
                    
                }
                       
                  Proceso tempProceso =  new Proceso(nombreProceso, 
                                              prioridadProceso, 
                                              duracionProceso, 
                                              entradaSalida);
                  planificador.agregarProceso(tempProceso);
                   //nuevo hilo para el planificador
                   if(!planificador.getEstadoPlanificador()){
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
                   

        } catch (Exception e) {
              JOptionPane.showMessageDialog(rootPane, "Error al leer datos del proceso", "Dialog",JOptionPane.ERROR_MESSAGE);
              
        } finally {
                  procesoNombre.setText("");
                  procesoPrioridad.setText("");
                  procesoDuracion.setText("");
                  procesoES.setText("");
          }
        
    }//GEN-LAST:event_cargarProcesosManualActionPerformed

    private void cargarProcesosArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarProcesosArchivoMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cargarProcesosArchivoMouseClicked

    private void procesoDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesoDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_procesoDuracionActionPerformed


    
    private void TablaProcesosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProcesosMouseClicked
        // TODO add your handling code here:
            planificador.setTableUpdate(false);
            JTable target = (JTable)evt.getSource();
            
            int row = target.getSelectedRow();
            
            String id = TablaProcesos.getValueAt(row, 0).toString();           
            if(TablaProcesos.getValueAt(row, 5).toString() != "FINALIZADO"){

                Proceso proc = planificador.getProcesoPorId(id);
                boolean bloqueadoPorUsuario = false;
                if(proc != null) {
                   if(proc.getTiempoBloqueado() == Double.POSITIVE_INFINITY){
                       bloqueadoPorUsuario = true;
                   }
                   ModificarProcesos dialog = new ModificarProcesos(new javax.swing.JFrame(), true,String.valueOf(proc.getID()),String.valueOf(proc.getNombre()),String.valueOf(proc.getPrioridad()),bloqueadoPorUsuario,proc.getTipo(), planificador);
                   //dialog.setLocationRelativeTo(bg);
                   dialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No es posible editar el proceso "+id+" Porque su estado es Finalizado", "Editar Proceso",JOptionPane.INFORMATION_MESSAGE);
                }
                
                
            } else {
                JOptionPane.showMessageDialog(rootPane, "No es posible editar el proceso "+id+ " Porque su estado es Finalizado", "Editar Proceso",JOptionPane.INFORMATION_MESSAGE);
            }
            //planificador.setTableUpdate(true);
    }//GEN-LAST:event_TablaProcesosMouseClicked

    private void limpiarFinalizadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarFinalizadosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_limpiarFinalizadosMouseClicked

    private void limpiarFinalizadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarFinalizadosActionPerformed
        // TODO add your handling code here:
        planificador.limpiarFinalizados();
    }//GEN-LAST:event_limpiarFinalizadosActionPerformed

    private void TablaProcesosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProcesosMouseEntered
        // TODO add your handling code here:
        planificador.setTableUpdate(false);
    }//GEN-LAST:event_TablaProcesosMouseEntered

    private void TablaProcesosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProcesosMouseExited
        // TODO add your handling code here:
        planificador.setTableUpdate(true);
    }//GEN-LAST:event_TablaProcesosMouseExited

    private void exitTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitTxtMousePressed

    public javax.swing.JTable getTablaProcesos(){
        return this.TablaProcesos;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPCrearProcesoManual;
    private javax.swing.JProgressBar ProgressBatch;
    private javax.swing.JProgressBar ProgressInteractivos;
    private javax.swing.JProgressBar ProgressTiempoReal;
    private javax.swing.JTable TablaBloqueados;
    private javax.swing.JTable TablaProcesos;
    private javax.swing.JPanel bg;
    private javax.swing.JButton cargarProcesosArchivo;
    private javax.swing.JButton cargarProcesosManual;
    private javax.swing.JLabel estadoPlanificador;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JPanel header;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPCargarProcesos1;
    private javax.swing.JPanel jPCargarProcesos2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpiarFinalizados;
    private javax.swing.JTextField procesoDuracion;
    private javax.swing.JTextField procesoES;
    private javax.swing.JTextField procesoNombre;
    private javax.swing.JTextField procesoPrioridad;
    private javax.swing.JTextArea status;
    private javax.swing.JLabel title;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userLabel1;
    private javax.swing.JLabel userLabel2;
    private javax.swing.JLabel userLabel3;
    private javax.swing.JLabel userLabel4;
    private javax.swing.JLabel userLabel5;
    private javax.swing.JLabel userLabel6;
    private javax.swing.JLabel userLabel7;
    // End of variables declaration//GEN-END:variables
}
