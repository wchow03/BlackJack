import java.util.*;

public class Hand {
    // Creates an array list of cards called hand
    private ArrayList<Card> hand = new ArrayList<Card>();
    // To keep track of values and values added
    private int sum = 0;

    public Hand(Deck deck) {
        // Initializes 2 cards and stores them in the hand variable
        // hand.add(deck.getCard());
        hand.add(deck.getCard());
        hand.add(deck.getCard());

        // Sums the values in the hand variable
        sum += hand.get(0).getValue() + hand.get(1).getValue();
        if(sum>21) sum -= 10;
    }

    // Adds a card to hand and removes it from the deck
    public void addCard(Deck deck) {
        hand.add(deck.getCard());

        sum += hand.get(hand.size()-1).getValue();

        int temp = 0;
        // If the sum is greater than 21 checks if there is an ACE
        // If there is it will subtract 10 and ACE will have the value 1
        if(sum > 21) {
            for(int i = 0; i < hand.size(); i++) {
                if(hand.get(i).getValue() != 11) {
                    temp += hand.get(i).getValue();
                }
                else temp++;
            }
            sum = temp;
        }
    }

    // Returns the sum of the cards in hand
    public int getSum() {
        return sum;
    }

    // Prints out the card in hand and the sum at the end
    public void printHand() {
        for(int i = 0; i < hand.size(); i++) {
            System.out.print(hand.get(i)+" ");
        }
        System.out.println("("+getSum()+")");
    }

    public void printDealerCard() {
        System.out.println(hand.get(1));
    }
}
