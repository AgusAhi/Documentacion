/**
 * Clase que representa una carta
 * @author Agus
 * @version 1.0
 */

public class Card {
    /**
     * Constantes oros {@value}
     */
    public static final int OROS = 1;
    /**
     * Constantes copas {@value}
     */
    public static final int COPAS = 2;
    /**
     * Constantes espadas {@value}
     */
    public static final int ESPADAS = 3;
    /**
     * Constantes bastos {@value}
     */
    public static final int BASTOS = 4;

    //Atributos
    private int number;
    private int suit;

    /**
     * Constructor de la clase
     * @param number numero
     * @param suit palo
     */
    public Card(int number, int suit) {
        this.number = number;
        this.suit = suit;
    }

    /**
     * Metodo toString que devuelve el string de la carta
     * @return
     */
    @Override
    public String toString() {
        String s = "";
        if (number < 10) {
            s += number;
        } else if (number == 10) {
            s = "Sota";
        } else if (number == 11) {
            s = "Caballo";
        } else if (number == 12) {
            s = "Rey";
        }
        switch(suit) {
            case OROS:
                s += " de oros";
                break;
            case COPAS:
                s += " de copas";
                break;
            case ESPADAS:
                s += " de espadas";
                break;
            case BASTOS:
                s += " de bastos";
                break;
        }
        return s;
    }

    /**
     * Getter para el palo
     * @return
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Getter para el numero de la carta
     * @return
     */
    public int getNumber() {
        return number;
    }
}