
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que gestiona la conexión a la base de datos MySQL.
 * Implementa el patrón Singleton para asegurar una única conexión a la base de datos.
 */
public class DatabaseConnection {
    
   // Parámetros de conexión a la base de datos
   private static final String HOST="localhost";
   
   private static final String PUERTO ="3306";
   
   private static final String DB = "crudPersona";
   
   private static final String USER = "root";
   
   private static final String PASSWORD = "Carlonitos02";
   
   private static String url;
   
   // Objeto de conexión a la base de datos
   private static Connection conexion = null;
    
   /**
    * Obtiene una conexión a la base de datos.
    * Si no existe una conexión activa o está cerrada, crea una nueva.
    * 
    * @return Connection objeto de conexión a la base de datos
    */
   public static Connection getConexion() {
       // Si no hay conexión o la conexión está cerrada, crear una nueva
       try {
           if (conexion == null || conexion.isClosed()) {
               // Cargar el driver de MySQL
               Class.forName("com.mysql.cj.jdbc.Driver");
               
               // Construir la URL de conexión
               url = "jdbc:mysql://" + HOST + ":" + PUERTO + "/" + DB + 
                     "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
               
               // Establecer la conexión con la base de datos
               conexion = DriverManager.getConnection(url, USER, PASSWORD);
               System.out.println("Conexión establecida correctamente");
           }
       } catch (ClassNotFoundException e) {
           System.out.println("Error: No se encontró el driver de MySQL");
           e.printStackTrace();
       } catch (SQLException e) {
           System.out.println("Error: No se pudo establecer la conexión con la base de datos");
           System.out.println("URL: " + url);
           System.out.println("Usuario: " + USER);
           e.printStackTrace();
       } catch (Exception e) {
           System.out.println("Error desconocido al establecer la conexión");
           e.printStackTrace();
       }
       
       return conexion;
   }
   
   /**
    * Cierra la conexión a la base de datos si está abierta.
    */
   public static void cerrarConexion() {
       try {
           if (conexion != null && !conexion.isClosed()) {
               conexion.close();
               System.out.println("Conexión cerrada correctamente");
           }
       } catch (SQLException e) {
           System.out.println("Error al cerrar la conexión");
           e.printStackTrace();
       }
   }
   
   //Metodo para verificar conexion
   /*
   public static void main(String[]args)
   {
     if (getConexion()!=null)  
      {
         System.out.println("conexion exitosa");
       
      } 
     
    } */      
   
}
