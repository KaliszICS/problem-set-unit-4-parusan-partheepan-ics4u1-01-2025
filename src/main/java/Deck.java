import java.util.Random;

/**
 * Represents a deck of playing cards with shuffle, draw, and management capabilities
 * @author Parusan
 * @version 1.0
 */
public class Deck {
    private Card[] cards;
    
    /**
     * Constructs a deck from an existing array of cards
     * @param cards the array of cards to initialize the deck with
     * @throws IllegalArgumentException if the card array is null
     */
    public Deck(Card[] cards) {
        if (cards == null) {
            throw new IllegalArgumentException("Card array cannot be null");
        }
        this.cards = cards;
    }
    
    /**
     * Constructs a standard 52-card deck with all suits and ranks
     */
    public Deck() {
        this.cards = generateFullDeck();
    }
    
    /**
     * Generates a complete standard deck of 52 playing cards
     * @return an array containing all 52 standard playing cards
     */
    private Card[] generateFullDeck() {
        Card[] fullDeck = new Card[52];
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int[] values = {14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        
        int cardIndex = 0;
        
        for (String suit : suits) {
            for (int i = 0; i < names.length; i++) {
                fullDeck[cardIndex] = new Card(names[i], suit, values[i]);
                cardIndex++;
            }
        }
        
        return fullDeck;
    }
    
    /**
     * Returns the number of cards currently in the deck
     * @return the size of the deck as an integer
     */
    public int size() {
        return cards.length;
    }
    
    /**
     * Removes and returns the top card from the deck
     * @return the top card, or null if the deck is empty
     */
    public Card draw() {
        if (cards.length == 0) {
            return null; // No cards left
        }
        
        // Get the top card (first element)
        Card topCard = cards[0];
        
        // Create a new array without the top card
        Card[] newDeck = new Card[cards.length - 1];
        for (int i = 0; i < newDeck.length; i++) {
            newDeck[i] = cards[i + 1]; // Shift all cards down
        }
        
        // Replace the old deck with the new smaller deck
        cards = newDeck;
        return topCard;
    }
    
    /**
     * Randomly shuffles the order of cards in the deck using Fisher-Yates algorithm
     * @throws IllegalStateException if attempting to shuffle an empty deck
     */
    public void shuffle() {
        if (cards.length == 0) {
            throw new IllegalStateException("Cannot shuffle an empty deck");
        }
        
        Random random = new Random();
        
        // Fisher-Yates shuffle algorithm
        for (int i = cards.length - 1; i > 0; i--) {
            // Pick a random index from 0 to i
            int randomIndex = random.nextInt(i + 1);
            
            // Swap cards[i] with cards[randomIndex]
            Card temp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
    }
    
    /**
     * Adds a single card to the bottom of the deck
     * @param card the card to add to the deck
     * @throws IllegalArgumentException if the card is null
     */
    public void addCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Cannot add null card to deck");
        }
        
        // Create a new array that's one card larger
        Card[] newDeck = new Card[cards.length + 1];
        
        // Copy all existing cards
        for (int i = 0; i < cards.length; i++) {
            newDeck[i] = cards[i];
        }
        
        // Add the new card at the end
        newDeck[cards.length] = card;
        
        // Replace the old deck with the new larger deck
        cards = newDeck;
    }
    
    /**
     * Returns the current array of cards in the deck
     * @return an array containing all cards in the deck
     */
    public Card[] getCards() {
        return cards;
    }
}