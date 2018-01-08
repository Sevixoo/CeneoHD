/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.base.UseCase;
import com.project.provider.IProductProvider;
import com.project.dto.ProductDTO;
import java.util.List;

/**
 *
 * @author seweryn
 */
class SearchProductsUseCase implements UseCase<String,List<ProductDTO>>{
    
    private final IProductProvider productProvider;
    
    SearchProductsUseCase(IProductProvider productProvider){
        this.productProvider = productProvider;
    }
    
    @Override
    public List<ProductDTO> execute(String searchQuerry) throws Throwable{
        return productProvider.getProducts(searchQuerry);
    }
  
}
