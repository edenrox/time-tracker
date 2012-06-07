/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.timetracker.entities;

import com.icadev.timetracker.db.Entity;

/**
 *
 * @author ihopkins
 */
public class Employee extends Entity {
    
    protected String firstName;
    protected String lastName;
    protected boolean isAdmin;
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String value) {
        firstName = value;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String value) {
        lastName = value;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean value) {
        isAdmin = value;
    }
    public String getName() {
        return String.format("%s %s", firstName, lastName);
    }
    
}
