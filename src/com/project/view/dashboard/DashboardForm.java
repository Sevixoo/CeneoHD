/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.view.dashboard;

import com.project.CeneoHDApplication;
import com.project.application.InitializeApplicationUseCase;
import com.project.application.LoadProductsUseCase;
import com.project.base.UseCaseExecutor;
import com.project.view.exporter.ExporterForm;
import com.project.view.importer.ImporterForm;
import java.awt.event.WindowEvent;

/**
 *
 * @author seweryn
 */
public class DashboardForm extends javax.swing.JFrame {

    private final UseCaseExecutor executor;
    
    private final InitializeApplicationUseCase initializeApplicationUseCase;
    
    private final LoadProductsUseCase loadProductsUseCase;
    
    public DashboardForm() {
        initComponents();
        executor = CeneoHDApplication.get().provideUseCaseExecutor();
        initializeApplicationUseCase = CeneoHDApplication.get().provideInitializeApplicationUseCase();
        loadProductsUseCase = CeneoHDApplication.get().provideLoadProductsUseCase();
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSplashLoader = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanelContainer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuExit = new javax.swing.JMenuItem();
        jMenuData = new javax.swing.JMenu();
        jMenuItemImport = new javax.swing.JMenuItem();
        jMenuItemExport = new javax.swing.JMenuItem();
        jMenuItemClear = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CeneoHD");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("frameDashboard"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setText("Initialize...");

        javax.swing.GroupLayout jPanelSplashLoaderLayout = new javax.swing.GroupLayout(jPanelSplashLoader);
        jPanelSplashLoader.setLayout(jPanelSplashLoaderLayout);
        jPanelSplashLoaderLayout.setHorizontalGroup(
            jPanelSplashLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSplashLoaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(360, 360, 360))
            .addGroup(jPanelSplashLoaderLayout.createSequentialGroup()
                .addGap(326, 326, 326)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(328, Short.MAX_VALUE))
        );
        jPanelSplashLoaderLayout.setVerticalGroup(
            jPanelSplashLoaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSplashLoaderLayout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(299, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelSplashLoader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 580));

        jLabel1.setFont(new java.awt.Font("Hiragino Kaku Gothic Std", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CeneoHD");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanelContainerLayout = new javax.swing.GroupLayout(jPanelContainer);
        jPanelContainer.setLayout(jPanelContainerLayout);
        jPanelContainerLayout.setHorizontalGroup(
            jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContainerLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 180, Short.MAX_VALUE))
            .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelContainerLayout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 180, Short.MAX_VALUE)))
        );
        jPanelContainerLayout.setVerticalGroup(
            jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContainerLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(515, Short.MAX_VALUE))
            .addGroup(jPanelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContainerLayout.createSequentialGroup()
                    .addGap(0, 206, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanelContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jMenuFile.setText("File");

        jMenuExit.setText("Exit");
        jMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuExit);

        jMenuBar1.add(jMenuFile);

        jMenuData.setText("Data");

        jMenuItemImport.setText("Import");
        jMenuItemImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImportActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuItemImport);

        jMenuItemExport.setText("Export");
        jMenuItemExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuItemExport);

        jMenuItemClear.setText("Clear");
        jMenuItemClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClearActionPerformed(evt);
            }
        });
        jMenuData.add(jMenuItemClear);

        jMenuBar1.add(jMenuData);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void loadProducts(){
        executor.execute(loadProductsUseCase, null, (result) -> {
            //TODO... display products list in table
        }, (ex) -> {  
            displayException(ex);
        } );
    } 
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        showSplashLoader();
        executor.execute(initializeApplicationUseCase, null, (result) -> {
            hideSplashLoader();
            loadProducts();
        }, (ex) -> {
            hideSplashLoader();
            displayException(ex);
        } );
    }//GEN-LAST:event_formWindowOpened

    private void jMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExitActionPerformed
       this.processWindowEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jMenuExitActionPerformed

    private void jMenuItemImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportActionPerformed
        CeneoHDApplication.get().openNewForm(new ImporterForm());
    }//GEN-LAST:event_jMenuItemImportActionPerformed

    private void jMenuItemExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportActionPerformed
        CeneoHDApplication.get().openNewForm(new ExporterForm());
    }//GEN-LAST:event_jMenuItemExportActionPerformed

    private void jMenuItemClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClearActionPerformed
        CeneoHDApplication.get().openNewForm(new ImporterForm());
    }//GEN-LAST:event_jMenuItemClearActionPerformed
 
    private void hideSplashLoader(){
        jPanelSplashLoader.setVisible(false);
        jPanelContainer.setVisible(true);
    }
    
    private void showSplashLoader(){
        jPanelSplashLoader.setVisible(true);
        jProgressBar1.setIndeterminate(true);
        jPanelContainer.setVisible(false);
    }
    
    private void displayException(Throwable ex){
        ex.printStackTrace();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuData;
    private javax.swing.JMenuItem jMenuExit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemClear;
    private javax.swing.JMenuItem jMenuItemExport;
    private javax.swing.JMenuItem jMenuItemImport;
    private javax.swing.JPanel jPanelContainer;
    private javax.swing.JPanel jPanelSplashLoader;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
