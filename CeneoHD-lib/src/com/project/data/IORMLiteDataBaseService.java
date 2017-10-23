/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.data;

import com.project.data.IORMLiteDataBase;

/**
 *
 * @author seweryn
 */
public interface IORMLiteDataBaseService {
    
    String getDatabaseName();

    boolean dataBaseExists();

    IORMLiteDataBase createDataBase();

    IORMLiteDataBase provideDataBase();
    
    void clearDatabase();
    
}
