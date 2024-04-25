
package com.mycompany.landmarklocator;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.LocationInfo;
import com.google.maps.GeoApiContext;
import com.google.maps.NearbySearchRequest;
import com.google.maps.PlacesApi;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
import com.google.protobuf.ByteString;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CMPSC 221 Program LandmarkLocator
 * Landmark.java
 * Purpose: Demo for the Google Vision API
 * 
 * @version 1.0 Apr 10, 2024
 * 
 */
public class Landmark {
    
    private static ArrayList<String> description = new ArrayList<String>();;
    private static ArrayList<String> location = new ArrayList<String>();;
  
    private static ArrayList<String> places = new ArrayList<String>();
    private static ArrayList<Float> ratings = new ArrayList<Float>();

    public static ArrayList<String> getDescription() {
        return description;
    }

    public static ArrayList<String> getLocation() {
        return location;
    }
    
    public static ArrayList<String> getPlaces() {
        return places;
    }

    public static ArrayList<Float> getRatings() {
        return ratings;
    }
    
    public static void getPlaces(String filePath, PlaceType placetosearch) throws IOException{
        List<AnnotateImageRequest> requests = new ArrayList<>();
        ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.LANDMARK_DETECTION).build();
        AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

    
        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.format("Error: %s%n", res.getError().getMessage());
                    return;
                }

            // For full list of available annotations, see http://g.co/cloud/vision/docs
            for (EntityAnnotation annotation : res.getLandmarkAnnotationsList()) {
            LocationInfo info = annotation.getLocationsList().listIterator().next();
          
            System.out.format("Landmark: %s%n %s%n", annotation.getDescription(), info.getLatLng());
            description.add(annotation.getDescription());
            location.add(info.getLatLng().toString());
          
            GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyC26kOz1q-7JdipmEP8b--dcnYGomYr63E")
                .build();
            LatLng mapsLatLng = new LatLng(info.getLatLng().getLatitude(), info.getLatLng().getLongitude());
            NearbySearchRequest nsr = PlacesApi.nearbySearchQuery(context, mapsLatLng);
            
            try {
                PlacesSearchResponse psr = nsr.radius(500).type(placetosearch).await();
                System.out.println("Found a total of " + psr.results.length + " results!");
                for (PlacesSearchResult result : psr.results) {
                    places.add(result.name);
                    ratings.add(result.rating);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }
            }//end for
        }//end try catch
    }//end getLandmark


}//end class