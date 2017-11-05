package dice_game;


import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Write a program that plays a simple dice game between the computer and the user.
 * When the program runs, a loop should repeat
 * 10 times. Each iteration of the loop should do the following:
 * <p>
 * •  Generate a random integer in the range of 1 through 6.
 * This is the value of the computer’s die.
 * •  Generate another random integer in the range of 1 through 6.
 * This is the value of the user’s die.
 * •  The die with the highest value wins.
 * (In case of a tie, there is no winner for that particular roll of the dice.)
 * <p>
 * As the loop iterates, the program should keep count of the number of
 * times the computer wins,
 * and the number of times that the user wins. After the loop performs
 * all of its iterations, the program should
 * display who was the grand winner, the computer or the user.
 */

public class DiceGame {

    private int computerDie;
    private int userDie;

    public void playDiceGame() throws Exception {
        System.out.println("Game starts...");
        int round = 0;
        int roundsWonComputer = 0;
        int roundsWonUser = 0;
        int roundsTie = 0;

        while (round <= 9) {
            System.out.println("Round: " + (round+1));

            computerDie = generateRandomNumber();
            userDie = generateRandomNumber();

            if(computerDie == userDie) {
                System.out.println("It's a tie! Nobody wins.");
                roundsTie++;
            }
            else if(computerDie > userDie) {
                System.out.println("Computer wins!");
                roundsWonComputer++;
            }
            else if(computerDie < userDie) {
                System.out.println("User wins!");
                roundsWonUser++;
            }
            else throw new Exception("ERROR! What just happened?!");

            round++;
        }

        System.out.println("Rounds won by computer:\n" + roundsWonComputer);
        System.out.println("Rounds won by user:\n" + roundsWonUser);
        System.out.println("Rounds tie:\n" + roundsTie);

        if(roundsWonComputer > roundsWonUser) {
            System.out.println("Computer Wins!");
        }
        else if(roundsWonComputer > roundsWonUser) {
            System.out.println("User Wins!");
        }
        else if(roundsWonComputer == roundsWonUser) {
            System.out.println("Nobody Wins!");
        }

    }

    public int generateRandomNumber() {
        int min = 0;
        int max = 6;
        int randomNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNumber;

    }

    public static void main(String[] args) throws IOException {
        DiceGame dg = new DiceGame();
        try {
            dg.playDiceGame();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
