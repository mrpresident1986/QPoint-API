/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qpoint.db;

import com.qpoint.objects.Employee;
import com.qpoint.objects.ServiceSetup;
import com.qpoint.objects.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AllahAkbar
 */
public class QueryGenerator {
    private static Object ResultSet;
    
    public static boolean addUser(User user){
        boolean success = false;
        
        String query = "INSERT INTO users (deviceName, uuid, deviceVersion, devicePlatform, authCode, userType, email, phoneNumber) VALUES ('"+user.getDeviceName()+"','"+user.getUuid()+"','"+user.getDeviceVersion()+"','"+user.getDevicePlatform()+"','"+user.getAuthCode()+"','"+user.getUserType().name()+"','"+user.getEmail()+"','"+user.getPhoneNumber()+"')";
        
        DBAccess db = new DBAccess();
        int result = db.executeUpdateQuery(query);
        
        if(result > 0) success = true;
        
        return success;
    }
    
    
    public static boolean addServiceSetup(ServiceSetup setup){
        boolean success = false;
        
        String query = "INSERT INTO service_setup(authCode, companyName, latitude, longitude, address, fromTime, toTime, workingHours, phoneNumber, serviceAverageDuration, numberOfEmployees, createdDate, about, automation, email, weekEnd) VALUES ('"+setup.getAuthCode()+"','"+setup.getCompanyName()+"','"+setup.getLatitude()+"','"+setup.getLongitude()+"','"+setup.getAddress()+"',"+setup.getFromTime()+","+setup.getToTime()+","+setup.getWorkingHours()+",'"+setup.getPhoneNumber()+"',"+setup.getServiceAverageDuration()+","+setup.getNumberOfEmployees()+",now(),'"+setup.getAbout()+"',"+ setup.getAutomation()+",'"+setup.getEmail()+"',"+setup.getWeekEnd()+")";
        
        DBAccess db = new DBAccess();
        int result = db.executeUpdateQuery(query);
        
        if(result > 0) success = true;
        
        return success;
    }
    
    
    public static boolean addEmployee(Employee emp){
        boolean success = false;
        
        String query = "INSERT INTO employee_info(authCode, name, latitude, longitude, address, company, phoneNumber, email) VALUES ('"+emp.getAuthCode()+"','"+emp.getName()+"','"+emp.getLatitude()+"','"+emp.getLongitude()+"','"+emp.getAddress()+"',"+emp.getCompany()+",'"+emp.getPhoneNumber()+"','"+emp.getEmail()+"')";
        
        DBAccess db = new DBAccess();
        int result = db.executeUpdateQuery(query);
        
        if(result > 0) success = true;
        
        return success;
    }
    
    public static List<ServiceSetup> getAllCompanies(){
        String query = "SELECT * FROM service_setup";
        DBAccess db = new DBAccess();
        ResultSet result = null;
        List<ServiceSetup> comps = null;
        
        try{
            result = db.executeSelectQuery(query);
            comps = buildCompanies(result);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return comps;
    }
    
    public static ServiceSetup getcompanyById(int id){
        String query = "SELECT * FROM service_setup WHERE serviceId = "+id;
        DBAccess db = new DBAccess();
        ResultSet result = null;
        List<ServiceSetup> comps = null;
        ServiceSetup comp = null;
        
        try{
            result = db.executeSelectQuery(query);
            comps = buildCompanies(result);
            comp = comps.get(0);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return comp;
    }
    
    private static List<ServiceSetup> buildCompanies(ResultSet result) throws Exception{
        List<ServiceSetup> comps = new ArrayList<ServiceSetup>();
        
        while(result.next()){
            ServiceSetup comp = new ServiceSetup();
            comp.setServiceId(result.getInt("serviceID"));
            comp.setAuthCode(result.getString("authCode"));
            comp.setCompanyName(result.getString("companyName"));
            comp.setLatitude(result.getString("latitude"));
            comp.setLongitude(result.getString("longitude"));
            comp.setAddress(result.getString("address"));
            comp.setFromTime(result.getLong("fromTime"));
            comp.setToTime(result.getLong("toTime"));
            comp.setWorkingHours(result.getFloat("workingHours"));
            comp.setPhoneNumber(result.getString("phoneNumber"));
            comp.setEmail(result.getString("email"));
            comp.setServiceAverageDuration(result.getInt("serviceAverageDuration"));
            comp.setNumberOfEmployees(result.getInt("numberOfEmployee"));
            comp.setCreationDate(result.getTimestamp("createdDate"));
            comp.setAbout(result.getString("about"));
            comp.setAutomation(result.getInt("automation"));
            comp.setWeekEnd(result.getInt("weekEnd"));
            
            comps.add(comp);
        }
        
        return comps;
    }
}
