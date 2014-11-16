/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qpoint.objects;

import java.sql.Timestamp;

/**
 *
 * @author AllahAkbar
 */
public class ServiceSetup {
    
    private int serviceId;
    private String authCode;
    private String companyName;
    private String latitude;
    private String longitude;
    private String address;
    private long fromTime;
    private long toTime;
    private float workingHours;
    private String phoneNumber;
    private int serviceAverageDuration;
    private int numberOfEmployees;
    private Timestamp creationDate;
    private String about;
    private int automation;
    private int weekEnd;
    private String email;

    /**
     * @return the serviceId
     */
    public int getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId the serviceId to set
     */
    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * @return the authCode
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * @param authCode the authCode to set
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the workingHours
     */
    public float getWorkingHours() {
        return workingHours;
    }

    /**
     * @param workingHours the workingHours to set
     */
    public void setWorkingHours(float workingHours) {
        this.workingHours = workingHours;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the serviceAverageDuration
     */
    public int getServiceAverageDuration() {
        return serviceAverageDuration;
    }

    /**
     * @param serviceAverageDuration the serviceAverageDuration to set
     */
    public void setServiceAverageDuration(int serviceAverageDuration) {
        this.serviceAverageDuration = serviceAverageDuration;
    }

    /**
     * @return the numberOfEmployees
     */
    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    /**
     * @param numberOfEmployees the numberOfEmployees to set
     */
    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    /**
     * @return the creationDate
     */
    public Timestamp getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the fromTime
     */
    public long getFromTime() {
        return fromTime;
    }

    /**
     * @param fromTime the fromTime to set
     */
    public void setFromTime(long fromTime) {
        this.fromTime = fromTime;
    }

    /**
     * @return the toTime
     */
    public long getToTime() {
        return toTime;
    }

    /**
     * @param toTime the toTime to set
     */
    public void setToTime(long toTime) {
        this.toTime = toTime;
    }

    /**
     * @return the about
     */
    public String getAbout() {
        return about;
    }

    /**
     * @param about the about to set
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * @return the automation
     */
    public int getAutomation() {
        return automation;
    }

    /**
     * @param automation the automation to set
     */
    public void setAutomation(int automation) {
        this.automation = automation;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the weekEnd
     */
    public int getWeekEnd() {
        return weekEnd;
    }

    /**
     * @param weekEnd the weekEnd to set
     */
    public void setWeekEnd(int weekEnd) {
        this.weekEnd = weekEnd;
    }
    
    
}
