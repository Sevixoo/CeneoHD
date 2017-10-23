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
import java.util.ArrayList;
import java.util.List;

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
        //https://www.ceneo.pl/;szukaj-{searchQuery}
        // wywołać http get, użyć DOMParser do zbudowania listy produktów.
        // może jeszcze paginacja?
        //TODO .. remove mock
        List<ProductDTO> data = new ArrayList<>();
        data.add(new ProductDTO("aaa"));
        data.add(new ProductDTO("bbb"));
        data.add(new ProductDTO("ccc"));
        return data;
    }
    
    public ProductDTO getReviews(String productId) throws ProviderException{
        //https://www.ceneo.pl/{productId}/opinie-{page}
        // wywołać http get, użyć DOMParser do zbudowania listy ocen i parametrów produktu.
        return null;
    }
    
}
