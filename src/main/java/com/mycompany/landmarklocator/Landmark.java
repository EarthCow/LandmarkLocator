
package com.mycompany.landmarklocator;

import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.LocationInfo;
import com.google.maps.model.PlacesSearchResponse;
import java.io.Serializable;

/**
 * CMPSC 221 Program com.mycompany.landmarklocator
 * Landmark.java
 * Purpose: Java bean returned when detecting a landmark containing all relevant information
 * 
 * @version 1.0 Apr 25, 2024
 */
public class Landmark implements Serializable {
    
    private EntityAnnotation annotation;
    private LocationInfo locationInfo;
    private PlacesSearchResponse placesResponse;
    
    public Landmark(EntityAnnotation annotation, LocationInfo locationInfo, PlacesSearchResponse placesResponse) {
        this.annotation = annotation;
        this.locationInfo = locationInfo;
        this.placesResponse = placesResponse;
    }

    public EntityAnnotation getAnnotation() {
        return annotation;
    }

    public LocationInfo getLocationInfo() {
        return locationInfo;
    }

    public PlacesSearchResponse getPlacesResponse() {
        return placesResponse;
    }

    public void setAnnotation(EntityAnnotation annotation) {
        this.annotation = annotation;
    }

    public void setLocationInfo(LocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }

    public void setPlacesResponse(PlacesSearchResponse placesResponse) {
        this.placesResponse = placesResponse;
    }
    
}
