/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qpoint.v1;

import com.qpoint.db.QueryGenerator;
import com.qpoint.objects.Employee;
import com.qpoint.objects.ServiceSetup;
import com.qpoint.objects.User;
import com.qpoint.response.CompanyResponse;
import com.qpoint.response.Response;
import com.qpoint.response.UserRegistrationResponse;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author Ahmed Ahmed
 */
@Path("/v1/qpoint")
public class QPoint {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/register")
    public UserRegistrationResponse userRegistration(@Context HttpServletResponse servletResponse, @FormParam("uuid") String uuid, @FormParam("name") String deviceName, @FormParam("version") String deviceVersion, @FormParam("platform") String devicePlatform, @FormParam("type") String userType, @FormParam("email") String email, @FormParam("phoneNumber") String phone) {
        
        servletResponse.addHeader("Allow-Control-Allow-Methods", "POST");
        servletResponse.addHeader("Access-Control-Allow-Origin", "*");
        
        String authCode = null;
        String authentication = uuid + deviceName + deviceVersion + devicePlatform;
        try{
            MessageDigest utility = MessageDigest.getInstance("MD5");
            utility.update(authentication.getBytes());
            authCode = bytesToHex(utility.digest());
        }catch(Exception ex){
            /////
        }
        
        User user = new User();
        user.setDeviceName(deviceName);
        user.setDeviceVersion(deviceVersion);
        user.setDevicePlatform(devicePlatform);
        user.setUuid(uuid);
        user.setUserType(User.UserType.valueOf(userType));
        user.setAuthCode(authCode);
        user.setEmail(email);
        user.setPhoneNumber(phone);
        
        boolean ret = QueryGenerator.addUser(user);
        
        UserRegistrationResponse response = new UserRegistrationResponse();
        
        if(!ret){
            response.setStatus("failed");
        }else{
            response.setAuthCode(authCode);
        }
        
        return response;
    }
    
    
    public static String bytesToHex(byte[] b) {
      char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                         '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
      StringBuffer buf = new StringBuffer();
      for (int j=0; j<b.length; j++) {
         buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
         buf.append(hexDigit[b[j] & 0x0f]);
      }
      return buf.toString();
   }
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/service/setup")
    public Response serviceSetup(@Context HttpServletResponse servletResponse, @FormParam("authCode") String authCode, @FormParam("name") String companyName, @FormParam("lat") String latitude, @FormParam("lng") String longtitude, @FormParam("address") String address, @FormParam("from") long fromtime, @FormParam("to") long toTime, @FormParam("phoneNumber") String phoneNumber, @FormParam("serviceAverageDuration") int serviceAverageDuration, @FormParam("employeesNumber") int numberOfEmployees, @FormParam("about") String about, @FormParam("automation") int auto, @FormParam("email") String email, @FormParam("weekend") int enableWeekend) {
        
        servletResponse.addHeader("Allow-Control-Allow-Methods", "POST");
        servletResponse.addHeader("Access-Control-Allow-Origin", "*");
        
        float workingHours = toTime - fromtime;
        
        ServiceSetup setup = new ServiceSetup();
        setup.setAuthCode(authCode);
        setup.setCompanyName(companyName);
        setup.setLatitude(latitude);
        setup.setLongitude(longtitude);
        setup.setAddress(address);
        setup.setFromTime(fromtime);
        setup.setToTime(toTime);
        setup.setWorkingHours(workingHours);
        setup.setPhoneNumber(phoneNumber);
        setup.setServiceAverageDuration(serviceAverageDuration);
        setup.setNumberOfEmployees(numberOfEmployees);
        setup.setAbout(about);
        setup.setAutomation(auto);
        setup.setEmail(email);
        setup.setWeekEnd(enableWeekend);
        
        boolean ret = QueryGenerator.addServiceSetup(setup);
        
        Response response = new Response();
        
        if(!ret){
            response.setStatus("failed");
        }
        
        return response;
    }
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/employee/setup")
    public Response employeeSetup(@Context HttpServletResponse servletResponse, @FormParam("authCode") String authCode, @FormParam("name") String employeeName, @FormParam("lat") String latitude, @FormParam("lng") String longtitude, @FormParam("address") String address, @FormParam("company") int company, @FormParam("phoneNumber") String phoneNumber, @FormParam("email") String email) {
        
        servletResponse.addHeader("Allow-Control-Allow-Methods", "POST");
        servletResponse.addHeader("Access-Control-Allow-Origin", "*");
        
        
        Employee emp = new Employee();
        emp.setName(employeeName);
        emp.setLatitude(latitude);
        emp.setLongitude(longtitude);
        emp.setAddress(address);
        emp.setCompany(company);
        emp.setPhoneNumber(phoneNumber);
        emp.setEmail(email);
        
        boolean ret = QueryGenerator.addEmployee(emp);
        
        Response response = new Response();
        
        if(!ret){
            response.setStatus("failed");
        }
        
        return response;
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/employee/setup")
    public CompanyResponse getCompanies(@Context HttpServletResponse servletResponse) {
        
        servletResponse.addHeader("Allow-Control-Allow-Methods", "GET");
        servletResponse.addHeader("Access-Control-Allow-Origin", "*");
        
        
        
        List<ServiceSetup> comps = QueryGenerator.getAllCompanies();
        
        CompanyResponse response = new CompanyResponse();
        
        if(!(comps.size() > 0)){
            response.setStatus("failed");
        }else{
            response.setSetups(comps);
        }
        
        return response;
    }
}
