/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Logica;

import controlador.util.CaException;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.database.HechizoDAO;
import modelo.database.PersonajeDAO;
import modelo.database.Personaje_HechizoDAO;

/**
 *
 * @author diego
 */
public class GestorDAO {
    
    private PersonajeDAO personajeDAO = new PersonajeDAO();
    private HechizoDAO hechizoDAO = new HechizoDAO();
    private Personaje_HechizoDAO personaje_HechizoDAO = new Personaje_HechizoDAO();
    
    public GestorDAO() {
        personajeDAO = new PersonajeDAO();
        hechizoDAO = new HechizoDAO();
        personaje_HechizoDAO = new Personaje_HechizoDAO();
    }
    
    public void incluirPeronajeMagoBlanco() throws CaException {
      personajeDAO.incluirPersonajeMagoBlanco();
    }
    public void incluirPeronajeMagoOscuro() throws CaException {
      personajeDAO.incluirPersonajeMagoOscuro();
    }
    public void incluirHechizo() throws CaException {
      hechizoDAO.incluirHechizo();
    }
    public void incluirPersonaje_Hechizo() throws CaException {
      personaje_HechizoDAO.incluirPersonaje_Hechizo();
    }
    
    
    public MagoBlanco getMagoBlanco() {
        return personajeDAO.getMagoBlanco();
    }
    public MagoOscuro getMagoOscuro() {
        return personajeDAO.getMagoOscuro();
    }
    public Hechizo getHechizo(){
        return hechizoDAO.getHechizo();
    }
    public Hechizo getPersonaje_Hechizo1() {
        return personaje_HechizoDAO.getHechizo();
    }
    public MagoBlanco getPersonaje_Hechizo2() {
        return personaje_HechizoDAO.getMb();
    }
    
    
    
    public void setMagoOscuro(MagoOscuro magoOscuro){
        personajeDAO.setMagoOscuro(magoOscuro);
    }
    public void setMagoBlanco(MagoBlanco magoBlanco){
        personajeDAO.setMagoBlanco(magoBlanco);
    }
    public void setHechizo(Hechizo hechizo){
        hechizoDAO.setHechizo(hechizo);
    }
    
    public ArrayList<Personaje> cargarPersonajes() throws CaException{
        return personajeDAO.cargarPersonajes();
    }
    public ArrayList<Hechizo> cargarHechizos() throws CaException{
        return hechizoDAO.cargarHechizos();
    }
    
    public boolean verificar() throws CaException{
        return personaje_HechizoDAO.verificar();
    }
    
    public Personaje buscarPersonaje(int id) throws CaException{
        return personajeDAO.buscarPersonaje(id);
    }
    public Hechizo buscarHechizo(int id) throws CaException{
        return hechizoDAO.buscarhechizo(id);
    }
    
    public ArrayList<Hechizo> joinHechizo(int id) throws CaException{
        return hechizoDAO.joinHechizo(id);
    }
    public void EliminarPersonaje_Hechizo(int id) throws CaException{
        personaje_HechizoDAO.EliminarPersonaje_Hechizo(id);
    }
    public void EliminarPersonaje(int id) throws CaException{
        personajeDAO.eliminarPersonaje(id);
    }
}
