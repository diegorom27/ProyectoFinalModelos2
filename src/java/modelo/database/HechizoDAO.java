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
import modelo.Logica.Hechizo;

/**
 *
 * @author diego
 */
public class HechizoDAO {

    private Hechizo hechizo;
    private ArrayList<Hechizo> hechizos;

    public HechizoDAO() {
        hechizo = new Hechizo();
        hechizos = new ArrayList();
    }

    public Hechizo getHechizo() {
        return hechizo;
    }

    public void setHechizo(Hechizo hechizo) {
        this.hechizo = hechizo;
    }

    public ArrayList<Hechizo> getHechizos() {
        return hechizos;
    }

    public void setHechizos(ArrayList<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    public void incluirHechizo() throws CaException {
        try {
            String strSQL = "INSERT INTO Hechizo (n_nombre, i_tipo, q_gastoMana, q_sacrificio, q_curacion, q_efectoMultiplicador, q_efecto, n_foto) VALUES(?,?,?,?,?,?,?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setString(1, hechizo.getNombre());
            prepStmt.setString(2, hechizo.getTipo());
            prepStmt.setInt(3, hechizo.getGastoMana());
            prepStmt.setInt(4, hechizo.getSacrificio());
            prepStmt.setInt(5, hechizo.getCuracion());
            prepStmt.setFloat(6, hechizo.getEfectoMultiplicador());
            prepStmt.setInt(7, hechizo.getEfecto());
            prepStmt.setString(8, hechizo.getFoto());
            prepStmt.executeUpdate();
            prepStmt.close();

            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("HechizoDAO", "No pudo crear el hechizo" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public ArrayList<Hechizo> cargarHechizos() throws CaException {
        try {
            String strSQL = "SELECT k_idHechizo, n_nombre, i_tipo, q_gastoMana, q_sacrificio, q_curacion, q_efectoMultiplicador, q_efecto, n_foto FROM Hechizo";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                Hechizo hechizo1 = new Hechizo();
                hechizo1.setId(rs.getInt(1));
                hechizo1.setNombre(rs.getString(2));
                hechizo1.setTipo(rs.getString(3));
                hechizo1.setGastoMana(rs.getInt(4));
                hechizo1.setSacrificio(rs.getInt(5));
                hechizo1.setCuracion(rs.getInt(6));
                hechizo1.setEfectoMultiplicador(rs.getInt(7));
                hechizo1.setEfecto(rs.getInt(8));
                hechizo1.setFoto(rs.getString(9));

                hechizos.add(hechizo1);
            }
        } catch (SQLException e) {
            throw new CaException("HechizoDAO", "No pudo recuperar los hechizos" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return hechizos;
    }

    public ArrayList<Hechizo> joinHechizo(int id) throws CaException {
        try {
            String strSQL = "SELECT h.k_idHechizo, h.n_nombre, i_tipo, q_gastoMana, q_sacrificio, q_curacion, q_efectoMultiplicador, q_efecto, h.n_foto FROM personaje_hechizo ph,Hechizo h, Personaje p WHERE p.k_idPersonaje = ph.k_idPersonaje AND ph.k_idHechizo = h.k_idHechizo AND p.k_idPersonaje = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, id);

            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
                Hechizo hechizo1 = new Hechizo();
                hechizo1.setId(rs.getInt(1));
                hechizo1.setNombre(rs.getString(2));
                hechizo1.setTipo(rs.getString(3));
                hechizo1.setGastoMana(rs.getInt(4));
                hechizo1.setSacrificio(rs.getInt(5));
                hechizo1.setCuracion(rs.getInt(6));
                hechizo1.setEfectoMultiplicador(rs.getInt(7));
                hechizo1.setEfecto(rs.getInt(8));
                hechizo1.setFoto(rs.getString(9));

                hechizos.add(hechizo1);
            }
        } catch (SQLException e) {
            throw new CaException("PersonajesDAO", "No pudo recuperar el personajes" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return hechizos;
    }

    public Hechizo buscarhechizo(int id) throws CaException {
        try {
            String strSQL = "SELECT k_idHechizo, n_nombre, i_tipo, q_gastoMana, q_sacrificio, q_curacion, q_efectoMultiplicador, q_efecto, n_foto FROM Hechizo WHERE k_idHechizo = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, id);

            ResultSet rs = prepStmt.executeQuery();
            rs.next();

            Hechizo hechizo1 = new Hechizo();
            hechizo1.setId(rs.getInt(1));
            hechizo1.setNombre(rs.getString(2));
            hechizo1.setTipo(rs.getString(3));
            hechizo1.setGastoMana(rs.getInt(4));
            hechizo1.setSacrificio(rs.getInt(5));
            hechizo1.setCuracion(rs.getInt(6));
            hechizo1.setEfectoMultiplicador(rs.getInt(7));
            hechizo1.setEfecto(rs.getInt(8));
            hechizo1.setFoto(rs.getString(9));

            setHechizo(hechizo1);

        } catch (SQLException e) {
            throw new CaException("PersonajesDAO", "No pudo recuperar el personajes" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        return hechizo;
    }

}
