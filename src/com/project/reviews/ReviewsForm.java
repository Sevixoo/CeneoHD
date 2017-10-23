/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.reviews;

import com.project.CeneoHDApplication;
import com.project.application.LoadReviewsUseCase;
import com.project.base.UseCaseExecutor;
import com.project.products.ProductVM;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author seweryn
 */
public class ReviewsForm extends javax.swing.JFrame {

    private final ProductVM productViewModel;
    
    private final LoadReviewsUseCase loadReviewsUseCase;
    
    private final UseCaseExecutor useCaseExecutor;
    
    private final ReviewsTableModel reviewsTableModel;
    /**
     * Creates new form ReviewsForm
     */
    public ReviewsForm(ProductVM productViewModel) {
        initComponents();
        this.productViewModel = productViewModel;
        this.loadReviewsUseCase = CeneoHDApplication.get().provideCeneoHDComponent().provideLoadReviewsUseCase();
        this.useCaseExecutor = CeneoHDApplication.get().provideCeneoHDComponent().provideUseCaseExecutor();
        this.reviewsTableModel = new ReviewsTableModel();
        this.jTable1.setModel(reviewsTableModel);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setName("frameReviews"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        useCaseExecutor.execute(loadReviewsUseCase, productViewModel.getRmoteId(),
                result -> {
                    List<ReviewVM> data = new ArrayList<>();
                    data.add(new ReviewVM("aaa", "aaaa"));
                    data.add(new ReviewVM("bbb", "bbbb"));
                    data.add(new ReviewVM("ccc", "cccc"));
                    data.add(new ReviewVM("aaa", "aaaa"));
                    data.add(new ReviewVM("bbb", "bbbb"));
                    data.add(new ReviewVM("ccc", "cccc"));
                    reviewsTableModel.setData(data);
                },ex -> {
                    displayException(ex);
                });
    }//GEN-LAST:event_formWindowOpened

    private void displayException(Throwable ex){
        ex.printStackTrace();
        JOptionPane.showMessageDialog( this,
            ex.getMessage(),
            ex.getClass().getSimpleName(), 
            JOptionPane.ERROR_MESSAGE); 
        this.processWindowEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
