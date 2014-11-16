/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qpoint.response;

import com.qpoint.objects.ServiceSetup;
import java.util.List;

/**
 *
 * @author AllahAkbar
 */
public class CompanyResponse extends Response{
    
    private List<ServiceSetup> setups;

    /**
     * @return the setups
     */
    public List<ServiceSetup> getSetups() {
        return setups;
    }

    /**
     * @param setups the setups to set
     */
    public void setSetups(List<ServiceSetup> setups) {
        this.setups = setups;
    }
    
}
