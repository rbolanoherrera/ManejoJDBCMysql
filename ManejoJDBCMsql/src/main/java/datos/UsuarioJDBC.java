/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafa
 */
public class UsuarioJDBC {
    
    private static final String SQL_SELECT = "SELECT id_usuario, nombre, password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario (nombre, password) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET nombre=?, password=? WHERE id_usuario=?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario=?";

    private final String COLUMN_ID_USUARIO = "id_usuario";
    private final String COLUMN_NOMBRE = "nombre";
    private final String COLUMN_PASSWORD = "password";


    public List<Usuario> select() {
        
        int idPersona;
        String nombre;
        String password;
        
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                idPersona = rs.getInt(COLUMN_ID_USUARIO);
                nombre = rs.getString(COLUMN_NOMBRE);
                password = rs.getString(COLUMN_PASSWORD);

                usuario = new Usuario();
                usuario.setIdUsuario(idPersona);
                usuario.setNombre(nombre);
                usuario.setPassword(password);
                
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return usuarios;
    }
    
    
    public int insert(Usuario usuario) {
        
        Connection conn = null;
        PreparedStatement ps = null;

        int rows=0;

        try {
            
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getPassword());
            
            System.out.println("ejecutando query: " + SQL_INSERT);
            
            rows = ps.executeUpdate();
            
            System.out.println("registros Insertados: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{

            Conexion.close(ps);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public int update(Usuario usuario) {
        
        Connection conn = null;
        PreparedStatement ps = null;

        int rows=0;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getPassword());
            ps.setInt(5, usuario.getIdUsuario());
            
            System.out.println("ejecutando query: " + SQL_UPDATE);
            
            rows = ps.executeUpdate();
            
            System.out.println("registros afectados: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{

            Conexion.close(ps);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public int delete(int idUsuario) {
        
        Connection conn = null;
        PreparedStatement ps = null;

        int rows=0;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            
            ps.setInt(1, idUsuario);
            
            System.out.println("ejecutando query: " + SQL_DELETE);
            
            rows = ps.executeUpdate();
            
            System.out.println("registros afectados: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{

            Conexion.close(ps);
            Conexion.close(conn);
        }

        return rows;
    }
    
}
