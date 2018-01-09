/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.base;

/**
 * @author seweryn
 * 
 * Ten interface obsługuje wynik operacji wykonania UseCase'a.
 * 
 * @param <RESULT_OBJECT> - typ wyniku operacji
 */
public interface OnSuccessListener<RESULT_OBJECT> {
    
    /**
     * @param result wynik operacji
     */
    void onSuccess( RESULT_OBJECT result );
    
}
