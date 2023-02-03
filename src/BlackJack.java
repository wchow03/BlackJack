import java.util.*;

public class BlackJack {
    // Player starts with $100
    public static int bankroll = 100;
    public static boolean playAgain = true;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.println("Starting bankroll: " +bankroll);

        while(playAgain) {
            // Create a deck of cards
            Deck deck = new Deck();
            // Create a player hand with 2 cards
            Hand player = new Hand(deck);
            // Create a dealer hand with 2 cards
            Hand dealer = new Hand(deck);
            System.out.print("What is your bet? ");
            int bet = console.nextInt();
            while (bet > bankroll) {
                System.out.print("You bet more than your bankroll, please enter a new bet! ");
                bet = console.nextInt();
            }

            bankroll -= bet;

            System.out.print("Player: ");
            player.printHand();
            System.out.print("Dealer: X ");
            dealer.printDealerCard();

            hitOrStand(console, deck, player);

            dealerHits(console, dealer, deck);

            checkWin(dealer, player, bet);

            wantToPlayAgain(console);
        }
    }

    // Asks player if they want to hit or stand
    public static void hitOrStand(Scanner console, Deck deck, Hand player) {

        while(true) {
            System.out.print("Hit or Stand? ");
            String hitOrStand = console.next().toLowerCase();
            if(hitOrStand.equals("stand")) {
                System.out.print("Enter for dealer turn");
                Scanner temp = new Scanner(System.in);
                temp.nextLine();
                break;
            }
            else if(hitOrStand.equals("hit")) {
                player.addCard(deck);
                player.printHand();
                if(player.getSum() > 21) {
                    System.out.println("You Busted!");
                    break;
                }
            }
            else {
                System.out.println("Invalid answer!");
            }
        }
    }

    public static void dealerHits(Scanner console, Hand dealer, Deck deck) {
        // Dealer keep hitting till sum is 17 or higher,
        System.out.print("Dealer: ");
        dealer.printHand();
        System.out.println("Dealer's hand has value "+dealer.getSum());
        System.out.print("Enter to continue");
        Scanner temp = new Scanner(System.in);
        temp.nextLine();
        while(dealer.getSum()<17) {
            System.out.println("Dealer hits");
            dealer.addCard(deck);
            dealer.printHand();
            System.out.println("Dealer's hand has value "+dealer.getSum());
            System.out.print("Enter to continue");
            temp.nextLine();
        }
        if(dealer.getSum()>21) {
            System.out.println("Dealer busts");
        }
        else {
            System.out.println("Dealer stands");
        }
        // once dealer gets 17 or higher they must stay
    }

    // Checks if the player wins
    public static void checkWin(Hand dealer, Hand player, int bet) {
        // Player wins if
        // If dealer exceeds 21 and player does not, player wins
        // If player attains final sum higher than dealer without exceeding 21
        // player wins
        if((dealer.getSum()>21 && player.getSum()<=21) ||
                (player.getSum()<=21 && player.getSum()>dealer.getSum())) {
            bankroll += bet*2;
            System.out.println("Player wins");
        }
        // If both dealer and player receive blackjack or hand with same sum
        // "push" is called and no one wins
        else if(dealer.getSum()==player.getSum()) {
            System.out.println("Push");
        }
        // else if(dealer.getSum()<=21 && dealer.getSum()<player.getSum()) {
        //     bankroll -= bet;
        //     System.out.println("Dealer wins");
        // }
        else {
            // bankroll -= bet;
            System.out.println("Dealer wins");
        }
        System.out.println("New bankroll: "+bankroll);
    }

    // Asks player if they want to play again
    public static void wantToPlayAgain(Scanner console) {

        System.out.print("Would you like to play again? (Y/N) ");
        String again = console.next().toLowerCase();
        while(!(again.equals("n") || again.equals("y"))) {
            System.out.println("Invalid answer!");
            System.out.print("Would you like to play again? (Y/N) ");
            again = console.next().toLowerCase();
        }
        if(again.equals("n")) {
            System.out.println("Thanks for playing!");
            System.out.println("Ending bankroll: " +bankroll);
            playAgain = false;
        }
    }
}
