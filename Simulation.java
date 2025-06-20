/**
 * This class should run simulations to determine
 * whether or not the Odd-Even game is fair and if
 * not who has the advantage and what is a strategy
 * that will realize that advantage.
 * 
 * 
 */

public class Simulation{
    
    public static void main(String[] args){
        double winningThreshold = -1; //t1 that gives comp1 an advantage
        double maxMinimumCounter = -100000;
        double minimumCounter = 100000;

        for (double i=0; i<=1; i+=.1){
            minimumCounter = 100000;
            for (double j=0;j<=1; j+=.1){
                Game g = new Game(i, j);
                g.play(1000);
                int ScoreP1 = g.getP1Score();
                if (ScoreP1 <minimumCounter){
                    minimumCounter=ScoreP1;   
                } 
            }
            if (minimumCounter>maxMinimumCounter){
                maxMinimumCounter = minimumCounter;
                winningThreshold = i;
            } 
        } 
    System.out.println("Threshold "+winningThreshold+" 
    guarantees p1 will win");
    }
}