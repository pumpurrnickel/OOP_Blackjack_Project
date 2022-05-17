public class Card {

	private Suits suit;
	private Values value;
	
	public Card(Suits suit, Values value) {
		this.value = value;
		this.suit = suit;
	}
	public String toString() {
		return this.value.toString() + " of " + this.suit.toString();
	}
	public Values getValue() {
		return this.value;
	}
	
}

