/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qpoint.response;

/**
 *
 * @author AllahAkbar
 */
public class UserRegistrationResponse extends Response{
    
    private String authCode;

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
    
    
    
}
