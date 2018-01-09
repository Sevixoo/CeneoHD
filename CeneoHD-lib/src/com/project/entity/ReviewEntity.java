/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.entity;
 
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable; 
import java.util.Date;

/** 
 * @author seweryn
 * 
 * Encja definiująca tabelę produktów w bazie danych.  
 */
@DatabaseTable(tableName = "review")
public class ReviewEntity {
    /**
     * id w bazie danych
     */
    @DatabaseField(generatedId = true)
    private Long id;
    /**
     * zdalne id opini
     */
    @DatabaseField( unique = true)
    private String remoteId;
    /**
     * zalety produktu
     */
    @DatabaseField
    private String advantages;
    /**
     * wady produktu
     */
    @DatabaseField
    private String disadvantages; 
    /**
     * podsumowanie opinii 
     */
    @DatabaseField
    private String summary;
    /**
     * liczba gwiazdek 
     */
    @DatabaseField
    private String score;
    /**
     * autor opinii (jeśli brakuje, to np. anonim) 
     */
    @DatabaseField
    private String author;
    /**
     * data wystawienia opinii 
     */
    @DatabaseField
    private Date createDate;
    /**
     * POLECAM / NIE POLECAM
     */
    @DatabaseField
    private Boolean isRecomended;
    /**
     * ile osób uznało opinię za przydatną
     */
    @DatabaseField
    private int likesCount;
    /**
     * ile osób uznało opinię za nieprzydatną
     */
    @DatabaseField
    private int dislikesCount;
    /** 
     * @param remoteId zdalne id opini 
     */
    @DatabaseField(foreign = true)
    private ProductEntity productEntity;
    /**
     * Konstruktor domyślny
     */
    public ReviewEntity( ) {  }
    /** 
     * @param remoteId
     * @param advantages
     * @param disadvantages
     * @param summary
     * @param score
     * @param author
     * @param createDate
     * @param isRecomended
     * @param likesCount
     * @param dislikesCount 
     */
    public ReviewEntity( String remoteId, String advantages, String disadvantages, String summary, String score, String author, Date createDate, Boolean isRecomended, int likesCount, int dislikesCount  ) {
        this.id = null;
        this.remoteId = remoteId;
        this.advantages = advantages;
        this.disadvantages = disadvantages;
        this.summary = summary;
        this.score = score;
        this.author = author;
        this.createDate = createDate;
        this.isRecomended = isRecomended;
        this.likesCount = likesCount;
        this.dislikesCount = dislikesCount;
    }
    /**
     * @return id
     */
    public Long getId() {
        return id;
    }
    /**
     * @return remoteId
     */
    public String getRemoteId() {
        return remoteId;
    }
    /**
     * @param product 
     */
    public void setProduct(ProductEntity product) {
        this.productEntity = product;
    }
    /**
     * @return productEntity
     */
    public ProductEntity getProduct() {
        return productEntity;
    } 
    /**
     * @return the advantages
     */
    public String getAdvantages() {
        return advantages;
    } 
    /**
     * @param advantages the advantages to set
     */
    public void setAdvantages(String advantages) {
        this.advantages = advantages;
    } 
    /**
     * @return the disadvantages
     */
    public String getDisadvantages() {
        return disadvantages;
    } 
    /**
     * @param disadvantages the disadvantages to set
     */
    public void setDisadvantages(String disadvantages) {
        this.disadvantages = disadvantages;
    } 
    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    } 
    /**
     * @param summary the summary to set
     */
    public void setSummary(String summary) {
        this.summary = summary;
    } 
    /**
     * @return the score
     */
    public String getScore() {
        return score;
    } 
    /**
     * @param score the score to set
     */
    public void setScore(String score) {
        this.score = score;
    } 
    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    } 
    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    } 
    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    } 
    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    } 
    /**
     * @return the isRecomended
     */
    public Boolean getIsRecomended() {
        return isRecomended;
    } 
    /**
     * @param isRecomended the isRecomended to set
     */
    public void setIsRecomended(Boolean isRecomended) {
        this.isRecomended = isRecomended;
    } 
    /**
     * @return the likesCount
     */
    public int getLikesCount() {
        return likesCount;
    } 
    /**
     * @param likesCount the likesCount to set
     */
    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    } 
    /**
     * @return the dislikesCount
     */
    public int getDislikesCount() {
        return dislikesCount;
    } 
    /**
     * @param dislikesCount the dislikesCount to set
     */
    public void setDislikesCount(int dislikesCount) {
        this.dislikesCount = dislikesCount;
    } 
}
