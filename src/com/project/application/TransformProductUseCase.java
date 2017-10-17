/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.base.UseCase;
import com.project.data.entity.ProductEntity;
import com.project.data.entity.ReviewEntity;
import com.project.provider.dto.ProductDTO;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author seweryn
 */
public class TransformProductUseCase implements UseCase<List<ProductDTO>,List<ProductEntity>>{
    
    public TransformProductUseCase(){ }
    
    @Override
    public List<ProductEntity> execute(List<ProductDTO> dtoList) throws Throwable{
        return dtoList.stream().map((productDto) -> { 
            ProductEntity productEntity = new ProductEntity(
                    productDto.getRemoteId()
                    //TODO... implementacja mapowania DTO -> Entity
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
        }).collect(Collectors.toList());
    }
    
}
