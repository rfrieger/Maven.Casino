package io.zipcoder.casino.gameTools;

public enum CardValue {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(11);

    private Integer cardValue;

    CardValue(Integer cardValue) {
        this.cardValue = cardValue;
    }
    public Integer getCardIntegerValue() {
        return cardValue;
    }

}
