/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.exception;

/**
 *
 * @author feraf
 */
public class WarException extends Exception{

    public WarException() {
    }

    public WarException(MessageExceptionEnum exceptionEnum){
        //TODO get the message on properties
    }

    
    public WarException(String message) {
        super(message);
    }

    public WarException(String message, Throwable cause) {
        super(message, cause);
    }

    public WarException(Throwable cause) {
        super(cause);
    }
}
