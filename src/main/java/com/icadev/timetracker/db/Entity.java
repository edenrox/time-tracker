/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.timetracker.db;

import com.icadev.common.Inflector;

/**
 *
 * @author ihopkins
 */
public abstract class Entity {
    protected int id;
    
    
    public int getId() {
        return id;
    }
    public void setId(int value) {
        id = value;
    }
    
    public String getTableName() {
        return Inflector.underscore(this.getClass().getSimpleName());
    }
}
