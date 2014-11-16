/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qpoint.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author AllahAkbar
 */
public class DBAccess {
    
    String dbURL = "jdbc:mysql://localhost:3306/qpoint";
    String username = "qpoint";
    String password = "qpoint";
    
    public ResultSet executeSelectQuery(String statement){
        
        Connection dbConn = null;
        PreparedStatement stat = null;
        ResultSet result = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //getting database connection to MySQL server
            dbConn = DriverManager.getConnection(dbURL, username, password);
        
            stat = dbConn.prepareStatement(statement);
            result = stat.executeQuery();
        }catch(Exception ex){
            ///to be filled later
        }finally{
            try{
                dbConn.close();
                stat.close();
            }catch(Exception e){
                ////
            }
        }
        
        return result;
    }
    
    public int executeUpdateQuery(String statement){
        
        Connection dbConn = null;
        PreparedStatement stat = null;
        
        int result = 0;
                
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //getting database connection to MySQL server
            dbConn = DriverManager.getConnection(dbURL, username, password);
        
            stat = dbConn.prepareStatement(statement);
            result = stat.executeUpdate();
        }catch(Exception ex){
            ///to be filled later
        }finally{
            try{
                dbConn.close();
                stat.close();
            }catch(Exception e){
                ////
            }
        }
        
        return result;
    }
    
}
