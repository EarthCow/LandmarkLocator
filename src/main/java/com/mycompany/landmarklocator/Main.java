
package com.mycompany.landmarklocator;

import com.mycompany.landmarklocator.db.LandmarkDB;

/**
 * CMPSC 221 Program LandmarkLocator
 * Main.java
 * Purpose: Main class for LandmarkLocator
 * 
 * @version 1.0 Apr 10, 2024
 * @author Ryan W & Griffin G
 */
public class Main {
    
    // LandmarkDB instance that should always be used
    public static final LandmarkDB landmarkDB = new LandmarkDB();
    

    /**
     * Initializes the program
     * @param args Strings passed to the artifact when ran
     */
    public static void main(String[] args) {
        try{
            landmarkDB.createRecord("cathedral", "src/main/resources/Images/cathedral.jpg");
            landmarkDB.createRecord("old main", "src/main/resources/Images/college_building.jpg");
            landmarkDB.createRecord("opera house", "src/main/resources/Images/opera.jpg");
            landmarkDB.createRecord("moai heads", "src/main/resources/Images/realmoai.jpg");
            landmarkDB.createRecord("tall tower", "src/main/resources/Images/realtower.jpg");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
}