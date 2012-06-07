/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.timetracker.invoicing;

import com.icadev.timetracker.db.NamedEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ihopkins
 */
public class TaxCode extends NamedEntity {
    
    protected List<Tax> taxes;
    
    public List<Tax> getTaxes() {
        return taxes;
    }
    
    public TaxCode() {
        taxes = new ArrayList<Tax>();
    }
    
    public static class Builder {
        protected TaxCode toBuild;
        
        public Builder() {
            toBuild = new TaxCode();
        }
        public Builder id(int value) {
            toBuild.setId(value);
            return this;
        }
        public Builder name(String value) {
            toBuild.setName(value);
            return this;
        }
        public Builder addTax(Tax tax) {
            toBuild.getTaxes().add(tax);
            return this;
        }
        public TaxCode build() {
            return toBuild;
        }
    }
}
