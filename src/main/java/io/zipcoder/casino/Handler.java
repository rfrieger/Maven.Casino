package io.zipcoder.casino;
import io.zipcoder.casino.games.*;
import io.zipcoder.casino.player.*;
import io.zipcoder.casino.utilities.Console;

import java.util.Scanner;


//
public class Handler {
    public Console console = new Console(System.in, System.out);
    public Player player;
    private Integer integerInput;
    private String name = "";
    private Double account = 0.0;
    private Double tempDeposit;



public void run() {
    console.println("WELCOME TO THE CASINO\n");
    getNameInput();
    getAccountBalanceInput();
    createPlayer(name, tempDeposit);

while (true) {
    System.out.println("\n PICK FROM ONE OF OUR GAMES \n \n  blackjack[0] --  go fish[1] -- roulette[2] -- craps[3] -- slots[4] \n");
    getGameInput();




    switch (integerInput) {
        case 0:
            BlackJackPlayer blackJackPlayer = new BlackJackPlayer(player);
            Blackjack blackjack = new Blackjack(blackJackPlayer, console);
            blackjack.beginGame();
            break;
        case 1:
            GoFishPlayer goFishPlayer = new GoFishPlayer(player);
            GoFish goFish = new GoFish(goFishPlayer, console);
            goFish.runGame();
            break;
        case 2:
            RoulettePlayer roulettePlayer = new RoulettePlayer(player.getName(), player.getAccount());
            Roulette roulette = new Roulette(roulettePlayer);
            Scanner scanner = new Scanner(System.in);
            boolean isNextRound = false;
            do {
                roulette.runGame();
                player.setAccount(roulettePlayer.getAccount());
                String continuePlaying = console.getStringInput("Do you want to continue playing (Y/N)?");
                if (continuePlaying != null && continuePlaying.equalsIgnoreCase("Y")) {
                    isNextRound = true;
                } else {
                    isNextRound = false;
                }
            } while (isNextRound);
            break;
        case 3:
            CrapsPlayer crapsPlayer = new CrapsPlayer(player);
            Craps craps = new Craps(crapsPlayer, console);
            craps.runGame();
            break;
        case 4:
            SlotsPlayer slotsPlayer = new SlotsPlayer(player);
            Slots slots = new Slots(slotsPlayer, console);
            slots.runGame();
            break;
        default:

            System.out.println("you blew it");
        }
    }
}

    public Player createPlayer (String name, Double account) {
        return player = new Player(name, account);
    }

    public void getNameInput() {
        this.name = console.getStringInput("Enter Name");
    }

    public void getAccountBalanceInput() {
       this.tempDeposit = console.getDoubleInput("How much do you want to deposit in your account?");
    }

    public Boolean testAccountInput (Double tempDeposit) {
        if (tempDeposit > 0 && tempDeposit < Double.MAX_VALUE) {
            return true;
        } else
            return false;
    }

    public void getGameInput() {
        this.integerInput = console.getIntegerInput("What game would you like to play?");
    }

}
//