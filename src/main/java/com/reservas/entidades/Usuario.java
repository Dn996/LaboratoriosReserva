package com.reservas.entidades;

import java.util.List;

/**
 *
 * @author Dayana
 */
public class Usuario {
    private int id_usuario;
    private String cedula;
    private String nombres;
    private String usuario;
    private String contrasenia;
    private int tipo;
    
    public Usuario() {
    }

    public Usuario(String usuario, String contrasenia, int tipo) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
    }

    public Usuario(int id_usuario, String cedula, String nombres, String usuario, String contrasenia, int tipo) {
        this.id_usuario = id_usuario;
        this.cedula = cedula;
        this.nombres = nombres;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void presentarResult(List<Usuario> usuarios) {        
         for (int i = 0; i < usuarios.size(); i++) {
            System.out.println("datos base: [id_usuario: " + usuarios.get(i).getId_usuario()+ "], "
                    + "[cedula: "+usuarios.get(i).getCedula()+"], "
                    + "[nombres: "+usuarios.get(i).getNombres()+"]"
                    + "[usuario: "+usuarios.get(i).getUsuario()+"]"
                    + "[contraseña: "+usuarios.get(i).getContrasenia()+"]"
                    + "[tipo: "+usuarios.get(i).getTipo()+"]");
        }
    }
    
    public boolean ResultGetId(Usuario usuarios, String usuario, String contrasenia) { 
        boolean correct;
        System.out.println("*****"+usuarios.getUsuario()+"************");
        
        if (usuarios.getUsuario().equals(usuario) || usuarios.getContrasenia().equals(contrasenia)) {
            System.out.println("credenciales correctas");
            correct = true;
        }else{
            System.out.println("credenciales incorrectas");
            correct = false;
        }
        return correct;
    }
   
}
