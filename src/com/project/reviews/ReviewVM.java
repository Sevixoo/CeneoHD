/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.reviews;

/**
 *
 * @author seweryn
 */
public class ReviewVM {
    
    private final String remoteId;
    
    private final String name;
    
    public ReviewVM(String remoteId, String name){
        this.remoteId = remoteId;
        this.name = name;
    }
    
    public String getRmoteId(){
        return remoteId;
    }
    
    public String getName(){
        return name;
    }
    
}
