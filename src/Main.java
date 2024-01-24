import java.io.IOException;
/**
 * This is a main class
 * For more information of what methods are available, see the documentation at {@docRoot}~/Escriptori/1º CFGS DAM/Documentación/docRoot.txt
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //deck.writeToFile("cards.csv");

        /**
         * Ejemplo de lectura de baraja desde un fichero csv
         * @link Deck#readFromFile(String)
         */
        Deck deck = Deck.readFromFile("cards.csv");
        System.out.println(deck);
    }
}