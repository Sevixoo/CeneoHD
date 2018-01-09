/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.base;

/** 
 * @author seweryn
 * 
 * Ten interface obsługuje zgłaszanie błędu podczas wykonania UseCase'a.
 */
public interface OnErrorListener {
    
    /**
     * @param error - błąd zgłoszony podczas wykonania operacji
     */
    void onError( Throwable error );
    
}
