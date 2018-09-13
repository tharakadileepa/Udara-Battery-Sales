/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.udarabattery.newproj.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author THARAKA
 */
public class DBconnection {
    private static DBconnection dbConnection;
    private Connection connection;
    
    private DBconnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/udarabatterysales","root","1234");
    }
    
    public static DBconnection getInstance() throws Exception{
        if (dbConnection == null){
            dbConnection = new DBconnection();
        }
        return dbConnection;
    }
    
    public Connection getConnection(){
        return connection;
    }
}
