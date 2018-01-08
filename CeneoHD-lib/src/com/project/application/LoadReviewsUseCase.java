/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.base.UseCase;
import com.project.data.IProductRepository;
import com.project.entity.ReviewEntity; 
import java.util.List;

/**
 *
 * @author seweryn
 */
class LoadReviewsUseCase implements UseCase<String, List<ReviewEntity>>{
    
    private final IProductRepository productRepository;
    
    LoadReviewsUseCase(IProductRepository productRepository){
        this.productRepository = productRepository;
    }
    
    @Override
    public List<ReviewEntity> execute(String productRemoteId) throws Throwable{
        return productRepository.loadReviews(productRemoteId);
    }
    
}
