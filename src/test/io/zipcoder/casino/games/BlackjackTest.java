package io.zipcoder.casino.games;


import io.zipcoder.casino.player.BlackJackPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import io.zipcoder.casino.Handler;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.games.Blackjack;

public class BlackjackTest {

    @Test
    public void endGameTest() {
        Handler handler = new Handler();
        Player player = handler.createPlayer("Sally", 200.0);
        Blackjack blackjack = new Blackjack();


        Boolean expected = false;
        Boolean actual = player.getPlaying();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void calcBJPaymentTest() {
        Blackjack blackjack = new Blackjack();

        blackjack.setOdds(2.0);
        blackjack.setCurrentBet(100.0);

        Double expected = 200.0;
        Double actual = blackjack.calcPayment(blackjack.odds, blackjack.getCurrentBet());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void player1MoveTest() {
//        BlackJackPlayer blackJackPlayer = new BlackJackPlayer();
//        String playerChoice = "1";
//        Assert.assertTrue(Blackjack.player1Move(playerChoice));
    }

    @Test
    public void player1Move2Test() {
//    String playerChoice = "1";
//    Assert.assertTrue(Blackjack.player1Move(playerChoice));
    }

     @Test
    public void readyToPlayTest(){
//        Blackjack blackjack = new Blackjack();
//        String userInput = new String();
//        Assert.assertTrue(userInput.readyToPlay("Y"));
    }

    @Test
    public void dealHandTest(){
//        Blackjack blackjack = new Blackjack();
//
//        Integer expected =
//        Integer actual =
    }

    @Test
   public void updateAccount(){
//        Blackjack blackjack = new Blackjack();
//
//       blackjack.getBlackJackPlayer().setAccount(30.0);
//       Double expected = 30.0;
//       Double actual = blackjack.getBlackJackPlayer().getAccount();
//
//        Assert.assertEquals(expected, actual);

   }
}

