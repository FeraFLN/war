/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.utilitarios;

import java.util.List;

/**
 *
 * @author fernandoneto
 */
public class Util {
    
     public static Object getValue(List<? extends Object> list,Object o){
        int index = list.indexOf(o);
        return list.get(index);
    }
}
