/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reservas.adapter;

import com.rerevas.dominio.Conexion;
import com.reservas.entidades.Laboratorio;
import com.reservas.entidades.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Dayana
 */
public class ConexionMSQL implements Conexion {
    
    public EstablecerConexion con = new EstablecerConexion();
    
    private final String tabla = "usuario";

    @Override
    public List<Usuario> getDatos() {
            List<Usuario> usuario = new ArrayList<>();
      try{          
         PreparedStatement consulta = con.getConnection().prepareStatement("SELECT Id_usuario, cedula, nombres, usuario, contrasenia, tipo FROM " + this.tabla);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            usuario.add(new Usuario(resultado.getInt("Id_usuario"), resultado.getString("cedula"), resultado.getString("nombres"), resultado.getString("usuario"), resultado.getString("contrasenia"), resultado.getInt("tipo")));
         }
      }catch(SQLException ex){           
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionMSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
           
      } 
        for (int i = 0; i < usuario.size(); i++) {
            System.out.println("usuario: "+ usuario.get(i).getCedula());
        }
      return usuario;    
    }

    @Override
    public Usuario getDato(String usuario, String contrasenia) {
        Usuario usuarioRegistrado = new Usuario();
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT usuario, contrasenia, tipo FROM "+this.tabla+" WHERE usuario = '" +usuario+"' AND contrasenia = '"+contrasenia+"'" );
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
            usuarioRegistrado = new Usuario(resultado.getString("usuario"), resultado.getString("contrasenia"), resultado.getInt("tipo"));
         }
        } catch (SQLException ex) {
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionMSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } 
        return usuarioRegistrado;    
    }

    @Override
    public int insertDatos(String cedula, String nombres, String usuario, String contrasenia, int tipo){               
        try {
             PreparedStatement consulta = con.getConnection().prepareStatement("INSERT INTO "+this.tabla+"(cedula, nombres, usuario, contrasenia, tipo)"
                + "VALUES (?,?,?,?,?)");            
            consulta.setString(1, cedula);
            consulta.setString(2, nombres);
            consulta.setString(3, usuario);
            consulta.setString(4, contrasenia);            
            consulta.setInt(5, tipo);
        return consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMSQL.class.getName()).log(Level.SEVERE, null, ex);

        }          
        return 0;
    }

    @Override
    public int insertDatosLab(String nombre, String descripcion, int usuario_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
