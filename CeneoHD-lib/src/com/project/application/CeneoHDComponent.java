/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.application.ClearDatabaseUseCase;
import com.project.application.ETLProductUseCase;
import com.project.application.ExportReviewsUseCase;
import com.project.application.ExtractProductUseCase;
import com.project.application.InitializeApplicationUseCase;
import com.project.application.LoadProductsUseCase;
import com.project.application.LoadReviewsUseCase;
import com.project.application.SaveProductUseCase;
import com.project.application.SearchProductsUseCase;
import com.project.application.TransformProductUseCase;
import com.project.base.UseCaseExecutor;
import com.project.data.IORMLiteDataBaseService;
import com.project.data.IProductRepository;
import com.project.provider.IProductProvider;
import com.project.provider.IWebClientService;

/**
 *
 * @author seweryn
 */
public class CeneoHDComponent {
    
    private final UseCaseExecutor useCaseExecutor;
    
    private final IWebClientService webClientService;
    
    private final IORMLiteDataBaseService dataBaseService;
      
    public CeneoHDComponent(){
        this.useCaseExecutor = new ThreadUseCaseExecutor();
        this.webClientService = new WebClientService(); 
        this.dataBaseService = new ORMLiteDataBaseService();
    }
     
    public UseCaseExecutor provideUseCaseExecutor(){
        return useCaseExecutor;
    }
    
    public IWebClientService provideWebClientService(){
        return webClientService;
    }
      
    public IProductRepository provideProductRepository(){
        return new ProductRepository(dataBaseService.provideDataBase());
    } 
    
    public IProductProvider provideProductProvider(){
        return new ProductProvider(provideWebClientService());
    }
    
    public final ExtractProductUseCase provideExtractProductUseCase(){
        return new ExtractProductUseCase(provideProductProvider());
    }
    
    public final SaveProductUseCase provideSaveProductUseCase(){
        return new SaveProductUseCase(provideProductRepository());
    }
    
    public final TransformProductUseCase provideTransformProductUseCase(){
        return new TransformProductUseCase();
    }
    
    public final InitializeApplicationUseCase provideInitializeApplicationUseCase(){
        return new InitializeApplicationUseCase(dataBaseService);
    }
    
    public final LoadProductsUseCase provideLoadProductsUseCase(){
        return new LoadProductsUseCase(provideProductRepository());
    }
    
    public final ExportReviewsUseCase provideExportReviewsUseCase(){
        return new ExportReviewsUseCase(provideProductRepository(),new CSVExporterService(),new TxTExporterService());
    }
    
    public final ClearDatabaseUseCase provideClearDatabaseUseCase(){
        return new ClearDatabaseUseCase(dataBaseService);
    }
    
    public final LoadReviewsUseCase provideLoadReviewsUseCase(){
        return new LoadReviewsUseCase(provideProductRepository());
    }
    
    public final SearchProductsUseCase provideSearchProductsUseCase(){
        return new SearchProductsUseCase(provideProductProvider());
    }
    
    public final ETLProductUseCase provideETLProductUseCase(){
        return new ETLProductUseCase(
                provideExtractProductUseCase(), 
                provideTransformProductUseCase(), 
                provideSaveProductUseCase()
        );
    }
    
}
