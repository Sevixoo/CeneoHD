/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dto;

import com.project.dto.ReviewDTO;
import java.util.Collection;

/**
 *
 * @author seweryn
 */
public class ProductDTO {
    
    private String remoteId;
    
    private String category;
    
    private String name;
     
    private String params;
    
    private String price;
    
    private Double score;
    
    private String reviewsDesc;
     
    public ProductDTO(){ }
    
    public ProductDTO(String remoteId){ 
        this.remoteId = remoteId;
    }
      
    public String getRemoteId(){
        return this.remoteId;
    }
    
    public void setRemoteId(String remoteId){
        this.remoteId = remoteId;
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
