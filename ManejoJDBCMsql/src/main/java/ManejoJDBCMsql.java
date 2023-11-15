
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author Rafael Bolaños Herrera
 * @fecha 14-nov-2023
 */
public class ManejoJDBCMsql {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/curso_java?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "ralfs.8310";
        
    public static void main(String[] args) {
        
        System.out.println("Manejando JDBC Ralfs!\n");
        
        try{
            
            Connection conexion = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            
            Statement instruccion = conexion.createStatement();
            
            var sql = "select id_persona, nombre, apellido, email, telefono from persona";
            
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while(resultado.next()){
                System.out.println("Id persona: " + resultado.getInt("id_persona"));
                System.out.println("Id persona: " + resultado.getString("nombre"));
                System.out.println("Id persona: " + resultado.getString("apellido"));
                System.out.println("Id persona: " + resultado.getString("email"));
                System.out.println("Id persona: " + resultado.getString("telefono"));
            }
            
            resultado.close();
            instruccion.close();
            conexion.close();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace(System.out);
        }
        finally{
            
        }
    
    }
}
