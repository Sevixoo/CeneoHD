/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.provider.dto;

/**
 *
 * @author seweryn
 */
public class ReviewDTO {
    
    private String remoteId;
    
    //TODO... dodać potrzebne pola, getery setery.
    
    public ReviewDTO(){ }
    
    public String getRemoteId(){
        return this.remoteId;
    }
    
    public void setRemoteId(String remoteId){
        this.remoteId = remoteId;
    }
    
}