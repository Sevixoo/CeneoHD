/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.base.UseCase;
import com.project.data.IProductRepository;
import com.project.entity.ProductEntity;
import java.util.List;

/**
 *
 * @author seweryn
 */
class LoadProductsUseCase implements UseCase<Void,List<ProductEntity>>{
     
    private IProductRepository productRepository;
    
    LoadProductsUseCase(IProductRepository productRepository){
        this.productRepository = productRepository;
    }
    
    public List<ProductEntity> execute(Void request) throws Throwable{
        return productRepository.loadProducts();
    }
   
}
