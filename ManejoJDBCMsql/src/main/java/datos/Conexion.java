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
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cursoJava?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    
    public static Connection getConnection() throws SQLException
    {
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
