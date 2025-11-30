/**
 * Represents a playing card with a name, suit, and numeric value
 * @author Parusan
 * @version 1.0
 */
public class Card {
    private String name;
    private String suit;
    private int value;
     /**
     * Constructs a new Card with the specified attributes
     * @param name the name of the card (e.g., "Ace", "King", "2")
     * @param suit the suit of the card (e.g., "Hearts", "Spades")
     * @param value the numeric value of the card (must be positive)
     * @throws IllegalArgumentException if name/suit are null/empty or value is not positive
     */
    
    public Card(String name, String suit, int value) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Card name cannot be null or empty");
        }
        if (suit == null || suit.trim().isEmpty()) {
            throw new IllegalArgumentException("Card suit cannot be null or empty");
        }
        if (value < 1) {
            throw new IllegalArgumentException("Card value cannot be negative or zero");
        }
        
        this.name = name.trim();
        this.suit = suit.trim();
        this.value = value;
    }
    
    /**
     * Returns the name of the card
     * @return the card's name as a String
     */
    public String getName() {
        return name;
    }
     /**
     * Returns the suit of the card
     * @return the card's suit as a String
     */
    
    public String getSuit() {
        return suit;
    }
     /**
     * Returns the numeric value of the card
     * @return the card's value as an integer
     */
    
    public int getValue() {
        return value;
    }
     /**
     * Returns a string representation of the card in "Name of Suit" format
     * @return the formatted card description
     */

   
    @Override
    public String toString() {
        return this.name + " of " + this.suit;
    }
    /**
     * Compares this card with another object for equality
     * @param obj the object to compare with
     * @return true if the cards have the same name, suit, and value
     */
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Card otherCard = (Card)obj;
        return this.name.equals(otherCard.name) && 
               this.suit.equals(otherCard.suit) && 
               this.value == otherCard.value;
    }
}