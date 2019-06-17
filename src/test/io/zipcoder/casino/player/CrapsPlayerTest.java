package io.zipcoder.casino.player;

import io.zipcoder.casino.gameTools.Dice;
import io.zipcoder.casino.games.Craps;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsPlayerTest {
    Player player = new Player("boo", 1000.0);
    CrapsPlayer crapsPlayer = new CrapsPlayer(player);
    Craps craps = new Craps();


    @Test
    public void roll1() {
        Integer result = crapsPlayer.roll();
        Assert.assertTrue(result <= 12 && result >=2);
    }

    @Test
    public void bet() {
        crapsPlayer.bet(2.0);
        Double expected = 2.0;
        Double actual = crapsPlayer.betVal;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void betType() {
        crapsPlayer.betType("2");
        String expected = "2";
        String actual = crapsPlayer.betTypeVal;

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void cashout1() {
        crapsPlayer.player.setPlaying(true);
        crapsPlayer.cashout();

         Boolean expected = false;
         boolean actual = crapsPlayer.player.getPlaying();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void cashout2() {
        crapsPlayer.player.setPlaying(true);


        Boolean expected = true;
        boolean actual = crapsPlayer.player.getPlaying();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void displayAccoutBal() {

        Double expected = 0.0;
        Double actual = crapsPlayer.getAccount();

        Assert.assertEquals(expected, actual);
    }
}