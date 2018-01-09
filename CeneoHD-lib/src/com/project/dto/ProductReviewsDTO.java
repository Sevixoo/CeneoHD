/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.dto;

import java.util.Collection;

/**
 *
 * @author seweryn
 * 
 * Struktura DTO przechowująca obiekt z danymi produktu oraz jego listą opini. 
 */
public class ProductReviewsDTO {
    /**
     * dane produktu
     */
    private final ProductDTO product;
    /**
     * lista opini
     */
    private final Collection<ReviewDTO> reviews;
    /** 
     * @param product dane produktu
     * @param reviews lista opini
     */
    public ProductReviewsDTO(ProductDTO product, Collection<ReviewDTO> reviews){
        this.product = product;
        this.reviews = reviews;
    }
    /**
     * @return dane produktu
     */
    public ProductDTO getProduct() {
        return product;
    }
    /**
     * @return lista opini
     */
    public Collection<ReviewDTO> getReviews() {
        return reviews;
    }
}
