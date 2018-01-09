/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.provider;
 
import com.project.base.ProviderException;
import com.project.dto.ProductDTO;
import com.project.dto.ReviewDTO;
import java.util.List;

public interface IProductProvider {
    
    List<ProductDTO> getProducts(String searchQuery) throws ProviderException; 
    
    ProductDTO getProduct(String searchQuery) throws ProviderException;
    
    List<ReviewDTO> getReviews(String productId) throws ProviderException; 
    
}
