package io.zipcoder.casino.games;

import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.PlayerTest;
import io.zipcoder.casino.player.SlotsPlayer;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SlotsTest {

    @Test
    public void runGame() {
    }

    @Test
    public void generateRandomTest(){
//        Slots slots = new Slots();
//
//
//        String actual = Random rand = new Random();
//        String expected = rand.setSeed(1);
    }
    @Test
    public void checkWinsTest() {
        for (int i= 0; i<10000; i++) {
            Slots slots = new Slots();
            slots.generateMatrix();
            Double actual = slots.CheckWins(5.0);
            Double expected = 5.0;

            Assert.assertTrue(actual <= expected);
        }
    }

    @Test
    public void checkWinsTest2() {
        for (int i= 0; i<10000; i++) {
            Slots slots = new Slots();
            slots.generateMatrix();
            Double actual = slots.CheckWins(3.0);
            Double expected = 3.0;

            Assert.assertTrue(actual <= expected);
        }
    }

    @Test
    public void checkWinsTest3() {
        for (int i= 0; i<10000; i++) {
            Slots slots = new Slots();
            slots.generateMatrix();
            Double actual = slots.CheckWins(1.0);
            Double expected = 1.0;

            Assert.assertTrue(actual <= expected);
        }
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
    public void withdrawTest() {
        Player player = new Player();
        SlotsPlayer slotsPlayer = new SlotsPlayer(player);
        Console console = new Console(System.in, System.out);
        Slots slots = new Slots(slotsPlayer, console);

        slots.slotsPlayer.player.setAccount(200.0);
        slots.withdraw(20.0);
        Double expected = 180.0;

        Double actual = slots.slotsPlayer.player.getAccount();

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void depositTest(){
        Player player = new Player();
        SlotsPlayer slotsPlayer = new SlotsPlayer(player);
        Console console = new Console(System.in, System.out);
        Slots slots = new Slots(slotsPlayer, console);

        slots.slotsPlayer.player.setAccount(100.0);
        slots.deposit(13.0);
        Double expected = 113.00;

        Double actual = slots.slotsPlayer.player.getAccount();

        Assert.assertEquals(expected, actual);
    }

}