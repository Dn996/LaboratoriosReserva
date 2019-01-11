/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rerevas.dominio;

import com.reservas.entidades.Laboratorio;
import com.reservas.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Dayana
 */
public interface Conexion {
    List<Usuario> getDatos();
    public Usuario getDato(String usuario, String contrasenia);
    public int insertDatos(String cedula, String nombres, String usuario, String contrasenia, int tipo);
    
    public int insertDatosLab(String nombre, String descripcion, int usuario_id);
    
    
}
