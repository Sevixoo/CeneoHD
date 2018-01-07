/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.base.UseCase;
import com.project.entity.ProductEntity;
import com.project.entity.ReviewEntity;
import com.project.dto.ProductDTO;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author seweryn
 */
public class TransformProductUseCase implements UseCase<ProductDTO,ProductEntity>{
    
    public TransformProductUseCase(){ }
    
    @Override
    public ProductEntity execute(ProductDTO productDto) throws Throwable{
        ProductEntity productEntity = new ProductEntity(
                productDto.getRemoteId(),
                productDto.getCategory(),
                productDto.getName(),
                productDto.getParams(),
                productDto.getPrice(),
                productDto.getScore(),
                productDto.getReviewsDesc()
        );
        List<ReviewEntity> reviewEntities = productDto.getReviews().stream().map((reviewDto) -> {
            ReviewEntity reviewEntity = new ReviewEntity(
                    reviewDto.getRemoteId()
                    //TODO... implementacja mapowania DTO -> Entity
            );
            reviewEntity.setProduct(productEntity);
            return reviewEntity;
        }).collect(Collectors.toList()); 
        productEntity.setReviews(reviewEntities);
        return productEntity; 
    }
    
}
