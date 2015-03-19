public class Player
{
  public String name;
  public int healthPoints;
  public Room position;
  public String race;
  
  public Player(String name, String race)
  {
    this.name = name;
    this.race = race;
    this.healthPoints = 100;

  }
  
  public void currentRoom(Room position)
  {
    this.position = position;
  }
  
  
}