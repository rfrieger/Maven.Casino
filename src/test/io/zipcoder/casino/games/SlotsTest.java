package io.zipcoder.casino.games;

import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.PlayerTest;
import io.zipcoder.casino.player.SlotsPlayer;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SlotsTest {

    @Test
    public void runGame() {
    }

    @Test
    public void generateRandomTest(){

    }
    @Test
    public void checkWinsTest() {
        Slots slots = new Slots();
        slots.generateMatrix();
        Double actual = slots.CheckWins(5.0);
        Double expected = 5.0;

        Assert.assertTrue(actual<=expected);
    }

    @Test
    public void checkWinsTest2() {
        Slots slots = new Slots();
        slots.generateMatrix();
        Double actual = slots.CheckWins(3.0);
        Double expected = 3.0;

        Assert.assertTrue(actual<=expected);
    }

    @Test
    public void checkWinsTest3() {
        Slots slots = new Slots();
        slots.generateMatrix();
        Double actual = slots.CheckWins(1.0);
        Double expected = 1.0;

        Assert.assertTrue(actual<=expected);
    }

    @Test
    public void nextTurn() {
    }

    @Test
    public void endGame() {
    }

    @Test
    public void getResults() {
    }

    @Test
    public void display() {
    }

    @Test
    public void calcPayment1() {
    Slots slots = new Slots();
    Double expected = slots.calcPayment1(3.0, 3.0);
    Double actual = 9.0 ;

    Assert.assertEquals(actual, expected);
    }

    @Test
    public void setCurrentBet() {
    }

    @Test
    public void withdraw() {
        Player player = new Player();
        SlotsPlayer slotsPlayer = new SlotsPlayer(player);
        Console console = new Console(System.in, System.out);
        Slots slots = new Slots(slotsPlayer, console);

        slots.slotsPlayer.player.setAccount(200.0);
        slots.withdraw(220.0);
        Double expected = -20.0;

        Double actual = slots.slotsPlayer.player.getAccount();

        Assert.assertEquals(expected,actual);

    }
}