import java.util.Random;

public class Deck {
    private Card[] cards;
    
    // Constructor 1: Takes an existing array of cards
    public Deck(Card[] cards) {
        this.cards = cards;
    }
    
    // Constructor 2: Creates a full unshuffled deck (52 cards)
    public Deck() {
        this.cards = generateFullDeck();
    }
    
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
    
    // size() - returns number of cards in deck
    public int size() {
        return cards.length;
    }
    
    // draw() - removes and returns the top card (first card in array)
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
    
    // shuffle() - randomly rearranges the cards
    public void shuffle() {
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
      // addCard() - adds a single card to the deck (if not null)
    public void addCard(Card card) {
        if (card == null) {
            return; // Don't add null cards
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
    
    // reshuffle() - adds all cards from array and then shuffles
    public void reshuffle(Card[] newCards) {
        if (newCards == null) {
            return; // Nothing to add
        }
        
        // Create a new array that can hold all cards
        Card[] combinedDeck = new Card[cards.length + newCards.length];
        
        // Copy existing cards
        for (int i = 0; i < cards.length; i++) {
            combinedDeck[i] = cards[i];
        }
        
        // Add new cards (skip null ones)
        int currentIndex = cards.length;
        for (Card card : newCards) {
            if (card != null) {
                combinedDeck[currentIndex] = card;
                currentIndex++;
            }
        }
        
        // If we skipped null cards, we need to resize the array
        if (currentIndex < combinedDeck.length) {
            Card[] finalDeck = new Card[currentIndex];
            for (int i = 0; i < currentIndex; i++) {
                finalDeck[i] = combinedDeck[i];
            }
            cards = finalDeck;
        } else {
            cards = combinedDeck;
        }
        
        // Shuffle the deck after adding cards
        shuffle();
    }
    
    // Getter for the deck
    public Card[] getCards() {
        return cards;
    }
}