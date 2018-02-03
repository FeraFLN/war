/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.dado;

import com.ferafln.war.exception.MessageExceptionEnum;
import com.ferafln.war.exception.WarException;

/**
 *
 * @author feraf
 */
public class DadosException extends WarException{

    public DadosException(MessageExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }

    public DadosException() {
    }

    public DadosException(String message) {
        super(message);
    }

    public DadosException(String message, Throwable cause) {
        super(message, cause);
    }

    public DadosException(Throwable cause) {
        super(cause);
    }

//    public DadosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
//        super(message, cause, enableSuppression, writableStackTrace);
//    }
    
}
