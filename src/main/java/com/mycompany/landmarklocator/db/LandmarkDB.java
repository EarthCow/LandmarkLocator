
package com.mycompany.landmarklocator.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * CMPSC 221 Program LandmarkLocator
 * LandmarkDB.java
 * Purpose: Handles database pushing and pulling
 * 
 * @version 1.0 Apr 19, 2024
 */
public class LandmarkDB {
    
    String className = null;
    String url = null;
    String user = null;
    String password = null;
    
    /**
     * Pulls the data from the db.properties file, creates the db if non-existent
     * and creates the table
     * 
     */
    public LandmarkDB() {
        
        // Load db variables
        try {
            InputStream in = new FileInputStream("db.properties");
            ResourceBundle resources = new PropertyResourceBundle(in);
            in.close();
            
            className = resources.getString("jdbc.driver");
            url = resources.getString("jdbc.url");
            user = resources.getString("jdbc.user");
            password = resources.getString("jdbc.password");
        } catch (IOException exp) {
            System.out.println("Failed to load db.properties file");
            System.exit(-1);
        }
        
        // Load the driver
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load the driver: " + className);
            System.exit(-1);
        }
        
        // Create the table
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            
            stmt.execute("""
                         CREATE TABLE Landmarks (
                            "Landmark ID" int generated always as identity(start with 0, increment by 1),
                            "Name" varchar(255),
                            "Lat" varchar(255),
                            "Lng" varchar(255),
                            "Image" varchar(255),
                            primary key ("Landmark ID")
                         )""");
            
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            // Ignore exceptions indicating the table already exists
            if (!ex.getMessage().contains("already exists")) {
                System.out.println("There was an error creating the 'Landmarks' table!");
                System.exit(-1);
            }
        }
        
    }
    
    /**
     * Pushes a record to the DB
     * 
     * @param name The landmark name
     * @param lat The latitude of the landmark
     * @param lng The longitude of the landmark
     * @param image The path to the image of the landmark
     * @throws SQLException 
     */
    public void createRecord(String name, double lat, double lng, String image) throws SQLException {
        
        Connection con = DriverManager.getConnection(url, user, password);     
        Statement stmt = con.createStatement();
        
        String query = String.format("""
                       INSERT INTO Landmarks
                       (
                         "Name",
                         "Lat",
                         "Lng",
                         "Image"
                       ) VALUES (
                         '%s',
                         '%s',
                         '%s',
                         '%s'
                       )
                       """, name, lat, lng, image);
        
        stmt.execute(query);
        stmt.close();
        con.close();
        
    }
    
    /**
     * Pulls a record from the DB
     * 
     * @param name The landmark name
     * @return null if no records are found or {@link LandmarkRecord}
     * @throws SQLException 
     */
    public LandmarkRecord getRecord(String name) throws SQLException {
        
        Connection con = DriverManager.getConnection(url, user, password);     
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        String query = String.format("""
                                     SELECT * FROM Landmarks
                                     WHERE "Name" = '%s'
                                     """, name);
        
        stmt.execute(query);
        
        ResultSet resultSet = stmt.getResultSet();
        
        // If there are no results
        if (!resultSet.isBeforeFirst()) {
            return null;
        }
        
        resultSet.next();
        
        int id = resultSet.getInt("Landmark ID");
        String realName = resultSet.getString("Name");
        double lat = Double.parseDouble(resultSet.getString("Lat"));
        double lng = Double.parseDouble(resultSet.getString("Lng"));
        String image = resultSet.getString("Image");
        
        LandmarkRecord landmarkRecord = new LandmarkRecord(id, realName, lat, lng, image);
        
        stmt.close();
        con.close();
        
        return landmarkRecord;
        
    }
    
}
