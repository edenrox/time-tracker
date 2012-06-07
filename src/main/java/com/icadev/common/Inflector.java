/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.common;

/**
 *
 * @author ihopkins
 */
public class Inflector {
    
    public static String uppercaseFirst(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
    public static String lowercaseFirst(String word) {
        return word.substring(0, 1).toLowerCase() + word.substring(1);
    }
    
    public static String properCase(String underscored) {
        StringBuilder sb = new StringBuilder(underscored.length());
        String[] parts = underscored.split("[ _]");
        for(String part : parts) {
            sb.append(uppercaseFirst(part.toLowerCase()));
        }
        return sb.toString();
    }
    
    public static String camelCase(String underscored) {
        return lowercaseFirst(properCase(underscored));
    }
    
    public static String underscore(String camelCase) {
        camelCase = camelCase.replace(" ", "_");
        
        return "";
    }
    public static String humanize(String underscored) {
        return underscored.replace("_", " ");
    }
    
    
}
