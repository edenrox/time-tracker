/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.timetracker.entities;

import com.icadev.timetracker.db.NamedEntity;

/**
 *
 * @author ihopkins
 */
public class Project extends NamedEntity {
    protected int clientId;
    
    public int getClientId() {
        return clientId;
    }
    public void setClientId(int value) {
        clientId = value;
    }
}
