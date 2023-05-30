package datos;

import domain.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafa
 */
public class PersonaJDBC {

    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, email=?, telefono=? WHERE id_persona=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";

    private final String COLUMN_ID_PERSONA = "id_persona";
    private final String COLUMN_NOMBRE = "nombre";
    private final String COLUMN_APELLIDO = "apellido";
    private final String COLUMN_EMAIL = "email";
    private final String COLUMN_TELEFONO = "telefono";

    public List<Persona> select() {
        String nombre;
        String apellido;
        String email;
        String telefono;
        Persona persona = null;
        List<Persona> personas = new ArrayList<Persona>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id_persona = rs.getInt(COLUMN_ID_PERSONA);
                nombre = rs.getString(COLUMN_NOMBRE);
                apellido = rs.getString(COLUMN_APELLIDO);
                email = rs.getString(COLUMN_EMAIL);
                telefono = rs.getString(COLUMN_TELEFONO);

                persona = new Persona();
                persona.setIdPersona(id_persona);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setEmail(email);
                persona.setTelefono(telefono);
                
                personas.add(persona);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return personas;
    }
    
    
    public int insert(Persona persona) {
        
        Connection conn = null;
        PreparedStatement ps = null;

        int rows=0;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getEmail());
            ps.setString(4, persona.getTelefono());
            
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
    
    public int update(Persona persona) {
        
        Connection conn = null;
        PreparedStatement ps = null;

        int rows=0;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getEmail());
            ps.setString(4, persona.getTelefono());
            ps.setInt(5, persona.getIdPersona());
            
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
    
    public int delete(int idPersona) {
        
        Connection conn = null;
        PreparedStatement ps = null;

        int rows=0;

        try {
            conn = Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            
            ps.setInt(1, idPersona);
            
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
