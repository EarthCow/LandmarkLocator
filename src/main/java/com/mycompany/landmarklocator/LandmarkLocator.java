
package com.mycompany.landmarklocator;

import java.io.IOException;

/**
 * CMPSC 221 Program LandmarkLocator
 * LandmarkLocator.java
 * Purpose: Main class for LandmarkLocator
 * 
 * @version 1.0 Apr 10, 2024
 * @author Ryan W & Griffin G
 */
public class LandmarkLocator {

    /**
     * Initializes the program
     * @param args Strings passed to the artifact when ran
     */
    public static void main(String[] args) {
        System.out.println("Attempting!");
        try {
            Demo.detectLandmarks();
        } catch (IOException ex) {
            System.out.println("Failed :(");
            ex.printStackTrace();
        }
    }
}