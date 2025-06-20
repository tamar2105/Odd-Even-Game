/**
 * This class represents the Odd-Even game
 * 
 * 
 */

import java.util.Scanner;
public class Game{

    // your instance variables here:
    private int oddTokens;
    private int evenTokens;
    private ComputerPlayer computerPlayer;
    private ComputerPlayer comp1;
    private ComputerPlayer comp2;
    private boolean again;
    private Scanner scanner;

    
/* this version of the game constructor is for Part 1
 * it takes no parameters */
    public Game(){
        computerPlayer = new ComputerPlayer(); 
        oddTokens=0;
        evenTokens= computerPlayer.getScore();
        again = true;
        scanner = new Scanner(System.in);
    }
    
/* this version of the game constructor is for Part 2
 * It requires two doubles as parameters. You will use 
 * these to set the initial thresholds for you computer players 
 */
    public Game (double t1, double t2){
        oddTokens = 0;
        evenTokens = 0;
        comp1 = new ComputerPlayer (t1);
        comp2 = new ComputerPlayer (t2);
        again = true;
    }
    
/* 
* This method is for Part 1
* This method should play one complete interactive session
* of odd-even until the user wishes to quit. 
*/
    public void playSession(){
        boolean isOddPlayer = choosePlayer();
        while (again){          
            //human choice
            System.out.println("Enter your choice (1 or 2):");
            int humanNumber = scanner.nextInt();
            scanner.nextLine();

            int computerNumber = computerPlayer.move();
            int sum = humanNumber + computerNumber;
            boolean isSumOdd= sum % 2 != 0;

            if (isSumOdd){
                oddTokens+=sum;
                evenTokens-=sum;
                System.out.println("P1 (odd) wins " + sum + " tokens!");
                System.out.println("P2 (even) looses " + sum + " tokens!");
            }
            else {
                oddTokens -=sum;
                evenTokens +=sum;
                System.out.println("P2 (even) wins " + sum + " tokens!");
                System.out.println("P1 (odd) looses " + sum + " tokens!");
            }
            computerScore(sum, isSumOdd, isOddPlayer);
            playAgain(isOddPlayer); // Check if the user wants to play again
            }
    }
    
    
/*
 * This method is for Part 2
 * It takes a single int as a parameter which is the
 * number of computer vs. computer games that should be played 
 */
    public void play(int games){
        for (int i=0; i<games; i++){ //play the game "games" amt of times
            int comp1Number = comp1.move();
            int comp2Number = comp2.move();
            int sum = comp1Number + comp2Number;

            if (sum %2 !=0){ //comp1 is always odd
                comp1.adjustScore(sum);
                oddTokens = comp1.getScore();
                comp2.adjustScore(-sum);
                evenTokens = comp2.getScore(); 
            }
            else{
                comp1.adjustScore(-sum);
                oddTokens = comp1.getScore();
                comp2.adjustScore(sum);
                evenTokens = comp2.getScore();
            }         
        }
    }

/* this method should return the current score (number of tokens)
 * that player 1 has */
    public int getP1Score(){
        return oddTokens;    
    }
    
/* this method should return the current score (number of tokens)
 * that player 2 has */
    public int getP2Score(){
        return evenTokens; 
    }  

    // the user will decide if they want the odd numbers or even
    public boolean choosePlayer(){ 
        System.out.println("Do you want to play as 'odd' or 'even'?");
        String choice = scanner.nextLine().toLowerCase();
        boolean isOddPlayer;
        if (choice.equals("odd")) 
            return true;  
        else 
            return false;        
    }

    public void computerScore(int sum, boolean isSumOdd, boolean isOddPlayer){
        if ((!isOddPlayer&&isSumOdd)||(isOddPlayer)&&(!isSumOdd)){
            computerPlayer.adjustScore(sum);
        }
        else{
            computerPlayer.adjustScore(-sum);
        } 
    }
  

    //the user decides if they want to play again
    public void playAgain(boolean isOddPlayer){
        System.out.println("Do you want to play again? (yes/no)");
        String input = scanner.nextLine().toLowerCase();
        if (input.equals("no")){
            again = false;
            System.out.println("Thanks for playing!");
            System.out.println(" Final scores:");
            
            if (isOddPlayer)
            {
                System.out.println("Player 1 (You): " +oddTokens + " tokens");
                System.out.println("Player 2 (Computer):" + 
                computerPlayer.getScore() + " tokens");     
            }
            else{
                System.out.println("Player 1 (Computer): " + 
                computerPlayer.getScore() + " tokens");
                System.out.println("Player 2 (You): " +evenTokens+ " tokens");                
            }
        }
    } 
    
    
}