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
    </style>
</head>
<body>

<h2>Select an Image</h2>

<form action="LandmarkRequestHandler" method="get">
    <select name="place" required>
        <%
            for (String place : com.mycompany.landmarklocator.LandmarkLocator.predefinedPlaces) {
        %>
        <option value="<%= place.toUpperCase().replace(" ", "_") %>"><%= place %></option>
        <% } %>
    </select>
    <br/>
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
    <input type="submit" value="Submit">
</form>

</body>
</html>
