/**
 * Class that provides services for managing people in the system.
 * 
 * This class acts as an intermediate layer between the user interface and
 * the data access layer. It contains methods to insert, display, look up,
 * update, and delete people, as well as to determine admission based on
 * faculty and score.
 */
package service;

import data.PersonaDAO;
import model.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PersonaService {
    
    // Objects for accessing the data and managing people
    PersonaDAO datos;
    Persona persona;
    
    // Model for the table in the graphical interface
    DefaultTableModel modelo;
    
    /**
     * Constructor of the PersonaService class.
     * Initializes the objects required for the service to work.
     */
    public PersonaService(){
        datos = new PersonaDAO();
        persona = new Persona();
    }
    
    /**
     * Inserts a new person into the system.
     * 
     * @param dni National identity document number of the person
     * @param puntaje Score obtained by the person
     * @param nombre First name of the person
     * @param apellido Last name of the person
     * @param facultad Faculty the person is applying to
     * @param admitido Admission status of the person
     * @return "OK" if the insertion was successful, an error message otherwise
     */
    public String insertar(String dni,int puntaje, String nombre, String apellido, String facultad,String admitido){
        
        persona.setDni(dni);
        persona.setPuntaje(puntaje);
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setFacultadAspirada(facultad);
        persona.setAdmitido(admitido);
        
        
        
        if (datos.insertar(persona)) {
            return "OK";
        }else{
            return "An error occurred while saving the record";
        }
    }
    
    /**
     * Retrieves and formats the data of all people for display in a table.
     * 
     * @return DefaultTableModel with the people's data
     */
    public DefaultTableModel mostrar(){
        List<Persona> lista = new ArrayList<>();
        
        lista.addAll(datos.listar());
        
        String[] title = {"idPersona", "DNI","First name", "Last name", "Faculty", "Score","Admitted"};
        modelo = new DefaultTableModel(null, title);
        
        String[] registro = new String[7];
        
        for (Persona item : lista) {
            registro[0] = Integer.toString(item.getIdPersona());
            registro[1] = item.getDni();
            registro[2] = item.getNombre();
            registro[3] = item.getApellido();
            registro[4] = item.getFacultadAspirada();
            registro[5] = Integer.toString(item.getPuntaje());
            registro[6] = item.getAdmitido();
            
            modelo.addRow(registro);
        }
        
        return modelo;
        
    }
    
    /**
     * Looks up a person by DNI.
     * 
     * @param dni DNI of the person to look up
     * @return Persona object found, or null if not found
     */
    public Persona buscar(String dni){
        persona = datos.buscar(dni);
        return persona;
    }
    
    /**
     * Updates the information of an existing person.
     * 
     * @param persona Persona with the updated information
     * @return "OK" if the update was successful, an error message otherwise
     */
    public String actualizar(Persona persona){
        if (datos.actualizar(persona)) {
            return "OK";
        }else{
            return "An error occurred while updating the record";
        }
    }
    
    /**
     * Deletes a person from the system by DNI.
     * 
     * @param dni DNI of the person to delete
     * @return "OK" if the deletion was successful, an error message otherwise
     */
    public String eliminar(String dni){
        if (datos.eliminar(dni)) {
            return "OK";
        }else{
            return "An error occurred while deleting the record";
        }
    }
    
    /**
     * Determines whether a person is admitted based on faculty and score.
     * 
     * @param facultad Faculty the person is applying to
     * @param puntaje Score obtained by the person
     * @return "SI" if admitted, "NO" otherwise
     */
    public String SelectorFacultad(String facultad,int puntaje)
    {
        String adm = "";
        
        

        switch(facultad){
        case "Ingenieria":
            adm = VerificadorIngenieria(puntaje);
            
            break;

        case "Artes":
            adm = VerificadorArtes(puntaje);
            break;

        case "Tecnologica":
            adm = VerificadorTecnologica(puntaje);
            break;

        case "Medio_Ambiente":
            adm = VerificadorMedioAmbiente(puntaje);
            break;

        case "Ciencias":
            adm = VerificadorCiencias(puntaje);
            break; 


           
        default: 
            System.out.println("Invalid faculty entered");
        }    
        
             return adm;

    }
    
    /**
     * Checks whether a person is admitted to the Ingenieria faculty based on their score.
     * 
     * @param puntaje Score obtained by the person
     * @return "SI" if admitted (score >= 350), "NO" otherwise
     */
    public static String VerificadorIngenieria(int puntaje)
    {   
        String estado;
        if(puntaje < 350)
        {
            estado= "NO";
        }
        else
        {
            estado= "SI";
        }
        return estado;
       
        
    }
    
    /**
     * Checks whether a person is admitted to the Artes faculty based on their score.
     * 
     * @param puntaje Score obtained by the person
     * @return "SI" if admitted (score >= 350), "NO" otherwise
     */
    public static String VerificadorArtes(int puntaje)
    {String estado;
        if(puntaje < 350)
        {
            estado= "NO";
        }
        else
        {
            estado= "SI";
        }
        return estado;
    }
    
    /**
     * Checks whether a person is admitted to the Tecnologica faculty based on their score.
     * 
     * @param puntaje Score obtained by the person
     * @return "SI" if admitted (score >= 280), "NO" otherwise
     */
    public static String VerificadorTecnologica(int puntaje)
    {String estado;
        if(puntaje < 280)
        {
            estado= "NO";
        }
        else
        {
            estado= "SI";
        }
        return estado;
    }
    
    /**
     * Checks whether a person is admitted to the Medio Ambiente faculty based on their score.
     * 
     * @param puntaje Score obtained by the person
     * @return "SI" if admitted (score >= 300), "NO" otherwise
     */
    public static String VerificadorMedioAmbiente(int puntaje)
    {String estado;
        if(puntaje < 300)
        {
            estado= "NO";
        }
        else
        {
            estado= "SI";
        }
        return estado;
    }
    
    /**
     * Checks whether a person is admitted to the Ciencias faculty based on their score.
     * 
     * @param puntaje Score obtained by the person
     * @return "SI" if admitted (score >= 320), "NO" otherwise
     */
    public static String VerificadorCiencias(int puntaje)
    {String estado;
        if(puntaje < 320)
        {
            estado= "NO";
        }
        else
        {
            estado= "SI";
        }
        return estado;
    }
   
}
