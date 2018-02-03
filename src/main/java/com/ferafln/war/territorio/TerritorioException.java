/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.territorio;

import com.ferafln.war.exception.WarException;

/**
 *
 * @author feraf
 */
public class TerritorioException extends WarException {

    public TerritorioException() {
    }

    public TerritorioException(String message) {
        super(message);
    }

    public TerritorioException(String message, Throwable cause) {
        super(message, cause);
    }

    public TerritorioException(Throwable cause) {
        super(cause);
    }

//    public TerritorioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
//        super(message, cause, enableSuppression, writableStackTrace);
//    }
    
}
