/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icadev.timetracker.time;

import com.icadev.timetracker.db.Entity;
import java.util.Date;

/**
 *
 * @author ihopkins
 */
public class TimeSlot extends Entity {
    protected int employeeId;
    protected int workTypeId;
    protected Date startTime;
    protected double duration;
    
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int value) {
        employeeId = value;
    }
    public int getWorkTypeId() {
        return workTypeId;
    }
    public void setWorkTypeId(int value) {
        workTypeId = value;
    }
    public Date getStartTime() {
        return startTime;
    }
    public void setStartTime(Date value) {
        startTime = value;
    }
    public double getDuration() {
        return duration;
    }
    public void setDuration(double value) {
        duration = value;
    }
}
