/**
 * Interfaz que define los métodos para operaciones CRUD (Create, Read, Update, Delete)
 * sobre objetos Persona en la base de datos.
 * 
 * Esta interfaz será implementada por la clase PersonaDAO para proporcionar
 * la funcionalidad de acceso a datos.
 */
package data.interfaces;

import model.Persona;
import java.util.List;
 
public interface PersonaInterface {
    
    /**
     * Inserta una nueva persona en la base de datos.
     * 
     * @param obj Persona a insertar
     * @return true si la inserción fue exitosa, false en caso contrario
     */
    public boolean insertar(Persona obj);
    
    /**
     * Obtiene una lista de todas las personas almacenadas en la base de datos.
     * 
     * @return Lista de objetos Persona
     */
    public List<Persona> listar();
    
    /**
     * Busca una persona en la base de datos por su DNI.
     * 
     * @param dni DNI de la persona a buscar
     * @return Objeto Persona encontrado, o null si no se encuentra
     */
    public Persona buscar(String dni);
    
    /**
     * Actualiza la información de una persona existente en la base de datos.
     * 
     * @param obj Persona con la información actualizada
     * @return true si la actualización fue exitosa, false en caso contrario
     */
    public boolean actualizar(Persona obj);
    
    /**
     * Elimina una persona de la base de datos por su DNI.
     * 
     * @param dni DNI de la persona a eliminar
     * @return true si la eliminación fue exitosa, false en caso contrario
     */
    public boolean eliminar(String dni);
    
       
}
