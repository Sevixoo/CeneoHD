/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.data;

import com.project.data.entity.ProductEntity;
import com.project.data.entity.ReviewEntity;
import java.util.List;

/**
 *
 * @author seweryn
 */
public interface IProductRepository {
    
    List<ProductEntity> loadProducts() throws DatabaseException;
    
    void saveProduct(ProductEntity productEntity) throws DatabaseException;
       
    List<ReviewEntity> loadReviews() throws DatabaseException;  
    
    List<ReviewEntity> loadReviews(String productId) throws DatabaseException;  
    
    void saveReview( String productRemoteId, ReviewEntity reviewEntity) throws DatabaseException;
    
}
