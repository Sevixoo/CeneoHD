/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.base.UseCase;
import com.project.data.IProductRepository;
import com.project.entity.ProductEntity;
import com.project.dto.ProductDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author seweryn
 */
public class ETLProductUseCase implements UseCase<String,Void>{
    
    private final ExtractProductUseCase extractProductUseCase;
    
    private final TransformProductUseCase transformProductUseCase;
    
    private final SaveProductUseCase saveProductUseCase;
     
    public ETLProductUseCase(ExtractProductUseCase extractProductUseCase, TransformProductUseCase transformProductUseCase, SaveProductUseCase saveProductUseCase){
        this.extractProductUseCase = extractProductUseCase; 
        this.transformProductUseCase = transformProductUseCase; 
        this.saveProductUseCase = saveProductUseCase; 
    }
    
    @Override
    public Void execute(String productId) throws Throwable{
         ProductDTO productDTO = extractProductUseCase.execute(productId);
         ProductEntity productEntity = transformProductUseCase.execute(productDTO);
         return saveProductUseCase.execute(productEntity);
    }
    
}
