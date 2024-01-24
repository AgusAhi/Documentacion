import java.io.*;

/**
 * Clase que representa una baraja
 * @author Agus
 * @version 1.0
 */
public class Deck {
    //Atributos
    private Card[] cards;
    private int cardsLeft;

    public Deck() {
        cards = new Card[48];
        int counter = 0;
        for (int suit = 1; suit <= 4; suit++) {
            for (int number = 1; number <= 12; number++) {
                cards[counter] = new Card(number, suit);
                counter++;
            }
        }
        cardsLeft = cards.length;
    }
    //Shuffle
    public void shuffle(int numSwaps) {
        Card temp;
        int number1, number2;
        for (int i = 0; i < numSwaps; i++) {
            number1 = (int) (Math.random() * cardsLeft);
            number2 = (int) (Math.random() * cardsLeft);
            temp = cards[number1];
            cards[number1] = cards[number2];
            cards[number2] = temp;
        }
    }
    //Extraer carta
    public Card extractCard() {
        Card lastCard = cards[cardsLeft - 1];
        cardsLeft--;
        return  lastCard;
    }
    //toString
    @Override
    public String toString() {
        String s = "";
        boolean first;
        for (int suit = 1; suit <= 4; suit++) {
            first = true;
            for (int i = 0; i < cards.length; i++) {
                if (cards[i].getSuit() == suit) {
                    if (first) {
                        first = false;
                    } else {
                        s += ", ";
                    }
                    s += cards[i] + " ";
                }
            }
            s += "\n";
        }
        return s;
    }

    /**
     * Escribe la baraja en un fichero
     * @param filename
     * @throws IOException
     */
    public void writeToFile(String filename) throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(filename));
            out.println("number,suit");
            for (int i = 0; i < cardsLeft; i++) {
                out.println(cards[i].getNumber() + "," + cards[i].getSuit());
            }
        } finally {
            if (out != null) {
                out.close();
            }

        }

    }

    public void empty() {
        cardsLeft = 0;
    }

    public void insertCard(Card card) {
        cards[cardsLeft] = card;
        cardsLeft++;
    }


    /**
     * Lee una baraja desde un fichero
     * @param fileName
     * @return
     * @throws IOException
     */
    public static Deck readFromFile(String fileName) throws IOException {
        BufferedReader input = null;
        Deck deck = new Deck();
        deck.empty();
        try {
            input = new BufferedReader(new FileReader(fileName));
            String line = input.readLine();
            while ((line = input.readLine()) != null) {
                String[] items = line.split(",");
                int number = Integer.parseInt(items[0]); // Convertir en stream
                int suit = Integer.parseInt(items[1]);
                Card card = new Card(number, suit);
                deck.insertCard(card);
            }
            return deck;
        } finally {
            if (input != null) {
                input.close();
            }

        }

    }

}