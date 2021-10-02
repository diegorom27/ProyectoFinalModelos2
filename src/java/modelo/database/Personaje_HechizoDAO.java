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
import modelo.Logica.Hechizo;
import modelo.Logica.MagoBlanco;

/**
 *
 * @author diego
 */
public class Personaje_HechizoDAO {
    
    MagoBlanco mb;
    Hechizo hechizo;
    boolean resp;

    public Personaje_HechizoDAO() {
        mb = new MagoBlanco();
        hechizo = new Hechizo();
    }

    public MagoBlanco getMb() {
        return mb;
    }

    public void setMb(MagoBlanco mb) {
        this.mb = mb;
    }

    public Hechizo getHechizo() {
        return hechizo;
    }

    public void setHechizo(Hechizo hechizo) {
        this.hechizo = hechizo;
    }
    public void incluirPersonaje_Hechizo() throws CaException {
        try {
            String strSQL = "INSERT INTO Personaje_Hechizo (k_idPersonaje, k_idHechizo) VALUES(?,?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, mb.getId());
            prepStmt.setInt(2, hechizo.getId());;
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            throw new CaException("Personaje_HechizoDAO", "No pudo añadir instancia a Personaje_Hechizo" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    public boolean verificar() throws CaException {
        try {
            String strSQL = "SELECT EXISTS(SELECT k_idPersonaje, k_idHechizo FROM Personaje_Hechizo WHERE k_idPersonaje = ? AND k_idHechizo = ?)";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, mb.getId());
            prepStmt.setInt(2, hechizo.getId());
            ResultSet rs = prepStmt.executeQuery();
            rs.next();
            resp = rs.getBoolean(1);

        } catch (SQLException e) {
            throw new CaException("Personaje_HechizoDAO", "No pudo buscar la instancia a Personaje_Hechizo" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

        return resp;
    }
    public void EliminarPersonaje_Hechizo(int id) throws CaException {
        try {
            String strSQL = "DELETE FROM Personaje_Hechizo WHERE k_idPersonaje=? ";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, id);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            throw new CaException("Personaje_HechizoDAO", "No pudo buscar la instancia a Personaje_Hechizo" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    
}
