/**
 * Interface that defines the methods for CRUD (Create, Read, Update, Delete)
 * operations on Persona objects in the database.
 * 
 * This interface is implemented by the PersonaDAO class to provide
 * the data access functionality.
 */
package data.interfaces;

import model.Persona;
import java.util.List;
 
public interface PersonaInterface {
    
    /**
     * Inserts a new person into the database.
     * 
     * @param obj Persona to insert
     * @return true if the insertion was successful, false otherwise
     */
    public boolean insertar(Persona obj);
    
    /**
     * Returns a list of all the people stored in the database.
     * 
     * @return List of Persona objects
     */
    public List<Persona> listar();
    
    /**
     * Looks up a person in the database by DNI.
     * 
     * @param dni DNI of the person to look up
     * @return Persona object found, or null if not found
     */
    public Persona buscar(String dni);
    
    /**
     * Updates the information of an existing person in the database.
     * 
     * @param obj Persona with the updated information
     * @return true if the update was successful, false otherwise
     */
    public boolean actualizar(Persona obj);
    
    /**
     * Deletes a person from the database by DNI.
     * 
     * @param dni DNI of the person to delete
     * @return true if the deletion was successful, false otherwise
     */
    public boolean eliminar(String dni);
    
       
}
