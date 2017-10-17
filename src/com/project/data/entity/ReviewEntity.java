/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.data.entity;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author seweryn
 */
@DatabaseTable(tableName = "review")
public class ReviewEntity {
    
    @DatabaseField(generatedId = true)
    private Long id;
    
    @DatabaseField( unique = true)
    private String remoteId;
    
    //TODO... dodać potrzebne pola, getery
    
    @DatabaseField(foreign = true)
    private ProductEntity productEntity;
    
    public ReviewEntity( ) { }
    
    public ReviewEntity( String remoteId /* więcej parametrów */ ) {
        this.id = null;
        this.remoteId = remoteId;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getRemoteId() {
        return remoteId;
    }
    
    public void setProduct(ProductEntity product) {
        this.productEntity = product;
    }
    
    public ProductEntity getProduct() {
        return productEntity;
    }
    
}
