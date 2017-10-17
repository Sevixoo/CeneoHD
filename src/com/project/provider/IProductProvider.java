/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.provider;

import com.project.provider.dto.ProductDTO;
import com.project.provider.dto.ReviewDTO;
import java.util.List;

/**
 *
 * @author seweryn
 */
public interface IProductProvider {
    
    List<ProductDTO> getProducts(String searchQuery) throws ProviderException; 
    
    ProductDTO getReviews(String productId) throws ProviderException; 
    
}
