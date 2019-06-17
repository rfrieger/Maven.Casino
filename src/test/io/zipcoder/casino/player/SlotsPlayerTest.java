package io.zipcoder.casino.player;

import io.zipcoder.casino.games.Slots;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SlotsPlayerTest {

    @Test
    public void getAccount() {
        Player player = new Player();
        SlotsPlayer slotsPlayer = new SlotsPlayer(player);
        Console console = new Console(System.in, System.out);
        Slots slots = new Slots(slotsPlayer, console);

        player.setAccount(200.0);
        Double expected = 200.0;

        Double actual = player.getAccount();

        Assert.assertEquals(expected,actual);

    }


}