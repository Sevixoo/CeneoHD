/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.provider;

import com.project.base.ProviderException;

/**
 *
 * @author seweryn
 */
public interface IWebClientService {
    
    String get( String url )throws ProviderException;
    
}
