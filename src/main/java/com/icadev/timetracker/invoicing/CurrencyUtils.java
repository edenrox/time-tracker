/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.timetracker.invoicing;

/**
 *
 * @author ihopkins
 */
public class CurrencyUtils {
    
    public static double round(double value) {
        return (double) Math.round(value * 100) / 100;
    }
    
}
