<!--
 * CMPSC 221 Program LandmarkLocator
 * index.jsp
 * Purpose: Web implementation for LandmarkLocator
 * 
 * @version 1.0 Apr 10, 2024
 -->
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>LandmarkLocator</title>
    <style>
        .cenetered-container {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        
        form {
            display: contents;
        }
        
        img {
            height: 12rem;
        }
        
        .imageRadios {
            display: flex;
            flex-direction: row;
            gap: 5px;
        }
        
        .imageRadios label {
            display: flex;
            flex-direction: column;
            justify-content: center;
            gap: 5px;
        }
        
        .imageRadios label input[type="radio"]:checked+img {
            outline: 1px solid blue;
        }
        
        /* Select Styling */
        
        .select-container {
          position: relative;
          display: inline-block;
        }

        .select-container select {
          appearance: none;
          -webkit-appearance: none;
          -moz-appearance: none;
          background-color: transparent;
          border: 1px solid #ccc;
          padding: 6px 20px 6px 8px;
          font-size: 14px;
          border-radius: 4px;
          cursor: pointer;
        }
        
        .select-container::after {
          content: '\25BC';
          position: absolute;
          top: 50%;
          right: 6px;
          transform: translateY(-50%);
          pointer-events: none;
          font-size: 8pt;
        }
        
        .select-container select:focus {
          outline: none;
          border-color: #007bff;
        }
        
        /* Button Styling */

        /* Style the button */
        .custom-button {
          background-color: #007bff;
          color: #fff;
          border: none;
          padding: 6px 8px;
          font-size: 14px;
          border-radius: 4px;
          cursor: pointer;
          transition: background-color 0.3s ease;
        }

        /* Hover effect */
        .custom-button:hover {
          background-color: #0056b3; /* Darker shade of the primary color */
        }

        /* Focus effect */
        .custom-button:focus {
          outline: none;
          box-shadow: 0 0 0 2px rgba(0, 123, 255, 0.5); /* Focus ring */
        }


    </style>
</head>
<body>
<div class="cenetered-container">

    <h2>Select an image for landmark detection!</h2>

    <form action="LandmarkRequestHandler" method="get">
        <div>
            <label for="placeTyoe">
                Search for: 
            </label>
            <div class="select-container">
                <select id="placeType" name="place" required>
                    <%
                        for (String place : com.mycompany.landmarklocator.LandmarkLocator.predefinedPlaces) {
                    %>
                    <option value="<%= place.toUpperCase().replace(" ", "_") %>"><%= place %></option>
                    <% } %>
                </select>
            </div>
        </div>
        <br/>
        <div class="imageRadios">
            <%
                String directory = "images";
                File dir = new File(request.getSession().getServletContext().getRealPath(directory));
                File[] files = dir.listFiles();

                // Iterate through each file and display it as a radio button
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            // Display the image as a radio button
            %>
            <label>
                <input type="radio" name="image" value="<%= file.getName() %>" required>
                <img src="<%= directory + "/" + file.getName() %>" alt="<%= file.getName() %>">
            </label>
            <% 
                        }
                    }
                }
            %>
        </div>
        <br/>
        <input class="custom-button" type="submit" value="Submit">
    </form>
</div>
</body>
</html>
