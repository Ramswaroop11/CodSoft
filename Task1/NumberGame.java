//If u want to win this game u need to follow binary searching technique which helps you to find the exact number.
// How it works  from 1-100 take mid as 50 u will get to know whether number is lesser or greater then again find mid so on...
// we can chnage the no of changes to 5 in the code which makes difficult to guess  play upto u win ..
// All the best....
import java.util.Scanner;
class NumberGame {
    static void game(int randomNumber, int score,Scanner sc) {
        // System.out.println(randomNumber);
        int i = 0;
        for (i = 1; i <= 10; i++) {
           System.out.print("Enter Guess "+i+":");
           int guessedNumber = sc.nextInt();
           if(guessedNumber <= 100){
            if (guessedNumber == randomNumber) {
                if (i != 10) {
                    System.out.println("Congratulations! You Guessed The Number Correctly You Won the Game!");
                }
                score = 100 - (i - 1) * 10;
                System.out.println("Your score is :" + score);
                break;
            } else if (guessedNumber >= randomNumber) {
                if (i != 10) {
                    System.out.println("RandomNumber Is be LessThan The Entered number");
                }
            } else if (guessedNumber <= randomNumber) {
                if (i != 10) {
                    System.out.println("RandomNumber Is be GreaterThan The Entered number");
                }
            } else {
                System.out.println();
            }
           }
           else{
               System.out.println("Kindly Enter Between 1-100 Only.");
               i=0;
           }
          
        }
        if(i > 10){
    System.out.println("Shit! just Miss You Ran Out Of Attempt");
        System.out.println("Random number is: " + randomNumber);
        System.out.println("Your Score is:"+score);
        }
        
    }

    public static void main(String[] args) {
         System.out.println("Caution!");
        System.out.println("You have only 10 attempts to guess the number between 1-100: ");
        System.out.println("Your score is calculated based on number of attempts Highest Score Is 100 And Lowest IS 0.");
        System.out.println("Lets Start The Game...");
        Scanner sc = new Scanner(System.in);
           String response;
        do {
             int randomNumber = (int) (Math.random() * 100) + 1;
             int score = 0;
             game(randomNumber, score,sc);
            System.out.print("Do you want to play again? (yes/no): ");
            response = sc.next();
        } while (response.equalsIgnoreCase("yes"));
        System.out.println("Thank you for playing!");
        sc.close();
    }
}
