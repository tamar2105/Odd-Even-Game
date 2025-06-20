# Odd-Even-Game

The game allows a human player to compete interactively against a computer,
and simulates games between two computer players with adjustable strategies.

In the interactive game, I created a Game class with a no-argument
constructor that initializes the game and handles the interaction 
between the human player and the computer. The user is prompted 
to choose whether they want to play as "odd" or "even". The game 
then runs in a loop, where the player is asked to input either 1 or 2.
The computer’s move is randomly determined using a fixed threshold 
of 0.5 (there is a 50% chance it will choose "odd" or "even").
If the sum of the human player's choice + computer is odd, 
the odd player wins tokens, and if the sum is even, 
the even player wins tokens. After each round, the player is asked
if they want to play again, and the scores are displayed. The game 
continues until the player chooses to quit. 

In Part 2, each computer player has a threshold value, from 0.0 to 1.0,
which determines the likelihood of choosing "odd" (1) or "even" (2). 
A lower threshold increases the likelihood of choosing "odd", while a 
higher threshold increases the likelihood of choosing "even". I created
 a constructor in the Game class that accepts two threshold values 
(one for each computer player) to initialize their strategies. The game 
then simulates a specified number of rounds between the two computer players.
After each round, the scores for both players are updated based on the outcome
of the round—if the sum of their choices is odd, the first player wins, and 
if the sum is even, the second player wins. This simulation runs for a set 
number of games, and the final scores of both players 
are printed after the simulation concludes.

The game is unfair - if p1 has .6 threshold, against any p2 threshold, P1
is guaranteed a win.
