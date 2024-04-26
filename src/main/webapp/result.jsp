<!--
 * CMPSC 221 Program LandmarkLocator
 * result.jsp
 * Purpose: Web implementation for LandmarkLocator
 * 
 * @version 1.0 Apr 10, 2024
 -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Landmark Detection Results</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
        }
        .landmark {
            background-color: #fff;
            border-radius: 5px;
            padding: 15px;
            margin-bottom: 20px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        .landmark h2 {
            color: #333;
            margin-top: 0;
        }
        .landmark p {
            margin: 5px 0;
        }
        .places {
            margin-top: 10px;
        }
        .places h3 {
            margin-top: 0;
        }
        .places ul {
            list-style-type: none;
            padding: 0;
        }
        .places li {
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Landmark Detection Results</h1>
        <%@ page import="java.util.List, com.mycompany.landmarklocator.Landmark" %>
        <% List<Landmark> landmarks = (List<Landmark>) request.getAttribute("landmarks");
            if (landmarks != null && !landmarks.isEmpty()) {
                for (Landmark landmark : landmarks) {
        %>
        <div class="landmark">
            <h2><%= landmark.getAnnotation().getDescription() %></h2>
            <p><strong>Location:</strong> <%= landmark.getLocationInfo().getLatLng() %></p>
            <div class="places">
                <h3>Nearby Places:</h3>
                <ul>
                    <%@
                    page import="com.google.maps.model.PlacesSearchResponse, com.google.maps.model.PlacesSearchResult" %>
                    <% PlacesSearchResponse placesResponse = landmark.getPlacesResponse();
                    PlacesSearchResult[] results = placesResponse.results;
                    if (results != null && results.length > 0) {
                        for (PlacesSearchResult result : results) {
                    %>
                    <li><%= result.name %></li>
                    <% } } else { %>
                    <li>No nearby places found.</li>
                    <% } %>
                </ul>
            </div>
        </div>
        <% } } else { %>
        <p>No landmarks found.</p>
        <% } %>
        <a href="index.jsp">Back to search</a>
    </div>
</body>
</html>
