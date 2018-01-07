/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.importer;

import com.project.CeneoHDApplication;
import com.project.application.ETLProductUseCase;
import com.project.application.ExtractProductUseCase;
import com.project.application.SearchProductsUseCase;
import com.project.base.UseCaseExecutor;
import com.project.dto.ProductDTO;
import com.project.products.JTableButtonMouseListener;
import com.project.products.JTableButtonRenderer;
import com.project.products.ProductVM;
import com.project.products.SearchProductTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author seweryn
 */
public class ExtractImporterPanel extends javax.swing.JPanel {

    public interface Listener{
        
        void displayException(Throwable ex);
        
        void onExtractSuccess( ProductDTO productDTO );
        
        void onLoadSuccess();
        
    }
    
    private final UseCaseExecutor executor;
    
    private final ExtractProductUseCase extractProductUseCase;
    
    private final SearchProductsUseCase searchProductsUseCase;
    
    private final ETLProductUseCase eTLProductUseCase;
    
    private final SearchProductTableModel searchProductTableModel;
    
    private Listener parentListener;
    
    /**
     * Creates new form ExtractImporterPanel
     */
    public ExtractImporterPanel() {
        initComponents(); 
        executor = CeneoHDApplication.get().provideCeneoHDComponent().provideUseCaseExecutor();
        extractProductUseCase = CeneoHDApplication.get().provideCeneoHDComponent().provideExtractProductUseCase();
        searchProductsUseCase = CeneoHDApplication.get().provideCeneoHDComponent().provideSearchProductsUseCase();
        eTLProductUseCase = CeneoHDApplication.get().provideCeneoHDComponent().provideETLProductUseCase();
        searchProductTableModel = new SearchProductTableModel((product) -> {
            jTextFieldProductId.setText(product.getRmoteId());
        });
        jTableProducts.setModel(searchProductTableModel); 
    }

    public void setParentListener(Listener parentListener){
        this.parentListener = parentListener; 
    }
    
    public void displayProductsList( List<ProductVM> products ){
        searchProductTableModel.setData(products);
        
        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        jTableProducts.getColumn("Action").setCellRenderer(buttonRenderer);
        jTableProducts.addMouseListener(new JTableButtonMouseListener(jTableProducts));
        jTableProducts.setRowSelectionAllowed(false);
        jTableProducts.setCellSelectionEnabled(false);
        jTableProducts.setColumnSelectionAllowed(false);
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonNext = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        jButtonFinish = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldProductId = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(424, 278));
        setSize(new java.awt.Dimension(424, 278));

        jButtonNext.setText("next");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jLabel2.setText("Search product by name");

        jButtonSearch.setText("search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableProducts);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonFinish.setText("finish");
        jButtonFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinishActionPerformed(evt);
            }
        });

        jLabel1.setText("Import product by id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jButtonNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonFinish))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldProductId)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldProductId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNext)
                    .addComponent(jButtonFinish))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        if(jTextFieldProductId.getText() == null || jTextFieldProductId.getText().equals(""))return;
        
        executor.execute(extractProductUseCase, jTextFieldProductId.getText()  , data -> {
            parentListener.onExtractSuccess(data);
        }, ex -> {
            parentListener.displayException(ex);
        });
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinishActionPerformed
       if(jTextFieldProductId.getText() == null || jTextFieldProductId.getText().equals(""))return;
        
        executor.execute(eTLProductUseCase, jTextFieldProductId.getText()  , data -> {
            parentListener.onLoadSuccess();
        }, ex -> {
            parentListener.displayException(ex);
        });
    }//GEN-LAST:event_jButtonFinishActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
       if(jTextFieldSearch.getText() == null || jTextFieldSearch.getText().equals(""))return;
       
       executor.execute(searchProductsUseCase, jTextFieldSearch.getText(), data -> {
           List<ProductVM> products = new ArrayList<>();
           for( ProductDTO dto : data ){
               products.add(new ProductVM(
                       dto.getRemoteId(), 
                       "name", 
                       "aaaa"
               ));
           }
           displayProductsList(products);
       }, ex -> {
           parentListener.displayException(ex);
       });
        
    }//GEN-LAST:event_jButtonSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFinish;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JTextField jTextFieldProductId;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
