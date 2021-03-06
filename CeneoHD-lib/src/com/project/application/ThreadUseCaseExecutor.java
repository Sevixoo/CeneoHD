/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.base.OnErrorListener;
import com.project.base.OnSuccessListener;
import com.project.base.UseCase;
import com.project.base.UseCaseExecutor;
import java.awt.EventQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.SwingUtilities;

/**
 *
 * @author seweryn
 */
class ThreadUseCaseExecutor implements UseCaseExecutor {
    
   private final ExecutorService executor;
    
   ThreadUseCaseExecutor(){ 
       executor = Executors.newFixedThreadPool(3);
   }
    
    public <REQUEST_OBJECT,RESPONSE_OBJECT> void execute( 
            UseCase<REQUEST_OBJECT,RESPONSE_OBJECT> usecase , 
            REQUEST_OBJECT argument,
            OnSuccessListener<RESPONSE_OBJECT> onSuccess,
            OnErrorListener onError 
    ){
        executor.execute(() -> {
            try{
                System.out.println("["+usecase.getClass().getSimpleName()+"] execute");
                Thread.sleep(500);//for testing
                RESPONSE_OBJECT response = usecase.execute(argument);
                EventQueue.invokeLater(() -> {
                    System.out.println("["+usecase.getClass().getSimpleName()+"] success");
                    onSuccess.onSuccess(response);
                });  
            }catch(Throwable error){
                EventQueue.invokeLater(() -> {
                    System.out.println("["+usecase.getClass().getSimpleName()+"] error" + error.getMessage());
                    onError.onError(error);
                }); 
            }
        });
    }
    
}
