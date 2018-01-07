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
    
    private String model;
    
    private String mark;
    
    private String description;
    
    private Collection<ReviewDTO> reviews;
    
    public ProductDTO(){ }
    
    public ProductDTO(String remoteId, String category, String model, String mark,String description){ 
        this(remoteId,null,category,model,mark, description);
    }
    
    public ProductDTO(String remoteId, Collection<ReviewDTO> reviews, String category, String model, String mark,String description){ 
        this.remoteId = remoteId;
        this.reviews = reviews;
        this.category = category;
        this.model = model;
        this.mark = mark;
        this.description = description;
    }
    
    public String getRemoteId(){
        return this.remoteId;
    }
    
    public void setRemoteId(String remoteId){
        this.remoteId = remoteId;
    }
    
    public Collection<ReviewDTO> getReviews(){
        return this.reviews;
    }
    
    public void setReviews(Collection<ReviewDTO> reviews){
        this.reviews = reviews;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
   
}
