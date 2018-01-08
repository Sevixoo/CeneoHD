/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.provider.IProductProvider;
import com.project.provider.IWebClientService;
import com.project.provider.ProviderException;
import com.project.dto.ProductDTO;
import com.project.dto.ReviewDTO;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List; 
 
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
    
    public ProductDTO getProduct(String productId) throws ProviderException{
        try{
         
           Document doc = Jsoup.connect(  
                   "https://www.ceneo.pl/"+ productId
           ).get();
           
           Element body = doc.selectFirst(".js_product-body");
           
           Element nameElement = body.selectFirst(".product-name");
           Element categoryElement = body.selectFirst(".breadcrumbs dd span:nth-last-child(2) a");
           Element scoreElement = body.selectFirst(".product-score");
           Element reviewsElement = body.selectFirst(".product-reviews-link"); 
           Element amountElement = body.selectFirst(".price"); 
           Elements params = body.select(".ProductSublineTags");
            
           ProductDTO productDTO = new ProductDTO(productId); 
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
               productDTO.setParams(params.text());
           } 

           return productDTO; 
            
        }catch(Exception e){
            e.printStackTrace();
            throw new ProviderException(e.getMessage());
        }
    }

    public List<ReviewDTO> getReviews(String productId) throws ProviderException{
        try{
            
            List<ReviewDTO> reviews = new ArrayList<>();
            
            boolean hasNextPage = false;
            int page = 1;
            
            do{ 
                Document doc = Jsoup.connect(  
                       "https://www.ceneo.pl/"+ productId + "/opinie-" + page
               ).get(); 
            
               Elements rows = doc.select(".review-box");
               
               hasNextPage = !doc.select(".arrow-next").isEmpty();
               
               for (Element row : rows) {   
                    Element voteYesButtonElement = row.selectFirst(".vote-yes");
                    Element authorElement = row.selectFirst(".reviewer-name-line");
                    Element summaryElement = row.selectFirst(".product-review-body");
                    Element scoreElement = row.selectFirst(".review-score-count");
                    Element timeElement = row.selectFirst(".review-time time");
                    Elements prosElements = row.select(".pros-cell li");
                    Elements consElements = row.select(".cons-cell li"); 
                    Element voteYesElement = row.selectFirst(".vote-yes span");
                    Element voteNoElement = row.selectFirst(".vote-no span"); 
                    Element recomendedElement = row.selectFirst(".reviewer-recommendation .product-recommended");
                    Element notRecomendedElement = row.selectFirst(".reviewer-recommendation .product-not-recommended");
                    
                    ReviewDTO reviewDTO = new ReviewDTO(voteYesButtonElement.attr("data-review-id"));
                    
                    if(authorElement!=null){
                        reviewDTO.setAuthor(authorElement.text());
                    }else{
                        reviewDTO.setAuthor("anonim");
                    }
                    
                    if(summaryElement != null){
                        reviewDTO.setSummary(summaryElement.text());
                    }
                    
                    if(scoreElement != null){
                        reviewDTO.setScore(scoreElement.text());
                    }
                    
                    if(timeElement != null){
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String datetime = timeElement.attr("datetime");
                        reviewDTO.setCreateDate(formatter.parse(datetime));
                    }
                    
                    if(prosElements != null){
                        StringBuilder stringBuilder = new StringBuilder();
                        for (Element prosElement : prosElements) {
                            stringBuilder.append(prosElement.text());
                            stringBuilder.append(" ");
                        }
                        reviewDTO.setAdvantages(stringBuilder.toString());
                    }
                    
                    if(consElements != null){
                        StringBuilder stringBuilder = new StringBuilder();
                        for (Element consElement : consElements) {
                            stringBuilder.append(consElement.text());
                            stringBuilder.append(" ");
                        }
                        reviewDTO.setDisadvantages(stringBuilder.toString());
                    }
                    
                    if(voteYesElement != null){
                        reviewDTO.setLikesCount(Integer.parseInt(voteYesElement.text()));
                    }
                    
                    if(voteNoElement != null){
                        reviewDTO.setDislikesCount(Integer.parseInt(voteNoElement.text()));
                    }
                    
                    if(recomendedElement != null){
                        reviewDTO.setIsRecomended(true);
                    }else if(notRecomendedElement != null){
                        reviewDTO.setIsRecomended(false);
                    }else{
                        reviewDTO.setIsRecomended(null);
                    }
                    reviews.add(reviewDTO);
               }  
               page++; 
            }while(hasNextPage);
            
            return reviews;
            
        }catch(Exception e){
            e.printStackTrace();
            throw new ProviderException(e.getMessage());
        } 
    }
    
}
