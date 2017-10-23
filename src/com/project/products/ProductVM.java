/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.products;

/**
 *
 * @author seweryn
 */
public class ProductVM {
     
    private final String remoteId;
    
    private final String name;
    
    private final String category;
    
    public ProductVM(String remoteId, String name, String category){
        this.remoteId = remoteId;
        this.name = name;
        this.category = category;
    }
    
    public String getRmoteId(){
        return remoteId;
    }
    
    public String getName(){
        return name;
    }
    
    public String getCategory(){
        return category;
    }
    
}
