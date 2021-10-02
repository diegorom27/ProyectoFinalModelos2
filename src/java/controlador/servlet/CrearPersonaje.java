/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servlet;

import java.io.IOException;
import controlador.util.CaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Logica.GestorDAO;
import modelo.Logica.MagoBlanco;
import modelo.Logica.MagoOscuro;
import modelo.Logica.Personaje;
import modelo.Logica.PersonajeFactory;
import modelo.database.PersonajeDAO;

/**
 *
 * @author diego
 */
public class CrearPersonaje extends HttpServlet {

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
            throws ServletException, IOException, CaException{
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession lol = request.getSession();
        
        GestorDAO gestor = new GestorDAO();
        PersonajeFactory factoryP = new PersonajeFactory();
        
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        String estilo = request.getParameter("estilo");
        
        if(tipo.equals("mago blanco")){
            gestor.setMagoBlanco((MagoBlanco) factoryP.getPersonaje(tipo, nombre, estilo));
            //m = (MagoBlanco) factoryP.getPersonaje(tipo, nombre, estilo);  
            gestor.incluirPeronajeMagoBlanco();
        }else{
            gestor.setMagoOscuro((MagoOscuro) factoryP.getPersonaje(tipo, nombre, estilo));
            //m = (MagoOscuro) factoryP.getPersonaje(tipo, nombre, estilo); 
            gestor.incluirPeronajeMagoOscuro();
        }
        response.sendRedirect("index.html");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CrearPersonaje.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CrearPersonaje.class.getName()).log(Level.SEVERE, null, ex);
        }
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
