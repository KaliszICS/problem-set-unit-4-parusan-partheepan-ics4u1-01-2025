
/**
 * Represents a player in a card game with a hand of cards
 * @author Parusan
 * @version 1.0
 */
public class Player {
    private String name;
    private int age;
    private Card[] hand;
    
    /**
     * Constructs a player with name, age, and initial hand of cards
     * @param name the player's name
     * @param age the player's age
     * @param hand the initial hand of cards
     * @throws IllegalArgumentException if name is null/empty or age is negative
     */
    public Player(String name, int age, Card[] hand) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (hand == null) {
            throw new IllegalArgumentException("Hand cannot be null");
        }
        this.name = name.trim();
        this.age = age;
        this.hand = hand;
    }
    
    /**
     * Constructs a player with name and age, with empty hand
     * @param name the player's name
     * @param age the player's age
     * @throws IllegalArgumentException if name is null/empty or age is negative
     */
    public Player(String name, int age) {
        this(name, age, new Card[0]);
    }
    
    /**
     * Returns the player's name
     * @return the player's name as a String
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the player's age
     * @return the player's age as an integer
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Returns the player's current hand of cards
     * @return an array of cards in the player's hand
     */
    public Card[] getHand() {
        return hand;
    }
    
    /**
     * Returns the number of cards in the player's hand
     * @return the size of the hand as an integer
     */
    public int size() {
        return hand.length;
    }
    
    /**
     * Draws a card from the deck and adds it to the player's hand
     * @param deck the deck to draw from
     * @throws IllegalArgumentException if deck is null
     */
    public void draw(Deck deck) {
        if (deck == null) {
            throw new IllegalArgumentException("Deck cannot be null");
        }
        
        Card drawnCard = deck.draw();
        if (drawnCard != null) {
            addCardToHand(drawnCard);
        }
    }
    
    /**
     * Discards a card from hand to the discard pile
     * @param card the card to discard
     * @param discardPile the discard pile to add to
     * @return true if card was successfully discarded, false otherwise
     * @throws IllegalArgumentException if card or discardPile is null
     */
    public boolean discardCard(Card card, DiscardPile discardPile) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null");
        }
        if (discardPile == null) {
            throw new IllegalArgumentException("Discard pile cannot be null");
        }
        
        // Find and remove the card from hand
        int cardIndex = -1;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].equals(card)) {
                cardIndex = i;
                break;
            }
        }
        
        if (cardIndex == -1) {
            return false; // Card not in hand
        }
        
        // Remove card from hand
        Card[] newHand = new Card[hand.length - 1];
        int newIndex = 0;
        for (int i = 0; i < hand.length; i++) {
            if (i != cardIndex) {
                newHand[newIndex] = hand[i];
                newIndex++;
            }
        }
        hand = newHand;
        
        // Add card to discard pile
        discardPile.addCard(card);
        return true;
    }
    
    /**
     * Returns a card from hand to the deck
     * @param card the card to return
     * @param deck the deck to add the card to
     * @return true if card was successfully returned, false otherwise
     * @throws IllegalArgumentException if card or deck is null
     */
    public boolean returnCard(Card card, Deck deck) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null");
        }
        if (deck == null) {
            throw new IllegalArgumentException("Deck cannot be null");
        }
        
        // Find and remove the card from hand
        int cardIndex = -1;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].equals(card)) {
                cardIndex = i;
                break;
            }
        }
        
        if (cardIndex == -1) {
            return false; // Card not in hand
        }
        
        // Remove card from hand
        Card[] newHand = new Card[hand.length - 1];
        int newIndex = 0;
        for (int i = 0; i < hand.length; i++) {
            if (i != cardIndex) {
                newHand[newIndex] = hand[i];
                newIndex++;
            }
        }
        hand = newHand;
        
        // Add card to deck
        deck.addCard(card);
        return true;
    }
    
    /**
     * Helper method to add a card to hand
     * @param card the card to add
     */
    private void addCardToHand(Card card) {
        Card[] newHand = new Card[hand.length + 1];
        for (int i = 0; i < hand.length; i++) {
            newHand[i] = hand[i];
        }
        newHand[hand.length] = card;
        hand = newHand;
    }
    
    /**
     * Returns a string representation of the player
     * @return formatted player information with name, age, and hand
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(name).append(", ").append(age);
        
        if (hand.length > 0) {
            result.append(", ");
            for (int i = 0; i < hand.length; i++) {
                result.append(hand[i].toString());
                if (i < hand.length - 1) {
                    result.append(", ");
                } else {
                    result.append(".");
                }
            }
        } else {
            result.append(".");
        }
        
        return result.toString();
    }
}