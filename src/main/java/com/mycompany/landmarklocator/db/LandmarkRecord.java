
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
    public final double lat;
    public final double lng;
    public final String image;
    
    public LandmarkRecord(int id, String name, double lat, double lng, String image) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.image = image;
    }
    
}
