/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servlet;

import controlador.util.CaException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Logica.CreadorDeHechizos;
import modelo.Logica.GestorDAO;
import modelo.Logica.HechizoAtaqueBuilder;
import modelo.Logica.HechizoBuilder;
import modelo.Logica.HechizoCuracionBuilder;
import modelo.Logica.HechizoSacrificioBuilder;

/**
 *
 * @author diego
 */
public class CrearHechizo extends HttpServlet {

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
            throws ServletException, IOException, CaException {
        response.setContentType("text/html;charset=UTF-8");
        
        GestorDAO gestor = new GestorDAO(); 
        
        String nombre = request.getParameter("nombre");
        String tipo = request.getParameter("tipo");
        
        CreadorDeHechizos builder = new CreadorDeHechizos();
        switch(tipo){
            case "curacion":
                HechizoCuracionBuilder buidelC = new HechizoCuracionBuilder();
                builder.setHechizoBuilder(buidelC);
            break;
            case "sacrificio":
                HechizoSacrificioBuilder buidelS = new HechizoSacrificioBuilder();
                builder.setHechizoBuilder(buidelS);
            break;
            case "ataque":
                HechizoAtaqueBuilder buidelA = new HechizoAtaqueBuilder();
                builder.setHechizoBuilder(buidelA);
            break;    
        }
        
        builder.construirHechizo();
        builder.nombrarHechizo(nombre);
        
        gestor.setHechizo(builder.getHechizo());
        gestor.incluirHechizo();
        
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
        } catch (CaException ex) {
            Logger.getLogger(CrearHechizo.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (CaException ex) {
            Logger.getLogger(CrearHechizo.class.getName()).log(Level.SEVERE, null, ex);
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
