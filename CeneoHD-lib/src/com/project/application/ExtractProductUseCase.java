/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.base.UseCase;
import com.project.provider.IProductProvider;
import com.project.dto.ProductDTO;
import com.project.dto.ProductReviewsDTO;
import com.project.dto.ReviewDTO;
import java.util.List;

/**
 *
 * @author seweryn
 */
class ExtractProductUseCase implements UseCase<String,ProductReviewsDTO>{
    
    private final IProductProvider productProvider;
    
    ExtractProductUseCase(IProductProvider productProvider){
        this.productProvider = productProvider;
    }
    
    @Override
    public ProductReviewsDTO execute(String request) throws Throwable{
        ProductDTO product = productProvider.getProduct(request);
        List<ReviewDTO> reviews = productProvider.getReviews(request);
        return new ProductReviewsDTO(product, reviews);
    }
    
}
