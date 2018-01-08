/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.base.UseCase; 
import com.project.entity.ProductEntity; 
import com.project.dto.ProductReviewsDTO; 

/**
 *
 * @author seweryn
 */
class ETLProductUseCase implements UseCase<String,Void>{
    
    private final UseCase<String,ProductReviewsDTO> extractProductUseCase;
    
    private final UseCase<ProductReviewsDTO,ProductEntity> transformProductUseCase;
    
    private final UseCase<ProductEntity,Void> saveProductUseCase;
     
    ETLProductUseCase(
            UseCase<String,ProductReviewsDTO> extractProductUseCase, 
            UseCase<ProductReviewsDTO,ProductEntity> transformProductUseCase, 
            UseCase<ProductEntity,Void> saveProductUseCase
    ){
        this.extractProductUseCase = extractProductUseCase; 
        this.transformProductUseCase = transformProductUseCase; 
        this.saveProductUseCase = saveProductUseCase; 
    }
    
    @Override
    public Void execute(String productId) throws Throwable{
         ProductReviewsDTO productDTO = extractProductUseCase.execute(productId);
         ProductEntity productEntity = transformProductUseCase.execute(productDTO);
         return saveProductUseCase.execute(productEntity);
    }
    
}
