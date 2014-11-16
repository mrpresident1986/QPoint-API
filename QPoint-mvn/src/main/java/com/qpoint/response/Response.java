/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qpoint.response;

/**
 *
 * @author AllahAkbar
 */
public class Response {
    private String status = "success";
    private long processingDate = System.currentTimeMillis();

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the processingDate
     */
    public long getProcessingDate() {
        return processingDate;
    }

    /**
     * @param processingDate the processingDate to set
     */
    public void setProcessingDate(long processingDate) {
        this.processingDate = processingDate;
    }
    
    
}
