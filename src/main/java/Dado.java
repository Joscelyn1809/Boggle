
import java.util.Random;
/*
* Crea un dado normal de 6 caras y lo lanza.
*/
public class Dado {
    protected int caras = 6;
    protected int valor;
    Random ale = new Random();
    
    public Dado(){
       lanzar();
    }
    
    public int getCaras(){
    return caras;
    }

    public int getValor() {
        return valor;
    }
    
    public int lanzar(){
        valor = ale.nextInt(6);
        return valor + 1;
    }
}
