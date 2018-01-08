
package com.project;

import com.project.dashboard.DashboardForm;
import com.project.application.CeneoHDComponent;
import com.project.splash.SplashForm;
import javax.swing.JFrame;

/**
 *
 * @author seweryn
 */
public class CeneoHDApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        application = new CeneoHDApplication(); 
    }   
    
    private static CeneoHDApplication application;
    
    private final CeneoHDComponent ceneoHDComponent;
    
    public static CeneoHDApplication get(){
        return application;
    }
    
    public CeneoHDComponent provideCeneoHDComponent(){
        return ceneoHDComponent;
    }
       
    private CeneoHDApplication(){
        application = this; 
        ceneoHDComponent = new CeneoHDComponent();
        openNewForm(new SplashForm());
    }
     
    public final void openNewForm(JFrame jFrame){
        java.awt.EventQueue.invokeLater(() -> {
            jFrame.setVisible(true);
        });
    }
    
}
