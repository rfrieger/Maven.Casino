package io.zipcoder.casino.games;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Deck;
import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.player.BlackJackPlayerNPC;

public class Blackjack extends CardGames implements GamblerGameInterface {
    BlackJackPlayer player1 = new BlackJackPlayer();
    BlackJackPlayerNPC player2 = new BlackJackPlayerNPC();
    Deck deck = new Deck();
    private Integer player1Score;
    private Integer player2Score;


    public Integer calcPayment(Integer bet, Integer odds) {
        return null;
    }

    public void updateAccount(Integer num) {

    }

    public void stay() {};

    public void spilt() {};

    public void doubleDown(){};

    public Card hit() {
        return null;
    }

    public Integer getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(Integer player1Score) {
        this.player1Score = player1Score;
    }

    public Integer getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(Integer player2Score) {
        this.player2Score = player2Score;
    }


}