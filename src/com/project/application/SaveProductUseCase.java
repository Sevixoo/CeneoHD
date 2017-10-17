/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.base.UseCase;
import com.project.data.IProductRepository;
import com.project.data.entity.ProductEntity;
import com.project.provider.dto.ProductDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author seweryn
 */
public class SaveProductUseCase implements UseCase<ProductEntity,Void>{
    
    private final IProductRepository productRepository;
     
    public SaveProductUseCase(IProductRepository productRepository){
        this.productRepository = productRepository; 
    }
    
    @Override
    public Void execute(ProductEntity data) throws Throwable{
         productRepository.saveProduct(data);
         return null;
    }
    
}