package io.zipcoder.casino.games;

import io.zipcoder.casino.gameTools.Card;
import io.zipcoder.casino.player.BlackJackPlayer;
import io.zipcoder.casino.gameTools.Deck;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;

public class Blackjack extends Games implements GamblerGameInterface {

    BlackJackPlayer player1;
    BlackJackPlayer dealer = new BlackJackPlayer(new Player());

    private Integer player1Score;
    private Integer dealerScore;
    private Double currentBet;
    private String userInput;
    private Deck deck = new Deck();
    private ArrayList<Card> hand1 = new ArrayList<Card>();
    private ArrayList<Card> hand2 = new ArrayList<Card>();
    Console console;


    public Blackjack() {
        super();
        this.odds = 2.0;
        this.player1Score = 0;
        this.dealerScore = 0;
        this.currentBet = 0.0;
        this.userInput = "";

    }

    public Blackjack(BlackJackPlayer player, Console console) {
        super();
        this.player1 = player;
        this.console = console;
        this.odds = 2.0;
        this.player1Score = 0;
        this.dealerScore = 0;
        this.currentBet = 0.0;
        this.userInput = "";


    }

    /**
     * 1)Prompt Player;
     * 2)Run Game;
     * 3)Deal;
     * 4)Prompt Player;
     * 4a) Stay();
     * 4b) Hit();
     * b1) keep playing;
     * b2) bust/lose;
     * 5) DealerTurn
     * 6) Handle Winning/Loses
     */

    ArrayList<Card> playerHand = hand1;
    ArrayList<Card> dealerHand = hand2;


    public void beginGame() {
        console.println("Welcome to Blackjack!");
        String userInput = console.getStringInput("Ready to play? Y/N");
        while (readyToPlay(userInput)) {
            currentBet = console.getDoubleInput("Please place your current bet.");
            dealHand();
            player1Turn();
            dealerTurn();
        }
        getWinner();
    }

    public String seeHand(BlackJackPlayer player) {
        String hand = "";
        for (Card c : player.getHand()
        ) {
            hand += c.getCardValue() + " of " + c.getSuit() + " ==== ";
        }
        return hand;

    }

    public void dealHand() {
        deck.deal(2, player1);
        deck.deal(2, dealer);
    }

    public void player1Turn() {
        seeHand(player1);
        String playerChoice = console.getStringInput("What do you want to do? Pick 1 for hit and 2 for stay.");
        if ((player1Move(playerChoice))) {
            deck.dealSingleCard(player1);
        }
        seeHand(player1);

        String playerChoice2 = console.getStringInput("What do you want to do? Pick 1 for hit and 2 for stay.");
        if ((player1Move2(playerChoice2))) {
            deck.dealSingleCard(player1);
        }
    }

    public boolean player1Move(String playerChoice) {
        if (userInput.equalsIgnoreCase("1")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean player1Move2(String playerChoice2) {
        if (userInput.equalsIgnoreCase("1")) {
            return true;
        } else {
            return false;
        }

    }


    public void dealerTurn() {
        seeHand(dealer);
        if (countPlayerHand() < countDealerHand()) {
            getWinner();
        } else {
            deck.dealSingleCard(dealer);
            if (countPlayerHand() < countDealerHand()) {
                deck.dealSingleCard(dealer);
            }
        }

    }

    public Integer countPlayerHand() {
        int sum = 0;
        for (Card i : playerHand) {
            Integer result = i.getCardValue().getCardIntegerValue();
            sum += result;
        }
        return sum;
    }

    public Integer countDealerHand() {
        int sum = 0;
        for (Card i : dealerHand) {
            Integer result = i.getCardValue().getCardIntegerValue();
            sum += result;
        }
        return sum;
    }

    public void getWinner() {
        if (countPlayerHand() > 21) {
            console.println("Sorry, you lose");
        } else if ((countPlayerHand() < countDealerHand()) && (countDealerHand() <= 21)) {
            console.println("Sorry, you lose.");
        } else if ((countPlayerHand() == 21) && (countDealerHand() == 21)) {
            // push();
        } else if ((countPlayerHand() > countDealerHand()) && (countPlayerHand() <= 21)) {
            console.println("Congrats! You win this round.");
        } else if (countDealerHand() > 21) {
            console.println("Congrats! You win this round.");
        }

    }

    public boolean readyToPlay(String userInput) {
        if (userInput.equalsIgnoreCase("Y")) {
            return true;
        } else {
            return false;
        }
    }

    public void dealerWin() {

    }

    ;

    public void playerWin() {

    }

    ;

    public double getCurrentBet() {
        return currentBet;
    }

    public void playerAccount(){
        double playerAccount = 0;
    }

    public Integer calcPayment(Integer bet, Integer odds) {
        return null;
    }

    public void updateAccount(Integer num) {
    }

    public void currentHand() {
    }

    ;

    public void stay() {
    }

    ;

    public void split() {
    }

    ;

    public void doubleDown() {
    }

    ;

    public void hit() {
        deck.dealSingleCard(player1);
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


    /**
     * public BlackJackPlayer getBlackJackPLayer() {
     * <p>
     * return blackJackPlayer;
     * }
     */


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

    public void getBlackJackPlayer() {
    }

    ;

    @Override
    boolean getResults() {
        return false;
    }
}
