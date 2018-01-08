/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.data;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.project.base.DatabaseException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author seweryn
 */
public class DAO<T> {

    private Dao<T, Long> ormDAO;

    public static <M> DAO<M> create( Class<M> clazz , Dao<M, Long> ormDAO ){
        return new DAO<M>( clazz , ormDAO );
    }

    protected DAO(Class<T> clazz , Dao<T, Long> ormDAO) {
        this.ormDAO = ormDAO;
    }

    public void save(T item) throws DatabaseException {
        try {
            ormDAO.createOrUpdate(item);
        }catch (SQLException ex){
            throw  new DatabaseException(ex);
        }
    }

    public void delete(String remoteId) throws DatabaseException {
        try {
            DeleteBuilder deleteBuilder = ormDAO.deleteBuilder();
            deleteBuilder.where().eq("remoteId",remoteId);
            deleteBuilder.delete();
        }catch (SQLException ex){
            throw  new DatabaseException(ex);
        }
    }

    public void deleteItem(T item) throws DatabaseException {
        try {
            ormDAO.delete(item);
        }catch (SQLException ex){
            throw  new DatabaseException(ex);
        }
    }

    public QueryBuilder<T,Long> queryBuilder(){
        return ormDAO.queryBuilder();
    }

    public T load(String remoteId) throws DatabaseException{
        try {
            return ormDAO.queryBuilder().where().eq("remoteId",remoteId).queryForFirst();
        }catch (SQLException ex){
            throw  new DatabaseException(ex);
        }
    }

    public List<T> list() throws DatabaseException{
        try {
            return ormDAO.queryForAll();
        }catch (SQLException ex){
            throw  new DatabaseException(ex);
        }
    }


}
