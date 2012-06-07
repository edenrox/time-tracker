/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.timetracker.db;

/**
 *
 * @author ihopkins
 */
public class NamedEntity extends Entity {
    protected String name;
    
    public String getName() {
        return name;
    }
    public void setName(String value) {
        name = value;
    }
}
