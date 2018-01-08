/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.provider.IWebClientService;
import com.project.base.ProviderException;  
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 *
 * @author seweryn
 */
class WebClientService implements IWebClientService{
    
    private OkHttpClient okHttpClient;
    
    WebClientService(){ 
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        okHttpClient = new OkHttpClient.Builder()
          .addInterceptor(logging)
          .build(); 
    }
    
    @Override
    public String get( String url ) throws ProviderException{
          Request request = new Request.Builder()
              .url(url)
              .build();
          try{
            Response response = okHttpClient.newCall(request).execute();
            if(!response.isSuccessful()){
                throw new ProviderException("Http error " + response.code());
            }
            if(response.body() != null){
                return response.body().string();
            }else{
                throw new ProviderException("Empty response");
            }
          }catch(IOException ex){
              throw new ProviderException("Connection lost");
          } 
    }
    
}
