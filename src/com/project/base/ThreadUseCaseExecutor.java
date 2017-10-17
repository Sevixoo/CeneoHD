/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.base;

import java.awt.EventQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.SwingUtilities;

/**
 *
 * @author seweryn
 */
public class ThreadUseCaseExecutor implements UseCaseExecutor {
    
   private final ExecutorService executor;
    
   public ThreadUseCaseExecutor(){ 
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
