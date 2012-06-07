/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.common;

import java.util.List;

/**
 *
 * @author ihopkins
 */
public class StringUtils {
    
    public static final char SPACE = ' ';
    
    public static String join(List<?> items, String glue) {
        if (items == null) {
            return join((Object[]) null, glue);
        }
        return join(items.toArray(), glue);
    }
    public static String join(Object[] items, String glue) {
        if (items == null) {
            items = new Object[] {};
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < items.length; i++) {
            if (i > 0) {
                sb.append(glue);
            }
            if (items[i] == null) {
                sb.append("null");
            } else {
                sb.append(items[i].toString());
            }
        }

        return sb.toString();
    }

    public static String join(int[] items, String glue) {
        if (items == null) {
            items = new int[] {};
        }
        Integer[] witems = new Integer[items.length];
        for(int i = 0; i < items.length; i++) {
            witems[i] = new Integer(items[i]);
        }
        return join(witems, glue);
    }

    public static int[] splitInt(String str, String regex) {
        if (str == null) {
            str = "";
        }
        if (str.trim().length() == 0) {
            return new int[0];
        }
        String[] parts = str.split(regex);
        int[] rv = new int[parts.length];
        for(int i = 0; i < parts.length; i++) {
            rv[i] = Integer.parseInt(parts[i].trim());
        }
        return rv;
    }
    
    public static boolean isNullOrEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }
    
    protected void appendCount(StringBuilder dest, String source, int count) {
        for(int i = 0; i < count; i++) {
            dest.append(source);
        }
    }
    
    public String repeat(String toRepeat, int count) {
        if (toRepeat == null) {
            toRepeat = "";
        }

        StringBuilder sb = new StringBuilder(count * toRepeat.length());
        appendCount(sb, toRepeat, count);
        return sb.toString();
    }
    
    public String center(String toCenter, int count) {
        return center(toCenter, count, SPACE);
    }
    
    public String center(String toCenter, int count, char whitespace) {
        StringBuilder sb = new StringBuilder(count);
        int extraSpace = (count - toCenter.length());
        int left = extraSpace/ 2;
        int right = extraSpace - left;
        
        appendCount(sb, "" + whitespace, left);
        sb.append(toCenter);
        appendCount(sb, "" + whitespace, right);

        return sb.toString();
    }
}
