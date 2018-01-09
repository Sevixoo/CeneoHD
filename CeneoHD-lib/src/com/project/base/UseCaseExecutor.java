/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.base;

/** 
 * @author seweryn
 * 
 * Ten interface realizuje wykonanie operacji UseCase i obsługuje 
 * dostarczenie jej wyniku. Jeśeli operacja wykonania jest przeprowadzana
 * w tle, odpowiedź powinna zostać dostarczona w wątku UI.
 */
public interface UseCaseExecutor {
    
    /** 
     * @param <REQUEST_OBJECT> - typ argumentu operacji
     * @param <RESPONSE_OBJECT> - typ wyniku operacji
     * @param usecase - UseCase, który ma być wykonany
     * @param argument - argument operacji
     * @param onSuccess - listener wywołany po wykonaniu operacji
     * @param onError - listener wywołany w przypadku błędu wykonania
     */
    <REQUEST_OBJECT,RESPONSE_OBJECT> void  execute( 
            UseCase<REQUEST_OBJECT,RESPONSE_OBJECT> usecase , 
            REQUEST_OBJECT argument,
            OnSuccessListener<RESPONSE_OBJECT> onSuccess,
            OnErrorListener onError 
    );
    
}
