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
 * @author seweryn
 * 
 * Główny komponent aplikacji. Odgrywa rolę kontynera do wstrzykiwania 
 * zależności oraz udostępnia usługi. Po stworzeniu instancji należy wykonać 
 * usecase inicjalizujący a następnie można pobierać pozostałe komponenty 
 * aplikacji. W przeciwnym razie zostanie zgłoszony RuntimeException.
 */
public class CeneoHDComponent {
    
    private final UseCaseExecutor useCaseExecutor;
    
    private final IWebClientService webClientService;
    
    private final IORMLiteDataBaseService dataBaseService;
    
    /**
    * Konstruktor domyślny
    */
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
    
    /**
    * @return UseCaseExecutor, który jest używany do wykonywania UseCasa'ów.
    * Domyślna implementacja udostępnia instancje ThreadUseCaseExecutor, 
    * która wykonuje UseCase w tle za pomocą ThreadPoolExecutor. 
    * Możesz nadpisać tą metodę aby zaimplementować własny UseCaseExecutor. 
    */
    public UseCaseExecutor provideUseCaseExecutor(){
        return useCaseExecutor;
    }
    /**
    * @return InitializeApplicationUseCase odpowiedzialny za inicjalizacje
    * aplikacji, który powinien zostać wykonany zaraz po stworzeniu
    * komponentu CeneoHDComponent, przed pobraniem innych komponentów.
    * Po wywołaniu zostanie stworzona baza danych i nawiązane z nią połączenie.
    * 
    * REQUEST_OBJECT null
    * RESPONSE_OBJECT null 
    */
    public final UseCase<Void, Void> provideInitializeApplicationUseCase(){
        return new InitializeApplicationUseCase(dataBaseService);
    }
    /**
    * @return ExtractProductUseCase, który przeprowadza operacje pobierania 
    * opini produktu na podstawie product_id.
    * 
    * REQUEST_OBJECT String - id produktu 
    * RESPONSE_OBJECT ProductReviewsDTO - dane produktu oraz lista opini 
    */
    public final UseCase<String,ProductReviewsDTO> provideExtractProductUseCase(){
        return new ExtractProductUseCase(provideProductProvider());
    }
    /**
    * @return SaveProductUseCase, który zapisuje encje do bazy danych.
    * 
    * REQUEST_OBJECT ProductEntity - encja produktu zawierająca opinie
    * RESPONSE_OBJECT null 
    */
    public final UseCase<ProductEntity,Void> provideSaveProductUseCase(){
        return new SaveProductUseCase(provideProductRepository());
    }
    /**
    * @return TransformProductUseCase, który mapuje obiekt ProductReviewsDTO 
    * na encję ProductEntity.
    * 
    * REQUEST_OBJECT ProductReviewsDTO - dane produktu i opinie
    * RESPONSE_OBJECT ProductEntity - encja produktu 
    */
    public final UseCase<ProductReviewsDTO,ProductEntity> provideTransformProductUseCase(){
        return new TransformProductUseCase();
    }
    /**
    * @return LoadProductsUseCase, który pobiera z bazy danych listę produktów.
    * 
    * REQUEST_OBJECT null
    * RESPONSE_OBJECT List<ProductEntity> - lista pobranych produktów 
    */
    public final UseCase<Void,List<ProductEntity>> provideLoadProductsUseCase(){
        return new LoadProductsUseCase(provideProductRepository());
    }
    /**
    * @return ExportReviewsUseCase, który może zostać użyty do wyeksportowania 
    * opini produktu do pliku CSV lub plików TXT.
    * 
    * REQUEST_OBJECT ExportReviewsArgument - zawiera konfiguracje eksportu
    * RESPONSE_OBJECT File - stworzony plik lub folder  
    */
    public final UseCase<ExportReviewsArgument, File> provideExportReviewsUseCase(){
        return new ExportReviewsUseCase(provideProductRepository(),new CSVExporterService(),new TxTExporterService());
    }
    /**
    * @return ClearDatabaseUseCase, który czyści wszystkie tabele bazy danych.
    * 
    * REQUEST_OBJECT null
    * RESPONSE_OBJECT null 
    */
    public final UseCase<Void,Void> provideClearDatabaseUseCase(){
        return new ClearDatabaseUseCase(dataBaseService);
    }
    /**
    * @return LoadReviewsUseCase, który pozwala pobrać listę opini danego
    * produktu z bazy danych.
    * 
    * REQUEST_OBJECT String - product_id
    * RESPONSE_OBJECT List<ReviewEntity>> - lista encji opini
    */
    public final UseCase<String, List<ReviewEntity>> provideLoadReviewsUseCase(){
        return new LoadReviewsUseCase(provideProductRepository());
    }
    /**
    * @return SearchProductsUseCase, który przeprowadza operacje wyszukania 
    * produktów na podstawie wpisanej frazy.
    * 
    * REQUEST_OBJECT String - szukana fraza
    * RESPONSE_OBJECT List<ProductDTO> - lista wyników 
    */
    public final UseCase<String,List<ProductDTO>> provideSearchProductsUseCase(){
        return new SearchProductsUseCase(provideProductProvider());
    }
    /**
    * @return ETLProductUseCase, który pozwala na przeprowadzenie całego 
    * procesu ETL. Pobiera opinie na podstawie product_id, 
    * przekształca je na ancje a następnie zapisuje do bazy danych.
    * 
    * REQUEST_OBJECT String - product_id
    * RESPONSE_OBJECT null 
    */
    public final UseCase<String,Void> provideETLProductUseCase(){
        return new ETLProductUseCase(
                provideExtractProductUseCase(), 
                provideTransformProductUseCase(), 
                provideSaveProductUseCase()
        );
    }
    
}
