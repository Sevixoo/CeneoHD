/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.splash;

import com.project.CeneoHDApplication; 
import com.project.base.UseCase;
import com.project.base.UseCaseExecutor;
import com.project.dashboard.DashboardForm;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author seweryn
 */
public class SplashForm extends javax.swing.JFrame {

    private final UseCaseExecutor executor;
    
    private final UseCase<Void, Void> initializeApplicationUseCase;
    
    /**
     * Creates new form SplashForm
     */
    public SplashForm() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        executor = CeneoHDApplication.get().provideCeneoHDComponent().provideUseCaseExecutor();
        initializeApplicationUseCase = CeneoHDApplication.get().provideCeneoHDComponent().provideInitializeApplicationUseCase();
        jProgressBar1.setIndeterminate(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CeneoHD - initialize");
        setMaximizedBounds(new java.awt.Rectangle(800, 600, 600, 600));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("frameSplash"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Initialize...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(280, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(311, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        executor.execute(initializeApplicationUseCase, null, (result) -> {
            CeneoHDApplication.get().openNewForm(new DashboardForm());
            dispose();
        }, (ex) -> { 
            displayException(ex);
        } );
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
