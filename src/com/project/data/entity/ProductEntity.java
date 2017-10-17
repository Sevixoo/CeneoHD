/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.data.entity;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Collection;

/**
 *
 * @author seweryn
 */
@DatabaseTable(tableName = "product")
public class ProductEntity {
    
    @DatabaseField(generatedId = true)
    private Long id;
    
    @DatabaseField( unique = true)
    private String remoteId;
    
    //TODO... dodać potrzebne pola, getery
    
    @ForeignCollectionField(eager = false)
    private Collection<ReviewEntity> reviews;
    
    public ProductEntity( ) { }
    
    public ProductEntity( String remoteId /* więcej parametrów */ ) {
        this.id = null;
        this.remoteId = remoteId;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getRemoteId() {
        return remoteId;
    }
    
    public void setReviews(Collection<ReviewEntity> reviews ) {
        this.reviews = reviews;
    }
    
    public Collection<ReviewEntity> getReviews() {
        return reviews;
    }
    
}
