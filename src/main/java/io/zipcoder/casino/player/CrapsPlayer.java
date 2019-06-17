package io.zipcoder.casino.player;

import io.zipcoder.casino.gameTools.Dice;

public class CrapsPlayer extends Player implements GamblerInterface {
    public Player player;
    public String  betTypeVal = "";
    public Double betVal = 0.0;

    public CrapsPlayer(){};

    public CrapsPlayer(Player player){
        this.player = player;
    }

    public Integer roll() {
        Dice dice = new Dice();

        return dice.rollDice();
    }

    public void bet(Double bet) {
        this.betVal = bet;

    }

    public void betType(String betType) {
        this.betTypeVal = betType;

    }

    public void cashout() {
        this.player.setPlaying(false);
    }

    public void displayAccoutBal() {
        System.out.println(player.getAccount());
    }
}
