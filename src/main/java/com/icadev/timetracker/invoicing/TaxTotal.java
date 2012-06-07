/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.timetracker.invoicing;

/**
 *
 * @author ihopkins
 */
public class TaxTotal {
    public double taxableAmount;
    public double taxAmount;
    
    public double getTaxableAmount() {
        return taxableAmount;
    }
    public void addTaxableAmount(double amount) {
        taxableAmount += amount;
    }
    
    public double getTaxAmount() {
        return taxAmount;
    }
    public void setTaxAmount(double value) {
        taxAmount = value;
    }
    
    public TaxTotal() {
        taxableAmount = 0;
        taxAmount = 0;
    }

}
