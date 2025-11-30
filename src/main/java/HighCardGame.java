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
            // Get player names
            System.out.println("=== HIGH CARD GAME ===");
            System.out.print("Enter Player 1 name: ");
            String player1Name = scanner.nextLine();
            
            System.out.print("Enter Player 2 name: ");
            String player2Name = scanner.nextLine();
            
            // Create players
            Player player1 = new Player(player1Name);
            Player player2 = new Player(player2Name);
            
            // Create and shuffle deck
            Deck deck = new Deck();
            System.out.println("\nShuffling deck...");
            deck.shuffle();
            
            // Deal 5 cards to each player
            System.out.println("Dealing cards...");
            for (int i = 0; i < 5; i++) {
                player1.addCardToHand(deck.draw());
                player2.addCardToHand(deck.draw());
            }
            
            // Play 5 rounds
            System.out.println("\n=== STARTING GAME ===");
            for (int round = 1; round <= 5; round++) {
                System.out.println("\n--- Round " + round + " ---");
                
                // Players play their highest cards
                Card card1 = player1.playHighestCard();
                Card card2 = player2.playHighestCard();
                
                System.out.println(player1.getName() + " plays: " + card1 + " (Value: " + card1.getValue() + ")");
                System.out.println(player2.getName() + " plays: " + card2 + " (Value: " + card2.getValue() + ")");
                
                // Determine round winner
                if (card1.getValue() > card2.getValue()) {
                    player1.addPoint();
                    System.out.println("🎉 " + player1.getName() + " wins the round!");
                } else if (card2.getValue() > card1.getValue()) {
                    player2.addPoint();
                    System.out.println("🎉 " + player2.getName() + " wins the round!");
                } else {
                    System.out.println("🤝 It's a tie! No points awarded.");
                }
            }
            
            // Determine game winner
            System.out.println("\n=== GAME OVER ===");
            System.out.println("Final Scores:");
            System.out.println(player1.getName() + ": " + player1.getPoints() + " points");
            System.out.println(player2.getName() + ": " + player2.getPoints() + " points");
            
            if (player1.getPoints() > player2.getPoints()) {
                System.out.println("\n🏆 " + player1.getName() + " WINS THE GAME!");
            } else if (player2.getPoints() > player1.getPoints()) {
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
}