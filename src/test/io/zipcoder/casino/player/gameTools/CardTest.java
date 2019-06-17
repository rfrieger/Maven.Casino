package io.zipcoder.casino.player.gameTools;


import io.zipcoder.casino.gameTools.Card;
import io.zipcoder.casino.gameTools.CardValue;
import io.zipcoder.casino.gameTools.Deck;
import io.zipcoder.casino.gameTools.Suit;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    Deck deck = new Deck();

    @Test
    public void getCardValueAce() {
        Card card = deck.getDeck().pop();
        Assert.assertEquals("ACE", CardValue.ACE.name());
    }
    @Test
    public void getCardValueTwo() {
        Card card = deck.getDeck().pop();
        Assert.assertEquals("TWO",CardValue.TWO.name());
    }

    @Test
    public void getSuitSpades() {
        Card card = deck.getDeck().pop();
        Assert.assertEquals("SPADES", Suit.SPADES.name());
    }
    @Test
    public void getSuitHearts() {
        Card card = deck.getDeck().pop();
        Assert.assertEquals("HEARTS",Suit.HEARTS.name());
    }
    @Test
    public void checkObjectTest(){
        Object card = deck.getDeck().pop();
        Assert.assertTrue(card instanceof Card);
    }

}