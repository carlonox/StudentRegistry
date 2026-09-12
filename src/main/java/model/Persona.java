/**
 * Class that represents a Person in the system.
 * 
 * This class is a data model that holds a person's information
 * and provides methods to access and modify that information.
 * It includes attributes such as identification, first name, last name,
 * target faculty, score, and admission status.
 */
package model;


public class Persona {
    // Attributes of the Persona class
    private int idPersona;
    private String facultadAspirada;
    private String nombre;
    private String apellido;
    private int puntaje;
    private String admitido;
    private String dni;
    
    /**
     * Default constructor of the Persona class.
     */
    public Persona() {
    }
    
    /**
     * Parameterized constructor of the Persona class.
     * 
     * @param idPersona Unique identifier of the person
     * @param dni National identity document number of the person
     * @param nombre First name of the person
     * @param apellido Last name of the person
     * @param facultad Faculty the person is applying to
     * @param puntaje Score obtained by the person
     * @param admitido Admission status of the person
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
     * Sets the admission status of the person.
     * 
     * @param admitido Admission status (for example, "SI" or "NO")
     */
    public void setAdmitido(String admitido)
    {
        this.admitido = admitido;
    }
    
    /**
     * Returns the admission status of the person.
     * 
     * @return Admission status of the person
     */
    public String getAdmitido()
    {
        return admitido;
    }
    
    /**
     * Returns the DNI of the person.
     * 
     * @return DNI of the person
     */
     public String getDni() {
        return dni;
    }

    /**
     * Sets the DNI of the person.
     * 
     * @param dni National identity document number of the person
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    /**
     * Sets the identifier of the person.
     * 
     * @param idPersona Unique identifier of the person
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    
    /**
     * Returns the identifier of the person.
     * 
     * @return Unique identifier of the person
     */
    public int getIdPersona() {
        return idPersona;
    }
    
    /**
     * Returns the score of the person.
     * 
     * @return Score obtained by the person
     */
    public int getPuntaje()
    {
        return puntaje;
    }
    
    /**
     * Sets the score of the person.
     * 
     * @param puntaje Score obtained by the person
     */
    public void setPuntaje(int puntaje)
    {
        this.puntaje = puntaje;
    }


    /**
     * Returns the faculty the person is applying to.
     * 
     * @return Faculty the person is applying to
     */
    public String getFacultadAspirada()
    {
        return facultadAspirada;
    }
    
    /**
     * Sets the faculty the person is applying to.
     * 
     * @param facultadAspirada Faculty the person is applying to
     */
    public void setFacultadAspirada(String facultadAspirada)
    {
        this.facultadAspirada = facultadAspirada;
    }
    
    /**
     * Returns the first name of the person.
     * 
     * @return First name of the person
     */
    public String getNombre()
    {
        return nombre;

    }
    
    /**
     * Sets the first name of the person.
     * 
     * @param nombre First name of the person
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;

    }
    
    /**
     * Returns the last name of the person.
     * 
     * @return Last name of the person
     */
    public String getApellido()
    {
        return apellido;
    
    }
    
    /**
     * Sets the last name of the person.
     * 
     * @param apellido Last name of the person
     */
    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }
}
