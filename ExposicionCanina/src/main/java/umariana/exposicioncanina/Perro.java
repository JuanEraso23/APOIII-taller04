package umariana.exposicioncanina;

/**
 *
 * @author 
 * David Ortiz,
 * Juan Eraso
 */
public class Perro {
    
    //Atributos
    private String nombre;
    private String raza;
    private int edad;
    private int puntos;
    private String foto;
    
    //Constructores
    public Perro() {
    }

    public Perro(String nombre, String raza, int edad, int puntos, String foto) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.puntos = puntos;
        this.foto = foto;
    }
    
    //Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}