package com.reservas.adapter;

import com.rerevas.dominio.Conexion;
import com.reservas.entidades.Laboratorio;
import com.reservas.entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dayana
 */
public class ConexionMSQLLab implements Conexion{
    public EstablecerConexion con = new EstablecerConexion();    
    private final String tabla = "laboratorio";
   
    @Override
    public List<Usuario> getDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getDato(String usuario, String contrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertDatos(String cedula, String nombres, String usuario, String contrasenia, int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertDatosLab(String nombre, String descripcion, int usuario_id) {
         try {
             PreparedStatement consulta = con.getConnection().prepareStatement("INSERT INTO "+this.tabla+"(nombre, descripcion, usuario_id_usuario)"
                + "VALUES (?,?,?)");            
            consulta.setString(1, nombre);
            consulta.setString(2, descripcion);
            consulta.setInt(3, usuario_id);                        
        return consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMSQL.class.getName()).log(Level.SEVERE, null, ex);

        }          
        return 0;
    }
}
