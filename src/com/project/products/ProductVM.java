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
    
    private final String price;
    
    private final String params;
    
    public ProductVM(String remoteId, String name, String category, String params, String price ){
        this.remoteId = remoteId;
        this.name = name;
        this.category = category;
        this.params = params;
        this.price = price;
    }
    
    public String getRmoteId(){
        return remoteId;
    }
    
    public String getParams(){
        return params;
    }
    
    public String getPrice(){
        return price;
    }
    
    public String getName(){
        return name;
    }
    
    public String getCategory(){
        return category;
    }
    
}
