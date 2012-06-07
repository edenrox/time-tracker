/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.timetracker.invoicing;

import com.icadev.timetracker.db.NamedEntity;

/**
 *
 * @author ihopkins
 */
public class Tax extends NamedEntity {
    protected double rate;
    
    
    public double getRate() {
        return rate;
    }
    public void setRate(double value) {
        rate = value;
    }
    
    public static class Builder {
        protected Tax toBuild;
        
        public Builder() {
            toBuild = new Tax();
        }
        public Builder id(int value) {
            toBuild.setId(value);
            return this;
        }
        public Builder name(String value) {
            toBuild.setName(value);
            return this;
        }
        public Builder rate(double value) {
            toBuild.setRate(value);
            return this;
        }
        public Tax build() {
            return toBuild;
        }
    }
    
    
}
