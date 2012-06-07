/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.timetracker.invoicing;

import java.util.HashMap;

/**
 *
 * @author ihopkins
 */
public class InvoiceTotals {
    protected Invoice invoice;
    protected int quantity;
    protected double subtotal;
    protected double taxTotal;
    protected HashMap<Tax, TaxTotal> taxTotals;
    protected double total;
    
    
    public int getQuantity() {
        return quantity;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public double getTaxTotal() {
        return taxTotal;
    }
    public double getTaxTotal(Tax tax) {
        if (!taxTotals.containsKey(tax)) {
            return 0;
        }
        return taxTotals.get(tax).getTaxAmount();
    }
    public double getTotal() {
        return total;
    }
    
    
    public InvoiceTotals(Invoice theInvoice) {
        invoice = theInvoice;
        taxTotals = new HashMap<Tax, TaxTotal>();
        reset();
    }
    
    protected final void reset() {
        quantity = 0;
        subtotal = 0;
        taxTotal = 0;
        total = 0;
        taxTotals.clear();
    }
    
    public void calculate() {
        reset();
        
        // calculate the quantity and subtotals
        for(InvoiceItem item : invoice.getItems()) {
            double itemSubtotal = item.getPrice() * item.getQuantity();
            
            quantity += item.getQuantity();
            subtotal += itemSubtotal;
            
            if (item.getTaxCode() != null) {
                for(Tax tax : item.getTaxCode().getTaxes()) {
                    if (!taxTotals.containsKey(tax)) {
                        taxTotals.put(tax, new TaxTotal());
                    }
                    taxTotals.get(tax).addTaxableAmount(itemSubtotal);
                }
            }
        }
        
        // calcualte the tax totals
        for(Tax tax : taxTotals.keySet()) {
            TaxTotal totalItem = taxTotals.get(tax);
            double taxAmount = CurrencyUtils.round(totalItem.getTaxableAmount() * tax.getRate());
            totalItem.setTaxAmount(taxAmount);
            taxTotal += taxAmount;
        }
        
        // calculate the total
        total = subtotal + taxTotal;
    }
    
}
