/**
 * Clase que proporciona servicios para la gestión de personas en el sistema.
 * 
 * Esta clase actúa como una capa intermedia entre la interfaz de usuario y
 * la capa de acceso a datos. Contiene métodos para insertar, mostrar, buscar,
 * actualizar y eliminar personas, así como para determinar la admisión según
 * la facultad y el puntaje.
 */
package service;

import data.PersonaDAO;
import model.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PersonaService {
    
    // Objetos para acceder a los datos y manejar personas
    PersonaDAO datos;
    Persona persona;
    
    // Modelo para la tabla de la interfaz gráfica
    DefaultTableModel modelo;
    
    /**
     * Constructor de la clase PersonaService.
     * Inicializa los objetos necesarios para el funcionamiento del servicio.
     */
    public PersonaService(){
        datos = new PersonaDAO();
        persona = new Persona();
    }
    
    /**
     * Inserta una nueva persona en el sistema.
     * 
     * @param dni Documento Nacional de Identidad de la persona
     * @param puntaje Puntaje obtenido por la persona
     * @param nombre Nombre de la persona
     * @param apellido Apellido de la persona
     * @param facultad Facultad a la que aspira la persona
     * @param admitido Estado de admisión de la persona
     * @return "OK" si la inserción fue exitosa, mensaje de error en caso contrario
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
            return "Ocurrio un error en el registro";
        }
    }
    
    /**
     * Obtiene y formatea los datos de todas las personas para mostrar en una tabla.
     * 
     * @return DefaultTableModel con los datos de las personas
     */
    public DefaultTableModel mostrar(){
        List<Persona> lista = new ArrayList<>();
        
        lista.addAll(datos.listar());
        
        String[] title = {"idPersona", "Dni","Nombre", "Apellido", "Facultad", "Puntaje","Admitido"};
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
     * Busca una persona por su DNI.
     * 
     * @param dni DNI de la persona a buscar
     * @return Objeto Persona encontrado, o null si no se encuentra
     */
    public Persona buscar(String dni){
        persona = datos.buscar(dni);
        return persona;
    }
    
    /**
     * Actualiza la información de una persona existente.
     * 
     * @param persona Persona con la información actualizada
     * @return "OK" si la actualización fue exitosa, mensaje de error en caso contrario
     */
    public String actualizar(Persona persona){
        if (datos.actualizar(persona)) {
            return "OK";
        }else{
            return "Ocurrio un error al actualizar";
        }
    }
    
    /**
     * Elimina una persona del sistema por su DNI.
     * 
     * @param dni DNI de la persona a eliminar
     * @return "OK" si la eliminación fue exitosa, mensaje de error en caso contrario
     */
    public String eliminar(String dni){
        if (datos.eliminar(dni)) {
            return "OK";
        }else{
            return "Ocurrio un error al eliminar";
        }
    }
    
    /**
     * Determina si una persona es admitida según la facultad y el puntaje.
     * 
     * @param facultad Facultad a la que aspira la persona
     * @param puntaje Puntaje obtenido por la persona
     * @return "SI" si es admitido, "NO" si no es admitido
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
            System.out.println("Sede Introducida, incorrecta");
        }    
        
             return adm;

    }
    
    /**
     * Verifica si una persona es admitida en la facultad de Ingeniería según su puntaje.
     * 
     * @param puntaje Puntaje obtenido por la persona
     * @return "SI" si es admitido (puntaje >= 350), "NO" si no es admitido
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
     * Verifica si una persona es admitida en la facultad de Artes según su puntaje.
     * 
     * @param puntaje Puntaje obtenido por la persona
     * @return "SI" si es admitido (puntaje >= 350), "NO" si no es admitido
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
     * Verifica si una persona es admitida en la facultad Tecnológica según su puntaje.
     * 
     * @param puntaje Puntaje obtenido por la persona
     * @return "SI" si es admitido (puntaje >= 280), "NO" si no es admitido
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
     * Verifica si una persona es admitida en la facultad de Medio Ambiente según su puntaje.
     * 
     * @param puntaje Puntaje obtenido por la persona
     * @return "SI" si es admitido (puntaje >= 300), "NO" si no es admitido
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
     * Verifica si una persona es admitida en la facultad de Ciencias según su puntaje.
     * 
     * @param puntaje Puntaje obtenido por la persona
     * @return "SI" si es admitido (puntaje >= 320), "NO" si no es admitido
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
