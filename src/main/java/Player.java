import java.util.Arrays;

/**
 * Represents a player in a card game with a hand of cards and score
 * @author Parusan
 * @version 1.0
 */
public class Player {
    private String name;
    private Card[] hand;
    private int points;
    
    /**
     * Constructs a new player with the specified name
     * @param name the player's name
     * @throws IllegalArgumentException if the name is null or empty
     */
    public Player(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty");
        }
        this.name = name.trim();
        this.hand = new Card[0];
        this.points = 0;
    }
    
    /**
     * Returns the player's name
     * @return the player's name as a String
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the player's current hand of cards
     * @return an array of cards in the player's hand
     */
    public Card[] getHand() {
        return hand;
    }
    
    /**
     * Returns the player's current point total
     * @return the number of points the player has
     */
    public int getPoints() {
        return points;
    }
    
    /**
     * Adds one point to the player's score
     */
    public void addPoint() {
        points++;
    }
    
    /**
     * Adds a card to the player's hand
     * @param card the card to add to the hand
     * @throws IllegalArgumentException if the card is null
     */
    public void addCardToHand(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Cannot add null card to hand");
        }
        
        Card[] newHand = new Card[hand.length + 1];
        for (int i = 0; i < hand.length; i++) {
            newHand[i] = hand[i];
        }
        newHand[hand.length] = card;
        hand = newHand;
    }
    
    /**
     * Removes and returns the highest value card from the player's hand
     * @return the highest value card in the hand
     * @throws IllegalStateException if the hand is empty
     */
    public Card playHighestCard() {
        if (hand.length == 0) {
            throw new IllegalStateException("Cannot play card from empty hand");
        }
        
        // Find the highest value card
        Card highestCard = hand[0];
        int highestIndex = 0;
        
        for (int i = 1; i < hand.length; i++) {
            if (hand[i].getValue() > highestCard.getValue()) {
                highestCard = hand[i];
                highestIndex = i;
            }
        }
        
        // Remove the card from hand
        Card[] newHand = new Card[hand.length - 1];
        int newIndex = 0;
        for (int i = 0; i < hand.length; i++) {
            if (i != highestIndex) {
                newHand[newIndex] = hand[i];
                newIndex++;
            }
        }
        hand = newHand;
        
        return highestCard;
    }
    
    /**
     * Returns a string representation of the player showing name, points, and hand
     * @return formatted player information
     */
    @Override
    public String toString() {
        return name + " (Points: " + points + ") - Hand: " + Arrays.toString(hand);
    }
}