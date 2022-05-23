import java.util.Scanner;
import java.lang.Thread;
public class PrincipalBichos
{
    public static Bichos[][] bichos = new Bichos[3][3]; //CREACIÓN DE LA MATRIZ BICHOS
    public static void main (String[]args)throws InterruptedException{
        Scanner scan = new Scanner(System.in);

        System.out.println("|------------------------------------|");
        System.out.println("|BIENVENIDO Al JUEGO MATA BICHOS 3000|");
        System.out.println("|------------------------------------|");
        System.out.println("");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|     By : Marcela Londoño & Tomas Pineda           | ");
        System.out.println("|---------------------------------------------------|");
        System.out.println("");
        System.out.println("|--------------------------|");
        System.out.println("|   Comenzamos el juego    | ");
        System.out.println("|--------------------------|");

        Thread.sleep(5000);
        System.out.print('\u000C');

        System.out.println("Menu: ");
        System.out.println("Opción 0: Cerra el programa ");
        System.out.println("Opción 1: Empezar juego ");

        int opcionInicial = scan.nextInt();

        switch(opcionInicial){

            case 0:
                System.out.println("Acabas de cerrar el programa.");
                break;

            case 1:

                Bichos.crearTabla(bichos);   

                int bichosMuertos = 0;

                while(bichosMuertos < 9  ){

                    bichosMuertos = 0;
                    for (int i = 0; i < bichos.length; i++){

                        for(int j = 0; j<bichos[i].length;j++){

                            if(bichos[j][i] == null){

                                bichosMuertos = bichosMuertos + 1;

                            }

                            if(bichosMuertos == 8){
                                opcionInicial = 0;

                            }

                        }
                    }

                    if(bichosMuertos < 9){

                        System.out.println("Menu: ");
                        System.out.println("Opción 1: Disparar una Bala ");
                        System.out.println("Opción 2: Activar Bomba Atómica ");
                        System.out.println("Opción 3: Activar Bicho Mutante ");
                        System.out.println("Opción 4: Intercambio de posiciones ");
                        System.out.println("Opción 5: Conversión Sangre ");
                        System.out.println("Opción 6: Bomba de Fila ");
                        System.out.println("Opción 7: Promedio Tenebroso ");
                        System.out.println("Opción 8: La frase de la abuela ");

                        System.out.println("");  
                        System.out.println("-Seleccione una opción del menu de opciones- ");
                        System.out.println("");

                        int numeroOpcion = scan.nextInt();

                        switch(numeroOpcion){

                            case 1:
                                System.out.println("Dispara una bala ");     

                                Bichos.dispararBala(bichos);
                                Bichos.imprimirTabla(bichos);
                                System.out.println("");

                                break;
                            case 2:
                                System.out.println("Activar Bomba Atómica "); 
                                Bichos.ActivarBombaAtomica(bichos);
                                Bichos.imprimirTabla(bichos);
                                System.out.println("");
                                break;

                            case 3:
                                System.out.println("Activar Bicho Mutante ");  
                                Bichos.activarBichoMutante(bichos);
                                Bichos.imprimirTabla(bichos);
                                System.out.println("");
                                break;

                            case 4:

                                System.out.println("Intercambio de posiciones ");   
                                Bichos.intercambioDePosiciones(bichos);
                                Bichos.imprimirTabla(bichos);
                                System.out.println("");
                                break;

                            case 5:
                                System.out.println("Conversión de Sangre ");   
                                int fila2 = Bichos.encontrarmenorfila(bichos);
                                int columna2 = Bichos.encontrarmenorcolumna(bichos);
                                int cambioSalud = bichos[columna2][fila2].getSalud();
                                bichos[columna2][fila2]= new BichosEspaciales();
                                bichos[columna2][fila2].setSalud(cambioSalud);
                                Bichos.imprimirTabla(bichos);

                                System.out.println("");
                                break;

                            case 6:

                                System.out.println("Bomba Fila "); 
                                Bichos.bombaDeFila(bichos);
                                Bichos.imprimirTabla(bichos);
                                System.out.println("");
                                break;

                            case 7:
                                System.out.println("Promedio Tenebroso ");  
                                Bichos.promedioTenebroso(bichos);
                                System.out.println("");

                                break;
                            case 8:
                                System.out.println("La frase de la abuela ");     
                                int numeroRandom = 0;
                                numeroRandom = (int)(Math.random() * 3);
                                if(numeroRandom == 0){
                                    System.out.println("Este juego me recuerda a mis tardes después del colegio!!!");
                                }
                                else if(numeroRandom == 1){
                                    System.out.println("Como ha pasado el tiempo y sigo disfrutando este juego!!!");
                                }
                                else if(numeroRandom == 2){
                                    System.out.println("Pense que nunca volveria a jugar esto!!!");
                                }
                                System.out.println("");
                                break;
                        }

                    }
                    else{
                        System.out.println("|-------------------|");
                        System.out.println("|   FIN DEL JUEGO   | ");
                        System.out.println("|-------------------|");
                    }
                }
        }

    }

}
