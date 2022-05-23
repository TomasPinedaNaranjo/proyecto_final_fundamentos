import java.util.Scanner;
public class Bichos
{
    Scanner scan1 = new Scanner(System.in);
    private int salud;

    public Bichos(int salud){
        this.salud = salud;
    }

    public int getSalud(){
        return this.salud;
    }

    public void setSalud(int salud){
        this.salud = salud;
    }

    public static void imprimirTabla(Bichos[][] bichos){

        for (int i = 0; i < bichos.length; i++){
            System.out.println("-------------------");
            for(int j = 0; j<bichos[i].length;j++){

                if(bichos[j][i] != null){
                    System.out.print("|" + bichos[j][i].toString() );
                }

                else{
                    System.out.print("|" + "     " );
                }
            }

            System.out.println("|");
        }
        System.out.println("-------------------");

    }

    public static void crearTabla(Bichos[][] bichos) {//METODO PARA INVOCAR LA TABLA
        int aleatorio = 0;
        aleatorio = (int) (Math.random() * (10-1) + 1);

        int x = 0;
        int y = 0;  

        for (int i = 0; i<aleatorio;i++){
            if(x>2){
                x = 0;
                y++;
            }
            int aleatorio1 = 0;
            aleatorio1 = (int) (Math.random() *(4-1)+1);

            if(aleatorio1 == 1){
                BichosNormales BN = new BichosNormales();
                bichos[x][y] = BN;
            }

            else if (aleatorio1 == 2){
                BichosAliens BA = new BichosAliens();
                bichos[x][y] = BA;

            }

            else if(aleatorio1 == 3){
                BichosEspaciales BE = new BichosEspaciales();
                bichos[x][y] = BE;

            }
            x++;

        }
        Bichos.imprimirTabla(bichos);

    }

    public static void ActivarBombaAtomica(Bichos[][] bichos){

        int aleatorio1 = 0;
        aleatorio1 = (int) (Math.random() * 3);

        int aleatorio2 = 0;
        aleatorio2 = (int) (Math.random() * 3);

        if(bichos[aleatorio1][aleatorio2] != null){
            bichos[aleatorio1][aleatorio2] = null;
        }
        else{
            aleatorio1 = 0;
            aleatorio2 = 0;

            if(bichos[aleatorio1][aleatorio2] != null){
                bichos[aleatorio1][aleatorio2] = null;
            } else{
                int aleatorio3 = 0;
                aleatorio1 = (int) (Math.random() * 3);

                int aleatorio4 = 0;
                aleatorio2 = (int) (Math.random() * 3);

                if(bichos[aleatorio3][aleatorio4] != null){
                    bichos[aleatorio3][aleatorio4] = null;
                }
            }

        }

    }

    public static void promedioTenebroso(Bichos[][] bichos){

        int promedio = 0;
        int contador = 0;
        for (int i = 0; i < bichos.length; i++){

            for(int j = 0; j<bichos[i].length;j++){
                if(bichos[j][i] != null){
                    promedio = promedio + bichos[j][i].getSalud();
                    contador = contador + 1;
                }

            }
        }

        System.out.println("El promedio es: " + (promedio/contador));

    }

    public static void bombaDeFila(Bichos[][] bichos){
        int aleatorio1 = 0;
        aleatorio1 = (int) (Math.random() * 3);

        if((bichos[0][aleatorio1] != null)||(bichos[1][aleatorio1] != null)||(bichos[2][aleatorio1] != null) ){
            bichos[0][aleatorio1] = null;
            bichos[1][aleatorio1] = null;
            bichos[2][aleatorio1] = null;

        }else{
            aleatorio1 = 0;

            if((bichos[0][aleatorio1] != null)||(bichos[1][aleatorio1] != null)||(bichos[2][aleatorio1] != null)){
                bichos[0][aleatorio1] = null;
                bichos[1][aleatorio1] = null;
                bichos[2][aleatorio1] = null;

            } else{

                aleatorio1 = 1;

                if((bichos[0][aleatorio1] != null)||(bichos[1][aleatorio1] != null)||(bichos[2][aleatorio1] != null)){
                    bichos[0][aleatorio1] = null;
                    bichos[1][aleatorio1] = null;
                    bichos[2][aleatorio1] = null;

                }else{

                    aleatorio1 = 2;

                    if((bichos[0][aleatorio1] != null)||(bichos[1][aleatorio1] != null)||(bichos[2][aleatorio1] != null)){
                        bichos[0][aleatorio1] = null;
                        bichos[1][aleatorio1] = null;
                        bichos[2][aleatorio1] = null;

                    }

                }
            }       
        }           
    }

    public static void dispararBala(Bichos[][] bichos){
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Escoja la fila (Recuerde que empieza desde cero)");
        int numeroFila = scan2.nextInt();
        System.out.println("Escoje la columna (Recuerde que empieza desde cero)");
        int numeroColumna = scan2.nextInt();

        if(bichos[numeroColumna][numeroFila] != null){
            //DEBEMOS CAPTURAR LA EXCEPCION
            bichos[numeroColumna][numeroFila].setSalud( bichos[numeroColumna][numeroFila].getSalud() - 5);

            if( bichos[numeroColumna][numeroFila].getSalud() == 0){
                bichos[numeroColumna][numeroFila] = null;
            }
        }
        else{
            System.out.println("-La posición que escogió no tiene un bicho-");
        }
    }

    public static void activarBichoMutante(Bichos[][] bichos){
        int bichoMenorSalud = bichos[0][0].getSalud();
        Bichos bichoMutante = bichos[0][0];
        for (int i = 0; i < bichos.length; i++){
            for(int j = 0; j<bichos[i].length;j++){
                if(bichos[j][i] != null){
                    if(bichoMenorSalud>= bichos[j][i].getSalud()){
                        bichoMenorSalud = bichos[j][i].getSalud();
                        bichoMutante = bichos[j][i];
                    }
                }
            }
        }
        bichoMutante.setSalud(bichoMutante.getSalud()*2);

    }

    public static void intercambioDePosiciones(Bichos[][] bichos){
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Escoja una columna: ");
        int columna = scan2.nextInt();
        System.out.println("Escoja una fila: ");
        int fila = scan2.nextInt();
        Bichos temp = bichos[columna][fila];
        System.out.println("Escoja otra columna: ");
        int columna1 = scan2.nextInt();
        System.out.println("Escoja otra fila: ");
        int fila1 = scan2.nextInt();
        bichos[columna][fila]= bichos[columna1][fila1];
        bichos[columna1][fila1] = temp;

    }

    public static int encontrarmenorfila(Bichos[][]bichos){
        int cambioSalud = bichos[0][0].getSalud();
        Bichos cambioTipo = bichos[0][0];
        int fila = 0;
        for (int i = 0; i < PrincipalBichos.bichos.length; i++){
            for(int j = 0; j< PrincipalBichos.bichos[i].length;j++){
                if(bichos[j][i] != null){
                    if(cambioSalud>= bichos[j][i].getSalud()){
                        cambioSalud = bichos[j][i].getSalud();
                        cambioTipo = bichos[j][i];
                        fila = i;
                    }
                }
            }
        }
        return fila;
    }

    public static int encontrarmenorcolumna(Bichos[][]bichos){
        int cambioSalud = bichos[0][0].getSalud();
        Bichos cambioTipo = bichos[0][0];
        int columna = 0;
        for (int i = 0; i < PrincipalBichos.bichos.length; i++){
            for(int j = 0; j< PrincipalBichos.bichos[i].length;j++){
                if(bichos[j][i] != null){
                    if(cambioSalud>= bichos[j][i].getSalud()){
                        cambioSalud = bichos[j][i].getSalud();
                        cambioTipo = bichos[j][i];
                        columna = j;
                    }
                }
            }
        }
        return columna;
    }

}
