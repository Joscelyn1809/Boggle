
import java.util.HashSet;

public class Jugador {

    /*
    * Esta clase modela a un jugador, el cual tiene un HashSet donde se guardan
    * las palabras que va encontrando, y gracias al mismo no pueden repetirse.
    * El jugador también cuenta con un puntaje que se le da a conocer al final
    * del juego
     */
    private HashSet<String> palabrasEncontradas;
    private int puntaje;

    /*
    * Constructor del jugador donde creamos el HashSet que contendrá las palabras
    * que vaya encontrando.
     */
    public Jugador() {
        palabrasEncontradas = new HashSet();
    }

    /*
    * Este método nos sirve para guardar la palabra que se le de.
     */
    public void guardarPalabra(String palabra) {
        palabrasEncontradas.add(palabra);
    }

    @Override
    public String toString() {
        return "" + palabrasEncontradas;
    }

    /*
    * Sacamos el puntaje al final del juego para darselo a conocer al jugador
    * donde una palabra de 5 letras vale 5 puntos, y una palabra con más, vale 
    * 10 puntos. Además que, se agregan puntos según el numero de palabras que 
    * el jugador haya encontrado.
     */
    public int sacarPuntaje() {
        puntaje = 0;
        for (String palabra : palabrasEncontradas) {
            if (palabra.length() == 5) {
                puntaje += 5;
                System.out.println(palabra + "\tPuntos = 5");
            } else if (palabra.length() > 5) {
                puntaje += 10;
                System.out.println(palabra + "\tPuntos = 10");
            } else if(palabra.length() < 5){
                puntaje += 3;
                System.out.println(palabra + "\tPuntos = 3");
            }

        }
        puntaje += palabrasEncontradas.size() * 2;
        System.out.println("Puntos por palabras encontradas = " + palabrasEncontradas.size() * 2);
        return puntaje;
    }

    public HashSet<String> getPalabrasEncontradas() {
        return palabrasEncontradas;
    }

    /* 
    * Este método lo utilizo en caso de que el jugador haya ingresado todas las 
    * palabras, y cuando esto pase se le dan 100 puntos extra. 
    */
    public int agregarPuntos() {
        sacarPuntaje();
        puntaje += 100;
        return puntaje;
    }

}
