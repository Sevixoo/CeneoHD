
package com.project;

import com.project.application.ExtractProductUseCase;
import com.project.application.InitializeApplicationUseCase;
import com.project.application.SaveProductUseCase;
import com.project.application.TransformProductUseCase;
import com.project.base.ThreadUseCaseExecutor;
import com.project.base.UseCaseExecutor;
import com.project.data.IORMLiteDataBase;
import com.project.data.IORMLiteDataBaseService;
import com.project.data.IProductRepository;
import com.project.data.impl.ORMLiteDataBaseService;
import com.project.data.impl.ProductRepository;
import com.project.provider.IProductProvider;
import com.project.provider.IWebClientService;
import com.project.provider.impl.ProductProvider;
import com.project.provider.impl.WebClientService;
import com.project.view.dashboard.DashboardForm;
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
    
    public static CeneoHDApplication get(){
        return application;
    }
    
    private final UseCaseExecutor useCaseExecutor;
    
    private final IWebClientService webClientService;
     
          
    private CeneoHDApplication(){
        useCaseExecutor = new ThreadUseCaseExecutor();
        webClientService = new WebClientService(); 
        openNewForm(new DashboardForm());
    }
    
    public UseCaseExecutor provideUseCaseExecutor(){
        return useCaseExecutor;
    }
    
    public IWebClientService provideWebClientService(){
        return webClientService;
    }
    
    public IORMLiteDataBaseService provideORMLiteDataBaseService(){
        return new ORMLiteDataBaseService();
    }
    
    public IProductRepository provideProductRepository(){
        return new ProductRepository(provideORMLiteDataBaseService().provideDataBase());
    } 
    
    public IProductProvider provideProductProvider(){
        return new ProductProvider(provideWebClientService());
    }
    
    public ExtractProductUseCase provideExtractProductUseCase(){
        return new ExtractProductUseCase(provideProductProvider());
    }
    
    public SaveProductUseCase provideSaveProductUseCase(){
        return new SaveProductUseCase(provideProductRepository());
    }
    
    public TransformProductUseCase provideTransformProductUseCase(){
        return new TransformProductUseCase();
    }
    
    public InitializeApplicationUseCase provideInitializeApplicationUseCase(){
        return new InitializeApplicationUseCase(provideORMLiteDataBaseService());
    }
     
    public final void openNewForm(JFrame jFrame){
        java.awt.EventQueue.invokeLater(() -> {
            jFrame.setVisible(true);
        });
    }
    
}
