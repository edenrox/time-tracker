/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.timetracker.invoicing;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author ihopkins
 */
public class InvoiceTest {
    
    public static final double DELTA = 0.0001;
    public static Tax TAX3, TAX6;
    public static TaxCode TAX_CODE_NONE, TAX_CODE_BOTH, TAX_CODE3, TAX_CODE6;
    
    @BeforeClass
    public static void initTaxes() {
        
        TAX3 = new Tax.Builder()
                .id(1).name("Tax 3.0%").rate(0.03)
                .build();
        
        TAX6 = new Tax.Builder()
                .id(2).name("Tax 6.0%").rate(0.06)
                .build();
        
        TAX_CODE_NONE = new TaxCode.Builder()
                .id(1).name("Tax Exempt")
                .build();
        TAX_CODE_BOTH = new TaxCode.Builder()
                .id(2).name("Tax 3 & 6").addTax(TAX3).addTax(TAX6)
                .build();
        TAX_CODE3 = new TaxCode.Builder()
                .id(3).name("Tax 3").addTax(TAX3)
                .build();
        TAX_CODE6 = new TaxCode.Builder()
                .id(5).name("Tax 6").addTax(TAX6)
                .build();
    }
    

    @Test
    public void testEmpty() {
        Invoice i = new Invoice();
        InvoiceTotals t = i.getTotals();
        
        assertEquals(0, t.getQuantity());
        assertEquals(0, t.getSubtotal(), DELTA);
        assertEquals(0, t.getTaxTotal(), DELTA);
        assertEquals(0, t.getTaxTotal(TAX3), DELTA);
        assertEquals(0, t.getTotal(), DELTA);
    }
    
    @Test
    public void testNoTax() {
        Invoice i = new Invoice();
        InvoiceTotals t = i.getTotals();
        
        i.addItem(new InvoiceItem.Builder()
                .quantity(3).price(12.56).taxCode(TAX_CODE_NONE)
                .build());
        i.addItem(new InvoiceItem.Builder()
                .quantity(1).price(1.11).taxCode(TAX_CODE_NONE)
                .build());
        
        int quantityExpected = 4;
        double subtotalExpected = 3 * 12.56 + 1 * 1.11;
        
        assertEquals(quantityExpected, t.getQuantity());
        assertEquals(subtotalExpected, t.getSubtotal(), DELTA);
        assertEquals(0, t.getTaxTotal(), DELTA);
        assertEquals(0, t.getTaxTotal(TAX3), DELTA);
        assertEquals(subtotalExpected, t.getTotal(), DELTA);
    }
    
    @Test
    public void testOneTax() {
        Invoice i = new Invoice();
        InvoiceTotals t = i.getTotals();
        
        i.addItem(new InvoiceItem.Builder()
                .quantity(15).price(4.95).taxCode(TAX_CODE3)
                .build());
        i.addItem(new InvoiceItem.Builder()
                .quantity(1).price(3.12).taxCode(TAX_CODE3)
                .build());
        
        int quantityExpected = 16;
        double subtotalExpected = 15 * 4.95 + 1 * 3.12;
        double taxTotalExpected = CurrencyUtils.round(subtotalExpected * TAX3.getRate());
        double totalExpected = subtotalExpected + taxTotalExpected;
        
        assertEquals(quantityExpected, t.getQuantity());
        assertEquals(subtotalExpected, t.getSubtotal(), DELTA);
        assertEquals(taxTotalExpected, t.getTaxTotal(), DELTA);
        assertEquals(taxTotalExpected, t.getTaxTotal(TAX3), DELTA);
        assertEquals(0, t.getTaxTotal(TAX6), DELTA);
        assertEquals(totalExpected, t.getTotal(), DELTA);
    }
    
    @Test
    public void testMultiTax() {
        Invoice i = new Invoice();
        InvoiceTotals t = i.getTotals();
        
        i.addItem(new InvoiceItem.Builder()
                .quantity(8).price(4.95).taxCode(TAX_CODE3)
                .build());
        i.addItem(new InvoiceItem.Builder()
                .quantity(2).price(3.12).taxCode(TAX_CODE6)
                .build());
        
        int quantityExpected = 10;
        double subtotalExpected = 8 * 4.95 + 2 * 3.12;
        double tax3Expected = CurrencyUtils.round(8 * 4.95 * TAX3.getRate());
        double tax6Expected = CurrencyUtils.round(2 * 3.12 * TAX6.getRate());
        double taxTotalExpected = tax3Expected + tax6Expected;
        double totalExpected = subtotalExpected + taxTotalExpected;
        
        assertEquals(quantityExpected, t.getQuantity());
        assertEquals(subtotalExpected, t.getSubtotal(), DELTA);
        assertEquals(taxTotalExpected, t.getTaxTotal(), DELTA);
        assertEquals(tax3Expected, t.getTaxTotal(TAX3), DELTA);
        assertEquals(tax6Expected, t.getTaxTotal(TAX6), DELTA);
        assertEquals(totalExpected, t.getTotal(), DELTA);
    }
    
    @Test
    public void testAfterDelete() {
        Invoice i = new Invoice();
        InvoiceTotals t = i.getTotals();
        
        i.addItem(new InvoiceItem.Builder()
                .quantity(5).price(6.21).taxCode(TAX_CODE3)
                .build());
        i.addItem(new InvoiceItem.Builder()
                .quantity(2).price(3.12).taxCode(TAX_CODE6)
                .build());
        i.addItem(new InvoiceItem.Builder()
                .quantity(1).price(1.12).taxCode(TAX_CODE6)
                .build());
        
        i.removeItem(1);
        
        int quantityExpected = 6;
        double subtotalExpected = 5 * 6.21 + 1 * 1.12;
        double tax3Expected = CurrencyUtils.round(5 * 6.21 * TAX3.getRate());
        double tax6Expected = CurrencyUtils.round(1 * 1.12 * TAX6.getRate());
        double taxTotalExpected = tax3Expected + tax6Expected;
        double totalExpected = subtotalExpected + taxTotalExpected;
        
        assertEquals(quantityExpected, t.getQuantity());
        assertEquals(subtotalExpected, t.getSubtotal(), DELTA);
        assertEquals(taxTotalExpected, t.getTaxTotal(), DELTA);
        assertEquals(tax3Expected, t.getTaxTotal(TAX3), DELTA);
        assertEquals(tax6Expected, t.getTaxTotal(TAX6), DELTA);
        assertEquals(totalExpected, t.getTotal(), DELTA);
    }
}
