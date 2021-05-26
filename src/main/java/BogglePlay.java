
import java.util.Scanner;

public class BogglePlay {

    /*
    * Aquí se modela el juego Boggle.
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int idioma;
        String palabra = "";
        BoggleBox boggleBox;
        Jugador ju = new Jugador();
        boolean totalPalabras = false; //Para saber si se han encontrado todas las palabras

        System.out.println("Bienvenido a Boggle\n");
        System.out.println("¿En qué idioma desea jugar? \nEscriba 0 para ingles y 1 para español: ");
        idioma = scan.nextInt(); //Pedimos primeramente el idioma en el que se desea jugar

        while (idioma != 0 && idioma != 1) { //Si no se introduce uno de estos 2 idiomas se pide la información de nuevo
            scan.nextLine();
            System.out.println("Dato inválido, introduce de nuevo la opción.");
            idioma = scan.nextInt();
        }

        System.out.println("");

        boggleBox = new BoggleBox(idioma); //Segun el idioma dado creamos el BoggleBox correspondiente
        boggleBox.mostrarBoggleBox(); //Mostramos el BoggleBox en la terminal

        System.out.println("Si desea salir escriba 'salir'\n"); //Le hacemos saber al usuario como podrá salir del juego

        scan.nextLine();

        /*
        * El siguiente cilo verifica que la palabra salir no se ha dado, por lo tanto
        * se podrá seguir ingresando palabras y comparando con el Array del BoggleBox
         */
        do {

            System.out.println("Ingrese una palabra: ");
            palabra = scan.nextLine().toUpperCase(); //Guardamos la palabra ingresada cambiandola a mayúsculas

            if (boggleBox.comprobarPalabra(palabra)) { //Comprobamos que la palabra se encuentre en el BoggleBox
                ju.guardarPalabra(palabra); //Si la encuentra se guarda en las palabras del jugador
            } else if (palabra.equals("SALIR")) { //Verifica que la palabra no sea salir, y si lo es imrpime un mensaje y termina el ciclo
                System.out.println("\nPalabras del jugador: ");
                break;
            } else { //En cualquier otro caso la palabra no sería válida
                System.out.println("Palabra no válida\n");
            }
            /*En caso de que se hayan ingresado todas las palabras, se verifica que así sea y se imprime un mensaje*/
            if (ju.getPalabrasEncontradas().size() == boggleBox.getPalabras().size()) {
                System.out.println("\n¡FELICIDADES! Has encontrado todas las palabras\nHas ganado 100 puntos\n");
                totalPalabras = true; //Se cambia el booleano
                palabra = "SALIR"; //Y cambiamos la palabra a salir para que el ciclo pueda terminar
            }

        } while (palabra.equals("SALIR") == false);
        /*Si se han encontrado todas las palabras usamos "agregarPuntos" para que le de al jugador puntos extras /*/
        if (totalPalabras) {
            System.out.println("\nEl puntaje fue: " + ju.agregarPuntos());
        } else { //En otro caso solo imprimimos su puntuación
            System.out.println("\nEl puntaje fue: " + ju.sacarPuntaje());
        }
    }
}
