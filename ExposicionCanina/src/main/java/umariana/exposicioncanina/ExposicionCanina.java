package umariana.exposicioncanina;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 
 * David Ortiz, 
 * Juan Eraso
 */
public class ExposicionCanina {
    
    ArrayList<Perro>misPerros =new ArrayList<>();
    Scanner lector=new Scanner (System.in);
    
    public static void main(String[] args) {
        
        ExposicionCanina exposicion = new ExposicionCanina();
        exposicion.mostrarMenu();
    }
    
    //Métodos     
    public void mostrarMenu(){
        boolean activo=true;
        
        do{
            
            System.out.println("======= Menu de opciones =======");
            System.out.println("1. Agregar perro");
            System.out.println("2. Mostrar perros");
            System.out.println("3. Modificar perro");
            System.out.println("4. Eliminar perro");
            System.out.println("5. Mostrar perro ganador");
            System.out.println("6. Mostrar perro con menor puntaje");
            System.out.println("7. Mostrar perro con mayor edad");
            System.out.println("8. Salir");
            System.out.println("----------------------------------");
           
            int opcion = lector.nextInt();
            switch (opcion){

                case 1:
                    try{
                        agregarPerro();
                    }catch (NombreDuplicadoException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    mostrarPerros();
                    break;

                case 3:
                    modificarInfoPerro();
                    break;

                case 4:
                    eliminarPerro();
                    break;

                case 5:
                    mostrarPerroMayorPuntaje();
                    break;

                case 6:
                    mostrarPerroMenorPuntaje();
                    break;

                case 7:
                    mostrarPerroMayorEdad();
                    break;

                case 8:
                    activo = false;
                    System.out.println("Hasta Pronto...");
                    break;

                default:
                    System.out.println("Opción no válida, inténtelo nuevamente");
            }   
        } while(activo);     
    }
    
    public void agregarPerro() throws NombreDuplicadoException {
        
        //Nombre
        System.out.println("Ingrese el nombre del perro:");
        lector.nextLine(); String nombre = lector.nextLine();
    
        if(!misPerros.isEmpty()){
            for(Perro p: misPerros){
                if(p.getNombre().equalsIgnoreCase(nombre)){
                    throw new NombreDuplicadoException ();
                }
            }
        }
       
        //Raza
        System.out.println("Ingrese la raza");
        String raza = lector.nextLine();

        //Edad
        System.out.println("Ingrese la edad");
        while (!lector.hasNextInt()) {
            System.out.println("La edad debe ser un número entero. Inténtelo de nuevo:");
            lector.nextLine();
        }

        int edad = lector.nextInt();
        //Consumir el salto de línea pendiente
        lector.nextLine();

        //Foto
        System.out.println("Ingrese la foto");
        String foto = lector.nextLine();

        //Puntos
        System.out.println("Ingrese los puntos");
        while (!lector.hasNextInt()) {
            System.out.println("Los puntos deben ser un número entero. Inténtelo de nuevo:");
            lector.nextLine();
        }
        int puntos = lector.nextInt();

       //Creacion del objeto y llenar la información
       Perro nuevoPerro=new Perro(nombre, raza, edad, puntos, foto);
       //ALMACENAR EL OBJETO EN LA CONTENEDORA
       misPerros.add(nuevoPerro); 
   }
    
    //Minimenú
    public void mostrarPerros (){
        
        if (misPerros.isEmpty()) {
            System.out.println("No se han ingresado perros al sistema.");
            return;
        } else {
            System.out.println("----------------------------------");
            System.out.println("1. Mostrar perros registrados.");
            System.out.println("2. Mostrar perros por raza.");
            System.out.println("3. Mostrar perros por puntos.");
            System.out.println("4. Mostrar perros por edad.");
            System.out.println("----------------------------------");

            int option = lector.nextInt();
            switch (option){

                case 1:
                    //Mostrar perros registrados
                    for(Perro p: misPerros) {  
                        System.out.println("Nombre: "+p.getNombre());
                        System.out.println("Foto: "+p.getFoto());
                        System.out.println("Raza: "+p.getRaza());
                        System.out.println("Edad: "+p.getEdad());
                        System.out.println("Puntos: "+p.getPuntos());
                        System.out.println("----------------------------------");
                    }
                    break;

                case 2:
                    //Mostrar perros ordenados por raza
                    mostrarPerrosPorRaza();
                    break;

                case 3:
                    //Ordenar perros por puntos
                    for (int i = 0; i < misPerros.size() - 1; i++) {
                        for (int j = i + 1; j < misPerros.size(); j++) {
                            Perro p1 = misPerros.get(i);
                            Perro p2 = misPerros.get(j);
                            if (p1.getPuntos() < p2.getPuntos()) {
                                // Intercambiar perro
                                Perro temp = p1;
                                misPerros.set(i, p2);
                                misPerros.set(j, temp);
                            }
                        }
                    }

                    //Mostrar perros ordenados por puntos
                    System.out.println("Perros ordenados por puntos:");
                    for (Perro p : misPerros) {
                        System.out.println("Nombre: " + p.getNombre());
                        System.out.println("Foto: " + p.getFoto());
                        System.out.println("Raza: " + p.getRaza());
                        System.out.println("Edad: " + p.getEdad());
                        System.out.println("Puntos: " + p.getPuntos());
                        System.out.println("----------------------------------");   
                    }
                    break;
                    
                case 4:
                    //Ordenar perros por edad
                    for (int i = 0; i < misPerros.size() - 1; i++) {
                        for (int j = i + 1; j < misPerros.size(); j++) {
                            Perro p1 = misPerros.get(i);
                            Perro p2 = misPerros.get(j);
                            if (p1.getEdad() < p2.getEdad()) {
                                // Intercambiar perro
                                Perro temp = p1;
                                misPerros.set(i, p2);
                                misPerros.set(j, temp);
                            }
                        }
                    }

                    //Mostrar perros ordenados por edad
                    System.out.println("Perros ordenados por edad:");
                    for (Perro p: misPerros) {
                        System.out.println("Nombre: " + p.getNombre());
                        System.out.println("Foto: " + p.getFoto());
                        System.out.println("Raza: " + p.getRaza());
                        System.out.println("Edad: " + p.getEdad());
                        System.out.println("Puntos: " + p.getPuntos());
                        System.out.println("----------------------------------");
                    }
                    break;

                default:
                    System.out.println("Opción no válida, inténtelo nuevamente");
            }    
        }
    }
    
    public void mostrarPerrosPorRaza() {
        
        if (!misPerros.isEmpty()) {
            // Ordenar perros por raza
            for (int i = 0; i < misPerros.size() - 1; i++) {           
                for (int j = i + 1; j < misPerros.size(); j++) {           
                    Perro p1 = misPerros.get(i);          
                    Perro p2 = misPerros.get(j); 
                    if (p1.getRaza().compareTo(p2.getRaza()) > 0) {// Intercambiar perros
                        Perro temp = p1;               
                        misPerros.set(i, p2);
                        misPerros.set(j, temp);
                    }
                }
            }
    
            // Mostrar perros ordenados por raza
            System.out.println("Perros ordenados por raza:");        
            for (Perro p: misPerros) {      
                System.out.println("Nombre: " + p.getNombre());
                System.out.println("Foto: " + p.getFoto());
                System.out.println("Raza: " + p.getRaza());
                System.out.println("Edad: " + p.getEdad());
                System.out.println("Puntos: " + p.getPuntos());
                System.out.println("----------------------------------");
            }
        } else {    
            System.out.println("No se han ingresado perros al sistema.");
        }       
    }
    
    public void modificarInfoPerro() {
        
        if (misPerros.isEmpty()) {
            System.out.println("No se han ingresado perros al sistema.");
            return;
        } else {
            System.out.println("Introduzca el nombre del perro que desea modificar:");
            Scanner scanner = new Scanner(System.in);
            String nombre = scanner.nextLine();

            Perro perroEncontrado = null;
            for (Perro p: misPerros) {
                if (p.getNombre().equals(nombre)) {
                    perroEncontrado = p;
                    break;
                }
            }

            if (perroEncontrado == null) {
                System.out.println("No se encontró ningún perro con el nombre " + nombre);
                return;
            }

            System.out.println("Introduzca la nueva raza:");
            String nuevaRaza = scanner.nextLine();
            perroEncontrado.setRaza(nuevaRaza);

            System.out.println("Introduzca la nueva edad:");
            int nuevaEdad = scanner.nextInt();
            perroEncontrado.setEdad(nuevaEdad);

            System.out.println("Introduzca los nuevos puntos:");
            int nuevosPuntos = scanner.nextInt();
            perroEncontrado.setPuntos(nuevosPuntos);

            System.out.println("La info del perro llamado " + nombre + " ha sido modificado correctamente.");
        }
    }
    
    public void eliminarPerro() {
        
        if (misPerros.isEmpty()) {
            System.out.println("No se han ingresado perros al sistema.");
            return;
        } else {
            System.out.println("Introduzca el nombre del perro que desea eliminar:");
            Scanner scanner = new Scanner(System.in);
            String nombre = scanner.nextLine();

            Perro perroEncontrado = null;
            for (Perro p: misPerros) {
                if (p.getNombre().equals(nombre)) {
                    perroEncontrado = p;
                    break;
                }
            }

            if (perroEncontrado == null) {
                System.out.println("No se encontró ningún perro con el nombre " + nombre);
                return;
            }

            misPerros.remove(perroEncontrado);
            System.out.println("El perro con nombre " + nombre + " ha sido eliminado correctamente.");
        }
    }
    
    public void mostrarPerroMayorPuntaje() {
        
        if (misPerros.isEmpty()) {
            System.out.println("No se han ingresado perros al sistema.");
            return;
        } else {
            Perro perroGanador = misPerros.get(0);
            for (Perro p: misPerros) {
                if (p.getPuntos() > perroGanador.getPuntos()) {
                    perroGanador = p;
                }
            }

            System.out.println("Perro ganador:");
            System.out.println("Nombre: " + perroGanador.getNombre());
            System.out.println("Foto: " + perroGanador.getFoto());
            System.out.println("Raza: " + perroGanador.getRaza());
            System.out.println("Edad: " + perroGanador.getEdad());
            System.out.println("Puntos: " + perroGanador.getPuntos());
            System.out.println("----------------------------------");
        }
    }
    
    public void mostrarPerroMenorPuntaje() {
        
        if (misPerros.isEmpty()) {
            System.out.println("No se han ingresado perros al sistema.");
            return;
        } else  {
            Perro perroMenorPuntaje = misPerros.get(0);
            for (Perro p: misPerros) {
                if (p.getPuntos() < perroMenorPuntaje.getPuntos()) {
                    perroMenorPuntaje = p;
                }
            }

            System.out.println("Perro con menor puntaje:");
            System.out.println("Nombre: " + perroMenorPuntaje.getNombre());
            System.out.println("Foto: " + perroMenorPuntaje.getFoto());
            System.out.println("Raza: " + perroMenorPuntaje.getRaza());
            System.out.println("Edad: " + perroMenorPuntaje.getEdad());
            System.out.println("Puntos: " + perroMenorPuntaje.getPuntos());
            System.out.println("----------------------------------");
        }
    }
    
    public void mostrarPerroMayorEdad() {
        
        if (misPerros.isEmpty()) {
            System.out.println("No se han ingresado perros al sistema.");
            return;
        } else{
            Perro perroMayorEdad = misPerros.get(0);
            for (Perro p: misPerros) {
                if (p.getEdad() > perroMayorEdad.getEdad()) {
                    perroMayorEdad = p;
                }
            }

            System.out.println("Perro con mayor edad:");
            System.out.println("Nombre: " + perroMayorEdad.getNombre());
            System.out.println("Foto: " + perroMayorEdad.getFoto());
            System.out.println("Raza: " + perroMayorEdad.getRaza());
            System.out.println("Edad: " + perroMayorEdad.getEdad());
            System.out.println("Puntos: " + perroMayorEdad.getPuntos());
            System.out.println("----------------------------------");
        }
    }
}