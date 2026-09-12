
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Handles the connection to the MySQL database.
 * Implements the Singleton pattern to ensure a single database connection.
 */
public class DatabaseConnection {
    
   // Database connection parameters
   private static final String HOST="localhost";
   
   private static final String PUERTO ="3306";
   
   private static final String DB = "crudPersona";
   
   private static final String USER = "root";
   
   private static final String PASSWORD = "Carlonitos02";
   
   private static String url;
   
   // Database connection object
   private static Connection conexion = null;
    
   /**
    * Returns a connection to the database.
    * If there is no active connection or it is closed, a new one is created.
    * 
    * @return Connection database connection object
    */
   public static Connection getConexion() {
       // If there is no connection or the connection is closed, create a new one
       try {
           if (conexion == null || conexion.isClosed()) {
               // Load the MySQL driver
               Class.forName("com.mysql.cj.jdbc.Driver");
               
               // Build the connection URL
               url = "jdbc:mysql://" + HOST + ":" + PUERTO + "/" + DB + 
                     "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
               
               // Establish the connection to the database
               conexion = DriverManager.getConnection(url, USER, PASSWORD);
               System.out.println("Connection established successfully");
           }
       } catch (ClassNotFoundException e) {
           System.out.println("Error: MySQL driver not found");
           e.printStackTrace();
       } catch (SQLException e) {
           System.out.println("Error: Could not connect to the database");
           System.out.println("URL: " + url);
           System.out.println("User: " + USER);
           e.printStackTrace();
       } catch (Exception e) {
           System.out.println("Unknown error while establishing the connection");
           e.printStackTrace();
       }
       
       return conexion;
   }
   
   /**
    * Closes the database connection if it is open.
    */
   public static void cerrarConexion() {
       try {
           if (conexion != null && !conexion.isClosed()) {
               conexion.close();
               System.out.println("Connection closed successfully");
           }
       } catch (SQLException e) {
           System.out.println("Error closing the connection");
           e.printStackTrace();
       }
   }
   
   // Method to verify the connection
   /*
   public static void main(String[]args)
   {
     if (getConexion()!=null)  
      {
         System.out.println("successful connection");
      
      } 
    
    } */      
   
}
