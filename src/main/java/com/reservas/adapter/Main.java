package com.reservas.adapter;

import com.rerevas.dominio.Conexion;
import com.reservas.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dayana
 */
public class Main {
    public static void main(String[] args) {
        Conexion conexion = new ConexionMSQL();
        Conexion conexion1 = new ConexionMSQLLab();
        Usuario usuario = new Usuario();
        String usuario1;
        String usuarioEn;
        String contrasenia;
        String cedula;
        String nombres;
        String nombre_lab;
        String descripcion;
        int id_us_lab;
        
        int tipo;
        int opcion;
        Scanner teclado = new Scanner(System.in);
        
        
        
        
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = conexion.getDatos();
        
        usuario.presentarResult(usuarios);
        
        System.out.println("Ingrese usuario y contraseña");
        System.out.println("usuario: ");        
        usuario1 = teclado.next();
        
        System.out.println("contraseña: ");        
        contrasenia = teclado.next();        
        
        
        usuario = conexion.getDato(usuario1, contrasenia);
        
        if (usuario.ResultGetId(usuario, usuario1, contrasenia)) {            
            switch (usuario.getTipo()) {
                case 0:
                    System.out.println("Seleccione una opción: ");
                    
                    System.out.println("1. Registrar personal");
                    System.out.println("2. Registrar laboratorio");
                    opcion = teclado.nextInt();                    
                    switch (opcion){
                        case 1:
                            System.out.println("Ingrese el número de cédula");
                            cedula = teclado.next();
                            System.out.println("Ingrese los nombres");
                            teclado.nextLine();
                            nombres = teclado.nextLine();
                            System.out.println("Ingrese el usuario");
                            usuarioEn = teclado.next();
                            System.out.println("Ingrese la contraseña");
                            contrasenia = teclado.next();
                            tipo = 2;
                            if (conexion.insertDatos(cedula, nombres, usuario1, contrasenia, tipo)>=1) {
                                System.out.println("Datos guardados correctamente");
                            }else{
                                System.out.println("Datos no registrados");
                            }
                            break;
                        case 2:
                            System.out.println("Ingrese el nombre");
                            nombre_lab = teclado.next();
                            System.out.println("Ingrese descripcion");
                            descripcion = teclado.next();
                            System.out.println("Ingrese el encargado");
                            id_us_lab = teclado.nextInt();
                            if (conexion1.insertDatosLab(nombre_lab, descripcion, id_us_lab)>=1) {
                                System.out.println("Datos guardados correctamente");
                            }else{
                                System.out.println("Datos no registrados");
                            }
                            break;
                            
                    }
                    
                    break;
                case 1:
                    System.out.println("Registre una reserva");
                    break;
                case 2:
                    System.out.println("Valide una reserva");
                    break;
                default:
                    break;
            }
            
            
        }

        
        
        
        
    }
    
}
