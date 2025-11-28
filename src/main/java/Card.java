public class Card {
    private String name;
    private String suit;
    private int value;
    
    // Constructor that takes three parameters (name, suit, and value)
    public Card(String name, String suit, int value) {
        this.name = name;
        this.suit = suit;
        this.value = value;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getSuit() {
        return suit;
    }
    
    public int getValue() {
        return value;
    }

    // toString() - returns "Name of Suit" format
    @Override
    public String toString() {
        return this.name + " of " + this.suit;
    }
     // equals() - checks if two cards have same name, suit, and value
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