
public class DadoBoggle extends Dado {
    /*
    * Crea el dado que se utilizará en Boggle Box, este DadoBoggle extiende a la clase Dado
    */
    protected String letras;
    
    /*
    * Recibe una cadena de letras las cuales serán asignadas a las diferentes caras del dado
    */
    public DadoBoggle(String letras) {
        super();
        this.letras = letras;
    }
    
    @Override
    public String toString() {
        return letras.substring(valor, valor + 1);
    }
    
    public String getCara() {
        return letras.substring(valor, valor + 1);
    }
}
