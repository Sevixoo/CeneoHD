/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.project.data.DAO;
import com.project.base.DatabaseException;
import com.project.data.IORMLiteDataBase;
import com.project.entity.ProductEntity;
import com.project.entity.ReviewEntity;
import java.io.File;
import java.sql.SQLException;

/**
 *
 * @author seweryn
 */
class ORMLiteDatabase implements IORMLiteDataBase {

    private final static String DATABASE_URL = "jdbc:sqlite:";

    private ConnectionSource connectionSource = null;
  
    ORMLiteDatabase(File dbFile) {
        try {
            this.connectionSource = new JdbcConnectionSource(DATABASE_URL+dbFile.getPath());
        }catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public void onCreateDataBase(){
        try {
            TableUtils.createTable(connectionSource, ProductEntity.class );
            TableUtils.createTable(connectionSource, ReviewEntity.class ); 
        }catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    
    public void onClearDatabase(){
        try { 
            TableUtils.clearTable(connectionSource, ReviewEntity.class ); 
            TableUtils.clearTable(connectionSource, ProductEntity.class ); 
        }catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    @Override
    public <T> DAO<T> provideDAO(Class<T> clazz) throws DatabaseException {
        try {
            return DAO.create(clazz , DaoManager.createDao(connectionSource, clazz));
        }catch (SQLException ex){
            throw new DatabaseException(ex);
        }
    }
 
}
