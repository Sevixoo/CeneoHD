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
public class DatabaseException extends RuntimeException {
    public DatabaseException() { }

    public DatabaseException(Throwable cause) {
        super(cause);
    }

    public DatabaseException(String message) {
        super(message);
    }
}
