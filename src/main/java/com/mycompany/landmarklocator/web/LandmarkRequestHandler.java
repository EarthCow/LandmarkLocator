
package com.mycompany.landmarklocator.web;

import com.google.maps.model.PlaceType;
import com.mycompany.landmarklocator.LandmarkLocator;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * CMPSC 221 Program LandmarkLocator
 * LandmarkRequestHandler.java
 * Purpose: Handles requests for landmark information via the web implementation
 * 
 * @version 1.0 Apr 10, 2024
 */
public class LandmarkRequestHandler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String imagePath = request.getParameter("image");
            String place = request.getParameter("place");
            
            PlaceType placeType;
            try {
                placeType = PlaceType.valueOf(place);
            } catch (IllegalArgumentException ex) {
                // If the provided PlaceType is invalid send them back.
                response.sendRedirect("./index.html?invalid");
                return;
            }
            
            LandmarkLocator landmark = new LandmarkLocator();

            // set Order object in request object
            request.setAttribute("landmark", landmark);

            // Forward request and response objects
            getServletContext()
                .getRequestDispatcher("/result.jsp")
                .forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
