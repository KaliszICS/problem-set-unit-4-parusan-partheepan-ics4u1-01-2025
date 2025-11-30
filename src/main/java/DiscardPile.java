/**
 * Represents a discard pile for card games where used cards are placed
 * @author Parusan
 * @version 1.0
 */
public class DiscardPile {
    private Card[] cards;
    
    /**
     * Constructs a discard pile from an existing array of cards
     * @param cards the array of cards to initialize the discard pile with
     */
    public DiscardPile(Card[] cards) {
        this.cards = cards;
    }
    
    /**
     * Constructs an empty discard pile
     */
    public DiscardPile() {
        this.cards = new Card[0]; // Empty array
    }
    
    /**
     * Returns the current array of cards in the discard pile
     * @return an array containing all cards in the discard pile
     */
    public Card[] getCards() {
        return cards;
    }
    
    /**
     * Returns the number of cards currently in the discard pile
     * @return the size of the discard pile as an integer
     */
    public int size() {
        return cards.length;
    }
    
    /**
     * Adds a card to the discard pile
     * @param card the card to add to the discard pile
     */
    public void addCard(Card card) {
        if (card == null) {
            return; // Don't add null cards
        }
        
        // Create a new array that's one card larger
        Card[] newPile = new Card[cards.length + 1];
        
        // Copy all existing cards
        for (int i = 0; i < cards.length; i++) {
            newPile[i] = cards[i];
        }
        
        // Add the new card at the end
        newPile[cards.length] = card;
        
        // Replace the old pile with the new larger pile
        cards = newPile;
    }
    
    /**
     * Removes a specific card from the discard pile and returns it
     * @param card the card to remove from the discard pile
     * @return the removed card, or null if the card was not found
     */
    public Card removeCard(Card card) {
        if (card == null || cards.length == 0) {
            return null; // Nothing to remove
        }
        
        // Find the card in the pile
        int cardIndex = -1;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals(card)) {
                cardIndex = i;
                break;
            }
        }
        
        if (cardIndex == -1) {
            return null; // Card not found
        }
        
        // Store the card to return
        Card removedCard = cards[cardIndex];
        
        // Create a new array without the removed card
        Card[] newPile = new Card[cards.length - 1];
        
        // Copy all cards except the removed one
        int newIndex = 0;
        for (int i = 0; i < cards.length; i++) {
            if (i != cardIndex) {
                newPile[newIndex] = cards[i];
                newIndex++;
            }
        }
        
        // Replace the old pile with the new smaller pile
        cards = newPile;
        return removedCard;
    }
    
    /**
     * Removes and returns all cards from the discard pile, emptying it
     * @return an array containing all cards that were in the discard pile
     */
    public Card[] removeAll() {
        if (cards.length == 0) {
            return new Card[0]; // Return empty array
        }
        
        // Store all current cards to return
        Card[] allCards = cards;
        
        // Empty the discard pile
        cards = new Card[0];
        
        return allCards;
    }
    
    /**
     * Returns a formatted string representation of all cards in the discard pile
     * @return a comma-separated list of cards with a period at the end
     */
    @Override
    public String toString() {
        if (cards.length == 0) {
            return "Empty discard pile";
        }
        
        StringBuilder result = new StringBuilder();
        
        // Add each card to the string
        for (int i = 0; i < cards.length; i++) {
            result.append(cards[i].toString()); // "Ace of Hearts" format
            
            // Add comma and space if not the last card
            if (i < cards.length - 1) {
                result.append(", ");
            } else {
                result.append("."); // Period at the end
            }
        }
        
        return result.toString();
    }
}