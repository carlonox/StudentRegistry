/**
 * Class that implements the PersonaInterface with CRUD
 * (Create, Read, Update, Delete) operations on Persona objects in the database.
 * 
 * This class handles direct interaction with the MySQL database
 * using prepared statements to prevent SQL injection.
 */
package data;

import data.interfaces.PersonaInterface;
import model.Persona;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class PersonaDAO implements PersonaInterface {

    // Objects for running SQL statements and handling results
    PreparedStatement ps;
    ResultSet rs;
    
    
    /**
     * Inserts a new person into the database.
     * 
     * @param obj Persona to insert
     * @return true if the insertion was successful, false otherwise
     */
    @Override
    public boolean insertar(Persona obj) {
        
        boolean resp = false;
        
        try{
           // SQL statement to insert a new person
           String sql = "insert into persona(dni, nombre, apellido, facultad, puntaje, admitido) values(?,?,?,?,?,?)";
            
           ps = DatabaseConnection.getConexion().prepareStatement(sql);
           ps.setString(1,obj.getDni());
           ps.setString(2,obj.getNombre());
           ps.setString(3,obj.getApellido());
           ps.setString(4,obj.getFacultadAspirada());
           ps.setInt(5,obj.getPuntaje());
           ps.setString(6,obj.getAdmitido());
           
           // Run the insertion and check whether it was successful
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
     * Returns a list of all the people stored in the database.
     * 
     * @return List of Persona objects
     */
    @Override
    public List<Persona> listar() {
        
        List<Persona> registros = new ArrayList<>();
        
        try
        {
            
           // SQL query to retrieve all people
           String consulta="select * from persona";
           ps = DatabaseConnection.getConexion().prepareStatement(consulta);
            
           rs = ps.executeQuery();
           
           // Iterate over the results and build Persona objects
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
     * Looks up a person in the database by DNI.
     * 
     * @param dniPersona DNI of the person to look up
     * @return Persona object found, or null if not found
     */
    @Override
    public Persona buscar(String dniPersona) {
        
        Persona persona = null;
        
        try
        {
            // SQL query to look up a person by DNI
            String consulta = "select * from persona where dni = ?";
            
            ps= DatabaseConnection.getConexion().prepareStatement(consulta);
            ps.setString(1, dniPersona);
            rs = ps.executeQuery();
            
            // If the person is found, build the Persona object
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
     * Updates the information of an existing person in the database.
     * 
     * @param obj Persona with the updated information
     * @return true if the update was successful, false otherwise
     */
    @Override
    public boolean actualizar(Persona obj) {
        
        boolean resp = false;
        
        try{
            // SQL statement to update an existing person
            String update = "update persona set dni =?, nombre =?, apellido = ?, facultad = ?, puntaje = ? where idPersona = ?";
            
            ps = DatabaseConnection.getConexion().prepareStatement(update);
            ps.setString(1, obj.getDni());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getApellido());
            ps.setString(4, obj.getFacultadAspirada());
            ps.setInt(5, obj.getPuntaje());
            ps.setInt(6, obj.getIdPersona());
            
            // Run the update and check whether it was successful
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
     * Deletes a person from the database by DNI.
     * 
     * @param dni DNI of the person to delete
     * @return true if the deletion was successful, false otherwise
     */
    @Override
    public boolean eliminar(String dni) {
        
       boolean resp = false;
        
        try {
            // SQL statement to delete a person by DNI
            String delete = "delete from persona where dni = ?";
            ps = DatabaseConnection.getConexion().prepareStatement(delete);
            ps.setString(1, dni);
            
            
            // Run the deletion and check whether it was successful
            if (ps.executeUpdate()>0) {
                resp = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return resp;
        
        
    }

    
    
    
}
