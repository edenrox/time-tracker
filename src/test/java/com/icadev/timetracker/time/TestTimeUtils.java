/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.timetracker.time;

import com.icadev.timetracker.time.TimeUtils;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author ihopkins
 */
public class TestTimeUtils {
    
    public static final double DELTA = 0.0001;
    public static final int MINUTES_PER_HOUR = 60;
    
    @Test
    public void testToMinutes() {
        
        assertEquals(30, TimeUtils.hoursToMinutes(0.5));
        assertEquals(0.5, TimeUtils.minutesToHours(30), DELTA);
        
        assertEquals(60, TimeUtils.hoursToMinutes(1));
        assertEquals(1, TimeUtils.minutesToHours(MINUTES_PER_HOUR), DELTA);
        
        assertEquals(3, TimeUtils.hoursToMinutes(3.0/MINUTES_PER_HOUR));
        assertEquals((double) Math.round(3.0/MINUTES_PER_HOUR * 100) / 100, TimeUtils.minutesToHours(3), DELTA);
    }
    
    @Test
    public void testDurations() {
        
        assertEquals(123, TimeUtils.durationToMinutes("2:03"));
        assertEquals(17, TimeUtils.durationToMinutes("17"));
        
        assertEquals("1:13", TimeUtils.minutesToDuration(1 * MINUTES_PER_HOUR + 13));
        assertEquals("1:37", TimeUtils.hoursToDuration(1 + 37.0/MINUTES_PER_HOUR));

    }
    
}
