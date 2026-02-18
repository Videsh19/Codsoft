import java.util.Random;
import java.util.*;

interface Game
{
    void play();
}

abstract class Player
{
    protected String name;

    public Player(String name)
    {
        this.name=name;
    }

    public abstract int getGuess(Scanner sc);

    public String getName()
    {
        return name;
    }

}

class HumanPlayer extends Player {
    public HumanPlayer(String name)
    {
        super(name);
    }

    public int getGuess(Scanner sc)
    {
        System.out.print("enter your guess: ");
        return sc.nextInt();

    }

}

class NumberGame implements Game{
    private static final int MIN=1;
    private static final int MAX=100;
    private static final int MAX_ATTEMPTS=7;
    private Player player;
    private int score;
    private int roundsPlayed;

    public NumberGame(Player player)
    {
        this.player=player;
        this.score=0;
        this.roundsPlayed=0;
    }

    public void play()
    {
        Scanner sc=new Scanner(System.in);
        Random random=new Random();
        boolean playAgain =true;

        System.out.println("Welcome to the number guessing game !!!");

        while(playAgain)
        {
            int secretNumber=random.nextInt(MAX-MIN+1)+MIN;
            int attempts =0;
            boolean guessedCorrect =false;

            System.out.println("\n I have generated a number between "+MIN+"and "+MAX);
            System.out.println("you have "+MAX+"attempts ..");

            while(attempts < MAX_ATTEMPTS)
            {
                int guess=player.getGuess(sc);
                if (guess < MIN || guess > MAX) {
                    System.out.println("Please enter a number between " + MIN + " and " + MAX + ".");
                    continue;
                }

                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too Low!");
                } else if (guess > secretNumber) {
                    System.out.println("Too High!");
                } else {
                    System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                    score++;
                    guessedCorrect = true;
                    break;
                }

                System.out.println("Attempts left: " + (MAX_ATTEMPTS - attempts));
            }

            if (!guessedCorrect) {
                System.out.println(" You failed! The correct number was: " + secretNumber);
            }

            System.out.println("Current Score: " + score + "/" + roundsPlayed);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n===== Final Result =====");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Rounds Won: " + score);
        System.out.println("Thank you for playing!");
    }
            }



public class GameMain
{
    public static void main(String[]args)
    {
    Scanner sc=new Scanner(System.in);
    System.out.print("enter your name: ");
    String name=sc.nextLine();
    Player player =new HumanPlayer(name);
    Game game =new NumberGame(player);
    game.play();
    sc.close();
    }


}
        

