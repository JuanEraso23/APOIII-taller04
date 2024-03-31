package umariana.exposicioncanina;

/**
 *
 * @author 
 * David Ortiz, 
 * Juan Eraso
 */
public class NombreDuplicadoException extends Exception {
    
    public NombreDuplicadoException(){
        super("Ya existe un perro con ese nombre, intentelo nuevamente");
    }
}
