public class Player
{
  public String name;
  public int healthPoints;
  public Room position;
  public String race;
  
  public Player(String name)
  {
    this.name = name;
    this.healthPoints = 100;
  }
  
  
  //tells the players location each time he/she moves to a new room
  public void currentRoom(Room position)
  {
    this.position = position;
    System.out.println("You are currently in the " + this.position.name + ".");
    
    //creature/dragon attacks if there is one in room
    if (this.position.creature == true)
    {
      int lose = (int) ((Math.random() + 1) * 10);
      this.healthPoints -= lose;
      System.out.println("A creature just attacked you! You lost " + lose + " health points!");
    }
    
    else if (this.position.dragon == true)
    {
      int lose = (int) ((Math.random() + 1) * 20);
      this.healthPoints -= lose;
      System.out.println("The dragon just attacked you! You lost " + lose + " health points!");
    }
    
    //calls the troll's riddles method
    if (this.position.name.equals("vault"))
    {
      Maze.riddles();
    }
  }
  
  
}