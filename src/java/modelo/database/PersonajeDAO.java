/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.database;

import controlador.util.CaException;
import controlador.util.ServiceLocator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Logica.MagoBlanco;
import modelo.Logica.MagoOscuro;
import modelo.Logica.Personaje;

/**
 *
 * @author diego
 */
public class PersonajeDAO {

    private MagoBlanco magoBlanco;
    private MagoOscuro magoOscuro;

    private ArrayList<Personaje> personajes;

    public PersonajeDAO() {
        magoBlanco = new MagoBlanco();
        magoOscuro = new MagoOscuro();
        personajes = new ArrayList();
    }

    public MagoBlanco getMagoBlanco() {
        return magoBlanco;
    }

    public void setMagoBlanco(MagoBlanco magoBlanco) {
        this.magoBlanco = magoBlanco;
    }

    public MagoOscuro getMagoOscuro() {
        return magoOscuro;
    }

    public void setMagoOscuro(MagoOscuro magoOscuro) {
        this.magoOscuro = magoOscuro;
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    public void incluirPersonajeMagoBlanco() throws CaException {
        try {
            String strSQL = "INSERT INTO Personaje (n_nombrePersonaje, q_vida, q_ataque, q_mana, n_foto, n_estilo) VALUES(?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setString(1, magoBlanco.getNombre());
            prepStmt.setInt(2, magoBlanco.getVida());
            prepStmt.setInt(3, magoBlanco.getAtaque());
            prepStmt.setInt(4, magoBlanco.getMana());
            prepStmt.setString(5, magoBlanco.getFoto());
            prepStmt.setString(6, magoBlanco.getEstilo());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("PersonajeDAO", "No pudo crear el personaje" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void incluirPersonajeMagoOscuro() throws CaException {
        try {
            String strSQL = "INSERT INTO Personaje (n_nombrePersonaje, q_vida, q_ataque, q_mana, n_foto, n_estilo) VALUES(?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setString(1, magoOscuro.getNombre());
            prepStmt.setInt(2, magoOscuro.getVida());
            prepStmt.setInt(3, magoOscuro.getAtaque());
            prepStmt.setInt(4, magoOscuro.getMana());
            prepStmt.setString(5, magoOscuro.getFoto());
            prepStmt.setString(6, magoOscuro.getEstilo());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("PersonajeDAO", "No pudo crear el personaje" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public ArrayList<Personaje> cargarPersonajes() throws CaException {
        try {
            String strSQL = "SELECT k_idPersonaje, n_nombrePersonaje, q_vida, q_ataque, q_mana, n_foto, n_estilo FROM Personaje";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                MagoBlanco personaje1 = new MagoBlanco();
                personaje1.setId(rs.getInt(1));
                personaje1.setNombre(rs.getString(2));
                personaje1.setVida(rs.getInt(3));
                personaje1.setAtaque(rs.getInt(4));
                personaje1.setMana(rs.getInt(5));
                personaje1.setFoto(rs.getString(6));
                personaje1.setEstilo(rs.getString(7));

                personajes.add(personaje1);
            }
        } catch (SQLException e) {
            throw new CaException("PersonajesDAO", "No pudo recuperar el personajes" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return personajes;
    }

    public Personaje buscarPersonaje(int id) throws CaException {
        try {
            String strSQL = "SELECT k_idPersonaje, n_nombrePersonaje, q_vida, q_ataque, q_mana, n_foto, n_estilo FROM Personaje WHERE k_idPersonaje = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, id);

            ResultSet rs = prepStmt.executeQuery();
            rs.next();

            MagoBlanco personaje1 = new MagoBlanco();
            personaje1.setId(rs.getInt(1));
            personaje1.setNombre(rs.getString(2));
            personaje1.setVida(rs.getInt(3));
            personaje1.setAtaque(rs.getInt(4));
            personaje1.setMana(rs.getInt(5));
            personaje1.setFoto(rs.getString(6));
            personaje1.setEstilo(rs.getString(7));

            setMagoBlanco(personaje1);

        } catch (SQLException e) {
            throw new CaException("PersonajesDAO", "No pudo recuperar el personajes" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return magoBlanco;
    }
    public void eliminarPersonaje(int id) throws CaException {
        try {
            String strSQL = "DELETE FROM Personaje WHERE k_idPersonaje = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, id);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            throw new CaException("PersonajeDAO", "No pudo buscar la instancia a Personaje" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

}
