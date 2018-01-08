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
 */
public class ProductReviewsDTO {
    
    private final ProductDTO product;
    
    private final Collection<ReviewDTO> reviews;

    public ProductReviewsDTO(ProductDTO product, Collection<ReviewDTO> reviews){
        this.product = product;
        this.reviews = reviews;
    }
    
    /**
     * @return the product
     */
    public ProductDTO getProduct() {
        return product;
    }
 
    /**
     * @return the reviews
     */
    public Collection<ReviewDTO> getReviews() {
        return reviews;
    }
 
    
}
