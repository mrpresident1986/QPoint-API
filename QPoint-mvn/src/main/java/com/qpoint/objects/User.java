/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qpoint.objects;

/**
 *
 * @author AllahAkbar
 */
public class User {

    
    public static enum UserType{
        NORMAL, SERVICEPROVIDER, EMPLOYEE
    }
    
    private int userId;
    private String deviceName;
    private String uuid;
    private String deviceVersion;
    private String devicePlatform;
    private String authCode;
    private UserType userType;
    private String phoneNumber;
    private String email;

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the deviceName
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * @param deviceName the deviceName to set
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return the deviceVersion
     */
    public String getDeviceVersion() {
        return deviceVersion;
    }

    /**
     * @param deviceVersion the deviceVersion to set
     */
    public void setDeviceVersion(String deviceVersion) {
        this.deviceVersion = deviceVersion;
    }

    /**
     * @return the devicePlatform
     */
    public String getDevicePlatform() {
        return devicePlatform;
    }

    /**
     * @param devicePlatform the devicePlatform to set
     */
    public void setDevicePlatform(String devicePlatform) {
        this.devicePlatform = devicePlatform;
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
     * @return the userType
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
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
}
