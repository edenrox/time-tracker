/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.timetracker.time;

/**
 *
 * @author ihopkins
 */
public class TimeUtils {
    
    
    public static double minutesToHours(int minutes) {
        return (double) Math.round((double) minutes / 60 * 100) / 100;
    }
    public static int hoursToMinutes(double hours) {
        return (int) Math.round(hours * 60);
    }
    
    public static String minutesToDuration(int minutes) {
        int hoursPart = minutes / 60;
        int minutesPart = minutes % 60;
        
        return String.format("%d:%02d", hoursPart, minutesPart);
    }
    
    public static String hoursToDuration(double hours) {
        return minutesToDuration(hoursToMinutes(hours));
    }
    
    public static int durationToMinutes(String duration) {
        String[] parts = duration.split(":");
        if (parts.length == 1) {
            return Integer.parseInt(parts[0]);
        } else {
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            return 60 * hours + minutes;
        }
    }
}
