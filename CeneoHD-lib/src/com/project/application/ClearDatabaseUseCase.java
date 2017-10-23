/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.base.UseCase;
import com.project.data.IORMLiteDataBaseService;

/**
 *
 * @author seweryn
 */
public class ClearDatabaseUseCase implements UseCase<Void,Void>{
   
    private final IORMLiteDataBaseService dataBaseService;
    
    public ClearDatabaseUseCase( IORMLiteDataBaseService dataBaseService){
        this.dataBaseService = dataBaseService;
    }
    
    @Override
    public Void execute(Void request) throws Throwable{
        dataBaseService.clearDatabase();
        return null;
    }
    
}
