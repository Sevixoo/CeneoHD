/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.entity;
 
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable; 
import java.util.Collection;

/** 
 * @author seweryn
 * 
 * Encja definiująca tabelę produktów w bazie danych.  
 */
@DatabaseTable(tableName = "product")
public class ProductEntity { 
    /**
     * Id w bazie danych
     */
    @DatabaseField(generatedId = true)
    private Long id;
    /**
     * zdalenie id produktu
     */
    @DatabaseField( unique = true)
    private String remoteId;
    /**
     * kategoria
     */
    @DatabaseField
    private String category;
    /**
     * nazwa 
     */
    @DatabaseField
    private String name;
    /**
     * parametry
     */
    @DatabaseField
    private String params;
    /**
     * cena
     */
    @DatabaseField
    private String price;
    /**
     * średnia ocena
     */
    @DatabaseField
    private Double score;
    /**
     * opis opini
     */
    @DatabaseField
    private String reviewsDesc;
    /**
     * lista opini
     */
    @ForeignCollectionField(eager = false)
    private Collection<ReviewEntity> reviews;
    /**
     * Konstruktor domyślny
     */
    public ProductEntity( ) { }
    /** 
     * @param remoteId
     * @param category
     * @param name
     * @param params
     * @param price
     * @param score
     * @param reviewsDesc 
     */
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
    /**
     * @return 
     */
    public Long getId() {
        return id;
    }
    /**
     * @return 
     */
    public String getRemoteId() {
        return remoteId;
    }
    /**
     * @param reviews 
     */
    public void setReviews(Collection<ReviewEntity> reviews ) {
        this.reviews = reviews;
    }
    /**
     * @return 
     */
    public Collection<ReviewEntity> getReviews() {
        return reviews;
    }
    /**
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return 
     */
    public String getCategory() {
        return category;
    }
    /**
     * @param category 
     */
    public void setCategory(String category) {
        this.category = category;
    }
    /**
     * @return 
     */
    public String getName() {
        return name;
    }
    /**
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return 
     */
    public String getParams() {
        return params;
    }
    /**
     * @param params 
     */
    public void setParams(String params) {
        this.params = params;
    }
    /**
     * @return 
     */
    public String getPrice() {
        return price;
    }
    /**
     * @param price 
     */
    public void setPrice(String price) {
        this.price = price;
    }
    /**
     * @return 
     */
    public Double getScore() {
        return score;
    }
    /**
     * @param score 
     */
    public void setScore(Double score) {
        this.score = score;
    }
    /**
     * @return 
     */
    public String getReviewsDesc() {
        return reviewsDesc;
    }
    /**
     * @param reviewsDesc 
     */
    public void setReviewsDesc(String reviewsDesc) {
        this.reviewsDesc = reviewsDesc;
    }
}
