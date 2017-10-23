/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.base;

/**
 *
 * @author seweryn
 */
public interface UseCaseExecutor {
    
    <REQUEST_OBJECT,RESPONSE_OBJECT> void  execute( 
            UseCase<REQUEST_OBJECT,RESPONSE_OBJECT> usecase , 
            REQUEST_OBJECT argument,
            OnSuccessListener<RESPONSE_OBJECT> onSuccess,
            OnErrorListener onError 
    );
    
}
