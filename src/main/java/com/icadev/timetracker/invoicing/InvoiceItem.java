/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.timetracker.invoicing;

import com.icadev.timetracker.db.Entity;

/**
 *
 * @author ihopkins
 */
public class InvoiceItem extends Entity {
    protected int quantity;
    protected String description;
    protected String notes;
    protected double price;
    protected TaxCode taxCode;
    
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int value) {
        quantity = value;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String value) {
        description = value;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String value) {
        notes = value;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double value) {
        price = value;
    }
    public TaxCode getTaxCode() {
        return taxCode;
    }
    public void setTaxCode(TaxCode value) {
        taxCode = value;
    }
    
    public static class Builder {
        protected InvoiceItem toBuild;
        
        public Builder() {
            toBuild = new InvoiceItem();
        }
        public Builder id(int value) {
            toBuild.setId(value);
            return this;
        }
        public Builder quantity(int value) {
            toBuild.setQuantity(value);
            return this;
        }
        public Builder description(String value) {
            toBuild.setDescription(value);
            return this;
        }
        public Builder notes(String value) {
            toBuild.setNotes(value);
            return this;
        }
        public Builder price(double value) {
            toBuild.setPrice(value);
            return this;
        }
        public Builder taxCode(TaxCode value) {
            toBuild.setTaxCode(value);
            return this;
        }
        public InvoiceItem build() {
            return toBuild;
        }
    }
}
