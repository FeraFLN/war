/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.gui;

import com.ferafln.war.territorio.util.Observer;
import com.ferafln.war.territorio.util.Subject;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author feraf
 */
public class MouseClickAdd extends MouseAdapter implements Subject {

    private List<Observer> observers;
    private boolean changed;
    private final Object MUTEX = new Object();

    public MouseClickAdd() {
        this.observers = new ArrayList<>();
    }

    public void mouseClicked(java.awt.event.MouseEvent evt) {
        this.changed=true;
        notifyObservers();
    }

    @Override
    public void register(Observer obj) {
        if (obj == null) {
            throw new NullPointerException("Null Observer");
        }
        synchronized (MUTEX) {
            if (!observers.contains(obj)) {
                observers.add(obj);
            }
        }
    }

    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX) {
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed) {
                return;
            }
            observersLocal = new ArrayList<>(this.observers);
            this.changed = false;
        }
        for (Observer obj : observersLocal) {
            obj.update();
        }
       
    }

    @Override
    public Object getUpdate(Observer obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
