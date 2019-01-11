package com.reservas.entidades;

/**
 *
 * @author Dayana
 */
public class Laboratorio {
    private int id_laboratorio;
    private String nombre;
    private String descripcion;
    private String usuario_id_usuario;

    public Laboratorio(int id_laboratorio, String nombre, String descripcion, String usuario_id_usuario) {
        this.id_laboratorio = id_laboratorio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuario_id_usuario = usuario_id_usuario;
    }

    public Laboratorio(String nombre, String descripcion, String usuario_id_usuario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuario_id_usuario = usuario_id_usuario;
    }

    public int getId_laboratorio() {
        return id_laboratorio;
    }

    public void setId_laboratorio(int id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuario_id_usuario() {
        return usuario_id_usuario;
    }

    public void setUsuario_id_usuario(String usuario_id_usuario) {
        this.usuario_id_usuario = usuario_id_usuario;
    }
    
}
