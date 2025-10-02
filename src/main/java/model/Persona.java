/**
 * Clase que representa una Persona en el sistema.
 * 
 * Esta clase es un modelo de datos que contiene la información de una persona
 * y proporciona métodos para acceder y modificar dicha información.
 * Incluye atributos como identificación, nombre, apellido, facultad aspirada,
 * puntaje y estado de admisión.
 */
package model;


public class Persona {
    // Atributos de la clase Persona
    private int idPersona;
    private String facultadAspirada;
    private String nombre;
    private String apellido;
    private int puntaje;
    private String admitido;
    private String dni;
    
    /**
     * Constructor por defecto de la clase Persona.
     */
    public Persona() {
    }
    
    /**
     * Constructor parametrizado de la clase Persona.
     * 
     * @param idPersona Identificador único de la persona
     * @param dni Documento Nacional de Identidad de la persona
     * @param nombre Nombre de la persona
     * @param apellido Apellido de la persona
     * @param facultad Facultad a la que aspira la persona
     * @param puntaje Puntaje obtenido por la persona
     * @param admitido Estado de admisión de la persona
     */
    public Persona(int idPersona, String dni, String nombre, String apellido, String  facultad,int puntaje, String admitido) {
        this.idPersona = idPersona;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.facultadAspirada = facultad;
        this.admitido = admitido;
    }
    
    /**
     * Establece el estado de admisión de la persona.
     * 
     * @param admitido Estado de admisión (por ejemplo, "Sí" o "No")
     */
    public void setAdmitido(String admitido)
    {
        this.admitido = admitido;
    }
    
    /**
     * Obtiene el estado de admisión de la persona.
     * 
     * @return Estado de admisión de la persona
     */
    public String getAdmitido()
    {
        return admitido;
    }
    
    /**
     * Obtiene el DNI de la persona.
     * 
     * @return DNI de la persona
     */
     public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI de la persona.
     * 
     * @param dni Documento Nacional de Identidad de la persona
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    /**
     * Establece el identificador de la persona.
     * 
     * @param idPersona Identificador único de la persona
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    
    /**
     * Obtiene el identificador de la persona.
     * 
     * @return Identificador único de la persona
     */
    public int getIdPersona() {
        return idPersona;
    }
    
    /**
     * Obtiene el puntaje de la persona.
     * 
     * @return Puntaje obtenido por la persona
     */
    public int getPuntaje()
    {
        return puntaje;
    }
    
    /**
     * Establece el puntaje de la persona.
     * 
     * @param puntaje Puntaje obtenido por la persona
     */
    public void setPuntaje(int puntaje)
    {
        this.puntaje = puntaje;
    }


    /**
     * Obtiene la facultad a la que aspira la persona.
     * 
     * @return Facultad aspirada por la persona
     */
    public String getFacultadAspirada()
    {
        return facultadAspirada;
    }
    
    /**
     * Establece la facultad a la que aspira la persona.
     * 
     * @param facultadAspirada Facultad a la que aspira la persona
     */
    public void setFacultadAspirada(String facultadAspirada)
    {
        this.facultadAspirada = facultadAspirada;
    }
    
    /**
     * Obtiene el nombre de la persona.
     * 
     * @return Nombre de la persona
     */
    public String getNombre()
    {
        return nombre;

    }
    
    /**
     * Establece el nombre de la persona.
     * 
     * @param nombre Nombre de la persona
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;

    }
    
    /**
     * Obtiene el apellido de la persona.
     * 
     * @return Apellido de la persona
     */
    public String getApellido()
    {
        return apellido;
    
    }
    
    /**
     * Establece el apellido de la persona.
     * 
     * @param apellido Apellido de la persona
     */
    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }
}
