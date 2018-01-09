/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dto;


/**
 * @author seweryn 
 * 
 * Struktura DTO przechowująca dane produktu.
 */
public class ProductDTO {
    /**
     * zdalne id produktu
     */
    private String remoteId;
    /**
     * kategoria
     */
    private String category;
    /**
     * nazwa 
     */
    private String name;
    /**
     * parametry
     */
    private String params;
    /**
     * cena
     */
    private String price;
    /**
     * średnia ocena 
     */
    private Double score;
    /**
     * opis opini
     */
    private String reviewsDesc;
     
    /**
     * Konstruktor domyślny
     */
    public ProductDTO(){ }
    
    /** 
     * @param remoteId zdalne id produktu
     */
    public ProductDTO(String remoteId){ 
        this.remoteId = remoteId;
    }
      
    /** 
     * @return zdalne id produktu
     */
    public String getRemoteId(){
        return this.remoteId;
    }
    /**
     * 
     * @param remoteId zdalne id produktu
     */
    public void setRemoteId(String remoteId){
        this.remoteId = remoteId;
    }
    /**
     * 
     * @return kategoria
     */
    public String getCategory() {
        return category;
    }
    /**
     * 
     * @param category kategoria
     */
    public void setCategory(String category) {
        this.category = category;
    }
    /** 
     * @return nazwa
     */
    public String getName() {
        return name;
    }
    /** 
     * @param name nazwa
     */
    public void setName(String name) {
        this.name = name;
    }
    /** 
     * @return parametry
     */
    public String getParams() {
        return params;
    }
    /** 
     * @param params parametry
     */
    public void setParams(String params) {
        this.params = params;
    }
    /** 
     * @return cena
     */
    public String getPrice() {
        return price;
    }
    /** 
     * @param price cena
     */
    public void setPrice(String price) {
        this.price = price;
    }
    /** 
     * @return średnia ocena
     */
    public Double getScore() {
        return score;
    }
    /** 
     * @param score średnia ocena
     */
    public void setScore(Double score) {
        this.score = score;
    }
    /** 
     * @return opis opini
     */
    public String getReviewsDesc() {
        return reviewsDesc;
    }
    /** 
     * @param reviewsDesc opis opini 
     */
    public void setReviewsDesc(String reviewsDesc) {
        this.reviewsDesc = reviewsDesc;
    }
 
}
