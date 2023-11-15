/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafa
 */
public class Conexion {
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/curso_java?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "ralfs.8310";
    
    public static Connection getConnection() throws SQLException
    {
        try{
            //Esto de pronto es requerido en aplicaciones Web
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace(System.out);
        }
        
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    public static void close(ResultSet rs)
    {
        try {
            
            rs.close();
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt)
    {
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn)
    {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
