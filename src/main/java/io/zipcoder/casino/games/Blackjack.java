package io.zipcoder.casino.games;

import io.zipcoder.casino.gameTools.Card;
import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.gameTools.Deck;
import io.zipcoder.casino.gameTools.BlackJackInput;

import java.util.ArrayList;

public class Blackjack extends CardGames implements GamblerGameInterface {

    BlackJackPlayer player1 = new BlackJackPlayer();
    BlackJackPlayer dealer = new BlackJackPlayer();

    private Integer player1Score;
    private Integer dealerScore;
    private Double currentBet;
    private Deck deck = new Deck();

    public Blackjack() {
        super();
        this.odds = 2.0;
        this.player1Score = 0;
        this.dealerScore = 0;
        this.currentBet = 0.0;


    }

    public void beginGame(){
        deck.deal(2, player1);
        deck.deal(2, dealer);
        ArrayList<Card> playerHand = player1.getHand();
        ArrayList<Card> dealerHand = dealer.getHand();
    }


    public Integer countPlayerHand(){
        int sum = 0;
        for(Card i : player1.getHand()){
            Integer result = i.getCardValue().getCardIntegerValue();
            sum += result;
        }
        return sum;
    }

    public Integer countDealerHand(){
        int sum = 0;
        for(Card i : player1.getHand()){
            Integer result = i.getCardValue().getCardIntegerValue();
            sum += result;
        }
        return sum;
    }

    public void getWinner(){
        if(countPlayerHand() > 21){
            dealerWin();
        } else if ((countPlayerHand() < countDealerHand()) && (countDealerHand() <=21)){
            dealerWin();
        } else if ((countPlayerHand() == 21) && (countDealerHand() == 21)){
           // push();
        } else if ((countPlayerHand() > countDealerHand()) && (countPlayerHand() <=21)){
            playerWin();
        } else if (countDealerHand() > 21){
            playerWin();
        }

    }

    public Integer calcPayment(Integer bet, Integer odds) {
        return null;
    }

    public void updateAccount(Integer num) {}

    public void currentHand(){};

    public void dealerWin(){};

    public void playerWin(){};
    //enums for the below

    public void stay() {};

    public void split() {};

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
        return dealerScore;
    }

    public void setPlayer2Score(Integer dealerScore) {
        this.dealerScore = dealerScore;
    }

    public void setCurrentBet(Double currentBet) {

        this.currentBet = currentBet;
    }

    public double getCurrentBet(){
        return currentBet;
    }

   /** public BlackJackPlayer getBlackJackPLayer() {

       return blackJackPlayer;
    } */




    @Override
    void nextTurn() {

    }

    @Override
    void endGame() {

    }

    public Double calcPayment(Double bet, Double odds) {
        return null;
    }

    public void withdraw(Double num) {

    }

    public void deposit(Double num) {

    }

    public void getBlackJackPlayer(){};
}
