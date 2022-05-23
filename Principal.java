import java.util.ArrayList;
import java.util.Scanner;
public class Principal{

    // MAIN 
    public static void main (String[]args){
        Principal.mostrarMenu();
    }
    
    public static void mostrarMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("Opción 0: Cerrar programa.");
        System.out.println("Opción 1: Ingresar información de zombie.");
        System.out.println("Opción 2: Mostrar información de todos los zombies.");
        System.out.println("Opción 3: Cantidad de zombies creados.");
        System.out.println("Opción 4: Mostrar zombies con tipo de sangre O+ & AB+.");
        System.out.println("Opción 5: Zombies que nacieron después del año 2000. ");
        System.out.println("Opción 6: Lanzar bomba a la ciudad (Reduce la salud de los zombies a la mitad).");
        System.out.println("Opción 7: Ingresar información de Ubicaciones.");
        System.out.println("Opción 8: Mostrar información de todas las ubicaciones.");
        System.out.println("Opción 9: Información de la ubicación más segura de la ciudad.");
        System.out.println("Opción 10: Ordenamiento de las ubicaciones por distancia de Alexandria.");
        System.out.println("Opción 11: Mostrar aleatoriamente 1 frase.");
        System.out.println("Opción 12: Aplicar vacuna a un zombie.");
        
        
        
        int i = 0;
        int numero = 1;
  
           
        while(numero != 0){
               System.out.println(" ");
               System.out.println("-Seleccione una opción del 0 al 12-");
               System.out.println(" ");
               int numero2 = scan.nextInt();
               numero = numero2;
               switch(numero2){
                   
                   case 0:
                       System.out.println("Acabas de cerrar el programa.");
                       break;
                       
                    case 1:
                        System.out.println("Ingrese información de zombies:");
                        System.out.println("Ingrese nombre del Zombie:");
                        String nombre = scan.next();
                        System.out.println("Ingrese Salud del Zombie:");
                        int salud = scan.nextInt();
                        System.out.println("Ingrese fecha de nacimiento del Zombie (DD-MM-AA):");
                        String fechaNacimiento = scan.next();
                        System.out.println("Ingrese tipo de sangre del Zombie:");
                        String tipoSangre = scan.next();
                        
                        Zombie zombie1 = new Zombie(nombre, salud, fechaNacimiento, tipoSangre);
                        Zombie.zombies.add(zombie1);
                        break;
                        
                    case 2:
                        System.out.println("Los zombies son los siguientes:");
                        for (int j = 0; j<Zombie.zombies.size(); j++){
                            System.out.println(Zombie.zombies.get(j).toString());
                        }
                        break;
                    case 3:
                        System.out.println("La cantidad de zombies creados es:");
                        System.out.println(Zombie.zombies.size());
                        break;
                        
                    case 4:
                        System.out.println("Estos son los zombies con tipo de sangre O+ & AB+ : ");
                        for(int j= 0; j<Zombie.zombies.size(); j++){
                            if(Zombie.zombies.get(j).getTipoSangre().equals("O+")){
                                System.out.println(Zombie.zombies.get(j).toString());
                            }
                            else if(Zombie.zombies.get(j).getTipoSangre().equals("AB+")){
                                System.out.println(Zombie.zombies.get(j).toString());
                            }
                        }
                        break;
                    
                    case 5:
                        System.out.println("Los zombies que nacieron después del año 2000 son: ");
                        for(int j= 0; j<Zombie.zombies.size(); j++){
                            String message = Zombie.zombies.get(j).getFechaNacimiento();
                            int añoNacimiento = Integer.parseInt(message.substring(6,10));
                            if(añoNacimiento > 2000){
                                System.out.println(Zombie.zombies.get(j).toString());
                            }
                        }
                        break;
                    case 6:
                        System.out.println("Acabas de lanzar la bomba, esto reduce a la mitad la salud de los zombies.");
                        System.out.println("Presiona 2 para verificar los datos actualizados.");
                        Zombie.lanzarBomba();
                        break;
                        
                    case 7:
                        System.out.println("Ingrese información de ubicaciones:");
                        System.out.println("Ingrese nombre de la ubicacion:");
                        String nombreUbicacion = scan.next();
                        System.out.println("Ingrese la distancia a Alexandria en metros:");
                        float distanciaAlexandria = scan.nextFloat();
                        System.out.println("Ingrese la cantidad de zombies:");
                        int cantidadZombies = scan.nextInt();
                        
                        Ubicacion ubicacion1 = new Ubicacion(nombreUbicacion, distanciaAlexandria, cantidadZombies);
                        Ubicacion.ubicaciones.add(ubicacion1);
                        break;
                        
                    case 8:
                        System.out.println("Las ubicaciones son las siguientes:");
                        for (int j = 0; j<Ubicacion.ubicaciones.size(); j++){
                            System.out.println(Ubicacion.ubicaciones.get(j).toString1());
                        }
                        break; 
                        
                    case 9:
                        System.out.println("La(s) ubicacione(s) más seguras son: ");
                        Ubicacion ubicacionMasSegura = Ubicacion.ubicaciones.get(0);
                        int ubicacionMenorCantidadZombies = Ubicacion.ubicaciones.get(0).getCantidadZombies();
                        for (int m=0; m<Ubicacion.ubicaciones.size(); m++){
                            if (ubicacionMenorCantidadZombies >= Ubicacion.ubicaciones.get(m).getCantidadZombies()){
                                ubicacionMenorCantidadZombies = Ubicacion.ubicaciones.get(m).getCantidadZombies();
                                ubicacionMasSegura = Ubicacion.ubicaciones.get(m);
                                
                            }
                             
                        }
                        
                        for(int x=0;  x<Ubicacion.ubicaciones.size(); x++){
                            if(Ubicacion.ubicaciones.get(x).getCantidadZombies() == ubicacionMenorCantidadZombies ){
                                  System.out.println(Ubicacion.ubicaciones.get(x).toString1());
                            }
                        }
                       
                      
                        
                        break;
                        
                    case 10:
                        System.out.println("Se ordeno por distancia las ubicaciones.");
                        System.out.println("Presiona 8 para verificar los datos actualizados.");
                        int n = Ubicacion.ubicaciones.size();
                        Ubicacion temp;
                        
                        for(int k = 1; k<n;k++){
                            for (int j = 0; j<n-1; j++){
                                if(Ubicacion.ubicaciones.get(j).getDistanciaAlexandria() > Ubicacion.ubicaciones.get(j+1).getDistanciaAlexandria()){
                                    temp = Ubicacion.ubicaciones.get(j);
                                    Ubicacion.ubicaciones.set(j, Ubicacion.ubicaciones.get(j+1));
                                    Ubicacion.ubicaciones.set(j+1, temp);
                                }
                            }
                        }
                        break;
                        
                    case 11:
                        System.out.println("Frases random de los zombies:");
                        int numeroRandom = 0;
                        numeroRandom = (int)(Math.random() * 4);
                        if(numeroRandom == 0){
                            System.out.println("Según la tradición zombi, la única manera de matar a un zombi es dañar su cerebro o cortar su cabeza.");
                        }
                        else if(numeroRandom == 1){
                            System.out.println("Además de poder moverse después de que están muertos, los zombies no tienen superpoderes. De hecho, los zombis en realidad tienen menos habilidades que cuando eran seres humanos vivos.");
                        }
                        else if(numeroRandom == 2){
                            System.out.println("El zombi más famoso de la «vida real» es el haitiano Clairvius Narcisse. Afirmó que se convirtió en un zombi por una combinación de poderosas neurotoxinas y alucinógenos.");
                        }
                        else if(numeroRandom == 3){
                            System.out.println("La primera película de zombis realizada es la película estadounidense de 1932 White Zombie. ");
                        }
                        else  if(numeroRandom == 4){
                            System.out.println("El término «Zombophiles» es un término utilizado para describir a los fans de los géneros zombies.");
                        }
                        break;
                        
                    case 12:
                        System.out.println("Tienes una vacuna para salvar una persona, esta convertira un zombie en persona.");
                        System.out.println("¿Qué persona quieres salvar?");
                        
                        String nombreZombie = scan.next();
                        
                         for(int j= 0; j<Zombie.zombies.size(); j++){
                            if(Zombie.zombies.get(j).getNombre().equals(nombreZombie)){
                        System.out.println("Acabas de salvar a: " + Zombie.zombies.get(j).getNombre());
                        Zombie.zombies.remove(j); 
                        System.out.println("Usa la opción 2 y verifica que ya no este en nuestro radar de zombies."); 
                            }
                           
                        }
                       
                        break;
                }
            } 
        }
}




