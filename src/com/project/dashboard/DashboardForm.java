/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dashboard;

import com.project.CeneoHDApplication;
import com.project.application.InitializeApplicationUseCase;
import com.project.application.LoadProductsUseCase;
import com.project.base.UseCaseExecutor;
import com.project.entity.ProductEntity;
import com.project.exporter.ExporterForm;
import com.project.importer.ImporterForm;
import com.project.products.JTableButtonMouseListener;
import com.project.products.JTableButtonRenderer;
import com.project.products.ProductVM;
import com.project.products.ProductsTableModel;
import com.project.products.TableButton;
import com.project.products.TableButtonListener;
import com.project.reviews.ReviewsForm;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import jdk.nashorn.internal.runtime.RewriteException;

/**
 *
 * @author seweryn
 */
public class DashboardForm extends javax.swing.JFrame implements ProductsTableModel.OnItemActionClickListener{

    private final UseCaseExecutor executor;
      
    private final LoadProductsUseCase loadProductsUseCase;
    
    private final ProductsTableModel productsTableModel;
    
    
    public DashboardForm() {
        initComponents();
        executor = CeneoHDApplication.get().provideCeneoHDComponent().provideUseCaseExecutor();
        loadProductsUseCase = CeneoHDApplication.get().provideCeneoHDComponent().provideLoadProductsUseCase();
        productsTableModel = new ProductsTableModel(this);
        jTable1.setModel(productsTableModel);
    } 
    
    @Override
    public void onActionClick(ProductVM product){
        CeneoHDApplication.get().openNewForm(new ReviewsForm(product));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        setMaximizedBounds(new java.awt.Rectangle(800, 600, 600, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("frameDashboard"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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
        jTable1.setBounds(new java.awt.Rectangle(0, 0, 800, 570));
        jTable1.setMaximumSize(new java.awt.Dimension(800, 570));
        jTable1.setMinimumSize(new java.awt.Dimension(800, 570));
        jTable1.setPreferredSize(new java.awt.Dimension(800, 570));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleName("");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        executor.execute(loadProductsUseCase, null, (result) -> {
            List<ProductVM> productsVM = new ArrayList<>();
            for(ProductEntity entity : result){
                productsVM.add(new ProductVM(
                        entity.getRemoteId(), 
                        entity.getRemoteId(), 
                        "aaaa"
                ));
            } 
            productsTableModel.setData(productsVM);
            
            TableCellRenderer buttonRenderer = new JTableButtonRenderer();
            jTable1.getColumn("Action").setCellRenderer(buttonRenderer);
            jTable1.addMouseListener(new JTableButtonMouseListener(jTable1));
            jTable1.setRowSelectionAllowed(false);
            jTable1.setCellSelectionEnabled(false);
            jTable1.setColumnSelectionAllowed(false);
        }, (ex) -> {  
            displayException(ex);
        } );
    }//GEN-LAST:event_formWindowOpened

    private void jMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExitActionPerformed
       this.processWindowEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jMenuExitActionPerformed

    private void jMenuItemImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportActionPerformed
        CeneoHDApplication.get().openNewForm(new ImporterForm());
    }//GEN-LAST:event_jMenuItemImportActionPerformed

    private void jMenuItemClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClearActionPerformed
         
    }//GEN-LAST:event_jMenuItemClearActionPerformed

    private void jMenuItemExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportActionPerformed
        CeneoHDApplication.get().openNewForm(new ExporterForm());
    }//GEN-LAST:event_jMenuItemExportActionPerformed
  
    private void displayException(Throwable ex){
        ex.printStackTrace();
        JOptionPane.showMessageDialog( this,
            ex.getMessage(),
            ex.getClass().getSimpleName(), 
            JOptionPane.ERROR_MESSAGE); 
        this.processWindowEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING));
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
