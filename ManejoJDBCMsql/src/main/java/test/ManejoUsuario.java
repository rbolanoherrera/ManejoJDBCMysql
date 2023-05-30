/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.UsuarioJDBC;
import domain.Usuario;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Rafa
 */
public class ManejoUsuario {
    
    public static void main(String[] args) 
    {
        
        UsuarioJDBC usuarioData = new UsuarioJDBC();
        
        /*Usuario usuario=new Usuario();
        usuario.setNombre("ralfs");
        usuario.setPassword("ralfs.8310");
        usuarioData.insert(usuario);
        */
        
        var usuarios = usuarioData.select();
        
        System.out.println("Listando los Usuarios: ");
        
        for(Usuario item: usuarios)
        {
            System.out.println("item: " + item);
        }
        
    }
    
}
