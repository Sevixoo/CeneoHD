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

import java.io.*;
import java.util.*; 
import javax.xml.parsers.DocumentBuilderFactory;
import org.jsoup.Jsoup; 
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
         
           Document doc = Jsoup.connect(  
                   "https://www.ceneo.pl/;szukaj-"+ 
                    URLEncoder.encode(searchQuery, "UTF-8" ) 
           ).get();
            
           List<ProductDTO> data = new ArrayList<>();
           
           Elements rows = doc.select(".category-list-body .cat-prod-row-body");
           for (Element row : rows) { 
                Element nameElement = row.selectFirst(".cat-prod-row-name a");
                Element categoryElement = row.selectFirst(".cat-prod-row-category a");
                Element scoreElement = row.selectFirst(".product-score");
                Element reviewsElement = row.selectFirst(".product-reviews-link"); 
                Element amountElement = row.selectFirst(".price"); 
                Elements params = row.select(".prod-params li");
               
                String remoteId = nameElement
                        .attr("href")
                        .split("#")[0].substring(1);
                
                ProductDTO productDTO = new ProductDTO(remoteId); 
                productDTO.setName(nameElement.text());
                
                if(categoryElement != null){
                    productDTO.setCategory(categoryElement.text());
                } 
                
                if(scoreElement != null){
                    productDTO.setScore(Double.parseDouble(
                            scoreElement.text().split(" ")[0].replace(",", ".")
                    ));
                } 
                
                if(reviewsElement != null){
                    productDTO.setReviewsDesc(reviewsElement.text());
                }
                
                if(amountElement != null){
                    productDTO.setPrice(amountElement.text());
                }
                 
                if(params != null && !params.isEmpty()){
                    StringBuilder paramsBuilder = new StringBuilder();
                    for(Element param : params){
                       paramsBuilder.append(param.text());
                       paramsBuilder.append("\n");
                    } 
                    productDTO.setParams(paramsBuilder.toString());
                } 
                
                data.add(productDTO);
                
           } 
           return data; 
            
        }catch(Exception e){
            e.printStackTrace();
            throw new ProviderException(e.getMessage());
        }
    }

    public ProductDTO getReviews(String productId) throws ProviderException{
        //https://www.ceneo.pl/{productId}/opinie-{page}
        // wywołać http get, użyć DOMParser do zbudowania listy ocen i parametrów produktu.
        List<ReviewDTO> reviews = new ArrayList<>();
        for(int i = 0 ; i < 24; i++)reviews.add(new ReviewDTO(productId + "review:" + i));
        return new ProductDTO(productId); 


    }
    
}
