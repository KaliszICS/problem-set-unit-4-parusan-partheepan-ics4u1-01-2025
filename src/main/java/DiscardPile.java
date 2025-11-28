public class DiscardPile {
    private Card[] cards;
    
    // Constructor 1: Takes an existing array of cards
    public DiscardPile(Card[] cards) {
        this.cards = cards;
    }
    
    // Constructor 2: Creates an empty discard pile
    public DiscardPile() {
        this.cards = new Card[0]; // Empty array
    }
    
    // Getter for the discard pile
    public Card[] getCards() {
        return cards;
    }
    
    // Basic method to get the size
    public int size() {
        return cards.length;
    }
}

