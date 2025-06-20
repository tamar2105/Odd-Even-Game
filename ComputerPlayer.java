/**
 * This class represents a computer
 * player in the Odd-Even game
 * 
 *  
 */

public class ComputerPlayer{
    private double t;
    private int tokenBalance; //ONLY PLACE YOU SHOULD TRACK COMPUTER TOKENS!
    
    /* no-argument constructor for the ComputerPlayer
       This is meant for Part 1 */
    public ComputerPlayer(){
        t=0.5;
        tokenBalance=0;
    }
    
    /* Speicfy the desired strategy in this constructor
       This is meant for Part 2 */
    public ComputerPlayer(double threshold){
        t=threshold; 
        tokenBalance=0;
    }
    
    public int move(){
        double random = Math.random();
        if (random < t) 
            return 1;   
        else
            return 2;   
    }

    public void adjustScore(int scoreChange){
        tokenBalance += scoreChange;
    }        
    
    public int getScore(){
        return tokenBalance;
    }
}
    
    

    