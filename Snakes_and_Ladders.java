import java.util.*;

public class SnakesLadders {
  
  int[] board = new int[101];
  int playerTurn = 2;
  boolean gameWon = false;
  boolean lastWasNotDouble = true;
  
  HashMap<Integer,Integer> newPosition = new HashMap<Integer,Integer>();
  HashMap<Integer,Integer> playerPosition = new HashMap<Integer,Integer>();


  public SnakesLadders() {
    
    //ladders
    newPosition.put(2, 38);
    newPosition.put(7, 14);
    newPosition.put(8, 31);
    newPosition.put(15, 26);
    newPosition.put(21, 42);
    newPosition.put(28, 84);
    newPosition.put(36, 44);
    newPosition.put(51, 67);
    newPosition.put(78, 98);
    newPosition.put(71, 91);
    newPosition.put(87, 94);
                
    //snakes
    newPosition.put(16, 6);
    newPosition.put(46, 25);
    newPosition.put(49, 11);
    newPosition.put(62, 19);
    newPosition.put(64, 60);
    newPosition.put(74, 53);
    newPosition.put(89, 68);
    newPosition.put(92, 88);
    newPosition.put(95, 75);
    newPosition.put(99, 80);
    
    //player positions
    playerPosition.put(1, 0);
    playerPosition.put(2, 0);


  }


  public String play(int die1, int die2) {
    
      //if game is finished, show this message    
      if(gameWon){
        return "Game over!";
      }
    
      //if lasts dies wasn's double change the player
      if(lastWasNotDouble){
        playerTurn = playerTurn == 1 ? 2 : 1; 
      }
    
      //check for doubles dies and set boolean for next player will be same    
      if(die1 == die2){
        lastWasNotDouble = false;
      } else {
        lastWasNotDouble = true;
      }
    
      //check if current position plus dies is above 100 and calculate new position
      if((playerPosition.get(playerTurn) + die1 + die2) > 100){
        newPositionCalculator((100 - (playerPosition.get(playerTurn) + die1 + die2 - 100)));    
      } else {
        newPositionCalculator(playerPosition.get(playerTurn) + die1 + die2);
      }
    
      //check win condition
      if(playerPosition.get(playerTurn) == 100){
        gameWon = true;
        return "Player " + playerTurn + " Wins!";
      }
      
      //if player doesn't wins, show the current position
      return "Player " + playerTurn + " is on square " + playerPosition.get(playerTurn);
  }
  
  //check for ladder or snake
  public void newPositionCalculator (int position){
    
    if(newPosition.containsKey(position)){
      playerPosition.put(playerTurn, newPosition.get(position));
    } else {
      playerPosition.put(playerTurn, position);
    }
           
  }
    
}
