package io.zipcoder.casino.games;

import com.sun.javadoc.SourcePosition;
import io.zipcoder.casino.Handler;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.SlotsPlayer;
import io.zipcoder.casino.utilities.Console;

import java.lang.reflect.Array;
import java.util.Random;

public class Slots extends Games implements GamblerGameInterface {

    SlotsPlayer slotsPlayer;
    private Double currentBet;
    public Console console;
    private Double bet;
    private Double result;

    //public Player player;

    Integer random = 0;
    String[] characters = new String[]{"cherry ", "orange ", "bell   ", "bars   ", "apple  ", "seven  "};
    String[][] toSave = new String[3][3];




    public Slots() {
    }

    public Slots(SlotsPlayer player, Console console) {
        this.slotsPlayer = player;
        this.console = console;
    }

//////////////////////////////////////////Run Game/////////////////////////////////////////


    public void runGame() {
        display("Welcome to the slots " + slotsPlayer.player.getName() + "! \n");

        slotsPlayer.setPlaying(true);


        do {
        Double tempBet = console.getDoubleInput("How many lines would you like to bet? 1, 3 or 5?");

           //console.println(slotsPlayer.player.getAccount().toString());
            if (tempBet==1||tempBet==3||tempBet==5){
                bet = tempBet;
            }
              else{
                console.println("please, choose between 1 or 3 or 5");
                continue;

            }
            withdraw(bet);
            System.out.println(slotsPlayer.player.getAccount().toString());
            generateMatrix();

            double countPayLines = CheckWins(bet);

            if(countPayLines>0) {
                deposit(calcPayment1(bet, countPayLines)+bet);
            }

            System.out.println();
            System.out.println(slotsPlayer.player.getAccount().toString());
            System.out.println();
            String tryAgain = console.getStringInput("do you want to play again? choose between yes/no");



            if (tryAgain.equals("no")) {
                slotsPlayer.setPlaying(false);
            }

        } while (slotsPlayer.getPlaying().equals(true));



        endGame();

    }
//////////////////////////////Generate Matrix//////////////////////////////
   public void generateMatrix() {
//        Random rand = new Random();
       int max = characters.length;
       int min = 1;
       int range = max - min + 1;


       for (int i = 0; i <= 2; i++) {
           for (int j = 0; j <= 2; j++) {
//               int rand = (int) (Math.random() * range);
//               System.out.print(characters[rand]);
//               toSave[i][j] = characters[rand];
               Random rand = new Random();
               int n = rand.nextInt(range);
               System.out.print(characters[n]);
               toSave[i][j]=characters[n];

           }
           System.out.println();
       }

   }




///////////////////////////////////Check Wins////////////////////////////////////////////////////////

    public Double CheckWins(Double bet) {
        Double countPayLines = 0.0;



            if (bet >= 1) {
                if (toSave[1][0] == toSave[1][1] && toSave[1][1] == toSave[1][2]) {
                    System.out.println();
                    System.out.println("you won horizontal middle");
                    countPayLines++;

                }
            }
            if (bet >= 3) {
                if (toSave[0][0] == toSave[0][1] && toSave[0][1] == toSave[0][2]) {
                    System.out.println();
                    System.out.println("you won horizontal top");
                    countPayLines++;

                }
                if (toSave[2][0] == toSave[2][1] && toSave[2][1] == toSave[2][2]) {
                    System.out.println();
                    System.out.println("you won horizontal bottom");
                    countPayLines++;
                }
            }
            if (bet >= 5) {
                if (toSave[2][0] == toSave[1][1] && toSave[1][1] == toSave[0][2]) {
                    System.out.println();
                    System.out.println("you won diagonally right");
                    countPayLines++;
                }
                if (toSave[0][0] == toSave[1][1] && toSave[1][1] == toSave[2][2]) {
                    System.out.println();
                    System.out.println("you won diagonally left ");
                    countPayLines++;
                }

            }

        return countPayLines;
    }

////////////////////////////////////////////////account//////////////////////////////////////////////



    @Override
    void nextTurn() {
    }

    @Override
    void endGame() {
//        Handler handler = new Handler();
//        handler.run();
    }

    @Override
    boolean getResults() {
        return false;
    }

    @Override
    public void display(String output) {
        super.display(output);
    }


    ///////////////mine////////

    public Double calcPayment1(Double bet, Double countPayLines) {

        result =bet * countPayLines;
        System.out.println("You won "+ result+bet +"$");
      updateAccount(result);
        return result;

    }


//////////////////////////////account manipulations///////////////////////////////



    public Double getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(Double currentBet) {
        this.currentBet = currentBet;
    }


    public Double calcPayment(Double bet, Double odds) {
        return null;
    }

    public void withdraw(Double num) {
        Double tempAccount =  slotsPlayer.player.getAccount();
        slotsPlayer.player.setAccount(tempAccount-num);
    }

    public void deposit(Double num) {
        Double tempAccount =  slotsPlayer.player.getAccount();
        slotsPlayer.player.setAccount(tempAccount+num);
    }

    public void updateAccount(Double num) {



    }
}
