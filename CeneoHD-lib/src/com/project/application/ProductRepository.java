/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.data.DAO;
import com.project.data.DatabaseException;
import com.project.data.IORMLiteDataBase;
import com.project.data.IProductRepository;
import com.project.entity.ProductEntity;
import com.project.entity.ReviewEntity;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author seweryn
 */
class ProductRepository implements IProductRepository{
    
    private final DAO<ProductEntity> productDAO;
    private final DAO<ReviewEntity> reviewDAO;
    
    public ProductRepository(IORMLiteDataBase database){
        this.productDAO = database.provideDAO(ProductEntity.class);
        this.reviewDAO = database.provideDAO(ReviewEntity.class);
    }
    
    @Override
    public List<ProductEntity> loadProducts(){
        return productDAO.list();
    }
    
    @Override
    public void saveProduct(ProductEntity productEntity){ 
        
        ProductEntity product = productDAO.load(productEntity.getRemoteId());
        if( product == null ){ 
            product = productEntity;
            productDAO.save(product);
        }else{
            productEntity.setId(product.getId());
            productDAO.save(productEntity);
            product = productEntity;
        } 
        
        if(productEntity.getReviews() != null){
            for(ReviewEntity reviewEntity : productEntity.getReviews()){
                ReviewEntity review = reviewDAO.load(reviewEntity.getRemoteId());
                if(review == null){
                    review = reviewEntity;
                } 
                review.setProduct(product);  
                reviewDAO.save(review); 
            }
        }
           
    }
       
    @Override
    public List<ReviewEntity> loadReviews(){
        return reviewDAO.list();
    }
    
    @Override
    public List<ReviewEntity> loadReviews(String productId){
        try {
            return reviewDAO.queryBuilder().where()
                    .eq("productEntity_id",productDAO.load(productId).getId())
                    .query();
        }catch (SQLException ex){
            throw  new DatabaseException(ex);
        }
    }
    
    @Override
    public void saveReview( String productRemoteId, ReviewEntity reviewEntity){
        //TODO... sprawdzenie czy product istnieje i dodanie opini
        //jeśli opinia istnieje. DatabaseException
    }
    
}
