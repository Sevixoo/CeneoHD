/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.impl;

import com.project.data.IORMLiteDataBase;
import com.project.data.IORMLiteDataBaseService;
import java.io.File;

/**
 *
 * @author seweryn
 */
class ORMLiteDataBaseService implements IORMLiteDataBaseService {

    private static String TAG = ORMLiteDataBaseService.class.getName();
    private static final int DB_VERSION = 5;

    private final String PATH_TO_DATABASE = "./";

    private ORMLiteDatabase ormLiteDatabase;

    @Override
    public String getDatabaseName(){
        return "CeneoHD_" + DB_VERSION + ".db";
    }

    private File getDatabaseFile( String name ){
        return new File(PATH_TO_DATABASE + name);
    }

    @Override
    public boolean dataBaseExists() {
        String name = getDatabaseName();
        File dbFile = getDatabaseFile(name);
        boolean dbExists = dbFile.exists() && !dbFile.isDirectory();
        if(dbExists){
            ormLiteDatabase = new ORMLiteDatabase(dbFile);
            System.out.println("[ORMLiteDataBaseService]"+TAG+":connectDatabase:"+dbFile.getPath());
        }
        return dbExists;
    }

    @Override
    public IORMLiteDataBase createDataBase() {
        String name = getDatabaseName();
        File dbFile = getDatabaseFile(name);
        ormLiteDatabase = new ORMLiteDatabase(dbFile);
        ormLiteDatabase.onCreateDataBase();
        System.out.println("[ORMLiteDataBaseService]"+TAG+":createDataBase:"+dbFile.getPath());
        return ormLiteDatabase;
    }

    @Override
    public IORMLiteDataBase provideDataBase(){
        if(ormLiteDatabase==null)throw new RuntimeException("Application not initialized");
        return ormLiteDatabase;
    }
    
    @Override
    public void clearDatabase(){
        //TODO... wyczyścić dane
    }
    
}
