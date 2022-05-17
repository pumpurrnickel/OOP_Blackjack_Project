public enum Suits {
    
    DIAMONDS("DIAMONDS"),
    HEARTS("HEARTS"),
    SPADES("SPADES"),
    CLUBS("CLUBS");

    public String suitName;

    private Suits(String suitName){
        this.suitName = suitName;
    }

}
