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
    
    //TODO... dodać potrzebne pola, getery setery.
    
    private Collection<ReviewDTO> reviews;
    
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
    
    public Collection<ReviewDTO> getReviews(){
        return this.reviews;
    }
    
    public void setReviews(Collection<ReviewDTO> reviews){
        this.reviews = reviews;
    }
    
}
