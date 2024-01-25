import java.io.IOException;
/**
 * This is a main class
 * <pre>
 * {@code
 * Deck deck = Deck.readFromFile("cards.csv");
 * System.out.println(deck);
 * }
 * </pre>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //deck.writeToFile("cards.csv");

        /**
         * Ejemplo de lectura de baraja desde un fichero csv
         * @link Deck#readFromFile(String)
         */
        Deck deck = Deck.readFromFile("cards.csv");
        System.out.println(deck + "@docRoot/cards.csv");

    }
}