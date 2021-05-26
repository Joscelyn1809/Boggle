
import java.util.ArrayList;
import java.util.Random;

/*
* La clase BoggleBox modela la caja de dados que se le mostrará al jugador
 */
public class BoggleBox {

    DadoBoggle[][] dados; //Aquí se guardan todos los dados dentro de una matriz para facilitar el acomodo del juego posteriormente
    Random ale = new Random();
    DadoBoggle dadoAux; //Un dado auxiliar para poder revolver los dados 
    int idioma;
    ArrayList<String> palabras; //Un ArrayList de las palabras que estén disponibles en el BoggleBox, las cuales podrá ingresar el usuario

    /*
    * El constructor pide como parametro el idioma para saber que método mandar 
    * llamar, ya sea crear los dados en español o en ingles.
     */
    public BoggleBox(int idioma) {
        dados = new DadoBoggle[5][5]; //Inicializamos la matriz de dados
        palabras = new ArrayList<>(); //Inicializamos el ArrayList de palabras

        if (idioma == 0) {
            crearBoggleBoxIngles();
        } else if (idioma == 1) {
            crearBoggleBoxEspañol();
        }
        revolverBoggleBox(); //Llamamos al método y la revolvemos
        buscarPalabras(); //Mandamos llamar al método de busqueda para tener las palabras listas
    }

    /*
    * Crea los dados solamenta para el Boggle Box en inglés, en una matriz de 
    * dados de Boggle de 5x5, y la regresa
     */
    public DadoBoggle[][] crearBoggleBoxIngles() {

        dados[0][0] = new DadoBoggle("QBZJXJ");
        dados[0][1] = new DadoBoggle("TOUOTO");
        dados[0][2] = new DadoBoggle("OVWRGR");
        dados[0][3] = new DadoBoggle("AAAFSR");
        dados[0][4] = new DadoBoggle("AUMEEG");
        dados[1][0] = new DadoBoggle("HHLRDO");
        dados[1][1] = new DadoBoggle("NHDTHO");
        dados[1][2] = new DadoBoggle("LHNROD");
        dados[1][3] = new DadoBoggle("AFAISR");
        dados[1][4] = new DadoBoggle("YIFASR");
        dados[2][0] = new DadoBoggle("TELPCI");
        dados[2][1] = new DadoBoggle("SSNSEU");
        dados[2][2] = new DadoBoggle("RIYPRH");
        dados[2][3] = new DadoBoggle("DORDLN");
        dados[2][4] = new DadoBoggle("CCWNST");
        dados[3][0] = new DadoBoggle("TTOTEM");
        dados[3][1] = new DadoBoggle("SCTIEP");
        dados[3][2] = new DadoBoggle("EANDNN");
        dados[3][3] = new DadoBoggle("MNNEAG");
        dados[3][4] = new DadoBoggle("UOTOWN");
        dados[4][0] = new DadoBoggle("AEAEEE");
        dados[4][1] = new DadoBoggle("YIFPSR");
        dados[4][2] = new DadoBoggle("EEEEMA");
        dados[4][3] = new DadoBoggle("ITITIE");
        dados[4][4] = new DadoBoggle("ETILIC");

        return dados;
    }

    /*
    * Crea los dados solamenta para el Boggle Box en español, en una matriz de 
    * dados de Boggle de 5x5, y la regresa
     */
    public DadoBoggle[][] crearBoggleBoxEspañol() {
        dados[0][0] = new DadoBoggle("QBZJXL");
        dados[0][1] = new DadoBoggle("TOUOTO");
        dados[0][2] = new DadoBoggle("OVCRGR");
        dados[0][3] = new DadoBoggle("AAAFSR");
        dados[0][4] = new DadoBoggle("AUMEEO");
        dados[1][0] = new DadoBoggle("EHLRDO");
        dados[1][1] = new DadoBoggle("NHDTHO");
        dados[1][2] = new DadoBoggle("LHNROD");
        dados[1][3] = new DadoBoggle("ADAISR");
        dados[1][4] = new DadoBoggle("UIFASR");
        dados[2][0] = new DadoBoggle("TELPCI");
        dados[2][1] = new DadoBoggle("SSNSEU");
        dados[2][2] = new DadoBoggle("RIYPRH");
        dados[2][3] = new DadoBoggle("DORDLN");
        dados[2][4] = new DadoBoggle("CCÑNST");
        dados[3][0] = new DadoBoggle("TTOTEM");
        dados[3][1] = new DadoBoggle("SCTIEP");
        dados[3][2] = new DadoBoggle("EANDNN");
        dados[3][3] = new DadoBoggle("MNNEAG");
        dados[3][4] = new DadoBoggle("UOTOÑN");
        dados[4][0] = new DadoBoggle("AEAEEH");
        dados[4][1] = new DadoBoggle("YIFPSR");
        dados[4][2] = new DadoBoggle("EEEEMA");
        dados[4][3] = new DadoBoggle("ITATIE");
        dados[4][4] = new DadoBoggle("ETILAC");

        return dados;
    }

    /*
    * Revuelve los dados dentro del Boggle Box para cambiar su posición.
    * Recordar que los dados individuales ya se lanzaron al ser creados.
     */
    public void revolverBoggleBox() {
        int x, y;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                x = ale.nextInt(5);
                y = ale.nextInt(5);
                dadoAux = dados[i][j];
                dados[i][j] = dados[x][y];
                dados[x][y] = dadoAux;
            }
        }
    }

    /*
    * Imprime el Boggle Box en forma de matriz
     */
    public void mostrarBoggleBox() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(dados[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /* 
    * Con este método buscamos las palabras que se puedan formar con las caras 
    * de los dados que hayan quedado "arriba" de esta forma podremos comparar
    * las String introducidas con el usuario con las disponibles.
     */
    public ArrayList<String> buscarPalabras() {
        for (int i = 0; i < 5; i++) { //Busca palabras horizontalmente
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < 5; j++) {
                sb = sb.append(dados[i][j].getCara());
                if (sb.toString().length() >= 3) { //Para que agregue también palabras de 3 y 4 letras
                    palabras.add(sb.toString());
                    palabras.add(invertirPalabra(sb.toString()));
                }
            }
        }

        for (int i = 0; i < 5; i++) { //Busca palabras verticalmente
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < 5; j++) {
                sb = sb.append(dados[j][i].getCara());
                if (sb.toString().length() >= 3) { //Para que agregue también palabras de 3 y 4 letras
                    palabras.add(sb.toString());
                    palabras.add(invertirPalabra(sb.toString()));
                }
            }
        }
        return palabras;
    }

    /*
    * Este método invierte la palabra que se le de.
     */
    public String invertirPalabra(String pal) {
        String palInvertida = "";

        for (int x = pal.length() - 1; x >= 0; x--) {
            palInvertida = palInvertida + pal.charAt(x);
        }
        return palInvertida;
    }

    /*
    * Para comparar la palabra del usuario con las contenidas en el ArrayList
     */
    public boolean comprobarPalabra(String palabra) {
        return palabras.contains(palabra);
    }

    public ArrayList<String> getPalabras() {
        return palabras;
    }
}
