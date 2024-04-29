
package com.mycompany.landmarklocator.db;

/**
 * CMPSC 221 Program LandmarkLocator
 * LandmarkRecord.java
 * Purpose: Stores a fetched record from the DB
 * 
 * @version 1.0 Apr 21, 2024
 */
public class LandmarkRecord {
    
    // immutable values and therefore can be public
    public final int id;
    public final String name;
    public final String filePath;
    
    public LandmarkRecord(int id, String name, String filePath) {
        this.id = id;
        this.name = name;
        this.filePath = filePath;
    }

    
    
    
}
