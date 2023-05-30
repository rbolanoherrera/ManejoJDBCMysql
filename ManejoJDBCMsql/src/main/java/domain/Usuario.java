/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Rafa
 */
public class Usuario {
    
    private int idUsuario;
    private String nombre;
    private String password;

    
    public Usuario()
    {
        
    }

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int id) {
        this.idUsuario = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario: {" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", password=" + password + '}';
    }
    
}
