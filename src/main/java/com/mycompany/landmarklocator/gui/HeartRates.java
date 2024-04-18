/**
 * CMPSC 221 Program #2
 * HeartRates.java
 * Purpose: Provides methods to calculate different heart rates
 * 
 * @version 1.0 01/21/24
 * @author Griffin G.
 */

package com.mycompany.landmarklocator.gui;

import java.time.LocalDate;
import java.time.Period;

public class HeartRates {
    
    private String firstName;
    private String lastName;
    private int dobMonth;
    private int dobDay;
    private int dobYear;
    
    /**
     * Provides methods related to that of calculating heart rates
     * 
     * @param firstName The first name
     * @param lastName  The last name
     * @param dobMonth  The date of birth month
     * @param dobDay    The date of birth day
     * @param dobYear   The date of birth year
     */
    public HeartRates(String firstName, String lastName, int dobMonth, int dobDay, int dobYear) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.dobMonth = dobMonth;
        this.dobDay = dobDay;
        this.dobYear = dobYear;
        
    }
    
    // Getters

    /**
     * Gets the first name
     * 
     * @return The first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name
     * 
     * @return The last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the dob month
     * 
     * @return The dob month
     */
    public int getDobMonth() {
        return dobMonth;
    }

    /**
     * Gets the dob day
     * 
     * @return The dob day
     */
    public int getDobDay() {
        return dobDay;
    }

    /**
     * Gets the dob year
     * 
     * @return The dob year
     */
    public int getDobYear() {
        return dobYear;
    }
    
    // Setters

    /**
     * Sets the first name
     * 
     * @param firstName The first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name
     * 
     * @param lastName The last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the dob month
     * 
     * @param dobMonth The dob month (!-12)
     */
    public void setDobMonth(int dobMonth) {
        this.dobMonth = dobMonth;
    }

    /**
     * Sets the dob day
     * 
     * @param dobDay The dob day to set (1-31)
     */
    public void setDobDay(int dobDay) {
        this.dobDay = dobDay;
    }

    /**
     * Sets the dob year
     * 
     * @param dobYear The dob year
     */
    public void setDobYear(int dobYear) {
        this.dobYear = dobYear;
    }
    
    /**
     * Calculates the person's current age as an integer of years
     * 
     * @return Age in years
     */
    public int calcAge() {
        
        LocalDate birthDate = LocalDate.of(dobYear, dobMonth, dobDay);

        Period period = Period.between(birthDate, LocalDate.now());

        int age = period.getYears();
        
        return age;
        
    }
    
    /**
     * Calculates the person's maximum heart rate
     * 
     * @return Maximum heart rate
     */
    public int calcMaxHeartRate() {
        
        int maxHeartRate = 220 - calcAge();
        
        return maxHeartRate;
        
    }
    
    /**
     * Calculates the person's target heart rate range
     * 
     * @return The range as a string: "lower - upper"
     */
    public String calcTargetHeartRateRange() {
        
        int maxHeartRate = calcMaxHeartRate();
        
        double lowerRange = maxHeartRate * 0.5;
        
        double upperRange = maxHeartRate * 0.85;
        
        return lowerRange + " - " + upperRange;
        
    }
    
}
