import java.util.*;

public class Deck {

    // Remove the card after adding it to a hand
    private int removeCard;
    // Create an array list of cards called deck
    public ArrayList<Card> deck = new ArrayList<Card>();

    public Deck() {
        // Constructs a deck of cards
        for(int i = 1; i <= 13; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, j));
            }
        }
    }

    // Returns a random card from the deck then removes it from deck
    // so it can't be used again
    public Card getCard() {
        Random rand = new Random();
        // Store int as a variable
        removeCard = rand.nextInt(deck.size());
        // Remove the card at the index
        Card temp = deck.get(removeCard);
        deck.remove(removeCard);
        return temp;
    }

    // Prints out the cards in the current deck
    public ArrayList<Card> getDeck() {
        return deck;
    }
}
