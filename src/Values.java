public enum Values {
    
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(10, "JACK"),
    QUEEN(10, "QUEEN"),
    KING(10, "KING"),
    ACE(11, "ACE");

    public int value;
    public String name;

    private Values(int value, String name){
        this.value = value;
        this.name = name;
    }
    
}
