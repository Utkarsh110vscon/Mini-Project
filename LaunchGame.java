import java.util.*;

class Guesser{
    int guess_Num;

    int Guessing_theNum()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Guesser! Kindly guess th number.");
        guess_Num=sc.nextInt();
        return guess_Num;
    }
}

class Player
{
    int guess_Num;

   int GuessingTheNumber()
   {    
        Scanner sc= new Scanner(System.in);
        System.out.println("Kindly! guess the number.");
        guess_Num=sc.nextInt();
        return guess_Num;
    }
}

class Umpire
{
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;
    
     void CollectNumberFromGuesser()
    {
        Guesser g=new Guesser();
        numFromGuesser=g.Guessing_theNum();
    }

    int[] hint()
    {
        int array[]={0,0};
        array[0]=(numFromGuesser-10);
        array[1]=(numFromGuesser+10);
        return array;
    }
    
     void CollectNumberFromPlayer()
    {
        Player p1= new Player();
        Player p2= new Player();
        Player p3= new Player();

        int []arr=hint();
        System.out.println("Players! your range is from " + arr[0] + " to "+ arr[1]);

        numFromPlayer1=p1.GuessingTheNumber();
        numFromPlayer2=p2.GuessingTheNumber();
        numFromPlayer3=p3.GuessingTheNumber();

    }

     void reinitiate()
    {
        Player p1= new Player();
        Player p2= new Player();
        Player p3= new Player();

        numFromPlayer1=p1.GuessingTheNumber();
        numFromPlayer2=p2.GuessingTheNumber();
        numFromPlayer3=p3.GuessingTheNumber();
        
        compare();

    }

     void compare()
    {
        if(numFromGuesser==numFromPlayer1)
        {
            if(numFromGuesser==numFromPlayer2&&numFromGuesser==numFromPlayer3)
            {
                System.out.println("Game Tied! it will restart again");
                System.out.println("Players guess the number one more time!");
                reinitiate();
            }
            else if(numFromGuesser==numFromPlayer2)
            {
                System.out.println("Player1 and Player2 both won the game!");
            }
            else if(numFromGuesser==numFromPlayer3)
            {
                System.out.println("Player1 as well as Player3 won the game");
            }else
            {
                System.out.println("Player1! is the winner.");
            }
        } 
        else if(numFromGuesser==numFromPlayer2)
        {
            if(numFromGuesser==numFromPlayer3)
            {
                System.out.println("Player2 and Player3 both won the game");
            }else
            {
                System.out.println("Player2! is the winner.");
            }
        }
         else if(numFromGuesser==numFromPlayer3)
         {
            System.out.println("Player3! is the winner.");
        }
        else
        {
            System.out.println("Game Over!'None of the player's guess was correct");
        }
    }

}

public class LaunchGame 
{
    public static void main(String[]args){
        System.out.println("Game Started!");
        Umpire u= new Umpire();
        u.CollectNumberFromGuesser();
        u.CollectNumberFromPlayer();
        u.compare();
    }
}
