import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Deck playingCards = new Deck();
        double balance = 200.00;
        boolean roundEnds = false;

        System.out.println("Welcome to Blackjack!");
        
        playingCards.createFullDeck();
        playingCards.shuffle();

        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();

        while (balance > 0) {

            System.out.println("Currently you have $" + balance + " dollars.\nState how much you would like to bet.");
            double betAmount = input.nextDouble();

            if (betAmount > balance) {
                System.out.println("You do not have enough funds to bet.");
                break;
            }

            playerDeck.draw(playingCards);
            playerDeck.draw(playingCards);

            dealerDeck.draw(playingCards);
            dealerDeck.draw(playingCards);

            while (true) {

                System.out.println("Your current hand: ");
                System.out.println(playerDeck.toString());
                System.out.println("\nYour current hand is valued at: " + playerDeck.cardsValue());
                System.out.println("\nDealer's current Hand: \n");
                System.out.println(dealerDeck.getCard(0).toString());
                System.out.println("[ HIDDEN ]");

                System.out.println("\nWould you like to [1] Double Down or [2] Continue?");
                int response = input.nextInt();

                if(response == 1){
                    if(betAmount * 2 > balance){
                        System.out.println("You do not have enough to double down.");
                    } else {
                        betAmount *= 2;
                        playerDeck.draw(playingCards);
                        System.out.println("Your current hand: ");
                        System.out.println(playerDeck.toString());
                        System.out.println("\nYour current hand is valued at: " + playerDeck.cardsValue());

                        if (playerDeck.cardsValue() > 21) {
                            System.out.println("\nIt's a bust. Your hand is valued at: " + playerDeck.cardsValue());
                            balance -= betAmount;
                            roundEnds = true;
                            break;
                        } else {
                            break;
                        }
                    }
                }

                System.out.println("Would you like to [1] Hit or [2] Stay?");
                int hitOrStay = input.nextInt();

                if (hitOrStay == 1) {

                    playerDeck.draw(playingCards);
                    System.out.println("You draw a: \n" + playerDeck.getCard(playerDeck.deckSize() - 1).toString());
                    
                    if (playerDeck.cardsValue() > 21) {
                        System.out.println("\nIt's a bust. Your hand is valued at: " + playerDeck.cardsValue());
                        balance -= betAmount;
                        roundEnds = true;
                        break;
                    }
                    
                } else if (hitOrStay == 2) {
                    break;
                }

            }

            System.out.println("Dealer's current hand:" + dealerDeck.toString());

            if ((dealerDeck.cardsValue() > playerDeck.cardsValue()) && roundEnds == false) {
                System.out.println("Dealer beats you!");
                balance -= betAmount;
                roundEnds = true;
            }
            
            while ((dealerDeck.cardsValue() < 17) && roundEnds == false) {
                dealerDeck.draw(playingCards);
                System.out.println("Dealer Draws: " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
            }
            
            System.out.println("Dealer's hand is valued at: " + dealerDeck.cardsValue());
            
            if ((dealerDeck.cardsValue() > 21) && roundEnds == false) {
                System.out.println("Dealer busts!  You win the round.");
                balance += betAmount;
                roundEnds = true;
            }
            

            if ((playerDeck.cardsValue() == dealerDeck.cardsValue()) && roundEnds == false) {
                System.out.println("push");
                roundEnds = true;
            }
            
            if ((playerDeck.cardsValue() > dealerDeck.cardsValue()) && roundEnds == false) {
                System.out.println("You win the hand.");
                balance += betAmount;
                roundEnds = true;

            } else if (roundEnds == false) {
                System.out.println("You lose the hand.");
                balance -= betAmount;
                roundEnds = true;
            }

            playerDeck.moveAllToDeck(playingCards);
            dealerDeck.moveAllToDeck(playingCards);
            System.out.println("End of the gamble.");

        }

        System.out.println("You ran out of funds.");
        input.close();

    }
}