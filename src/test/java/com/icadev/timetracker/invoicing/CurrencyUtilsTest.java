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
public class CurrencyUtilsTest {
    
    public static final double DELTA = 0.0001;
    
    @Test
    public void testRounding() {
        
        assertEquals(12.06, CurrencyUtils.round(12.06), DELTA);
        assertEquals(12.06, CurrencyUtils.round(12.064), DELTA);
        
        assertEquals(12.07, CurrencyUtils.round(12.065), DELTA);
        assertEquals(12.07, CurrencyUtils.round(12.068), DELTA);

    }
}
