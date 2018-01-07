/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.impl;

import com.project.provider.IProductProvider;
import com.project.provider.IWebClientService;
import com.project.provider.ProviderException;
import com.project.dto.ProductDTO;
import com.project.dto.ReviewDTO;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.xml.parsers.DocumentBuilder;

/**
 *
 * @author seweryn
 */
class ProductProvider implements IProductProvider{
     
    private IWebClientService webClientService;
    
    public ProductProvider(IWebClientService webClientService){
        this.webClientService = webClientService;
    }
    
    public List<ProductDTO> getProducts(String searchQuery) throws ProviderException{ 
        
       try{
        
            String response = webClientService.get(
                    "https://www.ceneo.pl/;szukaj-"+ 
                    URLEncoder.encode(searchQuery, "UTF-8") 
            );



            List<ProductDTO> data = new ArrayList<>();
            data.add(new ProductDTO(UUID.randomUUID().toString()));
            return data; 
            
        }catch(Exception e){
            throw new ProviderException(e.getMessage());
        }
    }

    public ProductDTO getReviews(String productId) throws ProviderException{
        //https://www.ceneo.pl/{productId}/opinie-{page}
        // wywołać http get, użyć DOMParser do zbudowania listy ocen i parametrów produktu.
        List<ReviewDTO> reviews = new ArrayList<>();
        for(int i = 0 ; i < 24; i++)reviews.add(new ReviewDTO(productId + "review:" + i));
        return new ProductDTO(productId, reviews); 


    }
    
}
