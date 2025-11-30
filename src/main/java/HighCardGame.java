import java.util.Scanner;

/**
 * A simple High Card game where two players compete by playing their highest cards
 * @author Parusan
 * @version 1.0
 */
public class HighCardGame {
    
    /**
     * Main method that runs the High Card game
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Get player names and ages
            System.out.println("=== HIGH CARD GAME ===");
            System.out.print("Enter Player 1 name: ");
            String player1Name = scanner.nextLine();
            System.out.print("Enter Player 1 age: ");
            int player1Age = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            System.out.print("Enter Player 2 name: ");
            String player2Name = scanner.nextLine();
            System.out.print("Enter Player 2 age: ");
            int player2Age = scanner.nextInt();
            
            // Create players with age
            Player player1 = new Player(player1Name, player1Age);
            Player player2 = new Player(player2Name, player2Age);
            
            // Create and shuffle deck
            Deck deck = new Deck();
            System.out.println("\nShuffling deck...");
            deck.shuffle();
            
            // Deal 5 cards to each player using draw method
            System.out.println("Dealing cards...");
            for (int i = 0; i < 5; i++) {
                player1.draw(deck);
                player2.draw(deck);
            }
            
            // Play 5 rounds
            System.out.println("\n=== STARTING GAME ===");
            int player1Points = 0;
            int player2Points = 0;
            
            for (int round = 1; round <= 5; round++) {
                System.out.println("\n--- Round " + round + " ---");
                
                // Players play their highest cards (we need to implement this logic)
                Card card1 = getHighestCard(player1.getHand());
                Card card2 = getHighestCard(player2.getHand());
                
                // Remove the played cards from hands using discardCard with a temporary discard pile
                DiscardPile tempDiscard = new DiscardPile();
                removeCardFromHand(player1, card1);
                removeCardFromHand(player2, card2);
                
                System.out.println(player1.getName() + " plays: " + card1 + " (Value: " + card1.getValue() + ")");
                System.out.println(player2.getName() + " plays: " + card2 + " (Value: " + card2.getValue() + ")");
                
                // Determine round winner
                if (card1.getValue() > card2.getValue()) {
                    player1Points++;
                    System.out.println("🎉 " + player1.getName() + " wins the round!");
                } else if (card2.getValue() > card1.getValue()) {
                    player2Points++;
                    System.out.println("🎉 " + player2.getName() + " wins the round!");
                } else {
                    System.out.println("🤝 It's a tie! No points awarded.");
                }
            }
            
            // Determine game winner
            System.out.println("\n=== GAME OVER ===");
            System.out.println("Final Scores:");
            System.out.println(player1.getName() + ": " + player1Points + " points");
            System.out.println(player2.getName() + ": " + player2Points + " points");
            
            if (player1Points > player2Points) {
                System.out.println("\n🏆 " + player1.getName() + " WINS THE GAME!");
            } else if (player2Points > player1Points) {
                System.out.println("\n🏆 " + player2.getName() + " WINS THE GAME!");
            } else {
                System.out.println("\n🤝 The game is a TIE!");
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Game error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Helper method to find the highest value card in a hand
     * @param hand the hand of cards to search
     * @return the highest value card in the hand
     */
    private static Card getHighestCard(Card[] hand) {
        if (hand.length == 0) {
            throw new IllegalStateException("Cannot get highest card from empty hand");
        }
        
        Card highestCard = hand[0];
        for (int i = 1; i < hand.length; i++) {
            if (hand[i].getValue() > highestCard.getValue()) {
                highestCard = hand[i];
            }
        }
        return highestCard;
    }
    
    /**
     * Helper method to remove a specific card from a player's hand
     * @param player the player to remove the card from
     * @param card the card to remove
     */
    private static void removeCardFromHand(Player player, Card card) {
        // Create a temporary discard pile to use the discardCard method
        DiscardPile tempDiscard = new DiscardPile();
        player.discardCard(card, tempDiscard);
    }
}