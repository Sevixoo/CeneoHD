/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.data.impl;

import com.project.data.DAO;
import com.project.data.DatabaseException;
import com.project.data.IORMLiteDataBase;
import com.project.data.IProductRepository;
import com.project.data.entity.ProductEntity;
import com.project.data.entity.ReviewEntity;
import java.util.List;

/**
 *
 * @author seweryn
 */
public class ProductRepository implements IProductRepository{
    
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
         //TODO... zapisanie productu jeśli nie istnieje. 
         //zapisanie wszystkich opini które zawiera.
         //jeśli product istnieje. DatabaseException
    }
       
    @Override
    public List<ReviewEntity> loadReviews(){
        return reviewDAO.list();
    }
    
    @Override
    public void saveReview( String productRemoteId, ReviewEntity reviewEntity){
        //TODO... sprawdzenie czy product istnieje i dodanie opini
        //jeśli opinia istnieje. DatabaseException
    }
    
}
