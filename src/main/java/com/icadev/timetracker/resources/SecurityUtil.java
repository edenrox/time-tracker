/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.timetracker.resources;

/**
 *
 * @author ihopkins
 */
public class SecurityUtil {
    
    public static void ensureLoggedInUser() {
        // load the user
        
        if (true) {
            throw new RuntimeException("Security Exception: you must be logged in to access this resource");
        }
    }
    
    public static void ensureAdminUser() {
        ensureLoggedInUser();
        
        if (true) {
            throw new RuntimeException("Security Exception: this endpoint requires an admin user");
        }
    }
    
}
