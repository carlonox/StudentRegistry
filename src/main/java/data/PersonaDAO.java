/**
 * Clase que implementa la interfaz PersonaInterface para realizar operaciones
 * CRUD (Create, Read, Update, Delete) en la base de datos para objetos Persona.
 * 
 * Esta clase se encarga de la interacción directa con la base de datos MySQL
 * utilizando prepared statements para prevenir inyecciones SQL.
 */
package data;

import data.interfaces.PersonaInterface;
import model.Persona;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class PersonaDAO implements PersonaInterface {

    // Objetos para ejecutar sentencias SQL y manejar resultados
    PreparedStatement ps;
    ResultSet rs;
    
    
    /**
     * Inserta una nueva persona en la base de datos.
     * 
     * @param obj Persona a insertar
     * @return true si la inserción fue exitosa, false en caso contrario
     */
    @Override
    public boolean insertar(Persona obj) {
        
        boolean resp = false;
        
        try{
           // Sentencia SQL para insertar una nueva persona
           String sql = "insert into persona(dni, nombre, apellido, facultad, puntaje, admitido) values(?,?,?,?,?,?)";
            
           ps = DatabaseConnection.getConexion().prepareStatement(sql);
           ps.setString(1,obj.getDni());
           ps.setString(2,obj.getNombre());
           ps.setString(3,obj.getApellido());
           ps.setString(4,obj.getFacultadAspirada());
           ps.setInt(5,obj.getPuntaje());
           ps.setString(6,obj.getAdmitido());
           
           // Ejecutar la inserción y verificar si fue exitosa
           if(ps.executeUpdate()>0)
           {
               resp=true;
           }
           ps.close();
           DatabaseConnection.cerrarConexion();
        }
        
        catch(Exception e){ System.out.println(e.getMessage());}
        
        return resp;
        
        
        
    }

    /**
     * Obtiene una lista de todas las personas almacenadas en la base de datos.
     * 
     * @return Lista de objetos Persona
     */
    @Override
    public List<Persona> listar() {
        
        List<Persona> registros = new ArrayList<>();
        
        try
        {
            
           // Consulta SQL para obtener todas las personas
           String consulta="select * from persona";
           ps = DatabaseConnection.getConexion().prepareStatement(consulta);
            
           rs = ps.executeQuery();
           
           // Recorrer los resultados y crear objetos Persona
           while (rs.next())
           {
               int idPersona = rs.getInt(1);
               String dni = rs.getString(2);
               String nombre = rs.getString(3);
               String apellido = rs.getString(4);
               String facultad = rs.getString(5);
               int puntaje = rs.getInt(6);
               String admitido = rs.getString(7);
               

               registros.add(new Persona(idPersona, dni, nombre, apellido, facultad,puntaje, admitido));
           }
           
           rs.close();
           ps.close();
           DatabaseConnection.cerrarConexion();
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return registros;
        
    }

    /**
     * Busca una persona en la base de datos por su DNI.
     * 
     * @param dniPersona DNI de la persona a buscar
     * @return Objeto Persona encontrado, o null si no se encuentra
     */
    @Override
    public Persona buscar(String dniPersona) {
        
        Persona persona = null;
        
        try
        {
            // Consulta SQL para buscar una persona por DNI
            String consulta = "select * from persona where dni = ?";
            
            ps= DatabaseConnection.getConexion().prepareStatement(consulta);
            ps.setString(1, dniPersona);
            rs = ps.executeQuery();
            
            // Si se encuentra la persona, crear el objeto Persona
            if(rs.next())
            {
                
               int idPersona = rs.getInt(1);
               String dni = rs.getString(2);
               String nombre = rs.getString(3);
               String apellido = rs.getString(4);
               String facultad = rs.getString(5);
               int puntaje = rs.getInt(6);
               String admitido = rs.getString(7);
              
               persona = new Persona(idPersona,dni,nombre,apellido,facultad,puntaje,admitido);
            }
            
            rs.close();
            ps.close();
            DatabaseConnection.cerrarConexion();
            
                    
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            
        }
        
        return persona;
        
    }

    /**
     * Actualiza la información de una persona existente en la base de datos.
     * 
     * @param obj Persona con la información actualizada
     * @return true si la actualización fue exitosa, false en caso contrario
     */
    @Override
    public boolean actualizar(Persona obj) {
        
        boolean resp = false;
        
        try{
            // Sentencia SQL para actualizar una persona existente
            String update = "update persona set dni =?, nombre =?, apellido = ?, facultad = ?, puntaje = ? where idPersona = ?";
            
            ps = DatabaseConnection.getConexion().prepareStatement(update);
            ps.setString(1, obj.getDni());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getApellido());
            ps.setString(4, obj.getFacultadAspirada());
            ps.setInt(5, obj.getPuntaje());
            ps.setInt(6, obj.getIdPersona());
            
            // Ejecutar la actualización y verificar si fue exitosa
            if (ps.executeUpdate()>0) 
            {
                resp = true;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return resp;
        
        
        
    }

    /**
     * Elimina una persona de la base de datos por su DNI.
     * 
     * @param dni DNI de la persona a eliminar
     * @return true si la eliminación fue exitosa, false en caso contrario
     */
    @Override
    public boolean eliminar(String dni) {
        
       boolean resp = false;
        
        try {
            // Sentencia SQL para eliminar una persona por DNI
            String delete = "delete from persona where dni = ?";
            ps = DatabaseConnection.getConexion().prepareStatement(delete);
            ps.setString(1, dni);
            
            
            // Ejecutar la eliminación y verificar si fue exitosa
            if (ps.executeUpdate()>0) {
                resp = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return resp;
        
        
    }

    
    
    
}
