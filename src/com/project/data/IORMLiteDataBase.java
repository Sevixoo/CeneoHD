/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.data;
 

/**
 *
 * @author seweryn
 */
public interface IORMLiteDataBase{

    <T> DAO<T> provideDAO(Class<T> clazz) throws DatabaseException;
 
}
