/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.entity;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.project.entity.ReviewEntity;
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
    
    @DatabaseField
    private String category;
    
    @DatabaseField
    private String name;
     
    @DatabaseField
    private String params;
    
    @DatabaseField
    private String price;
    
    @DatabaseField
    private Double score;
    
    @DatabaseField
    private String reviewsDesc;
    
    @ForeignCollectionField(eager = false)
    private Collection<ReviewEntity> reviews;
    
    public ProductEntity( ) { }
    
    public ProductEntity( String remoteId, String category, String name, String params, String price, Double score, String reviewsDesc ) {
        this.id = null;
        this.remoteId = remoteId;
        this.category = category;
        this.name = name;
        this.params = params;
        this.price = price;
        this.score = score;
        this.reviewsDesc = reviewsDesc;
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getReviewsDesc() {
        return reviewsDesc;
    }

    public void setReviewsDesc(String reviewsDesc) {
        this.reviewsDesc = reviewsDesc;
    }
    
    
    
}
