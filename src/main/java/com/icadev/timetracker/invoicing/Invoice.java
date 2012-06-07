/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.timetracker.invoicing;

import com.icadev.timetracker.db.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ihopkins
 */
public class Invoice extends Entity {
    protected List<InvoiceItem> items;
    protected InvoiceTotals totals;
    
    public InvoiceTotals getTotals() {
        return totals;
    }
    public Iterable<InvoiceItem> getItems() {
        return items;
    }
    public void addItem(InvoiceItem item) {
        items.add(item);
        totals.calculate();
    }
    public void removeItem(int index) {
        items.remove(index);
        totals.calculate();
    }
    
    public Invoice() {
        items = new ArrayList<InvoiceItem>();
        totals = new InvoiceTotals(this);
    }
}
