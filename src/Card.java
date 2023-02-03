public class Card {
    // Array of string to access suit as string
    public static final String[] suits = {"D", "C", "H", "S"};

    // Array of string to access value as string
    public static final String[] values = {"0", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private int value;
    private int suit;

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    // Returns the value of the card
    // If it is an ace it initializes it to be 11
    // If it is a face card the value is set to 10
    public int getValue() {
        if(value == 1) {
            return 11;
        }
        if(value > 10) {
            return 10;
        }
        return value;
    }

    // Returns the suit of the card
    public String getSuit() {
        return suits[suit];
    }

    // Prints the value then suit of the card
    public String toString() {
        return values[value] + suits[suit];
    }
}
