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
import com.project.dto.ProductReviewsDTO;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author seweryn
 */
class TransformProductUseCase implements UseCase<ProductReviewsDTO,ProductEntity>{
    
    TransformProductUseCase(){ }
    
    @Override
    public ProductEntity execute(ProductReviewsDTO productReviewsDto) throws Throwable{
        
        ProductDTO productDto = productReviewsDto.getProduct();
        
        ProductEntity productEntity = new ProductEntity(
                productDto.getRemoteId(),
                productDto.getCategory(),
                productDto.getName(),
                productDto.getParams(),
                productDto.getPrice(),
                productDto.getScore(),
                productDto.getReviewsDesc()
        );
        
        List<ReviewEntity> reviewEntities = productReviewsDto.getReviews().stream().map((reviewDto) -> {
            ReviewEntity reviewEntity = new ReviewEntity(
                    reviewDto.getRemoteId(),
                    reviewDto.getAdvantages(),
                    reviewDto.getDisadvantages(),
                    reviewDto.getSummary(),
                    reviewDto.getScore(),
                    reviewDto.getAuthor(),
                    reviewDto.getCreateDate(),
                    reviewDto.getIsRecomended(),
                    reviewDto.getLikesCount(),
                    reviewDto.getDislikesCount()
                    
            );
            reviewEntity.setProduct(productEntity);
            return reviewEntity;
        }).collect(Collectors.toList()); 
        productEntity.setReviews(reviewEntities);
        return productEntity; 
    }
    
}
