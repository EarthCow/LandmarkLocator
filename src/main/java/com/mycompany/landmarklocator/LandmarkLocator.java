
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
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.protobuf.ByteString;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CMPSC 221 Program LandmarkLocator
 * LandmarkLocator.java
 * Purpose: Utility for the Google Vision API
 * 
 * @version 1.0 Apr 10, 2024
 * 
 */
public class LandmarkLocator {
    
    public static List<Landmark> getLandmarks(String filePath, PlaceType placeType) throws IOException{
        List<Landmark> landmarks = new ArrayList();
        
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
                    return null;
                }

                for (EntityAnnotation annotation : res.getLandmarkAnnotationsList()) {
                    LocationInfo info = annotation.getLocationsList().listIterator().next();

                    System.out.format("Landmark: %s%n %s%n", annotation.getDescription(), info.getLatLng());

                    // Begin the places search
                    GeoApiContext context = new GeoApiContext.Builder()
                        .apiKey("AIzaSyC26kOz1q-7JdipmEP8b--dcnYGomYr63E")
                        .build();
                    LatLng mapsLatLng = new LatLng(info.getLatLng().getLatitude(), info.getLatLng().getLongitude());
                    NearbySearchRequest nsr = PlacesApi.nearbySearchQuery(context, mapsLatLng);

                    try {
                        PlacesSearchResponse psr = nsr.radius(500).type(placeType).await();
                        System.out.println("Found a total of " + psr.results.length + " results!");
                        landmarks.add(new Landmark(annotation, info, psr));
                    } catch (ApiException | IOException | InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        return landmarks;
    }

}