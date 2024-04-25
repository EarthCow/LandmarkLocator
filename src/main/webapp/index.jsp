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
        <option value="RESTAURANT" selected>Restaurant</option>
        <option value="CAFE">Cafe</option>
        <option value="AMUSEMENT_PARK">Amusement Park</option>
        <option value="AQUARIUM">Aquarium</option>
        <option value="BOWLING_ALLEY">Bowling Alley</option>
        <option value="CASINO">Casino</option>
        <option value="CULTURAL_CENTER">Cultural Center</option>
        <option value="DOG_PARK">Dog Park</option>
        <option value="HIKING_AREA">Hiking Area</option>
        <option value="HISTORICAL_LANDMARK">Historical Landmark</option>
        <option value="MARINA">Marina</option>
        <option value="MOVIE_THEATER">Movie Theater</option>
        <option value="NATIONAL_PARK">National Park</option>
        <option value="NIGHT_CLUB">Night Club</option>
        <option value="PARK">Park</option>
        <option value="TOURIST_ATTRACTION">Tourist Attraction</option>
        <option value="VISITOR_CENTER">Visitor Center</option>
        <option value="ZOO">Zoo</option>
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
            <input type="radio" name="image" value="<%= directory + "/" + file.getName() %>" required>
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
