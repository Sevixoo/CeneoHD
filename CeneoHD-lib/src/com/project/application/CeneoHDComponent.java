/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.base.UseCase;
import com.project.base.UseCaseExecutor;
import com.project.data.IORMLiteDataBaseService;
import com.project.data.IProductRepository;
import com.project.dto.ProductDTO;
import com.project.dto.ProductReviewsDTO;
import com.project.entity.ProductEntity;
import com.project.entity.ReviewEntity;
import com.project.provider.IProductProvider;
import com.project.provider.IWebClientService;
import java.io.File;
import java.util.List;

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
     
    final IWebClientService provideWebClientService(){
        return webClientService;
    }
      
    final IProductRepository provideProductRepository(){
        return new ProductRepository(dataBaseService.provideDataBase());
    } 
    
    final IProductProvider provideProductProvider(){
        return new ProductProvider(provideWebClientService());
    }
    
    public UseCaseExecutor provideUseCaseExecutor(){
        return useCaseExecutor;
    }
      
    public final UseCase<Void, Void> provideInitializeApplicationUseCase(){
        return new InitializeApplicationUseCase(dataBaseService);
    }
    
    public final UseCase<String,ProductReviewsDTO> provideExtractProductUseCase(){
        return new ExtractProductUseCase(provideProductProvider());
    }
    
    public final UseCase<ProductEntity,Void> provideSaveProductUseCase(){
        return new SaveProductUseCase(provideProductRepository());
    }
    
    public final UseCase<ProductReviewsDTO,ProductEntity> provideTransformProductUseCase(){
        return new TransformProductUseCase();
    }
     
    public final UseCase<Void,List<ProductEntity>> provideLoadProductsUseCase(){
        return new LoadProductsUseCase(provideProductRepository());
    }
    
    public final UseCase<ExportReviewsArgument, File> provideExportReviewsUseCase(){
        return new ExportReviewsUseCase(provideProductRepository(),new CSVExporterService(),new TxTExporterService());
    }
    
    public final UseCase<Void,Void> provideClearDatabaseUseCase(){
        return new ClearDatabaseUseCase(dataBaseService);
    }
    
    public final UseCase<String, List<ReviewEntity>> provideLoadReviewsUseCase(){
        return new LoadReviewsUseCase(provideProductRepository());
    }
    
    public final UseCase<String,List<ProductDTO>> provideSearchProductsUseCase(){
        return new SearchProductsUseCase(provideProductProvider());
    }
    
    public final UseCase<String,Void> provideETLProductUseCase(){
        return new ETLProductUseCase(
                provideExtractProductUseCase(), 
                provideTransformProductUseCase(), 
                provideSaveProductUseCase()
        );
    }
    
}
