/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dto;

import java.util.Date;

/** 
 * @author seweryn
 * 
 * Struktura DTO przechowująca dane opini.
 */
public class ReviewDTO {
    /**
     * zdalne id opini
     */
    private final String remoteId;
    /**
     * zalety produktu
     */
    private String advantages;
    /**
     * wady produktu
     */
    private String disadvantages; 
    /**
     * podsumowanie opinii 
     */
    private String summary;
    /**
     * liczba gwiazdek 
     */
    private String score;
    /**
     * autor opinii (jeśli brakuje, to np. anonim) 
     */
    private String author;
    /**
     * data wystawienia opinii 
     */
    private Date createDate;
    /**
     * POLECAM / NIE POLECAM
     */
    private Boolean isRecomended;
    /**
     * ile osób uznało opinię za przydatną
     */
    private int likesCount;
    /**
     * ile osób uznało opinię za nieprzydatną
     */
    private int dislikesCount; 
    /** 
     * @param remoteId zdalne id opini 
     */
    public ReviewDTO(String remoteId){ 
        this.remoteId = remoteId;
    }
    /** 
     * @return zdalne id opini
     */
    public String getRemoteId(){
        return this.remoteId;
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
