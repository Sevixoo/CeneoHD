/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.base.UseCase;
import com.project.data.IORMLiteDataBaseService;
import java.io.IOException;

/**
 *
 * @author seweryn
 */
public class InitializeApplicationUseCase implements UseCase<Void, Void>{
    
    private IORMLiteDataBaseService dataBaseService;
    
    public InitializeApplicationUseCase(IORMLiteDataBaseService dataBaseService){ 
        this.dataBaseService = dataBaseService;
    }
    
    @Override
    public Void execute(Void request) throws Throwable{  
        if(!dataBaseService.dataBaseExists()){
            dataBaseService.createDataBase();
        }
        return null;
    }
    
}
